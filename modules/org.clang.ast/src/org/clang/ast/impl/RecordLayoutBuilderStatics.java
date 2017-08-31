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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.basic.target.*;


//<editor-fold defaultstate="collapsed" desc="static type RecordLayoutBuilderStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL10isMsLayoutRKN5clang10ASTContextE;_ZL11PrintOffsetRN4llvm11raw_ostreamEN5clang9CharUnitsEj;_ZL13recordUsesEBOPKN5clang10RecordDeclE;_ZL14getFieldOffsetRKN5clang10ASTContextEPKNS_9FieldDeclE;_ZL16DumpRecordLayoutRN4llvm11raw_ostreamEPKN5clang10RecordDeclERKNS2_10ASTContextENS2_9CharUnitsEjPKcbb;_ZL16RequiresVtordispRKN4llvm15SmallPtrSetImplIPKN5clang13CXXRecordDeclEEES4_;_ZL18computeKeyFunctionRN5clang10ASTContextEPKNS_13CXXRecordDeclE;_ZL19PrintBitFieldOffsetRN4llvm11raw_ostreamEN5clang9CharUnitsEjjj;_ZL19PrintIndentNoOffsetRN4llvm11raw_ostreamEj;_ZL19mustSkipTailPaddingN5clang12TargetCXXABIEPKNS_13CXXRecordDeclE;_ZL25getPaddingDiagFromTagKindN5clang11TagTypeKindE;_ZL26roundUpSizeToCharAlignmentyRKN5clang10ASTContextE; -static-type=RecordLayoutBuilderStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class RecordLayoutBuilderStatics {


// Rounds the specified size to have it a multiple of the char size.
//<editor-fold defaultstate="collapsed" desc="roundUpSizeToCharAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1362,
 FQN="roundUpSizeToCharAlignment", NM="_ZL26roundUpSizeToCharAlignmentyRKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL26roundUpSizeToCharAlignmentyRKN5clang10ASTContextE")
//</editor-fold>
public static long/*uint64_t*/ roundUpSizeToCharAlignment(long/*uint64_t*/ Size, 
                          final /*const*/ ASTContext /*&*/ Context) {
  long/*uint64_t*/ CharAlignment = $uint2ulong(Context.getTargetInfo().getCharAlign());
  return llvm.alignTo(Size, CharAlignment);
}


/// \brief Get diagnostic %select index for tag kind for
/// field padding diagnostic message.
/// WARNING: Indexes apply to particular diagnostics only!
///
/// \returns diagnostic %select index.
//<editor-fold defaultstate="collapsed" desc="getPaddingDiagFromTagKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1935,
 FQN="getPaddingDiagFromTagKind", NM="_ZL25getPaddingDiagFromTagKindN5clang11TagTypeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL25getPaddingDiagFromTagKindN5clang11TagTypeKindE")
//</editor-fold>
public static /*uint*/int getPaddingDiagFromTagKind(TagTypeKind Tag) {
  switch (Tag) {
   case TTK_Struct:
    return 0;
   case TTK_Interface:
    return 1;
   case TTK_Class:
    return 2;
   default:
    throw new llvm_unreachable("Invalid tag kind for field padding diagnostic!");
  }
}

