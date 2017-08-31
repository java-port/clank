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

package org.clang.analysis;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.support.*;
import org.clang.analysis.impl.*;
import static org.clang.analysis.impl.CFGStatics.*;
import static org.clang.analysis.CFGBlock.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;


/// CFGBlock - Represents a single basic block in a source-level CFG.
///  It consists of:
///
///  (1) A set of statements/expressions (which may contain subexpressions).
///  (2) A "terminator" statement (not in the set of statements).
///  (3) A list of successors and predecessors.
///
/// Terminator: The terminator represents the type of control-flow that occurs
/// at the end of the basic block.  The terminator is a Stmt* referring to an
/// AST node that has control-flow: if-statements, breaks, loops, etc.
/// If the control-flow is conditional, the condition expression will appear
/// within the set of statements in the block (usually the last statement).
///
/// Predecessors: the order in the set of predecessors is arbitrary.
///
/// Successors: the order in the set of successors is NOT arbitrary.  We
///  currently have the following orderings based on the terminator:
///
///     Terminator       Successor Ordering
///  -----------------------------------------------------
///       if            Then Block;  Else Block
///     ? operator      LHS expression;  RHS expression
///     &&, ||          expression that uses result of && or ||, RHS
///
/// But note that any of that may be NULL in case of optimized-out edges.
///
//<editor-fold defaultstate="collapsed" desc="clang::CFGBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 353,
 FQN="clang::CFGBlock", NM="_ZN5clang8CFGBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlockE")
//</editor-fold>
public class CFGBlock implements Iterable<CFGElement /*P*/>, NativeReverseIterable<type$ptr<CFGElement>>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 354,
   FQN="clang::CFGBlock::ElementList", NM="_ZN5clang8CFGBlock11ElementListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementListE")
  //</editor-fold>
  private static class ElementList implements Destructors.ClassWithDestructor {
    /*typedef BumpVector<CFGElement> ImplTy*/
//    public final class ImplTy extends BumpVector<CFGElement>{ };
    private BumpVector<CFGElement> Impl;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::ElementList">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 358,
     FQN="clang::CFGBlock::ElementList::ElementList", NM="_ZN5clang8CFGBlock11ElementListC1ERNS_17BumpVectorContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementListC1ERNS_17BumpVectorContextE")
    //</editor-fold>
    public ElementList(final BumpVectorContext /*&*/ C) {
      // : Impl(C, 4) 
      //START JInit
      this.Impl = new BumpVector<CFGElement>(
              new BumpVector.TypeAllocator<CFGElement>(
                (int size)->{return new CFGElement[size];}, 
                (CFGElement element)->{return new CFGElement(element);}),
              C, 4);
      //END JInit
    }

    
    /*typedef std::reverse_iterator<ImplTy::iterator> iterator*/
//    public final class iterator extends std.reverse_iterator<CFGElement>{ };
    /*typedef std::reverse_iterator<ImplTy::const_iterator> const_iterator*/
//    public final class const_iterator extends std.reverse_iterator</*const*/ CFGElement>{ };
    /*typedef ImplTy::iterator reverse_iterator*/
//    public final class reverse_iterator extends type$ptr<CFGElement /*P*/ >{ };
    /*typedef ImplTy::const_iterator const_reverse_iterator*/
//    public final class const_reverse_iterator extends type$ptr</*const*/ CFGElement /*P*/ >{ };
    /*typedef ImplTy::const_reference const_reference*/
//    public final class const_reference extends /*const*/ CFGElement /*&*/ { };
    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::push_back">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 366,
     FQN="clang::CFGBlock::ElementList::push_back", NM="_ZN5clang8CFGBlock11ElementList9push_backENS_10CFGElementERNS_17BumpVectorContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementList9push_backENS_10CFGElementERNS_17BumpVectorContextE")
    //</editor-fold>
    public void push_back(CFGElement e, final BumpVectorContext /*&*/ C) {
      Impl.push_back(e, C);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::insert">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 367,
     FQN="clang::CFGBlock::ElementList::insert", NM="_ZN5clang8CFGBlock11ElementList6insertEPNS_10CFGElementEjS2_RNS_17BumpVectorContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementList6insertEPNS_10CFGElementEjS2_RNS_17BumpVectorContextE")
    //</editor-fold>
    public type$ptr<CFGElement /*P*/ > insert(type$ptr<CFGElement /*P*/ > I, /*size_t*/int Cnt, CFGElement E, 
          final BumpVectorContext /*&*/ C) {
      return Impl.insert(I, Cnt, E, C);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::front">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 372,
     FQN="clang::CFGBlock::ElementList::front", NM="_ZNK5clang8CFGBlock11ElementList5frontEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementList5frontEv")
    //</editor-fold>
    public /*const*/ CFGElement /*&*/ front() /*const*/ {
      return Impl.back$Const();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::back">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 373,
     FQN="clang::CFGBlock::ElementList::back", NM="_ZNK5clang8CFGBlock11ElementList4backEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementList4backEv")
    //</editor-fold>
    public /*const*/ CFGElement /*&*/ back() /*const*/ {
      return Impl.front$Const();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::begin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 375,
     FQN="clang::CFGBlock::ElementList::begin", NM="_ZN5clang8CFGBlock11ElementList5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementList5beginEv")
    //</editor-fold>
    public std.reverse_iterator<CFGElement> begin() {
      return Impl.rbegin();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::end">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 376,
     FQN="clang::CFGBlock::ElementList::end", NM="_ZN5clang8CFGBlock11ElementList3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementList3endEv")
    //</editor-fold>
    public std.reverse_iterator<CFGElement> end() {
      return Impl.rend();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::begin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 377,
     FQN="clang::CFGBlock::ElementList::begin", NM="_ZNK5clang8CFGBlock11ElementList5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementList5beginEv")
    //</editor-fold>
    public std.reverse_iterator</*const*/ CFGElement> begin$Const() /*const*/ {
      return Impl.rbegin$Const();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::end">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 378,
     FQN="clang::CFGBlock::ElementList::end", NM="_ZNK5clang8CFGBlock11ElementList3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementList3endEv")
    //</editor-fold>
    public std.reverse_iterator</*const*/ CFGElement> end$Const() /*const*/ {
      return Impl.rend$Const();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::rbegin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 379,
     FQN="clang::CFGBlock::ElementList::rbegin", NM="_ZN5clang8CFGBlock11ElementList6rbeginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementList6rbeginEv")
    //</editor-fold>
    public type$ptr<CFGElement /*P*/ > rbegin() {
      return Impl.begin();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::rend">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 380,
     FQN="clang::CFGBlock::ElementList::rend", NM="_ZN5clang8CFGBlock11ElementList4rendEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementList4rendEv")
    //</editor-fold>
    public type$ptr<CFGElement /*P*/ > rend() {
      return Impl.end();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::rbegin">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 381,
     FQN="clang::CFGBlock::ElementList::rbegin", NM="_ZNK5clang8CFGBlock11ElementList6rbeginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementList6rbeginEv")
    //</editor-fold>
    public type$ptr</*const*/ CFGElement /*P*/ > rbegin$Const() /*const*/ {
      return Impl.begin$Const();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::rend">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 382,
     FQN="clang::CFGBlock::ElementList::rend", NM="_ZNK5clang8CFGBlock11ElementList4rendEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementList4rendEv")
    //</editor-fold>
    public type$ptr</*const*/ CFGElement /*P*/ > rend$Const() /*const*/ {
      return Impl.end$Const();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::operator[]">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 384,
     FQN="clang::CFGBlock::ElementList::operator[]", NM="_ZNK5clang8CFGBlock11ElementListixEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementListixEj")
    //</editor-fold>
    public CFGElement $at(/*size_t*/int i) /*const*/ {
      assert ($less_uint(i, Impl.size()));
      return new CFGElement(Impl.$at$Const(Impl.size() - 1 - i));
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::size">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 389,
     FQN="clang::CFGBlock::ElementList::size", NM="_ZNK5clang8CFGBlock11ElementList4sizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementList4sizeEv")
    //</editor-fold>
    public /*size_t*/int size() /*const*/ {
      return Impl.size();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::empty">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 390,
     FQN="clang::CFGBlock::ElementList::empty", NM="_ZNK5clang8CFGBlock11ElementList5emptyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11ElementList5emptyEv")
    //</editor-fold>
    public boolean empty() /*const*/ {
      return Impl.empty();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::ElementList::~ElementList">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 354,
     FQN="clang::CFGBlock::ElementList::~ElementList", NM="_ZN5clang8CFGBlock11ElementListD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11ElementListD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Impl.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Impl=" + Impl; // NOI18N
    }
  };
  
  /// Stmts - The set of statements in the basic block.
  private ElementList Elements;
  
  /// Label - An (optional) label that prefixes the executable
  ///  statements in the block.  When this variable is non-NULL, it is
  ///  either an instance of LabelStmt, SwitchCase or CXXCatchStmt.
  private Stmt /*P*/ Label;
  
  /// Terminator - The terminator for a basic block that
  ///  indicates the type of control-flow that occurs between a block
  ///  and its successors.
  private CFGTerminator Terminator;
  
  /// LoopTarget - Some blocks are used to represent the "loop edge" to
  ///  the start of a loop from within the loop body.  This Stmt* will be
  ///  refer to the loop statement for such blocks (and be null otherwise).
  private /*const*/ Stmt /*P*/ LoopTarget;
  
  /// BlockID - A numerical ID assigned to a CFGBlock during construction
  ///   of the CFG.
  private /*uint*/int BlockID;
