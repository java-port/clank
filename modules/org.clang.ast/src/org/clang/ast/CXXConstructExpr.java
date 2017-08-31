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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

/// \brief Represents a call to a C++ constructor.
//<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1162,
 FQN="clang::CXXConstructExpr", NM="_ZN5clang16CXXConstructExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExprE")
//</editor-fold>
public class CXXConstructExpr extends /*public*/ Expr {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::ConstructionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1164,
   FQN="clang::CXXConstructExpr::ConstructionKind", NM="_ZN5clang16CXXConstructExpr16ConstructionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr16ConstructionKindE")
  //</editor-fold>
  public enum ConstructionKind implements Native.ComparableLower {
    CK_Complete(0),
    CK_NonVirtualBase(CK_Complete.getValue() + 1),
    CK_VirtualBase(CK_NonVirtualBase.getValue() + 1),
    CK_Delegating(CK_VirtualBase.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ConstructionKind valueOf(int val) {
      ConstructionKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ConstructionKind[] VALUES;
      private static final ConstructionKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ConstructionKind kind : ConstructionKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ConstructionKind[min < 0 ? (1-min) : 0];
        VALUES = new ConstructionKind[max >= 0 ? (1+max) : 0];
        for (ConstructionKind kind : ConstructionKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ConstructionKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ConstructionKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ConstructionKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private CXXConstructorDecl /*P*/ Constructor;
  
  private SourceLocation Loc;
  /*friend*/public SourceRange ParenOrBraceRange;
  /*friend*/public /*JCHAR unsigned int*/ char NumArgs /*: 16*/;
  private /*JBIT unsigned int*/ boolean Elidable /*: 1*/;
  private /*JBIT unsigned int*/ boolean HadMultipleCandidates /*: 1*/;
  private /*JBIT unsigned int*/ boolean ListInitialization /*: 1*/;
  private /*JBIT unsigned int*/ boolean StdInitListInitialization /*: 1*/;
  private /*JBIT unsigned int*/ boolean ZeroInitialization /*: 1*/;
  private /*JBYTE unsigned int*/ byte ConstructKind /*: 2*/;
  /*friend*/public type$ptr<Stmt /*P*/ /*P*/> Args;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1185,
   FQN="clang::CXXConstructExpr::setConstructor", NM="_ZN5clang16CXXConstructExpr14setConstructorEPNS_18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr14setConstructorEPNS_18CXXConstructorDeclE")
  //</editor-fold>
  /*friend*/public void setConstructor(CXXConstructorDecl /*P*/ C) {
    Constructor = C;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::CXXConstructExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 770,
   FQN="clang::CXXConstructExpr::CXXConstructExpr", NM="_ZN5clang16CXXConstructExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassENS_8QualTypeENS_14SourceLocationEPNS_18CXXConstructorDeclEbN4llvm8ArrayRefIPNS_4ExprEEEbbbbNS0_16ConstructionKindENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExprC1ERKNS_10ASTContextENS_4Stmt9StmtClassENS_8QualTypeENS_14SourceLocationEPNS_18CXXConstructorDeclEbN4llvm8ArrayRefIPNS_4ExprEEEbbbbNS0_16ConstructionKindENS_11SourceRangeE")
  //</editor-fold>
  protected CXXConstructExpr(final /*const*/ ASTContext /*&*/ C, StmtClass SC, 
      QualType T, SourceLocation Loc, 
      CXXConstructorDecl /*P*/ Ctor, 
      boolean Elidable, 
      ArrayRef<Expr /*P*/ > Args, 
      boolean HadMultipleCandidates, 
      boolean ListInitialization, 
      boolean StdInitListInitialization, 
      boolean ZeroInitialization, 
      ConstructionKind ConstructKind, 
      SourceRange ParenOrBraceRange) {
    // : Expr(SC, T, VK_RValue, OK_Ordinary, T->isDependentType(), T->isDependentType(), T->isInstantiationDependentType(), T->containsUnexpandedParameterPack()), Constructor(Ctor), Loc(Loc), ParenOrBraceRange(ParenOrBraceRange), NumArgs(Args.size()), Elidable(Elidable), HadMultipleCandidates(HadMultipleCandidates), ListInitialization(ListInitialization), StdInitListInitialization(StdInitListInitialization), ZeroInitialization(ZeroInitialization), ConstructKind(ConstructKind), Args(null) 
    //START JInit
    super(SC, new QualType(T), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
        T.$arrow().isDependentType(), T.$arrow().isDependentType(), 
        T.$arrow().isInstantiationDependentType(), 
        T.$arrow().containsUnexpandedParameterPack());
    this.Constructor = Ctor;
    this.Loc = new SourceLocation(Loc);
    this.ParenOrBraceRange = new SourceRange(ParenOrBraceRange);
    this.NumArgs = $uint2uint_16bits(Args.size());
    this.Elidable = Elidable;
    this.HadMultipleCandidates = HadMultipleCandidates;
    this.ListInitialization = ListInitialization;
    this.StdInitListInitialization = StdInitListInitialization;
    this.ZeroInitialization = ZeroInitialization;
    this.ConstructKind = $uint2uint_2bits(ConstructKind.getValue());
    this.Args = create_type$null$ptr();
    //END JInit
    if ((NumArgs != 0)) {
      this.Args = create_type$ptr(/*FIXME:NEW_EXPR*//*new (C)*/ new Stmt /*P*/ [Args.size()]);
      
      for (/*uint*/int i = 0; i != Args.size(); ++i) {
        assert ((Args.$at(i) != null)) : "NULL argument in CXXConstructExpr";
        if (Args.$at(i).isValueDependent()) {
          Unnamed_field.ExprBits.ValueDependent = true;
        }
        if (Args.$at(i).isInstantiationDependent()) {
          Unnamed_field.ExprBits.InstantiationDependent = true;
        }
        if (Args.$at(i).containsUnexpandedParameterPack()) {
          Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = true;
        }
        
        this.Args.$set(i, Args.$at(i));
      }
    }
  }

  
  /// \brief Construct an empty C++ construction expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::CXXConstructExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1201,
   FQN="clang::CXXConstructExpr::CXXConstructExpr", NM="_ZN5clang16CXXConstructExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExprC1ENS_4Stmt9StmtClassENS1_10EmptyShellE")
  //</editor-fold>
  protected CXXConstructExpr(StmtClass SC, EmptyShell Empty) {
    // : Expr(SC, Empty), Constructor(null), Loc(), ParenOrBraceRange(), NumArgs(0), Elidable(false), HadMultipleCandidates(false), ListInitialization(false), ZeroInitialization(false), ConstructKind(0), Args(null) 
    //START JInit
    super(SC, new EmptyShell(Empty));
    this.Constructor = null;
    this.Loc = new SourceLocation();
    this.ParenOrBraceRange = new SourceRange();
    this.NumArgs = $uint2uint_16bits(0);
    this.Elidable = false;
    this.HadMultipleCandidates = false;
    this.ListInitialization = false;
    this.ZeroInitialization = false;
    this.ConstructKind = $uint2uint_2bits(0);
    this.Args = create_type$null$ptr();
    //END JInit
  }

/*public:*/
  /// \brief Construct an empty C++ construction expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::CXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1209,
   FQN="clang::CXXConstructExpr::CXXConstructExpr", NM="_ZN5clang16CXXConstructExprC1ENS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExprC1ENS_4Stmt10EmptyShellE")
  //</editor-fold>
  public /*explicit*/ CXXConstructExpr(EmptyShell Empty) {
    // : CXXConstructExpr(CXXConstructExprClass, Empty) 
    //START JInit
    this(StmtClass.CXXConstructExprClass, new EmptyShell(Empty));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 751,
   FQN="clang::CXXConstructExpr::Create", NM="_ZN5clang16CXXConstructExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_14SourceLocationEPNS_18CXXConstructorDeclEbN4llvm8ArrayRefIPNS_4ExprEEEbbbbNS0_16ConstructionKindENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr6CreateERKNS_10ASTContextENS_8QualTypeENS_14SourceLocationEPNS_18CXXConstructorDeclEbN4llvm8ArrayRefIPNS_4ExprEEEbbbbNS0_16ConstructionKindENS_11SourceRangeE")
  //</editor-fold>
  public static CXXConstructExpr /*P*/ Create(final /*const*/ ASTContext /*&*/ C, QualType T, 
        SourceLocation Loc, 
        CXXConstructorDecl /*P*/ Ctor, 
        boolean Elidable, 
        ArrayRef<Expr /*P*/ > Args, 
        boolean HadMultipleCandidates, 
        boolean ListInitialization, 
        boolean StdInitListInitialization, 
        boolean ZeroInitialization, 
        ConstructionKind ConstructKind, 
        SourceRange ParenOrBraceRange) {
    return /*NEW_EXPR [Stmt::new]*//*new (C)*/ Stmt.$new_uint_ASTContext$C_uint(C, (type$ptr<?> Mem)->{
        return new CXXConstructExpr(C, StmtClass.CXXConstructExprClass, new QualType(T), new SourceLocation(Loc), 
                Ctor, Elidable, new ArrayRef<Expr /*P*/ >(Args), 
                HadMultipleCandidates, ListInitialization, 
                StdInitListInitialization, 
                ZeroInitialization, ConstructKind, 
                new SourceRange(ParenOrBraceRange));
     });
  }

  
  /// \brief Get the constructor that this expression will (ultimately) call.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getConstructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1225,
   FQN="clang::CXXConstructExpr::getConstructor", NM="_ZNK5clang16CXXConstructExpr14getConstructorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr14getConstructorEv")
  //</editor-fold>
  public CXXConstructorDecl /*P*/ getConstructor() /*const*/ {
    return Constructor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1227,
   FQN="clang::CXXConstructExpr::getLocation", NM="_ZNK5clang16CXXConstructExpr11getLocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1228,
   FQN="clang::CXXConstructExpr::setLocation", NM="_ZN5clang16CXXConstructExpr11setLocationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr11setLocationENS_14SourceLocationE")
  //</editor-fold>
  public void setLocation(SourceLocation Loc) {
    this.Loc.$assign(Loc);
  }

  
  /// \brief Whether this construction is elidable.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::isElidable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1231,
   FQN="clang::CXXConstructExpr::isElidable", NM="_ZNK5clang16CXXConstructExpr10isElidableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr10isElidableEv")
  //</editor-fold>
  public boolean isElidable() /*const*/ {
    return Elidable;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setElidable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1232,
   FQN="clang::CXXConstructExpr::setElidable", NM="_ZN5clang16CXXConstructExpr11setElidableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr11setElidableEb")
  //</editor-fold>
  public void setElidable(boolean E) {
    Elidable = E;
  }

  
  /// \brief Whether the referred constructor was resolved from
  /// an overloaded set having size greater than 1.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::hadMultipleCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1236,
   FQN="clang::CXXConstructExpr::hadMultipleCandidates", NM="_ZNK5clang16CXXConstructExpr21hadMultipleCandidatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr21hadMultipleCandidatesEv")
  //</editor-fold>
  public boolean hadMultipleCandidates() /*const*/ {
    return HadMultipleCandidates;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setHadMultipleCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1237,
   FQN="clang::CXXConstructExpr::setHadMultipleCandidates", NM="_ZN5clang16CXXConstructExpr24setHadMultipleCandidatesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr24setHadMultipleCandidatesEb")
  //</editor-fold>
  public void setHadMultipleCandidates(boolean V) {
    HadMultipleCandidates = V;
  }

  
  /// \brief Whether this constructor call was written as list-initialization.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::isListInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1240,
   FQN="clang::CXXConstructExpr::isListInitialization", NM="_ZNK5clang16CXXConstructExpr20isListInitializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr20isListInitializationEv")
  //</editor-fold>
  public boolean isListInitialization() /*const*/ {
    return ListInitialization;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setListInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1241,
   FQN="clang::CXXConstructExpr::setListInitialization", NM="_ZN5clang16CXXConstructExpr21setListInitializationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr21setListInitializationEb")
  //</editor-fold>
  public void setListInitialization(boolean V) {
    ListInitialization = V;
  }

  
  /// \brief Whether this constructor call was written as list-initialization,
  /// but was interpreted as forming a std::initializer_list<T> from the list
  /// and passing that as a single constructor argument.
  /// See C++11 [over.match.list]p1 bullet 1.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::isStdInitListInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1247,
   FQN="clang::CXXConstructExpr::isStdInitListInitialization", NM="_ZNK5clang16CXXConstructExpr27isStdInitListInitializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr27isStdInitListInitializationEv")
  //</editor-fold>
  public boolean isStdInitListInitialization() /*const*/ {
    return StdInitListInitialization;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setStdInitListInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1248,
   FQN="clang::CXXConstructExpr::setStdInitListInitialization", NM="_ZN5clang16CXXConstructExpr28setStdInitListInitializationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr28setStdInitListInitializationEb")
  //</editor-fold>
  public void setStdInitListInitialization(boolean V) {
    StdInitListInitialization = V;
  }

  
  /// \brief Whether this construction first requires
  /// zero-initialization before the initializer is called.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::requiresZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1252,
   FQN="clang::CXXConstructExpr::requiresZeroInitialization", NM="_ZNK5clang16CXXConstructExpr26requiresZeroInitializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr26requiresZeroInitializationEv")
  //</editor-fold>
  public boolean requiresZeroInitialization() /*const*/ {
    return ZeroInitialization;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setRequiresZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1253,
   FQN="clang::CXXConstructExpr::setRequiresZeroInitialization", NM="_ZN5clang16CXXConstructExpr29setRequiresZeroInitializationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr29setRequiresZeroInitializationEb")
  //</editor-fold>
  public void setRequiresZeroInitialization(boolean ZeroInit) {
    ZeroInitialization = ZeroInit;
  }

  
  /// \brief Determine whether this constructor is actually constructing
  /// a base class (rather than a complete object).
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getConstructionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1259,
   FQN="clang::CXXConstructExpr::getConstructionKind", NM="_ZNK5clang16CXXConstructExpr19getConstructionKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr19getConstructionKindEv")
  //</editor-fold>
  public ConstructionKind getConstructionKind() /*const*/ {
    return ConstructionKind.valueOf(ConstructKind);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setConstructionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1262,
   FQN="clang::CXXConstructExpr::setConstructionKind", NM="_ZN5clang16CXXConstructExpr19setConstructionKindENS0_16ConstructionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr19setConstructionKindENS0_16ConstructionKindE")
  //</editor-fold>
  public void setConstructionKind(ConstructionKind CK) {
    ConstructKind = $uint2uint_2bits(CK.getValue());
  }

  
  /*typedef ExprIterator arg_iterator*/
