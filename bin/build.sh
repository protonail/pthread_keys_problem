#!/bin/sh

export ROOT_HOME=$(cd `dirname "$0"` && cd .. && pwd)
export GOPATH=$ROOT_HOME/go

go build -o $ROOT_HOME/src/main/resources/darwin/libpthread_keys_problem.dylib -buildmode=c-shared protonail.com/pthread_keys_problem