/*public:*/
  /// This class represents a potential adjacent block in the CFG.  It encodes
  /// whether or not the block is actually reachable, or can be proved to be
  /// trivially unreachable.  For some cases it allows one to encode scenarios
  /// where a block was substituted because the original (now alternate) block
  /// is unreachable.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 421,
   FQN="clang::CFGBlock::AdjacentBlock", NM="_ZN5clang8CFGBlock13AdjacentBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13AdjacentBlockE")
  //</editor-fold>
  public static class AdjacentBlock {
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::Kind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 422,
     FQN="clang::CFGBlock::AdjacentBlock::Kind", NM="_ZN5clang8CFGBlock13AdjacentBlock4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13AdjacentBlock4KindE")
    //</editor-fold>
    private enum Kind implements Native.ComparableLower {
      AB_Normal(0),
      AB_Unreachable(AB_Normal.getValue() + 1),
      AB_Alternate(AB_Unreachable.getValue() + 1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Kind valueOf(int val) {
        Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Kind[] VALUES;
        private static final Kind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Kind kind : Kind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Kind[min < 0 ? (1-min) : 0];
          VALUES = new Kind[max >= 0 ? (1+max) : 0];
          for (Kind kind : Kind.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
                _VALUES[-kind.value] = kind;
              } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final /*uint*/int value;
      private Kind(int val) { this.value = (/*uint*/int)val;}
      public /*uint*/int getValue() { return value;}
      @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
      @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
      //</editor-fold>
    };
    
    private CFGBlock /*P*/ ReachableBlock;
    private PointerIntPair<CFGBlock /*P*/ > UnreachableBlock;
  /*public:*/
    /// Construct an AdjacentBlock with a possibly unreachable block.
    
    //===----------------------------------------------------------------------===//
    // CFGBlock operations.
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::AdjacentBlock">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3957,
     FQN="clang::CFGBlock::AdjacentBlock::AdjacentBlock", NM="_ZN5clang8CFGBlock13AdjacentBlockC1EPS0_b",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13AdjacentBlockC1EPS0_b")
    //</editor-fold>
    public AdjacentBlock(CFGBlock /*P*/ B, boolean IsReachable) {
      // : ReachableBlock(IsReachable ? B : null), UnreachableBlock(!IsReachable ? B : null, B && IsReachable ? AB_Normal : AB_Unreachable) 
      //START JInit
      this.ReachableBlock = IsReachable ? B : null;
      this.UnreachableBlock = new PointerIntPair<CFGBlock /*P*/ >(!IsReachable ? B : (CFGBlock /*P*/ )null, 
          (B != null) && IsReachable ? Kind.AB_Normal.getValue() : Kind.AB_Unreachable.getValue());
      //END JInit
    }

    
    /// Construct an AdjacentBlock with a reachable block and an alternate
    /// unreachable block.
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::AdjacentBlock">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3962,
     FQN="clang::CFGBlock::AdjacentBlock::AdjacentBlock", NM="_ZN5clang8CFGBlock13AdjacentBlockC1EPS0_S2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13AdjacentBlockC1EPS0_S2_")
    //</editor-fold>
    public AdjacentBlock(CFGBlock /*P*/ B, CFGBlock /*P*/ AlternateBlock) {
      // : ReachableBlock(B), UnreachableBlock(B == AlternateBlock ? null : AlternateBlock, B == AlternateBlock ? AB_Alternate : AB_Normal) 
      //START JInit
      this.ReachableBlock = B;
      this.UnreachableBlock = new PointerIntPair<CFGBlock /*P*/ >(B == AlternateBlock ? (CFGBlock /*P*/ )null : AlternateBlock, 
          B == AlternateBlock ? Kind.AB_Alternate.getValue() : Kind.AB_Normal.getValue());
      //END JInit
    }

    
    /// Get the reachable block, if one exists.
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::getReachableBlock">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 440,
     FQN="clang::CFGBlock::AdjacentBlock::getReachableBlock", NM="_ZNK5clang8CFGBlock13AdjacentBlock17getReachableBlockEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock13AdjacentBlock17getReachableBlockEv")
    //</editor-fold>
    public CFGBlock /*P*/ getReachableBlock() /*const*/ {
      return ReachableBlock;
    }

    
    /// Get the potentially unreachable block.
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::getPossiblyUnreachableBlock">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 445,
     FQN="clang::CFGBlock::AdjacentBlock::getPossiblyUnreachableBlock", NM="_ZNK5clang8CFGBlock13AdjacentBlock27getPossiblyUnreachableBlockEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock13AdjacentBlock27getPossiblyUnreachableBlockEv")
    //</editor-fold>
    public CFGBlock /*P*/ getPossiblyUnreachableBlock() /*const*/ {
      return UnreachableBlock.getPointer();
    }

    
    /// Provide an implicit conversion to CFGBlock* so that
    /// AdjacentBlock can be substituted for CFGBlock*.
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::operator CFGBlock * ">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 451,
     FQN="clang::CFGBlock::AdjacentBlock::operator CFGBlock * ", NM="_ZNK5clang8CFGBlock13AdjacentBlockcvPS0_Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock13AdjacentBlockcvPS0_Ev")
    //</editor-fold>
    public CFGBlock /*P*/ $CFGBlock$P() /*const*/ {
      return getReachableBlock();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 455,
     FQN="clang::CFGBlock::AdjacentBlock::operator*", NM="_ZNK5clang8CFGBlock13AdjacentBlockdeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock13AdjacentBlockdeEv")
    //</editor-fold>
    public CFGBlock /*&*/ $star() /*const*/ {
      return $Deref(getReachableBlock());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 459,
     FQN="clang::CFGBlock::AdjacentBlock::operator->", NM="_ZNK5clang8CFGBlock13AdjacentBlockptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock13AdjacentBlockptEv")
    //</editor-fold>
    public CFGBlock /*P*/ $arrow() /*const*/ {
      return getReachableBlock();
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::isReachable">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 463,
     FQN="clang::CFGBlock::AdjacentBlock::isReachable", NM="_ZNK5clang8CFGBlock13AdjacentBlock11isReachableEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock13AdjacentBlock11isReachableEv")
    //</editor-fold>
    public boolean isReachable() /*const*/ {
      Kind K = Kind.valueOf(UnreachableBlock.getInt());
      return K == Kind.AB_Normal || K == Kind.AB_Alternate;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::AdjacentBlock">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 421,
     FQN="clang::CFGBlock::AdjacentBlock::AdjacentBlock", NM="_ZN5clang8CFGBlock13AdjacentBlockC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13AdjacentBlockC1ERKS1_")
    //</editor-fold>
    public /*inline*/ AdjacentBlock(final /*const*/ AdjacentBlock /*&*/ $Prm0) {
      // : ReachableBlock(.ReachableBlock), UnreachableBlock(.UnreachableBlock) 
      //START JInit
      this.ReachableBlock = $Prm0.ReachableBlock;
      this.UnreachableBlock = new PointerIntPair<CFGBlock /*P*/ >($Prm0.UnreachableBlock);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::AdjacentBlock::AdjacentBlock">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 421,
     FQN="clang::CFGBlock::AdjacentBlock::AdjacentBlock", NM="_ZN5clang8CFGBlock13AdjacentBlockC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13AdjacentBlockC1EOS1_")
    //</editor-fold>
    public /*inline*/ AdjacentBlock(JD$Move _dparam, final AdjacentBlock /*&&*/$Prm0) {
      // : ReachableBlock(static_cast<AdjacentBlock &&>().ReachableBlock), UnreachableBlock(static_cast<AdjacentBlock &&>().UnreachableBlock) 
      //START JInit
      this.ReachableBlock = $Prm0.ReachableBlock;
      this.UnreachableBlock = new PointerIntPair<CFGBlock /*P*/ >(JD$Move.INSTANCE, $Prm0.UnreachableBlock);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "ReachableBlock=" + NativeTrace.getIdentityStr(ReachableBlock) // NOI18N
                + ", UnreachableBlock=" + UnreachableBlock; // NOI18N
    }
  };
