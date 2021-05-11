from pymongo import MongoClient
import pandas as pd
import numpy as np
import pickle
from sklearn.metrics import confusion_matrix, classification_report

# 최대 출력 수 설정
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split, GridSearchCV, KFold

pd.set_option('display.max_row', 500)
pd.set_option('display.max_columns', 91)

connection = MongoClient('localhost', 27017)

# print(connection.list_database_names()) # 데이터베이스 목록 출력

db = connection.get_database('teama') # DB 선택
# print(db.list_collection_names()) # DB 내 collection 목록 출력

collection = db.get_collection('localizationStatic')

# result = collection.find({}, {'_id': 0}) # 원하는 데이터만 추출
# result = collection.find({'timestamp': 25}, {'_id': 0}) # 조건

# timestamp 범위 설정
# result = collection.find({"timestamp": {"$gt": 20, "$lt": 25}}) # timestamp 21-24구간 추출
# result = collection.find({"timestamp": {"$gte": 20, "$lte": 25}}) # timestamp 20-25구간 추출
# result = collection.find({"timestamp": {"$gte": 0, "$lte": 29}})
result = collection.find()

col = list(range(1, 91)) # 채널 수
# col.insert(0, "timestamp") # column list
col.insert(0, "label") # label 버전

csi_df = pd.DataFrame(columns=col)

for i in result:
    timestamp = i.get("timestamp")
    label = i.get("label")
    data = i.get("antenna_A")
    data.extend(i.get("antenna_B"))
    data.extend(i.get("antenna_C"))
    # data.insert(0, timestamp) # 타임스탬프도 리스트에 추가
    data.insert(0, label) # label 버전
    data = np.round(data, 4)
    csi_df = csi_df.append(pd.Series(data, index=csi_df.columns), ignore_index=True) # 데이터프레임 삽입

print(np.unique(csi_df['label']))

print(csi_df)

X = csi_df.drop(['label'], 1)
y = csi_df['label']

# print(X)
# print(y)

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.5, random_state=0)

parameter = {
'n_estimators': [100, 200],
'max_depth': [6, 8, 10, 12],
'min_samples_leaf': [3, 5, 7, 10],
'min_samples_split': [2, 3, 5, 10]}

rf = RandomForestClassifier(random_state=0)

kfold = KFold(10, shuffle=True)

# name = 'people_counting.asv'
name = 'localization.asv'
# name = 'localizationStatic.asv'
#
# rf_grid = GridSearchCV(rf, param_grid=parameter, scoring="accuracy", n_jobs=-1, cv=kfold)
# rf_grid.fit(X, y)
#
# # storage model
# pickle.dump(rf_grid, open(name,'wb'))
#
# prediction = rf_grid.predict(X_test)
# total_param = rf_grid.cv_results_['params']
# total_score = rf_grid.cv_results_["mean_test_score"]
#
# print('best parameter: ', rf_grid.best_params_)
# print('best score: %.2f' % rf_grid.best_score_)
# print(confusion_matrix(y_test, prediction))


# load model
load_model = pickle.load(open(name, 'rb'))
result = load_model.score(X_test, y_test)

prediction = load_model.best_estimator_.predict(X)
total_param = load_model.cv_results_['params']
total_score = load_model.cv_results_["mean_test_score"]

print('best parameter: ', load_model.best_params_)
print('best score: %.2f' % load_model.best_score_)


print('\n\n')
print('score : {}'.format(round(load_model.best_estimator_.score(X, y), 3)))
print(confusion_matrix(y, prediction))
print(classification_report(y, prediction))