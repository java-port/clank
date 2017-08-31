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

import org.clang.ast.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;


/// This structure provides a set of types that are commonly used
/// during IR emission.  It's initialized once in CodeGenModule's
/// constructor and then copied around into new CodeGenFunctions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 32,
 FQN="clang::CodeGen::CodeGenTypeCache", NM="_ZN5clang7CodeGen16CodeGenTypeCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheE")
//</editor-fold>
public class/*struct*/ CodeGenTypeCache {
  /// void
  public Type /*P*/ VoidTy;
  
  /// i8, i16, i32, and i64
  public IntegerType /*P*/ Int8Ty;
  public IntegerType /*P*/ Int16Ty;
  public IntegerType /*P*/ Int32Ty;
  public IntegerType /*P*/ Int64Ty;
  /// float, double
  public Type /*P*/ FloatTy;
  public Type /*P*/ DoubleTy;
  
  /// int
  public IntegerType /*P*/ IntTy;
  
  /// intptr_t, size_t, and ptrdiff_t, which we assume are the same size.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 45,
   FQN="clang::CodeGen::CodeGenTypeCache::(anonymous)", NM="_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union1")
  //</editor-fold>
  public static class/*union*/ Unnamed_union1 {
    public IntegerType /*P*/ IntPtrTy;
    public IntegerType /*P*/ SizeTy;
    public IntegerType /*P*/ PtrDiffTy;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 45,
     FQN="clang::CodeGen::CodeGenTypeCache::(anonymous union)::", NM="_ZN5clang7CodeGen16CodeGenTypeCacheUt_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheUt_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
      $assign($Prm0.IntPtrTy);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private Unnamed_union1() {}

    // all fields in union are of the same type just differently named
    final void $assign(IntegerType /*P*/ Ty) {
      IntPtrTy = SizeTy = PtrDiffTy = Ty;
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "IntPtrTy=" + IntPtrTy // NOI18N
                + ", SizeTy=" + SizeTy // NOI18N
                + ", PtrDiffTy=" + PtrDiffTy; // NOI18N
    }

  };
  public Unnamed_union1 Unnamed_field8 = new Unnamed_union1();
  
  /// void* in address space 0
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 52,
   FQN="clang::CodeGen::CodeGenTypeCache::(anonymous)", NM="_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union2")
  //</editor-fold>
  public static class/*union*/ Unnamed_union2 {
    public PointerType /*P*/ VoidPtrTy;
    public PointerType /*P*/ Int8PtrTy;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 52,
     FQN="clang::CodeGen::CodeGenTypeCache::(anonymous union)::", NM="_ZN5clang7CodeGen16CodeGenTypeCacheUt0_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheUt0_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union2(final Unnamed_union2 $Prm0) {
      $assign($Prm0.Int8PtrTy);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private Unnamed_union2() {}

    // all fields in union are of the same type just differently named
    final void $assign(PointerType /*P*/ Ty) {
      VoidPtrTy = Int8PtrTy = Ty;
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "VoidPtrTy=" + VoidPtrTy // NOI18N
                + ", Int8PtrTy=" + Int8PtrTy; // NOI18N
    }
  };
  public Unnamed_union2 Unnamed_field9 = new Unnamed_union2();
  
  /// void** in address space 0
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 58,
   FQN="clang::CodeGen::CodeGenTypeCache::(anonymous)", NM="_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union3")
  //</editor-fold>
  public static class/*union*/ Unnamed_union3 {
    public PointerType /*P*/ VoidPtrPtrTy;
    public PointerType /*P*/ Int8PtrPtrTy;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 58,
     FQN="clang::CodeGen::CodeGenTypeCache::(anonymous union)::", NM="_ZN5clang7CodeGen16CodeGenTypeCacheUt1_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheUt1_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union3(final Unnamed_union3 $Prm0) {
      $assign($Prm0.Int8PtrPtrTy);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private Unnamed_union3() {}

    // all fields in union are of the same type just differently named
    final void $assign(PointerType /*P*/ Ty) {
      VoidPtrPtrTy = Int8PtrPtrTy = Ty;
    }
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "VoidPtrPtrTy=" + VoidPtrPtrTy // NOI18N
                + ", Int8PtrPtrTy=" + Int8PtrPtrTy; // NOI18N
    }
  };
  public Unnamed_union3 Unnamed_field10 = new Unnamed_union3();
  
  /// The size and alignment of the builtin C type 'int'.  This comes
  /// up enough in various ABI lowering tasks to be worth pre-computing.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 65,
   FQN="clang::CodeGen::CodeGenTypeCache::(anonymous)", NM="_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union4",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union4")
  //</editor-fold>
  public static class/*union*/ Unnamed_union4 {
    public /*uchar*/byte IntSizeInBytes;
    public /*uchar*/byte IntAlignInBytes;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 65,
     FQN="clang::CodeGen::CodeGenTypeCache::(anonymous union)::", NM="_ZN5clang7CodeGen16CodeGenTypeCacheUt2_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheUt2_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union4(final Unnamed_union4 $Prm0) {
      $assign($Prm0.IntAlignInBytes);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private Unnamed_union4() {}

    // all fields in union are of the same type just differently named
    final void $assign(/*uchar*/byte val) {
      IntSizeInBytes = IntAlignInBytes = val;
    }    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "IntSizeInBytes=" + $uchar2uint(IntSizeInBytes) // NOI18N
                + ", IntAlignInBytes=" + $uchar2uint(IntAlignInBytes); // NOI18N
    }
  };
  public Unnamed_union4 Unnamed_field11 = new Unnamed_union4();
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::getIntSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 69,
   FQN="clang::CodeGen::CodeGenTypeCache::getIntSize", NM="_ZNK5clang7CodeGen16CodeGenTypeCache10getIntSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen16CodeGenTypeCache10getIntSizeEv")
  //</editor-fold>
  public CharUnits getIntSize() /*const*/ {
    return CharUnits.fromQuantity($uchar2long(Unnamed_field11.IntSizeInBytes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::getIntAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 72,
   FQN="clang::CodeGen::CodeGenTypeCache::getIntAlign", NM="_ZNK5clang7CodeGen16CodeGenTypeCache11getIntAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen16CodeGenTypeCache11getIntAlignEv")
  //</editor-fold>
  public CharUnits getIntAlign() /*const*/ {
    return CharUnits.fromQuantity($uchar2long(Unnamed_field11.IntAlignInBytes));
  }

  
  /// The width of a pointer into the generic address space.
  public /*uchar*/byte PointerWidthInBits;
  
  /// The size and alignment of a pointer into the generic address space.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 80,
   FQN="clang::CodeGen::CodeGenTypeCache::(anonymous)", NM="_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union5",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheE_Unnamed_union5")
  //</editor-fold>
  public static class/*union*/ Unnamed_union5 {
    public /*uchar*/byte PointerAlignInBytes;
    public /*uchar*/byte PointerSizeInBytes;
    public /*uchar*/byte SizeSizeInBytes; // sizeof(size_t)
    public /*uchar*/byte SizeAlignInBytes;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 80,
     FQN="clang::CodeGen::CodeGenTypeCache::(anonymous union)::", NM="_ZN5clang7CodeGen16CodeGenTypeCacheUt3_C1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheUt3_C1ERKS2_")
    //</editor-fold>
    public /*inline*/ Unnamed_union5(final Unnamed_union5 $Prm0) {
      $assign($Prm0.PointerAlignInBytes);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    private Unnamed_union5() {}

    // all fields in union are of the same type just differently named
    final void $assign(/*uchar*/byte val) {
      PointerAlignInBytes = PointerSizeInBytes = SizeSizeInBytes = SizeAlignInBytes = val;
    } 
    
    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "PointerAlignInBytes=" + $uchar2uint(PointerAlignInBytes) // NOI18N
                + ", PointerSizeInBytes=" + $uchar2uint(PointerSizeInBytes) // NOI18N
                + ", SizeSizeInBytes=" + $uchar2uint(SizeSizeInBytes) // NOI18N
                + ", SizeAlignInBytes=" + $uchar2uint(SizeAlignInBytes); // NOI18N
    }
  };
  public Unnamed_union5 Unnamed_field13 = new Unnamed_union5();
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::getSizeSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 86,
   FQN="clang::CodeGen::CodeGenTypeCache::getSizeSize", NM="_ZNK5clang7CodeGen16CodeGenTypeCache11getSizeSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen16CodeGenTypeCache11getSizeSizeEv")
  //</editor-fold>
  public CharUnits getSizeSize() /*const*/ {
    return CharUnits.fromQuantity($uchar2long(Unnamed_field13.SizeSizeInBytes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::getSizeAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 89,
   FQN="clang::CodeGen::CodeGenTypeCache::getSizeAlign", NM="_ZNK5clang7CodeGen16CodeGenTypeCache12getSizeAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen16CodeGenTypeCache12getSizeAlignEv")
  //</editor-fold>
  public CharUnits getSizeAlign() /*const*/ {
    return CharUnits.fromQuantity($uchar2long(Unnamed_field13.SizeAlignInBytes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::getPointerSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 92,
   FQN="clang::CodeGen::CodeGenTypeCache::getPointerSize", NM="_ZNK5clang7CodeGen16CodeGenTypeCache14getPointerSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen16CodeGenTypeCache14getPointerSizeEv")
  //</editor-fold>
  public CharUnits getPointerSize() /*const*/ {
    return CharUnits.fromQuantity($uchar2long(Unnamed_field13.PointerSizeInBytes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::getPointerAlign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 95,
   FQN="clang::CodeGen::CodeGenTypeCache::getPointerAlign", NM="_ZNK5clang7CodeGen16CodeGenTypeCache15getPointerAlignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen16CodeGenTypeCache15getPointerAlignEv")
  //</editor-fold>
  public CharUnits getPointerAlign() /*const*/ {
    return CharUnits.fromQuantity($uchar2long(Unnamed_field13.PointerAlignInBytes));
  }

  
  public /*uint*/int RuntimeCC;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::getRuntimeCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 100,
   FQN="clang::CodeGen::CodeGenTypeCache::getRuntimeCC", NM="_ZNK5clang7CodeGen16CodeGenTypeCache12getRuntimeCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen16CodeGenTypeCache12getRuntimeCCEv")
  //</editor-fold>
  public /*uint*/int getRuntimeCC() /*const*/ {
    return RuntimeCC;
  }

  public /*uint*/int BuiltinCC;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::getBuiltinCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 102,
   FQN="clang::CodeGen::CodeGenTypeCache::getBuiltinCC", NM="_ZNK5clang7CodeGen16CodeGenTypeCache12getBuiltinCCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZNK5clang7CodeGen16CodeGenTypeCache12getBuiltinCCEv")
  //</editor-fold>
  public /*uint*/int getBuiltinCC() /*const*/ {
    return BuiltinCC;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::CodeGenTypeCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 32,
   FQN="clang::CodeGen::CodeGenTypeCache::CodeGenTypeCache", NM="_ZN5clang7CodeGen16CodeGenTypeCacheC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheC1ERKS1_")
  //</editor-fold>
  public /*inline*/ CodeGenTypeCache(final /*const*/ CodeGenTypeCache /*&*/ $Prm0) {
    // : VoidTy(.VoidTy), Int8Ty(.Int8Ty), Int16Ty(.Int16Ty), Int32Ty(.Int32Ty), Int64Ty(.Int64Ty), FloatTy(.FloatTy), DoubleTy(.DoubleTy), IntTy(.IntTy), Unnamed_field8(.), Unnamed_field9(.), Unnamed_field10(.), Unnamed_field11(.), PointerWidthInBits(.PointerWidthInBits), Unnamed_field13(.), RuntimeCC(.RuntimeCC), BuiltinCC(.BuiltinCC) 
    //START JInit
    this.VoidTy = $Prm0.VoidTy;
    this.Int8Ty = $Prm0.Int8Ty;
    this.Int16Ty = $Prm0.Int16Ty;
    this.Int32Ty = $Prm0.Int32Ty;
    this.Int64Ty = $Prm0.Int64Ty;
    this.FloatTy = $Prm0.FloatTy;
    this.DoubleTy = $Prm0.DoubleTy;
    this.IntTy = $Prm0.IntTy;
    this.Unnamed_field8 = new Unnamed_union1($Prm0.Unnamed_field8);
    this.Unnamed_field9 = new Unnamed_union2($Prm0.Unnamed_field9);
    this.Unnamed_field10 = new Unnamed_union3($Prm0.Unnamed_field10);
    this.Unnamed_field11 = new Unnamed_union4($Prm0.Unnamed_field11);
    this.PointerWidthInBits = $Prm0.PointerWidthInBits;
    this.Unnamed_field13 = new Unnamed_union5($Prm0.Unnamed_field13);
    this.RuntimeCC = $Prm0.RuntimeCC;
    this.BuiltinCC = $Prm0.BuiltinCC;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenTypeCache::CodeGenTypeCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypeCache.h", line = 32,
   FQN="clang::CodeGen::CodeGenTypeCache::CodeGenTypeCache", NM="_ZN5clang7CodeGen16CodeGenTypeCacheC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN5clang7CodeGen16CodeGenTypeCacheC1Ev")
  //</editor-fold>
  public /*inline*/ CodeGenTypeCache() {
  }

  
  @Override public String toString() {
    return "" + "VoidTy=" + VoidTy // NOI18N
              + ", Int8Ty=" + Int8Ty // NOI18N
              + ", Int16Ty=" + Int16Ty // NOI18N
              + ", Int32Ty=" + Int32Ty // NOI18N
              + ", Int64Ty=" + Int64Ty // NOI18N
              + ", FloatTy=" + FloatTy // NOI18N
              + ", DoubleTy=" + DoubleTy // NOI18N
              + ", IntTy=" + IntTy // NOI18N
              + ", Unnamed_field8=" + Unnamed_field8 // NOI18N
              + ", Unnamed_field9=" + Unnamed_field9 // NOI18N
              + ", Unnamed_field10=" + Unnamed_field10 // NOI18N
              + ", Unnamed_field11=" + Unnamed_field11 // NOI18N
              + ", PointerWidthInBits=" + $uchar2uint(PointerWidthInBits) // NOI18N
              + ", Unnamed_field13=" + Unnamed_field13 // NOI18N
              + ", RuntimeCC=" + RuntimeCC // NOI18N
              + ", BuiltinCC=" + BuiltinCC; // NOI18N
  }
}