/*private:*/
  /// Predecessors/Successors - Keep track of the predecessor / successor
  /// CFG blocks.
  /*typedef BumpVector<AdjacentBlock> AdjacentBlocks*/
//  public final class AdjacentBlocks extends BumpVector<AdjacentBlock>{ };
  private final BumpVector<AdjacentBlock> Preds;
  private final BumpVector<AdjacentBlock> Succs;
  
  /// NoReturn - This bit is set when the basic block contains a function call
  /// or implicit destructor that is attributed as 'noreturn'. In that case,
  /// control cannot technically ever proceed past this block. All such blocks
  /// will have a single immediate successor: the exit block. This allows them
  /// to be easily reached from the exit block and using this bit quickly
  /// recognized without scanning the contents of the block.
  ///
  /// Optimization Note: This bit could be profitably folded with Terminator's
  /// storage if the memory usage of CFGBlock becomes an issue.
  private /*JBIT unsigned int*/ boolean HasNoReturnElement /*: 1*/;
  
  /// Parent - The parent CFG that owns this CFGBlock.
  private CFG /*P*/ Parent;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::CFGBlock">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 491,
   FQN="clang::CFGBlock::CFGBlock", NM="_ZN5clang8CFGBlockC1EjRNS_17BumpVectorContextEPNS_3CFGE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlockC1EjRNS_17BumpVectorContextEPNS_3CFGE")
  //</editor-fold>
  public /*explicit*/ CFGBlock(/*uint*/int blockid, final BumpVectorContext /*&*/ C, CFG /*P*/ parent) {
    // : Elements(C), Label(null), Terminator(null), LoopTarget(null), BlockID(blockid), Preds(C, 1), Succs(C, 1), HasNoReturnElement(false), Parent(parent) 
    //START JInit
    this.Elements = new ElementList(C);
    this.Label = null;
    this.Terminator = new CFGTerminator((Stmt /*P*/ )null);
    this.LoopTarget = null;
    this.BlockID = blockid;
    // JAVA: MEMORY
    this.Preds = new BumpVector<AdjacentBlock>(
              new BumpVector.TypeAllocator<AdjacentBlock>(
                (int size)->{return new AdjacentBlock[size];}, 
                (AdjacentBlock element)->{return new AdjacentBlock(element);}),
              C, 1);
    this.Succs = new BumpVector<AdjacentBlock>(
              new BumpVector.TypeAllocator<AdjacentBlock>(
                (int size)->{return new AdjacentBlock[size];}, 
                (AdjacentBlock element)->{return new AdjacentBlock(element);}),
              C, 1);
    this.HasNoReturnElement = false;
    this.Parent = parent;
    //END JInit
  }

  
  // Statement iterators
  /*typedef ElementList::iterator iterator*/
//  public final class iterator extends std.reverse_iterator<CFGElement>{ };
  /*typedef ElementList::const_iterator const_iterator*/
//  public final class const_iterator extends std.reverse_iterator</*const*/ CFGElement>{ };
  /*typedef ElementList::reverse_iterator reverse_iterator*/
//  public final class reverse_iterator extends type$ptr<CFGElement /*P*/ >{ };
  /*typedef ElementList::const_reverse_iterator const_reverse_iterator*/
