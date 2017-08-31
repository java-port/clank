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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2701,
 FQN="clang::IBOutletCollectionAttr", NM="_ZN5clang22IBOutletCollectionAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22IBOutletCollectionAttrE")
//</editor-fold>
public class IBOutletCollectionAttr extends /*public*/ InheritableAttr {
  private TypeSourceInfo /*P*/ interface_;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2705,
   FQN="clang::IBOutletCollectionAttr::CreateImplicit", NM="_ZN5clang22IBOutletCollectionAttr14CreateImplicitERNS_10ASTContextEPNS_14TypeSourceInfoENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22IBOutletCollectionAttr14CreateImplicitERNS_10ASTContextEPNS_14TypeSourceInfoENS_11SourceRangeE")
  //</editor-fold>
  public static IBOutletCollectionAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, TypeSourceInfo /*P*/ Interface) {
    return CreateImplicit(Ctx, Interface, new SourceRange());
  }
  public static IBOutletCollectionAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, TypeSourceInfo /*P*/ Interface, SourceRange Loc/*= SourceRange()*/) {
    IBOutletCollectionAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new IBOutletCollectionAttr(new SourceRange(Loc), Ctx, Interface, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::IBOutletCollectionAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2711,
   FQN="clang::IBOutletCollectionAttr::IBOutletCollectionAttr", NM="_ZN5clang22IBOutletCollectionAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14TypeSourceInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22IBOutletCollectionAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14TypeSourceInfoEj")
  //</editor-fold>
  public IBOutletCollectionAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      TypeSourceInfo /*P*/ Interface, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::IBOutletCollection, R, SI, false, false), interface_(Interface) 
    //START JInit
    super(attr.Kind.IBOutletCollection, new SourceRange(R), SI, false, false);
    this.interface_ = Interface;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::IBOutletCollectionAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2720,
   FQN="clang::IBOutletCollectionAttr::IBOutletCollectionAttr", NM="_ZN5clang22IBOutletCollectionAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22IBOutletCollectionAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public IBOutletCollectionAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::IBOutletCollection, R, SI, false, false), interface_(implicit TypeSourceInfo * ()) 
    //START JInit
    super(attr.Kind.IBOutletCollection, new SourceRange(R), SI, false, false);
    this.interface_ = /*implicit-init*/((TypeSourceInfo /*P*/ )/*zero-init*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2573,
   FQN="clang::IBOutletCollectionAttr::clone", NM="_ZNK5clang22IBOutletCollectionAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22IBOutletCollectionAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public IBOutletCollectionAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    IBOutletCollectionAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new IBOutletCollectionAttr(new SourceRange(getLocation()), C, interface_, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2581,
   FQN="clang::IBOutletCollectionAttr::printPretty", NM="_ZNK5clang22IBOutletCollectionAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22IBOutletCollectionAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((iboutletcollection(").$out(getInterface().getAsString()).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2593,
   FQN="clang::IBOutletCollectionAttr::getSpelling", NM="_ZNK5clang22IBOutletCollectionAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22IBOutletCollectionAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("iboutletcollection");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::getInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2732,
   FQN="clang::IBOutletCollectionAttr::getInterface", NM="_ZNK5clang22IBOutletCollectionAttr12getInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22IBOutletCollectionAttr12getInterfaceEv")
  //</editor-fold>
  public QualType getInterface() /*const*/ {
    return interface_.getType();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::getInterfaceLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2734,
   FQN="clang::IBOutletCollectionAttr::getInterfaceLoc", NM="_ZNK5clang22IBOutletCollectionAttr15getInterfaceLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang22IBOutletCollectionAttr15getInterfaceLocEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getInterfaceLoc() /*const*/ {
    return interface_;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IBOutletCollectionAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2740,
   FQN="clang::IBOutletCollectionAttr::classof", NM="_ZN5clang22IBOutletCollectionAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang22IBOutletCollectionAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.IBOutletCollection;
  }

  
  @Override public String toString() {
    return "" + "interface_=" + interface_ // NOI18N
              + super.toString(); // NOI18N
  }
}
