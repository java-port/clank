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

package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Visitor for expressions which looks for unsequenced operations on the
/// same object.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8899,
 FQN="(anonymous namespace)::SequenceChecker", NM="_ZN12_GLOBAL__N_115SequenceCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceCheckerE")
//</editor-fold>
public class SequenceChecker implements /*public*/ EvaluatedExprVisitor<SequenceChecker>, Destructors.ClassWithDestructor {
  /*typedef EvaluatedExprVisitor<SequenceChecker> Base*/
//  public final class Base extends EvaluatedExprVisitor<SequenceChecker>{ };
  
  /// \brief A tree of sequenced regions within an expression. Two regions are
  /// unsequenced if one is an ancestor or a descendent of the other. When we
  /// finish processing an expression with sequencing, such as a comma
  /// expression, we fold its tree nodes into its parent, since they are
  /// unsequenced with respect to nodes we will visit later.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8907,
   FQN="(anonymous namespace)::SequenceChecker::SequenceTree", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTreeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTreeE")
  //</editor-fold>
  private static class SequenceTree implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Value">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8908,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Value", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree5ValueE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree5ValueE")
    //</editor-fold>
    private static class/*struct*/ Value implements NativeCloneable<Value> {
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Value::Value">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8909,
       FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Value::Value", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree5ValueC1Ej",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree5ValueC1Ej")
      //</editor-fold>
      public /*explicit*/ Value(/*uint*/int Parent) {
        // : Parent(Parent), Merged(false) 
        //START JInit
        this.Parent = Parent;
        this.Merged = false;
        //END JInit
      }

      public /*uint*/int Parent /*: 31*/;
      public /*JBIT unsigned int*/ boolean Merged /*: 1*/;
      //////////////////////////////////////////////////////////////
      // EXTRA MEMBERS: BEGIN

      @Override public Value clone() { return new Value(this); }
      
      public Value(Value $Prm0) { this.Parent = $Prm0.Parent; this.Merged = $Prm0.Merged; }
      
      public Value() { this(0); }

      // EXTRA MEMBERS: END
      //////////////////////////////////////////////////////////////
      
      @Override public String toString() {
        return "" + "Parent=" + Parent // NOI18N
                  + ", Merged=" + Merged; // NOI18N
      }
    };
    private SmallVector<Value> Values;
  /*public:*/
    /// \brief A region within an expression which may be sequenced with respect
    /// to some other region.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Seq">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8918,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Seq", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqE")
    //</editor-fold>
    public static class Seq implements NativePOD<Seq> {
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::Seq">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8919,
       FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::Seq", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqC1Ej",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqC1Ej")
      //</editor-fold>
      private /*explicit*/ Seq(/*uint*/int N) {
        // : Index(N) 
        //START JInit
        this.Index = N;
        //END JInit
      }

      private /*uint*/int Index;
      /*friend  class SequenceTree*/
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::Seq">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8923,
       FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::Seq", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqC1Ev")
      //</editor-fold>
      public Seq() {
        // : Index(0) 
        //START JInit
        this.Index = 0;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::Seq">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8918,
       FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::Seq", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqC1ERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqC1ERKS2_")
      //</editor-fold>
      public /*inline*/ Seq(final /*const*/ Seq /*&*/ $Prm0) {
        // : Index(.Index) 
        //START JInit
        this.Index = $Prm0.Index;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::Seq">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8918,
       FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::Seq", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqC1EOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqC1EOS2_")
      //</editor-fold>
      public /*inline*/ Seq(JD$Move _dparam, final Seq /*&&*/$Prm0) {
        // : Index(static_cast<Seq &&>().Index) 
        //START JInit
        this.Index = $Prm0.Index;
        //END JInit
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8918,
       FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::operator=", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqaSERKS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqaSERKS2_")
      //</editor-fold>
      public /*inline*/ Seq /*&*/ $assign(final /*const*/ Seq /*&*/ $Prm0) {
        this.Index = $Prm0.Index;
        return /*Deref*/this;
      }