//  public final class const_reverse_iterator extends type$ptr</*const*/ CFGElement /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::front">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 502,
   FQN="clang::CFGBlock::front", NM="_ZNK5clang8CFGBlock5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock5frontEv")
  //</editor-fold>
  public CFGElement front() /*const*/ {
    return new CFGElement(Elements.front());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::back">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 503,
   FQN="clang::CFGBlock::back", NM="_ZNK5clang8CFGBlock4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock4backEv")
  //</editor-fold>
  public CFGElement back() /*const*/ {
    return new CFGElement(Elements.back());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 505,
   FQN="clang::CFGBlock::begin", NM="_ZN5clang8CFGBlock5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock5beginEv")
  //</editor-fold>
  public std.reverse_iterator<CFGElement> begin() {
    return Elements.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 506,
   FQN="clang::CFGBlock::end", NM="_ZN5clang8CFGBlock3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock3endEv")
  //</editor-fold>
  public std.reverse_iterator<CFGElement> end() {
    return Elements.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 507,
   FQN="clang::CFGBlock::begin", NM="_ZNK5clang8CFGBlock5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock5beginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ CFGElement> begin$Const() /*const*/ {
    return Elements.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 508,
   FQN="clang::CFGBlock::end", NM="_ZNK5clang8CFGBlock3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock3endEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ CFGElement> end$Const() /*const*/ {
    return Elements.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 510,
   FQN="clang::CFGBlock::rbegin", NM="_ZN5clang8CFGBlock6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock6rbeginEv")
  //</editor-fold>
  public type$ptr<CFGElement /*P*/ > rbegin() {
    return Elements.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 511,
   FQN="clang::CFGBlock::rend", NM="_ZN5clang8CFGBlock4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock4rendEv")
  //</editor-fold>
  public type$ptr<CFGElement /*P*/ > rend() {
    return Elements.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 512,
   FQN="clang::CFGBlock::rbegin", NM="_ZNK5clang8CFGBlock6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock6rbeginEv")
  //</editor-fold>
  public type$ptr</*const*/ CFGElement /*P*/ > rbegin$Const() /*const*/ {
    return Elements.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 513,
   FQN="clang::CFGBlock::rend", NM="_ZNK5clang8CFGBlock4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock4rendEv")
  //</editor-fold>
  public type$ptr</*const*/ CFGElement /*P*/ > rend$Const() /*const*/ {
    return Elements.rend$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 515,
   FQN="clang::CFGBlock::size", NM="_ZNK5clang8CFGBlock4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Elements.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 516,
   FQN="clang::CFGBlock::empty", NM="_ZNK5clang8CFGBlock5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Elements.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 518,
   FQN="clang::CFGBlock::operator[]", NM="_ZNK5clang8CFGBlockixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlockixEj")
  //</editor-fold>
  public CFGElement $at(/*size_t*/int i) /*const*/ {
    return Elements.$at(i);
  }

  
  // CFG iterators
  /*typedef AdjacentBlocks::iterator pred_iterator*/
//  public final class pred_iterator extends type$ptr<AdjacentBlock /*P*/ >{ };
  /*typedef AdjacentBlocks::const_iterator const_pred_iterator*/
//  public final class const_pred_iterator extends type$ptr</*const*/ AdjacentBlock /*P*/ >{ };
  /*typedef AdjacentBlocks::reverse_iterator pred_reverse_iterator*/
//  public final class pred_reverse_iterator extends std.reverse_iterator<AdjacentBlock>{ };
  /*typedef AdjacentBlocks::const_reverse_iterator const_pred_reverse_iterator*/
//  public final class const_pred_reverse_iterator extends std.reverse_iterator</*const*/ AdjacentBlock>{ };
  
  /*typedef AdjacentBlocks::iterator succ_iterator*/
//  public final class succ_iterator extends type$ptr<AdjacentBlock /*P*/ >{ };
  /*typedef AdjacentBlocks::const_iterator const_succ_iterator*/
//  public final class const_succ_iterator extends type$ptr</*const*/ AdjacentBlock /*P*/ >{ };
  /*typedef AdjacentBlocks::reverse_iterator succ_reverse_iterator*/
//  public final class succ_reverse_iterator extends std.reverse_iterator<AdjacentBlock>{ };
  /*typedef AdjacentBlocks::const_reverse_iterator const_succ_reverse_iterator*/
