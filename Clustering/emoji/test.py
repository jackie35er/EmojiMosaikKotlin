import sys

import matplotlib
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.image as img
from sklearn.cluster import KMeans
from collections import Counter


def main():
    img_arr = img.imread('airplane.png')
    print(img_arr.shape)
    plt.imshow(img_arr)

    (h, w, c) = img_arr.shape
    img2D = img_arr.reshape(h * w, c)

    func = np.vectorize(rgba2rgb)
    img2D = func(img2D)
    print(np.asarray(img2D).shape)
    img2D = img2D[(img2D != [0, 0, 0, 0]).any(axis=1)]
    print(img2D)
    img2D = np.delete(np.asarray(img2D), np.arange(3,np.asarray(img2D).size, 4)).reshape((-1,3))
    print(img2D)

    kmeans_model = KMeans(n_clusters=3)
    cluster_labels = kmeans_model.fit_predict(img2D)
    labels_count = Counter(cluster_labels)
    print(labels_count)
    print(kmeans_model.cluster_centers_)
    rgb_cols = kmeans_model.cluster_centers_.round(0).astype(int)
    print(rgb_cols)


def rgba2rgb(pixel):
    return int(pixel * 255)


main()
