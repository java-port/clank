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
package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.VersionTuple.*;


//<editor-fold defaultstate="collapsed" desc="static type DeclBaseStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=Tpl__ZL20getNonClosureContextPT_;_ZL14shouldBeHiddenPN5clang9NamedDeclE;_ZL17CheckAvailabilityRN5clang10ASTContextEPKNS_16AvailabilityAttrEPSs;_ZL20isLinkageSpecContextPKN5clang11DeclContextENS_15LinkageSpecDecl11LanguageIDsE;_ZL7getKindPKN5clang11DeclContextE;_ZL7getKindPKN5clang4DeclE; -static-type=DeclBaseStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class DeclBaseStatics {


/// \brief Determine the availability of the given declaration based on
/// the target platform.
///
/// When it returns an availability result other than \c AR_Available,
/// if the \p Message parameter is non-NULL, it will be set to a
/// string describing why the entity is unavailable.
///
/// FIXME: Make these strings localizable, since they end up in
/// diagnostics.
//<editor-fold defaultstate="collapsed" desc="CheckAvailability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 402,
 FQN="CheckAvailability", NM="_ZL17CheckAvailabilityRN5clang10ASTContextEPKNS_16AvailabilityAttrEPSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL17CheckAvailabilityRN5clang10ASTContextEPKNS_16AvailabilityAttrEPSs")