      //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::operator=">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8918,
       FQN="(anonymous namespace)::SequenceChecker::SequenceTree::Seq::operator=", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqaSEOS2_",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree3SeqaSEOS2_")
      //</editor-fold>
      public /*inline*/ Seq /*&*/ $assignMove(final Seq /*&&*/$Prm0) {
        this.Index = $Prm0.Index;
        return /*Deref*/this;
      }

      @Override public Seq clone() { return new Seq(this); }
      
      @Override public String toString() {
        return "" + "Index=" + Index; // NOI18N
      }
    };
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::SequenceTree">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8926,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::SequenceTree", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTreeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTreeC1Ev")
    //</editor-fold>
    public SequenceTree() {
      // : Values() 
      //START JInit
      this.Values = new SmallVector<Value>(8, new Value());
      //END JInit
      Values.push_back(new Value(0));
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::root">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8927,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::root", NM="_ZNK12_GLOBAL__N_115SequenceChecker12SequenceTree4rootEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZNK12_GLOBAL__N_115SequenceChecker12SequenceTree4rootEv")
    //</editor-fold>
    public Seq root() /*const*/ {
      return new Seq(0);
    }

    
    /// \brief Create a new sequence of operations, which is an unsequenced
    /// subset of \p Parent. This sequence of operations is sequenced with
    /// respect to other children of \p Parent.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::allocate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8932,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::allocate", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree8allocateENS1_3SeqE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree8allocateENS1_3SeqE")
    //</editor-fold>
    public Seq allocate(Seq Parent) {
      Values.push_back(new Value(Parent.Index));
      return new Seq(Values.size() - 1);
    }

    
    /// \brief Merge a sequence of operations into its parent.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::merge">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8938,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::merge", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree5mergeENS1_3SeqE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree5mergeENS1_3SeqE")
    //</editor-fold>
    public void merge(Seq S) {
      Values.$at(S.Index).Merged = true;
    }

    
    /// \brief Determine whether two operations are unsequenced. This operation
    /// is asymmetric: \p Cur should be the more recent sequence, and \p Old
    /// should have been merged into its parent as appropriate.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::isUnsequenced">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8945,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::isUnsequenced", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree13isUnsequencedENS1_3SeqES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree13isUnsequencedENS1_3SeqES2_")
    //</editor-fold>
    public boolean isUnsequenced(Seq Cur, Seq Old) {
      /*uint*/int C = representative(Cur.Index);
      /*uint*/int Target = representative(Old.Index);
      while ($greatereq_uint(C, Target)) {
        if (C == Target) {
          return true;
        }
        C = Values.$at(C).Parent;
      }
      return false;
    }

  /*private:*/
    /// \brief Pick a representative for a sequence.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::representative">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8958,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::representative", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree14representativeEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTree14representativeEj")
    //</editor-fold>
    private /*uint*/int representative(/*uint*/int K) {
      if (Values.$at(K).Merged) {
        // Perform path compression as we go.
        return Values.$at(K).Parent = representative(Values.$at(K).Parent);
      }
      return K;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceTree::~SequenceTree">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8907,
     FQN="(anonymous namespace)::SequenceChecker::SequenceTree::~SequenceTree", NM="_ZN12_GLOBAL__N_115SequenceChecker12SequenceTreeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12SequenceTreeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Values.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "Values=" + Values; // NOI18N
    }
  };
  
  /// An object for which we can track unsequenced uses.
  /*typedef NamedDecl *Object*/
