FastIoC
=======
This IoC container aim to fast and simple perpose. It's also support type check
Performance compare
=======
I try to compare this container with Google Guice. Although Guice support a lot of features, but FastIoC aim to be fast. So that I just compare performance of 2 container. I run unit test of each container separate, and using Maven test (I think it more stable than Eclipse + JUnit)

round  | Guice	|  FastIoC
-------|--------|---------
1       |6.1	|  4.858
2       |6.28	|  4.918
3       |6.196	|  4.986
4       |6.572	|  4.962
5       |6.236	|  5.06
6       | 6.245	|  4.725
avg     |6.272  | 4.918

You can check the result by your self

I get test idea from this link http://www.christianschenk.org/blog/comparison-between-guice-picocontainer-and-spring/
