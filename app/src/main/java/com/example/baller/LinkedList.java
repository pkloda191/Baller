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

    public int removeEnd()
    {
        Node currNode = this.head;
        while(currNode.getNextNode() != null)
        {
            currNode = currNode.getNextNode();
        }

        currNode.setNextNode(null);
        this.count--;
        return currNode.getPayload();
    }

    public void removeAtIndex(int index)
    {
        if (index == 0)
        {
            this.removeFront();
        }
        else if (this.count == index)
        {
            this.removeEnd();
        }
        else
            {
            Node currNode = this.head;
            for (int i = 0; i < index - 1; i++)
            {
                currNode = currNode.getNextNode(); //stop one before the index
            }
            Node n = currNode.getNextNode(); //get the index
            Node aheadofN = n.getNextNode(); //progress one past the index
            currNode.setNextNode(aheadofN); //point from before index to after index
            this.count--;
        }
    }

    public int removeFront()
    {
        Node currNode = this.head;
        this.head = this.head.getNextNode();
        currNode.setNextNode(null);
        this.count--;
        return currNode.getPayload();
    }

    public int getAtIndex(int index)
    {
        Node currNode = this.head;
        for(int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }

    public void addAtIndex(int value, int index)
    {
        if(index == 0)
        {
            this.addFront(value);
        }
        else if(this.count == index)//how do I ask if they want to add to the end?
        {
            this.addEnd(value);
        }
        else
        {
            //we want to add in the middle somewhere
            //we need to run up to the node right before the location we are setting new node
            Node currNode = this.head;
            for(int i = 0; i < index - 1; i++)
            {
                currNode = currNode.getNextNode();
            }
            Node n = new Node(value);
            n.setNextNode(currNode.getNextNode());
            currNode.setNextNode(n);
            this.count++;
        }
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

    public void addEnd(int value)
    {
        if(this.head == null)
        {
            this.addFront(value);
        }
        else
        {
            Node currNode = this.head;
            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }

            Node n = new Node(value);
            currNode.setNextNode(n);
            this.count++;
        }
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