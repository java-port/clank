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

//<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2743,
 FQN="clang::IFuncAttr", NM="_ZN5clang9IFuncAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9IFuncAttrE")
//</editor-fold>
public class IFuncAttr extends /*public*/ Attr {
  private /*uint*/int resolverLength;
  private char$ptr/*char P*/ resolver;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2748,
   FQN="clang::IFuncAttr::CreateImplicit", NM="_ZN5clang9IFuncAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9IFuncAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static IFuncAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Resolver) {
    return CreateImplicit(Ctx, Resolver, new SourceRange());
  }
  public static IFuncAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef Resolver, SourceRange Loc/*= SourceRange()*/) {
    IFuncAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new IFuncAttr(new SourceRange(Loc), Ctx, new StringRef(Resolver), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::IFuncAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2754,
   FQN="clang::IFuncAttr::IFuncAttr", NM="_ZN5clang9IFuncAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9IFuncAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public IFuncAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef Resolver, 
      /*uint*/int SI) {
    // : Attr(attr::IFunc, R, SI, false, false), resolverLength(Resolver.size()), resolver(new (Ctx, 1) new char [resolverLength]) 
    //START JInit
    super(attr.Kind.IFunc, new SourceRange(R), SI, false, false);
    this.resolverLength = Resolver.size();
    this.resolver = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(resolverLength));
    //END JInit
    if (!Resolver.empty()) {
      std.memcpy(resolver, Resolver.data(), resolverLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2603,
   FQN="clang::IFuncAttr::clone", NM="_ZNK5clang9IFuncAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9IFuncAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public IFuncAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    IFuncAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new IFuncAttr(new SourceRange(getLocation()), C, getResolver(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2611,
   FQN="clang::IFuncAttr::printPretty", NM="_ZNK5clang9IFuncAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9IFuncAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((ifunc(\"").$out(getResolver()).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::ifunc(\"").$out(getResolver()).$out(/*KEEP_STR*/"\")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 2627,
   FQN="clang::IFuncAttr::getSpelling", NM="_ZNK5clang9IFuncAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9IFuncAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("ifunc");
     case 1:
      return $("ifunc");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::getResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2769,
   FQN="clang::IFuncAttr::getResolver", NM="_ZNK5clang9IFuncAttr11getResolverEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9IFuncAttr11getResolverEv")
  //</editor-fold>
  public StringRef getResolver() /*const*/ {
    return new StringRef(resolver, resolverLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::getResolverLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2772,
   FQN="clang::IFuncAttr::getResolverLength", NM="_ZNK5clang9IFuncAttr17getResolverLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang9IFuncAttr17getResolverLengthEv")
  //</editor-fold>
  public /*uint*/int getResolverLength() /*const*/ {
    return resolverLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::setResolver">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2775,
   FQN="clang::IFuncAttr::setResolver", NM="_ZN5clang9IFuncAttr11setResolverERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9IFuncAttr11setResolverERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setResolver(final ASTContext /*&*/ C, StringRef S) {
    resolverLength = S.size();
    this.resolver = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(resolverLength));
    if (!S.empty()) {
      std.memcpy(this.resolver, S.data(), resolverLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::IFuncAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 2784,
   FQN="clang::IFuncAttr::classof", NM="_ZN5clang9IFuncAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang9IFuncAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.IFunc;
  }

  
  @Override public String toString() {
    return "" + "resolverLength=" + resolverLength // NOI18N
              + ", resolver=" + resolver // NOI18N
              + super.toString(); // NOI18N
  }
}
