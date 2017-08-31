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

//<editor-fold defaultstate="collapsed" desc="clang::UuidAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7022,
 FQN="clang::UuidAttr", NM="_ZN5clang8UuidAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang8UuidAttrE")
//</editor-fold>
public class UuidAttr extends /*public*/ InheritableAttr {
  private /*uint*/int guidLength;
  private char$ptr/*char P*/ guid;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7027,
   FQN="clang::UuidAttr::CreateImplicit", NM="_ZN5clang8UuidAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang8UuidAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static UuidAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Guid) {
    return CreateImplicit(Ctx, Guid, new SourceRange());
  }
  public static UuidAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Guid, SourceRange Loc/*= SourceRange()*/) {
    UuidAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new UuidAttr(new SourceRange(Loc), Ctx, new StringRef(Guid), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::UuidAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7033,
   FQN="clang::UuidAttr::UuidAttr", NM="_ZN5clang8UuidAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang8UuidAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public UuidAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Guid, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Uuid, R, SI, false, false), guidLength(Guid.size()), guid(new (Ctx, 1) new char [guidLength]) 
    //START JInit
    super(attr.Kind.Uuid, new SourceRange(R), SI, false, false);
    this.guidLength = Guid.size();
    this.guid = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(guidLength));
    //END JInit
    if (!Guid.empty()) {
      std.memcpy(guid, Guid.data(), guidLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6583,
   FQN="clang::UuidAttr::clone", NM="_ZNK5clang8UuidAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang8UuidAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public UuidAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    UuidAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new UuidAttr(new SourceRange(getLocation()), C, getGuid(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6591,
   FQN="clang::UuidAttr::printPretty", NM="_ZNK5clang8UuidAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang8UuidAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __declspec(uuid(\"").$out(getGuid()).$out(/*KEEP_STR*/"\"))");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6603,
   FQN="clang::UuidAttr::getSpelling", NM="_ZNK5clang8UuidAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang8UuidAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("uuid");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::getGuid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7048,
   FQN="clang::UuidAttr::getGuid", NM="_ZNK5clang8UuidAttr7getGuidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang8UuidAttr7getGuidEv")
  //</editor-fold>
  public StringRef getGuid() /*const*/ {
    return new StringRef(guid, guidLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::getGuidLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7051,
   FQN="clang::UuidAttr::getGuidLength", NM="_ZNK5clang8UuidAttr13getGuidLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang8UuidAttr13getGuidLengthEv")
  //</editor-fold>
  public /*uint*/int getGuidLength() /*const*/ {
    return guidLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::setGuid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7054,
   FQN="clang::UuidAttr::setGuid", NM="_ZN5clang8UuidAttr7setGuidERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang8UuidAttr7setGuidERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setGuid(final ASTContext /*&*/ C, StringRef S) {
    guidLength = S.size();
    this.guid = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(guidLength));
    if (!S.empty()) {
      std.memcpy(this.guid, S.data(), guidLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UuidAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 7063,
   FQN="clang::UuidAttr::classof", NM="_ZN5clang8UuidAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang8UuidAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Uuid;
  }

  
  @Override public String toString() {
    return "" + "guidLength=" + guidLength // NOI18N
              + ", guid=" + guid // NOI18N
              + super.toString(); // NOI18N
  }
}
