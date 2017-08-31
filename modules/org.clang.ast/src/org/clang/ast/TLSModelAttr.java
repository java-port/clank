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

//<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6431,
 FQN="clang::TLSModelAttr", NM="_ZN5clang12TLSModelAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12TLSModelAttrE")
//</editor-fold>
public class TLSModelAttr extends /*public*/ InheritableAttr {
  private /*uint*/int modelLength;
  private char$ptr/*char P*/ model;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6436,
   FQN="clang::TLSModelAttr::CreateImplicit", NM="_ZN5clang12TLSModelAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12TLSModelAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static TLSModelAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Model) {
    return CreateImplicit(Ctx, Model, new SourceRange());
  }
  public static TLSModelAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Model, SourceRange Loc/*= SourceRange()*/) {
    TLSModelAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new TLSModelAttr(new SourceRange(Loc), Ctx, new StringRef(Model), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::TLSModelAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6442,
   FQN="clang::TLSModelAttr::TLSModelAttr", NM="_ZN5clang12TLSModelAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12TLSModelAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public TLSModelAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Model, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::TLSModel, R, SI, false, false), modelLength(Model.size()), model(new (Ctx, 1) new char [modelLength]) 
    //START JInit
    super(attr.Kind.TLSModel, new SourceRange(R), SI, false, false);
    this.modelLength = Model.size();
    this.model = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(modelLength));
    //END JInit
    if (!Model.empty()) {
      std.memcpy(model, Model.data(), modelLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6117,
   FQN="clang::TLSModelAttr::clone", NM="_ZNK5clang12TLSModelAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12TLSModelAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public TLSModelAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    TLSModelAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new TLSModelAttr(new SourceRange(getLocation()), C, getModel(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6125,
   FQN="clang::TLSModelAttr::printPretty", NM="_ZNK5clang12TLSModelAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12TLSModelAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((tls_model(\"").$out(getModel()).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::tls_model(\"").$out(getModel()).$out(/*KEEP_STR*/"\")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6141,
   FQN="clang::TLSModelAttr::getSpelling", NM="_ZNK5clang12TLSModelAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12TLSModelAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("tls_model");
     case 1:
      return $("tls_model");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::getModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6457,
   FQN="clang::TLSModelAttr::getModel", NM="_ZNK5clang12TLSModelAttr8getModelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12TLSModelAttr8getModelEv")
  //</editor-fold>
  public StringRef getModel() /*const*/ {
    return new StringRef(model, modelLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::getModelLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6460,
   FQN="clang::TLSModelAttr::getModelLength", NM="_ZNK5clang12TLSModelAttr14getModelLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang12TLSModelAttr14getModelLengthEv")
  //</editor-fold>
  public /*uint*/int getModelLength() /*const*/ {
    return modelLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::setModel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6463,
   FQN="clang::TLSModelAttr::setModel", NM="_ZN5clang12TLSModelAttr8setModelERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12TLSModelAttr8setModelERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setModel(final ASTContext /*&*/ C, StringRef S) {
    modelLength = S.size();
    this.model = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(modelLength));
    if (!S.empty()) {
      std.memcpy(this.model, S.data(), modelLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TLSModelAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6472,
   FQN="clang::TLSModelAttr::classof", NM="_ZN5clang12TLSModelAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang12TLSModelAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.TLSModel;
  }

  
  @Override public String toString() {
    return "" + "modelLength=" + modelLength // NOI18N
              + ", model=" + model // NOI18N
              + super.toString(); // NOI18N
  }
}
