cmake_minimum_required(VERSION 3.22.1)
project("svgv_engine")

add_library(svgv_engine SHARED 
    svgv_engine.cpp
)

find_library(log-lib log)

target_link_libraries(svgv_engine ${log-lib})
