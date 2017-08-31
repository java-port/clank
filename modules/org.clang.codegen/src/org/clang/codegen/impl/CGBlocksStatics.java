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
package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.java.ClangCodeGenJavaDifferentiators.*;
import static org.clang.ast.CharUnitsGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGBlocksStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGBlocksStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=Tpl__ZL17buildByrefHelpersRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoEOT_;_ZL15BlockHeaderSize;_ZL15buildCopyHelperRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE;_ZL15enterBlockScopeRN5clang7CodeGen15CodeGenFunctionEPNS_9BlockDeclE;_ZL16buildGlobalBlockRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoEPN4llvm8ConstantE;_ZL16computeBlockInfoRN5clang7CodeGen13CodeGenModuleEPNS0_15CodeGenFunctionERNS0_11CGBlockInfoE;_ZL18buildDisposeHelperRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE;_ZL20buildBlockDescriptorRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE;_ZL20buildByrefCopyHelperRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE;_ZL20tryCaptureAsConstantRN5clang7CodeGen13CodeGenModuleEPNS0_15CodeGenFunctionEPKNS_7VarDeclE;_ZL22findAndRemoveBlockInfoPPN5clang7CodeGen11CGBlockInfoEPKNS_9BlockDeclE;_ZL23buildByrefDisposeHelperRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE;_ZL23generateByrefCopyHelperRN5clang7CodeGen15CodeGenFunctionERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE;_ZL24initializeForBlockHeaderRN5clang7CodeGen13CodeGenModuleERNS0_11CGBlockInfoERN4llvm15SmallVectorImplIPNS5_4TypeEEE;_ZL26generateByrefDisposeHelperRN5clang7CodeGen15CodeGenFunctionERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE;_ZL27isSafeForCXXConstantCaptureN5clang8QualTypeE;_ZL28configureBlocksRuntimeObjectRN5clang7CodeGen13CodeGenModuleEPN4llvm8ConstantE;_ZL9getLowBitN5clang9CharUnitsE;_ZN12_GLOBAL__N_116BlockLayoutChunkE;_ZN12_GLOBAL__N_1ltERKNS_16BlockLayoutChunkES2_; -static-type=CGBlocksStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGBlocksStatics {


/// Build the given block as a global block.
//<editor-fold defaultstate="collapsed" desc="buildGlobalBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1066,
 FQN="buildGlobalBlock", NM="_ZL16buildGlobalBlockRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoEPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL16buildGlobalBlockRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoEPN4llvm8ConstantE")
//</editor-fold>
public static Constant /*P*/ buildGlobalBlock(final CodeGenModule /*&*/ CGM, 
                final /*const*/ CGBlockInfo /*&*/ blockInfo, 
                Constant /*P*/ blockFn) {
  assert (blockInfo.CanBeGlobal);
  
  // Generate the constants for the block literal initializer.
  Constant /*P*/ fields[/*5*/] = new Constant /*P*/  [5];
  
  // isa
  fields[0] = CGM.getNSConcreteGlobalBlock();
  
  // __flags
  BlockFlags flags = CodeGenStatics.$bitor_BlockLiteralFlags(/*KEEP_ENUM*/BlockLiteralFlags.BLOCK_IS_GLOBAL, /*KEEP_ENUM*/BlockLiteralFlags.BLOCK_HAS_SIGNATURE);
  if (blockInfo.UsesStret) {
    BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockLiteralFlags.INSTANCE, BlockLiteralFlags.BLOCK_USE_STRET));
  }
  
  fields[1] = ConstantInt.get(CGM.IntTy, $uint2ulong(flags.getBitMask()));
  
  // Reserved
  fields[2] = Constant.getNullValue(CGM.IntTy);
  
  // Function
  fields[3] = blockFn;
  
  // Descriptor
  fields[4] = buildBlockDescriptor(CGM, blockInfo);
  
  Constant /*P*/ init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(fields, true));
  
  GlobalVariable /*P*/ literal = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable(CGM.getModule(), 
      init.getType(), 
      /*constant*/ true, 
      GlobalVariable.LinkageTypes.InternalLinkage, 
      init, 
      new Twine(/*KEEP_STR*/"__block_literal_global"));
   });
  literal.setAlignment($long2uint(blockInfo.BlockAlign.getQuantity()));
  
  // Return a constant of the appropriately-casted type.
  org.llvm.ir.Type /*P*/ requiredType = CGM.getTypes().ConvertType(blockInfo.getBlockExpr().getType());
  return ConstantExpr.getBitCast(literal, requiredType);
}


/// Build the helper function to copy a block.
//<editor-fold defaultstate="collapsed" desc="buildCopyHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 51,
 FQN="buildCopyHelper", NM="_ZL15buildCopyHelperRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL15buildCopyHelperRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE")
//</editor-fold>
public static Constant /*P*/ buildCopyHelper(final CodeGenModule /*&*/ CGM, 
               final /*const*/ CGBlockInfo /*&*/ blockInfo) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean($c$.track(new CodeGenFunction(CGM)).GenerateCopyHelperFunction(blockInfo));
  } finally {
    $c$.$destroy();
  }
}


/// Build the helper function to dispose of a block.
//<editor-fold defaultstate="collapsed" desc="buildDisposeHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 57,
 FQN="buildDisposeHelper", NM="_ZL18buildDisposeHelperRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL18buildDisposeHelperRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE")
//</editor-fold>
public static Constant /*P*/ buildDisposeHelper(final CodeGenModule /*&*/ CGM, 
                  final /*const*/ CGBlockInfo /*&*/ blockInfo) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean($c$.track(new CodeGenFunction(CGM)).GenerateDestroyHelperFunction(blockInfo));
  } finally {
    $c$.$destroy();
  }
}


/// buildBlockDescriptor - Build the block descriptor meta-data for a block.
/// buildBlockDescriptor is accessed from 5th field of the Block_literal
/// meta-data and contains stationary information about the block literal.
/// Its definition will have 4 (or optinally 6) words.
/// \code
/// struct Block_descriptor {
///   unsigned long reserved;
///   unsigned long size;  // size of Block_literal metadata in bytes.
///   void *copy_func_helper_decl;  // optional copy helper.
///   void *destroy_func_decl; // optioanl destructor helper.
///   void *block_method_encoding_address; // @encode for block literal signature.
///   void *block_layout_info; // encoding of captured block variables.
/// };
/// \endcode
//<editor-fold defaultstate="collapsed" desc="buildBlockDescriptor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 76,
 FQN="buildBlockDescriptor", NM="_ZL20buildBlockDescriptorRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL20buildBlockDescriptorRN5clang7CodeGen13CodeGenModuleERKNS0_11CGBlockInfoE")
