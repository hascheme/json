(define token1
    "{\"first\":\"1\",\"second\":\"2\",\"third\":[3.1,[3.1,3.2,3.3,3.4,3.5],3.3,3.4,3.5],\"fourth\":\"4\"}")
    
(define token2
    "{\"first\":1,\"second\":\"2\",\"third\":[3.1,{\"first\":1,\"second\":\"2\",\"third\":[3.31,3.32,3.33,3.34,3.35],\"fourth\":\"4\"},3.3,3.4,3.5],\"fourth\":\"4\"}")

(define token3
    "[0.1,0.2,{\"first\":\"1\",\"second\":\"2\",\"third\":[3.1,{\"first\":1,\"second\":\"2\",\"third\":[3.31,3.32,3.33,3.34,3.35],\"fourth\":\"4\"},3.3,3.4,3.5],\"fourth\":\"4\"},0.3]")
