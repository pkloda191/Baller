package com.example.baller;

public class LinkedList
{
    private Node head;
    private int count;

    public LinkedList()
    {
        this.head = null;
        this.count = 0;

    }

    public void addFront(int value)
    {
        Node n = new Node(value);
        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            n.setNextNode(head);
            head = n;
        }
        count++;
    }

    public void addLast(int value)
    {
        Node last = head;
        while(last.nextNode != null)
        {
            last = last.nextNode;
        }
        last.nextNode = new Node(value);
        count++;
    }

    public void display()
    {
        String answer = "******* ";
        Node currNode = head;
        for(int i = 0; i < this.count; i++)
        {
            answer = answer + currNode.getPayload() + " -> ";
            currNode = currNode.getNextNode();
        }
        System.out.println(answer);
    }
}