//  public final class arg_iterator extends ExprIterator{ };
  /*typedef ConstExprIterator const_arg_iterator*/
//  public final class const_arg_iterator extends ConstExprIterator{ };
  /*typedef llvm::iterator_range<arg_iterator> arg_range*/
//  public final class arg_range extends iterator_range<Expr /*P*/ >{ };
  /*typedef llvm::iterator_range<const_arg_iterator> arg_const_range*/
//  public final class arg_const_range extends iterator_range</*const*/ Expr /*P*/ /*const*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1271,
   FQN="clang::CXXConstructExpr::arguments", NM="_ZN5clang16CXXConstructExpr9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr9argumentsEv")
  //</editor-fold>
  public iterator_range<Expr /*P*/ > arguments() {
    return new iterator_range<Expr /*P*/ >(arg_begin(), arg_end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1272,
   FQN="clang::CXXConstructExpr::arguments", NM="_ZNK5clang16CXXConstructExpr9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr9argumentsEv")
  //</editor-fold>
  public iterator_range</*const*/ Expr /*P*/ /*const*/> arguments$Const() /*const*/ {
    return new iterator_range</*const*/ Expr /*P*/ /*const*/>(arg_begin$Const(), arg_end$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1276,
   FQN="clang::CXXConstructExpr::arg_begin", NM="_ZN5clang16CXXConstructExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr9arg_beginEv")
  //</editor-fold>
  public ExprIterator arg_begin() {
    return new ExprIterator(Args);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1277,
   FQN="clang::CXXConstructExpr::arg_end", NM="_ZN5clang16CXXConstructExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr7arg_endEv")
  //</editor-fold>
  public ExprIterator arg_end() {
    return new ExprIterator(Args.$add(NumArgs));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::arg_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1278,
   FQN="clang::CXXConstructExpr::arg_begin", NM="_ZNK5clang16CXXConstructExpr9arg_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr9arg_beginEv")
  //</editor-fold>
  public ConstExprIterator arg_begin$Const() /*const*/ {
    return new ConstExprIterator(Args);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::arg_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1279,
   FQN="clang::CXXConstructExpr::arg_end", NM="_ZNK5clang16CXXConstructExpr7arg_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr7arg_endEv")
  //</editor-fold>
  public ConstExprIterator arg_end$Const() /*const*/ {
    return new ConstExprIterator(Args.$add(NumArgs));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1281,
   FQN="clang::CXXConstructExpr::getArgs", NM="_ZN5clang16CXXConstructExpr7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr7getArgsEv")
  //</editor-fold>
  public type$ptr<Expr /*P*/ /*P*/> getArgs() {
    return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, Args));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1282,
   FQN="clang::CXXConstructExpr::getArgs", NM="_ZNK5clang16CXXConstructExpr7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr7getArgsEv")
  //</editor-fold>
  public type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> getArgs$Const() /*const*/ {
    return ((/*const_cast*/CXXConstructExpr /*P*/ )(this)).getArgs();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1285,
   FQN="clang::CXXConstructExpr::getNumArgs", NM="_ZNK5clang16CXXConstructExpr10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr10getNumArgsEv")
  //</editor-fold>
  public /*uint*/int getNumArgs() /*const*/ {
    return NumArgs;
  }

  
  /// \brief Return the specified argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1288,
   FQN="clang::CXXConstructExpr::getArg", NM="_ZN5clang16CXXConstructExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr6getArgEj")
  //</editor-fold>
  public Expr /*P*/ getArg(/*uint*/int Arg) {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    return cast_Expr(Args.$at(Arg));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1292,
   FQN="clang::CXXConstructExpr::getArg", NM="_ZNK5clang16CXXConstructExpr6getArgEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr6getArgEj")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getArg$Const(/*uint*/int Arg) /*const*/ {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    return cast_Expr(Args.$at(Arg));
  }

  
  /// \brief Set the specified argument.
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1298,
   FQN="clang::CXXConstructExpr::setArg", NM="_ZN5clang16CXXConstructExpr6setArgEjPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr6setArgEjPNS_4ExprE")
  //</editor-fold>
  public void setArg(/*uint*/int Arg, Expr /*P*/ ArgExpr) {
    assert ($less_uint(Arg, NumArgs)) : "Arg access out of range!";
    Args.$set(Arg, ArgExpr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 407,
   FQN="clang::CXXConstructExpr::getLocStart", NM="_ZNK5clang16CXXConstructExpr11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    if (isa_CXXTemporaryObjectExpr(this)) {
      return cast_CXXTemporaryObjectExpr(this).getLocStart();
    }
    return new SourceLocation(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp", line = 413,
   FQN="clang::CXXConstructExpr::getLocEnd", NM="_ZNK5clang16CXXConstructExpr9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    if (isa_CXXTemporaryObjectExpr(this)) {
      return cast_CXXTemporaryObjectExpr(this).getLocEnd();
    }
    if (ParenOrBraceRange.isValid()) {
      return ParenOrBraceRange.getEnd();
    }
    
    SourceLocation End = new SourceLocation(Loc);
    for (/*uint*/int I = getNumArgs(); $greater_uint(I, 0); --I) {
      /*const*/ Expr /*P*/ Arg = getArg$Const(I - 1);
      if (!Arg.isDefaultArgument()) {
        SourceLocation NewEnd = Arg.getLocEnd();
        if (NewEnd.isValid()) {
          End.$assign(NewEnd);
          break;
        }
      }
    }
    
    return End;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::getParenOrBraceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1305,
   FQN="clang::CXXConstructExpr::getParenOrBraceRange", NM="_ZNK5clang16CXXConstructExpr20getParenOrBraceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZNK5clang16CXXConstructExpr20getParenOrBraceRangeEv")
  //</editor-fold>
  public SourceRange getParenOrBraceRange() /*const*/ {
    return new SourceRange(ParenOrBraceRange);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::setParenOrBraceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1306,
   FQN="clang::CXXConstructExpr::setParenOrBraceRange", NM="_ZN5clang16CXXConstructExpr20setParenOrBraceRangeENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr20setParenOrBraceRangeENS_11SourceRangeE")
  //</editor-fold>
  public void setParenOrBraceRange(SourceRange Range) {
    ParenOrBraceRange.$assign(Range);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1308,
   FQN="clang::CXXConstructExpr::classof", NM="_ZN5clang16CXXConstructExpr7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.CXXConstructExprClass
       || T.getStmtClass() == StmtClass.CXXTemporaryObjectExprClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::CXXConstructExpr::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ExprCXX.h", line = 1314,
   FQN="clang::CXXConstructExpr::children", NM="_ZN5clang16CXXConstructExpr8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang16CXXConstructExpr8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(Args/*.$set$addr(0)*/), new StmtIterator(Args/*.$set$addr(0)*/.$add(NumArgs)));
  }

  
  /*friend  class ASTStmtReader*/
  
  @Override public String toString() {
    return "" + "Constructor=" + Constructor // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", ParenOrBraceRange=" + ParenOrBraceRange // NOI18N
              + ", NumArgs=" + $ushort2uint(NumArgs) // NOI18N
              + ", Elidable=" + Elidable // NOI18N
              + ", HadMultipleCandidates=" + HadMultipleCandidates // NOI18N
              + ", ListInitialization=" + ListInitialization // NOI18N
              + ", StdInitListInitialization=" + StdInitListInitialization // NOI18N
              + ", ZeroInitialization=" + ZeroInitialization // NOI18N
              + ", ConstructKind=" + $uchar2uint(ConstructKind) // NOI18N
              + ", Args=" + Args // NOI18N
              + super.toString(); // NOI18N
  }
}