//  public final class Object extends NamedDecl /*P*/ { };
  
  /// Different flavors of object usage which we track. We only track the
  /// least-sequenced usage of each kind.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::UsageKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8971,
   FQN="(anonymous namespace)::SequenceChecker::UsageKind", NM="_ZN12_GLOBAL__N_115SequenceChecker9UsageKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker9UsageKindE")
  //</editor-fold>
  private enum UsageKind implements Native.ComparableLower {
    /// A read of an object. Multiple unsequenced reads are OK.
    UK_Use(0),
    /// A modification of an object which is sequenced before the value
    /// computation of the expression, such as ++n in C++.
    UK_ModAsValue(UK_Use.getValue() + 1),
    /// A modification of an object which is not sequenced before the value
    /// computation of the expression, such as n++.
    UK_ModAsSideEffect(UK_ModAsValue.getValue() + 1),
    
    UK_Count(UsageKind.UK_ModAsSideEffect.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static UsageKind valueOf(int val) {
      UsageKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final UsageKind[] VALUES;
      private static final UsageKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (UsageKind kind : UsageKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new UsageKind[min < 0 ? (1-min) : 0];
        VALUES = new UsageKind[max >= 0 ? (1+max) : 0];
        for (UsageKind kind : UsageKind.values()) {
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
    private UsageKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((UsageKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((UsageKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::Usage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8984,
   FQN="(anonymous namespace)::SequenceChecker::Usage", NM="_ZN12_GLOBAL__N_115SequenceChecker5UsageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker5UsageE")
  //</editor-fold>
  private static class/*struct*/ Usage implements NativeCloneable<Usage> {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::Usage::Usage">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8985,
     FQN="(anonymous namespace)::SequenceChecker::Usage::Usage", NM="_ZN12_GLOBAL__N_115SequenceChecker5UsageC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker5UsageC1Ev")
    //</editor-fold>
    public Usage() {
      // : Use(null), Seq() 
      //START JInit
      this.Use = null;
      this.Seq = new SequenceTree.Seq();
      //END JInit
    }

    public Expr /*P*/ Use;
    public SequenceTree.Seq Seq;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::Usage::Usage">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8984,
     FQN="(anonymous namespace)::SequenceChecker::Usage::Usage", NM="_ZN12_GLOBAL__N_115SequenceChecker5UsageC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker5UsageC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Usage(final /*const*/ Usage /*&*/ $Prm0) {
      // : Use(.Use), Seq(.Seq) 
      //START JInit
      this.Use = $Prm0.Use;
      this.Seq = new SequenceTree.Seq($Prm0.Seq);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::Usage::Usage">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8984,
     FQN="(anonymous namespace)::SequenceChecker::Usage::Usage", NM="_ZN12_GLOBAL__N_115SequenceChecker5UsageC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker5UsageC1EOS1_")
    //</editor-fold>
    public /*inline*/ Usage(JD$Move _dparam, final Usage /*&&*/$Prm0) {
      // : Use(static_cast<Usage &&>().Use), Seq(static_cast<Usage &&>().Seq) 
      //START JInit
      this.Use = $Prm0.Use;
      this.Seq = new SequenceTree.Seq(JD$Move.INSTANCE, $Prm0.Seq);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::Usage::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8984,
     FQN="(anonymous namespace)::SequenceChecker::Usage::operator=", NM="_ZN12_GLOBAL__N_115SequenceChecker5UsageaSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker5UsageaSERKS1_")
    //</editor-fold>
    public /*inline*/ Usage /*&*/ $assign(final /*const*/ Usage /*&*/ $Prm0) {
      this.Use = $Prm0.Use;
      this.Seq.$assign($Prm0.Seq);
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public Usage clone() { return new Usage(this); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Use=" + Use // NOI18N
                + ", Seq=" + Seq; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::UsageInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8990,
   FQN="(anonymous namespace)::SequenceChecker::UsageInfo", NM="_ZN12_GLOBAL__N_115SequenceChecker9UsageInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker9UsageInfoE")
  //</editor-fold>
  private static class/*struct*/ UsageInfo implements NativeCloneable<UsageInfo> {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::UsageInfo::UsageInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8991,
     FQN="(anonymous namespace)::SequenceChecker::UsageInfo::UsageInfo", NM="_ZN12_GLOBAL__N_115SequenceChecker9UsageInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker9UsageInfoC1Ev")
    //</editor-fold>
    public UsageInfo() {
      // : Uses(), Diagnosed(false) 
      //START JInit
      this.Uses = new$T(new Usage [3], ()->new Usage());
      this.Diagnosed = false;
      //END JInit
    }

    public Usage Uses[/*3*/] = new Usage [3];
    /// Have we issued a diagnostic for this variable already?
    public boolean Diagnosed;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::UsageInfo::UsageInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8990,
     FQN="(anonymous namespace)::SequenceChecker::UsageInfo::UsageInfo", NM="_ZN12_GLOBAL__N_115SequenceChecker9UsageInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker9UsageInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ UsageInfo(final /*const*/ UsageInfo /*&*/ $Prm0) {
      // : Uses(.Uses[__i0]), Diagnosed(.Diagnosed) 
      //START JInit
      this.Uses = new Usage[$Prm0.Uses.length];
      this.Diagnosed = $Prm0.Diagnosed;
      //END JInit
      // JAVA: copy
      for (int i = 0; i < Uses.length; i++) {
        Uses[i] = $tryClone($Prm0.Uses[i]);
      }      
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::UsageInfo::UsageInfo">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8990,
     FQN="(anonymous namespace)::SequenceChecker::UsageInfo::UsageInfo", NM="_ZN12_GLOBAL__N_115SequenceChecker9UsageInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker9UsageInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ UsageInfo(JD$Move _dparam, final UsageInfo /*&&*/$Prm0) {
      // : Uses(static_cast<Usage &&>(static_cast<UsageInfo &&>().Uses[__i0])), Diagnosed(static_cast<UsageInfo &&>().Diagnosed) 
      //START JInit
      this.Uses = $Prm0.Uses;
      $Prm0.Uses = null;
      this.Diagnosed = $Prm0.Diagnosed;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public UsageInfo clone() { return new UsageInfo(this); }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Uses=" + Uses // NOI18N
                + ", Diagnosed=" + Diagnosed; // NOI18N
    }
  };
  /*typedef llvm::SmallDenseMap<Object, UsageInfo, 16> UsageInfoMap*/
//  public final class UsageInfoMap extends SmallDenseMap<NamedDecl /*P*/ , UsageInfo>{ };
  
  private final Sema /*&*/ SemaRef;
  /// Sequenced regions within the expression.
  private SequenceTree Tree;
  /// Declaration modifications and references which we have seen.
  private SmallDenseMap<NamedDecl /*P*/ , UsageInfo> UsageMap;
  /// The region we are currently within.
  private SequenceTree.Seq Region;
  /// Filled in with declarations which were modified as a side-effect
  /// (that is, post-increment operations).
  private SmallVectorImpl<std.pair<NamedDecl /*P*/ , Usage> > /*P*/ ModAsSideEffect;
  /// Expressions to check later. We defer checking these to reduce
  /// stack usage.
  private final SmallVectorImpl<Expr /*P*/ > /*&*/ WorkList;
  
  /// RAII object wrapping the visitation of a sequenced subexpression of an
  /// expression. At the end of this process, the side-effects of the evaluation
  /// become sequenced with respect to the value computation of the result, so
  /// we downgrade any UK_ModAsSideEffect within the evaluation to
  /// UK_ModAsValue.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequencedSubexpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9017,
   FQN="(anonymous namespace)::SequenceChecker::SequencedSubexpression", NM="_ZN12_GLOBAL__N_115SequenceChecker22SequencedSubexpressionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker22SequencedSubexpressionE")
  //</editor-fold>
  private static class/*struct*/ SequencedSubexpression implements Destructors.ClassWithDestructor {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequencedSubexpression::SequencedSubexpression">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9018,
     FQN="(anonymous namespace)::SequenceChecker::SequencedSubexpression::SequencedSubexpression", NM="_ZN12_GLOBAL__N_115SequenceChecker22SequencedSubexpressionC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker22SequencedSubexpressionC1ERS0_")
    //</editor-fold>
    public SequencedSubexpression(final SequenceChecker /*&*/ Self) {
      // : Self(Self), ModAsSideEffect(), OldModAsSideEffect(Self.ModAsSideEffect) 
      //START JInit
      this./*&*/Self=/*&*/Self;
      this.ModAsSideEffect = new SmallVector<std.pair<NamedDecl /*P*/ , Usage>>(4, new std.pairPtrType<NamedDecl /*P*/ , Usage>(null, new Usage()));
      this.OldModAsSideEffect = Self.ModAsSideEffect;
      //END JInit
      Self.ModAsSideEffect = $AddrOf(ModAsSideEffect);
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequencedSubexpression::~SequencedSubexpression">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9022,
     FQN="(anonymous namespace)::SequenceChecker::SequencedSubexpression::~SequencedSubexpression", NM="_ZN12_GLOBAL__N_115SequenceChecker22SequencedSubexpressionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker22SequencedSubexpressionD0Ev")
    //</editor-fold>
    public void $destroy() {
      for (final std.pair<NamedDecl /*P*/ , Usage> /*&*/ M : llvm.reverse$NotHasRBegin(ModAsSideEffect)) {
        final UsageInfo /*&*/ U = Self.UsageMap.$at_T1$C$R(M.first);
        final Usage /*&*/ SideEffectUsage = U.Uses[UsageKind.UK_ModAsSideEffect.getValue()];
        Self.addUsage(U, M.first, SideEffectUsage.Use, UsageKind.UK_ModAsValue);
        SideEffectUsage.$assign(M.second);
      }
      Self.ModAsSideEffect = OldModAsSideEffect;
      //START JDestroy
      ModAsSideEffect.$destroy();
      //END JDestroy
    }

    
    public final SequenceChecker /*&*/ Self;
    public SmallVector<std.pair<NamedDecl /*P*/ , Usage>> ModAsSideEffect;
    public SmallVectorImpl<std.pair<NamedDecl /*P*/ , Usage> > /*P*/ OldModAsSideEffect;
    
    @Override public String toString() {
      return "" + "Self=" + Self // NOI18N
                + ", ModAsSideEffect=" + ModAsSideEffect // NOI18N
                + ", OldModAsSideEffect=" + OldModAsSideEffect; // NOI18N
    }
  };
  
  /// RAII object wrapping the visitation of a subexpression which we might
  /// choose to evaluate as a constant. If any subexpression is evaluated and
  /// found to be non-constant, this allows us to suppress the evaluation of
  /// the outer expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::EvaluationTracker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9041,
   FQN="(anonymous namespace)::SequenceChecker::EvaluationTracker", NM="_ZN12_GLOBAL__N_115SequenceChecker17EvaluationTrackerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker17EvaluationTrackerE")
  //</editor-fold>
  private static class EvaluationTracker implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::EvaluationTracker::EvaluationTracker">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9043,
     FQN="(anonymous namespace)::SequenceChecker::EvaluationTracker::EvaluationTracker", NM="_ZN12_GLOBAL__N_115SequenceChecker17EvaluationTrackerC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker17EvaluationTrackerC1ERS0_")
    //</editor-fold>
    public EvaluationTracker(final SequenceChecker /*&*/ Self) {
      // : Self(Self), Prev(Self.EvalTracker), EvalOK(true) 
      //START JInit
      this./*&*/Self=/*&*/Self;
      this.Prev = Self.EvalTracker;
      this.EvalOK = true;
      //END JInit
      Self.EvalTracker = this;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::EvaluationTracker::~EvaluationTracker">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9047,
     FQN="(anonymous namespace)::SequenceChecker::EvaluationTracker::~EvaluationTracker", NM="_ZN12_GLOBAL__N_115SequenceChecker17EvaluationTrackerD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker17EvaluationTrackerD0Ev")
    //</editor-fold>
    public void $destroy() {
      Self.EvalTracker = Prev;
      if ((Prev != null)) {
        Prev.EvalOK &= EvalOK;
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::EvaluationTracker::evaluate">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9053,
     FQN="(anonymous namespace)::SequenceChecker::EvaluationTracker::evaluate", NM="_ZN12_GLOBAL__N_115SequenceChecker17EvaluationTracker8evaluateEPKN5clang4ExprERb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker17EvaluationTracker8evaluateEPKN5clang4ExprERb")
    //</editor-fold>
    public boolean evaluate(/*const*/ Expr /*P*/ E, final bool$ref/*bool &*/ Result) {
      if (!EvalOK || E.isValueDependent()) {
        return false;
      }
      EvalOK = E.EvaluateAsBooleanCondition(Result, Self.SemaRef.Context);
      return EvalOK;
    }

  /*private:*/
    private final SequenceChecker /*&*/ Self;
    private EvaluationTracker /*P*/ Prev;
    private boolean EvalOK;
    
    @Override public String toString() {
      return "" + "Self=" + Self // NOI18N
                + ", Prev=" + Prev // NOI18N
                + ", EvalOK=" + EvalOK; // NOI18N
    }
  };
  private  EvaluationTracker /*P*/ EvalTracker;
  
  /// \brief Find the object which is produced by the specified expression,
  /// if any.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::getObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9068,
   FQN="(anonymous namespace)::SequenceChecker::getObject", NM="_ZNK12_GLOBAL__N_115SequenceChecker9getObjectEPN5clang4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZNK12_GLOBAL__N_115SequenceChecker9getObjectEPN5clang4ExprEb")
  //</editor-fold>
  private NamedDecl /*P*/ getObject(Expr /*P*/ E, boolean Mod) /*const*/ {
    E = E.IgnoreParenCasts();
    {
      UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
      if ((UO != null)) {
        if (Mod && (UO.getOpcode() == UnaryOperatorKind.UO_PreInc || UO.getOpcode() == UnaryOperatorKind.UO_PreDec)) {
          return getObject(UO.getSubExpr(), Mod);
        }
      } else {
        BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
        if ((BO != null)) {
          if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
            return getObject(BO.getRHS(), Mod);
          }
          if (Mod && BO.isAssignmentOp()) {
            return getObject(BO.getLHS(), Mod);
          }
        } else {
          MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
          if ((ME != null)) {
            // FIXME: Check for more interesting cases, like "x.n = ++x.n".
            if (isa_CXXThisExpr(ME.getBase().IgnoreParenCasts())) {
              return ME.getMemberDecl();
            }
          } else {
            DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
            if ((DRE != null)) {
              // FIXME: If this is a reference, map through to its value.
              return DRE.getDecl();
            }
          }
        }
      }
    }
    return null;
  }

  
  /// \brief Note that an object was modified or used by an expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::addUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9089,
   FQN="(anonymous namespace)::SequenceChecker::addUsage", NM="_ZN12_GLOBAL__N_115SequenceChecker8addUsageERNS0_9UsageInfoEPN5clang9NamedDeclEPNS3_4ExprENS0_9UsageKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker8addUsageERNS0_9UsageInfoEPN5clang9NamedDeclEPNS3_4ExprENS0_9UsageKindE")
  //</editor-fold>
  private void addUsage(final UsageInfo /*&*/ UI, NamedDecl /*P*/ O, Expr /*P*/ Ref, UsageKind UK) {
    final Usage /*&*/ U = UI.Uses[UK.getValue()];
    if (!(U.Use != null) || !Tree.isUnsequenced(new SequenceChecker.SequenceTree.Seq(Region), new SequenceChecker.SequenceTree.Seq(U.Seq))) {
      if (UK == UsageKind.UK_ModAsSideEffect && (ModAsSideEffect != null)) {
        ModAsSideEffect.push_back(std.make_pair_Ptr_T(O, U));
      }
      U.Use = Ref;
      U.Seq.$assign(Region);
    }
  }

  /// \brief Check whether a modification or use conflicts with a prior usage.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::checkUsage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9099,
   FQN="(anonymous namespace)::SequenceChecker::checkUsage", NM="_ZN12_GLOBAL__N_115SequenceChecker10checkUsageEPN5clang9NamedDeclERNS0_9UsageInfoEPNS1_4ExprENS0_9UsageKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker10checkUsageEPN5clang9NamedDeclERNS0_9UsageInfoEPNS1_4ExprENS0_9UsageKindEb")
  //</editor-fold>
  private void checkUsage(NamedDecl /*P*/ O, final UsageInfo /*&*/ UI, Expr /*P*/ Ref, UsageKind OtherKind, 
            boolean IsModMod) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (UI.Diagnosed) {
        return;
      }
      
      final /*const*/ Usage /*&*/ U = UI.Uses[OtherKind.getValue()];
      if (!(U.Use != null) || !Tree.isUnsequenced(new SequenceChecker.SequenceTree.Seq(Region), new SequenceChecker.SequenceTree.Seq(U.Seq))) {
        return;
      }
      
      type$ref<Expr /*P*/ > Mod = create_type$ref(U.Use);
      type$ref<Expr /*P*/ > ModOrUse = create_type$ref(Ref);
      if (OtherKind == UsageKind.UK_Use) {
        std.swap(Mod, ModOrUse);
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Mod.$deref().getExprLoc(), 
                  IsModMod ? diag.warn_unsequenced_mod_mod : diag.warn_unsequenced_mod_use)), 
              O), new SourceRange(ModOrUse.$deref().getExprLoc())));
      UI.Diagnosed = true;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::notePreUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9120,
   FQN="(anonymous namespace)::SequenceChecker::notePreUse", NM="_ZN12_GLOBAL__N_115SequenceChecker10notePreUseEPN5clang9NamedDeclEPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker10notePreUseEPN5clang9NamedDeclEPNS1_4ExprE")
  //</editor-fold>
  private void notePreUse(NamedDecl /*P*/ O, Expr /*P*/ Use) {
    final UsageInfo /*&*/ U = UsageMap.$at_T1$C$R(O);
    // Uses conflict with other modifications.
    checkUsage(O, U, Use, UsageKind.UK_ModAsValue, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::notePostUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9125,
   FQN="(anonymous namespace)::SequenceChecker::notePostUse", NM="_ZN12_GLOBAL__N_115SequenceChecker11notePostUseEPN5clang9NamedDeclEPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker11notePostUseEPN5clang9NamedDeclEPNS1_4ExprE")
  //</editor-fold>
  private void notePostUse(NamedDecl /*P*/ O, Expr /*P*/ Use) {
    final UsageInfo /*&*/ U = UsageMap.$at_T1$C$R(O);
    checkUsage(O, U, Use, UsageKind.UK_ModAsSideEffect, false);
    addUsage(U, O, Use, UsageKind.UK_Use);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::notePreMod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9131,
   FQN="(anonymous namespace)::SequenceChecker::notePreMod", NM="_ZN12_GLOBAL__N_115SequenceChecker10notePreModEPN5clang9NamedDeclEPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker10notePreModEPN5clang9NamedDeclEPNS1_4ExprE")
  //</editor-fold>
  private void notePreMod(NamedDecl /*P*/ O, Expr /*P*/ Mod) {
    final UsageInfo /*&*/ U = UsageMap.$at_T1$C$R(O);
    // Modifications conflict with other modifications and with uses.
    checkUsage(O, U, Mod, UsageKind.UK_ModAsValue, true);
    checkUsage(O, U, Mod, UsageKind.UK_Use, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::notePostMod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9137,
   FQN="(anonymous namespace)::SequenceChecker::notePostMod", NM="_ZN12_GLOBAL__N_115SequenceChecker11notePostModEPN5clang9NamedDeclEPNS1_4ExprENS0_9UsageKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker11notePostModEPN5clang9NamedDeclEPNS1_4ExprENS0_9UsageKindE")
  //</editor-fold>
  private void notePostMod(NamedDecl /*P*/ O, Expr /*P*/ Use, UsageKind UK) {
    final UsageInfo /*&*/ U = UsageMap.$at_T1$C$R(O);
    checkUsage(O, U, Use, UsageKind.UK_ModAsSideEffect, true);
    addUsage(U, O, Use, UK);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::SequenceChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9144,
   FQN="(anonymous namespace)::SequenceChecker::SequenceChecker", NM="_ZN12_GLOBAL__N_115SequenceCheckerC1ERN5clang4SemaEPNS1_4ExprERN4llvm15SmallVectorImplIS5_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceCheckerC1ERN5clang4SemaEPNS1_4ExprERN4llvm15SmallVectorImplIS5_EE")
  //</editor-fold>
  public SequenceChecker(final Sema /*&*/ S, Expr /*P*/ E, final SmallVectorImpl<Expr /*P*/ > /*&*/ WorkList) {
    // : Base(S.Context), SemaRef(S), Tree(), UsageMap(), Region(Tree.root()), ModAsSideEffect(null), WorkList(WorkList), EvalTracker(null) 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(S.Context);
    this./*&*/SemaRef=/*&*/S;
    this.Tree = new SequenceTree();
    this.UsageMap = new SmallDenseMap<NamedDecl /*P*/ , UsageInfo>(DenseMapInfo$LikePtr.$Info(), 16, new UsageInfo());
    this.Region = Tree.root();
    this.ModAsSideEffect = null;
    this./*&*/WorkList=/*&*/WorkList;
    this.EvalTracker = null;
    //END JInit
    Visit(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9150,
   FQN="(anonymous namespace)::SequenceChecker::VisitStmt", NM="_ZN12_GLOBAL__N_115SequenceChecker9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    // Skip all statements which aren't expressions for now.
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9154,
   FQN="(anonymous namespace)::SequenceChecker::VisitExpr", NM="_ZN12_GLOBAL__N_115SequenceChecker9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public void VisitExpr(Expr /*P*/ E) {
    // By default, just recurse to evaluated subexpressions.
    EvaluatedExprVisitor.super.VisitStmt(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9159,
   FQN="(anonymous namespace)::SequenceChecker::VisitCastExpr", NM="_ZN12_GLOBAL__N_115SequenceChecker13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(CastExpr /*P*/ E) {
    NamedDecl /*P*/ O = ((NamedDecl /*P*/ )null);
    if (E.getCastKind() == CastKind.CK_LValueToRValue) {
      O = getObject(E.getSubExpr(), false);
    }
    if ((O != null)) {
      notePreUse(O, E);
    }
    VisitExpr(E);
    if ((O != null)) {
      notePostUse(O, E);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitBinComma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9171,
   FQN="(anonymous namespace)::SequenceChecker::VisitBinComma", NM="_ZN12_GLOBAL__N_115SequenceChecker13VisitBinCommaEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker13VisitBinCommaEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinComma(BinaryOperator /*P*/ BO) {
    // C++11 [expr.comma]p1:
    //   Every value computation and side effect associated with the left
    //   expression is sequenced before every value computation and side
    //   effect associated with the right expression.
    SequenceTree.Seq LHS = Tree.allocate(new SequenceChecker.SequenceTree.Seq(Region));
    SequenceTree.Seq RHS = Tree.allocate(new SequenceChecker.SequenceTree.Seq(Region));
    SequenceTree.Seq OldRegion = new SequenceTree.Seq(Region);
    {
      SequencedSubexpression SeqLHS = null;
      try {
        SeqLHS/*J*/= new SequencedSubexpression(/*Deref*/this);
        Region.$assign(LHS);
        Visit(BO.getLHS());
      } finally {
        if (SeqLHS != null) { SeqLHS.$destroy(); }
      }
    }
    
    Region.$assign(RHS);
    Visit(BO.getRHS());
    
    Region.$assign(OldRegion);
    
    // Forget that LHS and RHS are sequenced. They are both unsequenced
    // with respect to other stuff.
    Tree.merge(new SequenceChecker.SequenceTree.Seq(LHS));
    Tree.merge(new SequenceChecker.SequenceTree.Seq(RHS));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitBinAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9197,
   FQN="(anonymous namespace)::SequenceChecker::VisitBinAssign", NM="_ZN12_GLOBAL__N_115SequenceChecker14VisitBinAssignEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker14VisitBinAssignEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinAssign(BinaryOperator /*P*/ BO) {
    // The modification is sequenced after the value computation of the LHS
    // and RHS, so check it before inspecting the operands and update the
    // map afterwards.
    NamedDecl /*P*/ O = getObject(BO.getLHS(), true);
    if (!(O != null)) {
      VisitExpr(BO);
      /*JAVA:return*/return;
    }
    
    notePreMod(O, BO);
    
    // C++11 [expr.ass]p7:
    //   E1 op= E2 is equivalent to E1 = E1 op E2, except that E1 is evaluated
    //   only once.
    //
    // Therefore, for a compound assignment operator, O is considered used
    // everywhere except within the evaluation of E1 itself.
    if (isa_CompoundAssignOperator(BO)) {
      notePreUse(O, BO);
    }
    
    Visit(BO.getLHS());
    if (isa_CompoundAssignOperator(BO)) {
      notePostUse(O, BO);
    }
    
    Visit(BO.getRHS());
    
    // C++11 [expr.ass]p1:
    //   the assignment is sequenced [...] before the value computation of the
    //   assignment expression.
    // C11 6.5.16/3 has no such rule.
    notePostMod(O, BO, SemaRef.getLangOpts().CPlusPlus ? UsageKind.UK_ModAsValue : UsageKind.UK_ModAsSideEffect);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9231,
   FQN="(anonymous namespace)::SequenceChecker::VisitCompoundAssignOperator", NM="_ZN12_GLOBAL__N_115SequenceChecker27VisitCompoundAssignOperatorEPN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker27VisitCompoundAssignOperatorEPN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public void VisitCompoundAssignOperator(CompoundAssignOperator /*P*/ CAO) {
    VisitBinAssign(CAO);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitUnaryPreInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9235,
   FQN="(anonymous namespace)::SequenceChecker::VisitUnaryPreInc", NM="_ZN12_GLOBAL__N_115SequenceChecker16VisitUnaryPreIncEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker16VisitUnaryPreIncEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryPreInc(UnaryOperator /*P*/ UO) {
    VisitUnaryPreIncDec(UO);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitUnaryPreDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9236,
   FQN="(anonymous namespace)::SequenceChecker::VisitUnaryPreDec", NM="_ZN12_GLOBAL__N_115SequenceChecker16VisitUnaryPreDecEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker16VisitUnaryPreDecEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryPreDec(UnaryOperator /*P*/ UO) {
    VisitUnaryPreIncDec(UO);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitUnaryPreIncDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9237,
   FQN="(anonymous namespace)::SequenceChecker::VisitUnaryPreIncDec", NM="_ZN12_GLOBAL__N_115SequenceChecker19VisitUnaryPreIncDecEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker19VisitUnaryPreIncDecEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryPreIncDec(UnaryOperator /*P*/ UO) {
    NamedDecl /*P*/ O = getObject(UO.getSubExpr(), true);
    if (!(O != null)) {
      VisitExpr(UO);
      /*JAVA:return*/return;
    }
    
    notePreMod(O, UO);
    Visit(UO.getSubExpr());
    // C++11 [expr.pre.incr]p1:
    //   the expression ++x is equivalent to x+=1
    notePostMod(O, UO, SemaRef.getLangOpts().CPlusPlus ? UsageKind.UK_ModAsValue : UsageKind.UK_ModAsSideEffect);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitUnaryPostInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9250,
   FQN="(anonymous namespace)::SequenceChecker::VisitUnaryPostInc", NM="_ZN12_GLOBAL__N_115SequenceChecker17VisitUnaryPostIncEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker17VisitUnaryPostIncEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryPostInc(UnaryOperator /*P*/ UO) {
    VisitUnaryPostIncDec(UO);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitUnaryPostDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9251,
   FQN="(anonymous namespace)::SequenceChecker::VisitUnaryPostDec", NM="_ZN12_GLOBAL__N_115SequenceChecker17VisitUnaryPostDecEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker17VisitUnaryPostDecEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryPostDec(UnaryOperator /*P*/ UO) {
    VisitUnaryPostIncDec(UO);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitUnaryPostIncDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9252,
   FQN="(anonymous namespace)::SequenceChecker::VisitUnaryPostIncDec", NM="_ZN12_GLOBAL__N_115SequenceChecker20VisitUnaryPostIncDecEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker20VisitUnaryPostIncDecEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryPostIncDec(UnaryOperator /*P*/ UO) {
    NamedDecl /*P*/ O = getObject(UO.getSubExpr(), true);
    if (!(O != null)) {
      VisitExpr(UO);
      /*JAVA:return*/return;
    }
    
    notePreMod(O, UO);
    Visit(UO.getSubExpr());
    notePostMod(O, UO, UsageKind.UK_ModAsSideEffect);
  }

  
  /// Don't visit the RHS of '&&' or '||' if it might not be evaluated.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitBinLOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9263,
   FQN="(anonymous namespace)::SequenceChecker::VisitBinLOr", NM="_ZN12_GLOBAL__N_115SequenceChecker11VisitBinLOrEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker11VisitBinLOrEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinLOr(BinaryOperator /*P*/ BO) {
    EvaluationTracker Eval = null;
    try {
      // The side-effects of the LHS of an '&&' are sequenced before the
      // value computation of the RHS, and hence before the value computation
      // of the '&&' itself, unless the LHS evaluates to zero. We treat them
      // as if they were unconditionally sequenced.
      Eval/*J*/= new EvaluationTracker(/*Deref*/this);
      {
        SequencedSubexpression Sequenced = null;
        try {
          Sequenced/*J*/= new SequencedSubexpression(/*Deref*/this);
          Visit(BO.getLHS());
        } finally {
          if (Sequenced != null) { Sequenced.$destroy(); }
        }
      }
      
      bool$ref Result = create_bool$ref();
      if (Eval.evaluate(BO.getLHS(), Result)) {
        if (!Result.$deref()) {
          Visit(BO.getRHS());
        }
      } else {
        // Check for unsequenced operations in the RHS, treating it as an
        // entirely separate evaluation.
        //
        // FIXME: If there are operations in the RHS which are unsequenced
        // with respect to operations outside the RHS, and those operations
        // are unconditionally evaluated, diagnose them.
        WorkList.push_back(BO.getRHS());
      }
    } finally {
      if (Eval != null) { Eval.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitBinLAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9288,
   FQN="(anonymous namespace)::SequenceChecker::VisitBinLAnd", NM="_ZN12_GLOBAL__N_115SequenceChecker12VisitBinLAndEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker12VisitBinLAndEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinLAnd(BinaryOperator /*P*/ BO) {
    EvaluationTracker Eval = null;
    try {
      Eval/*J*/= new EvaluationTracker(/*Deref*/this);
      {
        SequencedSubexpression Sequenced = null;
        try {
          Sequenced/*J*/= new SequencedSubexpression(/*Deref*/this);
          Visit(BO.getLHS());
        } finally {
          if (Sequenced != null) { Sequenced.$destroy(); }
        }
      }
      
      bool$ref Result = create_bool$ref();
      if (Eval.evaluate(BO.getLHS(), Result)) {
        if (Result.$deref()) {
          Visit(BO.getRHS());
        }
      } else {
        WorkList.push_back(BO.getRHS());
      }
    } finally {
      if (Eval != null) { Eval.$destroy(); }
    }
  }

  
  // Only visit the condition, unless we can be sure which subexpression will
  // be chosen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9306,
   FQN="(anonymous namespace)::SequenceChecker::VisitAbstractConditionalOperator", NM="_ZN12_GLOBAL__N_115SequenceChecker32VisitAbstractConditionalOperatorEPN5clang27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker32VisitAbstractConditionalOperatorEPN5clang27AbstractConditionalOperatorE")
  //</editor-fold>
  public void VisitAbstractConditionalOperator(AbstractConditionalOperator /*P*/ CO) {
    EvaluationTracker Eval = null;
    try {
      Eval/*J*/= new EvaluationTracker(/*Deref*/this);
      {
        SequencedSubexpression Sequenced = null;
        try {
          Sequenced/*J*/= new SequencedSubexpression(/*Deref*/this);
          Visit(CO.getCond());
        } finally {
          if (Sequenced != null) { Sequenced.$destroy(); }
        }
      }
      
      bool$ref Result = create_bool$ref();
      if (Eval.evaluate(CO.getCond(), Result)) {
        Visit(Result.$deref() ? CO.getTrueExpr() : CO.getFalseExpr());
      } else {
        WorkList.push_back(CO.getTrueExpr());
        WorkList.push_back(CO.getFalseExpr());
      }
    } finally {
      if (Eval != null) { Eval.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9322,
   FQN="(anonymous namespace)::SequenceChecker::VisitCallExpr", NM="_ZN12_GLOBAL__N_115SequenceChecker13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ CE) {
    SequencedSubexpression Sequenced = null;
    try {
      // C++11 [intro.execution]p15:
      //   When calling a function [...], every value computation and side effect
      //   associated with any argument expression, or with the postfix expression
      //   designating the called function, is sequenced before execution of every
      //   expression or statement in the body of the function [and thus before
      //   the value computation of its result].
      Sequenced/*J*/= new SequencedSubexpression(/*Deref*/this);
      EvaluatedExprVisitor.super.VisitCallExpr(CE);
    } finally {
      if (Sequenced != null) { Sequenced.$destroy(); }
    }
    // FIXME: CXXNewExpr and CXXDeleteExpr implicitly call functions.
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9335,
   FQN="(anonymous namespace)::SequenceChecker::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_115SequenceChecker21VisitCXXConstructExprEPN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker21VisitCXXConstructExprEPN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(CXXConstructExpr /*P*/ CCE) {
    SequencedSubexpression Sequenced = null;
    try {
      // This is a call, so all subexpressions are sequenced before the result.
      Sequenced/*J*/= new SequencedSubexpression(/*Deref*/this);
      if (!CCE.isListInitialization()) {
        VisitExpr(CCE);
        /*JAVA:return*/return;
      }
      
      // In C++11, list initializations are sequenced.
      SmallVector<SequenceTree.Seq> Elts/*J*/= new SmallVector<SequenceTree.Seq>(32, new SequenceTree.Seq());
      SequenceTree.Seq Parent = new SequenceTree.Seq(Region);
      for (Stmt.ExprIterator I = CCE.arg_begin(), 
          E = CCE.arg_end();
           I.$noteq(E); I.$preInc()) {
        Region.$assignMove(Tree.allocate(new SequenceChecker.SequenceTree.Seq(Parent)));
        Elts.push_back(Region);
        Visit(I.$star());
      }
      
      // Forget that the initializers are sequenced.
      Region.$assign(Parent);
      for (/*uint*/int I = 0; $less_uint(I, Elts.size()); ++I)  {
        Tree.merge(new SequenceChecker.SequenceTree.Seq(Elts.$at(I)));
      }
    } finally {
      if (Sequenced != null) { Sequenced.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 9359,
   FQN="(anonymous namespace)::SequenceChecker::VisitInitListExpr", NM="_ZN12_GLOBAL__N_115SequenceChecker17VisitInitListExprEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceChecker17VisitInitListExprEPN5clang12InitListExprE")
  //</editor-fold>
  public void VisitInitListExpr(InitListExpr /*P*/ ILE) {
    if (!SemaRef.getLangOpts().CPlusPlus11) {
      VisitExpr(ILE);
      /*JAVA:return*/return;
    }
    
    // In C++11, list initializations are sequenced.
    SmallVector<SequenceTree.Seq> Elts/*J*/= new SmallVector<SequenceTree.Seq>(32, new SequenceTree.Seq());
    SequenceTree.Seq Parent = new SequenceTree.Seq(Region);
    for (/*uint*/int I = 0; $less_uint(I, ILE.getNumInits()); ++I) {
      Expr /*P*/ E = ILE.getInit(I);
      if (!(E != null)) {
        continue;
      }
      Region.$assignMove(Tree.allocate(new SequenceChecker.SequenceTree.Seq(Parent)));
      Elts.push_back(Region);
      Visit(E);
    }
    
    // Forget that the initializers are sequenced.
    Region.$assign(Parent);
    for (/*uint*/int I = 0; $less_uint(I, Elts.size()); ++I)  {
      Tree.merge(new SequenceChecker.SequenceTree.Seq(Elts.$at(I)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SequenceChecker::~SequenceChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp", line = 8899,
   FQN="(anonymous namespace)::SequenceChecker::~SequenceChecker", NM="_ZN12_GLOBAL__N_115SequenceCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaChecking.cpp -nm=_ZN12_GLOBAL__N_115SequenceCheckerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    UsageMap.$destroy();
    Tree.$destroy();
    EvaluatedExprVisitor.super.$destroy$EvaluatedExprVisitor();
    //END JDestroy
  }

  
  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", Tree=" + Tree // NOI18N
              + ", UsageMap=" + UsageMap // NOI18N
              + ", Region=" + Region // NOI18N
              + ", ModAsSideEffect=" + ModAsSideEffect // NOI18N
              + ", WorkList=" + WorkList // NOI18N
              + ", EvalTracker=" + EvalTracker // NOI18N
              + super.toString(); // NOI18N
  }
}
