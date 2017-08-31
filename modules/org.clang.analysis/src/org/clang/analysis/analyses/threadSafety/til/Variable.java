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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.threadSafety.til.*;


/// A named variable, e.g. "x".
///
/// There are two distinct places in which a Variable can appear in the AST.
/// A variable declaration introduces a new variable, and can occur in 3 places:
///   Let-expressions:           (Let (x = t) u)
///   Functions:                 (Function (x : t) u)
///   Self-applicable functions  (SFunction (x) t)
///
/// If a variable occurs in any other location, it is a reference to an existing
/// variable declaration -- e.g. 'x' in (x * y + z). To save space, we don't
/// allocate a separate AST node for variable references; a reference is just a
/// pointer to the original declaration.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 345,
 FQN="clang::threadSafety::til::Variable", NM="_ZN5clang12threadSafety3til8VariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8VariableE")
//</editor-fold>
public class Variable extends /*public*/ SExpr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 347,
   FQN="clang::threadSafety::til::Variable::classof", NM="_ZN5clang12threadSafety3til8Variable7classofEPKNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Variable7classofEPKNS1_5SExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ SExpr /*P*/ E) {
    return E.opcode() == TIL_Opcode.COP_Variable;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::VariableKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 349,
   FQN="clang::threadSafety::til::Variable::VariableKind", NM="_ZN5clang12threadSafety3til8Variable12VariableKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Variable12VariableKindE")
  //</editor-fold>
  public enum VariableKind implements Native.ComparableLower {
    VK_Let(0), ///< Let-variable
    VK_Fun(VK_Let.getValue() + 1), ///< Function parameter
    VK_SFun(VK_Fun.getValue() + 1); ///< SFunction (self) parameter

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VariableKind valueOf(int val) {
      VariableKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VariableKind[] VALUES;
      private static final VariableKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VariableKind kind : VariableKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VariableKind[min < 0 ? (1-min) : 0];
        VALUES = new VariableKind[max >= 0 ? (1+max) : 0];
        for (VariableKind kind : VariableKind.values()) {
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
    private VariableKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((VariableKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((VariableKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::Variable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 355,
   FQN="clang::threadSafety::til::Variable::Variable", NM="_ZN5clang12threadSafety3til8VariableC1EN4llvm9StringRefEPNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8VariableC1EN4llvm9StringRefEPNS1_5SExprE")
  //</editor-fold>
  public Variable(StringRef s) {
    this(s, (SExpr /*P*/ )null);
  }
  public Variable(StringRef s, SExpr /*P*/ D/*= null*/) {
    // : SExpr(COP_Variable), Name(s), Definition(D), Cvdecl(null) 
    //START JInit
    super(TIL_Opcode.COP_Variable);
    this.Name = new StringRef(s);
    this.Definition = D;
    this.Cvdecl = null;
    //END JInit
    Flags = $uint2ushort(VariableKind.VK_Let.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::Variable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 359,
   FQN="clang::threadSafety::til::Variable::Variable", NM="_ZN5clang12threadSafety3til8VariableC1EPNS1_5SExprEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8VariableC1EPNS1_5SExprEPKNS_9ValueDeclE")
  //</editor-fold>
  public Variable(SExpr /*P*/ D) {
    this(D, (/*const*/ ValueDecl /*P*/ )null);
  }
  public Variable(SExpr /*P*/ D, /*const*/ ValueDecl /*P*/ Cvd/*= null*/) {
    // : SExpr(COP_Variable), Name(Cvd ? Cvd->getName() : "_x"), Definition(D), Cvdecl(Cvd) 
    //START JInit
    super(TIL_Opcode.COP_Variable);
    this.Name = (Cvd != null) ? Cvd.getName() : new StringRef(/*KEEP_STR*/"_x");
    this.Definition = D;
    this.Cvdecl = Cvd;
    //END JInit
    Flags = $uint2ushort(VariableKind.VK_Let.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::Variable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 364,
   FQN="clang::threadSafety::til::Variable::Variable", NM="_ZN5clang12threadSafety3til8VariableC1ERKS2_PNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8VariableC1ERKS2_PNS1_5SExprE")
  //</editor-fold>
  public Variable(final /*const*/ Variable /*&*/ Vd, SExpr /*P*/ D) {
    // : SExpr(Vd), Name(Vd.Name), Definition(D), Cvdecl(Vd.Cvdecl) 
    //START JInit
    // rewrite constructor
    super(Vd);
    this.Name = new StringRef(Vd.Name);
    this.Definition = D;
    this.Cvdecl = Vd.Cvdecl;
    //END JInit
    Flags = $uint2ushort(Vd.kind().getValue());
  }

  
  /// Return the kind of variable (let, function param, or self)
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 370,
   FQN="clang::threadSafety::til::Variable::kind", NM="_ZNK5clang12threadSafety3til8Variable4kindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8Variable4kindEv")
  //</editor-fold>
  public VariableKind kind() /*const*/ {
    return /*static_cast*/VariableKind.valueOf(Flags);
  }

  
  /// Return the name of the variable, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::name">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 373,
   FQN="clang::threadSafety::til::Variable::name", NM="_ZNK5clang12threadSafety3til8Variable4nameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8Variable4nameEv")
  //</editor-fold>
  public StringRef name() /*const*/ {
    return new StringRef(Name);
  }

  
  /// Return the clang declaration for this variable, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::clangDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 376,
   FQN="clang::threadSafety::til::Variable::clangDecl", NM="_ZNK5clang12threadSafety3til8Variable9clangDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8Variable9clangDeclEv")
  //</editor-fold>
  public /*const*/ ValueDecl /*P*/ clangDecl() /*const*/ {
    return Cvdecl;
  }

  
  /// Return the definition of the variable.
  /// For let-vars, this is the setting expression.
  /// For function and self parameters, it is the type of the variable.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::definition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 381,
   FQN="clang::threadSafety::til::Variable::definition", NM="_ZN5clang12threadSafety3til8Variable10definitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Variable10definitionEv")
  //</editor-fold>
  public SExpr /*P*/ definition() {
    return Definition;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::definition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 382,
   FQN="clang::threadSafety::til::Variable::definition", NM="_ZNK5clang12threadSafety3til8Variable10definitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZNK5clang12threadSafety3til8Variable10definitionEv")
  //</editor-fold>
  public /*const*/ SExpr /*P*/ definition$Const() /*const*/ {
    return Definition;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::setName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 384,
   FQN="clang::threadSafety::til::Variable::setName", NM="_ZN5clang12threadSafety3til8Variable7setNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Variable7setNameEN4llvm9StringRefE")
  //</editor-fold>
  public void setName(StringRef S) {
    Name.$assign(S);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::setKind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 385,
   FQN="clang::threadSafety::til::Variable::setKind", NM="_ZN5clang12threadSafety3til8Variable7setKindENS2_12VariableKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Variable7setKindENS2_12VariableKindE")
  //</editor-fold>
  public void setKind(VariableKind K) {
    Flags = $uint2ushort(K.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::setDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 386,
   FQN="clang::threadSafety::til::Variable::setDefinition", NM="_ZN5clang12threadSafety3til8Variable13setDefinitionEPNS1_5SExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Variable13setDefinitionEPNS1_5SExprE")
  //</editor-fold>
  public void setDefinition(SExpr /*P*/ E) {
    Definition = E;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::setClangDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 387,
   FQN="clang::threadSafety::til::Variable::setClangDecl", NM="_ZN5clang12threadSafety3til8Variable12setClangDeclEPKNS_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til8Variable12setClangDeclEPKNS_9ValueDeclE")
  //</editor-fold>
  public void setClangDecl(/*const*/ ValueDecl /*P*/ VD) {
    Cvdecl = VD;
  }

  
  /*template <class V> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::traverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 390,
   FQN="clang::threadSafety::til::Variable::traverse", NM="Tpl__ZN5clang12threadSafety3til8Variable8traverseERT_NS3_5R_CtxE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZN5clang12threadSafety3til8Variable8traverseERT_NS3_5R_CtxE")
  //</editor-fold>
  public </*class*/ V extends VisitReducer> boolean/*V.R_SExpr*/ traverse(final V /*&*/ Vs, SimpleReducerBase.TraversalKind/*V.R_Ctx*/ Ctx) {
    // This routine is only called for variable references.
    return Vs.reduceVariableRef(this) != null;
  }

  
  /*template <class C> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::Variable::compare">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 396,
   FQN="clang::threadSafety::til::Variable::compare", NM="Tpl__ZNK5clang12threadSafety3til8Variable7compareEPKS2_RT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=Tpl__ZNK5clang12threadSafety3til8Variable7compareEPKS2_RT_")
  //</editor-fold>
  public </*class*/ C extends Comparator<?>> boolean/*C.CType*/ compare(/*const*/ Variable /*P*/ E, final C /*&*/ Cmp) /*const*/ {
    return Cmp.compareVariableRefs(this, E);
  }

/*private:*/
  /*friend  class Function*/
  /*friend  class SFunction*/
  /*friend  class BasicBlock*/
  /*friend  class Let*/
  
  private StringRef Name; // The name of the variable.
  /*friend*/protected/*private*/ SExpr /*P*/ Definition; // The TIL type or definition
  private /*const*/ ValueDecl /*P*/ Cvdecl; // The clang declaration for this variable.
  
  @Override public String toString() {
    return "" + "Name=" + Name // NOI18N
              + ", Definition=" + Definition // NOI18N
              + ", Cvdecl=" + Cvdecl // NOI18N
              + super.toString(); // NOI18N
  }
}
