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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.clang.codegen.java.ClangCodeGenJavaDifferentiators.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import org.clang.basic.codegenoptions.DebugInfoKind;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGBlocks">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGBlocks",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGAtomic ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15LoadBlockStructEv;_ZN5clang7CodeGen15CodeGenFunction16EmitBlockLiteralEPKNS_9BlockExprE;_ZN5clang7CodeGen15CodeGenFunction16EmitBlockLiteralERKNS0_11CGBlockInfoE;_ZN5clang7CodeGen15CodeGenFunction17BuildBlockReleaseEPN4llvm5ValueENS0_15BlockFieldFlagsE;_ZN5clang7CodeGen15CodeGenFunction17EmitBlockCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE;_ZN5clang7CodeGen15CodeGenFunction17buildByrefHelpersERN4llvm10StructTypeERKNS1_15AutoVarEmissionE;_ZN5clang7CodeGen15CodeGenFunction17destroyBlockInfosEPNS0_11CGBlockInfoE;_ZN5clang7CodeGen15CodeGenFunction17enterByrefCleanupERKNS1_15AutoVarEmissionE;_ZN5clang7CodeGen15CodeGenFunction17getBlockByrefInfoEPKNS_7VarDeclE;_ZN5clang7CodeGen15CodeGenFunction18GetAddrOfBlockDeclEPKNS_7VarDeclEb;_ZN5clang7CodeGen15CodeGenFunction21GenerateBlockFunctionENS_10GlobalDeclERKNS0_11CGBlockInfoERKN4llvm8DenseMapIPKNS_4DeclENS0_7AddressENS6_12DenseMapInfoISA_EENS6_6detail12DenseMapPairISA_SB_EEEEb;_ZN5clang7CodeGen15CodeGenFunction21emitBlockByrefAddressENS0_7AddressEPKNS_7VarDeclEb;_ZN5clang7CodeGen15CodeGenFunction21emitBlockByrefAddressENS0_7AddressERKNS0_14BlockByrefInfoEbRKN4llvm5TwineE;_ZN5clang7CodeGen15CodeGenFunction22emitByrefStructureInitERKNS1_15AutoVarEmissionE;_ZN5clang7CodeGen15CodeGenFunction24setBlockContextParameterEPKNS_17ImplicitParamDeclEjPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction26GenerateCopyHelperFunctionERKNS0_11CGBlockInfoE;_ZN5clang7CodeGen15CodeGenFunction29GenerateDestroyHelperFunctionERKNS0_11CGBlockInfoE;_ZN5clang7CodeGen15CodeGenFunction29enterNonTrivialFullExpressionEPKNS_16ExprWithCleanupsE; -static-type=CodeGenFunction_CGBlocks -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGBlocks extends CodeGenFunction_CGAtomic {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGBlocks(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


//===--------------------------------------------------------------------===//
//                                  Block Bits
//===--------------------------------------------------------------------===//

/// Emit a block literal expression in the current function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBlockLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 679,
 FQN="clang::CodeGen::CodeGenFunction::EmitBlockLiteral", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitBlockLiteralEPKNS_9BlockExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitBlockLiteralEPKNS_9BlockExprE")
//</editor-fold>
public final Value /*P*/ EmitBlockLiteral(/*const*/ BlockExpr /*P*/ blockExpr) {
  std.unique_ptr<CGBlockInfo> blockInfo = null;
  try {
    // If the block has no captures, we won't have a pre-computed
    // layout for it.
    if (!blockExpr.getBlockDecl$Const().hasCaptures()) {
      CGBlockInfo blockInfo$1 = null;
      try {
        blockInfo$1/*J*/= new CGBlockInfo(blockExpr.getBlockDecl$Const(), $this().CurFn.getName());
        CGBlocksStatics.computeBlockInfo($this().CGM, $this(), blockInfo$1);
        blockInfo$1.BlockExpression = blockExpr;
        return $this().EmitBlockLiteral(blockInfo$1);
      } finally {
        if (blockInfo$1 != null) { blockInfo$1.$destroy(); }
      }
    }
    
    // Find the block info for this block and take ownership of it.
    blockInfo/*J*/= new std.unique_ptr<CGBlockInfo>();
    blockInfo.reset(CGBlocksStatics.findAndRemoveBlockInfo($AddrOf(create_type$ptr2ConstT($this().FirstBlockInfo)), 
            blockExpr.getBlockDecl$Const()));
    
    blockInfo.$arrow().BlockExpression = blockExpr;
    return $this().EmitBlockLiteral(blockInfo.$star());
  } finally {
    if (blockInfo != null) { blockInfo.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBlockLiteral">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 698,
 FQN="clang::CodeGen::CodeGenFunction::EmitBlockLiteral", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitBlockLiteralERKNS0_11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitBlockLiteralERKNS0_11CGBlockInfoE")
//</editor-fold>
public final Value /*P*/ EmitBlockLiteral(final /*const*/ CGBlockInfo /*&*/ blockInfo) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Using the computed layout, generate the actual block function.
    boolean isLambdaConv = blockInfo.getBlockDecl().isConversionFromLambda();
    Constant /*P*/ blockFn = $c$.clean($c$.track(new CodeGenFunction($this().CGM, true)).GenerateBlockFunction(new GlobalDecl($this().CurGD), blockInfo, 
        $this().LocalDeclMap, 
        isLambdaConv));
    blockFn = ConstantExpr.getBitCast(blockFn, Unnamed_field9.VoidPtrTy);
    
    // If there is nothing to capture, we can emit this as a global block.
    if (blockInfo.CanBeGlobal) {
      return CGBlocksStatics.buildGlobalBlock($this().CGM, blockInfo, blockFn);
    }
    
    // Otherwise, we have to emit this as a local block.
    Constant /*P*/ isa = $this().CGM.getNSConcreteStackBlock();
    isa = ConstantExpr.getBitCast(isa, Unnamed_field9.VoidPtrTy);
    
    // Build the block descriptor.
    Constant /*P*/ descriptor = CGBlocksStatics.buildBlockDescriptor($this().CGM, blockInfo);
    
    Address blockAddr = new Address(blockInfo.LocalAddress);
    assert (blockAddr.isValid()) : "block has no address!";
    
    // Compute the initial on-stack block flags.
    BlockFlags flags = new BlockFlags(JD$BlockLiteralFlags.INSTANCE, BlockLiteralFlags.BLOCK_HAS_SIGNATURE);
    if (blockInfo.HasCapturedVariableLayout) {
      BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockLiteralFlags.INSTANCE, BlockLiteralFlags.BLOCK_HAS_EXTENDED_LAYOUT));
    }
    if (blockInfo.NeedsCopyDispose) {
      BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockLiteralFlags.INSTANCE, BlockLiteralFlags.BLOCK_HAS_COPY_DISPOSE));
    }
    if (blockInfo.HasCXXObject) {
      BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockLiteralFlags.INSTANCE, BlockLiteralFlags.BLOCK_HAS_CXX_OBJ));
    }
    if (blockInfo.UsesStret) {
      BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockLiteralFlags.INSTANCE, BlockLiteralFlags.BLOCK_USE_STRET));
    }
    
    UIntCharUintTwine2Address projectField = /*[&, this, &blockAddr]*/ (/*uint*/int index, CharUnits offset, final /*const*/ Twine /*&*/ name) -> {
          return $this().Builder.CreateStructGEP(new Address(blockAddr), index, new CharUnits(offset), name);
        };
    ValueUIntCharUintTwine2Void storeField = /*[&, this, &projectField]*/ (Value /*P*/ value, /*uint*/int index, CharUnits offset, final /*const*/ Twine /*&*/ name) -> {
          $this().Builder.CreateStore(value, projectField.$call(index, new CharUnits(offset), name));
        };
    {
      // We assume all the header fields are densely packed.
      /*uint*/int$ref index = create_int$ref(0);
      CharUnits offset/*J*/= new CharUnits();
      ValueCharUintTwine2Void addHeaderField = /*[&, &storeField, &index, &offset]*/ (Value /*P*/ value, CharUnits size, final /*const*/ Twine /*&*/ name) -> {
            storeField.$call(value, index.$deref(), new CharUnits(offset), name);
            offset.$addassign(size);
            index.$set$postInc();
          };
      
      addHeaderField.$call(isa, /*J:ToBase*/super.getPointerSize(), new Twine(/*KEEP_STR*/"block.isa"));
      addHeaderField.$call(ConstantInt.get(IntTy, $uint2ulong(flags.getBitMask())), 
          /*J:ToBase*/super.getIntSize(), new Twine(/*KEEP_STR*/"block.flags")
      );
      addHeaderField.$call(ConstantInt.get(IntTy, $int2ulong(0)), 
          /*J:ToBase*/super.getIntSize(), new Twine(/*KEEP_STR*/"block.reserved")
      );
      addHeaderField.$call(blockFn, /*J:ToBase*/super.getPointerSize(), new Twine(/*KEEP_STR*/"block.invoke"));
      addHeaderField.$call(descriptor, /*J:ToBase*/super.getPointerSize(), new Twine(/*KEEP_STR*/"block.descriptor"));
    }
    
    // Finally, capture all the values into the block.
    /*const*/ BlockDecl /*P*/ blockDecl = blockInfo.getBlockDecl();
    
    // First, 'this'.
    if (blockDecl.capturesCXXThis()) {
      Address addr = projectField.$call(blockInfo.CXXThisIndex, new CharUnits(blockInfo.CXXThisOffset), 
          new Twine(/*KEEP_STR*/"block.captured-this.addr")
      );
      $this().Builder.CreateStore($this().LoadCXXThis(), new Address(addr));
    }
    
    // Next, captured variables.
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : blockDecl.captures()) {
      /*const*/ VarDecl /*P*/ variable = CI.getVariable();
      final /*const*/ CGBlockInfo.Capture /*&*/ capture = blockInfo.getCapture$Const(variable);
      
      // Ignore constant captures.
      if (capture.isConstant()) {
        continue;
      }
      
      QualType type = variable.getType();
      
      // This will be a [[type]]*, except that a byref entry will just be
      // an i8**.
      Address blockField = projectField.$call(capture.getIndex(), capture.getOffset(), new Twine(/*KEEP_STR*/"block.captured"));
      
      // Compute the address of the thing we're going to move into the
      // block literal.
      Address src = Address.invalid();
      if (blockDecl.isConversionFromLambda()) {
        // The lambda capture in a lambda's conversion-to-block-pointer is
        // special; we'll simply emit it directly.
        src.$assignMove(Address.invalid());
      } else if (CI.isByRef()) {
        if (($this().BlockInfo != null) && CI.isNested()) {
          // We need to use the capture from the enclosing block.
          final /*const*/ CGBlockInfo.Capture /*&*/ enclosingCapture = $this().BlockInfo.getCapture$Const(variable);
          
          // This is a [[type]]*, except that a byref entry wil just be an i8**.
          src.$assignMove($this().Builder.CreateStructGEP($this().LoadBlockStruct(), 
                  enclosingCapture.getIndex(), 
                  enclosingCapture.getOffset(), 
                  new Twine(/*KEEP_STR*/"block.capture.addr")));
        } else {
          DenseMapIterator</*const*/ Decl /*P*/ , Address> I = $this().LocalDeclMap.find(variable);
          assert (I.$noteq(/*NO_ITER_COPY*/$this().LocalDeclMap.end()));
          src.$assign(I.$arrow().second);
        }
      } else {
        DeclRefExpr declRef/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(variable)), 
            /*RefersToEnclosingVariableOrCapture*/ CI.isNested(), 
            type.getNonReferenceType(), ExprValueKind.VK_LValue, 
            new SourceLocation());
        src.$assignMove($this().EmitDeclRefLValue($AddrOf(declRef)).getAddress());
      }
      ;
      
      // For byrefs, we just write the pointer to the byref struct into
      // the block field.  There's no need to chase the forwarding
      // pointer at this point, since we're building something that will
      // live a shorter life than the stack byref anyway.
      if (CI.isByRef()) {
        // Get a void* that points to the byref struct.
        Value /*P*/ byrefPointer;
        if (CI.isNested()) {
          byrefPointer = $this().Builder.CreateLoad(new Address(src), $("byref.capture"));
        } else {
          byrefPointer = $this().Builder.CreateBitCast(src.getPointer(), Unnamed_field9.VoidPtrTy);
        }
        
        // Write that void* into the capture field.
        $this().Builder.CreateStore(byrefPointer, new Address(blockField));
        // If we have a copy constructor, evaluate that into the block field.
      } else {
        /*const*/ Expr /*P*/ copyExpr = CI.getCopyExpr();
        if ((copyExpr != null)) {
          if (blockDecl.isConversionFromLambda()) {
            // If we have a lambda conversion, emit the expression
            // directly into the block instead.
            AggValueSlot Slot = AggValueSlot.forAddr(new Address(blockField), new Qualifiers(), 
                AggValueSlot.IsDestructed_t.IsDestructed, 
                AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
                AggValueSlot.IsAliased_t.IsNotAliased);
            $this().EmitAggExpr(copyExpr, new AggValueSlot(Slot));
          } else {
            $this().EmitSynthesizedCXXCopyCtor(new Address(blockField), new Address(src), copyExpr);
          }
          // If it's a reference variable, copy the reference into the block field.
        } else if (type.$arrow().isReferenceType()) {
          $this().Builder.CreateStore(src.getPointer(), new Address(blockField));
          // If this is an ARC __strong block-pointer variable, don't do a
          // block copy.
          //
          // TODO: this can be generalized into the normal initialization logic:
          // we should never need to do a block-copy when initializing a local
          // variable, because the local variable's lifetime should be strictly
          // contained within the stack block's.
        } else if (type.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong
           && type.$arrow().isBlockPointerType()) {
          // Load the block and do a simple retain.
          Value /*P*/ value = $this().Builder.CreateLoad(new Address(src), $("block.captured_block"));
          value = $this().EmitARCRetainNonBlock(value);
          
          // Do a primitive store to the block field.
          $this().Builder.CreateStore(value, new Address(blockField));
          // Otherwise, fake up a POD copy into the block field.
        } else {
          ImplicitParamDecl blockFieldPseudoVar = null;
          try {
            // Fake up a new variable so that EmitScalarInit doesn't think
            // we're referring to the variable in its own initializer.
            blockFieldPseudoVar/*J*/= new ImplicitParamDecl($this().getContext(), /*DC*/ (DeclContext /*P*/ )null, 
                new SourceLocation(), /*name*/ (IdentifierInfo /*P*/ )null, 
                new QualType(type));
            
            // We use one of these or the other depending on whether the
            // reference is nested.
            DeclRefExpr declRef/*J*/= new DeclRefExpr(((/*const_cast*/VarDecl /*P*/ )(variable)), 
                /*RefersToEnclosingVariableOrCapture*/ CI.isNested(), 
                new QualType(type), ExprValueKind.VK_LValue, new SourceLocation());
            
            ImplicitCastExpr l2r/*J*/= new ImplicitCastExpr(ImplicitCastExpr.OnStack_t.OnStack, new QualType(type), CastKind.CK_LValueToRValue, 
                $AddrOf(declRef), ExprValueKind.VK_RValue);
            // FIXME: Pass a specific location for the expr init so that the store is
            // attributed to a reasonable location - otherwise it may be attributed to
            // locations of subexpressions in the initialization.
            $this().EmitExprAsInit($AddrOf(l2r), $AddrOf(blockFieldPseudoVar), 
                $this().MakeAddrLValue(new Address(blockField), new QualType(type), AlignmentSource.Decl), 
                /*captured by init*/ false);
          } finally {
            if (blockFieldPseudoVar != null) { blockFieldPseudoVar.$destroy(); }
          }
        }
      }
      
      // Activate the cleanup if layout pushed one.
      if (!CI.isByRef()) {
        EHScopeStack.stable_iterator cleanup = capture.getCleanup();
        if (cleanup.isValid()) {
          $this().ActivateCleanupBlock(new EHScopeStack.stable_iterator(cleanup), blockInfo.DominatingIP);
        }
      }
    }
    
    // Cast to the converted block-pointer type, which happens (somewhat
    // unfortunately) to be a pointer to function type.
    Value /*P*/ result = $this().Builder.CreateBitCast(blockAddr.getPointer(), 
        $this().ConvertType(blockInfo.getBlockExpr().getType()));
    
    return result;
  } finally {
    $c$.$destroy();
  }
}


