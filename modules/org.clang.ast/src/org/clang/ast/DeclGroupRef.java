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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;

//<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 54,
 FQN="clang::DeclGroupRef", NM="_ZN5clang12DeclGroupRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRefE")
//</editor-fold>
public class DeclGroupRef implements Iterable<Decl> {
  // Note this is not a PointerIntPair because we need the address of the
  // non-group case to be valid as a Decl** for iteration.
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 57,
   FQN="clang::DeclGroupRef::Kind", NM="_ZN5clang12DeclGroupRef4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRef4KindE")
  //</editor-fold>
  private static final class/*enum*/ Kind {
    public static final /*uint*/int SingleDeclKind = 0x0;
    public static final /*uint*/int DeclGroupKind = 0x1;
    public static final /*uint*/int Mask = 0x1;
  };
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private Object /*P*/ D;
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private boolean IsDeclGroup;
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::getKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 60,
   FQN="clang::DeclGroupRef::getKind", NM="_ZNK5clang12DeclGroupRef7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef7getKindEv")
  //</editor-fold>
  private /*Kind*//*uint*/int getKind() /*const*/ {
    return IsDeclGroup?1:0;//(/*Kind*//*uint*/int)(reinterpret_cast_Object/*uintptr_t*/(D) & Kind.Mask);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::DeclGroupRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 65,
   FQN="clang::DeclGroupRef::DeclGroupRef", NM="_ZN5clang12DeclGroupRefC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRefC1Ev")
  //</editor-fold>
  public DeclGroupRef() {
    // : D(null) 
    //START JInit
    this.D = null;
    this.IsDeclGroup = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::DeclGroupRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 67,
   FQN="clang::DeclGroupRef::DeclGroupRef", NM="_ZN5clang12DeclGroupRefC1EPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRefC1EPNS_4DeclE")
  //</editor-fold>
  public /*explicit*/ DeclGroupRef(Decl /*P*/ d) {
    // : D(d) 
    //START JInit
    this.D = d;
    this.IsDeclGroup = false;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::DeclGroupRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 68,
   FQN="clang::DeclGroupRef::DeclGroupRef", NM="_ZN5clang12DeclGroupRefC1EPNS_9DeclGroupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRefC1EPNS_9DeclGroupE")
  //</editor-fold>
  public /*explicit*/ DeclGroupRef(DeclGroup /*P*/ dg) {
    // : D((Decl * )(reinterpret_cast<uintptr_t>(dg) | DeclGroupKind)) 
    //START JInit
    this.D = dg;//(Decl /*P*/ )(reinterpret_cast_Object/*uintptr_t*/(dg) | Kind.DeclGroupKind);
    this.IsDeclGroup = true;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 71,
   FQN="clang::DeclGroupRef::Create", NM="_ZN5clang12DeclGroupRef6CreateERNS_10ASTContextEPPNS_4DeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRef6CreateERNS_10ASTContextEPPNS_4DeclEj")
  //</editor-fold>
  public static DeclGroupRef Create(final ASTContext /*&*/ C, type$ptr<Decl /*P*/ /*P*/> Decls, /*uint*/int NumDecls) {
    if (NumDecls == 0) {
      return new DeclGroupRef();
    }
    if (NumDecls == 1) {
      return new DeclGroupRef(Decls.$at(0));
    }
    return new DeclGroupRef(DeclGroup.Create(C, Decls, NumDecls));
  }

  
  /*typedef Decl **iterator*/
//  public final class iterator extends type$ptr<Decl /*P*/ /*P*/>{ };
  /*typedef Decl *const *const_iterator*/