//</editor-fold>
public static Constant /*P*/ buildBlockDescriptor(final CodeGenModule /*&*/ CGM, 
                    final /*const*/ CGBlockInfo /*&*/ blockInfo) {
  final ASTContext /*&*/ C = CGM.getContext();
  
  org.llvm.ir.Type /*P*/ ulong = CGM.getTypes().ConvertType(C.UnsignedLongTy.$QualType());
  org.llvm.ir.Type /*P*/ i8p = null;
  if (CGM.getLangOpts().OpenCL) {
    i8p
       = org.llvm.ir.Type.getInt8PtrTy(CGM.getLLVMContext(), C.getTargetAddressSpace(LangAS.ID.opencl_constant));
  } else {
    i8p = CGM.getTypes().ConvertType(C.VoidPtrTy.$QualType());
  }
  
  SmallVector<Constant /*P*/ > elements/*J*/= new SmallVector<Constant /*P*/ >(6, (Constant /*P*/ )null);
  
  // reserved
  elements.push_back(ConstantInt.get(ulong, $int2ulong(0)));
  
  // Size
  // FIXME: What is the right way to say this doesn't fit?  We should give
  // a user diagnostic in that case.  Better fix would be to change the
  // API to size_t.
  elements.push_back(ConstantInt.get(ulong, 
          blockInfo.BlockSize.getQuantity()));
  
  // Optional copy/dispose helpers.
  if (blockInfo.NeedsCopyDispose) {
    // copy_func_helper_decl
    elements.push_back(buildCopyHelper(CGM, blockInfo));
    
    // destroy_func_decl
    elements.push_back(buildDisposeHelper(CGM, blockInfo));
  }
  
  // Signature.  Mandatory ObjC-style method descriptor @encode sequence.
  std.string typeAtEncoding = CGM.getContext().getObjCEncodingForBlock(blockInfo.getBlockExpr());
  elements.push_back(ConstantExpr.getBitCast(CGM.GetAddrOfConstantCString(typeAtEncoding).getPointer(), i8p));
  
  // GC layout.
  if (C.getLangOpts().ObjC1) {
    if (CGM.getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
      elements.push_back(CGM.getObjCRuntime().BuildGCBlockLayout(CGM, blockInfo));
    } else {
      elements.push_back(CGM.getObjCRuntime().BuildRCBlockLayout(CGM, blockInfo));
    }
  } else {
    elements.push_back(Constant.getNullValue(i8p));
  }
  
  Constant /*P*/ init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(elements, true));
  
  /*uint*/int AddrSpace = 0;
  if (C.getLangOpts().OpenCL) {
    AddrSpace = C.getTargetAddressSpace(LangAS.ID.opencl_constant);
  }
  /*uint*/int AddrSpace_final = AddrSpace;
  GlobalVariable /*P*/ global = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable(CGM.getModule(), init.getType(), true, 
      GlobalValue.LinkageTypes.InternalLinkage, 
      init, new Twine(/*KEEP_STR*/"__block_descriptor_tmp"), (GlobalVariable /*P*/ )null, 
      GlobalValue.ThreadLocalMode.NotThreadLocal, 
      AddrSpace_final);
   });
  
  return ConstantExpr.getBitCast(global, CGM.getBlockDescriptorType());
}


/*
Purely notional variadic template describing the layout of a block.

template <class _ResultType, class... _ParamTypes, class... _CaptureTypes>
struct Block_literal {
/// Initialized to one of:
///   extern void *_NSConcreteStackBlock[];
///   extern void *_NSConcreteGlobalBlock[];
///
/// In theory, we could start one off malloc'ed by setting
/// BLOCK_NEEDS_FREE, giving it a refcount of 1, and using
/// this isa:
///   extern void *_NSConcreteMallocBlock[];
struct objc_class *isa;

/// These are the flags (with corresponding bit number) that the
/// compiler is actually supposed to know about.
///  25. BLOCK_HAS_COPY_DISPOSE - indicates that the block
///   descriptor provides copy and dispose helper functions
///  26. BLOCK_HAS_CXX_OBJ - indicates that there's a captured
///   object with a nontrivial destructor or copy constructor
///  28. BLOCK_IS_GLOBAL - indicates that the block is allocated
///   as global memory
///  29. BLOCK_USE_STRET - indicates that the block function
///   uses stret, which objc_msgSend needs to know about
///  30. BLOCK_HAS_SIGNATURE - indicates that the block has an
///   @encoded signature string
/// And we're not supposed to manipulate these:
///  24. BLOCK_NEEDS_FREE - indicates that the block has been moved
///   to malloc'ed memory
///  27. BLOCK_IS_GC - indicates that the block has been moved to
///   to GC-allocated memory
/// Additionally, the bottom 16 bits are a reference count which
/// should be zero on the stack.
int flags;

/// Reserved;  should be zero-initialized.
int reserved;

/// Function pointer generated from block literal.
_ResultType (*invoke)(Block_literal *, _ParamTypes...);

/// Block description metadata generated from block literal.
struct Block_descriptor *block_descriptor;

/// Captured values follow.
_CapturesTypes captures...;
};
*/

/// The number of fields in a block header.
//<editor-fold defaultstate="collapsed" desc="BlockHeaderSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 192,
 FQN="BlockHeaderSize", NM="_ZL15BlockHeaderSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL15BlockHeaderSize")
//</editor-fold>
public static /*const*//*uint*/int BlockHeaderSize = 5;
/// A chunk of data that we actually have to capture in the block.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockLayoutChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 196,
 FQN="(anonymous namespace)::BlockLayoutChunk", NM="_ZN12_GLOBAL__N_116BlockLayoutChunkE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_116BlockLayoutChunkE")