//<editor-fold defaultstate="collapsed" desc="computeKeyFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 1989,
 FQN="computeKeyFunction", NM="_ZL18computeKeyFunctionRN5clang10ASTContextEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL18computeKeyFunctionRN5clang10ASTContextEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static /*const*/ CXXMethodDecl /*P*/ computeKeyFunction(final ASTContext /*&*/ Context, 
                  /*const*/ CXXRecordDecl /*P*/ RD) {
  // If a class isn't polymorphic it doesn't have a key function.
  if (!RD.isPolymorphic()) {
    return null;
  }
  
  // A class that is not externally visible doesn't have a key function. (Or
  // at least, there's no point to assigning a key function to such a class;
  // this doesn't affect the ABI.)
  if (!RD.isExternallyVisible()) {
    return null;
  }
  
  // Template instantiations don't have key functions per Itanium C++ ABI 5.2.6.
  // Same behavior as GCC.
  TemplateSpecializationKind TSK = RD.getTemplateSpecializationKind();
  if (TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation
     || TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration
     || TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
    return null;
  }
  
  boolean allowInlineFunctions = Context.getTargetInfo().getCXXABI().canKeyFunctionBeInline();
  
  for (/*const*/ CXXMethodDecl /*P*/ MD : RD.methods()) {
    if (!MD.isVirtual()) {
      continue;
    }
    if (MD.isPure()) {
      continue;
    }
    
    // Ignore implicit member functions, they are always marked as inline, but
    // they don't have a body until they're defined.
    if (MD.isImplicit()) {
      continue;
    }
    if (MD.isInlineSpecified()) {
      continue;
    }
    if (MD.hasInlineBody()) {
      continue;
    }
    
    // Ignore inline deleted or defaulted functions.
    if (!MD.isUserProvided()) {
      continue;
    }
    
    // In certain ABIs, ignore functions with out-of-line inline definitions.
    if (!allowInlineFunctions) {
      type$ref</*const*/ FunctionDecl /*P*/ > Def = create_type$ref();
      if (MD.hasBody(Def) && Def.$deref().isInlineSpecified()) {
        continue;
      }
    }
    if (Context.getLangOpts().CUDA) {
      // While compiler may see key method in this TU, during CUDA
      // compilation we should ignore methods that are not accessible
      // on this side of compilation.
      if (Context.getLangOpts().CUDAIsDevice) {
        // In device mode ignore methods without __device__ attribute.
        if (!MD.hasAttr(CUDADeviceAttr.class)) {
          continue;
        }
      } else {
        // In host mode ignore __device__-only methods.
        if (!MD.hasAttr(CUDAHostAttr.class) && MD.hasAttr(CUDADeviceAttr.class)) {
          continue;
        }
      }
    }
    
    // If the key function is dllimport but the class isn't, then the class has
    // no key function. The DLL that exports the key function won't export the
    // vtable in this case.
    if (MD.hasAttr(DLLImportAttr.class) && !RD.hasAttr(DLLImportAttr.class)) {
      return null;
    }
    
    // We found it.
    return MD;
  }
  
  return null;
}


/// Does the target C++ ABI require us to skip over the tail-padding
/// of the given class (considering it as a base class) when allocating
/// objects?
//<editor-fold defaultstate="collapsed" desc="mustSkipTailPadding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2077,
 FQN="mustSkipTailPadding", NM="_ZL19mustSkipTailPaddingN5clang12TargetCXXABIEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL19mustSkipTailPaddingN5clang12TargetCXXABIEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static boolean mustSkipTailPadding(TargetCXXABI ABI, /*const*/ CXXRecordDecl /*P*/ RD) {
  switch (ABI.getTailPaddingUseRules()) {
   case AlwaysUseTailPadding:
    return false;
   case UseTailPaddingUnlessPOD03:
    // FIXME: To the extent that this is meant to cover the Itanium ABI
    // rules, we should implement the restrictions about over-sized
    // bitfields:
    //
    // http://mentorembedded.github.com/cxx-abi/abi.html#POD :
    //   In general, a type is considered a POD for the purposes of
    //   layout if it is a POD type (in the sense of ISO C++
    //   [basic.types]). However, a POD-struct or POD-union (in the
    //   sense of ISO C++ [class]) with a bitfield member whose
    //   declared width is wider than the declared type of the
    //   bitfield is not a POD for the purpose of layout.  Similarly,
    //   an array type is not a POD for the purpose of layout if the
    //   element type of the array is not a POD for the purpose of
    //   layout.
    //
    //   Where references to the ISO C++ are made in this paragraph,
    //   the Technical Corrigendum 1 version of the standard is
    //   intended.
    return RD.isPOD();
   case UseTailPaddingUnlessPOD11:
    // This is equivalent to RD->getTypeForDecl().isCXX11PODType(),
    // but with a lot of abstraction penalty stripped off.  This does
    // assume that these properties are set correctly even in C++98
    // mode; fortunately, that is true because we want to assign
    // consistently semantics to the type-traits intrinsics (or at
    // least as many of them as possible).
    return RD.isTrivial() && RD.isStandardLayout();
  }
  throw new llvm_unreachable("bad tail-padding use kind");
}

