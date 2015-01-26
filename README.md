FastIoC
=======
This IoC container aim to fast and simple purpose base on ConcurrentHashMap. It's also support type check
Performance compare
=======
I reuse and modify test scenario from this article http://java.dzone.com/articles/java-7-hashmap-vs (thank Pierre-Hugues Charbonneau for this useful article).

At glance, I create some concurrent thread to get object from each container (number of thread is from 1 to 50), each scenario run 5 times and I use average data for comparing. You can see FastIoC spend less time than Guice. At average, FastIoC spend 0.001544 second, Guice spend 0.00264 second.
<img src="http://www.codeproject.com/KB/java/868625/performance_compare.png">