//</editor-fold>
public static class/*struct*/ BlockLayoutChunk implements NativeCloneable<BlockLayoutChunk> {
  public CharUnits Alignment;
  public CharUnits Size;
  public Qualifiers.ObjCLifetime Lifetime;
  public /*const*/ BlockDecl.Capture /*P*/ Capture; // null for 'this'
  public org.llvm.ir.Type /*P*/ Type;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockLayoutChunk::BlockLayoutChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 203,
   FQN="(anonymous namespace)::BlockLayoutChunk::BlockLayoutChunk", NM="_ZN12_GLOBAL__N_116BlockLayoutChunkC1EN5clang9CharUnitsES2_NS1_10Qualifiers12ObjCLifetimeEPKNS1_9BlockDecl7CaptureEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_116BlockLayoutChunkC1EN5clang9CharUnitsES2_NS1_10Qualifiers12ObjCLifetimeEPKNS1_9BlockDecl7CaptureEPN4llvm4TypeE")
  //</editor-fold>
  public BlockLayoutChunk(CharUnits align, CharUnits size, 
      Qualifiers.ObjCLifetime lifetime, 
      /*const*/ BlockDecl.Capture /*P*/ capture, 
      org.llvm.ir.Type /*P*/ type) {
    // : Alignment(align), Size(size), Lifetime(lifetime), Capture(capture), Type(type) 
    //START JInit
    this.Alignment = new CharUnits(align);
    this.Size = new CharUnits(size);
    this.Lifetime = lifetime;
    this.Capture = capture;
    this.Type = type;
    //END JInit
  }
  
  
  /// Tell the block info that this chunk has the given field index.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockLayoutChunk::setIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 211,
   FQN="(anonymous namespace)::BlockLayoutChunk::setIndex", NM="_ZN12_GLOBAL__N_116BlockLayoutChunk8setIndexERN5clang7CodeGen11CGBlockInfoEjNS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_116BlockLayoutChunk8setIndexERN5clang7CodeGen11CGBlockInfoEjNS1_9CharUnitsE")
  //</editor-fold>
  public void setIndex(final CGBlockInfo /*&*/ info, /*uint*/int index, CharUnits offset) {
    if (!(Capture != null)) {
      info.CXXThisIndex = index;
      info.CXXThisOffset.$assign(offset);
    } else {
      info.Captures.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ VarDecl /*P*/ , CGBlockInfo.Capture>(JD$T$RR_T1$RR.INSTANCE, Capture.getVariable(), new CGBlockInfo.Capture(JD$Move.INSTANCE, /*Fwd*/CGBlockInfo.Capture.makeIndex(index, new CharUnits(offset)))
              )/* }*/);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockLayoutChunk::BlockLayoutChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 196,
   FQN="(anonymous namespace)::BlockLayoutChunk::BlockLayoutChunk", NM="_ZN12_GLOBAL__N_116BlockLayoutChunkC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_116BlockLayoutChunkC1EOS0_")
  //</editor-fold>
  public /*inline*/ BlockLayoutChunk(JD$Move _dparam, final BlockLayoutChunk /*&&*/$Prm0) {
    // : Alignment(static_cast<BlockLayoutChunk &&>().Alignment), Size(static_cast<BlockLayoutChunk &&>().Size), Lifetime(static_cast<BlockLayoutChunk &&>().Lifetime), Capture(static_cast<BlockLayoutChunk &&>().Capture), Type(static_cast<BlockLayoutChunk &&>().Type) 
    //START JInit
    this.Alignment = new CharUnits(JD$Move.INSTANCE, $Prm0.Alignment);
    this.Size = new CharUnits(JD$Move.INSTANCE, $Prm0.Size);
    this.Lifetime = $Prm0.Lifetime;
    this.Capture = $Prm0.Capture;
    this.Type = $Prm0.Type;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockLayoutChunk::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 196,
   FQN="(anonymous namespace)::BlockLayoutChunk::operator=", NM="_ZN12_GLOBAL__N_116BlockLayoutChunkaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_116BlockLayoutChunkaSEOS0_")
  //</editor-fold>
  public /*inline*/ BlockLayoutChunk /*&*/ $assignMove(final BlockLayoutChunk /*&&*/$Prm0) {
    this.Alignment.$assignMove($Prm0.Alignment);
    this.Size.$assignMove($Prm0.Size);
    this.Lifetime = $Prm0.Lifetime;
    this.Capture = $Prm0.Capture;
    this.Type = $Prm0.Type;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public BlockLayoutChunk() { this.Alignment = new CharUnits(); this.Size = new CharUnits(); this.Lifetime = Qualifiers.ObjCLifetime.OCL_None; this.Capture = null; this.Type = null; }

  public BlockLayoutChunk clone() { return new BlockLayoutChunk(this.Alignment, this.Size, this.Lifetime, this.Capture, this.Type); }  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Alignment=" + Alignment // NOI18N
              + ", Size=" + Size // NOI18N
              + ", Lifetime=" + Lifetime // NOI18N
              + ", Capture=" + Capture // NOI18N
              + ", Type=" + Type; // NOI18N
  }    
  }

/// Order by 1) all __strong together 2) next, all byfref together 3) next,
/// all __weak together. Preserve descending alignment in all situations.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 224,
 FQN="(anonymous namespace)::operator<", NM="_ZN12_GLOBAL__N_1ltERKNS_16BlockLayoutChunkES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_1ltERKNS_16BlockLayoutChunkES2_")
//</editor-fold>
public static boolean $less_BlockLayoutChunk$C(final /*const*/ BlockLayoutChunk /*&*/ left, final /*const*/ BlockLayoutChunk /*&*/ right) {
  if (left.Alignment.$noteq(right.Alignment)) {
    return left.Alignment.$greater(right.Alignment);
  }
  
  Type2Int<BlockLayoutChunk> getPrefOrder = /*[]*/ (final /*const*/ BlockLayoutChunk /*&*/ chunk) -> {
        if ((chunk.Capture != null) && chunk.Capture.isByRef()) {
          return 1;
        }
        if (chunk.Lifetime == Qualifiers.ObjCLifetime.OCL_Strong) {
          return 0;
        }
        if (chunk.Lifetime == Qualifiers.ObjCLifetime.OCL_Weak) {
          return 2;
        }
        return 3;
      };
  
  return getPrefOrder.$call(left) < getPrefOrder.$call(right);
}

// end anonymous namespace

/// Determines if the given type is safe for constant capture in C++.
//<editor-fold defaultstate="collapsed" desc="isSafeForCXXConstantCapture">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 243,
 FQN="isSafeForCXXConstantCapture", NM="_ZL27isSafeForCXXConstantCaptureN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL27isSafeForCXXConstantCaptureN5clang8QualTypeE")
//</editor-fold>
public static boolean isSafeForCXXConstantCapture(QualType type) {
  /*const*/ RecordType /*P*/ recordType = type.$arrow().getBaseElementTypeUnsafe().getAs$RecordType();
  
  // Only records can be unsafe.
  if (!(recordType != null)) {
    return true;
  }
  
  /*const*/ CXXRecordDecl /*P*/ record = cast_CXXRecordDecl(recordType.getDecl());
  
  // Maintain semantics for classes with non-trivial dtors or copy ctors.
  if (!record.hasTrivialDestructor()) {
    return false;
  }
  if (record.hasNonTrivialCopyConstructor()) {
    return false;
  }
  
  // Otherwise, we just have to make sure there aren't any mutable
  // fields that might have changed since initialization.
  return !record.hasMutableFields();
}


/// It is illegal to modify a const object after initialization.
/// Therefore, if a const object has a constant initializer, we don't
/// actually need to keep storage for it in the block; we'll just
/// rematerialize it at the start of the block function.  This is
/// acceptable because we make no promises about address stability of
/// captured variables.
//<editor-fold defaultstate="collapsed" desc="tryCaptureAsConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 267,
 FQN="tryCaptureAsConstant", NM="_ZL20tryCaptureAsConstantRN5clang7CodeGen13CodeGenModuleEPNS0_15CodeGenFunctionEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL20tryCaptureAsConstantRN5clang7CodeGen13CodeGenModuleEPNS0_15CodeGenFunctionEPKNS_7VarDeclE")
