#!/bin/bash

# https://phoenixnap.com/kb/docker-redis
sudo docker run --name redis -p 6379:6379 -d redis:latest