//<editor-fold defaultstate="collapsed" desc="isMsLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2116,
 FQN="isMsLayout", NM="_ZL10isMsLayoutRKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL10isMsLayoutRKN5clang10ASTContextE")
//</editor-fold>
public static boolean isMsLayout(final /*const*/ ASTContext /*&*/ Context) {
  return Context.getTargetInfo().getCXXABI().isMicrosoft();
}

//<editor-fold defaultstate="collapsed" desc="recordUsesEBO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2547,
 FQN="recordUsesEBO", NM="_ZL13recordUsesEBOPKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL13recordUsesEBOPKN5clang10RecordDeclE")
//</editor-fold>
public static boolean recordUsesEBO(/*const*/ RecordDecl /*P*/ RD) {
  if (!isa_CXXRecordDecl(RD)) {
    return false;
  }
  if (RD.hasAttr(EmptyBasesAttr.class)) {
    return true;
  }
  {
    LayoutVersionAttr /*P*/ LVA = RD.getAttr(LayoutVersionAttr.class);
    if ((LVA != null)) {
      // TODO: Double check with the next version of MSVC.
      if ($lesseq_uint(LVA.getVersion(), LangOptions.MSVCMajorVersion.MSVC2015.getValue())) {
        return false;
      }
    }
  }
  // TODO: Some later version of MSVC will change the default behavior of the
  // compiler to enable EBO by default.  When this happens, we will need an
  // additional isCompatibleWithMSVC check.
  return false;
}


// Recursively walks the non-virtual bases of a class and determines if any of
// them are in the bases with overridden methods set.
//<editor-fold defaultstate="collapsed" desc="RequiresVtordisp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 2837,
 FQN="RequiresVtordisp", NM="_ZL16RequiresVtordispRKN4llvm15SmallPtrSetImplIPKN5clang13CXXRecordDeclEEES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL16RequiresVtordispRKN4llvm15SmallPtrSetImplIPKN5clang13CXXRecordDeclEEES4_")
//</editor-fold>
public static boolean RequiresVtordisp(final /*const*/ SmallPtrSetImpl</*const*/ CXXRecordDecl /*P*/ > /*&*/ BasesWithOverriddenMethods, 
                /*const*/ CXXRecordDecl /*P*/ RD) {
  if ((BasesWithOverriddenMethods.count(RD) != 0)) {
    return true;
  }
  // If any of a virtual bases non-virtual bases (recursively) requires a
  // vtordisp than so does this virtual base.
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const())  {
    if (!Base.isVirtual()
       && RequiresVtordisp(BasesWithOverriddenMethods, 
        Base.getType().$arrow().getAsCXXRecordDecl())) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getFieldOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3056,
 FQN="getFieldOffset", NM="_ZL14getFieldOffsetRKN5clang10ASTContextEPKNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL14getFieldOffsetRKN5clang10ASTContextEPKNS_9FieldDeclE")
//</editor-fold>
public static long/*uint64_t*/ getFieldOffset(final /*const*/ ASTContext /*&*/ C, /*const*/ FieldDecl /*P*/ FD) {
  final /*const*/ ASTRecordLayout /*&*/ Layout = C.getASTRecordLayout(FD.getParent$Const());
  return Layout.getFieldOffset(FD.getFieldIndex());
}

