# Deutsche Bank Coding Assignment

This is my submission for the given assigment.

### Steps in my development phase :
* Created a spring boot base project with necessary dependencies
* Added a rest controller reacting to a POST call with path
  `/execute/${signal}` where signal is the value of signal we want to execute steps for
* Defined steps for each given signal in terms of enum values which
  would help to figure out which method to call at each step.
* Added comments under each function to make other developers understand it better.
* Lastly added some tests to ensure no one break things


### Why this approach?
* As it was mentioned that they would add 5 new signals each month and since it's not a
very big number even for the coming 100 months, we can keep the steps in a config file.
I've named the config specifically for signals in the signals.yaml
* signals.yaml can have 10000s of signals and it's only going to be read once, at the start
of the app, so it's cheaper.

### Future improvements
* We can keep the same format and store them in a No-SQL DB and read them at once, 
keep it in-memory or outside cache depending upon the number of signals finally we end up with.
* If it's in billions, we have to shard the DB and cache based on the range of numbers for signals
example - 1 - 1000000 in Part 1, 1000001 - 2000000 in Part 2 and so on
* In that case, we have to keep fetching the asked signal on demand as we won't be able to hold them
in memory, but we can create a cache based on signal number and keep a specific size following dequeue 
approaches like LRU

