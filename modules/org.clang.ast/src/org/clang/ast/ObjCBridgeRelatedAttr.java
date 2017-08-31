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

//<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4640,
 FQN="clang::ObjCBridgeRelatedAttr", NM="_ZN5clang21ObjCBridgeRelatedAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ObjCBridgeRelatedAttrE")
//</editor-fold>
public class ObjCBridgeRelatedAttr extends /*public*/ InheritableAttr {
  private IdentifierInfo /*P*/ relatedClass;
  
  private IdentifierInfo /*P*/ classMethod;
  
  private IdentifierInfo /*P*/ instanceMethod;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4648,
   FQN="clang::ObjCBridgeRelatedAttr::CreateImplicit", NM="_ZN5clang21ObjCBridgeRelatedAttr14CreateImplicitERNS_10ASTContextEPNS_14IdentifierInfoES4_S4_NS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ObjCBridgeRelatedAttr14CreateImplicitERNS_10ASTContextEPNS_14IdentifierInfoES4_S4_NS_11SourceRangeE")
  //</editor-fold>
  public static ObjCBridgeRelatedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, IdentifierInfo /*P*/ RelatedClass, IdentifierInfo /*P*/ ClassMethod, IdentifierInfo /*P*/ InstanceMethod) {
    return CreateImplicit(Ctx, RelatedClass, ClassMethod, InstanceMethod, new SourceRange());
  }
  public static ObjCBridgeRelatedAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, IdentifierInfo /*P*/ RelatedClass, IdentifierInfo /*P*/ ClassMethod, IdentifierInfo /*P*/ InstanceMethod, SourceRange Loc/*= SourceRange()*/) {
    ObjCBridgeRelatedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new ObjCBridgeRelatedAttr(new SourceRange(Loc), Ctx, RelatedClass, ClassMethod, InstanceMethod, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::ObjCBridgeRelatedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4654,
   FQN="clang::ObjCBridgeRelatedAttr::ObjCBridgeRelatedAttr", NM="_ZN5clang21ObjCBridgeRelatedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoES5_S5_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ObjCBridgeRelatedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoES5_S5_j")
  //</editor-fold>
  public ObjCBridgeRelatedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      IdentifierInfo /*P*/ RelatedClass, 
      IdentifierInfo /*P*/ ClassMethod, 
      IdentifierInfo /*P*/ InstanceMethod, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::ObjCBridgeRelated, R, SI, false, false), relatedClass(RelatedClass), classMethod(ClassMethod), instanceMethod(InstanceMethod) 
    //START JInit
    super(attr.Kind.ObjCBridgeRelated, new SourceRange(R), SI, false, false);
    this.relatedClass = RelatedClass;
    this.classMethod = ClassMethod;
    this.instanceMethod = InstanceMethod;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::ObjCBridgeRelatedAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4667,
   FQN="clang::ObjCBridgeRelatedAttr::ObjCBridgeRelatedAttr", NM="_ZN5clang21ObjCBridgeRelatedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ObjCBridgeRelatedAttrC1ENS_11SourceRangeERNS_10ASTContextEPNS_14IdentifierInfoEj")
  //</editor-fold>
  public ObjCBridgeRelatedAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      IdentifierInfo /*P*/ RelatedClass, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::ObjCBridgeRelated, R, SI, false, false), relatedClass(RelatedClass), classMethod(implicit IdentifierInfo * ()), instanceMethod(implicit IdentifierInfo * ()) 
    //START JInit
    super(attr.Kind.ObjCBridgeRelated, new SourceRange(R), SI, false, false);
    this.relatedClass = RelatedClass;
    this.classMethod = /*implicit-init*/((IdentifierInfo /*P*/ )/*zero-init*/null);
    this.instanceMethod = /*implicit-init*/((IdentifierInfo /*P*/ )/*zero-init*/null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4228,
   FQN="clang::ObjCBridgeRelatedAttr::clone", NM="_ZNK5clang21ObjCBridgeRelatedAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ObjCBridgeRelatedAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public ObjCBridgeRelatedAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    ObjCBridgeRelatedAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new ObjCBridgeRelatedAttr(new SourceRange(getLocation()), C, relatedClass, classMethod, instanceMethod, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4236,
   FQN="clang::ObjCBridgeRelatedAttr::printPretty", NM="_ZNK5clang21ObjCBridgeRelatedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ObjCBridgeRelatedAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((objc_bridge_related(").$out(getRelatedClass().getName()).$out(/*KEEP_STR*/$COMMA_SPACE).$out(getClassMethod().getName()).$out(/*KEEP_STR*/$COMMA_SPACE).$out(getInstanceMethod().getName()).$out(/*KEEP_STR*/")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4248,
   FQN="clang::ObjCBridgeRelatedAttr::getSpelling", NM="_ZNK5clang21ObjCBridgeRelatedAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ObjCBridgeRelatedAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("objc_bridge_related");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::getRelatedClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4682,
   FQN="clang::ObjCBridgeRelatedAttr::getRelatedClass", NM="_ZNK5clang21ObjCBridgeRelatedAttr15getRelatedClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ObjCBridgeRelatedAttr15getRelatedClassEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getRelatedClass() /*const*/ {
    return relatedClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::getClassMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4686,
   FQN="clang::ObjCBridgeRelatedAttr::getClassMethod", NM="_ZNK5clang21ObjCBridgeRelatedAttr14getClassMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ObjCBridgeRelatedAttr14getClassMethodEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getClassMethod() /*const*/ {
    return classMethod;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::getInstanceMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4690,
   FQN="clang::ObjCBridgeRelatedAttr::getInstanceMethod", NM="_ZNK5clang21ObjCBridgeRelatedAttr17getInstanceMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang21ObjCBridgeRelatedAttr17getInstanceMethodEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getInstanceMethod() /*const*/ {
    return instanceMethod;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCBridgeRelatedAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 4696,
   FQN="clang::ObjCBridgeRelatedAttr::classof", NM="_ZN5clang21ObjCBridgeRelatedAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang21ObjCBridgeRelatedAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.ObjCBridgeRelated;
  }

  
  @Override public String toString() {
    return "" + "relatedClass=" + relatedClass // NOI18N
              + ", classMethod=" + classMethod // NOI18N
              + ", instanceMethod=" + instanceMethod // NOI18N
              + super.toString(); // NOI18N
  }
}
