[![CircleCI](https://circleci.com/gh/springframeworkguru/spring5-webflux-rest/tree/master.svg?style=svg)](https://circleci.com/gh/springframeworkguru/spring5-webflux-rest/tree/master)
[![Github All Releases](https://img.shields.io/github/downloads/springframeworkguru/spring5-webflux-res/total.svg)](https://github.com/springframeworkguru/spring5-webflux-rest/archive/master.zip)
# Spring Framework 5 - RESTFul Interfaces with WebFlux

도커로 레디스를 기동 후, 사용. 도커 레디스 설치 명령어 : docker run --name myRedis -p 6379:6379 -d redis 
-p 포트 매핑 
-d 백그라운드에서 실행 
--name 컨테이너 이름 세팅

레디스 cli 접속 명령어 : docker run -it --link myRedis:redis --rm redis redis-cli -h redis -p 6379 

<레디스 명령어> 
keys *

hvals * 
hkeys *

type *

get * 
...