//</editor-fold>
public static Constant /*P*/ tryCaptureAsConstant(final CodeGenModule /*&*/ CGM, 
                    CodeGenFunction /*P*/ CGF, 
                    /*const*/ VarDecl /*P*/ var) {
  // Return if this is a function paramter. We shouldn't try to
  // rematerialize default arguments of function parameters.
  if (isa_ParmVarDecl(var)) {
    return null;
  }
  
  QualType type = var.getType();
  
  // We can only do this if the variable is const.
  if (!type.isConstQualified()) {
    return null;
  }
  
  // Furthermore, in C++ we have to worry about mutable fields:
  // C++ [dcl.type.cv]p4:
  //   Except that any class member declared mutable can be
  //   modified, any attempt to modify a const object during its
  //   lifetime results in undefined behavior.
  if (CGM.getLangOpts().CPlusPlus && !isSafeForCXXConstantCapture(new QualType(type))) {
    return null;
  }
  
  // If the variable doesn't have any initializer (shouldn't this be
  // invalid?), it's not clear what we should do.  Maybe capture as
  // zero?
  /*const*/ Expr /*P*/ init = var.getInit$Const();
  if (!(init != null)) {
    return null;
  }
  
  return CGM.EmitConstantInit($Deref(var), CGF);
}


/// Get the low bit of a nonzero character count.  This is the
/// alignment of the nth byte if the 0th byte is universally aligned.
//<editor-fold defaultstate="collapsed" desc="getLowBit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 299,
 FQN="getLowBit", NM="_ZL9getLowBitN5clang9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL9getLowBitN5clang9CharUnitsE")
//</editor-fold>
public static CharUnits getLowBit(CharUnits v) {
  return CharUnits.fromQuantity(v.getQuantity() & (~v.getQuantity() + 1));
}

//<editor-fold defaultstate="collapsed" desc="initializeForBlockHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 303,
 FQN="initializeForBlockHeader", NM="_ZL24initializeForBlockHeaderRN5clang7CodeGen13CodeGenModuleERNS0_11CGBlockInfoERN4llvm15SmallVectorImplIPNS5_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL24initializeForBlockHeaderRN5clang7CodeGen13CodeGenModuleERNS0_11CGBlockInfoERN4llvm15SmallVectorImplIPNS5_4TypeEEE")
//</editor-fold>
public static void initializeForBlockHeader(final CodeGenModule /*&*/ CGM, final CGBlockInfo /*&*/ info, 
                        final SmallVectorImpl<org.llvm.ir.Type /*P*/ > /*&*/ elementTypes) {
  // The header is basically 'struct { void *; int; int; void *; void *; }'.
  // Assert that that struct is packed.
  assert (CGM.getIntSize().$lesseq(CGM.getPointerSize()));
  assert (CGM.getIntAlign().$lesseq(CGM.getPointerAlign()));
  assert (($star_long_CharUnits$C(2, CGM.getIntSize())).isMultipleOf(CGM.getPointerAlign()));
  
  info.BlockAlign.$assignMove(CGM.getPointerAlign());
  info.BlockSize.$assignMove($star_long_CharUnits$C(3, CGM.getPointerSize()).$add($star_long_CharUnits$C(2, CGM.getIntSize())));
  assert (elementTypes.empty());
  elementTypes.push_back(CGM.Unnamed_field9.VoidPtrTy);
  elementTypes.push_back(CGM.IntTy);
  elementTypes.push_back(CGM.IntTy);
  elementTypes.push_back(CGM.Unnamed_field9.VoidPtrTy);
  elementTypes.push_back(CGM.getBlockDescriptorType());
  assert (elementTypes.size() == BlockHeaderSize);
}


/// Compute the layout of the given block.  Attempts to lay the block
/// out with minimal space requirements.
//<editor-fold defaultstate="collapsed" desc="computeBlockInfo">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 326,
 FQN="computeBlockInfo", NM="_ZL16computeBlockInfoRN5clang7CodeGen13CodeGenModuleEPNS0_15CodeGenFunctionERNS0_11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL16computeBlockInfoRN5clang7CodeGen13CodeGenModuleEPNS0_15CodeGenFunctionERNS0_11CGBlockInfoE")
