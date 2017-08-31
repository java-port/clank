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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.impl.MicrosoftMangleStatics.*;
import org.clang.basic.llvm.DenseMapInfoIdentifierInfo$Ptr;


/// MicrosoftMangleContextImpl - Overrides the default MangleContext for the
/// Microsoft Visual C++ ABI.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 125,
 FQN="(anonymous namespace)::MicrosoftMangleContextImpl", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImplE")
//</editor-fold>
public class MicrosoftMangleContextImpl extends /*public*/ MicrosoftMangleContext implements Destructors.ClassWithDestructor {
  /*typedef std::pair<const DeclContext *, IdentifierInfo *> DiscriminatorKeyTy*/
//  public final class DiscriminatorKeyTy extends std.pair</*const*/ DeclContext /*P*/ , IdentifierInfo /*P*/ >{ };
  private DenseMapTypeUInt<std.pair</*const*/ DeclContext /*P*/ , IdentifierInfo /*P*/ >> Discriminator;
  private DenseMapTypeUInt</*const*/ NamedDecl /*P*/ > Uniquifier;
  private DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ > LambdaIds;
  private DenseMapTypeUInt</*const*/ NamedDecl /*P*/ > SEHFilterIds;
  private DenseMapTypeUInt</*const*/ NamedDecl /*P*/ > SEHFinallyIds;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::MicrosoftMangleContextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 134,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::MicrosoftMangleContextImpl", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImplC1ERN5clang10ASTContextERNS1_17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImplC1ERN5clang10ASTContextERNS1_17DiagnosticsEngineE")
  //</editor-fold>
  public MicrosoftMangleContextImpl(final ASTContext /*&*/ Context, final DiagnosticsEngine /*&*/ Diags) {
    // : MicrosoftMangleContext(Context, Diags), Discriminator(), Uniquifier(), LambdaIds(), SEHFilterIds(), SEHFinallyIds() 
    //START JInit
    super(Context, Diags);
    this.Discriminator = new DenseMapTypeUInt<std.pair</*const*/ DeclContext /*P*/ , IdentifierInfo /*P*/ >>(
            new DenseMapInfoPair<DeclContext , IdentifierInfo>(DenseMapInfo$LikePtr.$Info(), DenseMapInfoIdentifierInfo$Ptr.$Info()), 0);
    this.Uniquifier = new DenseMapTypeUInt</*const*/ NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.LambdaIds = new DenseMapTypeUInt</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.SEHFilterIds = new DenseMapTypeUInt</*const*/ NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.SEHFinallyIds = new DenseMapTypeUInt</*const*/ NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::shouldMangleCXXName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 364,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::shouldMangleCXXName", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl19shouldMangleCXXNameEPKN5clang9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl19shouldMangleCXXNameEPKN5clang9NamedDeclE")
  //</editor-fold>
  @Override public boolean shouldMangleCXXName(/*const*/ NamedDecl /*P*/ D)/* override*/ {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        LanguageLinkage L = FD.getLanguageLinkage();
        // Overloadable functions need mangling.
        if (FD.hasAttr(OverloadableAttr.class)) {
          return true;
        }
        
        // The ABI expects that we would never mangle "typical" user-defined entry
        // points regardless of visibility or freestanding-ness.
        //
        // N.B. This is distinct from asking about "main".  "main" has a lot of
        // special rules associated with it in the standard while these
        // user-defined entry points are outside of the purview of the standard.
        // For example, there can be only one definition for "main" in a standards
        // compliant program; however nothing forbids the existence of wmain and
        // WinMain in the same translation unit.
        if (FD.isMSVCRTEntryPoint()) {
          return false;
        }
        
        // C++ functions and those whose names are not a simple identifier need
        // mangling.
        if (!FD.getDeclName().isIdentifier() || L == LanguageLinkage.CXXLanguageLinkage) {
          return true;
        }
        
        // C functions are not mangled.
        if (L == LanguageLinkage.CLanguageLinkage) {
          return false;
        }
      }
    }
    
    // Otherwise, no mangling is done outside C++ mode.
    if (!getASTContext().getLangOpts().CPlusPlus) {
      return false;
    }
    {
      
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        // C variables are not mangled.
        if (VD.isExternC()) {
          return false;
        }
        
        // Variables at global scope with non-internal linkage are not mangled.
        /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext(D);
        // Check for extern variable declared locally.
        if (DC.isFunctionOrMethod() && D.hasLinkage()) {
          while (!DC.isNamespace() && !DC.isTranslationUnit()) {
            DC = getEffectiveParentContext(DC);
          }
        }
        if (DC.isTranslationUnit() && D.getFormalLinkage() == Linkage.InternalLinkage
           && !isa_VarTemplateSpecializationDecl(D)
           && D.getIdentifier() != null) {
          return false;
        }
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::shouldMangleStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 418,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::shouldMangleStringLiteral", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl25shouldMangleStringLiteralEPKN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl25shouldMangleStringLiteralEPKN5clang13StringLiteralE")
  //</editor-fold>
  @Override public boolean shouldMangleStringLiteral(/*const*/ StringLiteral /*P*/ SL)/* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2446,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXName", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl13mangleCXXNameEPKN5clang9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl13mangleCXXNameEPKN5clang9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXName(/*const*/ NamedDecl /*P*/ D, 
               final raw_ostream /*&*/ Out)/* override*/ {
    PrettyStackTraceDecl CrashInfo = null;
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      assert ((isa_FunctionDecl(D) || isa_VarDecl(D))) : "Invalid mangleName() call, argument is not a variable or function!";
      assert (!isa_CXXConstructorDecl(D) && !isa_CXXDestructorDecl(D)) : "Invalid mangleName() call on 'structor decl!";
      
      CrashInfo/*J*/= new PrettyStackTraceDecl(D, new SourceLocation(), 
          getASTContext().getSourceManager(), 
          $("Mangling declaration"));
      
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.mangle(D);
      /*JAVA:return*/return;
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
      if (CrashInfo != null) { CrashInfo.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleVirtualMemPtrThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2550,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleVirtualMemPtrThunk", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl24mangleVirtualMemPtrThunkEPKN5clang13CXXMethodDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl24mangleVirtualMemPtrThunkEPKN5clang13CXXMethodDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleVirtualMemPtrThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
                          final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MicrosoftVTableContext /*P*/ VTContext = cast_MicrosoftVTableContext(getASTContext().getVTableContext());
      final /*const*/ MicrosoftVTableContext.MethodVFTableLocation /*&*/ ML = VTContext.getMethodVFTableLocation(new GlobalDecl(MD));
      
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001?");
      Mangler.mangleVirtualMemPtrThunk(MD, ML);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2564,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleThunk", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl11mangleThunkEPKN5clang13CXXMethodDeclERKNS1_9ThunkInfoERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl11mangleThunkEPKN5clang13CXXMethodDeclERKNS1_9ThunkInfoERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
             final /*const*/ ThunkInfo /*&*/ Thunk, 
             final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001?");
      Mangler.mangleName(MD);
      mangleThunkThisAdjustment(MD, Thunk.This, Mangler, MHO);
      if (!Thunk.Return.isEmpty()) {
        assert (Thunk.Method != null) : "Thunk info should hold the overridee decl";
      }
      
      /*const*/ CXXMethodDecl /*P*/ DeclForFPT = (Thunk.Method != null) ? (CXXMethodDecl)Thunk.Method : MD;
      Mangler.mangleFunctionType(DeclForFPT.getType().$arrow().castAs(FunctionProtoType.class), MD);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXDtorThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2581,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXDtorThunk", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl18mangleCXXDtorThunkEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeERKNS1_14ThisAdjustmentERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl18mangleCXXDtorThunkEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeERKNS1_14ThisAdjustmentERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXDtorThunk(/*const*/ CXXDestructorDecl /*P*/ DD, CXXDtorType Type, 
                    final /*const*/ ThisAdjustment /*&*/ Adjustment, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      // FIXME: Actually, the dtor thunk should be emitted for vector deleting
      // dtors rather than scalar deleting dtors. Just use the vector deleting dtor
      // mangling manually until we support both deleting dtor types.
      assert (Type == CXXDtorType.Dtor_Deleting);
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(JD$MicrosoftMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, /*Deref*/this, MHO, DD, Type);
      Mangler.getStream().$out(/*KEEP_STR*/"\001??_E");
      Mangler.mangleName(DD.getParent$Const());
      mangleThunkThisAdjustment(DD, Adjustment, Mangler, MHO);
      Mangler.mangleFunctionType(DD.getType().$arrow().castAs(FunctionProtoType.class), DD);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXVFTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2596,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXVFTable", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl16mangleCXXVFTableEPKN5clang13CXXRecordDeclEN4llvm8ArrayRefIS4_EERNS5_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl16mangleCXXVFTableEPKN5clang13CXXRecordDeclEN4llvm8ArrayRefIS4_EERNS5_11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXVFTable(/*const*/ CXXRecordDecl /*P*/ Derived, ArrayRef</*const*/ CXXRecordDecl /*P*/ > BasePath, 
                  final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      // <mangled-name> ::= ?_7 <class-name> <storage-class>
      //                    <cvr-qualifiers> [<name>] @
      // NOTE: <cvr-qualifiers> here is always 'B' (const). <storage-class>
      // is always '6' for vftables.
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      if (Derived.hasAttr(DLLImportAttr.class)) {
        Mangler.getStream().$out(/*KEEP_STR*/"\001??_S");
      } else {
        Mangler.getStream().$out(/*KEEP_STR*/"\001??_7");
      }
      Mangler.mangleName(Derived);
      Mangler.getStream().$out(/*KEEP_STR*/"6B"); // '6' for vftable, 'B' for const.
      for (/*const*/ CXXRecordDecl /*P*/ RD : BasePath)  {
        Mangler.mangleName(RD);
      }
      Mangler.getStream().$out_char($$AT);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXVBTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2616,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXVBTable", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl16mangleCXXVBTableEPKN5clang13CXXRecordDeclEN4llvm8ArrayRefIS4_EERNS5_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl16mangleCXXVBTableEPKN5clang13CXXRecordDeclEN4llvm8ArrayRefIS4_EERNS5_11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXVBTable(/*const*/ CXXRecordDecl /*P*/ Derived, ArrayRef</*const*/ CXXRecordDecl /*P*/ > BasePath, 
                  final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      // <mangled-name> ::= ?_8 <class-name> <storage-class>
      //                    <cvr-qualifiers> [<name>] @
      // NOTE: <cvr-qualifiers> here is always 'B' (const). <storage-class>
      // is always '7' for vbtables.
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001??_8");
      Mangler.mangleName(Derived);
      Mangler.getStream().$out(/*KEEP_STR*/"7B"); // '7' for vbtable, 'B' for const.
      for (/*const*/ CXXRecordDecl /*P*/ RD : BasePath)  {
        Mangler.mangleName(RD);
      }
      Mangler.getStream().$out_char($$AT);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXVirtualDisplacementMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2648,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXVirtualDisplacementMap", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl31mangleCXXVirtualDisplacementMapEPKN5clang13CXXRecordDeclES4_RN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl31mangleCXXVirtualDisplacementMapEPKN5clang13CXXRecordDeclES4_RN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXVirtualDisplacementMap(/*const*/ CXXRecordDecl /*P*/ SrcRD, /*const*/ CXXRecordDecl /*P*/ DstRD, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001??_K");
      Mangler.mangleName(SrcRD);
      Mangler.getStream().$out(/*KEEP_STR*/"$C");
      Mangler.mangleName(DstRD);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXThrowInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2658,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXThrowInfo", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl18mangleCXXThrowInfoEN5clang8QualTypeEbbbjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl18mangleCXXThrowInfoEN5clang8QualTypeEbbbjRN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXThrowInfo(QualType T, boolean IsConst, 
                    boolean IsVolatile, 
                    boolean IsUnaligned, 
                    /*uint32_t*/int NumEntries, 
                    final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"_TI");
      if (IsConst) {
        Mangler.getStream().$out_char($$C);
      }
      if (IsVolatile) {
        Mangler.getStream().$out_char($$V);
      }
      if (IsUnaligned) {
        Mangler.getStream().$out_char($$U);
      }
      Mangler.getStream().$out_uint(NumEntries);
      Mangler.mangleType(new QualType(T), new SourceRange(), MicrosoftCXXNameMangler.QualifierMangleMode.QMM_Result);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXCatchableTypeArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2676,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXCatchableTypeArray", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl27mangleCXXCatchableTypeArrayEN5clang8QualTypeEjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl27mangleCXXCatchableTypeArrayEN5clang8QualTypeEjRN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXCatchableTypeArray(QualType T, /*uint32_t*/int NumEntries, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"_CTA");
      Mangler.getStream().$out_uint(NumEntries);
      Mangler.mangleType(new QualType(T), new SourceRange(), MicrosoftCXXNameMangler.QualifierMangleMode.QMM_Result);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXCatchableType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2685,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXCatchableType", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl22mangleCXXCatchableTypeEN5clang8QualTypeEPKNS1_18CXXConstructorDeclENS1_11CXXCtorTypeEjjijRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl22mangleCXXCatchableTypeEN5clang8QualTypeEPKNS1_18CXXConstructorDeclENS1_11CXXCtorTypeEjjijRN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXCatchableType(QualType T, /*const*/ CXXConstructorDecl /*P*/ CD, CXXCtorType CT, /*uint32_t*/int Size, 
                        /*uint32_t*/int NVOffset, int/*int32_t*/ VBPtrOffset, /*uint32_t*/int VBIndex, 
                        final raw_ostream /*&*/ Out)/* override*/ {
    MicrosoftCXXNameMangler Mangler = null;
    try {
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out(/*KEEP_STR*/"_CT");
      
      SmallString/*64*/ RTTIMangling/*J*/= new SmallString/*64*/(64);
      {
        raw_svector_ostream Stream = null;
        msvc_hashing_ostream MHO = null;
        try {
          Stream/*J*/= new raw_svector_ostream(RTTIMangling);
          MHO/*J*/= new msvc_hashing_ostream(Stream);
          mangleCXXRTTI(new QualType(T), MHO);
        } finally {
          if (MHO != null) { MHO.$destroy(); }
          if (Stream != null) { Stream.$destroy(); }
        }
      }
      Mangler.getStream().$out(RTTIMangling.substr(1));
      
      // VS2015 CTP6 omits the copy-constructor in the mangled name.  This name is,
      // in fact, superfluous but I'm not sure the change was made consciously.
      SmallString/*64*/ CopyCtorMangling/*J*/= new SmallString/*64*/(64);
      if (!getASTContext().getLangOpts().isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)
         && (CD != null)) {
        raw_svector_ostream Stream = null;
        msvc_hashing_ostream MHO = null;
        try {
          Stream/*J*/= new raw_svector_ostream(CopyCtorMangling);
          MHO/*J*/= new msvc_hashing_ostream(Stream);
          mangleCXXCtor(CD, CT, MHO);
        } finally {
          if (MHO != null) { MHO.$destroy(); }
          if (Stream != null) { Stream.$destroy(); }
        }
      }
      Mangler.getStream().$out(CopyCtorMangling.substr(1));
      
      Mangler.getStream().$out_uint(Size);
      if (VBPtrOffset == -1) {
        if ((NVOffset != 0)) {
          Mangler.getStream().$out_uint(NVOffset);
        }
      } else {
        Mangler.getStream().$out_uint(NVOffset);
        Mangler.getStream().$out_int(VBPtrOffset);
        Mangler.getStream().$out_uint(VBIndex);
      }
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2633,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTI", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl13mangleCXXRTTIEN5clang8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl13mangleCXXRTTIEN5clang8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXRTTI(QualType T, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001??_R0");
      Mangler.mangleType(new QualType(T), new SourceRange(), MicrosoftCXXNameMangler.QualifierMangleMode.QMM_Result);
      Mangler.getStream().$out(/*KEEP_STR*/"@8");
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTIName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2641,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTIName", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl17mangleCXXRTTINameEN5clang8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl17mangleCXXRTTINameEN5clang8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXRTTIName(QualType T, 
                   final raw_ostream /*&*/ Out)/* override*/ {
    MicrosoftCXXNameMangler Mangler = null;
    try {
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out_char($$DOT);
      Mangler.mangleType(new QualType(T), new SourceRange(), MicrosoftCXXNameMangler.QualifierMangleMode.QMM_Result);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTIBaseClassDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2724,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTIBaseClassDescriptor", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl32mangleCXXRTTIBaseClassDescriptorEPKN5clang13CXXRecordDeclEjijjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl32mangleCXXRTTIBaseClassDescriptorEPKN5clang13CXXRecordDeclEjijjRN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXRTTIBaseClassDescriptor(/*const*/ CXXRecordDecl /*P*/ Derived, /*uint32_t*/int NVOffset, int/*int32_t*/ VBPtrOffset, 
                                  /*uint32_t*/int VBTableOffset, /*uint32_t*/int Flags, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001??_R1");
      Mangler.mangleNumber($uint2long(NVOffset));
      Mangler.mangleNumber(VBPtrOffset);
      Mangler.mangleNumber($uint2long(VBTableOffset));
      Mangler.mangleNumber($uint2long(Flags));
      Mangler.mangleName(Derived);
      Mangler.getStream().$out(/*KEEP_STR*/$8);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTIBaseClassArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2738,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTIBaseClassArray", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl27mangleCXXRTTIBaseClassArrayEPKN5clang13CXXRecordDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl27mangleCXXRTTIBaseClassArrayEPKN5clang13CXXRecordDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXRTTIBaseClassArray(/*const*/ CXXRecordDecl /*P*/ Derived, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001??_R2");
      Mangler.mangleName(Derived);
      Mangler.getStream().$out(/*KEEP_STR*/$8);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTIClassHierarchyDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2747,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTIClassHierarchyDescriptor", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl37mangleCXXRTTIClassHierarchyDescriptorEPKN5clang13CXXRecordDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl37mangleCXXRTTIClassHierarchyDescriptorEPKN5clang13CXXRecordDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXRTTIClassHierarchyDescriptor(/*const*/ CXXRecordDecl /*P*/ Derived, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001??_R3");
      Mangler.mangleName(Derived);
      Mangler.getStream().$out(/*KEEP_STR*/$8);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTICompleteObjectLocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2756,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXRTTICompleteObjectLocator", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl34mangleCXXRTTICompleteObjectLocatorEPKN5clang13CXXRecordDeclEN4llvm8ArrayRefIS4_EERNS5_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl34mangleCXXRTTICompleteObjectLocatorEPKN5clang13CXXRecordDeclEN4llvm8ArrayRefIS4_EERNS5_11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXRTTICompleteObjectLocator(/*const*/ CXXRecordDecl /*P*/ Derived, ArrayRef</*const*/ CXXRecordDecl /*P*/ > BasePath, 
                                    final raw_ostream /*&*/ Out)/* override*/ {
    raw_svector_ostream Stream = null;
    try {
      // <mangled-name> ::= ?_R4 <class-name> <storage-class>
      //                    <cvr-qualifiers> [<name>] @
      // NOTE: <cvr-qualifiers> here is always 'B' (const). <storage-class>
      // is always '6' for vftables.
      SmallString/*64*/ VFTableMangling/*J*/= new SmallString/*64*/(64);
      Stream/*J*/= new raw_svector_ostream(VFTableMangling);
      mangleCXXVFTable(Derived, new ArrayRef</*const*/ CXXRecordDecl /*P*/ >(BasePath), Stream);
      if (VFTableMangling.startswith(new StringRef(/*KEEP_STR*/"\001??@"))) {
        assert (VFTableMangling.endswith(new StringRef(/*KEEP_STR*/$AT)));
        Out.$out(VFTableMangling).$out(/*KEEP_STR*/"??_R4@");
        return;
      }
      assert (VFTableMangling.startswith(new StringRef(/*KEEP_STR*/"\001??_7")) || VFTableMangling.startswith(new StringRef(/*KEEP_STR*/"\001??_S")));
      
      Out.$out(/*KEEP_STR*/"\001??_R4").$out(VFTableMangling.$StringRef().drop_front(5));
    } finally {
      if (Stream != null) { Stream.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2803,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleTypeName", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl14mangleTypeNameEN5clang8QualTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl14mangleTypeNameEN5clang8QualTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleTypeName(QualType T, final raw_ostream /*&*/ Out)/* override*/ {
    MicrosoftCXXNameMangler Mangler = null;
    try {
      // This is just a made up unique string for the purposes of tbaa.  undname
      // does *not* know how to demangle it.
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, Out);
      Mangler.getStream().$out_char($$QMARK);
      Mangler.mangleType(new QualType(T), new SourceRange());
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2811,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXCtor", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl13mangleCXXCtorEPKN5clang18CXXConstructorDeclENS1_11CXXCtorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl13mangleCXXCtorEPKN5clang18CXXConstructorDeclENS1_11CXXCtorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXCtor(/*const*/ CXXConstructorDecl /*P*/ D, 
               CXXCtorType Type, 
               final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      mangler/*J*/= new MicrosoftCXXNameMangler(JD$MicrosoftMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, /*Deref*/this, MHO, D, Type);
      mangler.mangle(D);
    } finally {
      if (mangler != null) { mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2819,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleCXXDtor", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl13mangleCXXDtorEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl13mangleCXXDtorEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleCXXDtor(/*const*/ CXXDestructorDecl /*P*/ D, 
               CXXDtorType Type, 
               final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      mangler/*J*/= new MicrosoftCXXNameMangler(JD$MicrosoftMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, /*Deref*/this, MHO, D, Type);
      mangler.mangle(D);
    } finally {
      if (mangler != null) { mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleReferenceTemporary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2827,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleReferenceTemporary", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl24mangleReferenceTemporaryEPKN5clang7VarDeclEjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl24mangleReferenceTemporaryEPKN5clang7VarDeclEjRN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleReferenceTemporary(/*const*/ VarDecl /*P*/ VD, /*uint*/int ManglingNumber, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      
      Mangler.getStream().$out(/*KEEP_STR*/"\001?$RT").$out_uint(ManglingNumber).$out_char($$AT);
      Mangler.mangle(VD, new StringRef(/*KEEP_STR*/$EMPTY));
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleStaticGuardVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2846,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleStaticGuardVariable", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl25mangleStaticGuardVariableEPKN5clang7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl25mangleStaticGuardVariableEPKN5clang7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleStaticGuardVariable(/*const*/ VarDecl /*P*/ VD, 
                           final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      // <guard-name> ::= ?_B <postfix> @5 <scope-depth>
      //              ::= ?__J <postfix> @5 <scope-depth>
      //              ::= ?$S <guard-num> @ <postfix> @4IA
      
      // The first mangling is what MSVC uses to guard static locals in inline
      // functions.  It uses a different mangling in external functions to support
      // guarding more than 32 variables.  MSVC rejects inline functions with more
      // than 32 static locals.  We don't fully implement the second mangling
      // because those guards are not externally visible, and instead use LLVM's
      // default renaming when creating a new guard variable.
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      
      boolean Visible = VD.isExternallyVisible();
      if (Visible) {
        Mangler.getStream().$out(((VD.getTLSKind().getValue() != 0) ? $("\001??__J") : $("\001??_B")));
      } else {
        Mangler.getStream().$out(/*KEEP_STR*/"\001?$S1@");
      }
      uint$ref ScopeDepth = create_uint$ref(0);
      if (Visible && !getNextDiscriminator(VD, ScopeDepth)) {
        // If we do not have a discriminator and are emitting a guard variable for
        // use at global scope, then mangling the nested name will not be enough to
        // remove ambiguities.
        Mangler.mangle(VD, new StringRef(/*KEEP_STR*/$EMPTY));
      } else {
        Mangler.mangleNestedName(VD);
      }
      Mangler.getStream().$out((Visible ? $("@5") : $("@4IA")));
      if ((ScopeDepth.$deref() != 0)) {
        Mangler.mangleNumber($uint2long(ScopeDepth.$deref()));
      }
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleThreadSafeStaticGuardVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2836,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleThreadSafeStaticGuardVariable", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl35mangleThreadSafeStaticGuardVariableEPKN5clang7VarDeclEjRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl35mangleThreadSafeStaticGuardVariableEPKN5clang7VarDeclEjRN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleThreadSafeStaticGuardVariable(/*const*/ VarDecl /*P*/ VD, /*uint*/int GuardNum, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      
      Mangler.getStream().$out(/*KEEP_STR*/"\001?$TSS").$out_uint(GuardNum).$out_char($$AT);
      Mangler.mangleNestedName(VD);
      Mangler.getStream().$out(/*KEEP_STR*/"@4HA");
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleDynamicInitializer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2896,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleDynamicInitializer", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl24mangleDynamicInitializerEPKN5clang7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl24mangleDynamicInitializerEPKN5clang7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleDynamicInitializer(/*const*/ VarDecl /*P*/ D, 
                          final raw_ostream /*&*/ Out)/* override*/ {
    // <initializer-name> ::= ?__E <name> YAXXZ
    mangleInitFiniStub(D, $$E, Out);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleDynamicAtExitDestructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2902,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleDynamicAtExitDestructor", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl29mangleDynamicAtExitDestructorEPKN5clang7VarDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl29mangleDynamicAtExitDestructorEPKN5clang7VarDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleDynamicAtExitDestructor(/*const*/ VarDecl /*P*/ D, 
                               final raw_ostream /*&*/ Out)/* override*/ {
    // <destructor-name> ::= ?__F <name> YAXXZ
    mangleInitFiniStub(D, $$F, Out);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleSEHFilterExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2779,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleSEHFilterExpression", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl25mangleSEHFilterExpressionEPKN5clang9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl25mangleSEHFilterExpressionEPKN5clang9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleSEHFilterExpression(/*const*/ NamedDecl /*P*/ EnclosingDecl, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      // The function body is in the same comdat as the function with the handler,
      // so the numbering here doesn't have to be the same across TUs.
      //
      // <mangled-name> ::= ?filt$ <filter-number> @0
      Mangler.getStream().$out(/*KEEP_STR*/"\001?filt$").$out_uint(SEHFilterIds.ref$at(EnclosingDecl).$set$postInc()).$out(/*KEEP_STR*/"@0@");
      Mangler.mangleName(EnclosingDecl);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleSEHFinallyBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2791,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleSEHFinallyBlock", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl21mangleSEHFinallyBlockEPKN5clang9NamedDeclERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl21mangleSEHFinallyBlockEPKN5clang9NamedDeclERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleSEHFinallyBlock(/*const*/ NamedDecl /*P*/ EnclosingDecl, final raw_ostream /*&*/ Out)/* override*/ {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      // The function body is in the same comdat as the function with the handler,
      // so the numbering here doesn't have to be the same across TUs.
      //
      // <mangled-name> ::= ?fin$ <filter-number> @0
      Mangler.getStream().$out(/*KEEP_STR*/"\001?fin$").$out_uint(SEHFinallyIds.ref$at(EnclosingDecl).$set$postInc()).$out(/*KEEP_STR*/"@0@");
      Mangler.mangleName(EnclosingDecl);
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2909,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleStringLiteral", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl19mangleStringLiteralEPKN5clang13StringLiteralERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl19mangleStringLiteralEPKN5clang13StringLiteralERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void mangleStringLiteral(/*const*/ StringLiteral /*P*/ SL, 
                     final raw_ostream /*&*/ Out)/* override*/ {
    // <char-type> ::= 0   # char
    //             ::= 1   # wchar_t
    //             ::= ??? # char16_t/char32_t will need a mangling too...
    //
    // <literal-length> ::= <non-negative integer>  # the length of the literal
    //
    // <encoded-crc>    ::= <hex digit>+ @          # crc of the literal including
    //                                              # null-terminator
    //
    // <encoded-string> ::= <simple character>           # uninteresting character
    //                  ::= '?$' <hex digit> <hex digit> # these two nibbles
    //                                                   # encode the byte for the
    //                                                   # character
    //                  ::= '?' [a-z]                    # \xe1 - \xfa
    //                  ::= '?' [A-Z]                    # \xc1 - \xda
    //                  ::= '?' [0-9]                    # [,/\:. \n\t'-]
    //
    // <literal> ::= '??_C@_' <char-type> <literal-length> <encoded-crc>
    //               <encoded-string> '@'
    MicrosoftCXXNameMangler Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, Out);
    Mangler.getStream().$out(/*KEEP_STR*/"\001??_C@_");
    
    // <char-type>: The "kind" of string literal is encoded into the mangled name.
    if (SL.isWide()) {
      Mangler.getStream().$out_char($$1);
    } else {
      Mangler.getStream().$out_char($$0);
    }
    
    // <literal-length>: The next part of the mangled name consists of the length
    // of the string.
    // The StringLiteral does not consider the NUL terminator byte(s) but the
    // mangling does.
    // N.B. The length is in terms of bytes, not characters.
    Mangler.mangleNumber($uint2long(SL.getByteLength() + SL.getCharByteWidth()));
    
    Int2Char GetLittleEndianByte = /*[&Mangler, &SL]*/ (/*uint*/int Index) -> {
          /*uint*/int CharByteWidth = SL.getCharByteWidth();
          /*uint32_t*/int CodeUnit = SL.getCodeUnit($div_uint(Index, CharByteWidth));
          /*uint*/int OffsetInCodeUnit = $rem_uint(Index, CharByteWidth);
          return ((/*static_cast*//*char*/byte)($uint2char((CodeUnit >>> (8 * OffsetInCodeUnit)) & 0xff)));
        };
    
    Int2Char GetBigEndianByte = /*[&Mangler, &SL]*/ (/*uint*/int Index) -> {
          /*uint*/int CharByteWidth = SL.getCharByteWidth();
          /*uint32_t*/int CodeUnit = SL.getCodeUnit($div_uint(Index, CharByteWidth));
          /*uint*/int OffsetInCodeUnit = (CharByteWidth - 1) - ($rem_uint(Index, CharByteWidth));
          return ((/*static_cast*//*char*/byte)($uint2char((CodeUnit >>> (8 * OffsetInCodeUnit)) & 0xff)));
        };
    
    // CRC all the bytes of the StringLiteral.
    JamCRC JC/*J*/= new JamCRC();
    for (/*uint*/int I = 0, E = SL.getByteLength(); I != E; ++I)  {
      JC.update(new ArrayRefChar(GetLittleEndianByte.$call(I)));
    }
    
    // The NUL terminator byte(s) were not present earlier,
    // we need to manually process those bytes into the CRC.
    for (/*uint*/int NullTerminator = 0; $less_uint(NullTerminator, SL.getCharByteWidth());
         ++NullTerminator)  {
      JC.update(new ArrayRefChar($$TERM));
    }
    
    // <encoded-crc>: The CRC is encoded utilizing the standard number mangling
    // scheme.
    Mangler.mangleNumber($uint2long(JC.getCRC()));
    
    // <encoded-string>: The mangled name also contains the first 32 _characters_
    // (including null-terminator bytes) of the StringLiteral.
    // Each character is encoded by splitting them into bytes and then encoding
    // the constituent bytes.
    Char2Void MangleByte = /*[&Mangler]*/ (/*char*/byte Byte) -> {
          // There are five different manglings for characters:
          // - [a-zA-Z0-9_$]: A one-to-one mapping.
          // - ?[a-z]: The range from \xe1 to \xfa.
          // - ?[A-Z]: The range from \xc1 to \xda.
          // - ?[0-9]: The set of [,/\:. \n\t'-].
          // - ?$XX: A fallback which maps nibbles.
          if (isIdentifierBody(Byte, /*AllowDollar=*/ true)) {
            Mangler.getStream().$out_char(Byte);
          } else if (isLetter($int2uchar(Byte & 0x7f))) {
            Mangler.getStream().$out_char($$QMARK).$out_char(((/*static_cast*//*char*/byte)(Byte & 0x7f)));
          } else {
            /*const*//*char*/byte SpecialChars[/*10*/] = new$char(10, 
              $$COMMA, $$SLASH, $$BACK_SLASH, $$COLON, $$DOT, 
              $$SPACE, $$LF, $$TAB, $$SGL_QUOTE, $$MINUS);
            /*const*/char$ptr/*char P*/ Pos = $tryClone(std.find(std.begin(SpecialChars), std.end(SpecialChars), Byte));
            if ($noteq_ptr(Pos, std.end(SpecialChars))) {
              Mangler.getStream().$out_char($$QMARK).$out_int((Pos.$sub(std.begin(SpecialChars))));
            } else {
              Mangler.getStream().$out(/*KEEP_STR*/"?$");
              Mangler.getStream().$out_char(((/*static_cast*//*char*/byte)($$A + ((Byte >> 4) & 0xf))));
              Mangler.getStream().$out_char(((/*static_cast*//*char*/byte)($$A + (Byte & 0xf))));
            }
          }
        };
    
    // Enforce our 32 character max.
    /*uint*/int NumCharsToMangle = std.min_uint(32/*U*/, SL.getLength());
    for (/*uint*/int I = 0, E = NumCharsToMangle * SL.getCharByteWidth(); I != E;
         ++I)  {
      if (SL.isWide()) {
        MangleByte.$call(GetBigEndianByte.$call(I));
      } else {
        MangleByte.$call(GetLittleEndianByte.$call(I));
      }
    }
    
    // Encode the NUL terminator if there is room.
    if ($less_uint(NumCharsToMangle, 32)) {
      for (/*uint*/int NullTerminator = 0; $less_uint(NullTerminator, SL.getCharByteWidth());
           ++NullTerminator)  {
        MangleByte.$call((byte)0);
      }
    }
    
    Mangler.getStream().$out_char($$AT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::getNextDiscriminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 196,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::getNextDiscriminator", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl20getNextDiscriminatorEPKN5clang9NamedDeclERj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl20getNextDiscriminatorEPKN5clang9NamedDeclERj")
  //</editor-fold>
  public boolean getNextDiscriminator(/*const*/ NamedDecl /*P*/ ND, final uint$ref/*uint &*/ disc) {
    /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext(ND);
    if (!DC.isFunctionOrMethod()) {
      return false;
    }
    
    // Lambda closure types are already numbered, give out a phony number so
    // that they demangle nicely.
    if (isLambda(ND)) {
      disc.$set(1);
      return true;
    }
    
    // Use the canonical number for externally visible decls.
    if (ND.isExternallyVisible()) {
      disc.$set(getASTContext().getManglingNumber(ND));
      return true;
    }
    {
      
      // Anonymous tags are already numbered.
      /*const*/ TagDecl /*P*/ Tag = dyn_cast_TagDecl(ND);
      if ((Tag != null)) {
        if (!Tag.hasNameForLinkage()
           && !(getASTContext().getDeclaratorForUnnamedTagDecl(Tag) != null)
           && !(getASTContext().getTypedefNameForUnnamedTagDecl(Tag) != null)) {
          return false;
        }
      }
    }
    
    // Make up a reasonable number for internal decls.
    final uint$ref/*uint &*/ discriminator = Uniquifier.ref$at(ND);
    if (!(discriminator.$deref() != 0)) {
      discriminator.$set(Discriminator.ref$at(std.make_pair_Ptr_Ptr(DC, ND.getIdentifier())).$set$preInc());
    }
    disc.$set(discriminator.$deref() + 1);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::getLambdaId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 230,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::getLambdaId", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl11getLambdaIdEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl11getLambdaIdEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public /*uint*/int getLambdaId(/*const*/ CXXRecordDecl /*P*/ RD) {
    assert (RD.isLambda()) : "RD must be a lambda!";
    assert (!RD.isExternallyVisible()) : "RD must not be visible!";
    assert (RD.getLambdaManglingNumber() == 0) : "RD must not have a mangling number!";
    std.pairTypeBool<DenseMapIteratorTypeUInt</*const*/ CXXRecordDecl /*P*/ /*P*/>> Result = LambdaIds.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint(RD, LambdaIds.size()));
    return Result.first.$arrow().second;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::mangleInitFiniStub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 2880,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::mangleInitFiniStub", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl18mangleInitFiniStubEPKN5clang7VarDeclEcRN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImpl18mangleInitFiniStubEPKN5clang7VarDeclEcRN4llvm11raw_ostreamE")
  //</editor-fold>
  private void mangleInitFiniStub(/*const*/ VarDecl /*P*/ D, 
                    /*char*/byte CharCode, 
                    final raw_ostream /*&*/ Out) {
    msvc_hashing_ostream MHO = null;
    MicrosoftCXXNameMangler Mangler = null;
    try {
      MHO/*J*/= new msvc_hashing_ostream(Out);
      Mangler/*J*/= new MicrosoftCXXNameMangler(/*Deref*/this, MHO);
      Mangler.getStream().$out(/*KEEP_STR*/"\001??__").$out_char(CharCode);
      Mangler.mangleName(D);
      if (D.isStaticDataMember()) {
        Mangler.mangleVariableEncoding(D);
        Mangler.getStream().$out_char($$AT);
      }
      // This is the function class mangling.  These stubs are global, non-variadic,
      // cdecl functions that return void and take no args.
      Mangler.getStream().$out(/*KEEP_STR*/"YAXXZ");
    } finally {
      if (Mangler != null) { Mangler.$destroy(); }
      if (MHO != null) { MHO.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftMangleContextImpl::~MicrosoftMangleContextImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp", line = 125,
   FQN="(anonymous namespace)::MicrosoftMangleContextImpl::~MicrosoftMangleContextImpl", NM="_ZN12_GLOBAL__N_126MicrosoftMangleContextImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/MicrosoftMangle.cpp -nm=_ZN12_GLOBAL__N_126MicrosoftMangleContextImplD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    SEHFinallyIds.$destroy();
    SEHFilterIds.$destroy();
    LambdaIds.$destroy();
    Uniquifier.$destroy();
    Discriminator.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Discriminator=" + Discriminator // NOI18N
              + ", Uniquifier=" + Uniquifier // NOI18N
              + ", LambdaIds=" + LambdaIds // NOI18N
              + ", SEHFilterIds=" + SEHFilterIds // NOI18N
              + ", SEHFinallyIds=" + SEHFinallyIds // NOI18N
              + super.toString(); // NOI18N
  }
}
