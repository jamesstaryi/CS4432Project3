James Yi - 663227861

Section I:
    (in console)
    javac Main.java
    java Main
    Use one of the following commands after (has to be exact)
        SELECT count(*)  FROM  A, B WHERE A.RandomV > B.RandomV
        SELECT A.Col1, A.Col2, B.Col1, B.Col2  FROM  A, B WHERE A.RandomV = B.RandomV
        QUIT (To exit the program)

Section II:
    From what I can tell everything works correctly.
    The time taken for the hash join factors in print time which I wasn't sure should be included or not.
    Additionally, in the hash join I did not sort the records in the buckets.