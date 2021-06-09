import time

import pandas as pd
import numpy as np
import tensorflow as tf
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split
from keras.models import Sequential
from keras.layers import InputLayer
from keras.layers import Dense

start_time = time.time()

dataset_df = pd.read_csv("/home/aizc/Downloads/transfusion.csv")
dataset_df.rename(columns={'whether he/she donated blood in March 2007':'donated in march'}, inplace=True)
# Display the first 3 examples.

# fill missing values with 0
dataset_df.fillna(0)

print(dataset_df)

y = dataset_df['donated in march']
X = dataset_df.drop(['donated in march'], axis = 1)

model = Sequential()
model.add(Dense(60, input_dim=4, activation='relu'))
model.add(Dense(1, activation='sigmoid'))
# Compile model
model.compile(loss='binary_crossentropy', optimizer='adam', metrics=['accuracy'])

model.fit(X, y, epochs=100, batch_size=8)

print(model.summary())

print("--- %s seconds ---" % (time.time() - start_time))

from tensorflow import lite
converter = lite.TFLiteConverter.from_keras_model(model)

tfmodel = converter.convert()

open('test.tflite', 'wb').write(tfmodel)