/// Destroy a chain of block layouts.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::destroyBlockInfos">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 669,
 FQN="clang::CodeGen::CodeGenFunction::destroyBlockInfos", NM="_ZN5clang7CodeGen15CodeGenFunction17destroyBlockInfosEPNS0_11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17destroyBlockInfosEPNS0_11CGBlockInfoE")
//</editor-fold>
public static void destroyBlockInfos(CGBlockInfo /*P*/ head) {
  assert ((head != null)) : "destroying an empty chain";
  do {
    CGBlockInfo /*P*/ cur = head;
    head = cur.NextBlockInfo;
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)cur);
  } while (head != null);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateBlockFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1147,
 FQN="clang::CodeGen::CodeGenFunction::GenerateBlockFunction", NM="_ZN5clang7CodeGen15CodeGenFunction21GenerateBlockFunctionENS_10GlobalDeclERKNS0_11CGBlockInfoERKN4llvm8DenseMapIPKNS_4DeclENS0_7AddressENS6_12DenseMapInfoISA_EENS6_6detail12DenseMapPairISA_SB_EEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21GenerateBlockFunctionENS_10GlobalDeclERKNS0_11CGBlockInfoERKN4llvm8DenseMapIPKNS_4DeclENS0_7AddressENS6_12DenseMapInfoISA_EENS6_6detail12DenseMapPairISA_SB_EEEEb")
