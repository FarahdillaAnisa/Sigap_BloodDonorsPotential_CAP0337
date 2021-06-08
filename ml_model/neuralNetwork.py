import time

import tensorflow_decision_forests as tfdf

import os
import numpy as np
import pandas as pd
import tensorflow as tf
from keras import Sequential
from keras.callbacks import ModelCheckpoint
from keras.layers import Dense, Activation
from tensorflow import lite
import math

from sklearn.model_selection import train_test_split
from keras.models import Sequential
from keras.layers import InputLayer
from keras.layers import Dense
from keras.layers import Dropout
from keras.constraints import maxnorm
from sklearn.ensemble import RandomForestClassifier, RandomForestRegressor
from sklearn.metrics import classification_report, confusion_matrix, accuracy_score


# Load a dataset into a Pandas Dataframe.
#from tensorflow_decision_forests.keras.keras_test import train_test_split
start_time = time.time()

dataset_df = pd.read_csv("/home/aizc/Downloads/transfusion.csv")
dataset_df.rename(columns={'whether he/she donated blood in March 2007':'donated in march'}, inplace=True)
# Display the first 3 examples.


print(dataset_df)

y = dataset_df['donated in march']
X = dataset_df.drop(['donated in march'], axis = 1)


X_train, X_test, y_train, y_test = train_test_split(X, y, test_size= 0.2, random_state= 42)


model = Sequential()
model.add(Dense(128, input_dim = [4], activation='relu'))
model.add(Dense(256, activation='relu'))
model.add(Dense(1, activation='sigmoid'))

model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])

model.fit(X_train, y_train, epochs=100, batch_size=8,validation_split = 0.2)

predictions = model.predict(X_test)
# round predictions
rounded = [round(x[0]) for x in predictions]
predictions = rounded
score = accuracy_score(y_test ,predictions)

print()
print("Accuracy: ",score)

print("--- %s seconds ---" % (time.time() - start_time))

#keras_file = "model.h5"
#tf.keras.models.save_model(model,keras_file)
#converter = lite.TFLiteConverter.from_keras_model(model)
#tfmodel = converter.convert()

#open("model.tflite","wb").write(tfmodel)