//</editor-fold>
public static void computeBlockInfo(final CodeGenModule /*&*/ CGM, CodeGenFunction /*P*/ CGF, 
                final CGBlockInfo /*&*/ info) {
  final ASTContext /*&*/ C = CGM.getContext();
  /*const*/ BlockDecl /*P*/ block = info.getBlockDecl();
  
  SmallVector<org.llvm.ir.Type /*P*/ > elementTypes/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(8, (org.llvm.ir.Type /*P*/ )null);
  initializeForBlockHeader(CGM, info, elementTypes);
  if (!block.hasCaptures()) {
    info.StructureType
       = StructType.get(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(elementTypes, true), true);
    info.CanBeGlobal = true;
    return;
  } else if (C.getLangOpts().ObjC1
     && CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
    info.HasCapturedVariableLayout = true;
  }
  
  // Collect the layout chunks.
  SmallVector<BlockLayoutChunk> layout/*J*/= new SmallVector<BlockLayoutChunk>(16, new BlockLayoutChunk());
  layout.reserve((block.capturesCXXThis() ? 1 : 0)
         + (block.capture_end().$sub(block.capture_begin())));
  
  CharUnits maxFieldAlign/*J*/= new CharUnits();
  
  // First, 'this'.
  if (block.capturesCXXThis()) {
    assert ((CGF != null) && (CGF.CurFuncDecl != null) && isa_CXXMethodDecl(CGF.CurFuncDecl)) : "Can't capture 'this' outside a method";
    QualType thisType = cast_CXXMethodDecl(CGF.CurFuncDecl).getThisType(C);
    
    // Theoretically, this could be in a different address space, so
    // don't assume standard pointer size/align.
    org.llvm.ir.Type /*P*/ llvmType = CGM.getTypes().ConvertType(new QualType(thisType));
    std.pairTypeType<CharUnits, CharUnits> tinfo = CGM.getContext().getTypeInfoInChars(new QualType(thisType));
    maxFieldAlign.$assign(std.max(maxFieldAlign, tinfo.second));
    
    layout.push_back(new BlockLayoutChunk(new CharUnits(tinfo.second), new CharUnits(tinfo.first), 
            Qualifiers.ObjCLifetime.OCL_None, 
            (/*const*/ BlockDecl.Capture /*P*/ )null, llvmType));
  }
  
  // Next, all the block captures.
  for (final /*const*/ BlockDecl.Capture /*&*/ CI : block.captures()) {
    /*const*/ VarDecl /*P*/ variable = CI.getVariable();
    if (CI.isByRef()) {
      // We have to copy/dispose of the __block reference.
      info.NeedsCopyDispose = true;
      
      // Just use void* instead of a pointer to the byref type.
      CharUnits align = CGM.getPointerAlign();
      maxFieldAlign.$assign(std.max(maxFieldAlign, align));
      
      layout.push_back(new BlockLayoutChunk(new CharUnits(align), CGM.getPointerSize(), 
              Qualifiers.ObjCLifetime.OCL_None, $AddrOf(CI), 
              CGM.Unnamed_field9.VoidPtrTy));
      continue;
    }
    {
      
      // Otherwise, build a layout chunk with the size and alignment of
      // the declaration.
      Constant /*P*/ constant = tryCaptureAsConstant(CGM, CGF, variable);
      if ((constant != null)) {
        info.Captures.$at_T1$C$R(variable).$assignMove(CGBlockInfo.Capture.makeConstant(constant));
        continue;
      }
    }
    
    // If we have a lifetime qualifier, honor it for capture purposes.
    // That includes *not* copying it if it's __unsafe_unretained.
    Qualifiers.ObjCLifetime lifetime = variable.getType().getObjCLifetime();
    if ((lifetime.getValue() != 0)) {
      switch (lifetime) {
       case OCL_None:
        throw new llvm_unreachable("impossible");
       case OCL_ExplicitNone:
       case OCL_Autoreleasing:
        break;
       case OCL_Strong:
       case OCL_Weak:
        info.NeedsCopyDispose = true;
      }
      // Block pointers require copy/dispose.  So do Objective-C pointers.
    } else if (variable.getType().$arrow().isObjCRetainableType()) {
      // But honor the inert __unsafe_unretained qualifier, which doesn't
      // actually make it into the type system.
      if (variable.getType().$arrow().isObjCInertUnsafeUnretainedType()) {
        lifetime = Qualifiers.ObjCLifetime.OCL_ExplicitNone;
      } else {
        info.NeedsCopyDispose = true;
        // used for mrr below.
        lifetime = Qualifiers.ObjCLifetime.OCL_Strong;
      }
      // So do types that require non-trivial copy construction.
    } else if (CI.hasCopyExpr()) {
      info.NeedsCopyDispose = true;
      info.HasCXXObject = true;
      // And so do types with destructors.
    } else if (CGM.getLangOpts().CPlusPlus) {
      {
        /*const*/ CXXRecordDecl /*P*/ record = variable.getType().$arrow().getAsCXXRecordDecl();
        if ((record != null)) {
          if (!record.hasTrivialDestructor()) {
            info.HasCXXObject = true;
            info.NeedsCopyDispose = true;
          }
        }
      }
    }
    
    QualType VT = variable.getType();
    CharUnits size = C.getTypeSizeInChars(/*NO_COPY*/VT);
    CharUnits align = C.getDeclAlign(variable);
    
    maxFieldAlign.$assign(std.max(maxFieldAlign, align));
    
    org.llvm.ir.Type /*P*/ llvmType = CGM.getTypes().ConvertTypeForMem(new QualType(VT));
    
    layout.push_back(new BlockLayoutChunk(new CharUnits(align), new CharUnits(size), lifetime, $AddrOf(CI), llvmType));
  }
  
  // If that was everything, we're done here.
  if (layout.empty()) {
    info.StructureType
       = StructType.get(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(elementTypes, true), true);
    info.CanBeGlobal = true;
    return;
  }
  
  // Sort the layout by alignment.  We have to use a stable sort here
  // to get reproducible results.  There should probably be an
  // llvm::array_pod_stable_sort.
  std.stable_sort(layout.begin(), layout.end(), new Compare<BlockLayoutChunk>() {
    @Override
    public boolean compare(BlockLayoutChunk a, BlockLayoutChunk b) {
      return a.Alignment.$less(b.Alignment);
    }
  });
  
  // Needed for blocks layout info.
  info.BlockHeaderForcedGapOffset.$assign(info.BlockSize);
  info.BlockHeaderForcedGapSize.$assignMove(CharUnits.Zero());
  
  final CharUnits /*&*/ blockSize = info.BlockSize;
  info.BlockAlign.$assign(std.max(maxFieldAlign, info.BlockAlign));
  
  // Assuming that the first byte in the header is maximally aligned,
  // get the alignment of the first byte following the header.
  CharUnits endAlign = getLowBit(new CharUnits(blockSize));
  
  // If the end of the header isn't satisfactorily aligned for the
  // maximum thing, look for things that are okay with the header-end
  // alignment, and keep appending them until we get something that's
  // aligned right.  This algorithm is only guaranteed optimal if
  // that condition is satisfied at some point; otherwise we can get
  // things like:
  //   header                 // next byte has alignment 4
  //   something_with_size_5; // next byte has alignment 1
  //   something_with_alignment_8;
  // which has 7 bytes of padding, as opposed to the naive solution
  // which might have less (?).
  if (endAlign.$less(maxFieldAlign)) {
    type$ptr<BlockLayoutChunk> li = $tryClone(layout.begin().$add(1));
    type$ptr<BlockLayoutChunk> le = $tryClone(layout.end());
    
    // Look for something that the header end is already
    // satisfactorily aligned for.
    for (; $noteq_ptr(li, le) && endAlign.$less(li./*->*/$star().Alignment); li.$preInc())  {
      ;
    }
    
    // If we found something that's naturally aligned for the end of
    // the header, keep adding things...
    if ($noteq_ptr(li, le)) {
      type$ptr<BlockLayoutChunk> first = $tryClone(li);
      for (; $noteq_ptr(li, le); li.$preInc()) {
        assert (endAlign.$greatereq(li./*->*/$star().Alignment));
        
        li./*->*/$star().setIndex(info, elementTypes.size(), new CharUnits(blockSize));
        elementTypes.push_back(li./*->*/$star().Type);
        blockSize.$addassign(li./*->*/$star().Size);
        endAlign.$assignMove(getLowBit(new CharUnits(blockSize)));
        
        // ...until we get to the alignment of the maximum field.
        if (endAlign.$greatereq(maxFieldAlign)) {
          break;
        }
      }
      // Don't re-append everything we just appended.
      layout.erase(first, li);
    }
  }
  assert (endAlign.$eq(getLowBit(new CharUnits(blockSize))));
  
  // At this point, we just have to add padding if the end align still
  // isn't aligned right.
  if (endAlign.$less(maxFieldAlign)) {
    CharUnits newBlockSize = blockSize.alignTo(maxFieldAlign);
    CharUnits padding = newBlockSize.$sub(blockSize);
    
    // If we haven't yet added any fields, remember that there was an
    // initial gap; this need to go into the block layout bit map.
    if (blockSize.$eq(info.BlockHeaderForcedGapOffset)) {
      info.BlockHeaderForcedGapSize.$assign(padding);
    }
    
    elementTypes.push_back(org.llvm.ir.ArrayType.get(CGM.Int8Ty, 
            padding.getQuantity()));
    blockSize.$assign(newBlockSize);
    endAlign.$assignMove(getLowBit(new CharUnits(blockSize))); // might be > maxFieldAlign
  }
  assert (endAlign.$greatereq(maxFieldAlign));
  assert (endAlign.$eq(getLowBit(new CharUnits(blockSize))));
  // Slam everything else on now.  This works because they have
  // strictly decreasing alignment and we expect that size is always a
  // multiple of alignment.
  for (type$ptr<BlockLayoutChunk> li = $tryClone(layout.begin()), /*P*/ le = $tryClone(layout.end()); $noteq_ptr(li, le); li.$preInc()) {
    if (endAlign.$less(li./*->*/$star().Alignment)) {
      // size may not be multiple of alignment. This can only happen with
      // an over-aligned variable. We will be adding a padding field to
      // make the size be multiple of alignment.
      CharUnits padding = li./*->*/$star().Alignment.$sub(endAlign);
      elementTypes.push_back(org.llvm.ir.ArrayType.get(CGM.Int8Ty, 
              padding.getQuantity()));
      blockSize.$addassign(padding);
      endAlign.$assignMove(getLowBit(new CharUnits(blockSize)));
    }
    assert (endAlign.$greatereq(li./*->*/$star().Alignment));
    li./*->*/$star().setIndex(info, elementTypes.size(), new CharUnits(blockSize));
    elementTypes.push_back(li./*->*/$star().Type);
    blockSize.$addassign(li./*->*/$star().Size);
    endAlign.$assignMove(getLowBit(new CharUnits(blockSize)));
  }
  
  info.StructureType
     = StructType.get(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(elementTypes, true), true);
}