//</editor-fold>
public final Function /*P*/ GenerateBlockFunction(GlobalDecl GD, 
                     final /*const*/ CGBlockInfo /*&*/ blockInfo, 
                     final /*const*/DenseMap</*const*/ Decl /*P*/ , Address> /*&*/ ldm, 
                     boolean IsLambdaConversionToBlock) {
  FunctionArgList args = null;
  ImplicitParamDecl selfDecl = null;
  try {
    /*const*/ BlockDecl /*P*/ blockDecl = blockInfo.getBlockDecl();
    
    $this().CurGD.$assign(GD);
    
    $this().CurEHLocation.$assignMove(blockInfo.getBlockExpr().getLocEnd());
    
    $this().BlockInfo = $AddrOf(blockInfo);
    
    // Arrange for local static and local extern declarations to appear
    // to be local to this function as well, in case they're directly
    // referenced in a block.
    for (DenseMapIterator</*const*/ Decl /*P*/ , Address> i = ldm.begin$Const(), e = ldm.end$Const(); i.$noteq(e); i.$preInc()) {
      /*const*/ VarDecl /*P*/ var = AstDeclarationsRTTI.dyn_cast_VarDecl(i.$arrow().first);
      if ((var != null) && !var.hasLocalStorage()) {
        $this().setAddrOfLocalVar(var, new Address(i.$arrow().second));
      }
    }
    
    // Begin building the function declaration.
    
    // Build the argument list.
    args/*J*/= new FunctionArgList();
    
    // The first argument is the block pointer.  Just take it as a void*
    // and cast it later.
    QualType selfTy = $this().getContext().VoidPtrTy.$QualType();
    IdentifierInfo /*P*/ II = $AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/".block_descriptor")));
    
    selfDecl/*J*/= new ImplicitParamDecl($this().getContext(), ((/*const_cast*/BlockDecl /*P*/ )(blockDecl)), 
        new SourceLocation(), II, new QualType(selfTy));
    args.push_back($AddrOf(selfDecl));
    
    // Now add the rest of the parameters.
    args.append_T(blockDecl.param_begin$Const(), blockDecl.param_end$Const());
    
    // Create the function declaration.
    /*const*/ FunctionProtoType /*P*/ fnType = blockInfo.getBlockExpr().getFunctionType();
    final /*const*/ CGFunctionInfo /*&*/ fnInfo = $this().CGM.getTypes().arrangeBlockFunctionDeclaration(fnType, args);
    if ($this().CGM.ReturnSlotInterferesWithArgs(fnInfo)) {
      blockInfo.UsesStret = true;
    }
    
    org.llvm.ir.FunctionType /*P*/ fnLLVMType = $this().CGM.getTypes().GetFunctionType(fnInfo);
    
    StringRef name = $this().CGM.getBlockMangledName(new GlobalDecl(GD), blockDecl);
    Function /*P*/ fn = Function.Create(fnLLVMType, GlobalValue.LinkageTypes.InternalLinkage, new Twine(name), $AddrOf($this().CGM.getModule()));
    $this().CGM.SetInternalFunctionAttributes(blockDecl, fn, fnInfo);
    
    // Begin generating the function.
    $this().StartFunction(new GlobalDecl(blockDecl), fnType.getReturnType(), fn, fnInfo, args, 
        blockDecl.getLocation(), 
        blockInfo.getBlockExpr().getBody$Const().getLocStart());
    
    // Okay.  Undo some of what StartFunction did.
    
    // At -O0 we generate an explicit alloca for the BlockPointer, so the RA
    // won't delete the dbg.declare intrinsics for captured variables.
    Value /*P*/ BlockPointerDbgLoc = $this().BlockPointer;
    if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) == 0) {
      ApplyDebugLocation NL = null;
      try {
        // Allocate a stack slot for it, so we can point the debugger to it
        Address Alloca = $this().CreateTempAlloca($this().BlockPointer.getType(), 
            /*J:ToBase*/super.getPointerAlign(), 
            new Twine(/*KEEP_STR*/"block.addr"));
        // Set the DebugLocation to empty, so the store is recognized as a
        // frame setup instruction by llvm::DwarfDebug::beginFunction().
        NL = ApplyDebugLocation.CreateEmpty(/*Deref*/$this());
        $this().Builder.CreateStore($this().BlockPointer, new Address(Alloca));
        BlockPointerDbgLoc = Alloca.getPointer();
      } finally {
        if (NL != null) { NL.$destroy(); }
      }
    }
    
    // If we have a C++ 'this' reference, go ahead and force it into
    // existence now.
    if (blockDecl.capturesCXXThis()) {
      Address addr = $this().Builder.CreateStructGEP($this().LoadBlockStruct(), blockInfo.CXXThisIndex, 
          new CharUnits(blockInfo.CXXThisOffset), new Twine(/*KEEP_STR*/"block.captured-this"));
      $this().CXXThisValue = $this().Builder.CreateLoad(new Address(addr), $this);
    }
    
    // Also force all the constant captures.
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : blockDecl.captures()) {
      /*const*/ VarDecl /*P*/ variable = CI.getVariable();
      final /*const*/ CGBlockInfo.Capture /*&*/ capture = blockInfo.getCapture$Const(variable);
      if (!capture.isConstant()) {
        continue;
      }
      
      CharUnits align = $this().getContext().getDeclAlign(variable);
      Address alloca = $this().CreateMemTemp(variable.getType(), new CharUnits(align), new Twine(/*KEEP_STR*/"block.captured-const"));
      
      $this().Builder.CreateStore(capture.getConstant(), new Address(alloca));
      
      $this().setAddrOfLocalVar(variable, new Address(alloca));
    }
    
    // Save a spot to insert the debug information for all the DeclRefExprs.
    BasicBlock /*P*/ entry = $this().Builder.GetInsertBlock();
    ilist_iterator<Instruction> entry_ptr = $this().Builder.GetInsertPoint();
    entry_ptr.$preDec();
    if (IsLambdaConversionToBlock) {
      $this().EmitLambdaBlockInvokeBody();
    } else {
      $this().PGO.assignRegionCounters(new GlobalDecl(blockDecl), fn);
      $this().incrementProfileCounter(blockDecl.getBody());
      $this().EmitStmt(blockDecl.getBody());
    }
    
    // Remember where we were...
    BasicBlock /*P*/ resume = $this().Builder.GetInsertBlock();
    
    // Go back to the entry.
    entry_ptr.$preInc();
    $this().Builder.SetInsertPoint(entry, new ilist_iterator<Instruction>(entry_ptr));
    {
      
      // Emit debug information for all the DeclRefExprs.
      // FIXME: also for 'this'
      CGDebugInfo /*P*/ DI = $this().getDebugInfo();
      if ((DI != null)) {
        for (final /*const*/ BlockDecl.Capture /*&*/ CI : blockDecl.captures()) {
          /*const*/ VarDecl /*P*/ variable = CI.getVariable();
          DI.EmitLocation($this().Builder, variable.getLocation());
          if ($this().CGM.getCodeGenOpts().getDebugInfo().getValue()
             >= DebugInfoKind.LimitedDebugInfo.getValue()) {
            final /*const*/ CGBlockInfo.Capture /*&*/ capture = blockInfo.getCapture$Const(variable);
            if (capture.isConstant()) {
              Address addr = new Address($this().LocalDeclMap.find(variable).$arrow().second);
              DI.EmitDeclareOfAutoVariable(variable, addr.getPointer(), 
                  $this().Builder);
              continue;
            }
            
            DI.EmitDeclareOfBlockDeclRefVariable(variable, BlockPointerDbgLoc, $this().Builder, blockInfo, 
                entry_ptr.$eq(entry.end()) ? (Instruction /*P*/ )null : $AddrOf(entry_ptr.$star()));
          }
        }
        // Recover location if it was changed in the above loop.
        DI.EmitLocation($this().Builder, 
            AstStatementsRTTI.cast_CompoundStmt(blockDecl.getBody()).getRBracLoc());
      }
    }
    
    // And resume where we left off.
    if (resume == null) {
      $this().Builder.ClearInsertionPoint();
    } else {
      $this().Builder.SetInsertPoint(resume);
    }
    
    $this().FinishFunction(AstStatementsRTTI.cast_CompoundStmt(blockDecl.getBody()).getRBracLoc());
    
    return fn;
  } finally {
    if (selfDecl != null) { selfDecl.$destroy(); }
    if (args != null) { args.$destroy(); }
  }
}


/*
notes.push_back(HelperInfo());
HelperInfo &note = notes.back();
note.index = capture.getIndex();
note.RequiresCopying = (ci->hasCopyExpr() || BlockRequiresCopying(type));
note.cxxbar_import = ci->getCopyExpr();

if (ci->isByRef()) {
note.flag = BLOCK_FIELD_IS_BYREF;
if (type.isObjCGCWeak())
note.flag |= BLOCK_FIELD_IS_WEAK;
} else if (type->isBlockPointerType()) {
note.flag = BLOCK_FIELD_IS_BLOCK;
} else {
note.flag = BLOCK_FIELD_IS_OBJECT;
}
*/

/// Generate the copy-helper function for a block closure object:
///   static void block_copy_helper(block_t *dst, block_t *src);
/// The runtime will have previously initialized 'dst' by doing a
/// bit-copy of 'src'.
///
/// Note that this copies an entire block closure object to the heap;
/// it should not be confused with a 'byref copy helper', which moves
/// the contents of an individual __block variable to the heap.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateCopyHelperFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1330,
 FQN="clang::CodeGen::CodeGenFunction::GenerateCopyHelperFunction", NM="_ZN5clang7CodeGen15CodeGenFunction26GenerateCopyHelperFunctionERKNS0_11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26GenerateCopyHelperFunctionERKNS0_11CGBlockInfoE")
