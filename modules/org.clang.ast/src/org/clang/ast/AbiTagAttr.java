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

//<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 153,
 FQN="clang::AbiTagAttr", NM="_ZN5clang10AbiTagAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10AbiTagAttrE")
//</editor-fold>
public class AbiTagAttr extends /*public*/ Attr {
  private /*uint*/int tags_Size;
  private type$ptr<StringRef/*P*/> tags_;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 158,
   FQN="clang::AbiTagAttr::CreateImplicit", NM="_ZN5clang10AbiTagAttr14CreateImplicitERNS_10ASTContextEPN4llvm9StringRefEjNS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10AbiTagAttr14CreateImplicitERNS_10ASTContextEPN4llvm9StringRefEjNS_11SourceRangeE")
  //</editor-fold>
  public static AbiTagAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, type$ptr<StringRef/*P*/> Tags, /*uint*/int TagsSize) {
    return CreateImplicit(Ctx, Tags, TagsSize, new SourceRange());
  }
  public static AbiTagAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, type$ptr<StringRef/*P*/> Tags, /*uint*/int TagsSize, SourceRange Loc/*= SourceRange()*/) {
    AbiTagAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new AbiTagAttr(new SourceRange(Loc), Ctx, Tags, TagsSize, 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::AbiTagAttr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*change assignMove to $set because array is not initialized*/,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 164,
   FQN="clang::AbiTagAttr::AbiTagAttr", NM="_ZN5clang10AbiTagAttrC1ENS_11SourceRangeERNS_10ASTContextEPN4llvm9StringRefEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10AbiTagAttrC1ENS_11SourceRangeERNS_10ASTContextEPN4llvm9StringRefEjj")
  //</editor-fold>
  public AbiTagAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      type$ptr<StringRef/*P*/> Tags, /*uint*/int TagsSize, 
      /*uint*/int SI) {
    // : Attr(attr::AbiTag, R, SI, false, false), tags_Size(TagsSize), tags_(new (Ctx, 16) new StringRef [tags_Size]) 
    //START JInit
    super(attr.Kind.AbiTag, new SourceRange(R), SI, false, false);
    this.tags_Size = TagsSize;
    this.tags_ = create_type$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 16)*/ new StringRef [tags_Size]);
    //END JInit
    for (/*size_t*/int I = 0, E = tags_Size; I != E;
         ++I) {
      StringRef Ref = new StringRef(Tags.$at(I));
      if (!Ref.empty()) {
        char$ptr/*char P*/ Mem = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(Ref.size()));
        std.memcpy(Mem, Ref.data(), Ref.size());
        tags_.$set(I, new StringRef(Mem, Ref.size()));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::AbiTagAttr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 182,
   FQN="clang::AbiTagAttr::AbiTagAttr", NM="_ZN5clang10AbiTagAttrC1ENS_11SourceRangeERNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10AbiTagAttrC1ENS_11SourceRangeERNS_10ASTContextEj")
  //</editor-fold>
  public AbiTagAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      /*uint*/int SI) {
    // : Attr(attr::AbiTag, R, SI, false, false), tags_Size(0), tags_(null) 
    //START JInit
    super(attr.Kind.AbiTag, new SourceRange(R), SI, false, false);
    this.tags_Size = 0;
    this.tags_ = create_type$null$ptr();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 99,
   FQN="clang::AbiTagAttr::clone", NM="_ZNK5clang10AbiTagAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10AbiTagAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public AbiTagAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    AbiTagAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new AbiTagAttr(new SourceRange(getLocation()), C, tags_, tags_Size, getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 107,
   FQN="clang::AbiTagAttr::printPretty", NM="_ZNK5clang10AbiTagAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10AbiTagAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((abi_tag(");
        boolean isFirst = true;
        for (final /*const*/ StringRef /*&*/ Val : tags()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(/*KEEP_STR*/$DBL_QUOTE).$out(/*NO_COPY*/Val).$out(/*KEEP_STR*/$DBL_QUOTE);
        }
        OS.$out(/*KEEP_STR*/")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::abi_tag(");
        boolean isFirst = true;
        for (final /*const*/ StringRef /*&*/ Val : tags()) {
          if (isFirst) {
            isFirst = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          OS.$out(/*KEEP_STR*/$DBL_QUOTE).$out(/*NO_COPY*/Val).$out(/*KEEP_STR*/$DBL_QUOTE);
        }
        OS.$out(/*KEEP_STR*/")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 137,
   FQN="clang::AbiTagAttr::getSpelling", NM="_ZNK5clang10AbiTagAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10AbiTagAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("abi_tag");
     case 1:
      return $("abi_tag");
    }
  }

  /*typedef StringRef *tags_iterator*/
//  public final class tags_iterator extends type$ptr<StringRef/*P*/> { };
  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::tags_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 195,
   FQN="clang::AbiTagAttr::tags_begin", NM="_ZNK5clang10AbiTagAttr10tags_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10AbiTagAttr10tags_beginEv")
  //</editor-fold>
  public type$ptr<StringRef>/*tags_iterator*/ tags_begin() /*const*/ {
    return tags_;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::tags_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 196,
   FQN="clang::AbiTagAttr::tags_end", NM="_ZNK5clang10AbiTagAttr8tags_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10AbiTagAttr8tags_endEv")
  //</editor-fold>
  public type$ptr<StringRef>/*tags_iterator*/ tags_end() /*const*/ {
    return tags_.$add(tags_Size);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::tags_size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 197,
   FQN="clang::AbiTagAttr::tags_size", NM="_ZNK5clang10AbiTagAttr9tags_sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10AbiTagAttr9tags_sizeEv")
  //</editor-fold>
  public /*uint*/int tags_size() /*const*/ {
    return tags_Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::tags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 198,
   FQN="clang::AbiTagAttr::tags", NM="_ZNK5clang10AbiTagAttr4tagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10AbiTagAttr4tagsEv")
  //</editor-fold>
  public iterator_range<StringRef/*tags_iterator*/> tags() /*const*/ {
    return llvm.make_range(tags_begin(), tags_end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::AbiTagAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 203,
   FQN="clang::AbiTagAttr::classof", NM="_ZN5clang10AbiTagAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10AbiTagAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.AbiTag;
  }

  
  @Override public String toString() {
    return "" + "tags_Size=" + tags_Size // NOI18N
              + ", tags_=" + tags_ // NOI18N
              + super.toString(); // NOI18N
  }
}
