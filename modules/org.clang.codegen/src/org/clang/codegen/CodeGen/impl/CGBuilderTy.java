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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.clang.ast.CharUnitsGlobals.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 45,
 FQN="clang::CodeGen::CGBuilderTy", NM="_ZN5clang7CodeGen11CGBuilderTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTyE")
//</editor-fold>
public class CGBuilderTy extends /*public*/ IRBuilder<ConstantFolder, CGBuilderInserter> implements Destructors.ClassWithDestructor {
  /// Storing a reference to the type cache here makes it a lot easier
  /// to build natural-feeling, target-specific IR.
  private final /*const*/ CodeGenTypeCache /*&*/ TypeCache;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CGBuilderTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 50,
   FQN="clang::CodeGen::CGBuilderTy::CGBuilderTy", NM="_ZN5clang7CodeGen11CGBuilderTyC1ERKNS0_16CodeGenTypeCacheERN4llvm11LLVMContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTyC1ERKNS0_16CodeGenTypeCacheERN4llvm11LLVMContextE")
  //</editor-fold>
  public CGBuilderTy(final /*const*/ CodeGenTypeCache /*&*/ TypeCache, final LLVMContext /*&*/ C) {
    // : CGBuilderBaseTy(C), TypeCache(TypeCache) 
    //START JInit
    /*ExprWithCleanups*/super(C);
    this./*&*/TypeCache=/*&*/TypeCache;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CGBuilderTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 52,
   FQN="clang::CodeGen::CGBuilderTy::CGBuilderTy", NM="_ZN5clang7CodeGen11CGBuilderTyC1ERKNS0_16CodeGenTypeCacheERN4llvm11LLVMContextERKNS5_14ConstantFolderERKNS0_17CGBuilderInserterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTyC1ERKNS0_16CodeGenTypeCacheERN4llvm11LLVMContextERKNS5_14ConstantFolderERKNS0_17CGBuilderInserterE")
  //</editor-fold>
  public CGBuilderTy(final /*const*/ CodeGenTypeCache /*&*/ TypeCache, 
      final LLVMContext /*&*/ C, final /*const*/ ConstantFolder /*&*/ F, 
      final /*const*/ CGBuilderInserter /*&*/ Inserter) {
    // : CGBuilderBaseTy(C, F, Inserter), TypeCache(TypeCache) 
    //START JInit
    /*ExprWithCleanups*/super(JD$LLVMContext_T$C$R_T1_MDNode$P_ArrayRef$OperandBundleDefT$P.INSTANCE, C, F, new CGBuilderInserter(Inserter));
    this./*&*/TypeCache=/*&*/TypeCache;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CGBuilderTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 56,
   FQN="clang::CodeGen::CGBuilderTy::CGBuilderTy", NM="_ZN5clang7CodeGen11CGBuilderTyC1ERKNS0_16CodeGenTypeCacheEPN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTyC1ERKNS0_16CodeGenTypeCacheEPN4llvm11InstructionE")
  //</editor-fold>
  public CGBuilderTy(final /*const*/ CodeGenTypeCache /*&*/ TypeCache, Instruction /*P*/ I) {
    // : CGBuilderBaseTy(I), TypeCache(TypeCache) 
    //START JInit
    /*ExprWithCleanups*/super(I);
    this./*&*/TypeCache=/*&*/TypeCache;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CGBuilderTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 58,
   FQN="clang::CodeGen::CGBuilderTy::CGBuilderTy", NM="_ZN5clang7CodeGen11CGBuilderTyC1ERKNS0_16CodeGenTypeCacheEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTyC1ERKNS0_16CodeGenTypeCacheEPN4llvm10BasicBlockE")
  //</editor-fold>
  public CGBuilderTy(final /*const*/ CodeGenTypeCache /*&*/ TypeCache, BasicBlock /*P*/ BB) {
    // : CGBuilderBaseTy(BB), TypeCache(TypeCache) 
    //START JInit
    /*ExprWithCleanups*/super(BB);
    this./*&*/TypeCache=/*&*/TypeCache;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 61,
   FQN="clang::CodeGen::CGBuilderTy::getSize", NM="_ZN5clang7CodeGen11CGBuilderTy7getSizeENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy7getSizeENS_9CharUnitsE")
  //</editor-fold>
  public ConstantInt /*P*/ getSize(CharUnits N) {
    return ConstantInt.get(TypeCache.Unnamed_field8.SizeTy, N.getQuantity());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::getSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 64,
   FQN="clang::CodeGen::CGBuilderTy::getSize", NM="_ZN5clang7CodeGen11CGBuilderTy7getSizeEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy7getSizeEy")
  //</editor-fold>
  public ConstantInt /*P*/ getSize(long/*uint64_t*/ N) {
    return ConstantInt.get(TypeCache.Unnamed_field8.SizeTy, N);
  }

  
  // Note that we intentionally hide the CreateLoad APIs that don't
  // take an alignment.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 70,
   FQN="clang::CodeGen::CGBuilderTy::CreateLoad", NM="_ZN5clang7CodeGen11CGBuilderTy10CreateLoadENS0_7AddressERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy10CreateLoadENS0_7AddressERKN4llvm5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateLoad(Address Addr) {
    return CreateLoad(Addr, new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateLoad(Address Addr, final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAlignedLoad(Addr.getPointer(), 
        $long2uint(Addr.getAlignment().getQuantity()), 
        Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 75,
   FQN="clang::CodeGen::CGBuilderTy::CreateLoad", NM="_ZN5clang7CodeGen11CGBuilderTy10CreateLoadENS0_7AddressEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy10CreateLoadENS0_7AddressEPKc")
  //</editor-fold>
  public LoadInst /*P*/ CreateLoad(Address Addr, /*const*/char$ptr/*char P*/ Name) {
    // This overload is required to prevent string literals from
    // ending up in the IsVolatile overload.
    return CreateAlignedLoad(Addr.getPointer(), 
        $long2uint(Addr.getAlignment().getQuantity()), 
        Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 82,
   FQN="clang::CodeGen::CGBuilderTy::CreateLoad", NM="_ZN5clang7CodeGen11CGBuilderTy10CreateLoadENS0_7AddressEbRKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy10CreateLoadENS0_7AddressEbRKN4llvm5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateLoad(Address Addr, boolean IsVolatile) {
    return CreateLoad(Addr, IsVolatile, 
            new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateLoad(Address Addr, boolean IsVolatile, 
            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAlignedLoad(Addr.getPointer(), 
        $long2uint(Addr.getAlignment().getQuantity()), 
        IsVolatile, 
        Name);
  }

  
  //JAVA: using IRBuilder<ConstantFolder, CGBuilderInserter>::CreateAlignedLoad;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 91,
   FQN="clang::CodeGen::CGBuilderTy::CreateAlignedLoad", NM="_ZN5clang7CodeGen11CGBuilderTy17CreateAlignedLoadEPN4llvm5ValueENS_9CharUnitsERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy17CreateAlignedLoadEPN4llvm5ValueENS_9CharUnitsERKNS2_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Addr, CharUnits Align) {
    return CreateAlignedLoad(Addr, Align, 
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Addr, CharUnits Align, 
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAlignedLoad(Addr, $long2uint(Align.getQuantity()), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 95,
   FQN="clang::CodeGen::CGBuilderTy::CreateAlignedLoad", NM="_ZN5clang7CodeGen11CGBuilderTy17CreateAlignedLoadEPN4llvm5ValueENS_9CharUnitsEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy17CreateAlignedLoadEPN4llvm5ValueENS_9CharUnitsEPKc")
  //</editor-fold>
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Addr, CharUnits Align, 
                   /*const*/char$ptr/*char P*/ Name) {
    return CreateAlignedLoad(Addr, $long2uint(Align.getQuantity()), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 99,
   FQN="clang::CodeGen::CGBuilderTy::CreateAlignedLoad", NM="_ZN5clang7CodeGen11CGBuilderTy17CreateAlignedLoadEPN4llvm4TypeEPNS2_5ValueENS_9CharUnitsERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy17CreateAlignedLoadEPN4llvm4TypeEPNS2_5ValueENS_9CharUnitsERKNS2_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateAlignedLoad(Type /*P*/ Ty, Value /*P*/ Addr, 
                   CharUnits Align) {
    return CreateAlignedLoad(Ty, Addr, 
                   Align, 
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateAlignedLoad(Type /*P*/ Ty, Value /*P*/ Addr, 
                   CharUnits Align, 
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (Addr.getType().getPointerElementType() == Ty);
    return CreateAlignedLoad(Addr, $long2uint(Align.getQuantity()), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 105,
   FQN="clang::CodeGen::CGBuilderTy::CreateAlignedLoad", NM="_ZN5clang7CodeGen11CGBuilderTy17CreateAlignedLoadEPN4llvm5ValueENS_9CharUnitsEbRKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy17CreateAlignedLoadEPN4llvm5ValueENS_9CharUnitsEbRKNS2_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Addr, CharUnits Align, 
                   boolean IsVolatile) {
    return CreateAlignedLoad(Addr, Align, 
                   IsVolatile, 
                   new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateAlignedLoad(Value /*P*/ Addr, CharUnits Align, 
                   boolean IsVolatile, 
                   final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return CreateAlignedLoad(Addr, $long2uint(Align.getQuantity()), IsVolatile, Name);
  }

  
  // Note that we intentionally hide the CreateStore APIs that don't
  // take an alignment.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 113,
   FQN="clang::CodeGen::CGBuilderTy::CreateStore", NM="_ZN5clang7CodeGen11CGBuilderTy11CreateStoreEPN4llvm5ValueENS0_7AddressEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy11CreateStoreEPN4llvm5ValueENS0_7AddressEb")
  //</editor-fold>
  public StoreInst /*P*/ CreateStore(Value /*P*/ Val, Address Addr) {
    return CreateStore(Val, Addr, 
             false);
  }
  public StoreInst /*P*/ CreateStore(Value /*P*/ Val, Address Addr, 
             boolean IsVolatile/*= false*/) {
    return CreateAlignedStore(Val, Addr.getPointer(), 
        $long2uint(Addr.getAlignment().getQuantity()), IsVolatile);
  }

  
  //JAVA: using IRBuilder<ConstantFolder, CGBuilderInserter>::CreateAlignedStore;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateAlignedStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 120,
   FQN="clang::CodeGen::CGBuilderTy::CreateAlignedStore", NM="_ZN5clang7CodeGen11CGBuilderTy18CreateAlignedStoreEPN4llvm5ValueES4_NS_9CharUnitsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy18CreateAlignedStoreEPN4llvm5ValueES4_NS_9CharUnitsEb")
  //</editor-fold>
  public StoreInst /*P*/ CreateAlignedStore(Value /*P*/ Val, Value /*P*/ Addr, 
                    CharUnits Align) {
    return CreateAlignedStore(Val, Addr, 
                    Align, false);
  }
  public StoreInst /*P*/ CreateAlignedStore(Value /*P*/ Val, Value /*P*/ Addr, 
                    CharUnits Align, boolean IsVolatile/*= false*/) {
    return CreateAlignedStore(Val, Addr, $long2uint(Align.getQuantity()), IsVolatile);
  }

  
  // FIXME: these "default-aligned" APIs should be removed,
  // but I don't feel like fixing all the builtin code right now.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateDefaultAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 127,
   FQN="clang::CodeGen::CGBuilderTy::CreateDefaultAlignedLoad", NM="_ZN5clang7CodeGen11CGBuilderTy24CreateDefaultAlignedLoadEPN4llvm5ValueERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy24CreateDefaultAlignedLoadEPN4llvm5ValueERKNS2_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateDefaultAlignedLoad(Value /*P*/ Addr) {
    return CreateDefaultAlignedLoad(Addr, 
                          new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateDefaultAlignedLoad(Value /*P*/ Addr, 
                          final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return super.CreateLoad(Addr, false, Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateDefaultAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 131,
   FQN="clang::CodeGen::CGBuilderTy::CreateDefaultAlignedLoad", NM="_ZN5clang7CodeGen11CGBuilderTy24CreateDefaultAlignedLoadEPN4llvm5ValueEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy24CreateDefaultAlignedLoadEPN4llvm5ValueEPKc")
  //</editor-fold>
  public LoadInst /*P*/ CreateDefaultAlignedLoad(Value /*P*/ Addr, 
                          /*const*/char$ptr/*char P*/ Name) {
    return super.CreateLoad(Addr, false, new Twine(Name));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateDefaultAlignedLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 135,
   FQN="clang::CodeGen::CGBuilderTy::CreateDefaultAlignedLoad", NM="_ZN5clang7CodeGen11CGBuilderTy24CreateDefaultAlignedLoadEPN4llvm5ValueEbRKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy24CreateDefaultAlignedLoadEPN4llvm5ValueEbRKNS2_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateDefaultAlignedLoad(Value /*P*/ Addr, boolean IsVolatile) {
    return CreateDefaultAlignedLoad(Addr, IsVolatile, 
                          new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateDefaultAlignedLoad(Value /*P*/ Addr, boolean IsVolatile, 
                          final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return super.CreateLoad(Addr, IsVolatile, Name);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateDefaultAlignedStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 140,
   FQN="clang::CodeGen::CGBuilderTy::CreateDefaultAlignedStore", NM="_ZN5clang7CodeGen11CGBuilderTy25CreateDefaultAlignedStoreEPN4llvm5ValueES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy25CreateDefaultAlignedStoreEPN4llvm5ValueES4_b")
  //</editor-fold>
  public StoreInst /*P*/ CreateDefaultAlignedStore(Value /*P*/ Val, 
                           Value /*P*/ Addr) {
    return CreateDefaultAlignedStore(Val, 
                           Addr, 
                           false);
  }
  public StoreInst /*P*/ CreateDefaultAlignedStore(Value /*P*/ Val, 
                           Value /*P*/ Addr, 
                           boolean IsVolatile/*= false*/) {
    return super.CreateStore(Val, Addr, IsVolatile);
  }

  
  /// Emit a load from an i1 flag variable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateFlagLoad">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 147,
   FQN="clang::CodeGen::CGBuilderTy::CreateFlagLoad", NM="_ZN5clang7CodeGen11CGBuilderTy14CreateFlagLoadEPN4llvm5ValueERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy14CreateFlagLoadEPN4llvm5ValueERKNS2_5TwineE")
  //</editor-fold>
  public LoadInst /*P*/ CreateFlagLoad(Value /*P*/ Addr) {
    return CreateFlagLoad(Addr, 
                new Twine(/*KEEP_STR*/$EMPTY));
  }
  public LoadInst /*P*/ CreateFlagLoad(Value /*P*/ Addr, 
                final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (Addr.getType().getPointerElementType() == getInt1Ty());
    return CreateAlignedLoad(getInt1Ty(), Addr, CharUnits.One(), Name);
  }

  
  /// Emit a store to an i1 flag variable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateFlagStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 154,
   FQN="clang::CodeGen::CGBuilderTy::CreateFlagStore", NM="_ZN5clang7CodeGen11CGBuilderTy15CreateFlagStoreEbPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy15CreateFlagStoreEbPN4llvm5ValueE")
  //</editor-fold>
  public StoreInst /*P*/ CreateFlagStore(boolean Value, Value /*P*/ Addr) {
    assert (Addr.getType().getPointerElementType() == getInt1Ty());
    return CreateAlignedStore(getInt1(Value), Addr, CharUnits.One());
  }

  
  //JAVA: using IRBuilder<ConstantFolder, CGBuilderInserter>::CreateBitCast;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 160,
   FQN="clang::CodeGen::CGBuilderTy::CreateBitCast", NM="_ZN5clang7CodeGen11CGBuilderTy13CreateBitCastENS0_7AddressEPN4llvm4TypeERKNS3_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy13CreateBitCastENS0_7AddressEPN4llvm4TypeERKNS3_5TwineE")
  //</editor-fold>
  public Address CreateBitCast(Address Addr, Type /*P*/ Ty) {
    return CreateBitCast(Addr, Ty, 
               new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateBitCast(Address Addr, Type /*P*/ Ty, 
               final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return new Address(CreateBitCast(Addr.getPointer(), Ty, Name), 
        Addr.getAlignment());
  }

  
  /// Cast the element type of the given address to a different type,
  /// preserving information like the alignment and address space.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateElementBitCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 168,
   FQN="clang::CodeGen::CGBuilderTy::CreateElementBitCast", NM="_ZN5clang7CodeGen11CGBuilderTy20CreateElementBitCastENS0_7AddressEPN4llvm4TypeERKNS3_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy20CreateElementBitCastENS0_7AddressEPN4llvm4TypeERKNS3_5TwineE")
  //</editor-fold>
  public Address CreateElementBitCast(Address Addr, Type /*P*/ Ty) {
    return CreateElementBitCast(Addr, Ty, 
                      new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateElementBitCast(Address Addr, Type /*P*/ Ty, 
                      final /*const*/ Twine /*&*/ Name/*= ""*/) {
    PointerType /*P*/ PtrTy = Ty.getPointerTo(Addr.getAddressSpace());
    return CreateBitCast(new Address(Addr), PtrTy, Name);
  }

  
  //JAVA: using IRBuilder<ConstantFolder, CGBuilderInserter>::CreatePointerBitCastOrAddrSpaceCast;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreatePointerBitCastOrAddrSpaceCast">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 175,
   FQN="clang::CodeGen::CGBuilderTy::CreatePointerBitCastOrAddrSpaceCast", NM="_ZN5clang7CodeGen11CGBuilderTy35CreatePointerBitCastOrAddrSpaceCastENS0_7AddressEPN4llvm4TypeERKNS3_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy35CreatePointerBitCastOrAddrSpaceCastENS0_7AddressEPN4llvm4TypeERKNS3_5TwineE")
  //</editor-fold>
  public Address CreatePointerBitCastOrAddrSpaceCast(Address Addr, Type /*P*/ Ty) {
    return CreatePointerBitCastOrAddrSpaceCast(Addr, Ty, 
                                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreatePointerBitCastOrAddrSpaceCast(Address Addr, Type /*P*/ Ty, 
                                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    Value /*P*/ Ptr = CreatePointerBitCastOrAddrSpaceCast(Addr.getPointer(), Ty, Name);
    return new Address(Ptr, Addr.getAlignment());
  }

  
  //JAVA: using IRBuilder<ConstantFolder, CGBuilderInserter>::CreateStructGEP;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateStructGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 183,
   FQN="clang::CodeGen::CGBuilderTy::CreateStructGEP", NM="_ZN5clang7CodeGen11CGBuilderTy15CreateStructGEPENS0_7AddressEjNS_9CharUnitsERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy15CreateStructGEPENS0_7AddressEjNS_9CharUnitsERKN4llvm5TwineE")
  //</editor-fold>
  public Address CreateStructGEP(Address Addr, /*uint*/int Index, CharUnits Offset) {
    return CreateStructGEP(Addr, Index, Offset, 
                 new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateStructGEP(Address Addr, /*uint*/int Index, CharUnits Offset, 
                 final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return new Address(CreateStructGEP(Addr.getElementType(), 
            Addr.getPointer(), Index, Name), 
        Addr.getAlignment().alignmentAtOffset(new CharUnits(Offset)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateStructGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 189,
   FQN="clang::CodeGen::CGBuilderTy::CreateStructGEP", NM="_ZN5clang7CodeGen11CGBuilderTy15CreateStructGEPENS0_7AddressEjPKN4llvm12StructLayoutERKNS3_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy15CreateStructGEPENS0_7AddressEjPKN4llvm12StructLayoutERKNS3_5TwineE")
  //</editor-fold>
  public Address CreateStructGEP(Address Addr, /*uint*/int Index, 
                 /*const*/ StructLayout /*P*/ Layout) {
    return CreateStructGEP(Addr, Index, 
                 Layout, 
                 new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateStructGEP(Address Addr, /*uint*/int Index, 
                 /*const*/ StructLayout /*P*/ Layout, 
                 final /*const*/ Twine /*&*/ Name/*= ""*/) {
    CharUnits Offset = CharUnits.fromQuantity(Layout.getElementOffset(Index));
    return CreateStructGEP(new Address(Addr), Index, new CharUnits(Offset), Name);
  }

  
  /// Given
  ///   %addr = [n x T]* ...
  /// produce
  ///   %name = getelementptr inbounds %addr, i64 0, i64 index
  /// where i64 is actually the target word size.
  ///
  /// This API assumes that drilling into an array like this is always
  /// an inbounds operation.
  ///
  /// \param EltSize - the size of the type T in bytes
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateConstArrayGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 206,
   FQN="clang::CodeGen::CGBuilderTy::CreateConstArrayGEP", NM="_ZN5clang7CodeGen11CGBuilderTy19CreateConstArrayGEPENS0_7AddressEyNS_9CharUnitsERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy19CreateConstArrayGEPENS0_7AddressEyNS_9CharUnitsERKN4llvm5TwineE")
  //</editor-fold>
  public Address CreateConstArrayGEP(Address Addr, long/*uint64_t*/ Index, CharUnits EltSize) {
    return CreateConstArrayGEP(Addr, Index, EltSize, 
                     new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateConstArrayGEP(Address Addr, long/*uint64_t*/ Index, CharUnits EltSize, 
                     final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return new Address(CreateInBoundsGEP(Addr.getPointer(), 
            /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {
                  getSize(CharUnits.Zero()), 
                  getSize(Index)}, true)/* }*/, 
            Name), 
        Addr.getAlignment().alignmentAtOffset($star_long_CharUnits$C(Index, EltSize)));
  }

  
  /// Given
  ///   %addr = T* ...
  /// produce
  ///   %name = getelementptr inbounds %addr, i64 index
  /// where i64 is actually the target word size.
  ///
  /// \param EltSize - the size of the type T in bytes
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateConstInBoundsGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 222,
   FQN="clang::CodeGen::CGBuilderTy::CreateConstInBoundsGEP", NM="_ZN5clang7CodeGen11CGBuilderTy22CreateConstInBoundsGEPENS0_7AddressEyNS_9CharUnitsERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy22CreateConstInBoundsGEPENS0_7AddressEyNS_9CharUnitsERKN4llvm5TwineE")
  //</editor-fold>
  public Address CreateConstInBoundsGEP(Address Addr, long/*uint64_t*/ Index, 
                        CharUnits EltSize) {
    return CreateConstInBoundsGEP(Addr, Index, 
                        EltSize, 
                        new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateConstInBoundsGEP(Address Addr, long/*uint64_t*/ Index, 
                        CharUnits EltSize, 
                        final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return new Address(CreateInBoundsGEP(Addr.getElementType(), Addr.getPointer(), 
            getSize(Index), Name), 
        Addr.getAlignment().alignmentAtOffset($star_long_CharUnits$C(Index, EltSize)));
  }

  
  /// Given
  ///   %addr = T* ...
  /// produce
  ///   %name = getelementptr inbounds %addr, i64 index
  /// where i64 is actually the target word size.
  ///
  /// \param EltSize - the size of the type T in bytes
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateConstGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 237,
   FQN="clang::CodeGen::CGBuilderTy::CreateConstGEP", NM="_ZN5clang7CodeGen11CGBuilderTy14CreateConstGEPENS0_7AddressEyNS_9CharUnitsERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy14CreateConstGEPENS0_7AddressEyNS_9CharUnitsERKN4llvm5TwineE")
  //</editor-fold>
  public Address CreateConstGEP(Address Addr, long/*uint64_t*/ Index, CharUnits EltSize) {
    return CreateConstGEP(Addr, Index, EltSize, 
                new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateConstGEP(Address Addr, long/*uint64_t*/ Index, CharUnits EltSize, 
                final /*const*/ Twine /*&*/ Name/*= ""*/) {
    return new Address(CreateGEP(Addr.getElementType(), Addr.getPointer(), 
            getSize(Index), Name), 
        Addr.getAlignment().alignmentAtOffset($star_long_CharUnits$C(Index, EltSize)));
  }

  
  /// Given a pointer to i8, adjust it by a given constant offset.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateConstInBoundsByteGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 245,
   FQN="clang::CodeGen::CGBuilderTy::CreateConstInBoundsByteGEP", NM="_ZN5clang7CodeGen11CGBuilderTy26CreateConstInBoundsByteGEPENS0_7AddressENS_9CharUnitsERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy26CreateConstInBoundsByteGEPENS0_7AddressENS_9CharUnitsERKN4llvm5TwineE")
  //</editor-fold>
  public Address CreateConstInBoundsByteGEP(Address Addr, CharUnits Offset) {
    return CreateConstInBoundsByteGEP(Addr, Offset, 
                            new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateConstInBoundsByteGEP(Address Addr, CharUnits Offset, 
                            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (Addr.getElementType() == TypeCache.Int8Ty);
    return new Address(CreateInBoundsGEP(Addr.getPointer(), new ArrayRef<Value /*P*/ >(getSize(new CharUnits(Offset)), true), Name), 
        Addr.getAlignment().alignmentAtOffset(new CharUnits(Offset)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateConstByteGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 251,
   FQN="clang::CodeGen::CGBuilderTy::CreateConstByteGEP", NM="_ZN5clang7CodeGen11CGBuilderTy18CreateConstByteGEPENS0_7AddressENS_9CharUnitsERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy18CreateConstByteGEPENS0_7AddressENS_9CharUnitsERKN4llvm5TwineE")
  //</editor-fold>
  public Address CreateConstByteGEP(Address Addr, CharUnits Offset) {
    return CreateConstByteGEP(Addr, Offset, 
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Address CreateConstByteGEP(Address Addr, CharUnits Offset, 
                    final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (Addr.getElementType() == TypeCache.Int8Ty);
    return new Address(CreateGEP(Addr.getPointer(), getSize(new CharUnits(Offset)), Name), 
        Addr.getAlignment().alignmentAtOffset(new CharUnits(Offset)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateConstInBoundsByteGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 258,
   FQN="clang::CodeGen::CGBuilderTy::CreateConstInBoundsByteGEP", NM="_ZN5clang7CodeGen11CGBuilderTy26CreateConstInBoundsByteGEPEPN4llvm5ValueENS_9CharUnitsERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy26CreateConstInBoundsByteGEPEPN4llvm5ValueENS_9CharUnitsERKNS2_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstInBoundsByteGEP(Value /*P*/ Ptr, CharUnits Offset) {
    return CreateConstInBoundsByteGEP(Ptr, Offset, 
                            new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstInBoundsByteGEP(Value /*P*/ Ptr, CharUnits Offset, 
                            final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (Ptr.getType().getPointerElementType() == TypeCache.Int8Ty);
    return CreateInBoundsGEP(Ptr, new ArrayRef<Value /*P*/ >(getSize(new CharUnits(Offset)), true), Name);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateConstByteGEP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 263,
   FQN="clang::CodeGen::CGBuilderTy::CreateConstByteGEP", NM="_ZN5clang7CodeGen11CGBuilderTy18CreateConstByteGEPEPN4llvm5ValueENS_9CharUnitsERKNS2_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy18CreateConstByteGEPEPN4llvm5ValueENS_9CharUnitsERKNS2_5TwineE")
  //</editor-fold>
  public Value /*P*/ CreateConstByteGEP(Value /*P*/ Ptr, CharUnits Offset) {
    return CreateConstByteGEP(Ptr, Offset, 
                    new Twine(/*KEEP_STR*/$EMPTY));
  }
  public Value /*P*/ CreateConstByteGEP(Value /*P*/ Ptr, CharUnits Offset, 
                    final /*const*/ Twine /*&*/ Name/*= ""*/) {
    assert (Ptr.getType().getPointerElementType() == TypeCache.Int8Ty);
    return CreateGEP(Ptr, getSize(new CharUnits(Offset)), Name);
  }

  
  //JAVA: using IRBuilder<ConstantFolder, CGBuilderInserter>::CreateMemCpy;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateMemCpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 270,
   FQN="clang::CodeGen::CGBuilderTy::CreateMemCpy", NM="_ZN5clang7CodeGen11CGBuilderTy12CreateMemCpyENS0_7AddressES2_PN4llvm5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy12CreateMemCpyENS0_7AddressES2_PN4llvm5ValueEb")
  //</editor-fold>
  public CallInst /*P*/ CreateMemCpy(Address Dest, Address Src, Value /*P*/ Size) {
    return CreateMemCpy(Dest, Src, Size, 
              false);
  }
  public CallInst /*P*/ CreateMemCpy(Address Dest, Address Src, Value /*P*/ Size, 
              boolean IsVolatile/*= false*/) {
    CharUnits Align = new CharUnits(std.min(Dest.getAlignment(), Src.getAlignment()));
    return CreateMemCpy(Dest.getPointer(), Src.getPointer(), Size, 
        $long2uint(Align.getQuantity()), IsVolatile);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateMemCpy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 276,
   FQN="clang::CodeGen::CGBuilderTy::CreateMemCpy", NM="_ZN5clang7CodeGen11CGBuilderTy12CreateMemCpyENS0_7AddressES2_yb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy12CreateMemCpyENS0_7AddressES2_yb")
  //</editor-fold>
  public CallInst /*P*/ CreateMemCpy(Address Dest, Address Src, long/*uint64_t*/ Size) {
    return CreateMemCpy(Dest, Src, Size, 
              false);
  }
  public CallInst /*P*/ CreateMemCpy(Address Dest, Address Src, long/*uint64_t*/ Size, 
              boolean IsVolatile/*= false*/) {
    CharUnits Align = new CharUnits(std.min(Dest.getAlignment(), Src.getAlignment()));
    return CreateMemCpy(Dest.getPointer(), Src.getPointer(), Size, 
        $long2uint(Align.getQuantity()), IsVolatile);
  }

  
  //JAVA: using IRBuilder<ConstantFolder, CGBuilderInserter>::CreateMemMove;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateMemMove">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 284,
   FQN="clang::CodeGen::CGBuilderTy::CreateMemMove", NM="_ZN5clang7CodeGen11CGBuilderTy13CreateMemMoveENS0_7AddressES2_PN4llvm5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy13CreateMemMoveENS0_7AddressES2_PN4llvm5ValueEb")
  //</editor-fold>
  public CallInst /*P*/ CreateMemMove(Address Dest, Address Src, Value /*P*/ Size) {
    return CreateMemMove(Dest, Src, Size, 
               false);
  }
  public CallInst /*P*/ CreateMemMove(Address Dest, Address Src, Value /*P*/ Size, 
               boolean IsVolatile/*= false*/) {
    CharUnits Align = new CharUnits(std.min(Dest.getAlignment(), Src.getAlignment()));
    return CreateMemMove(Dest.getPointer(), Src.getPointer(), Size, 
        $long2uint(Align.getQuantity()), IsVolatile);
  }

  
  //JAVA: using IRBuilder<ConstantFolder, CGBuilderInserter>::CreateMemSet;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::CreateMemSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 292,
   FQN="clang::CodeGen::CGBuilderTy::CreateMemSet", NM="_ZN5clang7CodeGen11CGBuilderTy12CreateMemSetENS0_7AddressEPN4llvm5ValueES5_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTy12CreateMemSetENS0_7AddressEPN4llvm5ValueES5_b")
  //</editor-fold>
  public CallInst /*P*/ CreateMemSet(Address Dest, Value /*P*/ $Value, 
              Value /*P*/ Size) {
    return CreateMemSet(Dest, $Value, 
              Size, false);
  }
  public CallInst /*P*/ CreateMemSet(Address Dest, Value /*P*/ $Value, 
              Value /*P*/ Size, boolean IsVolatile/*= false*/) {
    return CreateMemSet(Dest.getPointer(), $Value, Size, 
        $long2uint(Dest.getAlignment().getQuantity()), IsVolatile);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGBuilderTy::~CGBuilderTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBuilder.h", line = 45,
   FQN="clang::CodeGen::CGBuilderTy::~CGBuilderTy", NM="_ZN5clang7CodeGen11CGBuilderTyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen11CGBuilderTyD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "TypeCache=" + TypeCache // NOI18N
              + super.toString(); // NOI18N
  }
}