//  public final class const_iterator extends type$ptr<Decl /*P*/ /*const*/ /*P*/>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::isNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 82,
   FQN="clang::DeclGroupRef::isNull", NM="_ZNK5clang12DeclGroupRef6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return D == null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::isSingleDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 83,
   FQN="clang::DeclGroupRef::isSingleDecl", NM="_ZNK5clang12DeclGroupRef12isSingleDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef12isSingleDeclEv")
  //</editor-fold>
  public boolean isSingleDecl() /*const*/ {
    return getKind() == Kind.SingleDeclKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::isDeclGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 84,
   FQN="clang::DeclGroupRef::isDeclGroup", NM="_ZNK5clang12DeclGroupRef11isDeclGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef11isDeclGroupEv")
  //</editor-fold>
  public boolean isDeclGroup() /*const*/ {
    return getKind() == Kind.DeclGroupKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::getSingleDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 86,
   FQN="clang::DeclGroupRef::getSingleDecl", NM="_ZN5clang12DeclGroupRef13getSingleDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRef13getSingleDeclEv")
  //</editor-fold>
  public Decl /*P*/ getSingleDecl() {
    assert (isSingleDecl()) : "Isn't a declgroup";
    return (Decl)D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::getSingleDecl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 90,
   FQN="clang::DeclGroupRef::getSingleDecl", NM="_ZNK5clang12DeclGroupRef13getSingleDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef13getSingleDeclEv")
  //</editor-fold>
  public /*const*/ Decl /*P*/ getSingleDecl$Const() /*const*/ {
    return //((/*const_cast*/DeclGroupRef /*P*/ )(this)).
            getSingleDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::getDeclGroup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 94,
   FQN="clang::DeclGroupRef::getDeclGroup", NM="_ZN5clang12DeclGroupRef12getDeclGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRef12getDeclGroupEv")
  //</editor-fold>
  public DeclGroup /*&*/ getDeclGroup() {
    assert (isDeclGroup()) : "Isn't a declgroup";
    return (DeclGroup)D;///*Deref*/((DeclGroup /*P*/ )(reinterpret_cast_Object/*uintptr_t*/(D) & ~Kind.Mask));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::getDeclGroup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 98,
   FQN="clang::DeclGroupRef::getDeclGroup", NM="_ZNK5clang12DeclGroupRef12getDeclGroupEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef12getDeclGroupEv")
  //</editor-fold>
  public /*const*/ DeclGroup /*&*/ getDeclGroup$Const() /*const*/ {
    return (DeclGroup)D;//((/*const_cast*/DeclGroupRef /*P*/ )(this)).getDeclGroup();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 102,
   FQN="clang::DeclGroupRef::begin", NM="_ZN5clang12DeclGroupRef5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRef5beginEv")
  //</editor-fold>
  public type$ptr<Decl /*P*/ /*P*/> begin() {
    if (isSingleDecl()) {
      return (D != null) ? $AddrOf(create_type$ptr2ConstT((Decl)D)) : null;
    }
    return $AddrOf(getDeclGroup().$at(0).deref$ptr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 108,
   FQN="clang::DeclGroupRef::end", NM="_ZN5clang12DeclGroupRef3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRef3endEv")
  //</editor-fold>
  public type$ptr<Decl /*P*/ /*P*/> end() {
    if (isSingleDecl()) {
      return (D != null) ? $AddrOf(create_type$ptr2ConstT((Decl)D).$add(1)) : null;
    }
    final DeclGroup /*&*/ G = getDeclGroup();
    return $AddrOf(G.$at(0).deref$ptr().$add(G.size()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 115,
   FQN="clang::DeclGroupRef::begin", NM="_ZNK5clang12DeclGroupRef5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef5beginEv")
  //</editor-fold>
  public type$ptr<Decl /*P*/ /*const*/ /*P*/> begin$Const() /*const*/ {
    if (isSingleDecl()) {
      return (D != null) ? $AddrOf(create_type$ptr2ConstT((Decl)D)) : null;
    }
    return $AddrOf(getDeclGroup$Const().$at(0).deref$ptr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 121,
   FQN="clang::DeclGroupRef::end", NM="_ZNK5clang12DeclGroupRef3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef3endEv")
  //</editor-fold>
  public type$ptr<Decl /*P*/ /*const*/ /*P*/> end$Const() /*const*/ {
    if (isSingleDecl()) {
      return (D != null) ? $AddrOf(create_type$ptr2ConstT((Decl)D).$add(1)) : null;
    }
    final /*const*/ DeclGroup /*&*/ G = getDeclGroup$Const();
    return $AddrOf(G.$at(0).deref$ptr().$add(G.size()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::getAsOpaquePtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 128,
   FQN="clang::DeclGroupRef::getAsOpaquePtr", NM="_ZNK5clang12DeclGroupRef14getAsOpaquePtrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang12DeclGroupRef14getAsOpaquePtrEv")
  //</editor-fold>
  public Object/*void P*/ getAsOpaquePtr() /*const*/ {
    return D;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::getFromOpaquePtr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 129,
   FQN="clang::DeclGroupRef::getFromOpaquePtr", NM="_ZN5clang12DeclGroupRef16getFromOpaquePtrEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRef16getFromOpaquePtrEPv")
  //</editor-fold>
  public static DeclGroupRef getFromOpaquePtr(Object/*void P*/ Ptr) {
    DeclGroupRef X/*J*/= new DeclGroupRef();
    X.D = ((/*static_cast*/Decl /*P*/ )(Ptr));
    X.IsDeclGroup = Ptr instanceof DeclGroup;
    return X;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::DeclGroupRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 54,
   FQN="clang::DeclGroupRef::DeclGroupRef", NM="_ZN5clang12DeclGroupRefC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRefC1ERKS0_")
  //</editor-fold>
  public /*inline*/ DeclGroupRef(final /*const*/ DeclGroupRef /*&*/ $Prm0) {
    // : D(.D) 
    //START JInit
    this.D = $Prm0.D;
    this.IsDeclGroup = $Prm0.IsDeclGroup;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::DeclGroupRef">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 54,
   FQN="clang::DeclGroupRef::DeclGroupRef", NM="_ZN5clang12DeclGroupRefC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRefC1EOS0_")
  //</editor-fold>
  public /*inline*/ DeclGroupRef(JD$Move _dparam, final DeclGroupRef /*&&*/$Prm0) {
    // : D(static_cast<DeclGroupRef &&>().D) 
    //START JInit
    this.D = $Prm0.D;
    this.IsDeclGroup = $Prm0.IsDeclGroup;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroupRef::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 54,
   FQN="clang::DeclGroupRef::operator=", NM="_ZN5clang12DeclGroupRefaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang12DeclGroupRefaSERKS0_")
  //</editor-fold>
  public /*inline*/ DeclGroupRef /*&*/ $assign(final /*const*/ DeclGroupRef /*&*/ $Prm0) {
    this.D = $Prm0.D;
    this.IsDeclGroup = $Prm0.IsDeclGroup;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<Decl> iterator() {return new JavaIterator<>(begin(), end());}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "DeclGroupRef{" + NativeTrace.getIdentityStr(D) + ":" + D + "}"; // NOI18N
  }
}