/// Enter the scope of a block.  This should be run at the entrance to
/// a full-expression so that the block's cleanups are pushed at the
/// right place in the stack.
//<editor-fold defaultstate="collapsed" desc="enterBlockScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 567,
 FQN="enterBlockScope", NM="_ZL15enterBlockScopeRN5clang7CodeGen15CodeGenFunctionEPNS_9BlockDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL15enterBlockScopeRN5clang7CodeGen15CodeGenFunctionEPNS_9BlockDeclE")
//</editor-fold>
public static void enterBlockScope(final CodeGenFunction /*&*/ CGF, BlockDecl /*P*/ block) {
  assert (CGF.HaveInsertPoint());
  
  // Allocate the block info and place it at the head of the list.
  final CGBlockInfo /*&*/ blockInfo = $Deref(new CGBlockInfo(block, CGF.CurFn.getName()));
  blockInfo.NextBlockInfo = CGF.FirstBlockInfo;
  CGF.FirstBlockInfo = $AddrOf(blockInfo);
  
  // Compute information about the layout, etc., of this block,
  // pushing cleanups as necessary.
  computeBlockInfo(CGF.CGM, $AddrOf(CGF), blockInfo);
  
  // Nothing else to do if it can be global.
  if (blockInfo.CanBeGlobal) {
    return;
  }
  
  // Make the allocation for the block.
  blockInfo.LocalAddress.$assignMove(CGF.CreateTempAlloca(blockInfo.StructureType, 
          new CharUnits(blockInfo.BlockAlign), new Twine(/*KEEP_STR*/"block")));
  
  // If there are cleanups to emit, enter them (but inactive).
  if (!blockInfo.NeedsCopyDispose) {
    return;
  }
  
  // Walk through the captures (in order) and find the ones not
  // captured by constant.
  for (final /*const*/ BlockDecl.Capture /*&*/ CI : block.captures()) {
    // Ignore __block captures; there's nothing special in the
    // on-stack block that we need to do for them.
    if (CI.isByRef()) {
      continue;
    }
    
    // Ignore variables that are constant-captured.
    /*const*/ VarDecl /*P*/ variable = CI.getVariable();
    final CGBlockInfo.Capture /*&*/ capture = blockInfo.getCapture(variable);
    if (capture.isConstant()) {
      continue;
    }
    
    // Ignore objects that aren't destructed.
    QualType.DestructionKind dtorKind = variable.getType().isDestructedType();
    if (dtorKind == QualType.DestructionKind.DK_none) {
      continue;
    }
    
    CodeGenFunction.AddressQualType2Void destroyer;
    
    // Block captures count as local values and have imprecise semantics.
    // They also can't be arrays, so need to worry about that.
    if (dtorKind == QualType.DestructionKind.DK_objc_strong_lifetime) {
      destroyer = /*FuncRef*/CodeGenFunction::destroyARCStrongImprecise;
    } else {
      destroyer = $tryClone(CGF.getDestroyer(dtorKind));
    }
    
    // GEP down to the address.
    Address addr = CGF.Builder.CreateStructGEP(new Address(blockInfo.LocalAddress), 
        capture.getIndex(), 
        capture.getOffset());
    
    // We can use that GEP as the dominating IP.
    if (!(blockInfo.DominatingIP != null)) {
      blockInfo.DominatingIP = cast_Instruction(addr.getPointer());
    }
    
    /*CleanupKind*//*uint*/int cleanupKind = CleanupKind.InactiveNormalCleanup;
    boolean useArrayEHCleanup = CGF.needsEHCleanup(dtorKind);
    if (useArrayEHCleanup) {
      cleanupKind = CleanupKind.InactiveNormalAndEHCleanup;
    }
    
    CGF.pushDestroy(cleanupKind, new Address(addr), variable.getType(), 
        destroyer, useArrayEHCleanup);
    
    // Remember where that cleanup was.
    capture.setCleanup(CGF.EHStack.stable_begin());
  }
}


/// Find the layout for the given block in a linked list and remove it.
//<editor-fold defaultstate="collapsed" desc="findAndRemoveBlockInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 652,
 FQN="findAndRemoveBlockInfo", NM="_ZL22findAndRemoveBlockInfoPPN5clang7CodeGen11CGBlockInfoEPKNS_9BlockDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL22findAndRemoveBlockInfoPPN5clang7CodeGen11CGBlockInfoEPKNS_9BlockDeclE")
