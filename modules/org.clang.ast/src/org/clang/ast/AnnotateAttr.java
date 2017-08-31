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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 608,
 FQN="clang::AnnotateAttr", NM="_ZN5clang12AnnotateAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AnnotateAttrE")
//</editor-fold>
public class AnnotateAttr extends /*public*/ InheritableParamAttr {
  private /*uint*/int annotationLength;
  private char$ptr/*char P*/ annotation;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 613,
   FQN="clang::AnnotateAttr::CreateImplicit", NM="_ZN5clang12AnnotateAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AnnotateAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static AnnotateAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Annotation) {
    return CreateImplicit(Ctx, Annotation, new SourceRange());
  }
  public static AnnotateAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Annotation, SourceRange Loc/*= SourceRange()*/) {
    AnnotateAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AnnotateAttr(new SourceRange(Loc), Ctx, new StringRef(Annotation), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::AnnotateAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 619,
   FQN="clang::AnnotateAttr::AnnotateAttr", NM="_ZN5clang12AnnotateAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AnnotateAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public AnnotateAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Annotation, 
      /*uint*/int SI) {
    // : InheritableParamAttr(attr::Annotate, R, SI, false, false), annotationLength(Annotation.size()), annotation(new (Ctx, 1) new char [annotationLength]) 
    //START JInit
    super(attr.Kind.Annotate, new SourceRange(R), SI, false, false);
    this.annotationLength = Annotation.size();
    this.annotation = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(annotationLength));
    //END JInit
    if (!Annotation.empty()) {
      std.memcpy(annotation, Annotation.data(), annotationLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 560,
   FQN="clang::AnnotateAttr::clone", NM="_ZNK5clang12AnnotateAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AnnotateAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AnnotateAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AnnotateAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AnnotateAttr(new SourceRange(getLocation()), C, getAnnotation(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 568,
   FQN="clang::AnnotateAttr::printPretty", NM="_ZNK5clang12AnnotateAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AnnotateAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((annotate(\"").$out(getAnnotation()).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 580,
   FQN="clang::AnnotateAttr::getSpelling", NM="_ZNK5clang12AnnotateAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AnnotateAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("annotate");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::getAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 634,
   FQN="clang::AnnotateAttr::getAnnotation", NM="_ZNK5clang12AnnotateAttr13getAnnotationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AnnotateAttr13getAnnotationEv")
  //</editor-fold>
  public StringRef getAnnotation() /*const*/ {
    return new StringRef(annotation, annotationLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::getAnnotationLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 637,
   FQN="clang::AnnotateAttr::getAnnotationLength", NM="_ZNK5clang12AnnotateAttr19getAnnotationLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12AnnotateAttr19getAnnotationLengthEv")
  //</editor-fold>
  public /*uint*/int getAnnotationLength() /*const*/ {
    return annotationLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::setAnnotation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 640,
   FQN="clang::AnnotateAttr::setAnnotation", NM="_ZN5clang12AnnotateAttr13setAnnotationERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AnnotateAttr13setAnnotationERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setAnnotation(final ASTContext /*&*/ C, StringRef S) {
    annotationLength = S.size();
    this.annotation = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(annotationLength));
    if (!S.empty()) {
      std.memcpy(this.annotation, S.data(), annotationLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AnnotateAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 649,
   FQN="clang::AnnotateAttr::classof", NM="_ZN5clang12AnnotateAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12AnnotateAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Annotate;
  }

  
  @Override public String toString() {
    return "" + "annotationLength=" + annotationLength // NOI18N
              + ", annotation=" + annotation // NOI18N
              + super.toString(); // NOI18N
  }
}