//</editor-fold>
public final Constant /*P*/ GenerateCopyHelperFunction(final /*const*/ CGBlockInfo /*&*/ blockInfo) {
  FunctionArgList args = null;
  ImplicitParamDecl dstDecl = null;
  ImplicitParamDecl srcDecl = null;
  ApplyDebugLocation NL = null;
  ApplyDebugLocation AL = null;
  try {
    final ASTContext /*&*/ C = $this().getContext();
    
    args/*J*/= new FunctionArgList();
    dstDecl/*J*/= new ImplicitParamDecl($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        C.VoidPtrTy.$QualType());
    args.push_back($AddrOf(dstDecl));
    srcDecl/*J*/= new ImplicitParamDecl($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        C.VoidPtrTy.$QualType());
    args.push_back($AddrOf(srcDecl));
    
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), args);
    
    // FIXME: it would be nice if these were mergeable with things with
    // identical semantics.
    org.llvm.ir.FunctionType /*P*/ LTy = $this().CGM.getTypes().GetFunctionType(FI);
    
    Function /*P*/ Fn = Function.Create(LTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/"__copy_helper_block_"), $AddrOf($this().CGM.getModule()));
    
    IdentifierInfo /*P*/ II = $AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"__copy_helper_block_")));
    
    FunctionDecl /*P*/ FD = FunctionDecl.Create(C, 
        C.getTranslationUnitDecl(), 
        new SourceLocation(), 
        new SourceLocation(), new DeclarationName(II), C.VoidTy.$QualType(), 
        (TypeSourceInfo /*P*/ )null, StorageClass.SC_Static, 
        false, 
        false);
    
    $this().CGM.SetInternalFunctionAttributes((/*const*/ Decl /*P*/ )null, Fn, FI);
    
    NL = ApplyDebugLocation.CreateEmpty(/*Deref*/$this());
    $this().StartFunction(new GlobalDecl(FD), C.VoidTy.$QualType(), Fn, FI, args);
    // Create a scope with an artificial location for the body of this function.
    AL = ApplyDebugLocation.CreateArtificial(/*Deref*/$this());
    org.llvm.ir.Type /*P*/ structPtrTy = blockInfo.StructureType.getPointerTo();
    
    Address src = $this().GetAddrOfLocalVar($AddrOf(srcDecl));
    src.$assignMove(new Address($this().Builder.CreateLoad(new Address(src)), new CharUnits(blockInfo.BlockAlign)));
    src.$assignMove($this().Builder.CreateBitCast(new Address(src), structPtrTy, new Twine(/*KEEP_STR*/"block.source")));
    
    Address dst = $this().GetAddrOfLocalVar($AddrOf(dstDecl));
    dst.$assignMove(new Address($this().Builder.CreateLoad(new Address(dst)), new CharUnits(blockInfo.BlockAlign)));
    dst.$assignMove($this().Builder.CreateBitCast(new Address(dst), structPtrTy, new Twine(/*KEEP_STR*/"block.dest")));
    
    /*const*/ BlockDecl /*P*/ blockDecl = blockInfo.getBlockDecl();
    
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : blockDecl.captures()) {
      /*const*/ VarDecl /*P*/ variable = CI.getVariable();
      QualType type = variable.getType();
      
      final /*const*/ CGBlockInfo.Capture /*&*/ capture = blockInfo.getCapture$Const(variable);
      if (capture.isConstant()) {
        continue;
      }
      
      /*const*/ Expr /*P*/ copyExpr = CI.getCopyExpr();
      BlockFieldFlags flags/*J*/= new BlockFieldFlags();
      
      boolean useARCWeakCopy = false;
      boolean useARCStrongCopy = false;
      if ((copyExpr != null)) {
        assert (!CI.isByRef());
        // don't bother computing flags
      } else if (CI.isByRef()) {
        flags.$assignMove(new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_BYREF));
        if (type.isObjCGCWeak()) {
          BlockFieldFlags.$orassign_BlockFieldFlags(flags, new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_WEAK));
        }
      } else if (type.$arrow().isObjCRetainableType()) {
        flags.$assignMove(new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_OBJECT));
        boolean isBlockPointer = type.$arrow().isBlockPointerType();
        if (isBlockPointer) {
          flags.$assignMove(new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_BLOCK));
        }
        
        // Special rules for ARC captures:
        Qualifiers qs = type.getQualifiers();
        
        // We need to register __weak direct captures with the runtime.
        if (qs.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
          useARCWeakCopy = true;
          // We need to retain the copied value for __strong direct captures.
        } else if (qs.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong) {
          // If it's a block pointer, we have to copy the block and
          // assign that to the destination pointer, so we might as
          // well use _Block_object_assign.  Otherwise we can avoid that.
          if (!isBlockPointer) {
            useARCStrongCopy = true;
          }
          // Non-ARC captures of retainable pointers are strong and
          // therefore require a call to _Block_object_assign.
        } else if (!(qs.getObjCLifetime().getValue() != 0) && !$this().getLangOpts().ObjCAutoRefCount) {

          // fall through

          // Otherwise the memcpy is fine.
        } else {
          continue;
        }
        // For all other types, the memcpy is fine.
      } else {
        continue;
      }
      
      /*uint*/int index = capture.getIndex();
      Address srcField = $this().Builder.CreateStructGEP(new Address(src), index, capture.getOffset());
      Address dstField = $this().Builder.CreateStructGEP(new Address(dst), index, capture.getOffset());
      
      // If there's an explicit copy expression, we do that.
      if ((copyExpr != null)) {
        $this().EmitSynthesizedCXXCopyCtor(new Address(dstField), new Address(srcField), copyExpr);
      } else if (useARCWeakCopy) {
        $this().EmitARCCopyWeak(new Address(dstField), new Address(srcField));
      } else {
        Value /*P*/ srcValue = $this().Builder.CreateLoad(new Address(srcField), $("blockcopy.src"));
        if (useARCStrongCopy) {
          // At -O0, store null into the destination field (so that the
          // storeStrong doesn't over-release) and then call storeStrong.
          // This is a workaround to not having an initStrong call.
          if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) == 0) {
            org.llvm.ir.PointerType /*P*/ ty = IrRTTI.cast_PointerType(srcValue.getType());
            Value /*P*/ __null = ConstantPointerNull.get(ty);
            $this().Builder.CreateStore(__null, new Address(dstField));
            $this().EmitARCStoreStrongCall(new Address(dstField), srcValue, true);
            // With optimization enabled, take advantage of the fact that
            // the blocks runtime guarantees a memcpy of the block data, and
            // just emit a retain of the src field.
          } else {
            $this().EmitARCRetainNonBlock(srcValue);
            
            // We don't need this anymore, so kill it.  It's not quite
            // worth the annoyance to avoid creating it in the first place.
            IrRTTI.cast_Instruction(dstField.getPointer()).eraseFromParent();
          }
        } else {
          srcValue = $this().Builder.CreateBitCast(srcValue, Unnamed_field9.VoidPtrTy);
          Value /*P*/ dstAddr = $this().Builder.CreateBitCast(dstField.getPointer(), Unnamed_field9.VoidPtrTy);
          Value /*P*/ args$1[/*3*/] = new Value /*P*/  [/*3*/] {
            dstAddr, srcValue, ConstantInt.get(Int32Ty, $uint2ulong(flags.getBitMask()))
          };
          
          boolean copyCanThrow = false;
          if (CI.isByRef() && (variable.getType().$arrow().getAsCXXRecordDecl() != null)) {
            /*const*/ Expr /*P*/ copyExpr$1 = $this().CGM.getContext().getBlockVarCopyInits(variable);
            if ((copyExpr$1 != null)) {
              copyCanThrow = true; // FIXME: reuse the noexcept logic
            }
          }
          if (copyCanThrow) {
            $this().EmitRuntimeCallOrInvoke($this().CGM.getBlockObjectAssign(), new ArrayRef<Value /*P*/ >(args$1, true));
          } else {
            $this().EmitNounwindRuntimeCall($this().CGM.getBlockObjectAssign(), new ArrayRef<Value /*P*/ >(args$1, true));
          }
        }
      }
    }
    
    $this().FinishFunction();
    
    return ConstantExpr.getBitCast(Fn, Unnamed_field9.VoidPtrTy);
  } finally {
    if (AL != null) { AL.$destroy(); }
    if (NL != null) { NL.$destroy(); }
    if (srcDecl != null) { srcDecl.$destroy(); }
    if (dstDecl != null) { dstDecl.$destroy(); }
    if (args != null) { args.$destroy(); }
  }
}


/// Generate the destroy-helper function for a block closure object:
///   static void block_destroy_helper(block_t *theBlock);
///
/// Note that this destroys a heap-allocated block closure object;
/// it should not be confused with a 'byref destroy helper', which
/// destroys the heap-allocated contents of an individual __block
/// variable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateDestroyHelperFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1509,
 FQN="clang::CodeGen::CodeGenFunction::GenerateDestroyHelperFunction", NM="_ZN5clang7CodeGen15CodeGenFunction29GenerateDestroyHelperFunctionERKNS0_11CGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29GenerateDestroyHelperFunctionERKNS0_11CGBlockInfoE")