//</editor-fold>
public static CGBlockInfo /*P*/ findAndRemoveBlockInfo(type$ptr<CGBlockInfo /*P*/ /*P*/> head, 
                      /*const*/ BlockDecl /*P*/ block) {
  while (true) {
    assert ((head != null) && (head.$star() != null));
    CGBlockInfo /*P*/ cur = head.$star();
    
    // If this is the block we're looking for, splice it out of the list.
    if (cur.getBlockDecl() == block) {
      head.$set(cur.NextBlockInfo);
      return cur;
    }
    
    head = $tryClone($AddrOf(create_type$ptr2ConstT(cur.NextBlockInfo)));
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="generateByrefCopyHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1788,
 FQN="generateByrefCopyHelper", NM="_ZL23generateByrefCopyHelperRN5clang7CodeGen15CodeGenFunctionERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL23generateByrefCopyHelperRN5clang7CodeGen15CodeGenFunctionERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE")
//</editor-fold>
public static Constant /*P*/ generateByrefCopyHelper(final CodeGenFunction /*&*/ CGF, final /*const*/ BlockByrefInfo /*&*/ byrefInfo, 
                       final BlockByrefHelpers /*&*/ generator) {
  FunctionArgList args = null;
  ImplicitParamDecl dst = null;
  ImplicitParamDecl src = null;
  try {
    final ASTContext /*&*/ Context = CGF.getContext();
    
    QualType R = Context.VoidTy.$QualType();
    
    args/*J*/= new FunctionArgList();
    dst/*J*/= new ImplicitParamDecl(CGF.getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        Context.VoidPtrTy.$QualType());
    args.push_back($AddrOf(dst));
    
    src/*J*/= new ImplicitParamDecl(CGF.getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        Context.VoidPtrTy.$QualType());
    args.push_back($AddrOf(src));
    
    final /*const*/ CGFunctionInfo /*&*/ FI = CGF.CGM.getTypes().arrangeBuiltinFunctionDeclaration(new QualType(R), args);
    
    org.llvm.ir.FunctionType /*P*/ LTy = CGF.CGM.getTypes().GetFunctionType(FI);
    
    // FIXME: We'd like to put these into a mergable by content, with
    // internal linkage.
    Function /*P*/ Fn = Function.Create(LTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/"__Block_byref_object_copy_"), $AddrOf(CGF.CGM.getModule()));
    
    IdentifierInfo /*P*/ II = $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"__Block_byref_object_copy_")));
    
    FunctionDecl /*P*/ FD = FunctionDecl.Create(Context, 
        Context.getTranslationUnitDecl(), 
        new SourceLocation(), 
        new SourceLocation(), new DeclarationName(II), new QualType(R), (TypeSourceInfo /*P*/ )null, 
        StorageClass.SC_Static, 
        false, false);
    
    CGF.CGM.SetInternalFunctionAttributes((/*const*/ Decl /*P*/ )null, Fn, FI);
    
    CGF.StartFunction(new GlobalDecl(FD), new QualType(R), Fn, FI, args);
    if (generator.needsCopy()) {
      org.llvm.ir.Type /*P*/ byrefPtrType = byrefInfo.Type.getPointerTo(0);
      
      // dst->x
      Address destField = CGF.GetAddrOfLocalVar($AddrOf(dst));
      destField.$assignMove(new Address(CGF.Builder.CreateLoad(new Address(destField)), 
              new CharUnits(byrefInfo.ByrefAlignment)));
      destField.$assignMove(CGF.Builder.CreateBitCast(new Address(destField), byrefPtrType));
      destField.$assignMove(CGF.emitBlockByrefAddress(new Address(destField), byrefInfo, false, 
              new Twine(/*KEEP_STR*/"dest-object")));
      
      // src->x
      Address srcField = CGF.GetAddrOfLocalVar($AddrOf(src));
      srcField.$assignMove(new Address(CGF.Builder.CreateLoad(new Address(srcField)), 
              new CharUnits(byrefInfo.ByrefAlignment)));
      srcField.$assignMove(CGF.Builder.CreateBitCast(new Address(srcField), byrefPtrType));
      srcField.$assignMove(CGF.emitBlockByrefAddress(new Address(srcField), byrefInfo, false, 
              new Twine(/*KEEP_STR*/"src-object")));
      
      generator.emitCopy(CGF, new Address(destField), new Address(srcField));
    }
    
    CGF.FinishFunction();
    
    return ConstantExpr.getBitCast(Fn, CGF.Unnamed_field9.Int8PtrTy);
  } finally {
    if (src != null) { src.$destroy(); }
    if (dst != null) { dst.$destroy(); }
    if (args != null) { args.$destroy(); }
  }
}


/// Build the copy helper for a __block variable.
//<editor-fold defaultstate="collapsed" desc="buildByrefCopyHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1857,
 FQN="buildByrefCopyHelper", NM="_ZL20buildByrefCopyHelperRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL20buildByrefCopyHelperRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE")
//</editor-fold>
public static Constant /*P*/ buildByrefCopyHelper(final CodeGenModule /*&*/ CGM, 
                    final /*const*/ BlockByrefInfo /*&*/ byrefInfo, 
                    final BlockByrefHelpers /*&*/ generator) {
  CodeGenFunction CGF = null;
  try {
    CGF/*J*/= new CodeGenFunction(CGM);
    return generateByrefCopyHelper(CGF, byrefInfo, generator);
  } finally {
    if (CGF != null) { CGF.$destroy(); }
  }
}


/// Generate code for a __block variable's dispose helper.
//<editor-fold defaultstate="collapsed" desc="generateByrefDisposeHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1865,
 FQN="generateByrefDisposeHelper", NM="_ZL26generateByrefDisposeHelperRN5clang7CodeGen15CodeGenFunctionERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL26generateByrefDisposeHelperRN5clang7CodeGen15CodeGenFunctionERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE")
