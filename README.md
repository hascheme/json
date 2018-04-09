# json
a simple, portable JSON librairy for Scheme

***The shortest code JSON Parser in history***

parse rules:

***json->list***

(json->list json) 

```
{key1: value1, key2: value2, key3: value3 ...}      =>     ((key1 . value2)(key2 . value2)(key3 . value3) ...)

[value1, value2, value3 ...]                        =>     #(value1 value2 value3 ...)
```

***list->json***

(list->json list)

(list->json vector)

```
((key1 . value2)(key2 . value2)(key3 . value3) ...)    =>    {key1: value1, key2: value2, key3: value3 ...}

#(value1 value2 value3 ...)                            =>    [value1, value2, value3 ...]
```

if you want more libert to vector, use:

***vector->array***

(vector->array vector)


```
#(value1 value2 value3 ...)        =>     ((0 . value2)(1 . value2)(2 . value2) ...) 
```

***array->vector***

key must be string.
value may be string, number or symbols: true, false or null.

```
when value is:     json-ref return:
true          =>      #t
false         =>      #f
null          =>      '()
```

***json->list***


> (display token1)

```
{"first":"1","second":"2","third":[3.1,[3.1,3.2,3.3,3.4,3.5],3.3,3.4,3.5],"fourth":"4"}
```
> (json->list token1)

```
(("first" . "1")
  ("second" . "2")
  ("third" . #(3.1 #(3.1 3.2 3.3 3.4 3.5) 3.3 3.4 3.5))
  ("fourth" . "4"))
```
> (display token2)

```
{"first":1,"second":"2","third":[3.1,{"first":1,"second":"2","third":[3.31,3.32,3.33,3.34,3.35],"fourth":"4"},3.3,3.4,3.5],"fourth":"4"}
```

> (json->list token2)

```
(("first" . 1)
  ("second" . "2")
  ("third"
    .
    #(3.1
      (("first" . 1)
        ("second" . "2")
        ("third" . #(3.31 3.32 3.33 3.34 3.35))
        ("fourth" . "4"))
      3.3 3.4 3.5))
  ("fourth" . "4"))
```

> (display token3)


```
[0.1,0.2,{"first":"1","second":"2","third":[3.1,{"first":1,"second":"2","third":[3.31,3.32,3.33,3.34,3.35],"fourth":"4"},3.3,3.4,3.5],"fourth":"4"},0.3]
```

> (json->list token3)


```
#(0.1 0.2
  (("first" . "1")
    ("second" . "2")
    ("third"
      .
      #(3.1
        (("first" . 1)
          ("second" . "2")
          ("third" . #(3.31 3.32 3.33 3.34 3.35))
          ("fourth" . "4"))
        3.3 3.4 3.5))
    ("fourth" . "4"))
  0.3)
```

***list->json***


> (json->list token1)

```
(("first" . "1")
  ("second" . "2")
  ("third" . #(3.1 #(3.1 3.2 3.3 3.4 3.5) 3.3 3.4 3.5))
  ("fourth" . "4"))
```

> (display (list->json (json->list token1)))

```
{"first":"1","second":"2","third":[3.1,[3.1,3.2,3.3,3.4,3.5],3.3,3.4,3.5],"fourth":"4"}
```

> (json->list token2)

```
(("first" . 1)
  ("second" . "2")
  ("third"
    .
    #(3.1
      (("first" . 1)
        ("second" . "2")
        ("third" . #(3.31 3.32 3.33 3.34 3.35))
        ("fourth" . "4"))
      3.3 3.4 3.5))
  ("fourth" . "4"))
```


> (display (list->json (json->list token2)))

```
{"first":1,"second":"2","third":[3.1,{"first":1,"second":"2","third":[3.31,3.32,3.33,3.34,3.35],"fourth":"4"},3.3,3.4,3.5],"fourth":"4"}
```

> (json->list token3)


```
#(0.1 0.2
  (("first" . "1")
    ("second" . "2")
    ("third"
      .
      #(3.1
        (("first" . 1)
          ("second" . "2")
          ("third" . #(3.31 3.32 3.33 3.34 3.35))
          ("fourth" . "4"))
        3.3 3.4 3.5))
    ("fourth" . "4"))
  0.3)
```

> (display (list->json (json->list token3)))

```
[0.1,0.2,{"first":"1","second":"2","third":[3.1,{"first":1,"second":"2","third":[3.31,3.32,3.33,3.34,3.35],"fourth":"4"},3.3,3.4,3.5],"fourth":"4"},0.3]
```

***json-ref***

> (display token3)

```
[0.1,0.2,{"first":"1","second":"2","third":[3.1,{"first":1,"second":"2","third":[3.31,3.32,3.33,3.34,3.35],"fourth":"4"},3.3,3.4,3.5],"fourth":"4"},0.3]
```

> (json-ref (json->list token3) 0)

```
0.1
```

> (json-ref (json->list token3) 1)

```
0.2
```

> (json-ref (json->list token3) 2 "first")

```
"1"
```

> (json-ref (json->list token3) 2 "third" 0)

```
3.1
```

> (json-ref (json->list token3) 2 "third" 1 "first")

```
1
```

> (json-ref (json->list token3) 2 "third" 1 "third" 0)

```
3.31
```

> (json-ref (json->list token3) 2 "third" 1 "third" 4)

```
3.35
```

