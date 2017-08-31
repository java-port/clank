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
package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.clang.codegen.impl.CGBlocksStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGBlocks">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGBlocks",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_NotDefined ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20GetAddrOfGlobalBlockEPKNS_9BlockExprEPKc;_ZN5clang7CodeGen13CodeGenModule20getBlockObjectAssignEv;_ZN5clang7CodeGen13CodeGenModule21getBlockObjectDisposeEv;_ZN5clang7CodeGen13CodeGenModule22getBlockDescriptorTypeEv;_ZN5clang7CodeGen13CodeGenModule23getNSConcreteStackBlockEv;_ZN5clang7CodeGen13CodeGenModule24getNSConcreteGlobalBlockEv;_ZN5clang7CodeGen13CodeGenModule26getGenericBlockLiteralTypeEv; -static-type=CodeGenModule_CGBlocks -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGBlocks extends CodeGenModule_NotDefined {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// Fetches the type of a generic block descriptor.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getBlockDescriptorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 909,
 FQN="clang::CodeGen::CodeGenModule::getBlockDescriptorType", NM="_ZN5clang7CodeGen13CodeGenModule22getBlockDescriptorTypeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModule22getBlockDescriptorTypeEv")
//</editor-fold>
public final Type /*P*/ getBlockDescriptorType() {
  if (($this().BlockDescriptorType != null)) {
    return $this().BlockDescriptorType;
  }
  
  Type /*P*/ UnsignedLongTy = $this().getTypes().ConvertType($this().getContext().UnsignedLongTy.$QualType());
  
  // struct __block_descriptor {
  //   unsigned long reserved;
  //   unsigned long block_size;
  //
  //   // later, the following will be added
  //
  //   struct {
  //     void (*copyHelper)();
  //     void (*copyHelper)();
  //   } helpers;                // !!! optional
  //
  //   const char *signature;   // the block signature
  //   const char *layout;      // reserved
  // };
  $this().BlockDescriptorType
     = StructType.create(new StringRef(/*KEEP_STR*/"struct.__block_descriptor"), 
      UnsignedLongTy, UnsignedLongTy, null);
  
  // Now form a pointer to that.
  /*uint*/int AddrSpace = 0;
  if ($this().getLangOpts().OpenCL) {
    AddrSpace = $this().getContext().getTargetAddressSpace(LangAS.ID.opencl_constant);
  }
  $this().BlockDescriptorType = PointerType.get($this().BlockDescriptorType, AddrSpace);
  return $this().BlockDescriptorType;
}


/// The type of a generic block literal.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getGenericBlockLiteralType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 942,
 FQN="clang::CodeGen::CodeGenModule::getGenericBlockLiteralType", NM="_ZN5clang7CodeGen13CodeGenModule26getGenericBlockLiteralTypeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModule26getGenericBlockLiteralTypeEv")
//</editor-fold>
public final Type /*P*/ getGenericBlockLiteralType() {
  if (($this().GenericBlockLiteralType != null)) {
    return $this().GenericBlockLiteralType;
  }
  
  Type /*P*/ BlockDescPtrTy = $this().getBlockDescriptorType();
  
  // struct __block_literal_generic {
  //   void *__isa;
  //   int __flags;
  //   int __reserved;
  //   void (*__invoke)(void *);
  //   struct __block_descriptor *__descriptor;
  // };
  $this().GenericBlockLiteralType
     = StructType.create(new StringRef(/*KEEP_STR*/"struct.__block_literal_generic"), 
      $this().Unnamed_field9.VoidPtrTy, $this().IntTy, $this().IntTy, $this().Unnamed_field9.VoidPtrTy, 
      BlockDescPtrTy, null);
  
  return $this().GenericBlockLiteralType;
}


/// Gets the address of a block which requires no captures.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::GetAddrOfGlobalBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1043,
 FQN="clang::CodeGen::CodeGenModule::GetAddrOfGlobalBlock", NM="_ZN5clang7CodeGen13CodeGenModule20GetAddrOfGlobalBlockEPKNS_9BlockExprEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20GetAddrOfGlobalBlockEPKNS_9BlockExprEPKc")
//</editor-fold>
public final Constant /*P*/ GetAddrOfGlobalBlock(/*const*/ BlockExpr /*P*/ blockExpr, 
                    /*const*/char$ptr/*char P*/ name) {
  CGBlockInfo blockInfo = null;
  try {
    blockInfo/*J*/= new CGBlockInfo(blockExpr.getBlockDecl$Const(), new StringRef(name));
    blockInfo.BlockExpression = blockExpr;
    
    // Compute information about the layout, etc., of this block.
    computeBlockInfo(/*Deref*/$this(), (CodeGenFunction /*P*/ )null, blockInfo);
    
    // Using that metadata, generate the actual block function.
    Constant /*P*/ blockFn;
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        DenseMap</*const*/ Decl /*P*/ , Address> LocalDeclMap/*J*/= new DenseMap</*const*/ Decl /*P*/ , Address>(DenseMapInfo$LikePtr.$Info(), new Address());
        $c$.clean(blockFn = $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateBlockFunction(new GlobalDecl(), 
            blockInfo, 
            LocalDeclMap, 
            false));
      } finally {
        $c$.$destroy();
      }
    }
    blockFn = ConstantExpr.getBitCast(blockFn, $this().Unnamed_field9.VoidPtrTy);
    
    return buildGlobalBlock(/*Deref*/$this(), blockInfo, blockFn);
  } finally {
    if (blockInfo != null) { blockInfo.$destroy(); }
  }
}


