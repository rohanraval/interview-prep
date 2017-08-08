'''
Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes. 

SOLUTION:
Use BFS or DFS. Make a graph class using an adjacency list
'''

class Graph():
    def __init__(self):
        self.nodes = []

class Node():
    def __init__(self, data):
        