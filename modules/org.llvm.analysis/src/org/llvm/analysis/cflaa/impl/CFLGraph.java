/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.analysis.cflaa.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import static org.llvm.analysis.cflaa.impl.CflaaStatics.NumAliasAttrs;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// \brief The Program Expression Graph (PEG) of CFL analysis
/// CFLGraph is auxiliary data structure used by CFL-based alias analysis to
/// describe flow-insensitive pointer-related behaviors. Given an LLVM function,
/// the main purpose of this graph is to abstract away unrelated facts and
/// translate the rest into a form that can be easily digested by CFL analyses.
/// Each Node in the graph is an InstantiatedValue, and each edge represent a
/// pointer assignment between InstantiatedValue. Pointer
/// references/dereferences are not explicitly stored in the graph: we
/// implicitly assume that for each node (X, I) it has a dereference edge to (X,
/// I+1) and a reference edge to (X, I-1).
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 37,
 FQN="llvm::cflaa::CFLGraph", NM="_ZN4llvm5cflaa8CFLGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraphE")
//</editor-fold>
public class CFLGraph implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef InstantiatedValue Node
//  public final class Node extends InstantiatedValue{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::Edge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 41,
   FQN="llvm::cflaa::CFLGraph::Edge", NM="_ZN4llvm5cflaa8CFLGraph4EdgeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph4EdgeE")
  //</editor-fold>
  public static class/*struct*/ Edge {
    public InstantiatedValue Other;
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::Edge::Edge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 41,
     FQN="llvm::cflaa::CFLGraph::Edge::Edge", NM="_ZN4llvm5cflaa8CFLGraph4EdgeC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph4EdgeC1EOS2_")
    //</editor-fold>
    public /*inline*/ Edge(JD$Move _dparam, final Edge /*&&*/$Prm0) {
      // : Other(static_cast<Edge &&>().Other) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Other=" + Other; // NOI18N
    }
  };
  
  // JAVA: typedef std::vector<Edge> EdgeList
//  public final class EdgeList extends std.vector<Edge>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::NodeInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 47,
   FQN="llvm::cflaa::CFLGraph::NodeInfo", NM="_ZN4llvm5cflaa8CFLGraph8NodeInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph8NodeInfoE")
  //</editor-fold>
  public static class/*struct*/ NodeInfo implements Destructors.ClassWithDestructor {
    public std.vector<Edge> Edges;
    public std.vector<Edge> ReverseEdges;
    public std.bitset/*NumAliasAttrs*/ Attr;
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::NodeInfo::NodeInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 47,
     FQN="llvm::cflaa::CFLGraph::NodeInfo::NodeInfo", NM="_ZN4llvm5cflaa8CFLGraph8NodeInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph8NodeInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ NodeInfo(JD$Move _dparam, final NodeInfo /*&&*/$Prm0) {
      // : Edges(static_cast<NodeInfo &&>().Edges), ReverseEdges(static_cast<NodeInfo &&>().ReverseEdges), Attr(static_cast<NodeInfo &&>().Attr) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::NodeInfo::~NodeInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 47,
     FQN="llvm::cflaa::CFLGraph::NodeInfo::~NodeInfo", NM="_ZN4llvm5cflaa8CFLGraph8NodeInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph8NodeInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::NodeInfo::NodeInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 47,
     FQN="llvm::cflaa::CFLGraph::NodeInfo::NodeInfo", NM="_ZN4llvm5cflaa8CFLGraph8NodeInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph8NodeInfoC1Ev")
    //</editor-fold>
    public /*inline*/ NodeInfo() {
      // : Edges(), ReverseEdges(), Attr() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Edges=" + Edges // NOI18N
                + ", ReverseEdges=" + ReverseEdges // NOI18N
                + ", Attr=" + Attr; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::ValueInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 52,
   FQN="llvm::cflaa::CFLGraph::ValueInfo", NM="_ZN4llvm5cflaa8CFLGraph9ValueInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph9ValueInfoE")
  //</editor-fold>
  public static class ValueInfo implements Destructors.ClassWithDestructor {
    private std.vector<NodeInfo> Levels;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::ValueInfo::addNodeToLevel">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 56,
     FQN="llvm::cflaa::CFLGraph::ValueInfo::addNodeToLevel", NM="_ZN4llvm5cflaa8CFLGraph9ValueInfo14addNodeToLevelEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph9ValueInfo14addNodeToLevelEj")
    //</editor-fold>
    public boolean addNodeToLevel(/*uint*/int Level) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::ValueInfo::getNodeInfoAtLevel">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 64,
     FQN="llvm::cflaa::CFLGraph::ValueInfo::getNodeInfoAtLevel", NM="_ZN4llvm5cflaa8CFLGraph9ValueInfo18getNodeInfoAtLevelEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph9ValueInfo18getNodeInfoAtLevelEj")
    //</editor-fold>
    public NodeInfo /*&*/ getNodeInfoAtLevel(/*uint*/int Level) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::ValueInfo::getNodeInfoAtLevel">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 68,
     FQN="llvm::cflaa::CFLGraph::ValueInfo::getNodeInfoAtLevel", NM="_ZNK4llvm5cflaa8CFLGraph9ValueInfo18getNodeInfoAtLevelEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa8CFLGraph9ValueInfo18getNodeInfoAtLevelEj")
    //</editor-fold>
    public /*const*/ NodeInfo /*&*/ getNodeInfoAtLevel$Const(/*uint*/int Level) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::ValueInfo::getNumLevels">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 73,
     FQN="llvm::cflaa::CFLGraph::ValueInfo::getNumLevels", NM="_ZNK4llvm5cflaa8CFLGraph9ValueInfo12getNumLevelsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa8CFLGraph9ValueInfo12getNumLevelsEv")
    //</editor-fold>
    public /*uint*/int getNumLevels() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::ValueInfo::ValueInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 52,
     FQN="llvm::cflaa::CFLGraph::ValueInfo::ValueInfo", NM="_ZN4llvm5cflaa8CFLGraph9ValueInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph9ValueInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ ValueInfo(JD$Move _dparam, final ValueInfo /*&&*/$Prm0) {
      // : Levels(static_cast<ValueInfo &&>().Levels) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::ValueInfo::~ValueInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 52,
     FQN="llvm::cflaa::CFLGraph::ValueInfo::~ValueInfo", NM="_ZN4llvm5cflaa8CFLGraph9ValueInfoD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph9ValueInfoD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::ValueInfo::ValueInfo">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 52,
     FQN="llvm::cflaa::CFLGraph::ValueInfo::ValueInfo", NM="_ZN4llvm5cflaa8CFLGraph9ValueInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph9ValueInfoC1Ev")
    //</editor-fold>
    public /*inline*/ ValueInfo() {
      // : Levels() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Levels=" + Levels; // NOI18N
    }
  };
