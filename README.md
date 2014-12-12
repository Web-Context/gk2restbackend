gk2restbackend
==============

## Introduction

A simple project to provide entity rest access on a MongoDB database for a sample project
providing Video Games informations.

## Architecture

this project rely on a 3 tiers architecture:

* Front-End based on AngularJS, HTML5 and CSS3,
* Back-End implementing a JAva REST service with a Jax-RS
* A database NoSQL document oriented implemented with a MongoDB server.

### A small schema

    +------------+     +-------------+     +---------------+
    | FrontEnd   |     |   BackEnd   |     |   Database    |
    | AngularJS  |<===>|   Jax-RS    |<===>|   Document    |
    | HTML5/CSS3 |     |             |     | NoSQL MongoDB |
    +------------+     +-------------+     +---------------+


## A personal touch

The Documents used here are <code>Game</code> describing a video game.   

## Unit Test

todo

## REST tests

todo

McG.
Web-Context