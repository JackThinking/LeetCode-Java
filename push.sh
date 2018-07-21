#!/usr/bin/env bash 

git add .
echo "add the change file to local reposit"
git commit -m "$1"
echo "commit the change to version reposit"
git push 
echo "finished !"