//  public final class const_succ_reverse_iterator extends std.reverse_iterator</*const*/ AdjacentBlock>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 531,
   FQN="clang::CFGBlock::pred_begin", NM="_ZN5clang8CFGBlock10pred_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock10pred_beginEv")
  //</editor-fold>
  public type$ptr<AdjacentBlock /*P*/ > pred_begin() {
    return Preds.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 532,
   FQN="clang::CFGBlock::pred_end", NM="_ZN5clang8CFGBlock8pred_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock8pred_endEv")
  //</editor-fold>
  public type$ptr<AdjacentBlock /*P*/ > pred_end() {
    return Preds.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 533,
   FQN="clang::CFGBlock::pred_begin", NM="_ZNK5clang8CFGBlock10pred_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock10pred_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ AdjacentBlock /*P*/ > pred_begin$Const() /*const*/ {
    return Preds.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 534,
   FQN="clang::CFGBlock::pred_end", NM="_ZNK5clang8CFGBlock8pred_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock8pred_endEv")
  //</editor-fold>
  public type$ptr</*const*/ AdjacentBlock /*P*/ > pred_end$Const() /*const*/ {
    return Preds.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 536,
   FQN="clang::CFGBlock::pred_rbegin", NM="_ZN5clang8CFGBlock11pred_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11pred_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<AdjacentBlock> pred_rbegin() {
    return Preds.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 537,
   FQN="clang::CFGBlock::pred_rend", NM="_ZN5clang8CFGBlock9pred_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock9pred_rendEv")
  //</editor-fold>
  public std.reverse_iterator<AdjacentBlock> pred_rend() {
    return Preds.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 538,
   FQN="clang::CFGBlock::pred_rbegin", NM="_ZNK5clang8CFGBlock11pred_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11pred_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ AdjacentBlock> pred_rbegin$Const() /*const*/ {
    return Preds.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 539,
   FQN="clang::CFGBlock::pred_rend", NM="_ZNK5clang8CFGBlock9pred_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock9pred_rendEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ AdjacentBlock> pred_rend$Const() /*const*/ {
    return Preds.rend$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 541,
   FQN="clang::CFGBlock::succ_begin", NM="_ZN5clang8CFGBlock10succ_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock10succ_beginEv")
  //</editor-fold>
  public type$ptr<AdjacentBlock /*P*/ > succ_begin() {
    return Succs.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 542,
   FQN="clang::CFGBlock::succ_end", NM="_ZN5clang8CFGBlock8succ_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock8succ_endEv")
  //</editor-fold>
  public type$ptr<AdjacentBlock /*P*/ > succ_end() {
    return Succs.end();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 543,
   FQN="clang::CFGBlock::succ_begin", NM="_ZNK5clang8CFGBlock10succ_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock10succ_beginEv")
  //</editor-fold>
  public type$ptr</*const*/ AdjacentBlock /*P*/ > succ_begin$Const() /*const*/ {
    return Succs.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 544,
   FQN="clang::CFGBlock::succ_end", NM="_ZNK5clang8CFGBlock8succ_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock8succ_endEv")
  //</editor-fold>
  public type$ptr</*const*/ AdjacentBlock /*P*/ > succ_end$Const() /*const*/ {
    return Succs.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 546,
   FQN="clang::CFGBlock::succ_rbegin", NM="_ZN5clang8CFGBlock11succ_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock11succ_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<AdjacentBlock> succ_rbegin() {
    return Succs.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 547,
   FQN="clang::CFGBlock::succ_rend", NM="_ZN5clang8CFGBlock9succ_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock9succ_rendEv")
  //</editor-fold>
  public std.reverse_iterator<AdjacentBlock> succ_rend() {
    return Succs.rend();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 548,
   FQN="clang::CFGBlock::succ_rbegin", NM="_ZNK5clang8CFGBlock11succ_rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock11succ_rbeginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ AdjacentBlock> succ_rbegin$Const() /*const*/ {
    return Succs.rbegin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 549,
   FQN="clang::CFGBlock::succ_rend", NM="_ZNK5clang8CFGBlock9succ_rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock9succ_rendEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ AdjacentBlock> succ_rend$Const() /*const*/ {
    return Succs.rend$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 551,
   FQN="clang::CFGBlock::succ_size", NM="_ZNK5clang8CFGBlock9succ_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock9succ_sizeEv")
  //</editor-fold>
  public /*uint*/int succ_size() /*const*/ {
    return Succs.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::succ_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 552,
   FQN="clang::CFGBlock::succ_empty", NM="_ZNK5clang8CFGBlock10succ_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock10succ_emptyEv")
  //</editor-fold>
  public boolean succ_empty() /*const*/ {
    return Succs.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 554,
   FQN="clang::CFGBlock::pred_size", NM="_ZNK5clang8CFGBlock9pred_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock9pred_sizeEv")
  //</editor-fold>
  public /*uint*/int pred_size() /*const*/ {
    return Preds.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::pred_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 555,
   FQN="clang::CFGBlock::pred_empty", NM="_ZNK5clang8CFGBlock10pred_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock10pred_emptyEv")
  //</editor-fold>
  public boolean pred_empty() /*const*/ {
    return Preds.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilterOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 558,
   FQN="clang::CFGBlock::FilterOptions", NM="_ZN5clang8CFGBlock13FilterOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13FilterOptionsE")
  //</editor-fold>
  public static class FilterOptions {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilterOptions::FilterOptions">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 560,
     FQN="clang::CFGBlock::FilterOptions::FilterOptions", NM="_ZN5clang8CFGBlock13FilterOptionsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13FilterOptionsC1Ev")
    //</editor-fold>
    public FilterOptions() {
      IgnoreNullPredecessors = true;
      IgnoreDefaultsWithCoveredEnums = false;
    }

    
    public /*JBIT unsigned int*/ boolean IgnoreNullPredecessors /*: 1*/;
    public /*JBIT unsigned int*/ boolean IgnoreDefaultsWithCoveredEnums /*: 1*/;
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilterOptions::FilterOptions">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 558,
     FQN="clang::CFGBlock::FilterOptions::FilterOptions", NM="_ZN5clang8CFGBlock13FilterOptionsC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13FilterOptionsC1ERKS1_")
    //</editor-fold>
    public /*inline*/ FilterOptions(final /*const*/ FilterOptions /*&*/ $Prm0) {
      // : IgnoreNullPredecessors(.IgnoreNullPredecessors), IgnoreDefaultsWithCoveredEnums(.IgnoreDefaultsWithCoveredEnums) 
      //START JInit
      this.IgnoreNullPredecessors = $Prm0.IgnoreNullPredecessors;
      this.IgnoreDefaultsWithCoveredEnums = $Prm0.IgnoreDefaultsWithCoveredEnums;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "IgnoreNullPredecessors=" + IgnoreNullPredecessors // NOI18N
                + ", IgnoreDefaultsWithCoveredEnums=" + IgnoreDefaultsWithCoveredEnums; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilterEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3978,
   FQN="clang::CFGBlock::FilterEdge", NM="_ZN5clang8CFGBlock10FilterEdgeERKNS0_13FilterOptionsEPKS0_S5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock10FilterEdgeERKNS0_13FilterOptionsEPKS0_S5_")
  //</editor-fold>
  public static boolean FilterEdge(final /*const*/ CFGBlock.FilterOptions /*&*/ F, 
            /*const*/ CFGBlock /*P*/ From, /*const*/ CFGBlock /*P*/ To) {
    if (F.IgnoreNullPredecessors && !(From != null)) {
      return true;
    }
    if ((To != null) && (From != null) && F.IgnoreDefaultsWithCoveredEnums) {
      {
        // If the 'To' has no label or is labeled but the label isn't a
        // CaseStmt then filter this edge.
        /*const*/ SwitchStmt /*P*/ S = dyn_cast_or_null_SwitchStmt(From.getTerminator$Const().getStmt$Const());
        if ((S != null)) {
          if (S.isAllEnumCasesCovered()) {
            /*const*/ Stmt /*P*/ L = To.getLabel$Const();
            if (!(L != null) || !isa_CaseStmt(L)) {
              return true;
            }
          }
        }
      }
    }
    
    return false;
  }

  
  /*template <typename IMPL, bool IsPred> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilteredCFGBlockIterator">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 572,
   FQN="clang::CFGBlock::FilteredCFGBlockIterator", NM="_ZN5clang8CFGBlock24FilteredCFGBlockIteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock24FilteredCFGBlockIteratorE")
  //</editor-fold>
  public static class FilteredCFGBlockIterator</*typename*/ IMPL extends type$iterator<IMPL,AdjacentBlock> /*, boolean IsPred*/>  {
  /*private:*/
    private boolean IsPred;
    private IMPL I;
    private IMPL E;
    private /*const*/ FilterOptions F;
    private /*const*/ CFGBlock /*P*/ From;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilteredCFGBlockIterator::FilteredCFGBlockIterator<IMPL, IsPred>">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 579,
     FQN="clang::CFGBlock::FilteredCFGBlockIterator::FilteredCFGBlockIterator<IMPL, IsPred>", NM="_ZN5clang8CFGBlock24FilteredCFGBlockIteratorC1ERKT_S4_PKS0_RKNS0_13FilterOptionsE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock24FilteredCFGBlockIteratorC1ERKT_S4_PKS0_RKNS0_13FilterOptionsE")
    //</editor-fold>
    public /*explicit*/ FilteredCFGBlockIterator(boolean IsPred, final /*const*/ IMPL /*&*/ i, final /*const*/ IMPL /*&*/ e, 
        /*const*/ CFGBlock /*P*/ from, 
        final /*const*/ FilterOptions /*&*/ f) {
      // : I(i), E(e), F(f), From(from) 
      //START JInit
      this.IsPred = IsPred;
      this.I = /*ParenListExpr*/$tryClone(i);//new IMPL(i);
      this.E = /*ParenListExpr*/$tryClone(e);//new IMPL(e);
      this.F = new FilterOptions(f);
      this.From = from;
      //END JInit
      while (hasMore() && Filter(I.$star().$CFGBlock$P())) {
        I.$preInc();
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilteredCFGBlockIterator::hasMore">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 587,
     FQN="clang::CFGBlock::FilteredCFGBlockIterator::hasMore", NM="_ZNK5clang8CFGBlock24FilteredCFGBlockIterator7hasMoreEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock24FilteredCFGBlockIterator7hasMoreEv")
    //</editor-fold>
    public boolean hasMore() /*const*/ {
      return Native.$noteq_iter(I, E);
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilteredCFGBlockIterator::operator++">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 589,
     FQN="clang::CFGBlock::FilteredCFGBlockIterator::operator++", NM="_ZN5clang8CFGBlock24FilteredCFGBlockIteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock24FilteredCFGBlockIteratorppEv")
    //</editor-fold>
    public FilteredCFGBlockIterator<IMPL> /*&*/ $preInc() {
      do {
        I.$preInc();
      } while (Native.$bool(hasMore()) && Native.$bool(Filter(I.$star().$CFGBlock$P())));
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilteredCFGBlockIterator::operator*">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 594,
     FQN="clang::CFGBlock::FilteredCFGBlockIterator::operator*", NM="_ZNK5clang8CFGBlock24FilteredCFGBlockIteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock24FilteredCFGBlockIteratordeEv")
    //</editor-fold>
    public /*const*/ CFGBlock /*P*/ $star() /*const*/ {
      return $Deref(I.$star().$star());
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::FilteredCFGBlockIterator::Filter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 596,
     FQN="clang::CFGBlock::FilteredCFGBlockIterator::Filter", NM="_ZN5clang8CFGBlock24FilteredCFGBlockIterator6FilterEPKS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock24FilteredCFGBlockIterator6FilterEPKS0_")
    //</editor-fold>
    private boolean Filter(/*const*/ CFGBlock /*P*/ To) {
      return IsPred ? FilterEdge(F, To, From) : FilterEdge(F, From, To);
    }

    
    @Override public String toString() {
      return "" + "I=" + I // NOI18N
                + ", E=" + E // NOI18N
                + ", F=" + F // NOI18N
                + ", From=" + From; // NOI18N
    }
  };
  
  /*typedef FilteredCFGBlockIterator<const_pred_iterator, true> filtered_pred_iterator*/