//</editor-fold>
public static AvailabilityResult CheckAvailability(final ASTContext /*&*/ Context, 
                 /*const*/ AvailabilityAttr /*P*/ A, 
                 std.string/*P*/ Message) {
  VersionTuple TargetMinVersion = Context.getTargetInfo().getPlatformMinVersion();
  if (TargetMinVersion.empty()) {
    return AvailabilityResult.AR_Available;
  }
  
  // Check if this is an App Extension "platform", and if so chop off
  // the suffix for matching with the actual platform.
  StringRef ActualPlatform = A.getPlatform().getName();
  StringRef RealizedPlatform = new StringRef(ActualPlatform);
  if (Context.getLangOpts().AppExt) {
    /*size_t*/int suffix = RealizedPlatform.rfind(/*STRINGREF_STR*/"_app_extension");
    if (suffix != StringRef.npos) {
      RealizedPlatform.$assignMove(RealizedPlatform.slice(0, suffix));
    }
  }
  
  StringRef TargetPlatform = Context.getTargetInfo().getPlatformName();
  
  // Match the platform name.
  if ($noteq_StringRef(/*NO_COPY*/RealizedPlatform, /*NO_COPY*/TargetPlatform)) {
    return AvailabilityResult.AR_Available;
  }
  
  StringRef PrettyPlatformName = AvailabilityAttr.getPrettyPlatformName(new StringRef(ActualPlatform));
  if (PrettyPlatformName.empty()) {
    PrettyPlatformName.$assign(ActualPlatform);
  }
  
  std.string HintMessage/*J*/= new std.string();
  if (!A.getMessage().empty()) {
    HintMessage.$assign_T$C$P(/*KEEP_STR*/" - ");
    $addassign_string_StringRef(HintMessage, A.getMessage());
  }
  
  // Make sure that this declaration has not been marked 'unavailable'.
  if (A.getUnavailable()) {
    if ((Message != null)) {
      raw_string_ostream Out = null;
      try {
        Message.clear();
        Out/*J*/= new raw_string_ostream($Deref(Message));
        Out.$out(/*KEEP_STR*/"not available on ").$out(/*NO_COPY*/PrettyPlatformName).$out(
            HintMessage
        );
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    
    return AvailabilityResult.AR_Unavailable;
  }
  
  // Make sure that this declaration has already been introduced.
  if (!A.getIntroduced().empty()
     && $less_VersionTuple$C(TargetMinVersion, A.getIntroduced())) {
    if ((Message != null)) {
      raw_string_ostream Out = null;
      try {
        Message.clear();
        Out/*J*/= new raw_string_ostream($Deref(Message));
        VersionTuple VTI/*J*/= A.getIntroduced();
        VTI.UseDotAsSeparator();
        $out_raw_ostream_VersionTuple$C(Out.$out(/*KEEP_STR*/"introduced in ").$out(/*NO_COPY*/PrettyPlatformName).$out_char($$SPACE), 
            VTI).$out(HintMessage);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    
    return A.getStrict() ? AvailabilityResult.AR_Unavailable : AvailabilityResult.AR_NotYetIntroduced;
  }
  
  // Make sure that this declaration hasn't been obsoleted.
  if (!A.getObsoleted().empty() && $greatereq_VersionTuple$C(TargetMinVersion, A.getObsoleted())) {
    if ((Message != null)) {
      raw_string_ostream Out = null;
      try {
        Message.clear();
        Out/*J*/= new raw_string_ostream($Deref(Message));
        VersionTuple VTO/*J*/= A.getObsoleted();
        VTO.UseDotAsSeparator();
        $out_raw_ostream_VersionTuple$C(Out.$out(/*KEEP_STR*/"obsoleted in ").$out(/*NO_COPY*/PrettyPlatformName).$out_char($$SPACE), 
            VTO).$out(HintMessage);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    
    return AvailabilityResult.AR_Unavailable;
  }
  
  // Make sure that this declaration hasn't been deprecated.
  if (!A.getDeprecated().empty() && $greatereq_VersionTuple$C(TargetMinVersion, A.getDeprecated())) {
    if ((Message != null)) {
      raw_string_ostream Out = null;
      try {
        Message.clear();
        Out/*J*/= new raw_string_ostream($Deref(Message));
        VersionTuple VTD/*J*/= A.getDeprecated();
        VTD.UseDotAsSeparator();
        $out_raw_ostream_VersionTuple$C(Out.$out(/*KEEP_STR*/"first deprecated in ").$out(/*NO_COPY*/PrettyPlatformName).$out_char($$SPACE), 
            VTD).$out(HintMessage);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    
    return AvailabilityResult.AR_Deprecated;
  }
  
  return AvailabilityResult.AR_Available;
}

//<editor-fold defaultstate="collapsed" desc="getKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 810,
 FQN="getKind", NM="_ZL7getKindPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL7getKindPKN5clang4DeclE")
//</editor-fold>
public static Decl.Kind getKind(/*const*/ Decl /*P*/ D) {
  return D.getKind();
}

//<editor-fold defaultstate="collapsed" desc="getKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 811,
 FQN="getKind", NM="_ZL7getKindPKN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL7getKindPKN5clang11DeclContextE")
//</editor-fold>
public static Decl.Kind getKind(/*const*/ DeclContext /*P*/ DC) {
  return DC.getDeclKind();
}


/// Starting at a given context (a Decl or DeclContext), look for a
/// code context that is not a closure (a lambda, block, etc.).
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getNonClosureContext">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 833,
 FQN="getNonClosureContext", NM="Tpl__ZL20getNonClosureContextPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=Tpl__ZL20getNonClosureContextPT_")
//</editor-fold>
public static </*class*/ T extends Decl> Decl /*P*/ getNonClosureContext$T(T /*P*/ D) {
  if (Native.$eq(getKind(D), Decl.Kind.CXXMethod)) {
    CXXMethodDecl /*P*/ MD = cast/*<CXXMethodDecl>*/(CXXMethodDecl.class, D);
    if (MD.getOverloadedOperator() == OverloadedOperatorKind.OO_Call
       && MD.getParent().isLambda()) {
      return getNonClosureContext$T(MD.getParent().getParent());
    }
    return MD;
  } else {
    FunctionDecl /*P*/ FD = dyn_cast/*<FunctionDecl>*/(FunctionDecl.class, D);
    if ((FD != null)) {
      return FD;
    } else {
      ObjCMethodDecl /*P*/ MD = dyn_cast/*<ObjCMethodDecl>*/(ObjCMethodDecl.class, D);
      if ((MD != null)) {
        return MD;
      } else {
        BlockDecl /*P*/ BD = dyn_cast/*<BlockDecl>*/(BlockDecl.class, D);
        if ((BD != null)) {
          return getNonClosureContext$T(BD.getParent());
        } else {
          CapturedDecl /*P*/ CD = dyn_cast/*<CapturedDecl>*/(CapturedDecl.class, D);
          if ((CD != null)) {
            return getNonClosureContext$T(CD.getParent());
          } else {
            return null;
          }
        }
      }
    }
  }
}
//<editor-fold defaultstate="collapsed" desc="getNonClosureContext">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 833,
 FQN="getNonClosureContext", NM="Tpl__ZL20getNonClosureContextPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=Tpl__ZL20getNonClosureContextPT_")
//</editor-fold>
public static </*class*/ T extends DeclContext> Decl /*P*/ getNonClosureContext$T(T /*P*/ D) {
  if (Native.$eq(getKind(D), Decl.Kind.CXXMethod)) {
    CXXMethodDecl /*P*/ MD = cast/*<CXXMethodDecl>*/(CXXMethodDecl.class, D);
    if (MD.getOverloadedOperator() == OverloadedOperatorKind.OO_Call
       && MD.getParent().isLambda()) {
      return getNonClosureContext$T(MD.getParent().getParent());
    }
    return MD;
  } else {
    FunctionDecl /*P*/ FD = dyn_cast/*<FunctionDecl>*/(FunctionDecl.class, D);
    if ((FD != null)) {
      return FD;
    } else {
      ObjCMethodDecl /*P*/ MD = dyn_cast/*<ObjCMethodDecl>*/(ObjCMethodDecl.class, D);
      if ((MD != null)) {
        return MD;
      } else {
        BlockDecl /*P*/ BD = dyn_cast/*<BlockDecl>*/(BlockDecl.class, D);
        if ((BD != null)) {
          return getNonClosureContext$T(BD.getParent());
        } else {
          CapturedDecl /*P*/ CD = dyn_cast/*<CapturedDecl>*/(CapturedDecl.class, D);
          if ((CD != null)) {
            return getNonClosureContext$T(CD.getParent());
          } else {
            return null;
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="isLinkageSpecContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 963,
 FQN="isLinkageSpecContext", NM="_ZL20isLinkageSpecContextPKN5clang11DeclContextENS_15LinkageSpecDecl11LanguageIDsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL20isLinkageSpecContextPKN5clang11DeclContextENS_15LinkageSpecDecl11LanguageIDsE")
//</editor-fold>
public static boolean isLinkageSpecContext(/*const*/ DeclContext /*P*/ DC, 
                    /*LinkageSpecDecl::LanguageIDs*//*uint*/int ID) {
  while (DC.getDeclKind() != Decl.Kind.TranslationUnit) {
    if (DC.getDeclKind() == Decl.Kind.LinkageSpec) {
      return cast_LinkageSpecDecl(DC).getLanguage() == ID;
    }
    DC = DC.getLexicalParent$Const();
  }
  return false;
}


/// shouldBeHidden - Determine whether a declaration which was declared
/// within its semantic context should be invisible to qualified name lookup.
//<editor-fold defaultstate="collapsed" desc="shouldBeHidden">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 1314,
 FQN="shouldBeHidden", NM="_ZL14shouldBeHiddenPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZL14shouldBeHiddenPN5clang9NamedDeclE")
//</editor-fold>
public static boolean shouldBeHidden(NamedDecl /*P*/ D) {
  // Skip unnamed declarations.
  if (!D.getDeclName().$bool()) {
    return true;
  }
  
  // Skip entities that can't be found by name lookup into a particular
  // context.
  if ((D.getIdentifierNamespace() == 0 && !isa_UsingDirectiveDecl(D))
     || D.isTemplateParameter()) {
    return true;
  }
  
  // Skip template specializations.
  // FIXME: This feels like a hack. Should DeclarationName support
  // template-ids, or is there a better way to keep specializations
  // from being visible?
  if (isa_ClassTemplateSpecializationDecl(D)) {
    return true;
  }
  {
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.isFunctionTemplateSpecialization()) {
        return true;
      }
    }
  }
  
  return false;
}

} // END OF class DeclBaseStatics
