cmake_minimum_required(VERSION 3.20)
project(Algoritmer_och_datastrukturer C)

set(CMAKE_C_STANDARD 11)

add_executable(Algoritmer_och_datastrukturer
        out/production/Algoritmer-och-datastrukturer/Laboration1/Uppgift1/task1.c
        src/Laboration1/Uppgift1/task1.c
        src/Laboration2/Uppgift1/uppgift1.c
        src/Laboration2/Uppgift3/inPlace.c)