//</editor-fold>
public final Constant /*P*/ GenerateDestroyHelperFunction(final /*const*/ CGBlockInfo /*&*/ blockInfo) {
  FunctionArgList args = null;
  ImplicitParamDecl srcDecl = null;
  ApplyDebugLocation NL = null;
  ApplyDebugLocation AL = null;
  CodeGenFunction.RunCleanupsScope cleanups = null;
  try {
    final ASTContext /*&*/ C = $this().getContext();
    
    args/*J*/= new FunctionArgList();
    srcDecl/*J*/= new ImplicitParamDecl($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        C.VoidPtrTy.$QualType());
    args.push_back($AddrOf(srcDecl));
    
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration(C.VoidTy.$QualType(), args);
    
    // FIXME: We'd like to put these into a mergable by content, with
    // internal linkage.
    org.llvm.ir.FunctionType /*P*/ LTy = $this().CGM.getTypes().GetFunctionType(FI);
    
    Function /*P*/ Fn = Function.Create(LTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine(/*KEEP_STR*/"__destroy_helper_block_"), $AddrOf($this().CGM.getModule()));
    
    IdentifierInfo /*P*/ II = $AddrOf($this().CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"__destroy_helper_block_")));
    
    FunctionDecl /*P*/ FD = FunctionDecl.Create(C, C.getTranslationUnitDecl(), 
        new SourceLocation(), 
        new SourceLocation(), new DeclarationName(II), C.VoidTy.$QualType(), 
        (TypeSourceInfo /*P*/ )null, StorageClass.SC_Static, 
        false, false);
    
    $this().CGM.SetInternalFunctionAttributes((/*const*/ Decl /*P*/ )null, Fn, FI);
    
    // Create a scope with an artificial location for the body of this function.
    NL = ApplyDebugLocation.CreateEmpty(/*Deref*/$this());
    $this().StartFunction(new GlobalDecl(FD), C.VoidTy.$QualType(), Fn, FI, args);
    AL = ApplyDebugLocation.CreateArtificial(/*Deref*/$this());
    
    org.llvm.ir.Type /*P*/ structPtrTy = blockInfo.StructureType.getPointerTo();
    
    Address src = $this().GetAddrOfLocalVar($AddrOf(srcDecl));
    src.$assignMove(new Address($this().Builder.CreateLoad(new Address(src)), new CharUnits(blockInfo.BlockAlign)));
    src.$assignMove($this().Builder.CreateBitCast(new Address(src), structPtrTy, new Twine(/*KEEP_STR*/"block")));
    
    /*const*/ BlockDecl /*P*/ blockDecl = blockInfo.getBlockDecl();
    
    cleanups/*J*/= new CodeGenFunction.RunCleanupsScope(/*Deref*/$this());
    
    for (final /*const*/ BlockDecl.Capture /*&*/ CI : blockDecl.captures()) {
      /*const*/ VarDecl /*P*/ variable = CI.getVariable();
      QualType type = variable.getType();
      
      final /*const*/ CGBlockInfo.Capture /*&*/ capture = blockInfo.getCapture$Const(variable);
      if (capture.isConstant()) {
        continue;
      }
      
      BlockFieldFlags flags/*J*/= new BlockFieldFlags();
      /*const*/ CXXDestructorDecl /*P*/ dtor = null;
      
      boolean useARCWeakDestroy = false;
      boolean useARCStrongDestroy = false;
      if (CI.isByRef()) {
        flags.$assignMove(new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_BYREF));
        if (type.isObjCGCWeak()) {
          BlockFieldFlags.$orassign_BlockFieldFlags(flags, new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_WEAK));
        }
      } else {
        /*const*/ CXXRecordDecl /*P*/ record = type.$arrow().getAsCXXRecordDecl();
        if ((record != null)) {
          if (record.hasTrivialDestructor()) {
            continue;
          }
          dtor = record.getDestructor();
        } else if (type.$arrow().isObjCRetainableType()) {
          flags.$assignMove(new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_OBJECT));
          if (type.$arrow().isBlockPointerType()) {
            flags.$assignMove(new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_BLOCK));
          }
          
          // Special rules for ARC captures.
          Qualifiers qs = type.getQualifiers();
          
          // Use objc_storeStrong for __strong direct captures; the
          // dynamic tools really like it when we do this.
          if (qs.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong) {
            useARCStrongDestroy = true;
            // Support __weak direct captures.
          } else if (qs.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
            useARCWeakDestroy = true;
            // Non-ARC captures are strong, and we need to use _Block_object_dispose.
          } else if (!qs.hasObjCLifetime() && !$this().getLangOpts().ObjCAutoRefCount) {

            // fall through

            // Otherwise, we have nothing to do.
          } else {
            continue;
          }
        } else {
          continue;
        }
      }
      
      Address srcField = $this().Builder.CreateStructGEP(new Address(src), capture.getIndex(), capture.getOffset());
      
      // If there's an explicit copy expression, we do that.
      if ((dtor != null)) {
        $this().PushDestructorCleanup(dtor, new Address(srcField));
        // If this is a __weak capture, emit the release directly.
      } else if (useARCWeakDestroy) {
        $this().EmitARCDestroyWeak(new Address(srcField));
        // Destroy strong objects with a call if requested.
      } else if (useARCStrongDestroy) {
        $this().EmitARCDestroyStrong(new Address(srcField), ARCPreciseLifetime_t.ARCImpreciseLifetime);
        // Otherwise we call _Block_object_dispose.  It wouldn't be too
        // hard to just emit this as a cleanup if we wanted to make sure
        // that things were done in reverse.
      } else {
        Value /*P*/ value = $this().Builder.CreateLoad(new Address(srcField));
        value = $this().Builder.CreateBitCast(value, Unnamed_field9.VoidPtrTy);
        $this().BuildBlockRelease(value, new BlockFieldFlags(flags));
      }
    }
    
    cleanups.ForceCleanup();
    
    $this().FinishFunction();
    
    return ConstantExpr.getBitCast(Fn, Unnamed_field9.VoidPtrTy);
  } finally {
    if (cleanups != null) { cleanups.$destroy(); }
    if (AL != null) { AL.$destroy(); }
    if (NL != null) { NL.$destroy(); }
    if (srcDecl != null) { srcDecl.$destroy(); }
    if (args != null) { args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::BuildBlockRelease">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2260,
 FQN="clang::CodeGen::CodeGenFunction::BuildBlockRelease", NM="_ZN5clang7CodeGen15CodeGenFunction17BuildBlockReleaseEPN4llvm5ValueENS0_15BlockFieldFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17BuildBlockReleaseEPN4llvm5ValueENS0_15BlockFieldFlagsE")
//</editor-fold>
public final void BuildBlockRelease(Value /*P*/ V, BlockFieldFlags flags) {
  Value /*P*/ F = $this().CGM.getBlockObjectDispose();
  Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {
    $this().Builder.CreateBitCast(V, Unnamed_field9.Int8PtrTy), 
    ConstantInt.get(Int32Ty, $uint2ulong(flags.getBitMask()))
  };
  $this().EmitNounwindRuntimeCall(F, new ArrayRef<Value /*P*/ >(args, true)); // FIXME: throwing destructors?
}


/// Initialize the structural components of a __block variable, i.e.
/// everything but the actual object.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitByrefStructureInit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2153,
 FQN="clang::CodeGen::CodeGenFunction::emitByrefStructureInit", NM="_ZN5clang7CodeGen15CodeGenFunction22emitByrefStructureInitERKNS1_15AutoVarEmissionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22emitByrefStructureInitERKNS1_15AutoVarEmissionE")