//</editor-fold>
public static Constant /*P*/ generateByrefDisposeHelper(final CodeGenFunction /*&*/ CGF, 
                          final /*const*/ BlockByrefInfo /*&*/ byrefInfo, 
                          final BlockByrefHelpers /*&*/ generator) {
  FunctionArgList args = null;
  ImplicitParamDecl src = null;
  try {
    final ASTContext /*&*/ Context = CGF.getContext();
    QualType R = Context.VoidTy.$QualType();
    
    args/*J*/= new FunctionArgList();
    src/*J*/= new ImplicitParamDecl(CGF.getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        Context.VoidPtrTy.$QualType());
    args.push_back($AddrOf(src));
    
    final /*const*/ CGFunctionInfo /*&*/ FI = CGF.CGM.getTypes().arrangeBuiltinFunctionDeclaration(new QualType(R), args);
    
    org.llvm.ir.FunctionType /*P*/ LTy = CGF.CGM.getTypes().GetFunctionType(FI);
    
    // FIXME: We'd like to put these into a mergable by content, with
    // internal linkage.
    Function /*P*/ Fn = Function.Create(LTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/"__Block_byref_object_dispose_"), 
        $AddrOf(CGF.CGM.getModule()));
    
    IdentifierInfo /*P*/ II = $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"__Block_byref_object_dispose_")));
    
    FunctionDecl /*P*/ FD = FunctionDecl.Create(Context, 
        Context.getTranslationUnitDecl(), 
        new SourceLocation(), 
        new SourceLocation(), new DeclarationName(II), new QualType(R), (TypeSourceInfo /*P*/ )null, 
        StorageClass.SC_Static, 
        false, false);
    
    CGF.CGM.SetInternalFunctionAttributes((/*const*/ Decl /*P*/ )null, Fn, FI);
    
    CGF.StartFunction(new GlobalDecl(FD), new QualType(R), Fn, FI, args);
    if (generator.needsDispose()) {
      Address addr = CGF.GetAddrOfLocalVar($AddrOf(src));
      addr.$assignMove(new Address(CGF.Builder.CreateLoad(new Address(addr)), new CharUnits(byrefInfo.ByrefAlignment)));
      org.llvm.ir.PointerType /*P*/ byrefPtrType = byrefInfo.Type.getPointerTo(0);
      addr.$assignMove(CGF.Builder.CreateBitCast(new Address(addr), byrefPtrType));
      addr.$assignMove(CGF.emitBlockByrefAddress(new Address(addr), byrefInfo, false, new Twine(/*KEEP_STR*/"object")));
      
      generator.emitDispose(CGF, new Address(addr));
    }
    
    CGF.FinishFunction();
    
    return ConstantExpr.getBitCast(Fn, CGF.Unnamed_field9.Int8PtrTy);
  } finally {
    if (src != null) { src.$destroy(); }
    if (args != null) { args.$destroy(); }
  }
}


/// Build the dispose helper for a __block variable.
//<editor-fold defaultstate="collapsed" desc="buildByrefDisposeHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1919,
 FQN="buildByrefDisposeHelper", NM="_ZL23buildByrefDisposeHelperRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL23buildByrefDisposeHelperRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoERNS0_17BlockByrefHelpersE")
//</editor-fold>
public static Constant /*P*/ buildByrefDisposeHelper(final CodeGenModule /*&*/ CGM, 
                       final /*const*/ BlockByrefInfo /*&*/ byrefInfo, 
                       final BlockByrefHelpers /*&*/ generator) {
  CodeGenFunction CGF = null;
  try {
    CGF/*J*/= new CodeGenFunction(CGM);
    return generateByrefDisposeHelper(CGF, byrefInfo, generator);
  } finally {
    if (CGF != null) { CGF.$destroy(); }
  }
}


/// Lazily build the copy and dispose helpers for a __block variable
/// with the given information.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="buildByrefHelpers">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1929,
 FQN="buildByrefHelpers", NM="Tpl__ZL17buildByrefHelpersRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoEOT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=Tpl__ZL17buildByrefHelpersRN5clang7CodeGen13CodeGenModuleERKNS0_14BlockByrefInfoEOT_")
//</editor-fold>
public static </*class*/ T extends BlockByrefHelpers> T /*P*/ buildByrefHelpers$T(final CodeGenModule /*&*/ CGM, final /*const*/ BlockByrefInfo /*&*/ byrefInfo, 
                   final T /*&&*/generator, final Type2Type<T> $generatorFactory) {
  // JAVA: $TFactory is used instead of new T(...)
  FoldingSetNodeID id/*J*/= new FoldingSetNodeID();
  generator.Profile(id);
  
  final type$ref<type$ptr<BlockByrefHelpers /*P*/>/*void P*/ > insertPos = create_type$ref();
  BlockByrefHelpers /*P*/ node = CGM.ByrefHelpersCache.FindNodeOrInsertPos(id, insertPos);
  if ((node != null)) {
    return ((/*static_cast*/T /*P*/ )(node));
  }
  
  generator.CopyHelper = buildByrefCopyHelper(CGM, byrefInfo, generator);
  generator.DisposeHelper = buildByrefDisposeHelper(CGM, byrefInfo, generator);
  
  //T /*P*/ copy = ((/*JCast*/T /*P*/ )(/*FIXME: NEW_EXPR [NoNewFun]*/CGM.getContext() = /*new (CGM.getContext())*/ new T(( std.move(generator) ))));  
  T copy = $new_uint_voidPtr(CGM.getContext().Allocate$JavaRef(), (type$ptr<?> New$Mem)->{
    return $generatorFactory.$call(std.move(generator));
  });
  
  CGM.ByrefHelpersCache.InsertNode(copy, insertPos.$deref());
  return copy;
}


/// Adjust the declaration of something from the blocks API.
//<editor-fold defaultstate="collapsed" desc="configureBlocksRuntimeObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2296,
 FQN="configureBlocksRuntimeObject", NM="_ZL28configureBlocksRuntimeObjectRN5clang7CodeGen13CodeGenModuleEPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZL28configureBlocksRuntimeObjectRN5clang7CodeGen13CodeGenModuleEPN4llvm8ConstantE")
//</editor-fold>
public static void configureBlocksRuntimeObject(final CodeGenModule /*&*/ CGM, 
                            Constant /*P*/ C) {
  GlobalValue /*P*/ GV = cast_GlobalValue(C.stripPointerCasts());
  if (CGM.getTarget().getTriple().isOSBinFormatCOFF()) {
    final IdentifierInfo /*&*/ II = CGM.getContext().Idents.get(C.getName());
    TranslationUnitDecl /*P*/ TUDecl = CGM.getContext().getTranslationUnitDecl();
    DeclContext /*P*/ DC = TranslationUnitDecl.castToDeclContext(TUDecl);
    assert ((isa_Function(C.stripPointerCasts()) || isa_GlobalVariable(C.stripPointerCasts()))) : "expected Function or GlobalVariable";
    
    /*const*/ NamedDecl /*P*/ ND = null;
    for (final NamedDecl /*P*/ /*const*/ /*&*/ Result : DC.lookup(new DeclarationName($AddrOf(II))))  {
      if (((ND = dyn_cast_FunctionDecl(Result)) != null)
         || ((ND = dyn_cast_VarDecl(Result)) != null)) {
        break;
      }
    }
    
    // TODO: support static blocks runtime
    if (GV.isDeclaration() && (!(ND != null) || !ND.hasAttr(DLLExportAttr.class))) {
      GV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
      GV.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
    } else {
      GV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
      GV.setLinkage(GlobalValue.LinkageTypes.ExternalLinkage);
    }
  }
  if (!CGM.getLangOpts().BlocksRuntimeOptional) {
    return;
  }
  if (GV.isDeclaration() && GV.hasExternalLinkage()) {
    GV.setLinkage(GlobalValue.LinkageTypes.ExternalWeakLinkage);
  }
}

} // END OF class CGBlocksStatics