//  public final class filtered_pred_iterator extends FilteredCFGBlockIterator<type$ptr</*const*/ AdjacentBlock /*P*/ >/*, true*/>{ };
  
  /*typedef FilteredCFGBlockIterator<const_succ_iterator, false> filtered_succ_iterator*/
//  public final class filtered_succ_iterator extends FilteredCFGBlockIterator<type$ptr</*const*/ AdjacentBlock /*P*/ >/*, false*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::filtered_pred_start_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 607,
   FQN="clang::CFGBlock::filtered_pred_start_end", NM="_ZNK5clang8CFGBlock23filtered_pred_start_endERKNS0_13FilterOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock23filtered_pred_start_endERKNS0_13FilterOptionsE")
  //</editor-fold>
  public FilteredCFGBlockIterator<type$ptr</*const*/ AdjacentBlock /*P*/ >/*, true*/> filtered_pred_start_end(final /*const*/ FilterOptions /*&*/ f) /*const*/ {
    return new FilteredCFGBlockIterator<type$ptr</*const*/ AdjacentBlock /*P*/ >/*, true*/>(true, pred_begin$Const(), pred_end$Const(), this, f);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::filtered_succ_start_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 611,
   FQN="clang::CFGBlock::filtered_succ_start_end", NM="_ZNK5clang8CFGBlock23filtered_succ_start_endERKNS0_13FilterOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock23filtered_succ_start_endERKNS0_13FilterOptionsE")
  //</editor-fold>
  public FilteredCFGBlockIterator<type$ptr</*const*/ AdjacentBlock /*P*/ >/*, false*/> filtered_succ_start_end(final /*const*/ FilterOptions /*&*/ f) /*const*/ {
    return new FilteredCFGBlockIterator<type$ptr</*const*/ AdjacentBlock /*P*/ >/*, false*/>(false, succ_begin$Const(), succ_end$Const(), this, f);
  }

  
  // Manipulation of block contents
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::setTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 617,
   FQN="clang::CFGBlock::setTerminator", NM="_ZN5clang8CFGBlock13setTerminatorENS_13CFGTerminatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13setTerminatorENS_13CFGTerminatorE")
  //</editor-fold>
  public void setTerminator(CFGTerminator Term) {
    Terminator.$assign(Term);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::setLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 618,
   FQN="clang::CFGBlock::setLabel", NM="_ZN5clang8CFGBlock8setLabelEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock8setLabelEPNS_4StmtE")
  //</editor-fold>
  public void setLabel(Stmt /*P*/ Statement) {
    Label = Statement;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::setLoopTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 619,
   FQN="clang::CFGBlock::setLoopTarget", NM="_ZN5clang8CFGBlock13setLoopTargetEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13setLoopTargetEPKNS_4StmtE")
  //</editor-fold>
  public void setLoopTarget(/*const*/ Stmt /*P*/ loopTarget) {
    LoopTarget = loopTarget;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::setHasNoReturnElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 620,
   FQN="clang::CFGBlock::setHasNoReturnElement", NM="_ZN5clang8CFGBlock21setHasNoReturnElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock21setHasNoReturnElementEv")
  //</editor-fold>
  public void setHasNoReturnElement() {
    HasNoReturnElement = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 622,
   FQN="clang::CFGBlock::getTerminator", NM="_ZN5clang8CFGBlock13getTerminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock13getTerminatorEv")
  //</editor-fold>
  public CFGTerminator getTerminator() {
    return new CFGTerminator(Terminator);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 623,
   FQN="clang::CFGBlock::getTerminator", NM="_ZNK5clang8CFGBlock13getTerminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock13getTerminatorEv")
  //</editor-fold>
  public /*const*/ CFGTerminator getTerminator$Const() /*const*/ {
    return new CFGTerminator(Terminator);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getTerminatorCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4579,
   FQN="clang::CFGBlock::getTerminatorCondition", NM="_ZN5clang8CFGBlock22getTerminatorConditionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock22getTerminatorConditionEb")
  //</editor-fold>
  public Stmt /*P*/ getTerminatorCondition() {
    return getTerminatorCondition(true);
  }
  public Stmt /*P*/ getTerminatorCondition(boolean StripParens/*= true*/) {
    Stmt /*P*/ Terminator = this.Terminator.$Stmt$P();
    if (!(Terminator != null)) {
      return null;
    }
    
    Expr /*P*/ E = null;
    switch (Terminator.getStmtClass()) {
     default:
      break;
     case CXXForRangeStmtClass:
      E = cast_CXXForRangeStmt(Terminator).getCond();
      break;
     case ForStmtClass:
      E = cast_ForStmt(Terminator).getCond();
      break;
     case WhileStmtClass:
      E = cast_WhileStmt(Terminator).getCond();
      break;
     case DoStmtClass:
      E = cast_DoStmt(Terminator).getCond();
      break;
     case IfStmtClass:
      E = cast_IfStmt(Terminator).getCond();
      break;
     case ChooseExprClass:
      E = cast_ChooseExpr(Terminator).getCond();
      break;
     case IndirectGotoStmtClass:
      E = cast_IndirectGotoStmt(Terminator).getTarget();
      break;
     case SwitchStmtClass:
      E = cast_SwitchStmt(Terminator).getCond();
      break;
     case BinaryConditionalOperatorClass:
      E = cast_BinaryConditionalOperator(Terminator).getCond();
      break;
     case ConditionalOperatorClass:
      E = cast_ConditionalOperator(Terminator).getCond();
      break;
     case BinaryOperatorClass: // '&&' and '||'
      E = cast_BinaryOperator(Terminator).getLHS();
      break;
     case ObjCForCollectionStmtClass:
      return Terminator;
    }
    if (!StripParens) {
      return E;
    }
    
    return (E != null) ? E.IgnoreParens() : null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getTerminatorCondition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 627,
   FQN="clang::CFGBlock::getTerminatorCondition", NM="_ZNK5clang8CFGBlock22getTerminatorConditionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock22getTerminatorConditionEb")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getTerminatorCondition$Const() /*const*/ {
    return getTerminatorCondition$Const(true);
  }
  public /*const*/ Stmt /*P*/ getTerminatorCondition$Const(boolean StripParens/*= true*/) /*const*/ {
    return ((/*const_cast*/CFGBlock /*P*/ )(this)).getTerminatorCondition(StripParens);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getLoopTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 631,
   FQN="clang::CFGBlock::getLoopTarget", NM="_ZNK5clang8CFGBlock13getLoopTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock13getLoopTargetEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getLoopTarget() /*const*/ {
    return LoopTarget;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 633,
   FQN="clang::CFGBlock::getLabel", NM="_ZN5clang8CFGBlock8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock8getLabelEv")
  //</editor-fold>
  public Stmt /*P*/ getLabel() {
    return Label;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 634,
   FQN="clang::CFGBlock::getLabel", NM="_ZNK5clang8CFGBlock8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock8getLabelEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getLabel$Const() /*const*/ {
    return Label;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::hasNoReturnElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 636,
   FQN="clang::CFGBlock::hasNoReturnElement", NM="_ZNK5clang8CFGBlock18hasNoReturnElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock18hasNoReturnElementEv")
  //</editor-fold>
  public boolean hasNoReturnElement() /*const*/ {
    return HasNoReturnElement;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getBlockID">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 638,
   FQN="clang::CFGBlock::getBlockID", NM="_ZNK5clang8CFGBlock10getBlockIDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock10getBlockIDEv")
  //</editor-fold>
  public /*uint*/int getBlockID() /*const*/ {
    return BlockID;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::getParent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 640,
   FQN="clang::CFGBlock::getParent", NM="_ZNK5clang8CFGBlock9getParentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock9getParentEv")
  //</editor-fold>
  public CFG /*P*/ getParent() /*const*/ {
    return Parent;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4559,
   FQN="clang::CFGBlock::dump", NM="_ZNK5clang8CFGBlock4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(getParent(), new LangOptions(), false);
  }

  
  
  /// dump - A simply pretty printer of a CFGBlock that outputs to stderr.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4554,
   FQN="clang::CFGBlock::dump", NM="_ZNK5clang8CFGBlock4dumpEPKNS_3CFGERKNS_11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock4dumpEPKNS_3CFGERKNS_11LangOptionsEb")
  //</editor-fold>
  public void dump(/*const*/ CFG /*P*/ cfg, final /*const*/ LangOptions /*&*/ LO) /*const*/ {
    dump(cfg, LO, 
      false);
  }
  public void dump(/*const*/ CFG /*P*/ cfg, final /*const*/ LangOptions /*&*/ LO, 
      boolean ShowColors/*= false*/) /*const*/ {
    print(llvm.errs(), cfg, LO, ShowColors);
  }

  
  /// print - A simple pretty printer of a CFGBlock that outputs to an ostream.
  ///   Generally this will only be called from CFG::print.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4565,
   FQN="clang::CFGBlock::print", NM="_ZNK5clang8CFGBlock5printERN4llvm11raw_ostreamEPKNS_3CFGERKNS_11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock5printERN4llvm11raw_ostreamEPKNS_3CFGERKNS_11LangOptionsEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, /*const*/ CFG /*P*/ cfg, 
       final /*const*/ LangOptions /*&*/ LO, boolean ShowColors) /*const*/ {
    StmtPrinterHelper Helper = null;
    try {
      Helper/*J*/= new StmtPrinterHelper(cfg, LO);
      print_block(OS, cfg, /*Deref*/this, Helper, true, ShowColors);
      OS.$out_char($$LF);
    } finally {
      if (Helper != null) { Helper.$destroy(); }
    }
  }

  
  /// printTerminator - A simple pretty printer of the terminator of a CFGBlock.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::printTerminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4573,
   FQN="clang::CFGBlock::printTerminator", NM="_ZNK5clang8CFGBlock15printTerminatorERN4llvm11raw_ostreamERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK5clang8CFGBlock15printTerminatorERN4llvm11raw_ostreamERKNS_11LangOptionsE")
  //</editor-fold>
  public void printTerminator(final raw_ostream /*&*/ OS, 
                 final /*const*/ LangOptions /*&*/ LO) /*const*/ {
    CFGBlockTerminatorPrint TPrinter/*J*/= new CFGBlockTerminatorPrint(OS, (StmtPrinterHelper /*P*/ )null, new PrintingPolicy(LO));
    TPrinter.print(getTerminator$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::printAsOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 648,
   FQN="clang::CFGBlock::printAsOperand", NM="_ZN5clang8CFGBlock14printAsOperandERN4llvm11raw_ostreamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock14printAsOperandERN4llvm11raw_ostreamEb")
  //</editor-fold>
  public void printAsOperand(final raw_ostream /*&*/ OS, boolean $Prm1/*PrintType*/) {
    OS.$out(/*KEEP_STR*/"BB#").$out_uint(getBlockID());
  }

  
  /// Adds a (potentially unreachable) successor block to the current block.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::addSuccessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 3967,
   FQN="clang::CFGBlock::addSuccessor", NM="_ZN5clang8CFGBlock12addSuccessorENS0_13AdjacentBlockERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock12addSuccessorENS0_13AdjacentBlockERNS_17BumpVectorContextE")
  //</editor-fold>
  public void addSuccessor(AdjacentBlock Succ, 
              final BumpVectorContext /*&*/ C) {
    {
      CFGBlock /*P*/ B = Succ.getReachableBlock();
      if ((B != null)) {
        B.Preds.push_back(new AdjacentBlock(this, Succ.isReachable()), C);
      }
    }
    {
      
      CFGBlock /*P*/ UnreachableB = Succ.getPossiblyUnreachableBlock();
      if ((UnreachableB != null)) {
        UnreachableB.Preds.push_back(new AdjacentBlock(this, false), C);
      }
    }
    
    Succs.push_back(Succ, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::appendStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 655,
   FQN="clang::CFGBlock::appendStmt", NM="_ZN5clang8CFGBlock10appendStmtEPNS_4StmtERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock10appendStmtEPNS_4StmtERNS_17BumpVectorContextE")
  //</editor-fold>
  public void appendStmt(Stmt /*P*/ statement, final BumpVectorContext /*&*/ C) {
    Elements.push_back(new CFGElement(JD$Move.INSTANCE, new CFGStmt(statement)), C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::appendInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 659,
   FQN="clang::CFGBlock::appendInitializer", NM="_ZN5clang8CFGBlock17appendInitializerEPNS_18CXXCtorInitializerERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock17appendInitializerEPNS_18CXXCtorInitializerERNS_17BumpVectorContextE")
  //</editor-fold>
  public void appendInitializer(CXXCtorInitializer /*P*/ initializer, 
                   final BumpVectorContext /*&*/ C) {
    Elements.push_back(new CFGElement(JD$Move.INSTANCE, new CFGInitializer(initializer)), C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::appendNewAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 664,
   FQN="clang::CFGBlock::appendNewAllocator", NM="_ZN5clang8CFGBlock18appendNewAllocatorEPNS_10CXXNewExprERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock18appendNewAllocatorEPNS_10CXXNewExprERNS_17BumpVectorContextE")
  //</editor-fold>
  public void appendNewAllocator(CXXNewExpr /*P*/ NE, 
                    final BumpVectorContext /*&*/ C) {
    Elements.push_back(new CFGElement(JD$Move.INSTANCE, new CFGNewAllocator(NE)), C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::appendBaseDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 669,
   FQN="clang::CFGBlock::appendBaseDtor", NM="_ZN5clang8CFGBlock14appendBaseDtorEPKNS_16CXXBaseSpecifierERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock14appendBaseDtorEPKNS_16CXXBaseSpecifierERNS_17BumpVectorContextE")
  //</editor-fold>
  public void appendBaseDtor(/*const*/ CXXBaseSpecifier /*P*/ BS, final BumpVectorContext /*&*/ C) {
    Elements.push_back(new CFGElement(JD$Move.INSTANCE, new CFGBaseDtor(BS)), C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::appendMemberDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 673,
   FQN="clang::CFGBlock::appendMemberDtor", NM="_ZN5clang8CFGBlock16appendMemberDtorEPNS_9FieldDeclERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock16appendMemberDtorEPNS_9FieldDeclERNS_17BumpVectorContextE")
  //</editor-fold>
  public void appendMemberDtor(FieldDecl /*P*/ FD, final BumpVectorContext /*&*/ C) {
    Elements.push_back(new CFGElement(JD$Move.INSTANCE, new CFGMemberDtor(FD)), C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::appendTemporaryDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 677,
   FQN="clang::CFGBlock::appendTemporaryDtor", NM="_ZN5clang8CFGBlock19appendTemporaryDtorEPNS_20CXXBindTemporaryExprERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock19appendTemporaryDtorEPNS_20CXXBindTemporaryExprERNS_17BumpVectorContextE")
  //</editor-fold>
  public void appendTemporaryDtor(CXXBindTemporaryExpr /*P*/ E, final BumpVectorContext /*&*/ C) {
    Elements.push_back(new CFGElement(JD$Move.INSTANCE, new CFGTemporaryDtor(E)), C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::appendAutomaticObjDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 681,
   FQN="clang::CFGBlock::appendAutomaticObjDtor", NM="_ZN5clang8CFGBlock22appendAutomaticObjDtorEPNS_7VarDeclEPNS_4StmtERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock22appendAutomaticObjDtorEPNS_7VarDeclEPNS_4StmtERNS_17BumpVectorContextE")
  //</editor-fold>
  public void appendAutomaticObjDtor(VarDecl /*P*/ VD, Stmt /*P*/ S, final BumpVectorContext /*&*/ C) {
    Elements.push_back(new CFGElement(JD$Move.INSTANCE, new CFGAutomaticObjDtor(VD, S)), C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::appendDeleteDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 685,
   FQN="clang::CFGBlock::appendDeleteDtor", NM="_ZN5clang8CFGBlock16appendDeleteDtorEPNS_13CXXRecordDeclEPNS_13CXXDeleteExprERNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock16appendDeleteDtorEPNS_13CXXRecordDeclEPNS_13CXXDeleteExprERNS_17BumpVectorContextE")
  //</editor-fold>
  public void appendDeleteDtor(CXXRecordDecl /*P*/ RD, CXXDeleteExpr /*P*/ DE, final BumpVectorContext /*&*/ C) {
    Elements.push_back(new CFGElement(JD$Move.INSTANCE, new CFGDeleteDtor(RD, DE)), C);
  }

  
  // Destructors must be inserted in reversed order. So insertion is in two
  // steps. First we prepare space for some number of elements, then we insert
  // the elements beginning at the last position in prepared space.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::beginAutomaticObjDtorsInsert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 692,
   FQN="clang::CFGBlock::beginAutomaticObjDtorsInsert", NM="_ZN5clang8CFGBlock28beginAutomaticObjDtorsInsertESt16reverse_iteratorIPNS_10CFGElementEEjRNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock28beginAutomaticObjDtorsInsertESt16reverse_iteratorIPNS_10CFGElementEEjRNS_17BumpVectorContextE")
  //</editor-fold>
  public std.reverse_iterator<CFGElement> beginAutomaticObjDtorsInsert(std.reverse_iterator<CFGElement> I, /*size_t*/int Cnt, 
                              final BumpVectorContext /*&*/ C) {
    return new std.reverse_iterator<CFGElement>(Elements.insert((type$ptr<CFGElement /*P*/ >)I.base(), Cnt, 
            new CFGElement(JD$Move.INSTANCE, new CFGAutomaticObjDtor((/*const*/ VarDecl /*P*/ )null, (/*const*/ Stmt /*P*/ )null)), C));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::insertAutomaticObjDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 697,
   FQN="clang::CFGBlock::insertAutomaticObjDtor", NM="_ZN5clang8CFGBlock22insertAutomaticObjDtorESt16reverse_iteratorIPNS_10CFGElementEEPNS_7VarDeclEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlock22insertAutomaticObjDtorESt16reverse_iteratorIPNS_10CFGElementEEPNS_7VarDeclEPNS_4StmtE")
  //</editor-fold>
  public std.reverse_iterator<CFGElement> insertAutomaticObjDtor(std.reverse_iterator<CFGElement> I, VarDecl /*P*/ VD, Stmt /*P*/ S) {
    I.$star().$assignMove(new CFGAutomaticObjDtor(VD, S));
    return new std.reverse_iterator<CFGElement>(I.$preInc());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CFGBlock::~CFGBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/CFG.h", line = 353,
   FQN="clang::CFGBlock::~CFGBlock", NM="_ZN5clang8CFGBlockD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN5clang8CFGBlockD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<CFGElement /*P*/> iterator() { return new JavaIterator<>(begin(), end()); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      print(OS, getParent(), new LangOptions(), false);
      OS.flush();
      return Buf.toJavaString();
    }
    return "" + "Elements=" + Elements // NOI18N
              + ", Label=" + Label // NOI18N
              + ", Terminator=" + Terminator // NOI18N
              + ", LoopTarget=" + LoopTarget // NOI18N
              + ", BlockID=" + BlockID // NOI18N
              + ", Preds=" + Preds // NOI18N
              + ", Succs=" + Succs // NOI18N
              + ", HasNoReturnElement=" + HasNoReturnElement // NOI18N
              + ", Parent=" + NativeTrace.getIdentityStr(Parent); // NOI18N
  }
}