//</editor-fold>
public final void emitByrefStructureInit(final /*const*/ AutoVarEmission /*&*/ emission) {
  // Find the address of the local.
  Address addr = new Address(emission.Addr);
  
  // That's an alloca of the byref structure type.
  StructType /*P*/ byrefType = IrRTTI.cast_StructType(IrRTTI.cast_PointerType(addr.getPointer().getType()).getElementType());
  
  /*uint*/int$ref nextHeaderIndex = create_int$ref(0);
  CharUnits nextHeaderOffset/*J*/= new CharUnits();
  ValueCharUintTwine2Void storeHeaderField = /*[&, this, &addr, &nextHeaderIndex, &nextHeaderOffset]*/ (Value /*P*/ value, CharUnits fieldSize, final /*const*/ Twine /*&*/ name) -> {
        Address fieldAddr = $this().Builder.CreateStructGEP(new Address(addr), nextHeaderIndex.$deref(), 
            new CharUnits(nextHeaderOffset), name);
        $this().Builder.CreateStore(value, new Address(fieldAddr));
        
        nextHeaderIndex.$set$postInc();
        nextHeaderOffset.$addassign(fieldSize);
      };
  
  // Build the byref helpers if necessary.  This is null if we don't need any.
  BlockByrefHelpers /*P*/ helpers = $this().buildByrefHelpers($Deref(byrefType), emission);
  
  final /*const*/ VarDecl /*&*/ D = $Deref(emission.Variable);
  QualType type = D.getType();
  
  bool$ref HasByrefExtendedLayout = create_bool$ref();
  type$ref<Qualifiers.ObjCLifetime> ByrefLifetime = create_type$ref();
  boolean ByRefHasLifetime = $this().getContext().getByrefLifetime(new QualType(type), ByrefLifetime, HasByrefExtendedLayout);
  
  Value /*P*/ V;
  
  // Initialize the 'isa', which is just 0 or 1.
  int isa = 0;
  if (type.isObjCGCWeak()) {
    isa = 1;
  }
  V = $this().Builder.CreateIntToPtr($this().Builder.getInt32(isa), Unnamed_field9.Int8PtrTy, new Twine(/*KEEP_STR*/"isa"));
  storeHeaderField.$call(V, /*J:ToBase*/super.getPointerSize(), new Twine(/*KEEP_STR*/"byref.isa"));
  
  // Store the address of the variable into its own forwarding pointer.
  storeHeaderField.$call(addr.getPointer(), /*J:ToBase*/super.getPointerSize(), new Twine(/*KEEP_STR*/"byref.forwarding"));
  
  // Blocks ABI:
  //   c) the flags field is set to either 0 if no helper functions are
  //      needed or BLOCK_BYREF_HAS_COPY_DISPOSE if they are,
  BlockFlags flags/*J*/= new BlockFlags();
  if ((helpers != null)) {
    BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_HAS_COPY_DISPOSE));
  }
  if (ByRefHasLifetime) {
    if (HasByrefExtendedLayout.$deref()) {
      BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_EXTENDED));
    } else {
      switch (ByrefLifetime.$deref()) {
       case OCL_Strong:
        BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_STRONG));
        break;
       case OCL_Weak:
        BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_WEAK));
        break;
       case OCL_ExplicitNone:
        BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_UNRETAINED));
        break;
       case OCL_None:
        if (!type.$arrow().isObjCObjectPointerType() && !type.$arrow().isBlockPointerType()) {
          BlockFlags.$orassign_BlockFlags(flags, new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_NON_OBJECT));
        }
        break;
       default:
        break;
      }
    }
    if ($this().CGM.getLangOpts().ObjCGCBitmapPrint) {
      printf(/*KEEP_STR*/"\n Inline flag for BYREF variable layout (%d):", flags.getBitMask());
      if (BlockFlags.$bitand_BlockFlags(/*NO_COPY*/flags, new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_HAS_COPY_DISPOSE))) {
        printf(/*KEEP_STR*/" BLOCK_BYREF_HAS_COPY_DISPOSE");
      }
      if (BlockFlags.$bitand_BlockFlags(/*NO_COPY*/flags, new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_MASK))) {
        BlockFlags ThisFlag/*J*/= new BlockFlags(flags.getBitMask() & BlockByrefFlags.BLOCK_BYREF_LAYOUT_MASK);
        if (ThisFlag.$eq(new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_EXTENDED))) {
          printf(/*KEEP_STR*/" BLOCK_BYREF_LAYOUT_EXTENDED");
        }
        if (ThisFlag.$eq(new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_STRONG))) {
          printf(/*KEEP_STR*/" BLOCK_BYREF_LAYOUT_STRONG");
        }
        if (ThisFlag.$eq(new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_WEAK))) {
          printf(/*KEEP_STR*/" BLOCK_BYREF_LAYOUT_WEAK");
        }
        if (ThisFlag.$eq(new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_UNRETAINED))) {
          printf(/*KEEP_STR*/" BLOCK_BYREF_LAYOUT_UNRETAINED");
        }
        if (ThisFlag.$eq(new BlockFlags(JD$BlockByrefFlags.INSTANCE, BlockByrefFlags.BLOCK_BYREF_LAYOUT_NON_OBJECT))) {
          printf(/*KEEP_STR*/" BLOCK_BYREF_LAYOUT_NON_OBJECT");
        }
      }
      printf(/*KEEP_STR*/"\n");
    }
  }
  storeHeaderField.$call(ConstantInt.get(IntTy, $uint2ulong(flags.getBitMask())), 
      /*J:ToBase*/super.getIntSize(), new Twine(/*KEEP_STR*/"byref.flags")
  );
  
  CharUnits byrefSize = $this().CGM.GetTargetTypeStoreSize(byrefType);
  V = ConstantInt.get(IntTy, byrefSize.getQuantity());
  storeHeaderField.$call(V, /*J:ToBase*/super.getIntSize(), new Twine(/*KEEP_STR*/"byref.size"));
  if ((helpers != null)) {
    storeHeaderField.$call(helpers.CopyHelper, /*J:ToBase*/super.getPointerSize(), 
        new Twine(/*KEEP_STR*/"byref.copyHelper")
    );
    storeHeaderField.$call(helpers.DisposeHelper, /*J:ToBase*/super.getPointerSize(), 
        new Twine(/*KEEP_STR*/"byref.disposeHelper")
    );
  }
  if (ByRefHasLifetime && HasByrefExtendedLayout.$deref()) {
    Constant /*P*/ layoutInfo = $this().CGM.getObjCRuntime().BuildByrefLayout($this().CGM, new QualType(type));
    storeHeaderField.$call(layoutInfo, /*J:ToBase*/super.getPointerSize(), new Twine(/*KEEP_STR*/"byref.layout"));
  }
}

// end anonymous namespace

/// Enter a cleanup to destroy a __block variable.  Note that this
/// cleanup should be a no-op if the variable hasn't left the stack
/// yet; if a cleanup is required for the variable itself, that needs
/// to be done externally.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::enterByrefCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2286,
 FQN="clang::CodeGen::CodeGenFunction::enterByrefCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction17enterByrefCleanupERKNS1_15AutoVarEmissionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17enterByrefCleanupERKNS1_15AutoVarEmissionE")
//</editor-fold>
public final void enterByrefCleanup(final /*const*/ AutoVarEmission /*&*/ emission) {
  // We don't enter this cleanup if we're in pure-GC mode.
  if ($this().CGM.getLangOpts().getGC() == LangOptions.GCMode.GCOnly) {
    return;
  }
  
  $this().EHStack.<CallBlockRelease>pushCleanup$T(CleanupKind.NormalAndEHCleanup, 
      () -> new CallBlockRelease(emission.Addr.getPointer()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::setBlockContextParameter">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1109,
 FQN="clang::CodeGen::CodeGenFunction::setBlockContextParameter", NM="_ZN5clang7CodeGen15CodeGenFunction24setBlockContextParameterEPKNS_17ImplicitParamDeclEjPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24setBlockContextParameterEPKNS_17ImplicitParamDeclEjPN4llvm5ValueE")
//</editor-fold>
public final void setBlockContextParameter(/*const*/ ImplicitParamDecl /*P*/ D, 
                        /*uint*/int argNum, 
                        Value /*P*/ arg) {
  ApplyDebugLocation Scope = null;
  try {
    assert (($this().BlockInfo != null)) : "not emitting prologue of block invocation function?!";
    
    Value /*P*/ localAddr = null;
    if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) == 0) {
      // Allocate a stack slot to let the debug info survive the RA.
      Address alloc = $this().CreateMemTemp(D.getType(), $add_StringRef$C_char$ptr$C(D.getName(), /*KEEP_STR*/".addr"));
      $this().Builder.CreateStore(arg, new Address(alloc));
      localAddr = $this().Builder.CreateLoad(new Address(alloc));
    }
    {
      
      CGDebugInfo /*P*/ DI = $this().getDebugInfo();
      if ((DI != null)) {
        if ($this().CGM.getCodeGenOpts().getDebugInfo().getValue()
           >= DebugInfoKind.LimitedDebugInfo.getValue()) {
          DI.setLocation(D.getLocation());
          DI.EmitDeclareOfBlockLiteralArgVariable($Deref($this().BlockInfo), arg, argNum, 
              localAddr, $this().Builder);
        }
      }
    }
    
    SourceLocation StartLoc = $this().BlockInfo.getBlockExpr().getBody$Const().getLocStart();
    Scope/*J*/= new ApplyDebugLocation(/*Deref*/$this(), new SourceLocation(StartLoc));
    
    // Instead of messing around with LocalDeclMap, just set the value
    // directly as BlockPointer.
    $this().BlockPointer = $this().Builder.CreateBitCast(arg, 
        $this().BlockInfo.StructureType.getPointerTo(), 
        new Twine(/*KEEP_STR*/"block"));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LoadBlockStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1141,
 FQN="clang::CodeGen::CodeGenFunction::LoadBlockStruct", NM="_ZN5clang7CodeGen15CodeGenFunction15LoadBlockStructEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15LoadBlockStructEv")
//</editor-fold>
public final Address LoadBlockStruct() {
  assert (($this().BlockInfo != null)) : "not in a block invocation function!";
  assert (($this().BlockPointer != null)) : "no block pointer set!";
  return new Address($this().BlockPointer, new CharUnits($this().BlockInfo.BlockAlign));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetAddrOfBlockDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1010,
 FQN="clang::CodeGen::CodeGenFunction::GetAddrOfBlockDecl", NM="_ZN5clang7CodeGen15CodeGenFunction18GetAddrOfBlockDeclEPKNS_7VarDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18GetAddrOfBlockDeclEPKNS_7VarDeclEb")
//</editor-fold>
public final Address GetAddrOfBlockDecl(/*const*/ VarDecl /*P*/ variable, 
                  boolean isByRef) {
  assert (($this().BlockInfo != null)) : "evaluating block ref without block information?";
  final /*const*/ CGBlockInfo.Capture /*&*/ capture = $this().BlockInfo.getCapture$Const(variable);
  
  // Handle constant captures.
  if (capture.isConstant()) {
    return new Address($this().LocalDeclMap.find(variable).$arrow().second);
  }
  
  Address addr = $this().Builder.CreateStructGEP($this().LoadBlockStruct(), capture.getIndex(), 
      capture.getOffset(), new Twine(/*KEEP_STR*/"block.capture.addr"));
  if (isByRef) {
    // addr should be a void** right now.  Load, then cast the result
    // to byref*.
    final /*const*/ BlockByrefInfo /*&*/ byrefInfo = $this().getBlockByrefInfo(variable);
    addr.$assignMove(new Address($this().Builder.CreateLoad(new Address(addr)), new CharUnits(byrefInfo.ByrefAlignment)));
    
    org.llvm.ir.PointerType /*P*/ byrefPointerType = org.llvm.ir.PointerType.get(byrefInfo.Type, 0);
    addr.$assignMove($this().Builder.CreateBitCast(new Address(addr), byrefPointerType, new Twine(/*KEEP_STR*/"byref.addr")));
    
    addr.$assignMove($this().emitBlockByrefAddress(new Address(addr), byrefInfo, /*follow*/ true, 
            new Twine(variable.getName())));
  }
  {
    
    /*const*/ ReferenceType /*P*/ refType = variable.getType().$arrow().getAs(ReferenceType.class);
    if ((refType != null)) {
      addr.$assignMove($this().EmitLoadOfReference(new Address(addr), refType));
    }
  }
  
  return addr;
}


/// BuildBlockByrefAddress - Computes the location of the
/// data in a variable which is declared as __block.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitBlockByrefAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2028,
 FQN="clang::CodeGen::CodeGenFunction::emitBlockByrefAddress", NM="_ZN5clang7CodeGen15CodeGenFunction21emitBlockByrefAddressENS0_7AddressEPKNS_7VarDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21emitBlockByrefAddressENS0_7AddressEPKNS_7VarDeclEb")