/*private:*/
  // JAVA: typedef DenseMap<Value *, ValueInfo> ValueMap
//  public final class ValueMap extends DenseMap<Value /*P*/ , ValueInfo>{ };
  private DenseMap<Value /*P*/ , ValueInfo> ValueImpls;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::getNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 80,
   FQN="llvm::cflaa::CFLGraph::getNode", NM="_ZN4llvm5cflaa8CFLGraph7getNodeENS0_17InstantiatedValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph7getNodeENS0_17InstantiatedValueE")
  //</editor-fold>
  private NodeInfo /*P*/ getNode(InstantiatedValue N) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  // JAVA: typedef ValueMap::const_iterator const_value_iterator
//  public final class const_value_iterator extends DenseMapIterator<Value /*P*/ , ValueInfo>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::addNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 90,
   FQN="llvm::cflaa::CFLGraph::addNode", NM="_ZN4llvm5cflaa8CFLGraph7addNodeENS0_17InstantiatedValueESt6bitsetILj32EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph7addNodeENS0_17InstantiatedValueESt6bitsetILj32EE")
  //</editor-fold>
  public boolean addNode(InstantiatedValue N) {
    return addNode(N, new std.bitset/*NumAliasAttrs*/(NumAliasAttrs));
  }
  public boolean addNode(InstantiatedValue N, std.bitset/*NumAliasAttrs*/ Attr/*= std.AliasAttrs()*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::addAttr">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 98,
   FQN="llvm::cflaa::CFLGraph::addAttr", NM="_ZN4llvm5cflaa8CFLGraph7addAttrENS0_17InstantiatedValueESt6bitsetILj32EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph7addAttrENS0_17InstantiatedValueESt6bitsetILj32EE")
  //</editor-fold>
  public void addAttr(InstantiatedValue N, std.bitset/*NumAliasAttrs*/ Attr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::addEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 104,
   FQN="llvm::cflaa::CFLGraph::addEdge", NM="_ZN4llvm5cflaa8CFLGraph7addEdgeENS0_17InstantiatedValueES2_x",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraph7addEdgeENS0_17InstantiatedValueES2_x")
  //</editor-fold>
  public void addEdge(InstantiatedValue From, InstantiatedValue To) {
    addEdge(From, To, 0);
  }
  public void addEdge(InstantiatedValue From, InstantiatedValue To, long/*int64_t*/ Offset/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::getNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 114,
   FQN="llvm::cflaa::CFLGraph::getNode", NM="_ZNK4llvm5cflaa8CFLGraph7getNodeENS0_17InstantiatedValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa8CFLGraph7getNodeENS0_17InstantiatedValueE")
  //</editor-fold>
  public /*const*/ NodeInfo /*P*/ getNode$Const(InstantiatedValue N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::attrFor">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 121,
   FQN="llvm::cflaa::CFLGraph::attrFor", NM="_ZNK4llvm5cflaa8CFLGraph7attrForENS0_17InstantiatedValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa8CFLGraph7attrForENS0_17InstantiatedValueE")
  //</editor-fold>
  public std.bitset/*NumAliasAttrs*/ attrFor(InstantiatedValue N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::value_mappings">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 127,
   FQN="llvm::cflaa::CFLGraph::value_mappings", NM="_ZNK4llvm5cflaa8CFLGraph14value_mappingsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa8CFLGraph14value_mappingsEv")
  //</editor-fold>
  public iterator_range</*constconst*/std.pair<Value /*P*/ , ValueInfo> /*&*/> value_mappings() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::~CFLGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 37,
   FQN="llvm::cflaa::CFLGraph::~CFLGraph", NM="_ZN4llvm5cflaa8CFLGraphD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraphD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::CFLGraph::CFLGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLGraph.h", line = 37,
   FQN="llvm::cflaa::CFLGraph::CFLGraph", NM="_ZN4llvm5cflaa8CFLGraphC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm5cflaa8CFLGraphC1Ev")
  //</editor-fold>
  public /*inline*/ CFLGraph() {
    // : ValueImpls() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "ValueImpls=" + ValueImpls; // NOI18N
  }
}
