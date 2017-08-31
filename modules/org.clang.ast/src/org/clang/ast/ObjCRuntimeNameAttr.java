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

//<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5008,
 FQN="clang::ObjCRuntimeNameAttr", NM="_ZN5clang19ObjCRuntimeNameAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19ObjCRuntimeNameAttrE")
//</editor-fold>
public class ObjCRuntimeNameAttr extends /*public*/ Attr {
  private /*uint*/int metadataNameLength;
  private char$ptr/*char P*/ metadataName;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5013,
   FQN="clang::ObjCRuntimeNameAttr::CreateImplicit", NM="_ZN5clang19ObjCRuntimeNameAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19ObjCRuntimeNameAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static ObjCRuntimeNameAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef MetadataName) {
    return CreateImplicit(Ctx, MetadataName, new SourceRange());
  }
  public static ObjCRuntimeNameAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef MetadataName, SourceRange Loc/*= SourceRange()*/) {
    ObjCRuntimeNameAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new ObjCRuntimeNameAttr(new SourceRange(Loc), Ctx, new StringRef(MetadataName), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::ObjCRuntimeNameAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5019,
   FQN="clang::ObjCRuntimeNameAttr::ObjCRuntimeNameAttr", NM="_ZN5clang19ObjCRuntimeNameAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19ObjCRuntimeNameAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public ObjCRuntimeNameAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef MetadataName, 
      /*uint*/int SI) {
    // : Attr(attr::ObjCRuntimeName, R, SI, false, false), metadataNameLength(MetadataName.size()), metadataName(new (Ctx, 1) new char [metadataNameLength]) 
    //START JInit
    super(attr.Kind.ObjCRuntimeName, new SourceRange(R), SI, false, false);
    this.metadataNameLength = MetadataName.size();
    this.metadataName = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(metadataNameLength));
    //END JInit
    if (!MetadataName.empty()) {
      std.memcpy(metadataName, MetadataName.data(), metadataNameLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4588,
   FQN="clang::ObjCRuntimeNameAttr::clone", NM="_ZNK5clang19ObjCRuntimeNameAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19ObjCRuntimeNameAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public ObjCRuntimeNameAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    ObjCRuntimeNameAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new ObjCRuntimeNameAttr(new SourceRange(getLocation()), C, getMetadataName(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4596,
   FQN="clang::ObjCRuntimeNameAttr::printPretty", NM="_ZNK5clang19ObjCRuntimeNameAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19ObjCRuntimeNameAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((objc_runtime_name(\"").$out(getMetadataName()).$out(/*KEEP_STR*/"\")))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 4608,
   FQN="clang::ObjCRuntimeNameAttr::getSpelling", NM="_ZNK5clang19ObjCRuntimeNameAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19ObjCRuntimeNameAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("objc_runtime_name");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::getMetadataName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5034,
   FQN="clang::ObjCRuntimeNameAttr::getMetadataName", NM="_ZNK5clang19ObjCRuntimeNameAttr15getMetadataNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19ObjCRuntimeNameAttr15getMetadataNameEv")
  //</editor-fold>
  public StringRef getMetadataName() /*const*/ {
    return new StringRef(metadataName, metadataNameLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::getMetadataNameLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5037,
   FQN="clang::ObjCRuntimeNameAttr::getMetadataNameLength", NM="_ZNK5clang19ObjCRuntimeNameAttr21getMetadataNameLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang19ObjCRuntimeNameAttr21getMetadataNameLengthEv")
  //</editor-fold>
  public /*uint*/int getMetadataNameLength() /*const*/ {
    return metadataNameLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::setMetadataName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5040,
   FQN="clang::ObjCRuntimeNameAttr::setMetadataName", NM="_ZN5clang19ObjCRuntimeNameAttr15setMetadataNameERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19ObjCRuntimeNameAttr15setMetadataNameERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setMetadataName(final ASTContext /*&*/ C, StringRef S) {
    metadataNameLength = S.size();
    this.metadataName = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(metadataNameLength));
    if (!S.empty()) {
      std.memcpy(this.metadataName, S.data(), metadataNameLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCRuntimeNameAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 5049,
   FQN="clang::ObjCRuntimeNameAttr::classof", NM="_ZN5clang19ObjCRuntimeNameAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang19ObjCRuntimeNameAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.ObjCRuntimeName;
  }

  
  @Override public String toString() {
    return "" + "metadataNameLength=" + metadataNameLength // NOI18N
              + ", metadataName=" + metadataName // NOI18N
              + super.toString(); // NOI18N
  }
}