//<editor-fold defaultstate="collapsed" desc="PrintOffset">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, // convert format to java style
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3123,
 FQN="PrintOffset", NM="_ZL11PrintOffsetRN4llvm11raw_ostreamEN5clang9CharUnitsEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL11PrintOffsetRN4llvm11raw_ostreamEN5clang9CharUnitsEj")
//</editor-fold>
public static void PrintOffset(final raw_ostream /*&*/ OS, 
           CharUnits Offset, /*uint*/int IndentLevel) {
  OS.$out(llvm.format($("%10d | "), (long/*int64_t*/)Offset.getQuantity()));
  OS.indent(IndentLevel * 2);
}

//<editor-fold defaultstate="collapsed" desc="PrintBitFieldOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3129,
 FQN="PrintBitFieldOffset", NM="_ZL19PrintBitFieldOffsetRN4llvm11raw_ostreamEN5clang9CharUnitsEjjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL19PrintBitFieldOffsetRN4llvm11raw_ostreamEN5clang9CharUnitsEjjj")
//</editor-fold>
public static void PrintBitFieldOffset(final raw_ostream /*&*/ OS, CharUnits Offset, 
                   /*uint*/int Begin, /*uint*/int Width, 
                   /*uint*/int IndentLevel) {
  SmallString/*10*/ Buffer/*J*/= new SmallString/*10*/(10);
  {
    raw_svector_ostream BufferOS = null;
    try {
      BufferOS/*J*/= new raw_svector_ostream(Buffer);
      BufferOS.$out_llong(Offset.getQuantity()).$out_char($$COLON);
      if (Width == 0) {
        BufferOS.$out_char($$MINUS);
      } else {
        BufferOS.$out_uint(Begin).$out_char($$MINUS).$out_uint((Begin + Width - 1));
      }
    } finally {
      if (BufferOS != null) { BufferOS.$destroy(); }
    }
  }
  
  OS.$out(llvm.right_justify(Buffer.$StringRef(), 10)).$out(/*KEEP_STR*/" | ");
  OS.indent(IndentLevel * 2);
}

//<editor-fold defaultstate="collapsed" desc="PrintIndentNoOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3147,
 FQN="PrintIndentNoOffset", NM="_ZL19PrintIndentNoOffsetRN4llvm11raw_ostreamEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL19PrintIndentNoOffsetRN4llvm11raw_ostreamEj")
//</editor-fold>
public static void PrintIndentNoOffset(final raw_ostream /*&*/ OS, /*uint*/int IndentLevel) {
  OS.$out(/*KEEP_STR*/"           | ");
  OS.indent(IndentLevel * 2);
}

//<editor-fold defaultstate="collapsed" desc="DumpRecordLayout">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp", line = 3152,
 FQN="DumpRecordLayout", NM="_ZL16DumpRecordLayoutRN4llvm11raw_ostreamEPKN5clang10RecordDeclERKNS2_10ASTContextENS2_9CharUnitsEjPKcbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/RecordLayoutBuilder.cpp -nm=_ZL16DumpRecordLayoutRN4llvm11raw_ostreamEPKN5clang10RecordDeclERKNS2_10ASTContextENS2_9CharUnitsEjPKcbb")