///@name Custom Blocks Runtime Interfaces
///@{
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getNSConcreteGlobalBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2356,
 FQN="clang::CodeGen::CodeGenModule::getNSConcreteGlobalBlock", NM="_ZN5clang7CodeGen13CodeGenModule24getNSConcreteGlobalBlockEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24getNSConcreteGlobalBlockEv")
//</editor-fold>
public final Constant /*P*/ getNSConcreteGlobalBlock() {
  if (($this().NSConcreteGlobalBlock != null)) {
    return $this().NSConcreteGlobalBlock;
  }
  
  $this().NSConcreteGlobalBlock = $this().GetOrCreateLLVMGlobal(new StringRef(/*KEEP_STR*/"_NSConcreteGlobalBlock"), 
      $this().Unnamed_field9.Int8PtrTy.getPointerTo(), 
      (/*const*/ VarDecl /*P*/ )null);
  configureBlocksRuntimeObject(/*Deref*/$this(), $this().NSConcreteGlobalBlock);
  return $this().NSConcreteGlobalBlock;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getNSConcreteStackBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2367,
 FQN="clang::CodeGen::CodeGenModule::getNSConcreteStackBlock", NM="_ZN5clang7CodeGen13CodeGenModule23getNSConcreteStackBlockEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23getNSConcreteStackBlockEv")
//</editor-fold>
public final Constant /*P*/ getNSConcreteStackBlock() {
  if (($this().NSConcreteStackBlock != null)) {
    return $this().NSConcreteStackBlock;
  }
  
  $this().NSConcreteStackBlock = $this().GetOrCreateLLVMGlobal(new StringRef(/*KEEP_STR*/"_NSConcreteStackBlock"), 
      $this().Unnamed_field9.Int8PtrTy.getPointerTo(), 
      (/*const*/ VarDecl /*P*/ )null);
  configureBlocksRuntimeObject(/*Deref*/$this(), $this().NSConcreteStackBlock);
  return $this().NSConcreteStackBlock;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getBlockObjectAssign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2344,
 FQN="clang::CodeGen::CodeGenModule::getBlockObjectAssign", NM="_ZN5clang7CodeGen13CodeGenModule20getBlockObjectAssignEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20getBlockObjectAssignEv")
//</editor-fold>
public final Constant /*P*/ getBlockObjectAssign() {
  if (($this().BlockObjectAssign != null)) {
    return $this().BlockObjectAssign;
  }
  
  Type /*P*/ args[/*3*/] = new Type /*P*/  [/*3*/] {$this().Unnamed_field9.Int8PtrTy, $this().Unnamed_field9.Int8PtrTy, $this().Int32Ty};
  FunctionType /*P*/ fty = FunctionType.get($this().VoidTy, new ArrayRef<Type /*P*/ >(args, true), false);
  $this().BlockObjectAssign = $this().CreateRuntimeFunction(fty, new StringRef(/*KEEP_STR*/"_Block_object_assign"));
  configureBlocksRuntimeObject(/*Deref*/$this(), $this().BlockObjectAssign);
  return $this().BlockObjectAssign;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getBlockObjectDispose">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2332,
 FQN="clang::CodeGen::CodeGenModule::getBlockObjectDispose", NM="_ZN5clang7CodeGen13CodeGenModule21getBlockObjectDisposeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13CodeGenModule21getBlockObjectDisposeEv")
//</editor-fold>
public final Constant /*P*/ getBlockObjectDispose() {
  if (($this().BlockObjectDispose != null)) {
    return $this().BlockObjectDispose;
  }
  
  Type /*P*/ args[/*2*/] = new Type /*P*/  [/*2*/] {$this().Unnamed_field9.Int8PtrTy, $this().Int32Ty};
  FunctionType /*P*/ fty = FunctionType.get($this().VoidTy, new ArrayRef<Type /*P*/ >(args, true), false);
  $this().BlockObjectDispose = $this().CreateRuntimeFunction(fty, new StringRef(/*KEEP_STR*/"_Block_object_dispose"));
  configureBlocksRuntimeObject(/*Deref*/$this(), $this().BlockObjectDispose);
  return $this().BlockObjectDispose;
}

} // END OF class CodeGenModule_CGBlocks
