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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.StmtIteratorStatics.*;

//<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 30,
 FQN="clang::StmtIteratorBase", NM="_ZN5clang16StmtIteratorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseE")
//</editor-fold>
public class StmtIteratorBase {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 32,
   FQN="clang::StmtIteratorBase::(anonymous)", NM="_ZN5clang16StmtIteratorBaseE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int StmtMode = 0x0;
    public static final /*uint*/int SizeOfTypeVAMode = 0x1;
    public static final /*uint*/int DeclGroupMode = 0x2;
    public static final /*uint*/int Flags = 0x3;
  /*}*/;
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 35,
   FQN="clang::StmtIteratorBase::(anonymous)", NM="_ZN5clang16StmtIteratorBaseE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseE_Unnamed_union1")
  //</editor-fold>
  protected static class/*union*/ Unnamed_union1 {
    public type$iterator<?, Stmt /*P*/ /*P*/> stmt = create_type$null$ptr();
    public type$iterator<?, Decl /*P*/ /*P*/> DGI = create_type$null$ptr();
    
    //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 35,
     FQN="clang::StmtIteratorBase::(anonymous union)::", NM="_ZN5clang16StmtIteratorBaseUt0_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseUt0_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
      this.stmt = $tryClone($Prm0.stmt);
      this.DGI = $tryClone($Prm0.DGI);
    }


    //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 35,
     FQN="clang::StmtIteratorBase::(anonymous union)::", NM="_ZN5clang16StmtIteratorBaseUt0_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN5clang16StmtIteratorBaseUt0_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
      this.stmt = $Prm0.stmt;
      this.DGI = $Prm0.DGI;
      $Prm0.stmt = null;
      $Prm0.DGI = null;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 35,
     FQN="clang::StmtIteratorBase::(anonymous union)::operator=", NM="_ZN5clang16StmtIteratorBaseUt0_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN5clang16StmtIteratorBaseUt0_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
      
      this.stmt = $tryClone($Prm0.stmt);
      
      this.DGI = $tryClone($Prm0.DGI);
      
      return /*Deref*/this;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 35,
     FQN="clang::StmtIteratorBase::(anonymous union)::operator=", NM="_ZN5clang16StmtIteratorBaseUt0_aSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang16StmtIteratorBaseUt0_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
      assert this != $Prm0;
      this.stmt = $tryClone($Prm0.stmt);
      
      this.DGI = $tryClone($Prm0.DGI);
      
      $Prm0.stmt = null;
      $Prm0.DGI = null;
      
      return /*Deref*/this;
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public Unnamed_union1() { }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "stmt=" + stmt // NOI18N
                + ", DGI=" + DGI; // NOI18N
    }
  };
  protected Unnamed_union1 Unnamed_field = new Unnamed_union1();
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  protected Object/*uintptr_t*/ RawVAPtr$Ptr;
  protected int/*uintptr_t*/ RawVAPtr$Flags;
  protected type$ptr<Decl /*P*/ /*P*/> DGE;
  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::inDeclGroup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 42,
   FQN="clang::StmtIteratorBase::inDeclGroup", NM="_ZNK5clang16StmtIteratorBase11inDeclGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorBase11inDeclGroupEv")
  //</editor-fold>
  protected boolean inDeclGroup() /*const*/ {
    return (RawVAPtr$Flags & Flags) == DeclGroupMode;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::inSizeOfTypeVA">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 46,
   FQN="clang::StmtIteratorBase::inSizeOfTypeVA", NM="_ZNK5clang16StmtIteratorBase14inSizeOfTypeVAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorBase14inSizeOfTypeVAEv")
  //</editor-fold>
  protected boolean inSizeOfTypeVA() /*const*/ {
    return (RawVAPtr$Flags & Flags) == SizeOfTypeVAMode;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::inStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 50,
   FQN="clang::StmtIteratorBase::inStmt", NM="_ZNK5clang16StmtIteratorBase6inStmtEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorBase6inStmtEv")
  //</editor-fold>
  protected boolean inStmt() /*const*/ {
    return (RawVAPtr$Flags & Flags) == StmtMode;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::getVAPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 54,
   FQN="clang::StmtIteratorBase::getVAPtr", NM="_ZNK5clang16StmtIteratorBase8getVAPtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorBase8getVAPtrEv")
  //</editor-fold>
  protected /*const*/ VariableArrayType /*P*/ getVAPtr() /*const*/ {
    return reinterpret_cast(/*const*/ VariableArrayType /*P*/ .class, RawVAPtr$Ptr/* & ~Flags*/);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::setVAPtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 58,
   FQN="clang::StmtIteratorBase::setVAPtr", NM="_ZN5clang16StmtIteratorBase8setVAPtrEPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBase8setVAPtrEPKNS_17VariableArrayTypeE")
  //</editor-fold>
  protected void setVAPtr(/*const*/ VariableArrayType /*P*/ P) {
    assert (inDeclGroup() || inSizeOfTypeVA());
//    RawVAPtr = reinterpret_cast_Object/*uintptr_t*/(P) | (RawVAPtr & Flags);
    RawVAPtr$Ptr = P;
    RawVAPtr$Flags = RawVAPtr$Flags & Flags;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::NextDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp", line = 56,
   FQN="clang::StmtIteratorBase::NextDecl", NM="_ZN5clang16StmtIteratorBase8NextDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBase8NextDeclEb")
  //</editor-fold>
  protected void NextDecl() {
    NextDecl(true);
  }
  protected void NextDecl(boolean ImmediateAdvance/*= true*/) {
    assert (getVAPtr() == null);
    assert (inDeclGroup());
    if (ImmediateAdvance) {
      Unnamed_field.DGI.$preInc();
    }
    
    for (; $noteq_ptr(Unnamed_field.DGI, DGE); Unnamed_field.DGI.$preInc())  {
      if (HandleDecl(Unnamed_field.DGI.$star())) {
        return;
      }
    }
    
    RawVAPtr$Ptr = null;
    RawVAPtr$Flags = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::HandleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp", line = 70,
   FQN="clang::StmtIteratorBase::HandleDecl", NM="_ZN5clang16StmtIteratorBase10HandleDeclEPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBase10HandleDeclEPNS_4DeclE")
  //</editor-fold>
  protected boolean HandleDecl(Decl /*P*/ D) {
    {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        {
          /*const*/ VariableArrayType /*P*/ VAPtr = FindVA(VD.getType().getTypePtr());
          if ((VAPtr != null)) {
            setVAPtr(VAPtr);
            return true;
          }
        }
        if ((VD.getInit() != null)) {
          return true;
        }
      } else {
        TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
        if ((TD != null)) {
          {
            /*const*/ VariableArrayType /*P*/ VAPtr = FindVA(TD.getUnderlyingType().getTypePtr());
            if ((VAPtr != null)) {
              setVAPtr(VAPtr);
              return true;
            }
          }
        } else {
          EnumConstantDecl /*P*/ ECD = dyn_cast_EnumConstantDecl(D);
          if ((ECD != null)) {
            if ((ECD.getInitExpr() != null)) {
              return true;
            }
          }
        }
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::NextVA">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp", line = 33,
   FQN="clang::StmtIteratorBase::NextVA", NM="_ZN5clang16StmtIteratorBase6NextVAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBase6NextVAEv")
  //</editor-fold>
  protected void NextVA() {
    assert Native.$bool(getVAPtr());
    
    /*const*/ VariableArrayType /*P*/ p = getVAPtr();
    p = FindVA(p.getElementType().getTypePtr());
    setVAPtr(p);
    if ((p != null)) {
      return;
    }
    if (inDeclGroup()) {
      {
        VarDecl /*P*/ VD = dyn_cast_VarDecl(Unnamed_field.DGI.$star());
        if ((VD != null)) {
          if (VD.hasInit()) {
            return;
          }
        }
      }
      
      NextDecl();
    } else {
      assert (inSizeOfTypeVA());
      RawVAPtr$Ptr = null;
      RawVAPtr$Flags = 0;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::GetDeclExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp", line = 105,
   FQN="clang::StmtIteratorBase::GetDeclExpr", NM="_ZNK5clang16StmtIteratorBase11GetDeclExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZNK5clang16StmtIteratorBase11GetDeclExprEv")
  //</editor-fold>
  protected type$ptr<Stmt /*P*/ /*&*/> GetDeclExpr() /*const*/ {
    {
      /*const*/ VariableArrayType /*P*/ VAPtr = getVAPtr();
      if ((VAPtr != null)) {
        assert Native.$bool(VAPtr.SizeExpr);
        return /*AddrOf*/new type$ptr$inout<Stmt /*P*/>(this) {
            @Override public Stmt/*P*/ $star$impl() { return VAPtr.SizeExpr; }
            @Override public Stmt/*P*/ $set$impl(Stmt/*P*/ value) { return VAPtr.SizeExpr = value; }
          };        
      }
    }
    assert (inDeclGroup());
    VarDecl /*P*/ VD = cast_VarDecl(Unnamed_field.DGI.$star());
    return VD.getInitAddress()/*.$star()*/;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::StmtIteratorBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 69,
   FQN="clang::StmtIteratorBase::StmtIteratorBase", NM="_ZN5clang16StmtIteratorBaseC1EPPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseC1EPPNS_4StmtE")
  //</editor-fold>
  protected StmtIteratorBase(type$iterator<?, Stmt /*P*/ /*P*/> s) {
    // : stmt(s), RawVAPtr(0) 
    //START JInit
    /*Indirect*/this.Unnamed_field.stmt = $tryClone(s);
    RawVAPtr$Ptr = null;
    RawVAPtr$Flags = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::StmtIteratorBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp", line = 100,
   FQN="clang::StmtIteratorBase::StmtIteratorBase", NM="_ZN5clang16StmtIteratorBaseC1EPKNS_17VariableArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseC1EPKNS_17VariableArrayTypeE")
  //</editor-fold>
  protected StmtIteratorBase(/*const*/ VariableArrayType /*P*/ t) {
    // : DGI(null), RawVAPtr(SizeOfTypeVAMode) 
    //START JInit
    /*Indirect*/this.Unnamed_field.DGI = null;
    this.RawVAPtr$Flags = SizeOfTypeVAMode;
    //END JInit
    RawVAPtr$Ptr = reinterpret_cast_Object/*uintptr_t*/(t);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::StmtIteratorBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp", line = 95,
   FQN="clang::StmtIteratorBase::StmtIteratorBase", NM="_ZN5clang16StmtIteratorBaseC1EPPNS_4DeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseC1EPPNS_4DeclES3_")
  //</editor-fold>
  protected StmtIteratorBase(type$iterator<?, Decl /*P*/ /*P*/> dgi, type$ptr<Decl /*P*/ /*P*/> dge) {
    // : DGI(dgi), RawVAPtr(DeclGroupMode), DGE(dge) 
    //START JInit
    /*Indirect*/this.Unnamed_field.DGI = $tryClone(dgi);
    this.RawVAPtr$Flags = DeclGroupMode;
    this.DGE = $tryClone(dge);
    //END JInit
    NextDecl(false);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::StmtIteratorBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 72,
   FQN="clang::StmtIteratorBase::StmtIteratorBase", NM="_ZN5clang16StmtIteratorBaseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseC1Ev")
  //</editor-fold>
  protected StmtIteratorBase() {
    // : stmt(null), RawVAPtr(0) 
    //START JInit
    /*Indirect*/this.Unnamed_field.stmt = null;
    this.RawVAPtr$Ptr = null;
    this.RawVAPtr$Flags = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::StmtIteratorBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 30,
   FQN="clang::StmtIteratorBase::StmtIteratorBase", NM="_ZN5clang16StmtIteratorBaseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp -nm=_ZN5clang16StmtIteratorBaseC1ERKS0_")
  //</editor-fold>
  public /*inline*/ StmtIteratorBase(final /*const*/ StmtIteratorBase /*&*/ $Prm0) {
    // : Unnamed_field(.), RawVAPtr(.RawVAPtr), DGE(.DGE) 
    //START JInit
    this.Unnamed_field = new Unnamed_union1($Prm0.Unnamed_field);
    this.RawVAPtr$Flags = $Prm0.RawVAPtr$Flags;
    this.RawVAPtr$Ptr = $Prm0.RawVAPtr$Ptr;
    this.DGE = $tryClone($Prm0.DGE);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::StmtIteratorBase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 30,
   FQN="clang::StmtIteratorBase::StmtIteratorBase", NM="_ZN5clang16StmtIteratorBaseC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN5clang16StmtIteratorBaseC1EOS0_")
  //</editor-fold>
  public /*inline*/ StmtIteratorBase(JD$Move _dparam, final StmtIteratorBase /*&&*/$Prm0) {
    // : Unnamed_field(static_cast<StmtIteratorBase &&>().), RawVAPtr(static_cast<StmtIteratorBase &&>().RawVAPtr), DGE(static_cast<StmtIteratorBase &&>().DGE) 
    //START JInit
    this.Unnamed_field = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field);
    this.RawVAPtr$Flags = $Prm0.RawVAPtr$Flags;
    this.RawVAPtr$Ptr = $Prm0.RawVAPtr$Ptr;
    this.DGE = $Prm0.DGE;
    //END JInit
    $Prm0.Unnamed_field=null;
    $Prm0.RawVAPtr$Flags = 0;
    $Prm0.RawVAPtr$Flags = 0;
    $Prm0.DGE = null;    
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 30,
   FQN="clang::StmtIteratorBase::operator=", NM="_ZN5clang16StmtIteratorBaseaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZN5clang16StmtIteratorBaseaSEOS0_")
  //</editor-fold>
  public /*inline*/ StmtIteratorBase /*&*/ $assignMove(final StmtIteratorBase /*&&*/$Prm0) {
    this.Unnamed_field = $Prm0.Unnamed_field;
    this.RawVAPtr$Flags = $Prm0.RawVAPtr$Flags;
    this.RawVAPtr$Ptr = $Prm0.RawVAPtr$Ptr;
    this.DGE = $Prm0.DGE;
    $Prm0.Unnamed_field=null;
    $Prm0.RawVAPtr$Flags = 0;
    $Prm0.RawVAPtr$Flags = 0;
    $Prm0.DGE = null;    
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::StmtIteratorBase::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtIterator.h", line = 30,
   FQN="clang::StmtIteratorBase::operator=", NM="_ZN5clang16StmtIteratorBaseaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/TransAutoreleasePool.cpp -nm=_ZN5clang16StmtIteratorBaseaSERKS0_")
  //</editor-fold>
  public /*inline*/ StmtIteratorBase /*&*/ $assign(final /*const*/ StmtIteratorBase /*&*/ $Prm0) {
    this.Unnamed_field = $tryClone($Prm0.Unnamed_field);
    this.RawVAPtr$Flags = $Prm0.RawVAPtr$Flags;
    this.RawVAPtr$Ptr = $Prm0.RawVAPtr$Ptr;
    this.DGE = $tryClone($Prm0.DGE);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Unnamed_field=" + Unnamed_field // NOI18N
              + ", RawVAPtr=[" + RawVAPtr$Flags + "]" + RawVAPtr$Ptr // NOI18N
              + ", DGE=" + DGE; // NOI18N
  }
}
