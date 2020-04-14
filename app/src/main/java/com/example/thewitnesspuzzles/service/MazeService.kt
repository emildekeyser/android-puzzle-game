package com.example.thewitnesspuzzles.service

import com.example.thewitnesspuzzles.model.Line
import com.example.thewitnesspuzzles.model.Maze
import com.example.thewitnesspuzzles.model.Node
import com.example.thewitnesspuzzles.model.NodeType
import java.io.Serializable

class MazeService: Serializable {
    val start = Node(0, 0, NodeType.START)
    val end = Node(1, 0, NodeType.END)
    val line = Line(start, end)
    var maze = Maze(0, setOf(line))

    fun setMaze(x: Int) {
        if (x == 1) {
            println("maze 1 set")
            val start = Node(0, 0, NodeType.START)
            val end = Node(1, 0, NodeType.END)
            val line = Line(start, end)
            maze = Maze(0, setOf(line))
        }
        if (x == 2) {
            println("maze 2 set")
            val start = Node(0, 0, NodeType.START)
            val middle = Node(1, 0, NodeType.MIDDLE)
            val end = Node(2, 0, NodeType.END)
            val line1 = Line(start, middle)
            val line2 = Line(middle, end)
            maze = Maze(0, setOf(line1, line2))
        }
        if (x == 3) {
            println("maze 3 set")
            val start = Node(0, 0, NodeType.START)
            val middle = Node(0, 1, NodeType.MIDDLE)
            val end = Node(1, 1, NodeType.END)
            val line1 = Line(start, middle)
            val line2 = Line(middle, end)
            maze = Maze(0, setOf(line1, line2))
        }
        if (x==4) {
            val start = Node(0,3,NodeType.START)
            val einde = Node(3,0,NodeType.END)
            val a = Node(1,3,NodeType.MIDDLE)
            val b = Node(3,3,NodeType.MIDDLE)
            val c = Node(0,2,NodeType.MIDDLE)
            val d = Node(1,2,NodeType.MIDDLE)
            val e = Node(2,2,NodeType.MIDDLE)
            val f = Node(3,2,NodeType.MIDDLE)
            val g = Node(0,1,NodeType.MIDDLE)
            val h = Node(1,1,NodeType.MIDDLE)
            val i = Node(2,1,NodeType.MIDDLE)
            val j = Node(1,0,NodeType.MIDDLE)
            val k = Node(2,0,NodeType.MIDDLE)
            val linea = Line(start,a)
            val lineb = Line(a,b)
            val linec = Line(start,c)
            val lined = Line(a,d)
            val linee = Line(b,f)
            val linef = Line(c,d)
            val lineg = Line(d,e)
            val lineh = Line(e,f)
            val linei = Line(c,g)
            val linej = Line(d,h)
            val linek = Line(e,i)
            val linel = Line(f,einde)
            val linem = Line(g,h)
            val linen = Line(h,i)
            val lineo = Line(h,j)
            val linep = Line(i,k)
            val lineq = Line(k, einde)
            maze = Maze(0, setOf(linea,lineb,linec,lined,linee,linef,lineg,lineh,linei,linej,linek,linel,linem,linen,lineo,linep,lineq))
        }
        if (x==5) {
            val start = Node(0, 0, NodeType.START)
            val einde = Node(4, 4, NodeType.END)
            val na = Node(1,0,NodeType.MIDDLE)
            val nb = Node(2,0,NodeType.MIDDLE)
            val nc = Node(3,0,NodeType.MIDDLE)
            val nd = Node(4,0,NodeType.MIDDLE)
            val ne = Node(0,1,NodeType.MIDDLE)
            val nf = Node(1,1,NodeType.MIDDLE)
            val ng = Node(2,1,NodeType.MIDDLE)
            val nh = Node(3,1,NodeType.MIDDLE)
            val ni = Node(4,1,NodeType.MIDDLE)
            val nj = Node(0,2,NodeType.MIDDLE)
            val nk = Node(1,2,NodeType.MIDDLE)
            val nl = Node(2,2,NodeType.MIDDLE)
            val nm = Node(3,2,NodeType.MIDDLE)
            val nn = Node(0,3,NodeType.MIDDLE)
            val no = Node(1,3,NodeType.MIDDLE)
            val np = Node(2,3,NodeType.MIDDLE)
            val nq = Node(3,3,NodeType.MIDDLE)
            val nr = Node(4,3,NodeType.MIDDLE)
            val ns = Node(0,4,NodeType.MIDDLE)
            val a = Line(start,na)
            val b = Line(nb,nc)
            val c = Line(nc,nd)
            val d = Line(na,nf)
            val e = Line(nb,ng)
            val f = Line(nc,nh)
            val g = Line(nf,ng)
            val h = Line(ng,nh)
            val i = Line(nh,ni)
            val j = Line(ne,nj)
            val k = Line(ng,nl)
            val l = Line(ni,nr)
            val m = Line(nk,no)
            val n = Line(nl,nf)
            val o = Line(nm,nq)
            val p = Line(nn,no)
            val q = Line(nf,nq)
            val r = Line(nn,ns)
            val s = Line(ns,einde)
            maze = Maze(0,setOf(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s))











        }
    }

    // kan de functie niet getMaze noemen? geeft een conflict ergens in het domain?
    fun getServiceMaze(): Maze {
        return maze;
    }

}