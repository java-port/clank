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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;

//<editor-fold defaultstate="collapsed" desc="clang::TargetAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6475,
 FQN="clang::TargetAttr", NM="_ZN5clang10TargetAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10TargetAttrE")
//</editor-fold>
public class TargetAttr extends /*public*/ InheritableAttr {
  private /*uint*/int featuresStrLength;
  private char$ptr/*char P*/ featuresStr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::CreateImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6480,
   FQN="clang::TargetAttr::CreateImplicit", NM="_ZN5clang10TargetAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10TargetAttr14CreateImplicitERNS_10ASTContextEN4llvm9StringRefENS_11SourceRangeE")
  //</editor-fold>
  public static TargetAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef FeaturesStr) {
    return CreateImplicit(Ctx, FeaturesStr, new SourceRange());
  }
  public static TargetAttr /*P*/ CreateImplicit(final ASTContext /*&*/ Ctx, StringRef FeaturesStr, SourceRange Loc/*= SourceRange()*/) {
    TargetAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (Ctx)*/ new TargetAttr(new SourceRange(Loc), Ctx, new StringRef(FeaturesStr), 0);
    A.setImplicit(true);
    return A;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::TargetAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6486,
   FQN="clang::TargetAttr::TargetAttr", NM="_ZN5clang10TargetAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10TargetAttrC1ENS_11SourceRangeERNS_10ASTContextEN4llvm9StringRefEj")
  //</editor-fold>
  public TargetAttr(SourceRange R, final ASTContext /*&*/ Ctx, 
      StringRef FeaturesStr, 
      /*uint*/int SI) {
    // : InheritableAttr(attr::Target, R, SI, false, false), featuresStrLength(FeaturesStr.size()), featuresStr(new (Ctx, 1) new char [featuresStrLength]) 
    //START JInit
    super(attr.Kind.Target, new SourceRange(R), SI, false, false);
    this.featuresStrLength = FeaturesStr.size();
    this.featuresStr = create_char$ptr(/*FIXME:NEW_EXPR*//*new (Ctx, 1)*/ new$char(featuresStrLength));
    //END JInit
    if (!FeaturesStr.empty()) {
      std.memcpy(featuresStr, FeaturesStr.data(), featuresStrLength);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::clone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6153,
   FQN="clang::TargetAttr::clone", NM="_ZNK5clang10TargetAttr5cloneERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10TargetAttr5cloneERNS_10ASTContextE")
  //</editor-fold>
  public TargetAttr /*P*/ clone(final ASTContext /*&*/ C) /*const*/ {
    TargetAttr /*P*/ A = /*FIXME:NEW_EXPR*//*new (C)*/ new TargetAttr(new SourceRange(getLocation()), C, getFeaturesStr(), getSpellingListIndex());
    A.Inherited = Inherited;
    A.IsPackExpansion = IsPackExpansion;
    A.Implicit = Implicit;
    return A;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6161,
   FQN="clang::TargetAttr::printPretty", NM="_ZNK5clang10TargetAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10TargetAttr11printPrettyERN4llvm11raw_ostreamERKNS_14PrintingPolicyE")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      break;
     case 0:
      {
        OS.$out(/*KEEP_STR*/" __attribute__((target(\"").$out(getFeaturesStr()).$out(/*KEEP_STR*/"\")))");
        break;
      }
     case 1:
      {
        OS.$out(/*KEEP_STR*/" [[gnu::target(\"").$out(getFeaturesStr()).$out(/*KEEP_STR*/"\")]]");
        break;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::getSpelling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/AttrImpl.inc", line = 6177,
   FQN="clang::TargetAttr::getSpelling", NM="_ZNK5clang10TargetAttr11getSpellingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10TargetAttr11getSpellingEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getSpelling() /*const*/ {
    switch (SpellingListIndex) {
     default:
      throw new llvm_unreachable("Unknown attribute spelling!");
//      return $("(No spelling)");
     case 0:
      return $("target");
     case 1:
      return $("target");
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::getFeaturesStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6501,
   FQN="clang::TargetAttr::getFeaturesStr", NM="_ZNK5clang10TargetAttr14getFeaturesStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10TargetAttr14getFeaturesStrEv")
  //</editor-fold>
  public StringRef getFeaturesStr() /*const*/ {
    return new StringRef(featuresStr, featuresStrLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::getFeaturesStrLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6504,
   FQN="clang::TargetAttr::getFeaturesStrLength", NM="_ZNK5clang10TargetAttr20getFeaturesStrLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10TargetAttr20getFeaturesStrLengthEv")
  //</editor-fold>
  public /*uint*/int getFeaturesStrLength() /*const*/ {
    return featuresStrLength;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::setFeaturesStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6507,
   FQN="clang::TargetAttr::setFeaturesStr", NM="_ZN5clang10TargetAttr14setFeaturesStrERNS_10ASTContextEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10TargetAttr14setFeaturesStrERNS_10ASTContextEN4llvm9StringRefE")
  //</editor-fold>
  public void setFeaturesStr(final ASTContext /*&*/ C, StringRef S) {
    featuresStrLength = S.size();
    this.featuresStr = create_char$ptr(/*FIXME:NEW_EXPR*//*new (C, 1)*/ new$char(featuresStrLength));
    if (!S.empty()) {
      std.memcpy(this.featuresStr, S.data(), featuresStrLength);
    }
  }

  
  /*typedef std::pair<std::vector<std::string>, StringRef> ParsedTargetAttr*/
//  public final class ParsedTargetAttr extends std.pair<std.vectorString, StringRef>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::parse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6516,
   FQN="clang::TargetAttr::parse", NM="_ZNK5clang10TargetAttr5parseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZNK5clang10TargetAttr5parseEv")
  //</editor-fold>
  public std.pair<std.vectorString, StringRef> parse() /*const*/ {
    std.pair<std.vectorString, StringRef> Ret = null;
    try {
      Ret/*J*/= new std.pairTypeType<std.vectorString, StringRef>(new std.vectorString(), new StringRef());
      SmallVector<StringRef> AttrFeatures/*J*/= new SmallVector<StringRef>(1, new StringRef());
      getFeaturesStr().split(AttrFeatures, /*STRINGREF_STR*/",");
      
      // Grab the various features and prepend a "+" to turn on the feature to
      // the backend and add them to our existing set of features.
      for (final StringRef /*&*/ Feature : AttrFeatures) {
        // Go ahead and trim whitespace rather than either erroring or
        // accepting it weirdly.
        Feature.$assignMove(Feature.trim());
        
        // We don't support cpu tuning this way currently.
        // TODO: Support the fpmath option. It will require checking
        // overall feature validity for the function with the rest of the
        // attributes on the function.
        if (Feature.startswith(/*STRINGREF_STR*/"fpmath=") || Feature.startswith(/*STRINGREF_STR*/"tune=")) {
          continue;
        }
        
        // While we're here iterating check for a different target cpu.
        if (Feature.startswith(/*STRINGREF_STR*/"arch=")) {
          Ret.second.$assignMove(Feature.split(/*STRINGREF_STR*/"=").second.trim());
        } else if (Feature.startswith(/*STRINGREF_STR*/"no-")) {
          Ret.first.push_back_T$RR($add_T$C$P_string(/*KEEP_STR*/"-", Feature.split(/*STRINGREF_STR*/"-").second.str()));
        } else {
          Ret.first.push_back_T$RR($add_T$C$P_string(/*KEEP_STR*/"+", Feature.str()));
        }
      }
      return new std.pairTypeType<std.vectorString, StringRef>(JD$Move.INSTANCE, Ret);
    } finally {
      if (Ret != null) { Ret.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TargetAttr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/Attrs.inc", line = 6547,
   FQN="clang::TargetAttr::classof", NM="_ZN5clang10TargetAttr7classofEPKNS_4AttrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/AttrImpl.cpp -nm=_ZN5clang10TargetAttr7classofEPKNS_4AttrE")
  //</editor-fold>
  public static boolean classof(/*const*/ Attr /*P*/ A) {
    return A.getKind() == attr.Kind.Target;
  }

  
  @Override public String toString() {
    return "" + "featuresStrLength=" + featuresStrLength // NOI18N
              + ", featuresStr=" + featuresStr // NOI18N
              + super.toString(); // NOI18N
  }
}