//</editor-fold>
public final Address emitBlockByrefAddress(Address baseAddr, 
                     /*const*/ VarDecl /*P*/ var) {
  return emitBlockByrefAddress(baseAddr, 
                     var, 
                     true);
}
public final Address emitBlockByrefAddress(Address baseAddr, 
                     /*const*/ VarDecl /*P*/ var, 
                     boolean followForward/*= true*/) {
  final /*const*/ BlockByrefInfo /*&*/ info = $this().getBlockByrefInfo(var);
  return $this().emitBlockByrefAddress(new Address(baseAddr), info, followForward, new Twine(var.getName()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitBlockByrefAddress">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2035,
 FQN="clang::CodeGen::CodeGenFunction::emitBlockByrefAddress", NM="_ZN5clang7CodeGen15CodeGenFunction21emitBlockByrefAddressENS0_7AddressERKNS0_14BlockByrefInfoEbRKN4llvm5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21emitBlockByrefAddressENS0_7AddressERKNS0_14BlockByrefInfoEbRKN4llvm5TwineE")
//</editor-fold>
public final Address emitBlockByrefAddress(Address baseAddr, 
                     final /*const*/ BlockByrefInfo /*&*/ info, 
                     boolean followForward, 
                     final /*const*/ Twine /*&*/ name) {
  // Chase the forwarding address if requested.
  if (followForward) {
    Address forwardingAddr = $this().Builder.CreateStructGEP(new Address(baseAddr), 1, /*J:ToBase*/super.getPointerSize(), new Twine(/*KEEP_STR*/"forwarding"));
    baseAddr.$assignMove(new Address($this().Builder.CreateLoad(new Address(forwardingAddr)), new CharUnits(info.ByrefAlignment)));
  }
  
  return $this().Builder.CreateStructGEP(new Address(baseAddr), info.FieldIndex, 
      new CharUnits(info.FieldOffset), name);
}


/// BuildByrefInfo - This routine changes a __block variable declared as T x
///   into:
///
///      struct {
///        void *__isa;
///        void *__forwarding;
///        int32_t __flags;
///        int32_t __size;
///        void *__copy_helper;       // only if needed
///        void *__destroy_helper;    // only if needed
///        void *__byref_variable_layout;// only if needed
///        char padding[X];           // only if needed
///        T x;
///      } x
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getBlockByrefInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 2065,
 FQN="clang::CodeGen::CodeGenFunction::getBlockByrefInfo", NM="_ZN5clang7CodeGen15CodeGenFunction17getBlockByrefInfoEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17getBlockByrefInfoEPKNS_7VarDeclE")
//</editor-fold>
public final /*const*/ BlockByrefInfo /*&*/ getBlockByrefInfo(/*const*/ VarDecl /*P*/ D) {
  DenseMapIterator</*const*/ ValueDecl /*P*/ , BlockByrefInfo> it = $this().BlockByrefInfos.find(D);
  if (it.$noteq(/*NO_ITER_COPY*/$this().BlockByrefInfos.end())) {
    return it.$arrow().second;
  }
  
  StructType /*P*/ byrefType = StructType.create($this().getLLVMContext(), 
      new StringRef($add_T$C$P_string(/*KEEP_STR*/"struct.__block_byref_", D.getNameAsString())));
  
  QualType Ty = D.getType();
  
  CharUnits size/*J*/= new CharUnits();
  SmallVector<org.llvm.ir.Type /*P*/ > types/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(8, (org.llvm.ir.Type /*P*/ )null);
  
  // void *__isa;
  types.push_back(Unnamed_field9.Int8PtrTy);
  size.$addassign(/*J:ToBase*/super.getPointerSize());
  
  // void *__forwarding;
  types.push_back(org.llvm.ir.PointerType.getUnqual(byrefType));
  size.$addassign(/*J:ToBase*/super.getPointerSize());
  
  // int32_t __flags;
  types.push_back(Int32Ty);
  size.$addassign(CharUnits.fromQuantity(4));
  
  // int32_t __size;
  types.push_back(Int32Ty);
  size.$addassign(CharUnits.fromQuantity(4));
  
  // Note that this must match *exactly* the logic in buildByrefHelpers.
  boolean hasCopyAndDispose = $this().getContext().BlockRequiresCopying(new QualType(Ty), D);
  if (hasCopyAndDispose) {
    /// void *__copy_helper;
    types.push_back(Unnamed_field9.Int8PtrTy);
    size.$addassign(/*J:ToBase*/super.getPointerSize());
    
    /// void *__destroy_helper;
    types.push_back(Unnamed_field9.Int8PtrTy);
    size.$addassign(/*J:ToBase*/super.getPointerSize());
  }
  
  bool$ref HasByrefExtendedLayout = create_bool$ref(false);
  type$ref<Qualifiers.ObjCLifetime> Lifetime = create_type$ref();
  if ($this().getContext().getByrefLifetime(new QualType(Ty), Lifetime, HasByrefExtendedLayout)
     && HasByrefExtendedLayout.$deref()) {
    /// void *__byref_variable_layout;
    types.push_back(Unnamed_field9.Int8PtrTy);
    size.$addassign(CharUnits.fromQuantity($uchar2long(Unnamed_field13.PointerSizeInBytes)));
  }
  
  // T x;
  org.llvm.ir.Type /*P*/ varTy = $this().ConvertTypeForMem(new QualType(Ty));
  
  boolean packed = false;
  CharUnits varAlign = $this().getContext().getDeclAlign(D);
  CharUnits varOffset = size.alignTo(varAlign);
  
  // We may have to insert padding.
  if (varOffset.$noteq(size)) {
    org.llvm.ir.Type /*P*/ paddingTy = org.llvm.ir.ArrayType.get(Int8Ty, (varOffset.$sub(size)).getQuantity());
    
    types.push_back(paddingTy);
    size.$assign(varOffset);
    // Conversely, we might have to prevent LLVM from inserting padding.
  } else if ($uint2llong($this().CGM.getDataLayout().getABITypeAlignment(varTy))
     > varAlign.getQuantity()) {
    packed = true;
  }
  types.push_back(varTy);
  
  byrefType.setBody(new ArrayRef<org.llvm.ir.Type /*P*/ >(types, true), packed);
  
  BlockByrefInfo info/*J*/= new BlockByrefInfo();
  info.Type = byrefType;
  info.FieldIndex = types.size() - 1;
  info.FieldOffset.$assign(varOffset);
  info.ByrefAlignment.$assign(std.max(varAlign, /*J:ToBase*/super.getPointerAlign()));
  
  std.pairTypeBool<DenseMapIterator</*const*/ ValueDecl /*P*/ , BlockByrefInfo>> pair = $this().BlockByrefInfos.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ ValueDecl /*P*/ , BlockByrefInfo>(JD$T$RR_T1$RR.INSTANCE, D, new BlockByrefInfo(/*Fwd*/info))/* }*/);
  assert (pair.second) : "info was inserted recursively?";
  return pair.first.$arrow().second;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBlockCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 963,
 FQN="clang::CodeGen::CodeGenFunction::EmitBlockCallExpr", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitBlockCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitBlockCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitBlockCallExpr(/*const*/ CallExpr /*P*/ E, 
                 ReturnValueSlot ReturnValue) {
  CallArgList Args = null;
  try {
    /*const*/ BlockPointerType /*P*/ BPT = E.getCallee$Const().getType().$arrow().getAs(BlockPointerType.class);
    
    Value /*P*/ Callee = $this().EmitScalarExpr(E.getCallee$Const());
    
    // Get a pointer to the generic block literal.
    org.llvm.ir.Type /*P*/ BlockLiteralTy = org.llvm.ir.PointerType.getUnqual($this().CGM.getGenericBlockLiteralType());
    
    // Bitcast the callee to a block literal.
    Value /*P*/ BlockLiteral = $this().Builder.CreateBitCast(Callee, BlockLiteralTy, new Twine(/*KEEP_STR*/"block.literal"));
    
    // Get the function pointer from the literal.
    Value /*P*/ FuncPtr = $this().Builder.CreateStructGEP($this().CGM.getGenericBlockLiteralType(), BlockLiteral, 3);
    
    BlockLiteral = $this().Builder.CreateBitCast(BlockLiteral, Unnamed_field9.VoidPtrTy);
    
    // Add the block literal.
    Args/*J*/= new CallArgList();
    Args.add(RValue.get(BlockLiteral), $this().getContext().VoidPtrTy.$QualType());
    
    QualType FnType = BPT.getPointeeType();
    
    // And the rest of the arguments.
    $this().EmitCallArgs(Args, FnType.$arrow().getAs(FunctionProtoType.class), E.arguments$Const());
    
    // Load the function.
    Value /*P*/ Func = $this().Builder.CreateAlignedLoad(FuncPtr, /*J:ToBase*/super.getPointerAlign());
    
    /*const*/ org.clang.ast.FunctionType /*P*/ FuncTy = FnType.$arrow().castAs(org.clang.ast.FunctionType.class);
    final /*const*/ CGFunctionInfo /*&*/ FnInfo = $this().CGM.getTypes().arrangeBlockFunctionCall(Args, FuncTy);
    
    // Cast the function pointer to the right type.
    org.llvm.ir.Type /*P*/ BlockFTy = $this().CGM.getTypes().GetFunctionType(FnInfo);
    
    org.llvm.ir.Type /*P*/ BlockFTyPtr = org.llvm.ir.PointerType.getUnqual(BlockFTy);
    Func = $this().Builder.CreateBitCast(Func, BlockFTyPtr);
    
    // And call the block.
    return $this().EmitCall(FnInfo, Func, new ReturnValueSlot(ReturnValue), Args);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


/// Enter a full-expression with a non-trivial number of objects to
/// clean up.  This is in this file because, at the moment, the only
/// kind of cleanup object is a BlockDecl*.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::enterNonTrivialFullExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 642,
 FQN="clang::CodeGen::CodeGenFunction::enterNonTrivialFullExpression", NM="_ZN5clang7CodeGen15CodeGenFunction29enterNonTrivialFullExpressionEPKNS_16ExprWithCleanupsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29enterNonTrivialFullExpressionEPKNS_16ExprWithCleanupsE")
//</editor-fold>
public final void enterNonTrivialFullExpression(/*const*/ ExprWithCleanups /*P*/ E) {
  assert (E.getNumObjects() != 0);
  ArrayRef<BlockDecl /*P*/ > cleanups = E.getObjects();
  for (type$ptr<BlockDecl /*P*/ /*P*/> i = $tryClone(cleanups.begin()), /*P*/ e = $tryClone(cleanups.end()); $noteq_ptr(i, e); i.$preInc()) {
    CGBlocksStatics.enterBlockScope(/*Deref*/$this(), i.$star());
  }
}


/// Build the copy and dispose helpers for the given __block variable
/// emission.  Places the helpers in the global cache.  Returns null
/// if no helpers are required.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::buildByrefHelpers">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1950,
 FQN="clang::CodeGen::CodeGenFunction::buildByrefHelpers", NM="_ZN5clang7CodeGen15CodeGenFunction17buildByrefHelpersERN4llvm10StructTypeERKNS1_15AutoVarEmissionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17buildByrefHelpersERN4llvm10StructTypeERKNS1_15AutoVarEmissionE")
//</editor-fold>
protected/*private*/ final BlockByrefHelpers /*P*/ buildByrefHelpers(final StructType /*&*/ byrefType, 
                 final /*const*/ AutoVarEmission /*&*/ emission) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    final /*const*/ VarDecl /*&*/ var = $Deref(emission.Variable);
    QualType type = var.getType();
    
    final /*const*/ BlockByrefInfo /*&*/ byrefInfo = $this().getBlockByrefInfo($AddrOf(var));
    
    // The alignment we care about for the purposes of uniquing byref
    // helpers is the alignment of the actual byref value field.
    CharUnits valueAlignment = byrefInfo.ByrefAlignment.alignmentAtOffset(new CharUnits(byrefInfo.FieldOffset));
    {
      
      /*const*/ CXXRecordDecl /*P*/ record = type.$arrow().getAsCXXRecordDecl();
      if ((record != null)) {
        /*const*/ Expr /*P*/ copyExpr = $this().CGM.getContext().getBlockVarCopyInits($AddrOf(var));
        if (!(copyExpr != null) && record.hasTrivialDestructor()) {
          return null;
        }
        
        return $c$.clean(/*::*/CGBlocksStatics.buildByrefHelpers$T($this().CGM, byrefInfo, $c$.track(new CXXByrefHelpers(new CharUnits(valueAlignment), new QualType(type), copyExpr)), CXXByrefHelpers::$factory));
      }
    }
    
    // Otherwise, if we don't have a retainable type, there's nothing to do.
    // that the runtime does extra copies.
    if (!type.$arrow().isObjCRetainableType()) {
      return null;
    }
    
    Qualifiers qs = type.getQualifiers();
    {
      
      // If we have lifetime, that dominates.
      Qualifiers.ObjCLifetime lifetime = qs.getObjCLifetime();
      if ((lifetime.getValue() != 0)) {
        switch (lifetime) {
         case OCL_None:
          throw new llvm_unreachable("impossible");
         case OCL_ExplicitNone:
         case OCL_Autoreleasing:
          
          // These are just bits as far as the runtime is concerned.
          return null;
         case OCL_Weak:
          
          // Tell the runtime that this is ARC __weak, called by the
          // byref routines.
          return $c$.clean(/*::*/CGBlocksStatics.buildByrefHelpers$T($this().CGM, byrefInfo, 
              $c$.track(new ARCWeakByrefHelpers(new CharUnits(valueAlignment))), ARCWeakByrefHelpers::$factory));
         case OCL_Strong:
          // Block pointers need to be copied, and there's no direct
          // transfer possible.
          if (type.$arrow().isBlockPointerType()) {
            return $c$.clean(/*::*/CGBlocksStatics.buildByrefHelpers$T($this().CGM, byrefInfo, 
                $c$.track(new ARCStrongBlockByrefHelpers(new CharUnits(valueAlignment))), ARCStrongBlockByrefHelpers::$factory));
            // Otherwise, we transfer ownership of the retain from the stack
            // to the heap.
          } else {
            return $c$.clean(/*::*/CGBlocksStatics.buildByrefHelpers$T($this().CGM, byrefInfo, 
                $c$.track(new ARCStrongByrefHelpers(new CharUnits(valueAlignment))), ARCStrongByrefHelpers::$factory));
          }
        }
        throw new llvm_unreachable("fell out of lifetime switch!");
      }
    }
    
    BlockFieldFlags flags/*J*/= new BlockFieldFlags();
    if (type.$arrow().isBlockPointerType()) {
      BlockFieldFlags.$orassign_BlockFieldFlags(flags, new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_BLOCK));
    } else if ($this().CGM.getContext().isObjCNSObjectType(new QualType(type))
       || type.$arrow().isObjCObjectPointerType()) {
      BlockFieldFlags.$orassign_BlockFieldFlags(flags, new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_OBJECT));
    } else {
      return null;
    }
    if (type.isObjCGCWeak()) {
      BlockFieldFlags.$orassign_BlockFieldFlags(flags, new BlockFieldFlags(BlockFieldFlag_t.BLOCK_FIELD_IS_WEAK));
    }
    
    return $c$.clean(/*::*/CGBlocksStatics.buildByrefHelpers$T($this().CGM, byrefInfo, 
        $c$.track(new ObjectByrefHelpers(new CharUnits(valueAlignment), new BlockFieldFlags(flags))), ObjectByrefHelpers::$factory));
  } finally {
    $c$.$destroy();
  }
}

} // END OF class CodeGenFunction_CGBlocks