//</editor-fold>
public static void DumpRecordLayout(final raw_ostream /*&*/ OS, /*const*/ RecordDecl /*P*/ RD, 
                final /*const*/ ASTContext /*&*/ C, 
                CharUnits Offset, 
                /*uint*/int IndentLevel, 
                /*const*/char$ptr/*char P*/ Description, 
                boolean PrintSizeInfo, 
                boolean IncludeVirtualBases) {
  final /*const*/ ASTRecordLayout /*&*/ Layout = C.getASTRecordLayout(RD);
  /*const*/ CXXRecordDecl /*P*/ CXXRD = dyn_cast_CXXRecordDecl(RD);
  
  PrintOffset(OS, new CharUnits(Offset), IndentLevel);
  OS.$out(C.getTypeDeclType(((/*const_cast*/RecordDecl /*P*/ )(RD))).getAsString());
  if (Native.$bool(Description)) {
    OS.$out_char($$SPACE).$out(Description);
  }
  if ((CXXRD != null) && CXXRD.isEmpty()) {
    OS.$out(/*KEEP_STR*/" (empty)");
  }
  OS.$out_char($$LF);
  
  IndentLevel++;
  
  // Dump bases.
  if ((CXXRD != null)) {
    /*const*/ CXXRecordDecl /*P*/ PrimaryBase = Layout.getPrimaryBase();
    boolean HasOwnVFPtr = Layout.hasOwnVFPtr();
    boolean HasOwnVBPtr = Layout.hasOwnVBPtr();
    
    // Vtable pointer.
    if (CXXRD.isDynamicClass() && !(PrimaryBase != null) && !isMsLayout(C)) {
      PrintOffset(OS, new CharUnits(Offset), IndentLevel);
      $out_raw_ostream_NamedDecl$C(OS.$out_char($$LPAREN), $Deref(RD)).$out(/*KEEP_STR*/" vtable pointer)\n");
    } else if (HasOwnVFPtr) {
      PrintOffset(OS, new CharUnits(Offset), IndentLevel);
      // vfptr (for Microsoft C++ ABI)
      $out_raw_ostream_NamedDecl$C(OS.$out_char($$LPAREN), $Deref(RD)).$out(/*KEEP_STR*/" vftable pointer)\n");
    }
    
    // Collect nvbases.
    SmallVector</*const*/ CXXRecordDecl /*P*/ > Bases/*J*/= new SmallVector</*const*/ CXXRecordDecl /*P*/ >(4, (/*const*/ CXXRecordDecl /*P*/ )null);
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : CXXRD.bases$Const()) {
      assert (!Base.getType().$arrow().isDependentType()) : "Cannot layout class with dependent bases.";
      if (!Base.isVirtual()) {
        Bases.push_back(Base.getType().$arrow().getAsCXXRecordDecl());
      }
    }
    
    // Sort nvbases by offset.
    std.stable_sort(Bases.begin(), Bases.end(), 
        /*[&, &Layout]*/ (/*const*/ CXXRecordDecl /*P*/ L, /*const*/ CXXRecordDecl /*P*/ R) -> {
              return Layout.getBaseClassOffset(L).$less(Layout.getBaseClassOffset(R));
            });
    
    // Dump (non-virtual) bases
    for (/*const*/ CXXRecordDecl /*P*/ Base : Bases) {
      CharUnits BaseOffset = Offset.$add(Layout.getBaseClassOffset(Base));
      DumpRecordLayout(OS, Base, C, new CharUnits(BaseOffset), IndentLevel, 
          Base == PrimaryBase ? $("(primary base)") : $("(base)"), 
          /*PrintSizeInfo=*/ false, 
          /*IncludeVirtualBases=*/ false);
    }
    
    // vbptr (for Microsoft C++ ABI)
    if (HasOwnVBPtr) {
      PrintOffset(OS, Offset.$add(Layout.getVBPtrOffset()), IndentLevel);
      $out_raw_ostream_NamedDecl$C(OS.$out_char($$LPAREN), $Deref(RD)).$out(/*KEEP_STR*/" vbtable pointer)\n");
    }
  }
  
  // Dump fields.
  long/*uint64_t*/ FieldNo = 0;
  for (specific_decl_iterator<FieldDecl> I = RD.field_begin(), 
      E = RD.field_end(); $noteq_specific_decl_iterator$SpecificDecl$C(I, E); I.$preInc() , ++FieldNo) {
    final /*const*/ FieldDecl /*&*/ Field = $Deref(I.$star());
    long/*uint64_t*/ LocalFieldOffsetInBits = Layout.getFieldOffset($ulong2uint(FieldNo));
    CharUnits FieldOffset = Offset.$add(C.toCharUnitsFromBits(LocalFieldOffsetInBits));
    {
      
      // Recursively dump fields of record type.
      /*const*/ RecordType /*P*/ RT = Field.getType().$arrow().<RecordType>getAs$RecordType();
      if ((RT != null)) {
        DumpRecordLayout(OS, RT.getDecl(), C, new CharUnits(FieldOffset), IndentLevel, 
            Field.getName().data(), 
            /*PrintSizeInfo=*/ false, 
            /*IncludeVirtualBases=*/ true);
        continue;
      }
    }
    if (Field.isBitField()) {
      long/*uint64_t*/ LocalFieldByteOffsetInBits = C.toBits(FieldOffset.$sub(Offset));
      /*uint*/int Begin = $ullong2uint(LocalFieldOffsetInBits - LocalFieldByteOffsetInBits);
      /*uint*/int Width = Field.getBitWidthValue(C);
      PrintBitFieldOffset(OS, new CharUnits(FieldOffset), Begin, Width, IndentLevel);
    } else {
      PrintOffset(OS, new CharUnits(FieldOffset), IndentLevel);
    }
    $out_raw_ostream_NamedDecl$C(OS.$out(Field.getType().getAsString()).$out_char($$SPACE), Field).$out_char($$LF);
  }
  
  // Dump virtual bases.
  if ((CXXRD != null) && IncludeVirtualBases) {
    final /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , ASTRecordLayout.VBaseInfo> /*&*/ VtorDisps = Layout.getVBaseOffsetsMap();
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : CXXRD.vbases$Const()) {
      assert (Base.isVirtual()) : "Found non-virtual class!";
      /*const*/ CXXRecordDecl /*P*/ VBase = Base.getType().$arrow().getAsCXXRecordDecl();
      
      CharUnits VBaseOffset = Offset.$add(Layout.getVBaseClassOffset(VBase));
      if (VtorDisps.find$Const(VBase).$arrow().second.hasVtorDisp()) {
        PrintOffset(OS, VBaseOffset.$sub(CharUnits.fromQuantity(4)), IndentLevel);
        $out_raw_ostream_NamedDecl$C(OS.$out(/*KEEP_STR*/"(vtordisp for vbase "), $Deref(VBase)).$out(/*KEEP_STR*/")\n");
      }
      
      DumpRecordLayout(OS, VBase, C, new CharUnits(VBaseOffset), IndentLevel, 
          VBase == Layout.getPrimaryBase() ? $("(primary virtual base)") : $("(virtual base)"), 
          /*PrintSizeInfo=*/ false, 
          /*IncludeVirtualBases=*/ false);
    }
  }
  if (!PrintSizeInfo) {
    return;
  }
  
  PrintIndentNoOffset(OS, IndentLevel - 1);
  OS.$out(/*KEEP_STR*/"[sizeof=").$out_llong(Layout.getSize().getQuantity());
  if ((CXXRD != null) && !isMsLayout(C)) {
    OS.$out(/*KEEP_STR*/", dsize=").$out_llong(Layout.getDataSize().getQuantity());
  }
  OS.$out(/*KEEP_STR*/", align=").$out_llong(Layout.getAlignment().getQuantity());
  if ((CXXRD != null)) {
    OS.$out(/*KEEP_STR*/",\n");
    PrintIndentNoOffset(OS, IndentLevel - 1);
    OS.$out(/*KEEP_STR*/" nvsize=").$out_llong(Layout.getNonVirtualSize().getQuantity());
    OS.$out(/*KEEP_STR*/", nvalign=").$out_llong(Layout.getNonVirtualAlignment().getQuantity());
  }
  OS.$out(/*KEEP_STR*/"]\n");
}

} // END OF class RecordLayoutBuilderStatics
