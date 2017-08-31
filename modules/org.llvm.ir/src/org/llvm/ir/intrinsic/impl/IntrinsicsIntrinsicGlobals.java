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
package org.llvm.ir.intrinsic.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.*;


//<editor-fold defaultstate="collapsed" desc="static type IntrinsicsIntrinsicGlobals">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.llvm.ir.intrinsic.impl.IntrinsicsIntrinsicGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13getAttributesERNS_11LLVMContextENS0_2IDE;_ZN4llvm9Intrinsic24getIntrinsicForMSBuiltinEPKcS2_;_ZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_; -static-type=IntrinsicsIntrinsicGlobals -package=org.llvm.ir.intrinsic.impl")
//</editor-fold>
public final class IntrinsicsIntrinsicGlobals {

  //<editor-fold defaultstate="collapsed" desc="BuiltinEntry">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 29691,
   FQN="BuiltinEntry", NM="_ZZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_E12BuiltinEntry",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_E12BuiltinEntry")
  //</editor-fold>
   public static class/*struct*/ BuiltinEntry {
    public /*Intrinsic.ID*/int IntrinID;
    public /*uint*/int StrTabOffset;
    //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getIntrinsicForGCCBuiltin(const char * , const char * )::BuiltinEntry::getName">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 29694,
     FQN="llvm::Intrinsic::getIntrinsicForGCCBuiltin(const char * , const char * )::BuiltinEntry::getName", NM="_ZZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_ENK12BuiltinEntry7getNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_ENK12BuiltinEntry7getNameEv")
    //</editor-fold>
    public /*const*/char$ptr/*char P*/ getName() /*const*/ {
      return $AddrOf(create_char$ptr(getIntrinsicForGCCBuiltin$$.BuiltinNames, StrTabOffset));
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getIntrinsicForGCCBuiltin(const char * , const char * )::BuiltinEntry::operator<">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 29697,
     FQN="llvm::Intrinsic::getIntrinsicForGCCBuiltin(const char * , const char * )::BuiltinEntry::operator<", NM="_ZZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_ENK12BuiltinEntryltES2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_ENK12BuiltinEntryltES2_")
    //</editor-fold>
    public boolean $less(/*const*/char$ptr/*char P*/ RHS) /*const*/ {
      return strcmp(getName(), RHS) < 0;
    }

    public BuiltinEntry(int IntrinID, int StrTabOffset) {
      this.IntrinID = IntrinID;
      this.StrTabOffset = StrTabOffset;
    }

    
    @Override public String toString() {
      return "" + "IntrinID=" + IntrinID // NOI18N
                + ", StrTabOffset=" + StrTabOffset; // NOI18N
    }
  }
;

/// Return the attributes for an intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getAttributes">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 14139,
 FQN="llvm::Intrinsic::getAttributes", NM="_ZN4llvm9Intrinsic13getAttributesERNS_11LLVMContextENS0_2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic13getAttributesERNS_11LLVMContextENS0_2IDE")
//</editor-fold>
public static AttributeSet getAttributes(final LLVMContext /*&*/ C, /*Intrinsic.ID*/int id) {
  final/*static*/ /*const*/byte/*uint8_t*/ IntrinsicsToAttributesMap[/*6082*/] = getAttributes$$.IntrinsicsToAttributesMap;
  
  AttributeSet AS[/*5*/]/*J*/= new$T(new AttributeSet [5], ()->new AttributeSet());
  /*uint*/int NumAttrs = 0;
  if (id != 0) {
    switch (IntrinsicsToAttributesMap[id - 1]) {
     default:
      throw new llvm_unreachable("Invalid attribute number");
     case 2:
      {
        /*const*/ Attribute.AttrKind Atts[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoUnwind};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 26:
      {
        /*const*/ Attribute.AttrKind AttrParam1[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 1, new ArrayRef<Attribute.AttrKind>(AttrParam1)));
        /*const*/ Attribute.AttrKind Atts[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoUnwind};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 27:
      {
        /*const*/ Attribute.AttrKind AttrParam1[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 1, new ArrayRef<Attribute.AttrKind>(AttrParam1)));
        /*const*/ Attribute.AttrKind AttrParam2[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 2, new ArrayRef<Attribute.AttrKind>(AttrParam2)));
        /*const*/ Attribute.AttrKind Atts[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoUnwind};
        AS[2].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 3;
        break;
      }
     case 11:
      {
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 8:
      {
        /*const*/ Attribute.AttrKind AttrParam1[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 1, new ArrayRef<Attribute.AttrKind>(AttrParam1)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 14:
      {
        /*const*/ Attribute.AttrKind AttrParam1[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoCapture, Attribute.AttrKind.WriteOnly};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 1, new ArrayRef<Attribute.AttrKind>(AttrParam1)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 12:
      {
        /*const*/ Attribute.AttrKind AttrParam1[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoCapture, Attribute.AttrKind.WriteOnly};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 1, new ArrayRef<Attribute.AttrKind>(AttrParam1)));
        /*const*/ Attribute.AttrKind AttrParam2[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoCapture, Attribute.AttrKind.ReadOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 2, new ArrayRef<Attribute.AttrKind>(AttrParam2)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[2].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 3;
        break;
      }
     case 13:
      {
        /*const*/ Attribute.AttrKind AttrParam1[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 1, new ArrayRef<Attribute.AttrKind>(AttrParam1)));
        /*const*/ Attribute.AttrKind AttrParam2[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoCapture, Attribute.AttrKind.ReadOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 2, new ArrayRef<Attribute.AttrKind>(AttrParam2)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[2].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 3;
        break;
      }
     case 10:
      {
        /*const*/ Attribute.AttrKind AttrParam2[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 2, new ArrayRef<Attribute.AttrKind>(AttrParam2)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 7:
      {
        /*const*/ Attribute.AttrKind AttrParam2[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 2, new ArrayRef<Attribute.AttrKind>(AttrParam2)));
        /*const*/ Attribute.AttrKind AttrParam3[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 3, new ArrayRef<Attribute.AttrKind>(AttrParam3)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[2].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 3;
        break;
      }
     case 9:
      {
        /*const*/ Attribute.AttrKind AttrParam3[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 3, new ArrayRef<Attribute.AttrKind>(AttrParam3)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 15:
      {
        /*const*/ Attribute.AttrKind AttrParam4[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 4, new ArrayRef<Attribute.AttrKind>(AttrParam4)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 16:
      {
        /*const*/ Attribute.AttrKind AttrParam5[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 5, new ArrayRef<Attribute.AttrKind>(AttrParam5)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 17:
      {
        /*const*/ Attribute.AttrKind AttrParam6[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 6, new ArrayRef<Attribute.AttrKind>(AttrParam6)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ArgMemOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 18:
      {
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.WriteOnly};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 6:
      {
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ReadOnly};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 1:
      {
        /*const*/ Attribute.AttrKind Atts[/*3*/] = new /*const*/ Attribute.AttrKind [/*3*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ReadOnly, Attribute.AttrKind.ArgMemOnly};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 22:
      {
        /*const*/ Attribute.AttrKind AttrParam1[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 1, new ArrayRef<Attribute.AttrKind>(AttrParam1)));
        /*const*/ Attribute.AttrKind Atts[/*3*/] = new /*const*/ Attribute.AttrKind [/*3*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ReadOnly, Attribute.AttrKind.ArgMemOnly};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 3:
      {
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ReadNone};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 23:
      {
        /*const*/ Attribute.AttrKind AttrParam1[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoCapture};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, 1, new ArrayRef<Attribute.AttrKind>(AttrParam1)));
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.ReadNone};
        AS[1].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 2;
        break;
      }
     case 20:
      {
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.Convergent};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 19:
      {
        /*const*/ Attribute.AttrKind Atts[/*3*/] = new /*const*/ Attribute.AttrKind [/*3*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.Convergent, Attribute.AttrKind.ReadNone};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 4:
      {
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.NoReturn};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 25:
      {
        /*const*/ Attribute.AttrKind Atts[/*2*/] = new /*const*/ Attribute.AttrKind [/*2*/] {Attribute.AttrKind.NoUnwind, Attribute.AttrKind.NoDuplicate};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 5:
      {
        return new AttributeSet();
      }
     case 21:
      {
        /*const*/ Attribute.AttrKind Atts[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.ReadNone};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
     case 24:
      {
        /*const*/ Attribute.AttrKind Atts[/*1*/] = new /*const*/ Attribute.AttrKind [/*1*/] {Attribute.AttrKind.NoReturn};
        AS[0].$assignMove(AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(C, AttributeSet.AttrIndex.FunctionIndex.getValue(), new ArrayRef<Attribute.AttrKind>(Atts)));
        NumAttrs = 1;
        break;
      }
    }
  }
  return AttributeSet.get_LLVMContext_ArrayRef$AttributeSet(C, makeArrayRef(AS, NumAttrs));
}
private static final class getAttributes$$ {
  private static final byte[] readBytes(String resource, int length) throws URISyntaxException, IOException {
    InputStream is = IntrinsicsIntrinsicGlobals.class.getResourceAsStream(resource);
    byte res[] = new byte[length];
    is.read(res);
    is.close();
    return res;
  }
  static final/*static*/ /*const*/byte/*uint8_t*/ IntrinsicsToAttributesMap[/*6082*/];
  static {
    byte res[] = new byte[0];
    try {
      res = readBytes("/org/llvm/ir/resources/IntrinsicsToAttributesMap", 6082);
    } catch (Exception ex) {
      Logger.getLogger(IntrinsicsIntrinsicGlobals.class.getName()).log(Level.SEVERE, null, ex);
    }
    IntrinsicsToAttributesMap = res;
  }
}


/// Map a GCC builtin name to an intrinsic ID.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getIntrinsicForGCCBuiltin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 20436,
 FQN="llvm::Intrinsic::getIntrinsicForGCCBuiltin", NM="_ZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic25getIntrinsicForGCCBuiltinEPKcS2_")
//</editor-fold>
public static /*Intrinsic.ID*/int getIntrinsicForGCCBuiltin(/*const*/char$ptr/*char P*/ TargetPrefixStr, /*const*/char$ptr/*char P*/ BuiltinNameStr) {
  //final/*static*/ /*const*//*char*/byte BuiltinNames[/*138761*/] = getIntrinsicForGCCBuiltin$$.BuiltinNames;
  
  StringRef BuiltinName/*J*/= new StringRef(BuiltinNameStr);
  StringRef TargetPrefix/*J*/= new StringRef(TargetPrefixStr);

  Native.ComparatorLower<BuiltinEntry, char$ptr> comparator = new Native.ComparatorLower<BuiltinEntry, char$ptr>(){
    @Override
    public boolean $less(BuiltinEntry one, char$ptr other) {
      return one.$less(other);
    }
  };
  /* Target Independent Builtins */   {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> Names = create_type$ptr(getIntrinsicForGCCBuiltin$$.Names);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(Names, Names.$add(10), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, Names.$add(10))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"aarch64")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> aarch64Names = create_type$ptr(getIntrinsicForGCCBuiltin$$.aarch64Names);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(aarch64Names, aarch64Names.$add(3), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, aarch64Names.$add(3))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"amdgcn")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> amdgcnNames = create_type$ptr(getIntrinsicForGCCBuiltin$$.amdgcnNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(amdgcnNames, amdgcnNames.$add(31), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, amdgcnNames.$add(31))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"arm")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> armNames = create_type$ptr(getIntrinsicForGCCBuiltin$$.armNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(armNames, armNames.$add(23), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, armNames.$add(23))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"bpf")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> bpfNames = create_type$ptr(getIntrinsicForGCCBuiltin$$.bpfNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(bpfNames, bpfNames.$add(4), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, bpfNames.$add(4))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"hexagon")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> hexagonNames = create_type$ptr(getIntrinsicForGCCBuiltin$$.hexagonNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(hexagonNames, hexagonNames.$add(1489), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, hexagonNames.$add(1489))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"mips")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> mipsNames = create_type$ptr(getIntrinsicForGCCBuiltin$$.mipsNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(mipsNames, mipsNames.$add(667), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, mipsNames.$add(667))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"nvvm")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> nvvmNames = create_type$ptr(getIntrinsicForGCCBuiltin$$.nvvmNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(nvvmNames, nvvmNames.$add(555), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, nvvmNames.$add(555))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"ppc")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> ppcNames = create_type$ptr(getIntrinsicForGCCBuiltin$$.ppcNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(ppcNames, ppcNames.$add(311), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, ppcNames.$add(311))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"r600")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> r600Names = create_type$ptr(getIntrinsicForGCCBuiltin$$.r600Names);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(r600Names, r600Names.$add(12), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, r600Names.$add(12))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"s390")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> s390Names = create_type$ptr(getIntrinsicForGCCBuiltin$$.s390Names);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(s390Names, s390Names.$add(149), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, s390Names.$add(149))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"x86")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> x86Names = create_type$ptr(getIntrinsicForGCCBuiltin$$.x86Names);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(x86Names, x86Names.$add(1740), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, x86Names.$add(1740))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"xcore")) {
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> xcoreNames = create_type$ptr(getIntrinsicForGCCBuiltin$$.xcoreNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(xcoreNames, xcoreNames.$add(4), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, xcoreNames.$add(4))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  return ID.not_intrinsic;
}
private static final class getIntrinsicForGCCBuiltin$$ {
  private static final byte[] readStrings(String resource, int length) throws URISyntaxException, IOException {
    InputStream is = IntrinsicsIntrinsicGlobals.class.getResourceAsStream(resource);
    byte res[] = new byte[length];
    is.read(res);
    is.close();
    return res;
  }
  static final/*static*/ /*const*//*char*/byte BuiltinNames[/*138761*/];
  static {
    byte res[] = new byte[0];
    try {
      res = readStrings("/org/llvm/ir/resources/IntrinsicForGCCBuiltin", 138761);
    } catch (Exception ex) {
      Logger.getLogger(IntrinsicsIntrinsicGlobals.class.getName()).log(Level.SEVERE, null, ex);
    }
    BuiltinNames = res;
  }
  static final/*static*/ /*const*/ BuiltinEntry[/*10*/] Names = new /*const*/ BuiltinEntry [/*10*/] {
    new BuiltinEntry(ID.adjust_trampoline, 0),  // __builtin_adjust_trampoline
    new BuiltinEntry(ID.debugtrap, 28),  // __builtin_debugtrap
    new BuiltinEntry(ID.flt_rounds, 70),  // __builtin_flt_rounds
    new BuiltinEntry(ID.init_trampoline, 91),  // __builtin_init_trampoline
    new BuiltinEntry(ID.objectsize, 117),  // __builtin_object_size
    new BuiltinEntry(ID.stackrestore, 139),  // __builtin_stack_restore
    new BuiltinEntry(ID.stacksave, 163),  // __builtin_stack_save
    new BuiltinEntry(ID.thread_pointer, 184),  // __builtin_thread_pointer
    new BuiltinEntry(ID.trap, 209),  // __builtin_trap
    new BuiltinEntry(ID.eh_unwind_init, 48) // __builtin_unwind_init
  };
  static final/*static*/ /*const*/ BuiltinEntry aarch64Names[/*3*/] = new /*const*/ BuiltinEntry [/*3*/] {
    new BuiltinEntry(ID.aarch64_dmb, 224),  // __builtin_arm_dmb
    new BuiltinEntry(ID.aarch64_dsb, 242),  // __builtin_arm_dsb
    new BuiltinEntry(ID.aarch64_isb, 260) // __builtin_arm_isb
  };
  static final/*static*/ /*const*/ BuiltinEntry amdgcnNames[/*31*/] = new /*const*/ BuiltinEntry [/*31*/] {
    new BuiltinEntry(ID.amdgcn_buffer_wbinvl1, 278),  // __builtin_amdgcn_buffer_wbinvl1
    new BuiltinEntry(ID.amdgcn_buffer_wbinvl1_sc, 310),  // __builtin_amdgcn_buffer_wbinvl1_sc
    new BuiltinEntry(ID.amdgcn_buffer_wbinvl1_vol, 345),  // __builtin_amdgcn_buffer_wbinvl1_vol
    new BuiltinEntry(ID.amdgcn_cubeid, 381),  // __builtin_amdgcn_cubeid
    new BuiltinEntry(ID.amdgcn_cubema, 405),  // __builtin_amdgcn_cubema
    new BuiltinEntry(ID.amdgcn_cubesc, 429),  // __builtin_amdgcn_cubesc
    new BuiltinEntry(ID.amdgcn_cubetc, 453),  // __builtin_amdgcn_cubetc
    new BuiltinEntry(ID.amdgcn_dispatch_ptr, 477),  // __builtin_amdgcn_dispatch_ptr
    new BuiltinEntry(ID.amdgcn_ds_swizzle, 507),  // __builtin_amdgcn_ds_swizzle
    new BuiltinEntry(ID.amdgcn_groupstaticsize, 535),  // __builtin_amdgcn_groupstaticsize
    new BuiltinEntry(ID.amdgcn_implicitarg_ptr, 568),  // __builtin_amdgcn_implicitarg_ptr
    new BuiltinEntry(ID.amdgcn_interp_p1, 601),  // __builtin_amdgcn_interp_p1
    new BuiltinEntry(ID.amdgcn_interp_p2, 628),  // __builtin_amdgcn_interp_p2
    new BuiltinEntry(ID.amdgcn_kernarg_segment_ptr, 655),  // __builtin_amdgcn_kernarg_segment_ptr
    new BuiltinEntry(ID.amdgcn_lerp, 692),  // __builtin_amdgcn_lerp
    new BuiltinEntry(ID.amdgcn_mbcnt_hi, 714),  // __builtin_amdgcn_mbcnt_hi
    new BuiltinEntry(ID.amdgcn_mbcnt_lo, 740),  // __builtin_amdgcn_mbcnt_lo
    new BuiltinEntry(ID.amdgcn_queue_ptr, 766),  // __builtin_amdgcn_queue_ptr
    new BuiltinEntry(ID.amdgcn_rsq_legacy, 793),  // __builtin_amdgcn_rsq_legacy
    new BuiltinEntry(ID.amdgcn_s_barrier, 821),  // __builtin_amdgcn_s_barrier
    new BuiltinEntry(ID.amdgcn_s_dcache_inv, 848),  // __builtin_amdgcn_s_dcache_inv
    new BuiltinEntry(ID.amdgcn_s_dcache_inv_vol, 878),  // __builtin_amdgcn_s_dcache_inv_vol
    new BuiltinEntry(ID.amdgcn_s_dcache_wb, 912),  // __builtin_amdgcn_s_dcache_wb
    new BuiltinEntry(ID.amdgcn_s_dcache_wb_vol, 941),  // __builtin_amdgcn_s_dcache_wb_vol
    new BuiltinEntry(ID.amdgcn_s_getreg, 974),  // __builtin_amdgcn_s_getreg
    new BuiltinEntry(ID.amdgcn_s_memrealtime, 1000),  // __builtin_amdgcn_s_memrealtime
    new BuiltinEntry(ID.amdgcn_s_memtime, 1031),  // __builtin_amdgcn_s_memtime
    new BuiltinEntry(ID.amdgcn_s_sleep, 1058),  // __builtin_amdgcn_s_sleep
    new BuiltinEntry(ID.amdgcn_workgroup_id_x, 1083),  // __builtin_amdgcn_workgroup_id_x
    new BuiltinEntry(ID.amdgcn_workgroup_id_y, 1115),  // __builtin_amdgcn_workgroup_id_y
    new BuiltinEntry(ID.amdgcn_workgroup_id_z, 1147) // __builtin_amdgcn_workgroup_id_z
  };
  static final/*static*/ /*const*/ BuiltinEntry armNames[/*23*/] = new /*const*/ BuiltinEntry [/*23*/] {
    new BuiltinEntry(ID.arm_cdp, 1179),  // __builtin_arm_cdp
    new BuiltinEntry(ID.arm_cdp2, 1197),  // __builtin_arm_cdp2
    new BuiltinEntry(ID.arm_dmb, 224),  // __builtin_arm_dmb
    new BuiltinEntry(ID.arm_dsb, 242),  // __builtin_arm_dsb
    new BuiltinEntry(ID.arm_get_fpscr, 1216),  // __builtin_arm_get_fpscr
    new BuiltinEntry(ID.arm_isb, 260),  // __builtin_arm_isb
    new BuiltinEntry(ID.arm_ldc, 1240),  // __builtin_arm_ldc
    new BuiltinEntry(ID.arm_ldc2, 1258),  // __builtin_arm_ldc2
    new BuiltinEntry(ID.arm_ldc2l, 1277),  // __builtin_arm_ldc2l
    new BuiltinEntry(ID.arm_ldcl, 1297),  // __builtin_arm_ldcl
    new BuiltinEntry(ID.arm_mcr, 1316),  // __builtin_arm_mcr
    new BuiltinEntry(ID.arm_mcr2, 1334),  // __builtin_arm_mcr2
    new BuiltinEntry(ID.arm_mrc, 1353),  // __builtin_arm_mrc
    new BuiltinEntry(ID.arm_mrc2, 1371),  // __builtin_arm_mrc2
    new BuiltinEntry(ID.arm_qadd, 1390),  // __builtin_arm_qadd
    new BuiltinEntry(ID.arm_qsub, 1409),  // __builtin_arm_qsub
    new BuiltinEntry(ID.arm_set_fpscr, 1428),  // __builtin_arm_set_fpscr
    new BuiltinEntry(ID.arm_ssat, 1452),  // __builtin_arm_ssat
    new BuiltinEntry(ID.arm_stc, 1471),  // __builtin_arm_stc
    new BuiltinEntry(ID.arm_stc2, 1489),  // __builtin_arm_stc2
    new BuiltinEntry(ID.arm_stc2l, 1508),  // __builtin_arm_stc2l
    new BuiltinEntry(ID.arm_stcl, 1528),  // __builtin_arm_stcl
    new BuiltinEntry(ID.arm_usat, 1547) // __builtin_arm_usat
  };
  static final/*static*/ /*const*/ BuiltinEntry bpfNames[/*4*/] = new /*const*/ BuiltinEntry [/*4*/] {
    new BuiltinEntry(ID.bpf_load_byte, 1566),  // __builtin_bpf_load_byte
    new BuiltinEntry(ID.bpf_load_half, 1590),  // __builtin_bpf_load_half
    new BuiltinEntry(ID.bpf_load_word, 1614),  // __builtin_bpf_load_word
    new BuiltinEntry(ID.bpf_pseudo, 1638) // __builtin_bpf_pseudo
  };
  static final/*static*/ /*const*/ BuiltinEntry hexagonNames[/*1489*/] = new /*const*/ BuiltinEntry [/*1489*/] {
    new BuiltinEntry(ID.hexagon_A2_abs, 1659),  // __builtin_HEXAGON_A2_abs
    new BuiltinEntry(ID.hexagon_A2_absp, 1684),  // __builtin_HEXAGON_A2_absp
    new BuiltinEntry(ID.hexagon_A2_abssat, 1710),  // __builtin_HEXAGON_A2_abssat
    new BuiltinEntry(ID.hexagon_A2_add, 1738),  // __builtin_HEXAGON_A2_add
    new BuiltinEntry(ID.hexagon_A2_addh_h16_hh, 1763),  // __builtin_HEXAGON_A2_addh_h16_hh
    new BuiltinEntry(ID.hexagon_A2_addh_h16_hl, 1796),  // __builtin_HEXAGON_A2_addh_h16_hl
    new BuiltinEntry(ID.hexagon_A2_addh_h16_lh, 1829),  // __builtin_HEXAGON_A2_addh_h16_lh
    new BuiltinEntry(ID.hexagon_A2_addh_h16_ll, 1862),  // __builtin_HEXAGON_A2_addh_h16_ll
    new BuiltinEntry(ID.hexagon_A2_addh_h16_sat_hh, 1895),  // __builtin_HEXAGON_A2_addh_h16_sat_hh
    new BuiltinEntry(ID.hexagon_A2_addh_h16_sat_hl, 1932),  // __builtin_HEXAGON_A2_addh_h16_sat_hl
    new BuiltinEntry(ID.hexagon_A2_addh_h16_sat_lh, 1969),  // __builtin_HEXAGON_A2_addh_h16_sat_lh
    new BuiltinEntry(ID.hexagon_A2_addh_h16_sat_ll, 2006),  // __builtin_HEXAGON_A2_addh_h16_sat_ll
    new BuiltinEntry(ID.hexagon_A2_addh_l16_hl, 2043),  // __builtin_HEXAGON_A2_addh_l16_hl
    new BuiltinEntry(ID.hexagon_A2_addh_l16_ll, 2076),  // __builtin_HEXAGON_A2_addh_l16_ll
    new BuiltinEntry(ID.hexagon_A2_addh_l16_sat_hl, 2109),  // __builtin_HEXAGON_A2_addh_l16_sat_hl
    new BuiltinEntry(ID.hexagon_A2_addh_l16_sat_ll, 2146),  // __builtin_HEXAGON_A2_addh_l16_sat_ll
    new BuiltinEntry(ID.hexagon_A2_addi, 2183),  // __builtin_HEXAGON_A2_addi
    new BuiltinEntry(ID.hexagon_A2_addp, 2209),  // __builtin_HEXAGON_A2_addp
    new BuiltinEntry(ID.hexagon_A2_addpsat, 2235),  // __builtin_HEXAGON_A2_addpsat
    new BuiltinEntry(ID.hexagon_A2_addsat, 2264),  // __builtin_HEXAGON_A2_addsat
    new BuiltinEntry(ID.hexagon_A2_addsp, 2292),  // __builtin_HEXAGON_A2_addsp
    new BuiltinEntry(ID.hexagon_A2_and, 2319),  // __builtin_HEXAGON_A2_and
    new BuiltinEntry(ID.hexagon_A2_andir, 2344),  // __builtin_HEXAGON_A2_andir
    new BuiltinEntry(ID.hexagon_A2_andp, 2371),  // __builtin_HEXAGON_A2_andp
    new BuiltinEntry(ID.hexagon_A2_aslh, 2397),  // __builtin_HEXAGON_A2_aslh
    new BuiltinEntry(ID.hexagon_A2_asrh, 2423),  // __builtin_HEXAGON_A2_asrh
    new BuiltinEntry(ID.hexagon_A2_combine_hh, 2449),  // __builtin_HEXAGON_A2_combine_hh
    new BuiltinEntry(ID.hexagon_A2_combine_hl, 2481),  // __builtin_HEXAGON_A2_combine_hl
    new BuiltinEntry(ID.hexagon_A2_combine_lh, 2513),  // __builtin_HEXAGON_A2_combine_lh
    new BuiltinEntry(ID.hexagon_A2_combine_ll, 2545),  // __builtin_HEXAGON_A2_combine_ll
    new BuiltinEntry(ID.hexagon_A2_combineii, 2577),  // __builtin_HEXAGON_A2_combineii
    new BuiltinEntry(ID.hexagon_A2_combinew, 2608),  // __builtin_HEXAGON_A2_combinew
    new BuiltinEntry(ID.hexagon_A2_max, 2638),  // __builtin_HEXAGON_A2_max
    new BuiltinEntry(ID.hexagon_A2_maxp, 2663),  // __builtin_HEXAGON_A2_maxp
    new BuiltinEntry(ID.hexagon_A2_maxu, 2689),  // __builtin_HEXAGON_A2_maxu
    new BuiltinEntry(ID.hexagon_A2_maxup, 2715),  // __builtin_HEXAGON_A2_maxup
    new BuiltinEntry(ID.hexagon_A2_min, 2742),  // __builtin_HEXAGON_A2_min
    new BuiltinEntry(ID.hexagon_A2_minp, 2767),  // __builtin_HEXAGON_A2_minp
    new BuiltinEntry(ID.hexagon_A2_minu, 2793),  // __builtin_HEXAGON_A2_minu
    new BuiltinEntry(ID.hexagon_A2_minup, 2819),  // __builtin_HEXAGON_A2_minup
    new BuiltinEntry(ID.hexagon_A2_neg, 2846),  // __builtin_HEXAGON_A2_neg
    new BuiltinEntry(ID.hexagon_A2_negp, 2871),  // __builtin_HEXAGON_A2_negp
    new BuiltinEntry(ID.hexagon_A2_negsat, 2897),  // __builtin_HEXAGON_A2_negsat
    new BuiltinEntry(ID.hexagon_A2_not, 2925),  // __builtin_HEXAGON_A2_not
    new BuiltinEntry(ID.hexagon_A2_notp, 2950),  // __builtin_HEXAGON_A2_notp
    new BuiltinEntry(ID.hexagon_A2_or, 2976),  // __builtin_HEXAGON_A2_or
    new BuiltinEntry(ID.hexagon_A2_orir, 3000),  // __builtin_HEXAGON_A2_orir
    new BuiltinEntry(ID.hexagon_A2_orp, 3026),  // __builtin_HEXAGON_A2_orp
    new BuiltinEntry(ID.hexagon_A2_roundsat, 3051),  // __builtin_HEXAGON_A2_roundsat
    new BuiltinEntry(ID.hexagon_A2_sat, 3081),  // __builtin_HEXAGON_A2_sat
    new BuiltinEntry(ID.hexagon_A2_satb, 3106),  // __builtin_HEXAGON_A2_satb
    new BuiltinEntry(ID.hexagon_A2_sath, 3132),  // __builtin_HEXAGON_A2_sath
    new BuiltinEntry(ID.hexagon_A2_satub, 3158),  // __builtin_HEXAGON_A2_satub
    new BuiltinEntry(ID.hexagon_A2_satuh, 3185),  // __builtin_HEXAGON_A2_satuh
    new BuiltinEntry(ID.hexagon_A2_sub, 3212),  // __builtin_HEXAGON_A2_sub
    new BuiltinEntry(ID.hexagon_A2_subh_h16_hh, 3237),  // __builtin_HEXAGON_A2_subh_h16_hh
    new BuiltinEntry(ID.hexagon_A2_subh_h16_hl, 3270),  // __builtin_HEXAGON_A2_subh_h16_hl
    new BuiltinEntry(ID.hexagon_A2_subh_h16_lh, 3303),  // __builtin_HEXAGON_A2_subh_h16_lh
    new BuiltinEntry(ID.hexagon_A2_subh_h16_ll, 3336),  // __builtin_HEXAGON_A2_subh_h16_ll
    new BuiltinEntry(ID.hexagon_A2_subh_h16_sat_hh, 3369),  // __builtin_HEXAGON_A2_subh_h16_sat_hh
    new BuiltinEntry(ID.hexagon_A2_subh_h16_sat_hl, 3406),  // __builtin_HEXAGON_A2_subh_h16_sat_hl
    new BuiltinEntry(ID.hexagon_A2_subh_h16_sat_lh, 3443),  // __builtin_HEXAGON_A2_subh_h16_sat_lh
    new BuiltinEntry(ID.hexagon_A2_subh_h16_sat_ll, 3480),  // __builtin_HEXAGON_A2_subh_h16_sat_ll
    new BuiltinEntry(ID.hexagon_A2_subh_l16_hl, 3517),  // __builtin_HEXAGON_A2_subh_l16_hl
    new BuiltinEntry(ID.hexagon_A2_subh_l16_ll, 3550),  // __builtin_HEXAGON_A2_subh_l16_ll
    new BuiltinEntry(ID.hexagon_A2_subh_l16_sat_hl, 3583),  // __builtin_HEXAGON_A2_subh_l16_sat_hl
    new BuiltinEntry(ID.hexagon_A2_subh_l16_sat_ll, 3620),  // __builtin_HEXAGON_A2_subh_l16_sat_ll
    new BuiltinEntry(ID.hexagon_A2_subp, 3657),  // __builtin_HEXAGON_A2_subp
    new BuiltinEntry(ID.hexagon_A2_subri, 3683),  // __builtin_HEXAGON_A2_subri
    new BuiltinEntry(ID.hexagon_A2_subsat, 3710),  // __builtin_HEXAGON_A2_subsat
    new BuiltinEntry(ID.hexagon_A2_svaddh, 3738),  // __builtin_HEXAGON_A2_svaddh
    new BuiltinEntry(ID.hexagon_A2_svaddhs, 3766),  // __builtin_HEXAGON_A2_svaddhs
    new BuiltinEntry(ID.hexagon_A2_svadduhs, 3795),  // __builtin_HEXAGON_A2_svadduhs
    new BuiltinEntry(ID.hexagon_A2_svavgh, 3825),  // __builtin_HEXAGON_A2_svavgh
    new BuiltinEntry(ID.hexagon_A2_svavghs, 3853),  // __builtin_HEXAGON_A2_svavghs
    new BuiltinEntry(ID.hexagon_A2_svnavgh, 3882),  // __builtin_HEXAGON_A2_svnavgh
    new BuiltinEntry(ID.hexagon_A2_svsubh, 3911),  // __builtin_HEXAGON_A2_svsubh
    new BuiltinEntry(ID.hexagon_A2_svsubhs, 3939),  // __builtin_HEXAGON_A2_svsubhs
    new BuiltinEntry(ID.hexagon_A2_svsubuhs, 3968),  // __builtin_HEXAGON_A2_svsubuhs
    new BuiltinEntry(ID.hexagon_A2_swiz, 3998),  // __builtin_HEXAGON_A2_swiz
    new BuiltinEntry(ID.hexagon_A2_sxtb, 4024),  // __builtin_HEXAGON_A2_sxtb
    new BuiltinEntry(ID.hexagon_A2_sxth, 4050),  // __builtin_HEXAGON_A2_sxth
    new BuiltinEntry(ID.hexagon_A2_sxtw, 4076),  // __builtin_HEXAGON_A2_sxtw
    new BuiltinEntry(ID.hexagon_A2_tfr, 4102),  // __builtin_HEXAGON_A2_tfr
    new BuiltinEntry(ID.hexagon_A2_tfrih, 4127),  // __builtin_HEXAGON_A2_tfrih
    new BuiltinEntry(ID.hexagon_A2_tfril, 4154),  // __builtin_HEXAGON_A2_tfril
    new BuiltinEntry(ID.hexagon_A2_tfrp, 4181),  // __builtin_HEXAGON_A2_tfrp
    new BuiltinEntry(ID.hexagon_A2_tfrpi, 4207),  // __builtin_HEXAGON_A2_tfrpi
    new BuiltinEntry(ID.hexagon_A2_tfrsi, 4234),  // __builtin_HEXAGON_A2_tfrsi
    new BuiltinEntry(ID.hexagon_A2_vabsh, 4261),  // __builtin_HEXAGON_A2_vabsh
    new BuiltinEntry(ID.hexagon_A2_vabshsat, 4288),  // __builtin_HEXAGON_A2_vabshsat
    new BuiltinEntry(ID.hexagon_A2_vabsw, 4318),  // __builtin_HEXAGON_A2_vabsw
    new BuiltinEntry(ID.hexagon_A2_vabswsat, 4345),  // __builtin_HEXAGON_A2_vabswsat
    new BuiltinEntry(ID.hexagon_A2_vaddb_map, 4375),  // __builtin_HEXAGON_A2_vaddb_map
    new BuiltinEntry(ID.hexagon_A2_vaddh, 4406),  // __builtin_HEXAGON_A2_vaddh
    new BuiltinEntry(ID.hexagon_A2_vaddhs, 4433),  // __builtin_HEXAGON_A2_vaddhs
    new BuiltinEntry(ID.hexagon_A2_vaddub, 4461),  // __builtin_HEXAGON_A2_vaddub
    new BuiltinEntry(ID.hexagon_A2_vaddubs, 4489),  // __builtin_HEXAGON_A2_vaddubs
    new BuiltinEntry(ID.hexagon_A2_vadduhs, 4518),  // __builtin_HEXAGON_A2_vadduhs
    new BuiltinEntry(ID.hexagon_A2_vaddw, 4547),  // __builtin_HEXAGON_A2_vaddw
    new BuiltinEntry(ID.hexagon_A2_vaddws, 4574),  // __builtin_HEXAGON_A2_vaddws
    new BuiltinEntry(ID.hexagon_A2_vavgh, 4602),  // __builtin_HEXAGON_A2_vavgh
    new BuiltinEntry(ID.hexagon_A2_vavghcr, 4629),  // __builtin_HEXAGON_A2_vavghcr
    new BuiltinEntry(ID.hexagon_A2_vavghr, 4658),  // __builtin_HEXAGON_A2_vavghr
    new BuiltinEntry(ID.hexagon_A2_vavgub, 4686),  // __builtin_HEXAGON_A2_vavgub
    new BuiltinEntry(ID.hexagon_A2_vavgubr, 4714),  // __builtin_HEXAGON_A2_vavgubr
    new BuiltinEntry(ID.hexagon_A2_vavguh, 4743),  // __builtin_HEXAGON_A2_vavguh
    new BuiltinEntry(ID.hexagon_A2_vavguhr, 4771),  // __builtin_HEXAGON_A2_vavguhr
    new BuiltinEntry(ID.hexagon_A2_vavguw, 4800),  // __builtin_HEXAGON_A2_vavguw
    new BuiltinEntry(ID.hexagon_A2_vavguwr, 4828),  // __builtin_HEXAGON_A2_vavguwr
    new BuiltinEntry(ID.hexagon_A2_vavgw, 4857),  // __builtin_HEXAGON_A2_vavgw
    new BuiltinEntry(ID.hexagon_A2_vavgwcr, 4884),  // __builtin_HEXAGON_A2_vavgwcr
    new BuiltinEntry(ID.hexagon_A2_vavgwr, 4913),  // __builtin_HEXAGON_A2_vavgwr
    new BuiltinEntry(ID.hexagon_A2_vcmpbeq, 4941),  // __builtin_HEXAGON_A2_vcmpbeq
    new BuiltinEntry(ID.hexagon_A2_vcmpbgtu, 4970),  // __builtin_HEXAGON_A2_vcmpbgtu
    new BuiltinEntry(ID.hexagon_A2_vcmpheq, 5000),  // __builtin_HEXAGON_A2_vcmpheq
    new BuiltinEntry(ID.hexagon_A2_vcmphgt, 5029),  // __builtin_HEXAGON_A2_vcmphgt
    new BuiltinEntry(ID.hexagon_A2_vcmphgtu, 5058),  // __builtin_HEXAGON_A2_vcmphgtu
    new BuiltinEntry(ID.hexagon_A2_vcmpweq, 5088),  // __builtin_HEXAGON_A2_vcmpweq
    new BuiltinEntry(ID.hexagon_A2_vcmpwgt, 5117),  // __builtin_HEXAGON_A2_vcmpwgt
    new BuiltinEntry(ID.hexagon_A2_vcmpwgtu, 5146),  // __builtin_HEXAGON_A2_vcmpwgtu
    new BuiltinEntry(ID.hexagon_A2_vconj, 5176),  // __builtin_HEXAGON_A2_vconj
    new BuiltinEntry(ID.hexagon_A2_vmaxb, 5203),  // __builtin_HEXAGON_A2_vmaxb
    new BuiltinEntry(ID.hexagon_A2_vmaxh, 5230),  // __builtin_HEXAGON_A2_vmaxh
    new BuiltinEntry(ID.hexagon_A2_vmaxub, 5257),  // __builtin_HEXAGON_A2_vmaxub
    new BuiltinEntry(ID.hexagon_A2_vmaxuh, 5285),  // __builtin_HEXAGON_A2_vmaxuh
    new BuiltinEntry(ID.hexagon_A2_vmaxuw, 5313),  // __builtin_HEXAGON_A2_vmaxuw
    new BuiltinEntry(ID.hexagon_A2_vmaxw, 5341),  // __builtin_HEXAGON_A2_vmaxw
    new BuiltinEntry(ID.hexagon_A2_vminb, 5368),  // __builtin_HEXAGON_A2_vminb
    new BuiltinEntry(ID.hexagon_A2_vminh, 5395),  // __builtin_HEXAGON_A2_vminh
    new BuiltinEntry(ID.hexagon_A2_vminub, 5422),  // __builtin_HEXAGON_A2_vminub
    new BuiltinEntry(ID.hexagon_A2_vminuh, 5450),  // __builtin_HEXAGON_A2_vminuh
    new BuiltinEntry(ID.hexagon_A2_vminuw, 5478),  // __builtin_HEXAGON_A2_vminuw
    new BuiltinEntry(ID.hexagon_A2_vminw, 5506),  // __builtin_HEXAGON_A2_vminw
    new BuiltinEntry(ID.hexagon_A2_vnavgh, 5533),  // __builtin_HEXAGON_A2_vnavgh
    new BuiltinEntry(ID.hexagon_A2_vnavghcr, 5561),  // __builtin_HEXAGON_A2_vnavghcr
    new BuiltinEntry(ID.hexagon_A2_vnavghr, 5591),  // __builtin_HEXAGON_A2_vnavghr
    new BuiltinEntry(ID.hexagon_A2_vnavgw, 5620),  // __builtin_HEXAGON_A2_vnavgw
    new BuiltinEntry(ID.hexagon_A2_vnavgwcr, 5648),  // __builtin_HEXAGON_A2_vnavgwcr
    new BuiltinEntry(ID.hexagon_A2_vnavgwr, 5678),  // __builtin_HEXAGON_A2_vnavgwr
    new BuiltinEntry(ID.hexagon_A2_vraddub, 5707),  // __builtin_HEXAGON_A2_vraddub
    new BuiltinEntry(ID.hexagon_A2_vraddub_acc, 5736),  // __builtin_HEXAGON_A2_vraddub_acc
    new BuiltinEntry(ID.hexagon_A2_vrsadub, 5769),  // __builtin_HEXAGON_A2_vrsadub
    new BuiltinEntry(ID.hexagon_A2_vrsadub_acc, 5798),  // __builtin_HEXAGON_A2_vrsadub_acc
    new BuiltinEntry(ID.hexagon_A2_vsubb_map, 5831),  // __builtin_HEXAGON_A2_vsubb_map
    new BuiltinEntry(ID.hexagon_A2_vsubh, 5862),  // __builtin_HEXAGON_A2_vsubh
    new BuiltinEntry(ID.hexagon_A2_vsubhs, 5889),  // __builtin_HEXAGON_A2_vsubhs
    new BuiltinEntry(ID.hexagon_A2_vsubub, 5917),  // __builtin_HEXAGON_A2_vsubub
    new BuiltinEntry(ID.hexagon_A2_vsububs, 5945),  // __builtin_HEXAGON_A2_vsububs
    new BuiltinEntry(ID.hexagon_A2_vsubuhs, 5974),  // __builtin_HEXAGON_A2_vsubuhs
    new BuiltinEntry(ID.hexagon_A2_vsubw, 6003),  // __builtin_HEXAGON_A2_vsubw
    new BuiltinEntry(ID.hexagon_A2_vsubws, 6030),  // __builtin_HEXAGON_A2_vsubws
    new BuiltinEntry(ID.hexagon_A2_xor, 6058),  // __builtin_HEXAGON_A2_xor
    new BuiltinEntry(ID.hexagon_A2_xorp, 6083),  // __builtin_HEXAGON_A2_xorp
    new BuiltinEntry(ID.hexagon_A2_zxtb, 6109),  // __builtin_HEXAGON_A2_zxtb
    new BuiltinEntry(ID.hexagon_A2_zxth, 6135),  // __builtin_HEXAGON_A2_zxth
    new BuiltinEntry(ID.hexagon_A4_andn, 6161),  // __builtin_HEXAGON_A4_andn
    new BuiltinEntry(ID.hexagon_A4_andnp, 6187),  // __builtin_HEXAGON_A4_andnp
    new BuiltinEntry(ID.hexagon_A4_bitsplit, 6214),  // __builtin_HEXAGON_A4_bitsplit
    new BuiltinEntry(ID.hexagon_A4_bitspliti, 6244),  // __builtin_HEXAGON_A4_bitspliti
    new BuiltinEntry(ID.hexagon_A4_boundscheck, 6275),  // __builtin_HEXAGON_A4_boundscheck
    new BuiltinEntry(ID.hexagon_A4_cmpbeq, 6308),  // __builtin_HEXAGON_A4_cmpbeq
    new BuiltinEntry(ID.hexagon_A4_cmpbeqi, 6336),  // __builtin_HEXAGON_A4_cmpbeqi
    new BuiltinEntry(ID.hexagon_A4_cmpbgt, 6365),  // __builtin_HEXAGON_A4_cmpbgt
    new BuiltinEntry(ID.hexagon_A4_cmpbgti, 6393),  // __builtin_HEXAGON_A4_cmpbgti
    new BuiltinEntry(ID.hexagon_A4_cmpbgtu, 6422),  // __builtin_HEXAGON_A4_cmpbgtu
    new BuiltinEntry(ID.hexagon_A4_cmpbgtui, 6451),  // __builtin_HEXAGON_A4_cmpbgtui
    new BuiltinEntry(ID.hexagon_A4_cmpheq, 6481),  // __builtin_HEXAGON_A4_cmpheq
    new BuiltinEntry(ID.hexagon_A4_cmpheqi, 6509),  // __builtin_HEXAGON_A4_cmpheqi
    new BuiltinEntry(ID.hexagon_A4_cmphgt, 6538),  // __builtin_HEXAGON_A4_cmphgt
    new BuiltinEntry(ID.hexagon_A4_cmphgti, 6566),  // __builtin_HEXAGON_A4_cmphgti
    new BuiltinEntry(ID.hexagon_A4_cmphgtu, 6595),  // __builtin_HEXAGON_A4_cmphgtu
    new BuiltinEntry(ID.hexagon_A4_cmphgtui, 6624),  // __builtin_HEXAGON_A4_cmphgtui
    new BuiltinEntry(ID.hexagon_A4_combineir, 6654),  // __builtin_HEXAGON_A4_combineir
    new BuiltinEntry(ID.hexagon_A4_combineri, 6685),  // __builtin_HEXAGON_A4_combineri
    new BuiltinEntry(ID.hexagon_A4_cround_ri, 6716),  // __builtin_HEXAGON_A4_cround_ri
    new BuiltinEntry(ID.hexagon_A4_cround_rr, 6747),  // __builtin_HEXAGON_A4_cround_rr
    new BuiltinEntry(ID.hexagon_A4_modwrapu, 6778),  // __builtin_HEXAGON_A4_modwrapu
    new BuiltinEntry(ID.hexagon_A4_orn, 6808),  // __builtin_HEXAGON_A4_orn
    new BuiltinEntry(ID.hexagon_A4_ornp, 6833),  // __builtin_HEXAGON_A4_ornp
    new BuiltinEntry(ID.hexagon_A4_rcmpeq, 6859),  // __builtin_HEXAGON_A4_rcmpeq
    new BuiltinEntry(ID.hexagon_A4_rcmpeqi, 6887),  // __builtin_HEXAGON_A4_rcmpeqi
    new BuiltinEntry(ID.hexagon_A4_rcmpneq, 6916),  // __builtin_HEXAGON_A4_rcmpneq
    new BuiltinEntry(ID.hexagon_A4_rcmpneqi, 6945),  // __builtin_HEXAGON_A4_rcmpneqi
    new BuiltinEntry(ID.hexagon_A4_round_ri, 6975),  // __builtin_HEXAGON_A4_round_ri
    new BuiltinEntry(ID.hexagon_A4_round_ri_sat, 7005),  // __builtin_HEXAGON_A4_round_ri_sat
    new BuiltinEntry(ID.hexagon_A4_round_rr, 7039),  // __builtin_HEXAGON_A4_round_rr
    new BuiltinEntry(ID.hexagon_A4_round_rr_sat, 7069),  // __builtin_HEXAGON_A4_round_rr_sat
    new BuiltinEntry(ID.hexagon_A4_tlbmatch, 7103),  // __builtin_HEXAGON_A4_tlbmatch
    new BuiltinEntry(ID.hexagon_A4_vcmpbeq_any, 7133),  // __builtin_HEXAGON_A4_vcmpbeq_any
    new BuiltinEntry(ID.hexagon_A4_vcmpbeqi, 7166),  // __builtin_HEXAGON_A4_vcmpbeqi
    new BuiltinEntry(ID.hexagon_A4_vcmpbgt, 7196),  // __builtin_HEXAGON_A4_vcmpbgt
    new BuiltinEntry(ID.hexagon_A4_vcmpbgti, 7225),  // __builtin_HEXAGON_A4_vcmpbgti
    new BuiltinEntry(ID.hexagon_A4_vcmpbgtui, 7255),  // __builtin_HEXAGON_A4_vcmpbgtui
    new BuiltinEntry(ID.hexagon_A4_vcmpheqi, 7286),  // __builtin_HEXAGON_A4_vcmpheqi
    new BuiltinEntry(ID.hexagon_A4_vcmphgti, 7316),  // __builtin_HEXAGON_A4_vcmphgti
    new BuiltinEntry(ID.hexagon_A4_vcmphgtui, 7346),  // __builtin_HEXAGON_A4_vcmphgtui
    new BuiltinEntry(ID.hexagon_A4_vcmpweqi, 7377),  // __builtin_HEXAGON_A4_vcmpweqi
    new BuiltinEntry(ID.hexagon_A4_vcmpwgti, 7407),  // __builtin_HEXAGON_A4_vcmpwgti
    new BuiltinEntry(ID.hexagon_A4_vcmpwgtui, 7437),  // __builtin_HEXAGON_A4_vcmpwgtui
    new BuiltinEntry(ID.hexagon_A4_vrmaxh, 7468),  // __builtin_HEXAGON_A4_vrmaxh
    new BuiltinEntry(ID.hexagon_A4_vrmaxuh, 7496),  // __builtin_HEXAGON_A4_vrmaxuh
    new BuiltinEntry(ID.hexagon_A4_vrmaxuw, 7525),  // __builtin_HEXAGON_A4_vrmaxuw
    new BuiltinEntry(ID.hexagon_A4_vrmaxw, 7554),  // __builtin_HEXAGON_A4_vrmaxw
    new BuiltinEntry(ID.hexagon_A4_vrminh, 7582),  // __builtin_HEXAGON_A4_vrminh
    new BuiltinEntry(ID.hexagon_A4_vrminuh, 7610),  // __builtin_HEXAGON_A4_vrminuh
    new BuiltinEntry(ID.hexagon_A4_vrminuw, 7639),  // __builtin_HEXAGON_A4_vrminuw
    new BuiltinEntry(ID.hexagon_A4_vrminw, 7668),  // __builtin_HEXAGON_A4_vrminw
    new BuiltinEntry(ID.hexagon_A5_vaddhubs, 7696),  // __builtin_HEXAGON_A5_vaddhubs
    new BuiltinEntry(ID.hexagon_C2_all8, 7726),  // __builtin_HEXAGON_C2_all8
    new BuiltinEntry(ID.hexagon_C2_and, 7752),  // __builtin_HEXAGON_C2_and
    new BuiltinEntry(ID.hexagon_C2_andn, 7777),  // __builtin_HEXAGON_C2_andn
    new BuiltinEntry(ID.hexagon_C2_any8, 7803),  // __builtin_HEXAGON_C2_any8
    new BuiltinEntry(ID.hexagon_C2_bitsclr, 7829),  // __builtin_HEXAGON_C2_bitsclr
    new BuiltinEntry(ID.hexagon_C2_bitsclri, 7858),  // __builtin_HEXAGON_C2_bitsclri
    new BuiltinEntry(ID.hexagon_C2_bitsset, 7888),  // __builtin_HEXAGON_C2_bitsset
    new BuiltinEntry(ID.hexagon_C2_cmpeq, 7917),  // __builtin_HEXAGON_C2_cmpeq
    new BuiltinEntry(ID.hexagon_C2_cmpeqi, 7944),  // __builtin_HEXAGON_C2_cmpeqi
    new BuiltinEntry(ID.hexagon_C2_cmpeqp, 7972),  // __builtin_HEXAGON_C2_cmpeqp
    new BuiltinEntry(ID.hexagon_C2_cmpgei, 8000),  // __builtin_HEXAGON_C2_cmpgei
    new BuiltinEntry(ID.hexagon_C2_cmpgeui, 8028),  // __builtin_HEXAGON_C2_cmpgeui
    new BuiltinEntry(ID.hexagon_C2_cmpgt, 8057),  // __builtin_HEXAGON_C2_cmpgt
    new BuiltinEntry(ID.hexagon_C2_cmpgti, 8084),  // __builtin_HEXAGON_C2_cmpgti
    new BuiltinEntry(ID.hexagon_C2_cmpgtp, 8112),  // __builtin_HEXAGON_C2_cmpgtp
    new BuiltinEntry(ID.hexagon_C2_cmpgtu, 8140),  // __builtin_HEXAGON_C2_cmpgtu
    new BuiltinEntry(ID.hexagon_C2_cmpgtui, 8168),  // __builtin_HEXAGON_C2_cmpgtui
    new BuiltinEntry(ID.hexagon_C2_cmpgtup, 8197),  // __builtin_HEXAGON_C2_cmpgtup
    new BuiltinEntry(ID.hexagon_C2_cmplt, 8226),  // __builtin_HEXAGON_C2_cmplt
    new BuiltinEntry(ID.hexagon_C2_cmpltu, 8253),  // __builtin_HEXAGON_C2_cmpltu
    new BuiltinEntry(ID.hexagon_C2_mask, 8281),  // __builtin_HEXAGON_C2_mask
    new BuiltinEntry(ID.hexagon_C2_mux, 8307),  // __builtin_HEXAGON_C2_mux
    new BuiltinEntry(ID.hexagon_C2_muxii, 8332),  // __builtin_HEXAGON_C2_muxii
    new BuiltinEntry(ID.hexagon_C2_muxir, 8359),  // __builtin_HEXAGON_C2_muxir
    new BuiltinEntry(ID.hexagon_C2_muxri, 8386),  // __builtin_HEXAGON_C2_muxri
    new BuiltinEntry(ID.hexagon_C2_not, 8413),  // __builtin_HEXAGON_C2_not
    new BuiltinEntry(ID.hexagon_C2_or, 8438),  // __builtin_HEXAGON_C2_or
    new BuiltinEntry(ID.hexagon_C2_orn, 8462),  // __builtin_HEXAGON_C2_orn
    new BuiltinEntry(ID.hexagon_C2_pxfer_map, 8487),  // __builtin_HEXAGON_C2_pxfer_map
    new BuiltinEntry(ID.hexagon_C2_tfrpr, 8518),  // __builtin_HEXAGON_C2_tfrpr
    new BuiltinEntry(ID.hexagon_C2_tfrrp, 8545),  // __builtin_HEXAGON_C2_tfrrp
    new BuiltinEntry(ID.hexagon_C2_vitpack, 8572),  // __builtin_HEXAGON_C2_vitpack
    new BuiltinEntry(ID.hexagon_C2_vmux, 8601),  // __builtin_HEXAGON_C2_vmux
    new BuiltinEntry(ID.hexagon_C2_xor, 8627),  // __builtin_HEXAGON_C2_xor
    new BuiltinEntry(ID.hexagon_C4_and_and, 8652),  // __builtin_HEXAGON_C4_and_and
    new BuiltinEntry(ID.hexagon_C4_and_andn, 8681),  // __builtin_HEXAGON_C4_and_andn
    new BuiltinEntry(ID.hexagon_C4_and_or, 8711),  // __builtin_HEXAGON_C4_and_or
    new BuiltinEntry(ID.hexagon_C4_and_orn, 8739),  // __builtin_HEXAGON_C4_and_orn
    new BuiltinEntry(ID.hexagon_C4_cmplte, 8768),  // __builtin_HEXAGON_C4_cmplte
    new BuiltinEntry(ID.hexagon_C4_cmpltei, 8796),  // __builtin_HEXAGON_C4_cmpltei
    new BuiltinEntry(ID.hexagon_C4_cmplteu, 8825),  // __builtin_HEXAGON_C4_cmplteu
    new BuiltinEntry(ID.hexagon_C4_cmplteui, 8854),  // __builtin_HEXAGON_C4_cmplteui
    new BuiltinEntry(ID.hexagon_C4_cmpneq, 8884),  // __builtin_HEXAGON_C4_cmpneq
    new BuiltinEntry(ID.hexagon_C4_cmpneqi, 8912),  // __builtin_HEXAGON_C4_cmpneqi
    new BuiltinEntry(ID.hexagon_C4_fastcorner9, 8941),  // __builtin_HEXAGON_C4_fastcorner9
    new BuiltinEntry(ID.hexagon_C4_fastcorner9_not, 8974),  // __builtin_HEXAGON_C4_fastcorner9_not
    new BuiltinEntry(ID.hexagon_C4_nbitsclr, 9011),  // __builtin_HEXAGON_C4_nbitsclr
    new BuiltinEntry(ID.hexagon_C4_nbitsclri, 9041),  // __builtin_HEXAGON_C4_nbitsclri
    new BuiltinEntry(ID.hexagon_C4_nbitsset, 9072),  // __builtin_HEXAGON_C4_nbitsset
    new BuiltinEntry(ID.hexagon_C4_or_and, 9102),  // __builtin_HEXAGON_C4_or_and
    new BuiltinEntry(ID.hexagon_C4_or_andn, 9130),  // __builtin_HEXAGON_C4_or_andn
    new BuiltinEntry(ID.hexagon_C4_or_or, 9159),  // __builtin_HEXAGON_C4_or_or
    new BuiltinEntry(ID.hexagon_C4_or_orn, 9186),  // __builtin_HEXAGON_C4_or_orn
    new BuiltinEntry(ID.hexagon_F2_conv_d2df, 9214),  // __builtin_HEXAGON_F2_conv_d2df
    new BuiltinEntry(ID.hexagon_F2_conv_d2sf, 9245),  // __builtin_HEXAGON_F2_conv_d2sf
    new BuiltinEntry(ID.hexagon_F2_conv_df2d, 9276),  // __builtin_HEXAGON_F2_conv_df2d
    new BuiltinEntry(ID.hexagon_F2_conv_df2d_chop, 9307),  // __builtin_HEXAGON_F2_conv_df2d_chop
    new BuiltinEntry(ID.hexagon_F2_conv_df2sf, 9343),  // __builtin_HEXAGON_F2_conv_df2sf
    new BuiltinEntry(ID.hexagon_F2_conv_df2ud, 9375),  // __builtin_HEXAGON_F2_conv_df2ud
    new BuiltinEntry(ID.hexagon_F2_conv_df2ud_chop, 9407),  // __builtin_HEXAGON_F2_conv_df2ud_chop
    new BuiltinEntry(ID.hexagon_F2_conv_df2uw, 9444),  // __builtin_HEXAGON_F2_conv_df2uw
    new BuiltinEntry(ID.hexagon_F2_conv_df2uw_chop, 9476),  // __builtin_HEXAGON_F2_conv_df2uw_chop
    new BuiltinEntry(ID.hexagon_F2_conv_df2w, 9513),  // __builtin_HEXAGON_F2_conv_df2w
    new BuiltinEntry(ID.hexagon_F2_conv_df2w_chop, 9544),  // __builtin_HEXAGON_F2_conv_df2w_chop
    new BuiltinEntry(ID.hexagon_F2_conv_sf2d, 9580),  // __builtin_HEXAGON_F2_conv_sf2d
    new BuiltinEntry(ID.hexagon_F2_conv_sf2d_chop, 9611),  // __builtin_HEXAGON_F2_conv_sf2d_chop
    new BuiltinEntry(ID.hexagon_F2_conv_sf2df, 9647),  // __builtin_HEXAGON_F2_conv_sf2df
    new BuiltinEntry(ID.hexagon_F2_conv_sf2ud, 9679),  // __builtin_HEXAGON_F2_conv_sf2ud
    new BuiltinEntry(ID.hexagon_F2_conv_sf2ud_chop, 9711),  // __builtin_HEXAGON_F2_conv_sf2ud_chop
    new BuiltinEntry(ID.hexagon_F2_conv_sf2uw, 9748),  // __builtin_HEXAGON_F2_conv_sf2uw
    new BuiltinEntry(ID.hexagon_F2_conv_sf2uw_chop, 9780),  // __builtin_HEXAGON_F2_conv_sf2uw_chop
    new BuiltinEntry(ID.hexagon_F2_conv_sf2w, 9817),  // __builtin_HEXAGON_F2_conv_sf2w
    new BuiltinEntry(ID.hexagon_F2_conv_sf2w_chop, 9848),  // __builtin_HEXAGON_F2_conv_sf2w_chop
    new BuiltinEntry(ID.hexagon_F2_conv_ud2df, 9884),  // __builtin_HEXAGON_F2_conv_ud2df
    new BuiltinEntry(ID.hexagon_F2_conv_ud2sf, 9916),  // __builtin_HEXAGON_F2_conv_ud2sf
    new BuiltinEntry(ID.hexagon_F2_conv_uw2df, 9948),  // __builtin_HEXAGON_F2_conv_uw2df
    new BuiltinEntry(ID.hexagon_F2_conv_uw2sf, 9980),  // __builtin_HEXAGON_F2_conv_uw2sf
    new BuiltinEntry(ID.hexagon_F2_conv_w2df, 10012),  // __builtin_HEXAGON_F2_conv_w2df
    new BuiltinEntry(ID.hexagon_F2_conv_w2sf, 10043),  // __builtin_HEXAGON_F2_conv_w2sf
    new BuiltinEntry(ID.hexagon_F2_dfclass, 10074),  // __builtin_HEXAGON_F2_dfclass
    new BuiltinEntry(ID.hexagon_F2_dfcmpeq, 10103),  // __builtin_HEXAGON_F2_dfcmpeq
    new BuiltinEntry(ID.hexagon_F2_dfcmpge, 10132),  // __builtin_HEXAGON_F2_dfcmpge
    new BuiltinEntry(ID.hexagon_F2_dfcmpgt, 10161),  // __builtin_HEXAGON_F2_dfcmpgt
    new BuiltinEntry(ID.hexagon_F2_dfcmpuo, 10190),  // __builtin_HEXAGON_F2_dfcmpuo
    new BuiltinEntry(ID.hexagon_F2_dfimm_n, 10219),  // __builtin_HEXAGON_F2_dfimm_n
    new BuiltinEntry(ID.hexagon_F2_dfimm_p, 10248),  // __builtin_HEXAGON_F2_dfimm_p
    new BuiltinEntry(ID.hexagon_F2_sfadd, 10277),  // __builtin_HEXAGON_F2_sfadd
    new BuiltinEntry(ID.hexagon_F2_sfclass, 10304),  // __builtin_HEXAGON_F2_sfclass
    new BuiltinEntry(ID.hexagon_F2_sfcmpeq, 10333),  // __builtin_HEXAGON_F2_sfcmpeq
    new BuiltinEntry(ID.hexagon_F2_sfcmpge, 10362),  // __builtin_HEXAGON_F2_sfcmpge
    new BuiltinEntry(ID.hexagon_F2_sfcmpgt, 10391),  // __builtin_HEXAGON_F2_sfcmpgt
    new BuiltinEntry(ID.hexagon_F2_sfcmpuo, 10420),  // __builtin_HEXAGON_F2_sfcmpuo
    new BuiltinEntry(ID.hexagon_F2_sffixupd, 10449),  // __builtin_HEXAGON_F2_sffixupd
    new BuiltinEntry(ID.hexagon_F2_sffixupn, 10479),  // __builtin_HEXAGON_F2_sffixupn
    new BuiltinEntry(ID.hexagon_F2_sffixupr, 10509),  // __builtin_HEXAGON_F2_sffixupr
    new BuiltinEntry(ID.hexagon_F2_sffma, 10539),  // __builtin_HEXAGON_F2_sffma
    new BuiltinEntry(ID.hexagon_F2_sffma_lib, 10566),  // __builtin_HEXAGON_F2_sffma_lib
    new BuiltinEntry(ID.hexagon_F2_sffma_sc, 10597),  // __builtin_HEXAGON_F2_sffma_sc
    new BuiltinEntry(ID.hexagon_F2_sffms, 10627),  // __builtin_HEXAGON_F2_sffms
    new BuiltinEntry(ID.hexagon_F2_sffms_lib, 10654),  // __builtin_HEXAGON_F2_sffms_lib
    new BuiltinEntry(ID.hexagon_F2_sfimm_n, 10685),  // __builtin_HEXAGON_F2_sfimm_n
    new BuiltinEntry(ID.hexagon_F2_sfimm_p, 10714),  // __builtin_HEXAGON_F2_sfimm_p
    new BuiltinEntry(ID.hexagon_F2_sfmax, 10743),  // __builtin_HEXAGON_F2_sfmax
    new BuiltinEntry(ID.hexagon_F2_sfmin, 10770),  // __builtin_HEXAGON_F2_sfmin
    new BuiltinEntry(ID.hexagon_F2_sfmpy, 10797),  // __builtin_HEXAGON_F2_sfmpy
    new BuiltinEntry(ID.hexagon_F2_sfsub, 10824),  // __builtin_HEXAGON_F2_sfsub
    new BuiltinEntry(ID.hexagon_L2_loadw_locked, 10851),  // __builtin_HEXAGON_L2_loadw_locked
    new BuiltinEntry(ID.hexagon_L4_loadd_locked, 10885),  // __builtin_HEXAGON_L4_loadd_locked
    new BuiltinEntry(ID.hexagon_M2_acci, 10919),  // __builtin_HEXAGON_M2_acci
    new BuiltinEntry(ID.hexagon_M2_accii, 10945),  // __builtin_HEXAGON_M2_accii
    new BuiltinEntry(ID.hexagon_M2_cmaci_s0, 10972),  // __builtin_HEXAGON_M2_cmaci_s0
    new BuiltinEntry(ID.hexagon_M2_cmacr_s0, 11002),  // __builtin_HEXAGON_M2_cmacr_s0
    new BuiltinEntry(ID.hexagon_M2_cmacs_s0, 11032),  // __builtin_HEXAGON_M2_cmacs_s0
    new BuiltinEntry(ID.hexagon_M2_cmacs_s1, 11062),  // __builtin_HEXAGON_M2_cmacs_s1
    new BuiltinEntry(ID.hexagon_M2_cmacsc_s0, 11092),  // __builtin_HEXAGON_M2_cmacsc_s0
    new BuiltinEntry(ID.hexagon_M2_cmacsc_s1, 11123),  // __builtin_HEXAGON_M2_cmacsc_s1
    new BuiltinEntry(ID.hexagon_M2_cmpyi_s0, 11154),  // __builtin_HEXAGON_M2_cmpyi_s0
    new BuiltinEntry(ID.hexagon_M2_cmpyr_s0, 11184),  // __builtin_HEXAGON_M2_cmpyr_s0
    new BuiltinEntry(ID.hexagon_M2_cmpyrs_s0, 11214),  // __builtin_HEXAGON_M2_cmpyrs_s0
    new BuiltinEntry(ID.hexagon_M2_cmpyrs_s1, 11245),  // __builtin_HEXAGON_M2_cmpyrs_s1
    new BuiltinEntry(ID.hexagon_M2_cmpyrsc_s0, 11276),  // __builtin_HEXAGON_M2_cmpyrsc_s0
    new BuiltinEntry(ID.hexagon_M2_cmpyrsc_s1, 11308),  // __builtin_HEXAGON_M2_cmpyrsc_s1
    new BuiltinEntry(ID.hexagon_M2_cmpys_s0, 11340),  // __builtin_HEXAGON_M2_cmpys_s0
    new BuiltinEntry(ID.hexagon_M2_cmpys_s1, 11370),  // __builtin_HEXAGON_M2_cmpys_s1
    new BuiltinEntry(ID.hexagon_M2_cmpysc_s0, 11400),  // __builtin_HEXAGON_M2_cmpysc_s0
    new BuiltinEntry(ID.hexagon_M2_cmpysc_s1, 11431),  // __builtin_HEXAGON_M2_cmpysc_s1
    new BuiltinEntry(ID.hexagon_M2_cnacs_s0, 11462),  // __builtin_HEXAGON_M2_cnacs_s0
    new BuiltinEntry(ID.hexagon_M2_cnacs_s1, 11492),  // __builtin_HEXAGON_M2_cnacs_s1
    new BuiltinEntry(ID.hexagon_M2_cnacsc_s0, 11522),  // __builtin_HEXAGON_M2_cnacsc_s0
    new BuiltinEntry(ID.hexagon_M2_cnacsc_s1, 11553),  // __builtin_HEXAGON_M2_cnacsc_s1
    new BuiltinEntry(ID.hexagon_M2_dpmpyss_acc_s0, 11584),  // __builtin_HEXAGON_M2_dpmpyss_acc_s0
    new BuiltinEntry(ID.hexagon_M2_dpmpyss_nac_s0, 11620),  // __builtin_HEXAGON_M2_dpmpyss_nac_s0
    new BuiltinEntry(ID.hexagon_M2_dpmpyss_rnd_s0, 11656),  // __builtin_HEXAGON_M2_dpmpyss_rnd_s0
    new BuiltinEntry(ID.hexagon_M2_dpmpyss_s0, 11692),  // __builtin_HEXAGON_M2_dpmpyss_s0
    new BuiltinEntry(ID.hexagon_M2_dpmpyuu_acc_s0, 11724),  // __builtin_HEXAGON_M2_dpmpyuu_acc_s0
    new BuiltinEntry(ID.hexagon_M2_dpmpyuu_nac_s0, 11760),  // __builtin_HEXAGON_M2_dpmpyuu_nac_s0
    new BuiltinEntry(ID.hexagon_M2_dpmpyuu_s0, 11796),  // __builtin_HEXAGON_M2_dpmpyuu_s0
    new BuiltinEntry(ID.hexagon_M2_hmmpyh_rs1, 11828),  // __builtin_HEXAGON_M2_hmmpyh_rs1
    new BuiltinEntry(ID.hexagon_M2_hmmpyh_s1, 11860),  // __builtin_HEXAGON_M2_hmmpyh_s1
    new BuiltinEntry(ID.hexagon_M2_hmmpyl_rs1, 11891),  // __builtin_HEXAGON_M2_hmmpyl_rs1
    new BuiltinEntry(ID.hexagon_M2_hmmpyl_s1, 11923),  // __builtin_HEXAGON_M2_hmmpyl_s1
    new BuiltinEntry(ID.hexagon_M2_maci, 11954),  // __builtin_HEXAGON_M2_maci
    new BuiltinEntry(ID.hexagon_M2_macsin, 11980),  // __builtin_HEXAGON_M2_macsin
    new BuiltinEntry(ID.hexagon_M2_macsip, 12008),  // __builtin_HEXAGON_M2_macsip
    new BuiltinEntry(ID.hexagon_M2_mmachs_rs0, 12036),  // __builtin_HEXAGON_M2_mmachs_rs0
    new BuiltinEntry(ID.hexagon_M2_mmachs_rs1, 12068),  // __builtin_HEXAGON_M2_mmachs_rs1
    new BuiltinEntry(ID.hexagon_M2_mmachs_s0, 12100),  // __builtin_HEXAGON_M2_mmachs_s0
    new BuiltinEntry(ID.hexagon_M2_mmachs_s1, 12131),  // __builtin_HEXAGON_M2_mmachs_s1
    new BuiltinEntry(ID.hexagon_M2_mmacls_rs0, 12162),  // __builtin_HEXAGON_M2_mmacls_rs0
    new BuiltinEntry(ID.hexagon_M2_mmacls_rs1, 12194),  // __builtin_HEXAGON_M2_mmacls_rs1
    new BuiltinEntry(ID.hexagon_M2_mmacls_s0, 12226),  // __builtin_HEXAGON_M2_mmacls_s0
    new BuiltinEntry(ID.hexagon_M2_mmacls_s1, 12257),  // __builtin_HEXAGON_M2_mmacls_s1
    new BuiltinEntry(ID.hexagon_M2_mmacuhs_rs0, 12288),  // __builtin_HEXAGON_M2_mmacuhs_rs0
    new BuiltinEntry(ID.hexagon_M2_mmacuhs_rs1, 12321),  // __builtin_HEXAGON_M2_mmacuhs_rs1
    new BuiltinEntry(ID.hexagon_M2_mmacuhs_s0, 12354),  // __builtin_HEXAGON_M2_mmacuhs_s0
    new BuiltinEntry(ID.hexagon_M2_mmacuhs_s1, 12386),  // __builtin_HEXAGON_M2_mmacuhs_s1
    new BuiltinEntry(ID.hexagon_M2_mmaculs_rs0, 12418),  // __builtin_HEXAGON_M2_mmaculs_rs0
    new BuiltinEntry(ID.hexagon_M2_mmaculs_rs1, 12451),  // __builtin_HEXAGON_M2_mmaculs_rs1
    new BuiltinEntry(ID.hexagon_M2_mmaculs_s0, 12484),  // __builtin_HEXAGON_M2_mmaculs_s0
    new BuiltinEntry(ID.hexagon_M2_mmaculs_s1, 12516),  // __builtin_HEXAGON_M2_mmaculs_s1
    new BuiltinEntry(ID.hexagon_M2_mmpyh_rs0, 12548),  // __builtin_HEXAGON_M2_mmpyh_rs0
    new BuiltinEntry(ID.hexagon_M2_mmpyh_rs1, 12579),  // __builtin_HEXAGON_M2_mmpyh_rs1
    new BuiltinEntry(ID.hexagon_M2_mmpyh_s0, 12610),  // __builtin_HEXAGON_M2_mmpyh_s0
    new BuiltinEntry(ID.hexagon_M2_mmpyh_s1, 12640),  // __builtin_HEXAGON_M2_mmpyh_s1
    new BuiltinEntry(ID.hexagon_M2_mmpyl_rs0, 12670),  // __builtin_HEXAGON_M2_mmpyl_rs0
    new BuiltinEntry(ID.hexagon_M2_mmpyl_rs1, 12701),  // __builtin_HEXAGON_M2_mmpyl_rs1
    new BuiltinEntry(ID.hexagon_M2_mmpyl_s0, 12732),  // __builtin_HEXAGON_M2_mmpyl_s0
    new BuiltinEntry(ID.hexagon_M2_mmpyl_s1, 12762),  // __builtin_HEXAGON_M2_mmpyl_s1
    new BuiltinEntry(ID.hexagon_M2_mmpyuh_rs0, 12792),  // __builtin_HEXAGON_M2_mmpyuh_rs0
    new BuiltinEntry(ID.hexagon_M2_mmpyuh_rs1, 12824),  // __builtin_HEXAGON_M2_mmpyuh_rs1
    new BuiltinEntry(ID.hexagon_M2_mmpyuh_s0, 12856),  // __builtin_HEXAGON_M2_mmpyuh_s0
    new BuiltinEntry(ID.hexagon_M2_mmpyuh_s1, 12887),  // __builtin_HEXAGON_M2_mmpyuh_s1
    new BuiltinEntry(ID.hexagon_M2_mmpyul_rs0, 12918),  // __builtin_HEXAGON_M2_mmpyul_rs0
    new BuiltinEntry(ID.hexagon_M2_mmpyul_rs1, 12950),  // __builtin_HEXAGON_M2_mmpyul_rs1
    new BuiltinEntry(ID.hexagon_M2_mmpyul_s0, 12982),  // __builtin_HEXAGON_M2_mmpyul_s0
    new BuiltinEntry(ID.hexagon_M2_mmpyul_s1, 13013),  // __builtin_HEXAGON_M2_mmpyul_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_hh_s0, 13044),  // __builtin_HEXAGON_M2_mpy_acc_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_hh_s1, 13079),  // __builtin_HEXAGON_M2_mpy_acc_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_hl_s0, 13114),  // __builtin_HEXAGON_M2_mpy_acc_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_hl_s1, 13149),  // __builtin_HEXAGON_M2_mpy_acc_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_lh_s0, 13184),  // __builtin_HEXAGON_M2_mpy_acc_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_lh_s1, 13219),  // __builtin_HEXAGON_M2_mpy_acc_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_ll_s0, 13254),  // __builtin_HEXAGON_M2_mpy_acc_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_ll_s1, 13289),  // __builtin_HEXAGON_M2_mpy_acc_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_sat_hh_s0, 13324),  // __builtin_HEXAGON_M2_mpy_acc_sat_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_sat_hh_s1, 13363),  // __builtin_HEXAGON_M2_mpy_acc_sat_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_sat_hl_s0, 13402),  // __builtin_HEXAGON_M2_mpy_acc_sat_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_sat_hl_s1, 13441),  // __builtin_HEXAGON_M2_mpy_acc_sat_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_sat_lh_s0, 13480),  // __builtin_HEXAGON_M2_mpy_acc_sat_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_sat_lh_s1, 13519),  // __builtin_HEXAGON_M2_mpy_acc_sat_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_sat_ll_s0, 13558),  // __builtin_HEXAGON_M2_mpy_acc_sat_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_acc_sat_ll_s1, 13597),  // __builtin_HEXAGON_M2_mpy_acc_sat_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_hh_s0, 13636),  // __builtin_HEXAGON_M2_mpy_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_hh_s1, 13667),  // __builtin_HEXAGON_M2_mpy_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_hl_s0, 13698),  // __builtin_HEXAGON_M2_mpy_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_hl_s1, 13729),  // __builtin_HEXAGON_M2_mpy_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_lh_s0, 13760),  // __builtin_HEXAGON_M2_mpy_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_lh_s1, 13791),  // __builtin_HEXAGON_M2_mpy_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_ll_s0, 13822),  // __builtin_HEXAGON_M2_mpy_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_ll_s1, 13853),  // __builtin_HEXAGON_M2_mpy_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_hh_s0, 13884),  // __builtin_HEXAGON_M2_mpy_nac_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_hh_s1, 13919),  // __builtin_HEXAGON_M2_mpy_nac_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_hl_s0, 13954),  // __builtin_HEXAGON_M2_mpy_nac_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_hl_s1, 13989),  // __builtin_HEXAGON_M2_mpy_nac_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_lh_s0, 14024),  // __builtin_HEXAGON_M2_mpy_nac_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_lh_s1, 14059),  // __builtin_HEXAGON_M2_mpy_nac_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_ll_s0, 14094),  // __builtin_HEXAGON_M2_mpy_nac_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_ll_s1, 14129),  // __builtin_HEXAGON_M2_mpy_nac_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_sat_hh_s0, 14164),  // __builtin_HEXAGON_M2_mpy_nac_sat_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_sat_hh_s1, 14203),  // __builtin_HEXAGON_M2_mpy_nac_sat_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_sat_hl_s0, 14242),  // __builtin_HEXAGON_M2_mpy_nac_sat_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_sat_hl_s1, 14281),  // __builtin_HEXAGON_M2_mpy_nac_sat_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_sat_lh_s0, 14320),  // __builtin_HEXAGON_M2_mpy_nac_sat_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_sat_lh_s1, 14359),  // __builtin_HEXAGON_M2_mpy_nac_sat_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_sat_ll_s0, 14398),  // __builtin_HEXAGON_M2_mpy_nac_sat_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_nac_sat_ll_s1, 14437),  // __builtin_HEXAGON_M2_mpy_nac_sat_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_rnd_hh_s0, 14476),  // __builtin_HEXAGON_M2_mpy_rnd_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_rnd_hh_s1, 14511),  // __builtin_HEXAGON_M2_mpy_rnd_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_rnd_hl_s0, 14546),  // __builtin_HEXAGON_M2_mpy_rnd_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_rnd_hl_s1, 14581),  // __builtin_HEXAGON_M2_mpy_rnd_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_rnd_lh_s0, 14616),  // __builtin_HEXAGON_M2_mpy_rnd_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_rnd_lh_s1, 14651),  // __builtin_HEXAGON_M2_mpy_rnd_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_rnd_ll_s0, 14686),  // __builtin_HEXAGON_M2_mpy_rnd_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_rnd_ll_s1, 14721),  // __builtin_HEXAGON_M2_mpy_rnd_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_hh_s0, 14756),  // __builtin_HEXAGON_M2_mpy_sat_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_hh_s1, 14791),  // __builtin_HEXAGON_M2_mpy_sat_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_hl_s0, 14826),  // __builtin_HEXAGON_M2_mpy_sat_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_hl_s1, 14861),  // __builtin_HEXAGON_M2_mpy_sat_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_lh_s0, 14896),  // __builtin_HEXAGON_M2_mpy_sat_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_lh_s1, 14931),  // __builtin_HEXAGON_M2_mpy_sat_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_ll_s0, 14966),  // __builtin_HEXAGON_M2_mpy_sat_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_ll_s1, 15001),  // __builtin_HEXAGON_M2_mpy_sat_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_rnd_hh_s0, 15036),  // __builtin_HEXAGON_M2_mpy_sat_rnd_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_rnd_hh_s1, 15075),  // __builtin_HEXAGON_M2_mpy_sat_rnd_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_rnd_hl_s0, 15114),  // __builtin_HEXAGON_M2_mpy_sat_rnd_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_rnd_hl_s1, 15153),  // __builtin_HEXAGON_M2_mpy_sat_rnd_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_rnd_lh_s0, 15192),  // __builtin_HEXAGON_M2_mpy_sat_rnd_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_rnd_lh_s1, 15231),  // __builtin_HEXAGON_M2_mpy_sat_rnd_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_rnd_ll_s0, 15270),  // __builtin_HEXAGON_M2_mpy_sat_rnd_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpy_sat_rnd_ll_s1, 15309),  // __builtin_HEXAGON_M2_mpy_sat_rnd_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_up, 15348),  // __builtin_HEXAGON_M2_mpy_up
    new BuiltinEntry(ID.hexagon_M2_mpy_up_s1, 15376),  // __builtin_HEXAGON_M2_mpy_up_s1
    new BuiltinEntry(ID.hexagon_M2_mpy_up_s1_sat, 15407),  // __builtin_HEXAGON_M2_mpy_up_s1_sat
    new BuiltinEntry(ID.hexagon_M2_mpyd_acc_hh_s0, 15442),  // __builtin_HEXAGON_M2_mpyd_acc_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_acc_hh_s1, 15478),  // __builtin_HEXAGON_M2_mpyd_acc_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_acc_hl_s0, 15514),  // __builtin_HEXAGON_M2_mpyd_acc_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_acc_hl_s1, 15550),  // __builtin_HEXAGON_M2_mpyd_acc_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_acc_lh_s0, 15586),  // __builtin_HEXAGON_M2_mpyd_acc_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_acc_lh_s1, 15622),  // __builtin_HEXAGON_M2_mpyd_acc_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_acc_ll_s0, 15658),  // __builtin_HEXAGON_M2_mpyd_acc_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_acc_ll_s1, 15694),  // __builtin_HEXAGON_M2_mpyd_acc_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_hh_s0, 15730),  // __builtin_HEXAGON_M2_mpyd_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_hh_s1, 15762),  // __builtin_HEXAGON_M2_mpyd_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_hl_s0, 15794),  // __builtin_HEXAGON_M2_mpyd_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_hl_s1, 15826),  // __builtin_HEXAGON_M2_mpyd_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_lh_s0, 15858),  // __builtin_HEXAGON_M2_mpyd_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_lh_s1, 15890),  // __builtin_HEXAGON_M2_mpyd_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_ll_s0, 15922),  // __builtin_HEXAGON_M2_mpyd_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_ll_s1, 15954),  // __builtin_HEXAGON_M2_mpyd_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_nac_hh_s0, 15986),  // __builtin_HEXAGON_M2_mpyd_nac_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_nac_hh_s1, 16022),  // __builtin_HEXAGON_M2_mpyd_nac_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_nac_hl_s0, 16058),  // __builtin_HEXAGON_M2_mpyd_nac_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_nac_hl_s1, 16094),  // __builtin_HEXAGON_M2_mpyd_nac_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_nac_lh_s0, 16130),  // __builtin_HEXAGON_M2_mpyd_nac_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_nac_lh_s1, 16166),  // __builtin_HEXAGON_M2_mpyd_nac_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_nac_ll_s0, 16202),  // __builtin_HEXAGON_M2_mpyd_nac_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_nac_ll_s1, 16238),  // __builtin_HEXAGON_M2_mpyd_nac_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_rnd_hh_s0, 16274),  // __builtin_HEXAGON_M2_mpyd_rnd_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_rnd_hh_s1, 16310),  // __builtin_HEXAGON_M2_mpyd_rnd_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_rnd_hl_s0, 16346),  // __builtin_HEXAGON_M2_mpyd_rnd_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_rnd_hl_s1, 16382),  // __builtin_HEXAGON_M2_mpyd_rnd_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_rnd_lh_s0, 16418),  // __builtin_HEXAGON_M2_mpyd_rnd_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_rnd_lh_s1, 16454),  // __builtin_HEXAGON_M2_mpyd_rnd_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyd_rnd_ll_s0, 16490),  // __builtin_HEXAGON_M2_mpyd_rnd_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyd_rnd_ll_s1, 16526),  // __builtin_HEXAGON_M2_mpyd_rnd_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyi, 16562),  // __builtin_HEXAGON_M2_mpyi
    new BuiltinEntry(ID.hexagon_M2_mpysmi, 16588),  // __builtin_HEXAGON_M2_mpysmi
    new BuiltinEntry(ID.hexagon_M2_mpysu_up, 16616),  // __builtin_HEXAGON_M2_mpysu_up
    new BuiltinEntry(ID.hexagon_M2_mpyu_acc_hh_s0, 16646),  // __builtin_HEXAGON_M2_mpyu_acc_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_acc_hh_s1, 16682),  // __builtin_HEXAGON_M2_mpyu_acc_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_acc_hl_s0, 16718),  // __builtin_HEXAGON_M2_mpyu_acc_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_acc_hl_s1, 16754),  // __builtin_HEXAGON_M2_mpyu_acc_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_acc_lh_s0, 16790),  // __builtin_HEXAGON_M2_mpyu_acc_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_acc_lh_s1, 16826),  // __builtin_HEXAGON_M2_mpyu_acc_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_acc_ll_s0, 16862),  // __builtin_HEXAGON_M2_mpyu_acc_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_acc_ll_s1, 16898),  // __builtin_HEXAGON_M2_mpyu_acc_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_hh_s0, 16934),  // __builtin_HEXAGON_M2_mpyu_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_hh_s1, 16966),  // __builtin_HEXAGON_M2_mpyu_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_hl_s0, 16998),  // __builtin_HEXAGON_M2_mpyu_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_hl_s1, 17030),  // __builtin_HEXAGON_M2_mpyu_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_lh_s0, 17062),  // __builtin_HEXAGON_M2_mpyu_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_lh_s1, 17094),  // __builtin_HEXAGON_M2_mpyu_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_ll_s0, 17126),  // __builtin_HEXAGON_M2_mpyu_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_ll_s1, 17158),  // __builtin_HEXAGON_M2_mpyu_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_nac_hh_s0, 17190),  // __builtin_HEXAGON_M2_mpyu_nac_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_nac_hh_s1, 17226),  // __builtin_HEXAGON_M2_mpyu_nac_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_nac_hl_s0, 17262),  // __builtin_HEXAGON_M2_mpyu_nac_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_nac_hl_s1, 17298),  // __builtin_HEXAGON_M2_mpyu_nac_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_nac_lh_s0, 17334),  // __builtin_HEXAGON_M2_mpyu_nac_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_nac_lh_s1, 17370),  // __builtin_HEXAGON_M2_mpyu_nac_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_nac_ll_s0, 17406),  // __builtin_HEXAGON_M2_mpyu_nac_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyu_nac_ll_s1, 17442),  // __builtin_HEXAGON_M2_mpyu_nac_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyu_up, 17478),  // __builtin_HEXAGON_M2_mpyu_up
    new BuiltinEntry(ID.hexagon_M2_mpyud_acc_hh_s0, 17507),  // __builtin_HEXAGON_M2_mpyud_acc_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_acc_hh_s1, 17544),  // __builtin_HEXAGON_M2_mpyud_acc_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_acc_hl_s0, 17581),  // __builtin_HEXAGON_M2_mpyud_acc_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_acc_hl_s1, 17618),  // __builtin_HEXAGON_M2_mpyud_acc_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_acc_lh_s0, 17655),  // __builtin_HEXAGON_M2_mpyud_acc_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_acc_lh_s1, 17692),  // __builtin_HEXAGON_M2_mpyud_acc_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_acc_ll_s0, 17729),  // __builtin_HEXAGON_M2_mpyud_acc_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_acc_ll_s1, 17766),  // __builtin_HEXAGON_M2_mpyud_acc_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_hh_s0, 17803),  // __builtin_HEXAGON_M2_mpyud_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_hh_s1, 17836),  // __builtin_HEXAGON_M2_mpyud_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_hl_s0, 17869),  // __builtin_HEXAGON_M2_mpyud_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_hl_s1, 17902),  // __builtin_HEXAGON_M2_mpyud_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_lh_s0, 17935),  // __builtin_HEXAGON_M2_mpyud_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_lh_s1, 17968),  // __builtin_HEXAGON_M2_mpyud_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_ll_s0, 18001),  // __builtin_HEXAGON_M2_mpyud_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_ll_s1, 18034),  // __builtin_HEXAGON_M2_mpyud_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_nac_hh_s0, 18067),  // __builtin_HEXAGON_M2_mpyud_nac_hh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_nac_hh_s1, 18104),  // __builtin_HEXAGON_M2_mpyud_nac_hh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_nac_hl_s0, 18141),  // __builtin_HEXAGON_M2_mpyud_nac_hl_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_nac_hl_s1, 18178),  // __builtin_HEXAGON_M2_mpyud_nac_hl_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_nac_lh_s0, 18215),  // __builtin_HEXAGON_M2_mpyud_nac_lh_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_nac_lh_s1, 18252),  // __builtin_HEXAGON_M2_mpyud_nac_lh_s1
    new BuiltinEntry(ID.hexagon_M2_mpyud_nac_ll_s0, 18289),  // __builtin_HEXAGON_M2_mpyud_nac_ll_s0
    new BuiltinEntry(ID.hexagon_M2_mpyud_nac_ll_s1, 18326),  // __builtin_HEXAGON_M2_mpyud_nac_ll_s1
    new BuiltinEntry(ID.hexagon_M2_mpyui, 18363),  // __builtin_HEXAGON_M2_mpyui
    new BuiltinEntry(ID.hexagon_M2_nacci, 18390),  // __builtin_HEXAGON_M2_nacci
    new BuiltinEntry(ID.hexagon_M2_naccii, 18417),  // __builtin_HEXAGON_M2_naccii
    new BuiltinEntry(ID.hexagon_M2_subacc, 18445),  // __builtin_HEXAGON_M2_subacc
    new BuiltinEntry(ID.hexagon_M2_vabsdiffh, 18473),  // __builtin_HEXAGON_M2_vabsdiffh
    new BuiltinEntry(ID.hexagon_M2_vabsdiffw, 18504),  // __builtin_HEXAGON_M2_vabsdiffw
    new BuiltinEntry(ID.hexagon_M2_vcmac_s0_sat_i, 18535),  // __builtin_HEXAGON_M2_vcmac_s0_sat_i
    new BuiltinEntry(ID.hexagon_M2_vcmac_s0_sat_r, 18571),  // __builtin_HEXAGON_M2_vcmac_s0_sat_r
    new BuiltinEntry(ID.hexagon_M2_vcmpy_s0_sat_i, 18607),  // __builtin_HEXAGON_M2_vcmpy_s0_sat_i
    new BuiltinEntry(ID.hexagon_M2_vcmpy_s0_sat_r, 18643),  // __builtin_HEXAGON_M2_vcmpy_s0_sat_r
    new BuiltinEntry(ID.hexagon_M2_vcmpy_s1_sat_i, 18679),  // __builtin_HEXAGON_M2_vcmpy_s1_sat_i
    new BuiltinEntry(ID.hexagon_M2_vcmpy_s1_sat_r, 18715),  // __builtin_HEXAGON_M2_vcmpy_s1_sat_r
    new BuiltinEntry(ID.hexagon_M2_vdmacs_s0, 18751),  // __builtin_HEXAGON_M2_vdmacs_s0
    new BuiltinEntry(ID.hexagon_M2_vdmacs_s1, 18782),  // __builtin_HEXAGON_M2_vdmacs_s1
    new BuiltinEntry(ID.hexagon_M2_vdmpyrs_s0, 18813),  // __builtin_HEXAGON_M2_vdmpyrs_s0
    new BuiltinEntry(ID.hexagon_M2_vdmpyrs_s1, 18845),  // __builtin_HEXAGON_M2_vdmpyrs_s1
    new BuiltinEntry(ID.hexagon_M2_vdmpys_s0, 18877),  // __builtin_HEXAGON_M2_vdmpys_s0
    new BuiltinEntry(ID.hexagon_M2_vdmpys_s1, 18908),  // __builtin_HEXAGON_M2_vdmpys_s1
    new BuiltinEntry(ID.hexagon_M2_vmac2, 18939),  // __builtin_HEXAGON_M2_vmac2
    new BuiltinEntry(ID.hexagon_M2_vmac2es, 18966),  // __builtin_HEXAGON_M2_vmac2es
    new BuiltinEntry(ID.hexagon_M2_vmac2es_s0, 18995),  // __builtin_HEXAGON_M2_vmac2es_s0
    new BuiltinEntry(ID.hexagon_M2_vmac2es_s1, 19027),  // __builtin_HEXAGON_M2_vmac2es_s1
    new BuiltinEntry(ID.hexagon_M2_vmac2s_s0, 19059),  // __builtin_HEXAGON_M2_vmac2s_s0
    new BuiltinEntry(ID.hexagon_M2_vmac2s_s1, 19090),  // __builtin_HEXAGON_M2_vmac2s_s1
    new BuiltinEntry(ID.hexagon_M2_vmac2su_s0, 19121),  // __builtin_HEXAGON_M2_vmac2su_s0
    new BuiltinEntry(ID.hexagon_M2_vmac2su_s1, 19153),  // __builtin_HEXAGON_M2_vmac2su_s1
    new BuiltinEntry(ID.hexagon_M2_vmpy2es_s0, 19185),  // __builtin_HEXAGON_M2_vmpy2es_s0
    new BuiltinEntry(ID.hexagon_M2_vmpy2es_s1, 19217),  // __builtin_HEXAGON_M2_vmpy2es_s1
    new BuiltinEntry(ID.hexagon_M2_vmpy2s_s0, 19249),  // __builtin_HEXAGON_M2_vmpy2s_s0
    new BuiltinEntry(ID.hexagon_M2_vmpy2s_s0pack, 19280),  // __builtin_HEXAGON_M2_vmpy2s_s0pack
    new BuiltinEntry(ID.hexagon_M2_vmpy2s_s1, 19315),  // __builtin_HEXAGON_M2_vmpy2s_s1
    new BuiltinEntry(ID.hexagon_M2_vmpy2s_s1pack, 19346),  // __builtin_HEXAGON_M2_vmpy2s_s1pack
    new BuiltinEntry(ID.hexagon_M2_vmpy2su_s0, 19381),  // __builtin_HEXAGON_M2_vmpy2su_s0
    new BuiltinEntry(ID.hexagon_M2_vmpy2su_s1, 19413),  // __builtin_HEXAGON_M2_vmpy2su_s1
    new BuiltinEntry(ID.hexagon_M2_vraddh, 19445),  // __builtin_HEXAGON_M2_vraddh
    new BuiltinEntry(ID.hexagon_M2_vradduh, 19473),  // __builtin_HEXAGON_M2_vradduh
    new BuiltinEntry(ID.hexagon_M2_vrcmaci_s0, 19502),  // __builtin_HEXAGON_M2_vrcmaci_s0
    new BuiltinEntry(ID.hexagon_M2_vrcmaci_s0c, 19534),  // __builtin_HEXAGON_M2_vrcmaci_s0c
    new BuiltinEntry(ID.hexagon_M2_vrcmacr_s0, 19567),  // __builtin_HEXAGON_M2_vrcmacr_s0
    new BuiltinEntry(ID.hexagon_M2_vrcmacr_s0c, 19599),  // __builtin_HEXAGON_M2_vrcmacr_s0c
    new BuiltinEntry(ID.hexagon_M2_vrcmpyi_s0, 19632),  // __builtin_HEXAGON_M2_vrcmpyi_s0
    new BuiltinEntry(ID.hexagon_M2_vrcmpyi_s0c, 19664),  // __builtin_HEXAGON_M2_vrcmpyi_s0c
    new BuiltinEntry(ID.hexagon_M2_vrcmpyr_s0, 19697),  // __builtin_HEXAGON_M2_vrcmpyr_s0
    new BuiltinEntry(ID.hexagon_M2_vrcmpyr_s0c, 19729),  // __builtin_HEXAGON_M2_vrcmpyr_s0c
    new BuiltinEntry(ID.hexagon_M2_vrcmpys_acc_s1, 19762),  // __builtin_HEXAGON_M2_vrcmpys_acc_s1
    new BuiltinEntry(ID.hexagon_M2_vrcmpys_s1, 19798),  // __builtin_HEXAGON_M2_vrcmpys_s1
    new BuiltinEntry(ID.hexagon_M2_vrcmpys_s1rp, 19830),  // __builtin_HEXAGON_M2_vrcmpys_s1rp
    new BuiltinEntry(ID.hexagon_M2_vrmac_s0, 19864),  // __builtin_HEXAGON_M2_vrmac_s0
    new BuiltinEntry(ID.hexagon_M2_vrmpy_s0, 19894),  // __builtin_HEXAGON_M2_vrmpy_s0
    new BuiltinEntry(ID.hexagon_M2_xor_xacc, 19924),  // __builtin_HEXAGON_M2_xor_xacc
    new BuiltinEntry(ID.hexagon_M4_and_and, 19954),  // __builtin_HEXAGON_M4_and_and
    new BuiltinEntry(ID.hexagon_M4_and_andn, 19983),  // __builtin_HEXAGON_M4_and_andn
    new BuiltinEntry(ID.hexagon_M4_and_or, 20013),  // __builtin_HEXAGON_M4_and_or
    new BuiltinEntry(ID.hexagon_M4_and_xor, 20041),  // __builtin_HEXAGON_M4_and_xor
    new BuiltinEntry(ID.hexagon_M4_cmpyi_wh, 20070),  // __builtin_HEXAGON_M4_cmpyi_wh
    new BuiltinEntry(ID.hexagon_M4_cmpyi_whc, 20100),  // __builtin_HEXAGON_M4_cmpyi_whc
    new BuiltinEntry(ID.hexagon_M4_cmpyr_wh, 20131),  // __builtin_HEXAGON_M4_cmpyr_wh
    new BuiltinEntry(ID.hexagon_M4_cmpyr_whc, 20161),  // __builtin_HEXAGON_M4_cmpyr_whc
    new BuiltinEntry(ID.hexagon_M4_mac_up_s1_sat, 20192),  // __builtin_HEXAGON_M4_mac_up_s1_sat
    new BuiltinEntry(ID.hexagon_M4_mpyri_addi, 20227),  // __builtin_HEXAGON_M4_mpyri_addi
    new BuiltinEntry(ID.hexagon_M4_mpyri_addr, 20259),  // __builtin_HEXAGON_M4_mpyri_addr
    new BuiltinEntry(ID.hexagon_M4_mpyri_addr_u2, 20291),  // __builtin_HEXAGON_M4_mpyri_addr_u2
    new BuiltinEntry(ID.hexagon_M4_mpyrr_addi, 20326),  // __builtin_HEXAGON_M4_mpyrr_addi
    new BuiltinEntry(ID.hexagon_M4_mpyrr_addr, 20358),  // __builtin_HEXAGON_M4_mpyrr_addr
    new BuiltinEntry(ID.hexagon_M4_nac_up_s1_sat, 20390),  // __builtin_HEXAGON_M4_nac_up_s1_sat
    new BuiltinEntry(ID.hexagon_M4_or_and, 20425),  // __builtin_HEXAGON_M4_or_and
    new BuiltinEntry(ID.hexagon_M4_or_andn, 20453),  // __builtin_HEXAGON_M4_or_andn
    new BuiltinEntry(ID.hexagon_M4_or_or, 20482),  // __builtin_HEXAGON_M4_or_or
    new BuiltinEntry(ID.hexagon_M4_or_xor, 20509),  // __builtin_HEXAGON_M4_or_xor
    new BuiltinEntry(ID.hexagon_M4_pmpyw, 20537),  // __builtin_HEXAGON_M4_pmpyw
    new BuiltinEntry(ID.hexagon_M4_pmpyw_acc, 20564),  // __builtin_HEXAGON_M4_pmpyw_acc
    new BuiltinEntry(ID.hexagon_M4_vpmpyh, 20595),  // __builtin_HEXAGON_M4_vpmpyh
    new BuiltinEntry(ID.hexagon_M4_vpmpyh_acc, 20623),  // __builtin_HEXAGON_M4_vpmpyh_acc
    new BuiltinEntry(ID.hexagon_M4_vrmpyeh_acc_s0, 20655),  // __builtin_HEXAGON_M4_vrmpyeh_acc_s0
    new BuiltinEntry(ID.hexagon_M4_vrmpyeh_acc_s1, 20691),  // __builtin_HEXAGON_M4_vrmpyeh_acc_s1
    new BuiltinEntry(ID.hexagon_M4_vrmpyeh_s0, 20727),  // __builtin_HEXAGON_M4_vrmpyeh_s0
    new BuiltinEntry(ID.hexagon_M4_vrmpyeh_s1, 20759),  // __builtin_HEXAGON_M4_vrmpyeh_s1
    new BuiltinEntry(ID.hexagon_M4_vrmpyoh_acc_s0, 20791),  // __builtin_HEXAGON_M4_vrmpyoh_acc_s0
    new BuiltinEntry(ID.hexagon_M4_vrmpyoh_acc_s1, 20827),  // __builtin_HEXAGON_M4_vrmpyoh_acc_s1
    new BuiltinEntry(ID.hexagon_M4_vrmpyoh_s0, 20863),  // __builtin_HEXAGON_M4_vrmpyoh_s0
    new BuiltinEntry(ID.hexagon_M4_vrmpyoh_s1, 20895),  // __builtin_HEXAGON_M4_vrmpyoh_s1
    new BuiltinEntry(ID.hexagon_M4_xor_and, 20927),  // __builtin_HEXAGON_M4_xor_and
    new BuiltinEntry(ID.hexagon_M4_xor_andn, 20956),  // __builtin_HEXAGON_M4_xor_andn
    new BuiltinEntry(ID.hexagon_M4_xor_or, 20986),  // __builtin_HEXAGON_M4_xor_or
    new BuiltinEntry(ID.hexagon_M4_xor_xacc, 21014),  // __builtin_HEXAGON_M4_xor_xacc
    new BuiltinEntry(ID.hexagon_M5_vdmacbsu, 21044),  // __builtin_HEXAGON_M5_vdmacbsu
    new BuiltinEntry(ID.hexagon_M5_vdmpybsu, 21074),  // __builtin_HEXAGON_M5_vdmpybsu
    new BuiltinEntry(ID.hexagon_M5_vmacbsu, 21104),  // __builtin_HEXAGON_M5_vmacbsu
    new BuiltinEntry(ID.hexagon_M5_vmacbuu, 21133),  // __builtin_HEXAGON_M5_vmacbuu
    new BuiltinEntry(ID.hexagon_M5_vmpybsu, 21162),  // __builtin_HEXAGON_M5_vmpybsu
    new BuiltinEntry(ID.hexagon_M5_vmpybuu, 21191),  // __builtin_HEXAGON_M5_vmpybuu
    new BuiltinEntry(ID.hexagon_M5_vrmacbsu, 21220),  // __builtin_HEXAGON_M5_vrmacbsu
    new BuiltinEntry(ID.hexagon_M5_vrmacbuu, 21250),  // __builtin_HEXAGON_M5_vrmacbuu
    new BuiltinEntry(ID.hexagon_M5_vrmpybsu, 21280),  // __builtin_HEXAGON_M5_vrmpybsu
    new BuiltinEntry(ID.hexagon_M5_vrmpybuu, 21310),  // __builtin_HEXAGON_M5_vrmpybuu
    new BuiltinEntry(ID.hexagon_M6_vabsdiffb, 21340),  // __builtin_HEXAGON_M6_vabsdiffb
    new BuiltinEntry(ID.hexagon_M6_vabsdiffub, 21371),  // __builtin_HEXAGON_M6_vabsdiffub
    new BuiltinEntry(ID.hexagon_S2_addasl_rrri, 21403),  // __builtin_HEXAGON_S2_addasl_rrri
    new BuiltinEntry(ID.hexagon_S2_asl_i_p, 21436),  // __builtin_HEXAGON_S2_asl_i_p
    new BuiltinEntry(ID.hexagon_S2_asl_i_p_acc, 21465),  // __builtin_HEXAGON_S2_asl_i_p_acc
    new BuiltinEntry(ID.hexagon_S2_asl_i_p_and, 21498),  // __builtin_HEXAGON_S2_asl_i_p_and
    new BuiltinEntry(ID.hexagon_S2_asl_i_p_nac, 21531),  // __builtin_HEXAGON_S2_asl_i_p_nac
    new BuiltinEntry(ID.hexagon_S2_asl_i_p_or, 21564),  // __builtin_HEXAGON_S2_asl_i_p_or
    new BuiltinEntry(ID.hexagon_S2_asl_i_p_xacc, 21596),  // __builtin_HEXAGON_S2_asl_i_p_xacc
    new BuiltinEntry(ID.hexagon_S2_asl_i_r, 21630),  // __builtin_HEXAGON_S2_asl_i_r
    new BuiltinEntry(ID.hexagon_S2_asl_i_r_acc, 21659),  // __builtin_HEXAGON_S2_asl_i_r_acc
    new BuiltinEntry(ID.hexagon_S2_asl_i_r_and, 21692),  // __builtin_HEXAGON_S2_asl_i_r_and
    new BuiltinEntry(ID.hexagon_S2_asl_i_r_nac, 21725),  // __builtin_HEXAGON_S2_asl_i_r_nac
    new BuiltinEntry(ID.hexagon_S2_asl_i_r_or, 21758),  // __builtin_HEXAGON_S2_asl_i_r_or
    new BuiltinEntry(ID.hexagon_S2_asl_i_r_sat, 21790),  // __builtin_HEXAGON_S2_asl_i_r_sat
    new BuiltinEntry(ID.hexagon_S2_asl_i_r_xacc, 21823),  // __builtin_HEXAGON_S2_asl_i_r_xacc
    new BuiltinEntry(ID.hexagon_S2_asl_i_vh, 21857),  // __builtin_HEXAGON_S2_asl_i_vh
    new BuiltinEntry(ID.hexagon_S2_asl_i_vw, 21887),  // __builtin_HEXAGON_S2_asl_i_vw
    new BuiltinEntry(ID.hexagon_S2_asl_r_p, 21917),  // __builtin_HEXAGON_S2_asl_r_p
    new BuiltinEntry(ID.hexagon_S2_asl_r_p_acc, 21946),  // __builtin_HEXAGON_S2_asl_r_p_acc
    new BuiltinEntry(ID.hexagon_S2_asl_r_p_and, 21979),  // __builtin_HEXAGON_S2_asl_r_p_and
    new BuiltinEntry(ID.hexagon_S2_asl_r_p_nac, 22012),  // __builtin_HEXAGON_S2_asl_r_p_nac
    new BuiltinEntry(ID.hexagon_S2_asl_r_p_or, 22045),  // __builtin_HEXAGON_S2_asl_r_p_or
    new BuiltinEntry(ID.hexagon_S2_asl_r_p_xor, 22077),  // __builtin_HEXAGON_S2_asl_r_p_xor
    new BuiltinEntry(ID.hexagon_S2_asl_r_r, 22110),  // __builtin_HEXAGON_S2_asl_r_r
    new BuiltinEntry(ID.hexagon_S2_asl_r_r_acc, 22139),  // __builtin_HEXAGON_S2_asl_r_r_acc
    new BuiltinEntry(ID.hexagon_S2_asl_r_r_and, 22172),  // __builtin_HEXAGON_S2_asl_r_r_and
    new BuiltinEntry(ID.hexagon_S2_asl_r_r_nac, 22205),  // __builtin_HEXAGON_S2_asl_r_r_nac
    new BuiltinEntry(ID.hexagon_S2_asl_r_r_or, 22238),  // __builtin_HEXAGON_S2_asl_r_r_or
    new BuiltinEntry(ID.hexagon_S2_asl_r_r_sat, 22270),  // __builtin_HEXAGON_S2_asl_r_r_sat
    new BuiltinEntry(ID.hexagon_S2_asl_r_vh, 22303),  // __builtin_HEXAGON_S2_asl_r_vh
    new BuiltinEntry(ID.hexagon_S2_asl_r_vw, 22333),  // __builtin_HEXAGON_S2_asl_r_vw
    new BuiltinEntry(ID.hexagon_S2_asr_i_p, 22363),  // __builtin_HEXAGON_S2_asr_i_p
    new BuiltinEntry(ID.hexagon_S2_asr_i_p_acc, 22392),  // __builtin_HEXAGON_S2_asr_i_p_acc
    new BuiltinEntry(ID.hexagon_S2_asr_i_p_and, 22425),  // __builtin_HEXAGON_S2_asr_i_p_and
    new BuiltinEntry(ID.hexagon_S2_asr_i_p_nac, 22458),  // __builtin_HEXAGON_S2_asr_i_p_nac
    new BuiltinEntry(ID.hexagon_S2_asr_i_p_or, 22491),  // __builtin_HEXAGON_S2_asr_i_p_or
    new BuiltinEntry(ID.hexagon_S2_asr_i_p_rnd, 22523),  // __builtin_HEXAGON_S2_asr_i_p_rnd
    new BuiltinEntry(ID.hexagon_S2_asr_i_p_rnd_goodsyntax, 22556),  // __builtin_HEXAGON_S2_asr_i_p_rnd_goodsyntax
    new BuiltinEntry(ID.hexagon_S2_asr_i_r, 22600),  // __builtin_HEXAGON_S2_asr_i_r
    new BuiltinEntry(ID.hexagon_S2_asr_i_r_acc, 22629),  // __builtin_HEXAGON_S2_asr_i_r_acc
    new BuiltinEntry(ID.hexagon_S2_asr_i_r_and, 22662),  // __builtin_HEXAGON_S2_asr_i_r_and
    new BuiltinEntry(ID.hexagon_S2_asr_i_r_nac, 22695),  // __builtin_HEXAGON_S2_asr_i_r_nac
    new BuiltinEntry(ID.hexagon_S2_asr_i_r_or, 22728),  // __builtin_HEXAGON_S2_asr_i_r_or
    new BuiltinEntry(ID.hexagon_S2_asr_i_r_rnd, 22760),  // __builtin_HEXAGON_S2_asr_i_r_rnd
    new BuiltinEntry(ID.hexagon_S2_asr_i_r_rnd_goodsyntax, 22793),  // __builtin_HEXAGON_S2_asr_i_r_rnd_goodsyntax
    new BuiltinEntry(ID.hexagon_S2_asr_i_svw_trun, 22837),  // __builtin_HEXAGON_S2_asr_i_svw_trun
    new BuiltinEntry(ID.hexagon_S2_asr_i_vh, 22873),  // __builtin_HEXAGON_S2_asr_i_vh
    new BuiltinEntry(ID.hexagon_S2_asr_i_vw, 22903),  // __builtin_HEXAGON_S2_asr_i_vw
    new BuiltinEntry(ID.hexagon_S2_asr_r_p, 22933),  // __builtin_HEXAGON_S2_asr_r_p
    new BuiltinEntry(ID.hexagon_S2_asr_r_p_acc, 22962),  // __builtin_HEXAGON_S2_asr_r_p_acc
    new BuiltinEntry(ID.hexagon_S2_asr_r_p_and, 22995),  // __builtin_HEXAGON_S2_asr_r_p_and
    new BuiltinEntry(ID.hexagon_S2_asr_r_p_nac, 23028),  // __builtin_HEXAGON_S2_asr_r_p_nac
    new BuiltinEntry(ID.hexagon_S2_asr_r_p_or, 23061),  // __builtin_HEXAGON_S2_asr_r_p_or
    new BuiltinEntry(ID.hexagon_S2_asr_r_p_xor, 23093),  // __builtin_HEXAGON_S2_asr_r_p_xor
    new BuiltinEntry(ID.hexagon_S2_asr_r_r, 23126),  // __builtin_HEXAGON_S2_asr_r_r
    new BuiltinEntry(ID.hexagon_S2_asr_r_r_acc, 23155),  // __builtin_HEXAGON_S2_asr_r_r_acc
    new BuiltinEntry(ID.hexagon_S2_asr_r_r_and, 23188),  // __builtin_HEXAGON_S2_asr_r_r_and
    new BuiltinEntry(ID.hexagon_S2_asr_r_r_nac, 23221),  // __builtin_HEXAGON_S2_asr_r_r_nac
    new BuiltinEntry(ID.hexagon_S2_asr_r_r_or, 23254),  // __builtin_HEXAGON_S2_asr_r_r_or
    new BuiltinEntry(ID.hexagon_S2_asr_r_r_sat, 23286),  // __builtin_HEXAGON_S2_asr_r_r_sat
    new BuiltinEntry(ID.hexagon_S2_asr_r_svw_trun, 23319),  // __builtin_HEXAGON_S2_asr_r_svw_trun
    new BuiltinEntry(ID.hexagon_S2_asr_r_vh, 23355),  // __builtin_HEXAGON_S2_asr_r_vh
    new BuiltinEntry(ID.hexagon_S2_asr_r_vw, 23385),  // __builtin_HEXAGON_S2_asr_r_vw
    new BuiltinEntry(ID.hexagon_S2_brev, 23415),  // __builtin_HEXAGON_S2_brev
    new BuiltinEntry(ID.hexagon_S2_brevp, 23441),  // __builtin_HEXAGON_S2_brevp
    new BuiltinEntry(ID.hexagon_S2_cabacencbin, 23468),  // __builtin_HEXAGON_S2_cabacencbin
    new BuiltinEntry(ID.hexagon_S2_cl0, 23501),  // __builtin_HEXAGON_S2_cl0
    new BuiltinEntry(ID.hexagon_S2_cl0p, 23526),  // __builtin_HEXAGON_S2_cl0p
    new BuiltinEntry(ID.hexagon_S2_cl1, 23552),  // __builtin_HEXAGON_S2_cl1
    new BuiltinEntry(ID.hexagon_S2_cl1p, 23577),  // __builtin_HEXAGON_S2_cl1p
    new BuiltinEntry(ID.hexagon_S2_clb, 23603),  // __builtin_HEXAGON_S2_clb
    new BuiltinEntry(ID.hexagon_S2_clbnorm, 23628),  // __builtin_HEXAGON_S2_clbnorm
    new BuiltinEntry(ID.hexagon_S2_clbp, 23657),  // __builtin_HEXAGON_S2_clbp
    new BuiltinEntry(ID.hexagon_S2_clrbit_i, 23683),  // __builtin_HEXAGON_S2_clrbit_i
    new BuiltinEntry(ID.hexagon_S2_clrbit_r, 23713),  // __builtin_HEXAGON_S2_clrbit_r
    new BuiltinEntry(ID.hexagon_S2_ct0, 23743),  // __builtin_HEXAGON_S2_ct0
    new BuiltinEntry(ID.hexagon_S2_ct0p, 23768),  // __builtin_HEXAGON_S2_ct0p
    new BuiltinEntry(ID.hexagon_S2_ct1, 23794),  // __builtin_HEXAGON_S2_ct1
    new BuiltinEntry(ID.hexagon_S2_ct1p, 23819),  // __builtin_HEXAGON_S2_ct1p
    new BuiltinEntry(ID.hexagon_S2_deinterleave, 23845),  // __builtin_HEXAGON_S2_deinterleave
    new BuiltinEntry(ID.hexagon_S2_extractu, 23879),  // __builtin_HEXAGON_S2_extractu
    new BuiltinEntry(ID.hexagon_S2_extractu_rp, 23909),  // __builtin_HEXAGON_S2_extractu_rp
    new BuiltinEntry(ID.hexagon_S2_extractup, 23942),  // __builtin_HEXAGON_S2_extractup
    new BuiltinEntry(ID.hexagon_S2_extractup_rp, 23973),  // __builtin_HEXAGON_S2_extractup_rp
    new BuiltinEntry(ID.hexagon_S2_insert, 24007),  // __builtin_HEXAGON_S2_insert
    new BuiltinEntry(ID.hexagon_S2_insert_rp, 24035),  // __builtin_HEXAGON_S2_insert_rp
    new BuiltinEntry(ID.hexagon_S2_insertp, 24066),  // __builtin_HEXAGON_S2_insertp
    new BuiltinEntry(ID.hexagon_S2_insertp_rp, 24095),  // __builtin_HEXAGON_S2_insertp_rp
    new BuiltinEntry(ID.hexagon_S2_interleave, 24127),  // __builtin_HEXAGON_S2_interleave
    new BuiltinEntry(ID.hexagon_S2_lfsp, 24159),  // __builtin_HEXAGON_S2_lfsp
    new BuiltinEntry(ID.hexagon_S2_lsl_r_p, 24185),  // __builtin_HEXAGON_S2_lsl_r_p
    new BuiltinEntry(ID.hexagon_S2_lsl_r_p_acc, 24214),  // __builtin_HEXAGON_S2_lsl_r_p_acc
    new BuiltinEntry(ID.hexagon_S2_lsl_r_p_and, 24247),  // __builtin_HEXAGON_S2_lsl_r_p_and
    new BuiltinEntry(ID.hexagon_S2_lsl_r_p_nac, 24280),  // __builtin_HEXAGON_S2_lsl_r_p_nac
    new BuiltinEntry(ID.hexagon_S2_lsl_r_p_or, 24313),  // __builtin_HEXAGON_S2_lsl_r_p_or
    new BuiltinEntry(ID.hexagon_S2_lsl_r_p_xor, 24345),  // __builtin_HEXAGON_S2_lsl_r_p_xor
    new BuiltinEntry(ID.hexagon_S2_lsl_r_r, 24378),  // __builtin_HEXAGON_S2_lsl_r_r
    new BuiltinEntry(ID.hexagon_S2_lsl_r_r_acc, 24407),  // __builtin_HEXAGON_S2_lsl_r_r_acc
    new BuiltinEntry(ID.hexagon_S2_lsl_r_r_and, 24440),  // __builtin_HEXAGON_S2_lsl_r_r_and
    new BuiltinEntry(ID.hexagon_S2_lsl_r_r_nac, 24473),  // __builtin_HEXAGON_S2_lsl_r_r_nac
    new BuiltinEntry(ID.hexagon_S2_lsl_r_r_or, 24506),  // __builtin_HEXAGON_S2_lsl_r_r_or
    new BuiltinEntry(ID.hexagon_S2_lsl_r_vh, 24538),  // __builtin_HEXAGON_S2_lsl_r_vh
    new BuiltinEntry(ID.hexagon_S2_lsl_r_vw, 24568),  // __builtin_HEXAGON_S2_lsl_r_vw
    new BuiltinEntry(ID.hexagon_S2_lsr_i_p, 24598),  // __builtin_HEXAGON_S2_lsr_i_p
    new BuiltinEntry(ID.hexagon_S2_lsr_i_p_acc, 24627),  // __builtin_HEXAGON_S2_lsr_i_p_acc
    new BuiltinEntry(ID.hexagon_S2_lsr_i_p_and, 24660),  // __builtin_HEXAGON_S2_lsr_i_p_and
    new BuiltinEntry(ID.hexagon_S2_lsr_i_p_nac, 24693),  // __builtin_HEXAGON_S2_lsr_i_p_nac
    new BuiltinEntry(ID.hexagon_S2_lsr_i_p_or, 24726),  // __builtin_HEXAGON_S2_lsr_i_p_or
    new BuiltinEntry(ID.hexagon_S2_lsr_i_p_xacc, 24758),  // __builtin_HEXAGON_S2_lsr_i_p_xacc
    new BuiltinEntry(ID.hexagon_S2_lsr_i_r, 24792),  // __builtin_HEXAGON_S2_lsr_i_r
    new BuiltinEntry(ID.hexagon_S2_lsr_i_r_acc, 24821),  // __builtin_HEXAGON_S2_lsr_i_r_acc
    new BuiltinEntry(ID.hexagon_S2_lsr_i_r_and, 24854),  // __builtin_HEXAGON_S2_lsr_i_r_and
    new BuiltinEntry(ID.hexagon_S2_lsr_i_r_nac, 24887),  // __builtin_HEXAGON_S2_lsr_i_r_nac
    new BuiltinEntry(ID.hexagon_S2_lsr_i_r_or, 24920),  // __builtin_HEXAGON_S2_lsr_i_r_or
    new BuiltinEntry(ID.hexagon_S2_lsr_i_r_xacc, 24952),  // __builtin_HEXAGON_S2_lsr_i_r_xacc
    new BuiltinEntry(ID.hexagon_S2_lsr_i_vh, 24986),  // __builtin_HEXAGON_S2_lsr_i_vh
    new BuiltinEntry(ID.hexagon_S2_lsr_i_vw, 25016),  // __builtin_HEXAGON_S2_lsr_i_vw
    new BuiltinEntry(ID.hexagon_S2_lsr_r_p, 25046),  // __builtin_HEXAGON_S2_lsr_r_p
    new BuiltinEntry(ID.hexagon_S2_lsr_r_p_acc, 25075),  // __builtin_HEXAGON_S2_lsr_r_p_acc
    new BuiltinEntry(ID.hexagon_S2_lsr_r_p_and, 25108),  // __builtin_HEXAGON_S2_lsr_r_p_and
    new BuiltinEntry(ID.hexagon_S2_lsr_r_p_nac, 25141),  // __builtin_HEXAGON_S2_lsr_r_p_nac
    new BuiltinEntry(ID.hexagon_S2_lsr_r_p_or, 25174),  // __builtin_HEXAGON_S2_lsr_r_p_or
    new BuiltinEntry(ID.hexagon_S2_lsr_r_p_xor, 25206),  // __builtin_HEXAGON_S2_lsr_r_p_xor
    new BuiltinEntry(ID.hexagon_S2_lsr_r_r, 25239),  // __builtin_HEXAGON_S2_lsr_r_r
    new BuiltinEntry(ID.hexagon_S2_lsr_r_r_acc, 25268),  // __builtin_HEXAGON_S2_lsr_r_r_acc
    new BuiltinEntry(ID.hexagon_S2_lsr_r_r_and, 25301),  // __builtin_HEXAGON_S2_lsr_r_r_and
    new BuiltinEntry(ID.hexagon_S2_lsr_r_r_nac, 25334),  // __builtin_HEXAGON_S2_lsr_r_r_nac
    new BuiltinEntry(ID.hexagon_S2_lsr_r_r_or, 25367),  // __builtin_HEXAGON_S2_lsr_r_r_or
    new BuiltinEntry(ID.hexagon_S2_lsr_r_vh, 25399),  // __builtin_HEXAGON_S2_lsr_r_vh
    new BuiltinEntry(ID.hexagon_S2_lsr_r_vw, 25429),  // __builtin_HEXAGON_S2_lsr_r_vw
    new BuiltinEntry(ID.hexagon_S2_packhl, 25459),  // __builtin_HEXAGON_S2_packhl
    new BuiltinEntry(ID.hexagon_S2_parityp, 25487),  // __builtin_HEXAGON_S2_parityp
    new BuiltinEntry(ID.hexagon_S2_setbit_i, 25516),  // __builtin_HEXAGON_S2_setbit_i
    new BuiltinEntry(ID.hexagon_S2_setbit_r, 25546),  // __builtin_HEXAGON_S2_setbit_r
    new BuiltinEntry(ID.hexagon_S2_shuffeb, 25576),  // __builtin_HEXAGON_S2_shuffeb
    new BuiltinEntry(ID.hexagon_S2_shuffeh, 25605),  // __builtin_HEXAGON_S2_shuffeh
    new BuiltinEntry(ID.hexagon_S2_shuffob, 25634),  // __builtin_HEXAGON_S2_shuffob
    new BuiltinEntry(ID.hexagon_S2_shuffoh, 25663),  // __builtin_HEXAGON_S2_shuffoh
    new BuiltinEntry(ID.hexagon_S2_storew_locked, 25692),  // __builtin_HEXAGON_S2_storew_locked
    new BuiltinEntry(ID.hexagon_S2_svsathb, 25727),  // __builtin_HEXAGON_S2_svsathb
    new BuiltinEntry(ID.hexagon_S2_svsathub, 25756),  // __builtin_HEXAGON_S2_svsathub
    new BuiltinEntry(ID.hexagon_S2_tableidxb_goodsyntax, 25786),  // __builtin_HEXAGON_S2_tableidxb_goodsyntax
    new BuiltinEntry(ID.hexagon_S2_tableidxd_goodsyntax, 25828),  // __builtin_HEXAGON_S2_tableidxd_goodsyntax
    new BuiltinEntry(ID.hexagon_S2_tableidxh_goodsyntax, 25870),  // __builtin_HEXAGON_S2_tableidxh_goodsyntax
    new BuiltinEntry(ID.hexagon_S2_tableidxw_goodsyntax, 25912),  // __builtin_HEXAGON_S2_tableidxw_goodsyntax
    new BuiltinEntry(ID.hexagon_S2_togglebit_i, 25954),  // __builtin_HEXAGON_S2_togglebit_i
    new BuiltinEntry(ID.hexagon_S2_togglebit_r, 25987),  // __builtin_HEXAGON_S2_togglebit_r
    new BuiltinEntry(ID.hexagon_S2_tstbit_i, 26020),  // __builtin_HEXAGON_S2_tstbit_i
    new BuiltinEntry(ID.hexagon_S2_tstbit_r, 26050),  // __builtin_HEXAGON_S2_tstbit_r
    new BuiltinEntry(ID.hexagon_S2_valignib, 26080),  // __builtin_HEXAGON_S2_valignib
    new BuiltinEntry(ID.hexagon_S2_valignrb, 26110),  // __builtin_HEXAGON_S2_valignrb
    new BuiltinEntry(ID.hexagon_S2_vcnegh, 26140),  // __builtin_HEXAGON_S2_vcnegh
    new BuiltinEntry(ID.hexagon_S2_vcrotate, 26168),  // __builtin_HEXAGON_S2_vcrotate
    new BuiltinEntry(ID.hexagon_S2_vrcnegh, 26198),  // __builtin_HEXAGON_S2_vrcnegh
    new BuiltinEntry(ID.hexagon_S2_vrndpackwh, 26227),  // __builtin_HEXAGON_S2_vrndpackwh
    new BuiltinEntry(ID.hexagon_S2_vrndpackwhs, 26259),  // __builtin_HEXAGON_S2_vrndpackwhs
    new BuiltinEntry(ID.hexagon_S2_vsathb, 26292),  // __builtin_HEXAGON_S2_vsathb
    new BuiltinEntry(ID.hexagon_S2_vsathb_nopack, 26320),  // __builtin_HEXAGON_S2_vsathb_nopack
    new BuiltinEntry(ID.hexagon_S2_vsathub, 26355),  // __builtin_HEXAGON_S2_vsathub
    new BuiltinEntry(ID.hexagon_S2_vsathub_nopack, 26384),  // __builtin_HEXAGON_S2_vsathub_nopack
    new BuiltinEntry(ID.hexagon_S2_vsatwh, 26420),  // __builtin_HEXAGON_S2_vsatwh
    new BuiltinEntry(ID.hexagon_S2_vsatwh_nopack, 26448),  // __builtin_HEXAGON_S2_vsatwh_nopack
    new BuiltinEntry(ID.hexagon_S2_vsatwuh, 26483),  // __builtin_HEXAGON_S2_vsatwuh
    new BuiltinEntry(ID.hexagon_S2_vsatwuh_nopack, 26512),  // __builtin_HEXAGON_S2_vsatwuh_nopack
    new BuiltinEntry(ID.hexagon_S2_vsplatrb, 26548),  // __builtin_HEXAGON_S2_vsplatrb
    new BuiltinEntry(ID.hexagon_S2_vsplatrh, 26578),  // __builtin_HEXAGON_S2_vsplatrh
    new BuiltinEntry(ID.hexagon_S2_vspliceib, 26608),  // __builtin_HEXAGON_S2_vspliceib
    new BuiltinEntry(ID.hexagon_S2_vsplicerb, 26639),  // __builtin_HEXAGON_S2_vsplicerb
    new BuiltinEntry(ID.hexagon_S2_vsxtbh, 26670),  // __builtin_HEXAGON_S2_vsxtbh
    new BuiltinEntry(ID.hexagon_S2_vsxthw, 26698),  // __builtin_HEXAGON_S2_vsxthw
    new BuiltinEntry(ID.hexagon_S2_vtrunehb, 26726),  // __builtin_HEXAGON_S2_vtrunehb
    new BuiltinEntry(ID.hexagon_S2_vtrunewh, 26756),  // __builtin_HEXAGON_S2_vtrunewh
    new BuiltinEntry(ID.hexagon_S2_vtrunohb, 26786),  // __builtin_HEXAGON_S2_vtrunohb
    new BuiltinEntry(ID.hexagon_S2_vtrunowh, 26816),  // __builtin_HEXAGON_S2_vtrunowh
    new BuiltinEntry(ID.hexagon_S2_vzxtbh, 26846),  // __builtin_HEXAGON_S2_vzxtbh
    new BuiltinEntry(ID.hexagon_S2_vzxthw, 26874),  // __builtin_HEXAGON_S2_vzxthw
    new BuiltinEntry(ID.hexagon_S4_addaddi, 26902),  // __builtin_HEXAGON_S4_addaddi
    new BuiltinEntry(ID.hexagon_S4_addi_asl_ri, 26931),  // __builtin_HEXAGON_S4_addi_asl_ri
    new BuiltinEntry(ID.hexagon_S4_addi_lsr_ri, 26964),  // __builtin_HEXAGON_S4_addi_lsr_ri
    new BuiltinEntry(ID.hexagon_S4_andi_asl_ri, 26997),  // __builtin_HEXAGON_S4_andi_asl_ri
    new BuiltinEntry(ID.hexagon_S4_andi_lsr_ri, 27030),  // __builtin_HEXAGON_S4_andi_lsr_ri
    new BuiltinEntry(ID.hexagon_S4_clbaddi, 27063),  // __builtin_HEXAGON_S4_clbaddi
    new BuiltinEntry(ID.hexagon_S4_clbpaddi, 27092),  // __builtin_HEXAGON_S4_clbpaddi
    new BuiltinEntry(ID.hexagon_S4_clbpnorm, 27122),  // __builtin_HEXAGON_S4_clbpnorm
    new BuiltinEntry(ID.hexagon_S4_extract, 27152),  // __builtin_HEXAGON_S4_extract
    new BuiltinEntry(ID.hexagon_S4_extract_rp, 27181),  // __builtin_HEXAGON_S4_extract_rp
    new BuiltinEntry(ID.hexagon_S4_extractp, 27213),  // __builtin_HEXAGON_S4_extractp
    new BuiltinEntry(ID.hexagon_S4_extractp_rp, 27243),  // __builtin_HEXAGON_S4_extractp_rp
    new BuiltinEntry(ID.hexagon_S4_lsli, 27276),  // __builtin_HEXAGON_S4_lsli
    new BuiltinEntry(ID.hexagon_S4_ntstbit_i, 27302),  // __builtin_HEXAGON_S4_ntstbit_i
    new BuiltinEntry(ID.hexagon_S4_ntstbit_r, 27333),  // __builtin_HEXAGON_S4_ntstbit_r
    new BuiltinEntry(ID.hexagon_S4_or_andi, 27364),  // __builtin_HEXAGON_S4_or_andi
    new BuiltinEntry(ID.hexagon_S4_or_andix, 27393),  // __builtin_HEXAGON_S4_or_andix
    new BuiltinEntry(ID.hexagon_S4_or_ori, 27423),  // __builtin_HEXAGON_S4_or_ori
    new BuiltinEntry(ID.hexagon_S4_ori_asl_ri, 27451),  // __builtin_HEXAGON_S4_ori_asl_ri
    new BuiltinEntry(ID.hexagon_S4_ori_lsr_ri, 27483),  // __builtin_HEXAGON_S4_ori_lsr_ri
    new BuiltinEntry(ID.hexagon_S4_parity, 27515),  // __builtin_HEXAGON_S4_parity
    new BuiltinEntry(ID.hexagon_S4_stored_locked, 27543),  // __builtin_HEXAGON_S4_stored_locked
    new BuiltinEntry(ID.hexagon_S4_subaddi, 27578),  // __builtin_HEXAGON_S4_subaddi
    new BuiltinEntry(ID.hexagon_S4_subi_asl_ri, 27607),  // __builtin_HEXAGON_S4_subi_asl_ri
    new BuiltinEntry(ID.hexagon_S4_subi_lsr_ri, 27640),  // __builtin_HEXAGON_S4_subi_lsr_ri
    new BuiltinEntry(ID.hexagon_S4_vrcrotate, 27673),  // __builtin_HEXAGON_S4_vrcrotate
    new BuiltinEntry(ID.hexagon_S4_vrcrotate_acc, 27704),  // __builtin_HEXAGON_S4_vrcrotate_acc
    new BuiltinEntry(ID.hexagon_S4_vxaddsubh, 27739),  // __builtin_HEXAGON_S4_vxaddsubh
    new BuiltinEntry(ID.hexagon_S4_vxaddsubhr, 27770),  // __builtin_HEXAGON_S4_vxaddsubhr
    new BuiltinEntry(ID.hexagon_S4_vxaddsubw, 27802),  // __builtin_HEXAGON_S4_vxaddsubw
    new BuiltinEntry(ID.hexagon_S4_vxsubaddh, 27833),  // __builtin_HEXAGON_S4_vxsubaddh
    new BuiltinEntry(ID.hexagon_S4_vxsubaddhr, 27864),  // __builtin_HEXAGON_S4_vxsubaddhr
    new BuiltinEntry(ID.hexagon_S4_vxsubaddw, 27896),  // __builtin_HEXAGON_S4_vxsubaddw
    new BuiltinEntry(ID.hexagon_S5_asrhub_rnd_sat_goodsyntax, 27927),  // __builtin_HEXAGON_S5_asrhub_rnd_sat_goodsyntax
    new BuiltinEntry(ID.hexagon_S5_asrhub_sat, 27974),  // __builtin_HEXAGON_S5_asrhub_sat
    new BuiltinEntry(ID.hexagon_S5_popcountp, 28006),  // __builtin_HEXAGON_S5_popcountp
    new BuiltinEntry(ID.hexagon_S5_vasrhrnd_goodsyntax, 28037),  // __builtin_HEXAGON_S5_vasrhrnd_goodsyntax
    new BuiltinEntry(ID.hexagon_S6_rol_i_p, 28078),  // __builtin_HEXAGON_S6_rol_i_p
    new BuiltinEntry(ID.hexagon_S6_rol_i_p_acc, 28107),  // __builtin_HEXAGON_S6_rol_i_p_acc
    new BuiltinEntry(ID.hexagon_S6_rol_i_p_and, 28140),  // __builtin_HEXAGON_S6_rol_i_p_and
    new BuiltinEntry(ID.hexagon_S6_rol_i_p_nac, 28173),  // __builtin_HEXAGON_S6_rol_i_p_nac
    new BuiltinEntry(ID.hexagon_S6_rol_i_p_or, 28206),  // __builtin_HEXAGON_S6_rol_i_p_or
    new BuiltinEntry(ID.hexagon_S6_rol_i_p_xacc, 28238),  // __builtin_HEXAGON_S6_rol_i_p_xacc
    new BuiltinEntry(ID.hexagon_S6_rol_i_r, 28272),  // __builtin_HEXAGON_S6_rol_i_r
    new BuiltinEntry(ID.hexagon_S6_rol_i_r_acc, 28301),  // __builtin_HEXAGON_S6_rol_i_r_acc
    new BuiltinEntry(ID.hexagon_S6_rol_i_r_and, 28334),  // __builtin_HEXAGON_S6_rol_i_r_and
    new BuiltinEntry(ID.hexagon_S6_rol_i_r_nac, 28367),  // __builtin_HEXAGON_S6_rol_i_r_nac
    new BuiltinEntry(ID.hexagon_S6_rol_i_r_or, 28400),  // __builtin_HEXAGON_S6_rol_i_r_or
    new BuiltinEntry(ID.hexagon_S6_rol_i_r_xacc, 28432),  // __builtin_HEXAGON_S6_rol_i_r_xacc
    new BuiltinEntry(ID.hexagon_S6_vsplatrbp, 28466),  // __builtin_HEXAGON_S6_vsplatrbp
    new BuiltinEntry(ID.hexagon_S6_vtrunehb_ppp, 28497),  // __builtin_HEXAGON_S6_vtrunehb_ppp
    new BuiltinEntry(ID.hexagon_S6_vtrunohb_ppp, 28531),  // __builtin_HEXAGON_S6_vtrunohb_ppp
    new BuiltinEntry(ID.hexagon_V6_extractw, 28592),  // __builtin_HEXAGON_V6_extractw
    new BuiltinEntry(ID.hexagon_V6_extractw_128B, 28622),  // __builtin_HEXAGON_V6_extractw_128B
    new BuiltinEntry(ID.hexagon_V6_hi, 28657),  // __builtin_HEXAGON_V6_hi
    new BuiltinEntry(ID.hexagon_V6_hi_128B, 28681),  // __builtin_HEXAGON_V6_hi_128B
    new BuiltinEntry(ID.hexagon_V6_lo, 28710),  // __builtin_HEXAGON_V6_lo
    new BuiltinEntry(ID.hexagon_V6_lo_128B, 28734),  // __builtin_HEXAGON_V6_lo_128B
    new BuiltinEntry(ID.hexagon_V6_lvsplatw, 28763),  // __builtin_HEXAGON_V6_lvsplatw
    new BuiltinEntry(ID.hexagon_V6_lvsplatw_128B, 28793),  // __builtin_HEXAGON_V6_lvsplatw_128B
    new BuiltinEntry(ID.hexagon_V6_pred_and, 28828),  // __builtin_HEXAGON_V6_pred_and
    new BuiltinEntry(ID.hexagon_V6_pred_and_128B, 28858),  // __builtin_HEXAGON_V6_pred_and_128B
    new BuiltinEntry(ID.hexagon_V6_pred_and_n, 28893),  // __builtin_HEXAGON_V6_pred_and_n
    new BuiltinEntry(ID.hexagon_V6_pred_and_n_128B, 28925),  // __builtin_HEXAGON_V6_pred_and_n_128B
    new BuiltinEntry(ID.hexagon_V6_pred_not, 28962),  // __builtin_HEXAGON_V6_pred_not
    new BuiltinEntry(ID.hexagon_V6_pred_not_128B, 28992),  // __builtin_HEXAGON_V6_pred_not_128B
    new BuiltinEntry(ID.hexagon_V6_pred_or, 29027),  // __builtin_HEXAGON_V6_pred_or
    new BuiltinEntry(ID.hexagon_V6_pred_or_128B, 29056),  // __builtin_HEXAGON_V6_pred_or_128B
    new BuiltinEntry(ID.hexagon_V6_pred_or_n, 29090),  // __builtin_HEXAGON_V6_pred_or_n
    new BuiltinEntry(ID.hexagon_V6_pred_or_n_128B, 29121),  // __builtin_HEXAGON_V6_pred_or_n_128B
    new BuiltinEntry(ID.hexagon_V6_pred_scalar2, 29157),  // __builtin_HEXAGON_V6_pred_scalar2
    new BuiltinEntry(ID.hexagon_V6_pred_scalar2_128B, 29191),  // __builtin_HEXAGON_V6_pred_scalar2_128B
    new BuiltinEntry(ID.hexagon_V6_pred_xor, 29230),  // __builtin_HEXAGON_V6_pred_xor
    new BuiltinEntry(ID.hexagon_V6_pred_xor_128B, 29260),  // __builtin_HEXAGON_V6_pred_xor_128B
    new BuiltinEntry(ID.hexagon_V6_vabsdiffh, 29295),  // __builtin_HEXAGON_V6_vabsdiffh
    new BuiltinEntry(ID.hexagon_V6_vabsdiffh_128B, 29326),  // __builtin_HEXAGON_V6_vabsdiffh_128B
    new BuiltinEntry(ID.hexagon_V6_vabsdiffub, 29362),  // __builtin_HEXAGON_V6_vabsdiffub
    new BuiltinEntry(ID.hexagon_V6_vabsdiffub_128B, 29394),  // __builtin_HEXAGON_V6_vabsdiffub_128B
    new BuiltinEntry(ID.hexagon_V6_vabsdiffuh, 29431),  // __builtin_HEXAGON_V6_vabsdiffuh
    new BuiltinEntry(ID.hexagon_V6_vabsdiffuh_128B, 29463),  // __builtin_HEXAGON_V6_vabsdiffuh_128B
    new BuiltinEntry(ID.hexagon_V6_vabsdiffw, 29500),  // __builtin_HEXAGON_V6_vabsdiffw
    new BuiltinEntry(ID.hexagon_V6_vabsdiffw_128B, 29531),  // __builtin_HEXAGON_V6_vabsdiffw_128B
    new BuiltinEntry(ID.hexagon_V6_vabsh, 29567),  // __builtin_HEXAGON_V6_vabsh
    new BuiltinEntry(ID.hexagon_V6_vabsh_128B, 29594),  // __builtin_HEXAGON_V6_vabsh_128B
    new BuiltinEntry(ID.hexagon_V6_vabsh_sat, 29626),  // __builtin_HEXAGON_V6_vabsh_sat
    new BuiltinEntry(ID.hexagon_V6_vabsh_sat_128B, 29657),  // __builtin_HEXAGON_V6_vabsh_sat_128B
    new BuiltinEntry(ID.hexagon_V6_vabsw, 29693),  // __builtin_HEXAGON_V6_vabsw
    new BuiltinEntry(ID.hexagon_V6_vabsw_128B, 29720),  // __builtin_HEXAGON_V6_vabsw_128B
    new BuiltinEntry(ID.hexagon_V6_vabsw_sat, 29752),  // __builtin_HEXAGON_V6_vabsw_sat
    new BuiltinEntry(ID.hexagon_V6_vabsw_sat_128B, 29783),  // __builtin_HEXAGON_V6_vabsw_sat_128B
    new BuiltinEntry(ID.hexagon_V6_vaddb, 29819),  // __builtin_HEXAGON_V6_vaddb
    new BuiltinEntry(ID.hexagon_V6_vaddb_128B, 29846),  // __builtin_HEXAGON_V6_vaddb_128B
    new BuiltinEntry(ID.hexagon_V6_vaddb_dv, 29878),  // __builtin_HEXAGON_V6_vaddb_dv
    new BuiltinEntry(ID.hexagon_V6_vaddb_dv_128B, 29908),  // __builtin_HEXAGON_V6_vaddb_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vaddbnq, 29943),  // __builtin_HEXAGON_V6_vaddbnq
    new BuiltinEntry(ID.hexagon_V6_vaddbnq_128B, 29972),  // __builtin_HEXAGON_V6_vaddbnq_128B
    new BuiltinEntry(ID.hexagon_V6_vaddbq, 30006),  // __builtin_HEXAGON_V6_vaddbq
    new BuiltinEntry(ID.hexagon_V6_vaddbq_128B, 30034),  // __builtin_HEXAGON_V6_vaddbq_128B
    new BuiltinEntry(ID.hexagon_V6_vaddh, 30067),  // __builtin_HEXAGON_V6_vaddh
    new BuiltinEntry(ID.hexagon_V6_vaddh_128B, 30094),  // __builtin_HEXAGON_V6_vaddh_128B
    new BuiltinEntry(ID.hexagon_V6_vaddh_dv, 30126),  // __builtin_HEXAGON_V6_vaddh_dv
    new BuiltinEntry(ID.hexagon_V6_vaddh_dv_128B, 30156),  // __builtin_HEXAGON_V6_vaddh_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vaddhnq, 30191),  // __builtin_HEXAGON_V6_vaddhnq
    new BuiltinEntry(ID.hexagon_V6_vaddhnq_128B, 30220),  // __builtin_HEXAGON_V6_vaddhnq_128B
    new BuiltinEntry(ID.hexagon_V6_vaddhq, 30254),  // __builtin_HEXAGON_V6_vaddhq
    new BuiltinEntry(ID.hexagon_V6_vaddhq_128B, 30282),  // __builtin_HEXAGON_V6_vaddhq_128B
    new BuiltinEntry(ID.hexagon_V6_vaddhsat, 30315),  // __builtin_HEXAGON_V6_vaddhsat
    new BuiltinEntry(ID.hexagon_V6_vaddhsat_128B, 30345),  // __builtin_HEXAGON_V6_vaddhsat_128B
    new BuiltinEntry(ID.hexagon_V6_vaddhsat_dv, 30380),  // __builtin_HEXAGON_V6_vaddhsat_dv
    new BuiltinEntry(ID.hexagon_V6_vaddhsat_dv_128B, 30413),  // __builtin_HEXAGON_V6_vaddhsat_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vaddhw, 30451),  // __builtin_HEXAGON_V6_vaddhw
    new BuiltinEntry(ID.hexagon_V6_vaddhw_128B, 30479),  // __builtin_HEXAGON_V6_vaddhw_128B
    new BuiltinEntry(ID.hexagon_V6_vaddubh, 30512),  // __builtin_HEXAGON_V6_vaddubh
    new BuiltinEntry(ID.hexagon_V6_vaddubh_128B, 30541),  // __builtin_HEXAGON_V6_vaddubh_128B
    new BuiltinEntry(ID.hexagon_V6_vaddubsat, 30575),  // __builtin_HEXAGON_V6_vaddubsat
    new BuiltinEntry(ID.hexagon_V6_vaddubsat_128B, 30606),  // __builtin_HEXAGON_V6_vaddubsat_128B
    new BuiltinEntry(ID.hexagon_V6_vaddubsat_dv, 30642),  // __builtin_HEXAGON_V6_vaddubsat_dv
    new BuiltinEntry(ID.hexagon_V6_vaddubsat_dv_128B, 30676),  // __builtin_HEXAGON_V6_vaddubsat_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vadduhsat, 30715),  // __builtin_HEXAGON_V6_vadduhsat
    new BuiltinEntry(ID.hexagon_V6_vadduhsat_128B, 30746),  // __builtin_HEXAGON_V6_vadduhsat_128B
    new BuiltinEntry(ID.hexagon_V6_vadduhsat_dv, 30782),  // __builtin_HEXAGON_V6_vadduhsat_dv
    new BuiltinEntry(ID.hexagon_V6_vadduhsat_dv_128B, 30816),  // __builtin_HEXAGON_V6_vadduhsat_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vadduhw, 30855),  // __builtin_HEXAGON_V6_vadduhw
    new BuiltinEntry(ID.hexagon_V6_vadduhw_128B, 30884),  // __builtin_HEXAGON_V6_vadduhw_128B
    new BuiltinEntry(ID.hexagon_V6_vaddw, 30918),  // __builtin_HEXAGON_V6_vaddw
    new BuiltinEntry(ID.hexagon_V6_vaddw_128B, 30945),  // __builtin_HEXAGON_V6_vaddw_128B
    new BuiltinEntry(ID.hexagon_V6_vaddw_dv, 30977),  // __builtin_HEXAGON_V6_vaddw_dv
    new BuiltinEntry(ID.hexagon_V6_vaddw_dv_128B, 31007),  // __builtin_HEXAGON_V6_vaddw_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vaddwnq, 31042),  // __builtin_HEXAGON_V6_vaddwnq
    new BuiltinEntry(ID.hexagon_V6_vaddwnq_128B, 31071),  // __builtin_HEXAGON_V6_vaddwnq_128B
    new BuiltinEntry(ID.hexagon_V6_vaddwq, 31105),  // __builtin_HEXAGON_V6_vaddwq
    new BuiltinEntry(ID.hexagon_V6_vaddwq_128B, 31133),  // __builtin_HEXAGON_V6_vaddwq_128B
    new BuiltinEntry(ID.hexagon_V6_vaddwsat, 31166),  // __builtin_HEXAGON_V6_vaddwsat
    new BuiltinEntry(ID.hexagon_V6_vaddwsat_128B, 31196),  // __builtin_HEXAGON_V6_vaddwsat_128B
    new BuiltinEntry(ID.hexagon_V6_vaddwsat_dv, 31231),  // __builtin_HEXAGON_V6_vaddwsat_dv
    new BuiltinEntry(ID.hexagon_V6_vaddwsat_dv_128B, 31264),  // __builtin_HEXAGON_V6_vaddwsat_dv_128B
    new BuiltinEntry(ID.hexagon_V6_valignb, 31302),  // __builtin_HEXAGON_V6_valignb
    new BuiltinEntry(ID.hexagon_V6_valignb_128B, 31331),  // __builtin_HEXAGON_V6_valignb_128B
    new BuiltinEntry(ID.hexagon_V6_valignbi, 31365),  // __builtin_HEXAGON_V6_valignbi
    new BuiltinEntry(ID.hexagon_V6_valignbi_128B, 31395),  // __builtin_HEXAGON_V6_valignbi_128B
    new BuiltinEntry(ID.hexagon_V6_vand, 31430),  // __builtin_HEXAGON_V6_vand
    new BuiltinEntry(ID.hexagon_V6_vand_128B, 31456),  // __builtin_HEXAGON_V6_vand_128B
    new BuiltinEntry(ID.hexagon_V6_vandqrt, 31487),  // __builtin_HEXAGON_V6_vandqrt
    new BuiltinEntry(ID.hexagon_V6_vandqrt_128B, 31516),  // __builtin_HEXAGON_V6_vandqrt_128B
    new BuiltinEntry(ID.hexagon_V6_vandqrt_acc, 31550),  // __builtin_HEXAGON_V6_vandqrt_acc
    new BuiltinEntry(ID.hexagon_V6_vandqrt_acc_128B, 31583),  // __builtin_HEXAGON_V6_vandqrt_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vandvrt, 31621),  // __builtin_HEXAGON_V6_vandvrt
    new BuiltinEntry(ID.hexagon_V6_vandvrt_128B, 31650),  // __builtin_HEXAGON_V6_vandvrt_128B
    new BuiltinEntry(ID.hexagon_V6_vandvrt_acc, 31684),  // __builtin_HEXAGON_V6_vandvrt_acc
    new BuiltinEntry(ID.hexagon_V6_vandvrt_acc_128B, 31717),  // __builtin_HEXAGON_V6_vandvrt_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vaslh, 31755),  // __builtin_HEXAGON_V6_vaslh
    new BuiltinEntry(ID.hexagon_V6_vaslh_128B, 31782),  // __builtin_HEXAGON_V6_vaslh_128B
    new BuiltinEntry(ID.hexagon_V6_vaslhv, 31814),  // __builtin_HEXAGON_V6_vaslhv
    new BuiltinEntry(ID.hexagon_V6_vaslhv_128B, 31842),  // __builtin_HEXAGON_V6_vaslhv_128B
    new BuiltinEntry(ID.hexagon_V6_vaslw, 31875),  // __builtin_HEXAGON_V6_vaslw
    new BuiltinEntry(ID.hexagon_V6_vaslw_128B, 31902),  // __builtin_HEXAGON_V6_vaslw_128B
    new BuiltinEntry(ID.hexagon_V6_vaslw_acc, 31934),  // __builtin_HEXAGON_V6_vaslw_acc
    new BuiltinEntry(ID.hexagon_V6_vaslw_acc_128B, 31965),  // __builtin_HEXAGON_V6_vaslw_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vaslwv, 32001),  // __builtin_HEXAGON_V6_vaslwv
    new BuiltinEntry(ID.hexagon_V6_vaslwv_128B, 32029),  // __builtin_HEXAGON_V6_vaslwv_128B
    new BuiltinEntry(ID.hexagon_V6_vasrh, 32062),  // __builtin_HEXAGON_V6_vasrh
    new BuiltinEntry(ID.hexagon_V6_vasrh_128B, 32089),  // __builtin_HEXAGON_V6_vasrh_128B
    new BuiltinEntry(ID.hexagon_V6_vasrhbrndsat, 32121),  // __builtin_HEXAGON_V6_vasrhbrndsat
    new BuiltinEntry(ID.hexagon_V6_vasrhbrndsat_128B, 32155),  // __builtin_HEXAGON_V6_vasrhbrndsat_128B
    new BuiltinEntry(ID.hexagon_V6_vasrhubrndsat, 32194),  // __builtin_HEXAGON_V6_vasrhubrndsat
    new BuiltinEntry(ID.hexagon_V6_vasrhubrndsat_128B, 32229),  // __builtin_HEXAGON_V6_vasrhubrndsat_128B
    new BuiltinEntry(ID.hexagon_V6_vasrhubsat, 32269),  // __builtin_HEXAGON_V6_vasrhubsat
    new BuiltinEntry(ID.hexagon_V6_vasrhubsat_128B, 32301),  // __builtin_HEXAGON_V6_vasrhubsat_128B
    new BuiltinEntry(ID.hexagon_V6_vasrhv, 32338),  // __builtin_HEXAGON_V6_vasrhv
    new BuiltinEntry(ID.hexagon_V6_vasrhv_128B, 32366),  // __builtin_HEXAGON_V6_vasrhv_128B
    new BuiltinEntry(ID.hexagon_V6_vasrw, 32399),  // __builtin_HEXAGON_V6_vasrw
    new BuiltinEntry(ID.hexagon_V6_vasrw_128B, 32426),  // __builtin_HEXAGON_V6_vasrw_128B
    new BuiltinEntry(ID.hexagon_V6_vasrw_acc, 32458),  // __builtin_HEXAGON_V6_vasrw_acc
    new BuiltinEntry(ID.hexagon_V6_vasrw_acc_128B, 32489),  // __builtin_HEXAGON_V6_vasrw_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vasrwh, 32525),  // __builtin_HEXAGON_V6_vasrwh
    new BuiltinEntry(ID.hexagon_V6_vasrwh_128B, 32553),  // __builtin_HEXAGON_V6_vasrwh_128B
    new BuiltinEntry(ID.hexagon_V6_vasrwhrndsat, 32586),  // __builtin_HEXAGON_V6_vasrwhrndsat
    new BuiltinEntry(ID.hexagon_V6_vasrwhrndsat_128B, 32620),  // __builtin_HEXAGON_V6_vasrwhrndsat_128B
    new BuiltinEntry(ID.hexagon_V6_vasrwhsat, 32659),  // __builtin_HEXAGON_V6_vasrwhsat
    new BuiltinEntry(ID.hexagon_V6_vasrwhsat_128B, 32690),  // __builtin_HEXAGON_V6_vasrwhsat_128B
    new BuiltinEntry(ID.hexagon_V6_vasrwuhsat, 32726),  // __builtin_HEXAGON_V6_vasrwuhsat
    new BuiltinEntry(ID.hexagon_V6_vasrwuhsat_128B, 32758),  // __builtin_HEXAGON_V6_vasrwuhsat_128B
    new BuiltinEntry(ID.hexagon_V6_vasrwv, 32795),  // __builtin_HEXAGON_V6_vasrwv
    new BuiltinEntry(ID.hexagon_V6_vasrwv_128B, 32823),  // __builtin_HEXAGON_V6_vasrwv_128B
    new BuiltinEntry(ID.hexagon_V6_vassign, 32856),  // __builtin_HEXAGON_V6_vassign
    new BuiltinEntry(ID.hexagon_V6_vassign_128B, 32885),  // __builtin_HEXAGON_V6_vassign_128B
    new BuiltinEntry(ID.hexagon_V6_vassignp, 32919),  // __builtin_HEXAGON_V6_vassignp
    new BuiltinEntry(ID.hexagon_V6_vassignp_128B, 32949),  // __builtin_HEXAGON_V6_vassignp_128B
    new BuiltinEntry(ID.hexagon_V6_vavgh, 32984),  // __builtin_HEXAGON_V6_vavgh
    new BuiltinEntry(ID.hexagon_V6_vavgh_128B, 33011),  // __builtin_HEXAGON_V6_vavgh_128B
    new BuiltinEntry(ID.hexagon_V6_vavghrnd, 33043),  // __builtin_HEXAGON_V6_vavghrnd
    new BuiltinEntry(ID.hexagon_V6_vavghrnd_128B, 33073),  // __builtin_HEXAGON_V6_vavghrnd_128B
    new BuiltinEntry(ID.hexagon_V6_vavgub, 33108),  // __builtin_HEXAGON_V6_vavgub
    new BuiltinEntry(ID.hexagon_V6_vavgub_128B, 33136),  // __builtin_HEXAGON_V6_vavgub_128B
    new BuiltinEntry(ID.hexagon_V6_vavgubrnd, 33169),  // __builtin_HEXAGON_V6_vavgubrnd
    new BuiltinEntry(ID.hexagon_V6_vavgubrnd_128B, 33200),  // __builtin_HEXAGON_V6_vavgubrnd_128B
    new BuiltinEntry(ID.hexagon_V6_vavguh, 33236),  // __builtin_HEXAGON_V6_vavguh
    new BuiltinEntry(ID.hexagon_V6_vavguh_128B, 33264),  // __builtin_HEXAGON_V6_vavguh_128B
    new BuiltinEntry(ID.hexagon_V6_vavguhrnd, 33297),  // __builtin_HEXAGON_V6_vavguhrnd
    new BuiltinEntry(ID.hexagon_V6_vavguhrnd_128B, 33328),  // __builtin_HEXAGON_V6_vavguhrnd_128B
    new BuiltinEntry(ID.hexagon_V6_vavgw, 33364),  // __builtin_HEXAGON_V6_vavgw
    new BuiltinEntry(ID.hexagon_V6_vavgw_128B, 33391),  // __builtin_HEXAGON_V6_vavgw_128B
    new BuiltinEntry(ID.hexagon_V6_vavgwrnd, 33423),  // __builtin_HEXAGON_V6_vavgwrnd
    new BuiltinEntry(ID.hexagon_V6_vavgwrnd_128B, 33453),  // __builtin_HEXAGON_V6_vavgwrnd_128B
    new BuiltinEntry(ID.hexagon_V6_vcl0h, 33488),  // __builtin_HEXAGON_V6_vcl0h
    new BuiltinEntry(ID.hexagon_V6_vcl0h_128B, 33515),  // __builtin_HEXAGON_V6_vcl0h_128B
    new BuiltinEntry(ID.hexagon_V6_vcl0w, 33547),  // __builtin_HEXAGON_V6_vcl0w
    new BuiltinEntry(ID.hexagon_V6_vcl0w_128B, 33574),  // __builtin_HEXAGON_V6_vcl0w_128B
    new BuiltinEntry(ID.hexagon_V6_vcombine, 33606),  // __builtin_HEXAGON_V6_vcombine
    new BuiltinEntry(ID.hexagon_V6_vcombine_128B, 33636),  // __builtin_HEXAGON_V6_vcombine_128B
    new BuiltinEntry(ID.hexagon_V6_vd0, 33671),  // __builtin_HEXAGON_V6_vd0
    new BuiltinEntry(ID.hexagon_V6_vd0_128B, 33696),  // __builtin_HEXAGON_V6_vd0_128B
    new BuiltinEntry(ID.hexagon_V6_vdealb, 33726),  // __builtin_HEXAGON_V6_vdealb
    new BuiltinEntry(ID.hexagon_V6_vdealb4w, 33787),  // __builtin_HEXAGON_V6_vdealb4w
    new BuiltinEntry(ID.hexagon_V6_vdealb4w_128B, 33817),  // __builtin_HEXAGON_V6_vdealb4w_128B
    new BuiltinEntry(ID.hexagon_V6_vdealb_128B, 33754),  // __builtin_HEXAGON_V6_vdealb_128B
    new BuiltinEntry(ID.hexagon_V6_vdealh, 33852),  // __builtin_HEXAGON_V6_vdealh
    new BuiltinEntry(ID.hexagon_V6_vdealh_128B, 33880),  // __builtin_HEXAGON_V6_vdealh_128B
    new BuiltinEntry(ID.hexagon_V6_vdealvdd, 33913),  // __builtin_HEXAGON_V6_vdealvdd
    new BuiltinEntry(ID.hexagon_V6_vdealvdd_128B, 33943),  // __builtin_HEXAGON_V6_vdealvdd_128B
    new BuiltinEntry(ID.hexagon_V6_vdelta, 33978),  // __builtin_HEXAGON_V6_vdelta
    new BuiltinEntry(ID.hexagon_V6_vdelta_128B, 34006),  // __builtin_HEXAGON_V6_vdelta_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpybus, 34039),  // __builtin_HEXAGON_V6_vdmpybus
    new BuiltinEntry(ID.hexagon_V6_vdmpybus_128B, 34069),  // __builtin_HEXAGON_V6_vdmpybus_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpybus_acc, 34104),  // __builtin_HEXAGON_V6_vdmpybus_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpybus_acc_128B, 34138),  // __builtin_HEXAGON_V6_vdmpybus_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpybus_dv, 34177),  // __builtin_HEXAGON_V6_vdmpybus_dv
    new BuiltinEntry(ID.hexagon_V6_vdmpybus_dv_128B, 34210),  // __builtin_HEXAGON_V6_vdmpybus_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpybus_dv_acc, 34248),  // __builtin_HEXAGON_V6_vdmpybus_dv_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpybus_dv_acc_128B, 34285),  // __builtin_HEXAGON_V6_vdmpybus_dv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhb, 34327),  // __builtin_HEXAGON_V6_vdmpyhb
    new BuiltinEntry(ID.hexagon_V6_vdmpyhb_128B, 34356),  // __builtin_HEXAGON_V6_vdmpyhb_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhb_acc, 34390),  // __builtin_HEXAGON_V6_vdmpyhb_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpyhb_acc_128B, 34423),  // __builtin_HEXAGON_V6_vdmpyhb_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhb_dv, 34461),  // __builtin_HEXAGON_V6_vdmpyhb_dv
    new BuiltinEntry(ID.hexagon_V6_vdmpyhb_dv_128B, 34493),  // __builtin_HEXAGON_V6_vdmpyhb_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhb_dv_acc, 34530),  // __builtin_HEXAGON_V6_vdmpyhb_dv_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpyhb_dv_acc_128B, 34566),  // __builtin_HEXAGON_V6_vdmpyhb_dv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhisat, 34607),  // __builtin_HEXAGON_V6_vdmpyhisat
    new BuiltinEntry(ID.hexagon_V6_vdmpyhisat_128B, 34639),  // __builtin_HEXAGON_V6_vdmpyhisat_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhisat_acc, 34676),  // __builtin_HEXAGON_V6_vdmpyhisat_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpyhisat_acc_128B, 34712),  // __builtin_HEXAGON_V6_vdmpyhisat_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsat, 34753),  // __builtin_HEXAGON_V6_vdmpyhsat
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsat_128B, 34784),  // __builtin_HEXAGON_V6_vdmpyhsat_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsat_acc, 34820),  // __builtin_HEXAGON_V6_vdmpyhsat_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsat_acc_128B, 34855),  // __builtin_HEXAGON_V6_vdmpyhsat_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsuisat, 34895),  // __builtin_HEXAGON_V6_vdmpyhsuisat
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsuisat_128B, 34929),  // __builtin_HEXAGON_V6_vdmpyhsuisat_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsuisat_acc, 34968),  // __builtin_HEXAGON_V6_vdmpyhsuisat_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsuisat_acc_128B, 35006),  // __builtin_HEXAGON_V6_vdmpyhsuisat_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsusat, 35049),  // __builtin_HEXAGON_V6_vdmpyhsusat
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsusat_128B, 35082),  // __builtin_HEXAGON_V6_vdmpyhsusat_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsusat_acc, 35120),  // __builtin_HEXAGON_V6_vdmpyhsusat_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpyhsusat_acc_128B, 35157),  // __builtin_HEXAGON_V6_vdmpyhsusat_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhvsat, 35199),  // __builtin_HEXAGON_V6_vdmpyhvsat
    new BuiltinEntry(ID.hexagon_V6_vdmpyhvsat_128B, 35231),  // __builtin_HEXAGON_V6_vdmpyhvsat_128B
    new BuiltinEntry(ID.hexagon_V6_vdmpyhvsat_acc, 35268),  // __builtin_HEXAGON_V6_vdmpyhvsat_acc
    new BuiltinEntry(ID.hexagon_V6_vdmpyhvsat_acc_128B, 35304),  // __builtin_HEXAGON_V6_vdmpyhvsat_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vdsaduh, 35345),  // __builtin_HEXAGON_V6_vdsaduh
    new BuiltinEntry(ID.hexagon_V6_vdsaduh_128B, 35374),  // __builtin_HEXAGON_V6_vdsaduh_128B
    new BuiltinEntry(ID.hexagon_V6_vdsaduh_acc, 35408),  // __builtin_HEXAGON_V6_vdsaduh_acc
    new BuiltinEntry(ID.hexagon_V6_vdsaduh_acc_128B, 35441),  // __builtin_HEXAGON_V6_vdsaduh_acc_128B
    new BuiltinEntry(ID.hexagon_V6_veqb, 35479),  // __builtin_HEXAGON_V6_veqb
    new BuiltinEntry(ID.hexagon_V6_veqb_128B, 35505),  // __builtin_HEXAGON_V6_veqb_128B
    new BuiltinEntry(ID.hexagon_V6_veqb_and, 35536),  // __builtin_HEXAGON_V6_veqb_and
    new BuiltinEntry(ID.hexagon_V6_veqb_and_128B, 35566),  // __builtin_HEXAGON_V6_veqb_and_128B
    new BuiltinEntry(ID.hexagon_V6_veqb_or, 35601),  // __builtin_HEXAGON_V6_veqb_or
    new BuiltinEntry(ID.hexagon_V6_veqb_or_128B, 35630),  // __builtin_HEXAGON_V6_veqb_or_128B
    new BuiltinEntry(ID.hexagon_V6_veqb_xor, 35664),  // __builtin_HEXAGON_V6_veqb_xor
    new BuiltinEntry(ID.hexagon_V6_veqb_xor_128B, 35694),  // __builtin_HEXAGON_V6_veqb_xor_128B
    new BuiltinEntry(ID.hexagon_V6_veqh, 35729),  // __builtin_HEXAGON_V6_veqh
    new BuiltinEntry(ID.hexagon_V6_veqh_128B, 35755),  // __builtin_HEXAGON_V6_veqh_128B
    new BuiltinEntry(ID.hexagon_V6_veqh_and, 35786),  // __builtin_HEXAGON_V6_veqh_and
    new BuiltinEntry(ID.hexagon_V6_veqh_and_128B, 35816),  // __builtin_HEXAGON_V6_veqh_and_128B
    new BuiltinEntry(ID.hexagon_V6_veqh_or, 35851),  // __builtin_HEXAGON_V6_veqh_or
    new BuiltinEntry(ID.hexagon_V6_veqh_or_128B, 35880),  // __builtin_HEXAGON_V6_veqh_or_128B
    new BuiltinEntry(ID.hexagon_V6_veqh_xor, 35914),  // __builtin_HEXAGON_V6_veqh_xor
    new BuiltinEntry(ID.hexagon_V6_veqh_xor_128B, 35944),  // __builtin_HEXAGON_V6_veqh_xor_128B
    new BuiltinEntry(ID.hexagon_V6_veqw, 35979),  // __builtin_HEXAGON_V6_veqw
    new BuiltinEntry(ID.hexagon_V6_veqw_128B, 36005),  // __builtin_HEXAGON_V6_veqw_128B
    new BuiltinEntry(ID.hexagon_V6_veqw_and, 36036),  // __builtin_HEXAGON_V6_veqw_and
    new BuiltinEntry(ID.hexagon_V6_veqw_and_128B, 36066),  // __builtin_HEXAGON_V6_veqw_and_128B
    new BuiltinEntry(ID.hexagon_V6_veqw_or, 36101),  // __builtin_HEXAGON_V6_veqw_or
    new BuiltinEntry(ID.hexagon_V6_veqw_or_128B, 36130),  // __builtin_HEXAGON_V6_veqw_or_128B
    new BuiltinEntry(ID.hexagon_V6_veqw_xor, 36164),  // __builtin_HEXAGON_V6_veqw_xor
    new BuiltinEntry(ID.hexagon_V6_veqw_xor_128B, 36194),  // __builtin_HEXAGON_V6_veqw_xor_128B
    new BuiltinEntry(ID.hexagon_V6_vgtb, 36229),  // __builtin_HEXAGON_V6_vgtb
    new BuiltinEntry(ID.hexagon_V6_vgtb_128B, 36255),  // __builtin_HEXAGON_V6_vgtb_128B
    new BuiltinEntry(ID.hexagon_V6_vgtb_and, 36286),  // __builtin_HEXAGON_V6_vgtb_and
    new BuiltinEntry(ID.hexagon_V6_vgtb_and_128B, 36316),  // __builtin_HEXAGON_V6_vgtb_and_128B
    new BuiltinEntry(ID.hexagon_V6_vgtb_or, 36351),  // __builtin_HEXAGON_V6_vgtb_or
    new BuiltinEntry(ID.hexagon_V6_vgtb_or_128B, 36380),  // __builtin_HEXAGON_V6_vgtb_or_128B
    new BuiltinEntry(ID.hexagon_V6_vgtb_xor, 36414),  // __builtin_HEXAGON_V6_vgtb_xor
    new BuiltinEntry(ID.hexagon_V6_vgtb_xor_128B, 36444),  // __builtin_HEXAGON_V6_vgtb_xor_128B
    new BuiltinEntry(ID.hexagon_V6_vgth, 36479),  // __builtin_HEXAGON_V6_vgth
    new BuiltinEntry(ID.hexagon_V6_vgth_128B, 36505),  // __builtin_HEXAGON_V6_vgth_128B
    new BuiltinEntry(ID.hexagon_V6_vgth_and, 36536),  // __builtin_HEXAGON_V6_vgth_and
    new BuiltinEntry(ID.hexagon_V6_vgth_and_128B, 36566),  // __builtin_HEXAGON_V6_vgth_and_128B
    new BuiltinEntry(ID.hexagon_V6_vgth_or, 36601),  // __builtin_HEXAGON_V6_vgth_or
    new BuiltinEntry(ID.hexagon_V6_vgth_or_128B, 36630),  // __builtin_HEXAGON_V6_vgth_or_128B
    new BuiltinEntry(ID.hexagon_V6_vgth_xor, 36664),  // __builtin_HEXAGON_V6_vgth_xor
    new BuiltinEntry(ID.hexagon_V6_vgth_xor_128B, 36694),  // __builtin_HEXAGON_V6_vgth_xor_128B
    new BuiltinEntry(ID.hexagon_V6_vgtub, 36729),  // __builtin_HEXAGON_V6_vgtub
    new BuiltinEntry(ID.hexagon_V6_vgtub_128B, 36756),  // __builtin_HEXAGON_V6_vgtub_128B
    new BuiltinEntry(ID.hexagon_V6_vgtub_and, 36788),  // __builtin_HEXAGON_V6_vgtub_and
    new BuiltinEntry(ID.hexagon_V6_vgtub_and_128B, 36819),  // __builtin_HEXAGON_V6_vgtub_and_128B
    new BuiltinEntry(ID.hexagon_V6_vgtub_or, 36855),  // __builtin_HEXAGON_V6_vgtub_or
    new BuiltinEntry(ID.hexagon_V6_vgtub_or_128B, 36885),  // __builtin_HEXAGON_V6_vgtub_or_128B
    new BuiltinEntry(ID.hexagon_V6_vgtub_xor, 36920),  // __builtin_HEXAGON_V6_vgtub_xor
    new BuiltinEntry(ID.hexagon_V6_vgtub_xor_128B, 36951),  // __builtin_HEXAGON_V6_vgtub_xor_128B
    new BuiltinEntry(ID.hexagon_V6_vgtuh, 36987),  // __builtin_HEXAGON_V6_vgtuh
    new BuiltinEntry(ID.hexagon_V6_vgtuh_128B, 37014),  // __builtin_HEXAGON_V6_vgtuh_128B
    new BuiltinEntry(ID.hexagon_V6_vgtuh_and, 37046),  // __builtin_HEXAGON_V6_vgtuh_and
    new BuiltinEntry(ID.hexagon_V6_vgtuh_and_128B, 37077),  // __builtin_HEXAGON_V6_vgtuh_and_128B
    new BuiltinEntry(ID.hexagon_V6_vgtuh_or, 37113),  // __builtin_HEXAGON_V6_vgtuh_or
    new BuiltinEntry(ID.hexagon_V6_vgtuh_or_128B, 37143),  // __builtin_HEXAGON_V6_vgtuh_or_128B
    new BuiltinEntry(ID.hexagon_V6_vgtuh_xor, 37178),  // __builtin_HEXAGON_V6_vgtuh_xor
    new BuiltinEntry(ID.hexagon_V6_vgtuh_xor_128B, 37209),  // __builtin_HEXAGON_V6_vgtuh_xor_128B
    new BuiltinEntry(ID.hexagon_V6_vgtuw, 37245),  // __builtin_HEXAGON_V6_vgtuw
    new BuiltinEntry(ID.hexagon_V6_vgtuw_128B, 37272),  // __builtin_HEXAGON_V6_vgtuw_128B
    new BuiltinEntry(ID.hexagon_V6_vgtuw_and, 37304),  // __builtin_HEXAGON_V6_vgtuw_and
    new BuiltinEntry(ID.hexagon_V6_vgtuw_and_128B, 37335),  // __builtin_HEXAGON_V6_vgtuw_and_128B
    new BuiltinEntry(ID.hexagon_V6_vgtuw_or, 37371),  // __builtin_HEXAGON_V6_vgtuw_or
    new BuiltinEntry(ID.hexagon_V6_vgtuw_or_128B, 37401),  // __builtin_HEXAGON_V6_vgtuw_or_128B
    new BuiltinEntry(ID.hexagon_V6_vgtuw_xor, 37436),  // __builtin_HEXAGON_V6_vgtuw_xor
    new BuiltinEntry(ID.hexagon_V6_vgtuw_xor_128B, 37467),  // __builtin_HEXAGON_V6_vgtuw_xor_128B
    new BuiltinEntry(ID.hexagon_V6_vgtw, 37503),  // __builtin_HEXAGON_V6_vgtw
    new BuiltinEntry(ID.hexagon_V6_vgtw_128B, 37529),  // __builtin_HEXAGON_V6_vgtw_128B
    new BuiltinEntry(ID.hexagon_V6_vgtw_and, 37560),  // __builtin_HEXAGON_V6_vgtw_and
    new BuiltinEntry(ID.hexagon_V6_vgtw_and_128B, 37590),  // __builtin_HEXAGON_V6_vgtw_and_128B
    new BuiltinEntry(ID.hexagon_V6_vgtw_or, 37625),  // __builtin_HEXAGON_V6_vgtw_or
    new BuiltinEntry(ID.hexagon_V6_vgtw_or_128B, 37654),  // __builtin_HEXAGON_V6_vgtw_or_128B
    new BuiltinEntry(ID.hexagon_V6_vgtw_xor, 37688),  // __builtin_HEXAGON_V6_vgtw_xor
    new BuiltinEntry(ID.hexagon_V6_vgtw_xor_128B, 37718),  // __builtin_HEXAGON_V6_vgtw_xor_128B
    new BuiltinEntry(ID.hexagon_V6_vinsertwr, 37753),  // __builtin_HEXAGON_V6_vinsertwr
    new BuiltinEntry(ID.hexagon_V6_vinsertwr_128B, 37784),  // __builtin_HEXAGON_V6_vinsertwr_128B
    new BuiltinEntry(ID.hexagon_V6_vlalignb, 37820),  // __builtin_HEXAGON_V6_vlalignb
    new BuiltinEntry(ID.hexagon_V6_vlalignb_128B, 37850),  // __builtin_HEXAGON_V6_vlalignb_128B
    new BuiltinEntry(ID.hexagon_V6_vlalignbi, 37885),  // __builtin_HEXAGON_V6_vlalignbi
    new BuiltinEntry(ID.hexagon_V6_vlalignbi_128B, 37916),  // __builtin_HEXAGON_V6_vlalignbi_128B
    new BuiltinEntry(ID.hexagon_V6_vlsrh, 37952),  // __builtin_HEXAGON_V6_vlsrh
    new BuiltinEntry(ID.hexagon_V6_vlsrh_128B, 37979),  // __builtin_HEXAGON_V6_vlsrh_128B
    new BuiltinEntry(ID.hexagon_V6_vlsrhv, 38011),  // __builtin_HEXAGON_V6_vlsrhv
    new BuiltinEntry(ID.hexagon_V6_vlsrhv_128B, 38039),  // __builtin_HEXAGON_V6_vlsrhv_128B
    new BuiltinEntry(ID.hexagon_V6_vlsrw, 38072),  // __builtin_HEXAGON_V6_vlsrw
    new BuiltinEntry(ID.hexagon_V6_vlsrw_128B, 38099),  // __builtin_HEXAGON_V6_vlsrw_128B
    new BuiltinEntry(ID.hexagon_V6_vlsrwv, 38131),  // __builtin_HEXAGON_V6_vlsrwv
    new BuiltinEntry(ID.hexagon_V6_vlsrwv_128B, 38159),  // __builtin_HEXAGON_V6_vlsrwv_128B
    new BuiltinEntry(ID.hexagon_V6_vlutb, 38192),  // __builtin_HEXAGON_V6_vlutb
    new BuiltinEntry(ID.hexagon_V6_vlutb_128B, 38219),  // __builtin_HEXAGON_V6_vlutb_128B
    new BuiltinEntry(ID.hexagon_V6_vlutb_acc, 38251),  // __builtin_HEXAGON_V6_vlutb_acc
    new BuiltinEntry(ID.hexagon_V6_vlutb_acc_128B, 38282),  // __builtin_HEXAGON_V6_vlutb_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vlutb_dv, 38318),  // __builtin_HEXAGON_V6_vlutb_dv
    new BuiltinEntry(ID.hexagon_V6_vlutb_dv_128B, 38348),  // __builtin_HEXAGON_V6_vlutb_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vlutb_dv_acc, 38383),  // __builtin_HEXAGON_V6_vlutb_dv_acc
    new BuiltinEntry(ID.hexagon_V6_vlutb_dv_acc_128B, 38417),  // __builtin_HEXAGON_V6_vlutb_dv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vlutvvb, 38456),  // __builtin_HEXAGON_V6_vlutvvb
    new BuiltinEntry(ID.hexagon_V6_vlutvvb_128B, 38485),  // __builtin_HEXAGON_V6_vlutvvb_128B
    new BuiltinEntry(ID.hexagon_V6_vlutvvb_oracc, 38519),  // __builtin_HEXAGON_V6_vlutvvb_oracc
    new BuiltinEntry(ID.hexagon_V6_vlutvvb_oracc_128B, 38554),  // __builtin_HEXAGON_V6_vlutvvb_oracc_128B
    new BuiltinEntry(ID.hexagon_V6_vlutvwh, 38594),  // __builtin_HEXAGON_V6_vlutvwh
    new BuiltinEntry(ID.hexagon_V6_vlutvwh_128B, 38623),  // __builtin_HEXAGON_V6_vlutvwh_128B
    new BuiltinEntry(ID.hexagon_V6_vlutvwh_oracc, 38657),  // __builtin_HEXAGON_V6_vlutvwh_oracc
    new BuiltinEntry(ID.hexagon_V6_vlutvwh_oracc_128B, 38692),  // __builtin_HEXAGON_V6_vlutvwh_oracc_128B
    new BuiltinEntry(ID.hexagon_V6_vmaxh, 38732),  // __builtin_HEXAGON_V6_vmaxh
    new BuiltinEntry(ID.hexagon_V6_vmaxh_128B, 38759),  // __builtin_HEXAGON_V6_vmaxh_128B
    new BuiltinEntry(ID.hexagon_V6_vmaxub, 38791),  // __builtin_HEXAGON_V6_vmaxub
    new BuiltinEntry(ID.hexagon_V6_vmaxub_128B, 38819),  // __builtin_HEXAGON_V6_vmaxub_128B
    new BuiltinEntry(ID.hexagon_V6_vmaxuh, 38852),  // __builtin_HEXAGON_V6_vmaxuh
    new BuiltinEntry(ID.hexagon_V6_vmaxuh_128B, 38880),  // __builtin_HEXAGON_V6_vmaxuh_128B
    new BuiltinEntry(ID.hexagon_V6_vmaxw, 38913),  // __builtin_HEXAGON_V6_vmaxw
    new BuiltinEntry(ID.hexagon_V6_vmaxw_128B, 38940),  // __builtin_HEXAGON_V6_vmaxw_128B
    new BuiltinEntry(ID.hexagon_V6_vminh, 38972),  // __builtin_HEXAGON_V6_vminh
    new BuiltinEntry(ID.hexagon_V6_vminh_128B, 38999),  // __builtin_HEXAGON_V6_vminh_128B
    new BuiltinEntry(ID.hexagon_V6_vminub, 39031),  // __builtin_HEXAGON_V6_vminub
    new BuiltinEntry(ID.hexagon_V6_vminub_128B, 39059),  // __builtin_HEXAGON_V6_vminub_128B
    new BuiltinEntry(ID.hexagon_V6_vminuh, 39092),  // __builtin_HEXAGON_V6_vminuh
    new BuiltinEntry(ID.hexagon_V6_vminuh_128B, 39120),  // __builtin_HEXAGON_V6_vminuh_128B
    new BuiltinEntry(ID.hexagon_V6_vminw, 39153),  // __builtin_HEXAGON_V6_vminw
    new BuiltinEntry(ID.hexagon_V6_vminw_128B, 39180),  // __builtin_HEXAGON_V6_vminw_128B
    new BuiltinEntry(ID.hexagon_V6_vmpabus, 39212),  // __builtin_HEXAGON_V6_vmpabus
    new BuiltinEntry(ID.hexagon_V6_vmpabus_128B, 39241),  // __builtin_HEXAGON_V6_vmpabus_128B
    new BuiltinEntry(ID.hexagon_V6_vmpabus_acc, 39275),  // __builtin_HEXAGON_V6_vmpabus_acc
    new BuiltinEntry(ID.hexagon_V6_vmpabus_acc_128B, 39308),  // __builtin_HEXAGON_V6_vmpabus_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpabusv, 39346),  // __builtin_HEXAGON_V6_vmpabusv
    new BuiltinEntry(ID.hexagon_V6_vmpabusv_128B, 39376),  // __builtin_HEXAGON_V6_vmpabusv_128B
    new BuiltinEntry(ID.hexagon_V6_vmpabuuv, 39411),  // __builtin_HEXAGON_V6_vmpabuuv
    new BuiltinEntry(ID.hexagon_V6_vmpabuuv_128B, 39441),  // __builtin_HEXAGON_V6_vmpabuuv_128B
    new BuiltinEntry(ID.hexagon_V6_vmpahb, 39476),  // __builtin_HEXAGON_V6_vmpahb
    new BuiltinEntry(ID.hexagon_V6_vmpahb_128B, 39504),  // __builtin_HEXAGON_V6_vmpahb_128B
    new BuiltinEntry(ID.hexagon_V6_vmpahb_acc, 39537),  // __builtin_HEXAGON_V6_vmpahb_acc
    new BuiltinEntry(ID.hexagon_V6_vmpahb_acc_128B, 39569),  // __builtin_HEXAGON_V6_vmpahb_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpybus, 39606),  // __builtin_HEXAGON_V6_vmpybus
    new BuiltinEntry(ID.hexagon_V6_vmpybus_128B, 39635),  // __builtin_HEXAGON_V6_vmpybus_128B
    new BuiltinEntry(ID.hexagon_V6_vmpybus_acc, 39669),  // __builtin_HEXAGON_V6_vmpybus_acc
    new BuiltinEntry(ID.hexagon_V6_vmpybus_acc_128B, 39702),  // __builtin_HEXAGON_V6_vmpybus_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpybusv, 39740),  // __builtin_HEXAGON_V6_vmpybusv
    new BuiltinEntry(ID.hexagon_V6_vmpybusv_128B, 39770),  // __builtin_HEXAGON_V6_vmpybusv_128B
    new BuiltinEntry(ID.hexagon_V6_vmpybusv_acc, 39805),  // __builtin_HEXAGON_V6_vmpybusv_acc
    new BuiltinEntry(ID.hexagon_V6_vmpybusv_acc_128B, 39839),  // __builtin_HEXAGON_V6_vmpybusv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpybv, 39878),  // __builtin_HEXAGON_V6_vmpybv
    new BuiltinEntry(ID.hexagon_V6_vmpybv_128B, 39906),  // __builtin_HEXAGON_V6_vmpybv_128B
    new BuiltinEntry(ID.hexagon_V6_vmpybv_acc, 39939),  // __builtin_HEXAGON_V6_vmpybv_acc
    new BuiltinEntry(ID.hexagon_V6_vmpybv_acc_128B, 39971),  // __builtin_HEXAGON_V6_vmpybv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyewuh, 40008),  // __builtin_HEXAGON_V6_vmpyewuh
    new BuiltinEntry(ID.hexagon_V6_vmpyewuh_128B, 40038),  // __builtin_HEXAGON_V6_vmpyewuh_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyh, 40073),  // __builtin_HEXAGON_V6_vmpyh
    new BuiltinEntry(ID.hexagon_V6_vmpyh_128B, 40100),  // __builtin_HEXAGON_V6_vmpyh_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyhsat_acc, 40132),  // __builtin_HEXAGON_V6_vmpyhsat_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyhsat_acc_128B, 40166),  // __builtin_HEXAGON_V6_vmpyhsat_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyhsrs, 40205),  // __builtin_HEXAGON_V6_vmpyhsrs
    new BuiltinEntry(ID.hexagon_V6_vmpyhsrs_128B, 40235),  // __builtin_HEXAGON_V6_vmpyhsrs_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyhss, 40270),  // __builtin_HEXAGON_V6_vmpyhss
    new BuiltinEntry(ID.hexagon_V6_vmpyhss_128B, 40299),  // __builtin_HEXAGON_V6_vmpyhss_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyhus, 40333),  // __builtin_HEXAGON_V6_vmpyhus
    new BuiltinEntry(ID.hexagon_V6_vmpyhus_128B, 40362),  // __builtin_HEXAGON_V6_vmpyhus_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyhus_acc, 40396),  // __builtin_HEXAGON_V6_vmpyhus_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyhus_acc_128B, 40429),  // __builtin_HEXAGON_V6_vmpyhus_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyhv, 40467),  // __builtin_HEXAGON_V6_vmpyhv
    new BuiltinEntry(ID.hexagon_V6_vmpyhv_128B, 40495),  // __builtin_HEXAGON_V6_vmpyhv_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyhv_acc, 40528),  // __builtin_HEXAGON_V6_vmpyhv_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyhv_acc_128B, 40560),  // __builtin_HEXAGON_V6_vmpyhv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyhvsrs, 40597),  // __builtin_HEXAGON_V6_vmpyhvsrs
    new BuiltinEntry(ID.hexagon_V6_vmpyhvsrs_128B, 40628),  // __builtin_HEXAGON_V6_vmpyhvsrs_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyieoh, 40664),  // __builtin_HEXAGON_V6_vmpyieoh
    new BuiltinEntry(ID.hexagon_V6_vmpyieoh_128B, 40694),  // __builtin_HEXAGON_V6_vmpyieoh_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyiewh_acc, 40729),  // __builtin_HEXAGON_V6_vmpyiewh_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyiewh_acc_128B, 40763),  // __builtin_HEXAGON_V6_vmpyiewh_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyiewuh, 40802),  // __builtin_HEXAGON_V6_vmpyiewuh
    new BuiltinEntry(ID.hexagon_V6_vmpyiewuh_128B, 40833),  // __builtin_HEXAGON_V6_vmpyiewuh_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyiewuh_acc, 40869),  // __builtin_HEXAGON_V6_vmpyiewuh_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyiewuh_acc_128B, 40904),  // __builtin_HEXAGON_V6_vmpyiewuh_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyih, 40944),  // __builtin_HEXAGON_V6_vmpyih
    new BuiltinEntry(ID.hexagon_V6_vmpyih_128B, 40972),  // __builtin_HEXAGON_V6_vmpyih_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyih_acc, 41005),  // __builtin_HEXAGON_V6_vmpyih_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyih_acc_128B, 41037),  // __builtin_HEXAGON_V6_vmpyih_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyihb, 41074),  // __builtin_HEXAGON_V6_vmpyihb
    new BuiltinEntry(ID.hexagon_V6_vmpyihb_128B, 41103),  // __builtin_HEXAGON_V6_vmpyihb_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyihb_acc, 41137),  // __builtin_HEXAGON_V6_vmpyihb_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyihb_acc_128B, 41170),  // __builtin_HEXAGON_V6_vmpyihb_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyiowh, 41208),  // __builtin_HEXAGON_V6_vmpyiowh
    new BuiltinEntry(ID.hexagon_V6_vmpyiowh_128B, 41238),  // __builtin_HEXAGON_V6_vmpyiowh_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyiwb, 41273),  // __builtin_HEXAGON_V6_vmpyiwb
    new BuiltinEntry(ID.hexagon_V6_vmpyiwb_128B, 41302),  // __builtin_HEXAGON_V6_vmpyiwb_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyiwb_acc, 41336),  // __builtin_HEXAGON_V6_vmpyiwb_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyiwb_acc_128B, 41369),  // __builtin_HEXAGON_V6_vmpyiwb_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyiwh, 41407),  // __builtin_HEXAGON_V6_vmpyiwh
    new BuiltinEntry(ID.hexagon_V6_vmpyiwh_128B, 41436),  // __builtin_HEXAGON_V6_vmpyiwh_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyiwh_acc, 41470),  // __builtin_HEXAGON_V6_vmpyiwh_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyiwh_acc_128B, 41503),  // __builtin_HEXAGON_V6_vmpyiwh_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyowh, 41541),  // __builtin_HEXAGON_V6_vmpyowh
    new BuiltinEntry(ID.hexagon_V6_vmpyowh_128B, 41570),  // __builtin_HEXAGON_V6_vmpyowh_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyowh_rnd, 41604),  // __builtin_HEXAGON_V6_vmpyowh_rnd
    new BuiltinEntry(ID.hexagon_V6_vmpyowh_rnd_128B, 41637),  // __builtin_HEXAGON_V6_vmpyowh_rnd_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyowh_rnd_sacc, 41675),  // __builtin_HEXAGON_V6_vmpyowh_rnd_sacc
    new BuiltinEntry(ID.hexagon_V6_vmpyowh_rnd_sacc_128B, 41713),  // __builtin_HEXAGON_V6_vmpyowh_rnd_sacc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyowh_sacc, 41756),  // __builtin_HEXAGON_V6_vmpyowh_sacc
    new BuiltinEntry(ID.hexagon_V6_vmpyowh_sacc_128B, 41790),  // __builtin_HEXAGON_V6_vmpyowh_sacc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyub, 41829),  // __builtin_HEXAGON_V6_vmpyub
    new BuiltinEntry(ID.hexagon_V6_vmpyub_128B, 41857),  // __builtin_HEXAGON_V6_vmpyub_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyub_acc, 41890),  // __builtin_HEXAGON_V6_vmpyub_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyub_acc_128B, 41922),  // __builtin_HEXAGON_V6_vmpyub_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyubv, 41959),  // __builtin_HEXAGON_V6_vmpyubv
    new BuiltinEntry(ID.hexagon_V6_vmpyubv_128B, 41988),  // __builtin_HEXAGON_V6_vmpyubv_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyubv_acc, 42022),  // __builtin_HEXAGON_V6_vmpyubv_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyubv_acc_128B, 42055),  // __builtin_HEXAGON_V6_vmpyubv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyuh, 42093),  // __builtin_HEXAGON_V6_vmpyuh
    new BuiltinEntry(ID.hexagon_V6_vmpyuh_128B, 42121),  // __builtin_HEXAGON_V6_vmpyuh_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyuh_acc, 42154),  // __builtin_HEXAGON_V6_vmpyuh_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyuh_acc_128B, 42186),  // __builtin_HEXAGON_V6_vmpyuh_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyuhv, 42223),  // __builtin_HEXAGON_V6_vmpyuhv
    new BuiltinEntry(ID.hexagon_V6_vmpyuhv_128B, 42252),  // __builtin_HEXAGON_V6_vmpyuhv_128B
    new BuiltinEntry(ID.hexagon_V6_vmpyuhv_acc, 42286),  // __builtin_HEXAGON_V6_vmpyuhv_acc
    new BuiltinEntry(ID.hexagon_V6_vmpyuhv_acc_128B, 42319),  // __builtin_HEXAGON_V6_vmpyuhv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vmux, 42357),  // __builtin_HEXAGON_V6_vmux
    new BuiltinEntry(ID.hexagon_V6_vmux_128B, 42383),  // __builtin_HEXAGON_V6_vmux_128B
    new BuiltinEntry(ID.hexagon_V6_vnavgh, 42414),  // __builtin_HEXAGON_V6_vnavgh
    new BuiltinEntry(ID.hexagon_V6_vnavgh_128B, 42442),  // __builtin_HEXAGON_V6_vnavgh_128B
    new BuiltinEntry(ID.hexagon_V6_vnavgub, 42475),  // __builtin_HEXAGON_V6_vnavgub
    new BuiltinEntry(ID.hexagon_V6_vnavgub_128B, 42504),  // __builtin_HEXAGON_V6_vnavgub_128B
    new BuiltinEntry(ID.hexagon_V6_vnavgw, 42538),  // __builtin_HEXAGON_V6_vnavgw
    new BuiltinEntry(ID.hexagon_V6_vnavgw_128B, 42566),  // __builtin_HEXAGON_V6_vnavgw_128B
    new BuiltinEntry(ID.hexagon_V6_vnormamth, 42599),  // __builtin_HEXAGON_V6_vnormamth
    new BuiltinEntry(ID.hexagon_V6_vnormamth_128B, 42630),  // __builtin_HEXAGON_V6_vnormamth_128B
    new BuiltinEntry(ID.hexagon_V6_vnormamtw, 42666),  // __builtin_HEXAGON_V6_vnormamtw
    new BuiltinEntry(ID.hexagon_V6_vnormamtw_128B, 42697),  // __builtin_HEXAGON_V6_vnormamtw_128B
    new BuiltinEntry(ID.hexagon_V6_vnot, 42733),  // __builtin_HEXAGON_V6_vnot
    new BuiltinEntry(ID.hexagon_V6_vnot_128B, 42759),  // __builtin_HEXAGON_V6_vnot_128B
    new BuiltinEntry(ID.hexagon_V6_vor, 42790),  // __builtin_HEXAGON_V6_vor
    new BuiltinEntry(ID.hexagon_V6_vor_128B, 42815),  // __builtin_HEXAGON_V6_vor_128B
    new BuiltinEntry(ID.hexagon_V6_vpackeb, 42845),  // __builtin_HEXAGON_V6_vpackeb
    new BuiltinEntry(ID.hexagon_V6_vpackeb_128B, 42874),  // __builtin_HEXAGON_V6_vpackeb_128B
    new BuiltinEntry(ID.hexagon_V6_vpackeh, 42908),  // __builtin_HEXAGON_V6_vpackeh
    new BuiltinEntry(ID.hexagon_V6_vpackeh_128B, 42937),  // __builtin_HEXAGON_V6_vpackeh_128B
    new BuiltinEntry(ID.hexagon_V6_vpackhb_sat, 42971),  // __builtin_HEXAGON_V6_vpackhb_sat
    new BuiltinEntry(ID.hexagon_V6_vpackhb_sat_128B, 43004),  // __builtin_HEXAGON_V6_vpackhb_sat_128B
    new BuiltinEntry(ID.hexagon_V6_vpackhub_sat, 43042),  // __builtin_HEXAGON_V6_vpackhub_sat
    new BuiltinEntry(ID.hexagon_V6_vpackhub_sat_128B, 43076),  // __builtin_HEXAGON_V6_vpackhub_sat_128B
    new BuiltinEntry(ID.hexagon_V6_vpackob, 43115),  // __builtin_HEXAGON_V6_vpackob
    new BuiltinEntry(ID.hexagon_V6_vpackob_128B, 43144),  // __builtin_HEXAGON_V6_vpackob_128B
    new BuiltinEntry(ID.hexagon_V6_vpackoh, 43178),  // __builtin_HEXAGON_V6_vpackoh
    new BuiltinEntry(ID.hexagon_V6_vpackoh_128B, 43207),  // __builtin_HEXAGON_V6_vpackoh_128B
    new BuiltinEntry(ID.hexagon_V6_vpackwh_sat, 43241),  // __builtin_HEXAGON_V6_vpackwh_sat
    new BuiltinEntry(ID.hexagon_V6_vpackwh_sat_128B, 43274),  // __builtin_HEXAGON_V6_vpackwh_sat_128B
    new BuiltinEntry(ID.hexagon_V6_vpackwuh_sat, 43312),  // __builtin_HEXAGON_V6_vpackwuh_sat
    new BuiltinEntry(ID.hexagon_V6_vpackwuh_sat_128B, 43346),  // __builtin_HEXAGON_V6_vpackwuh_sat_128B
    new BuiltinEntry(ID.hexagon_V6_vpopcounth, 43385),  // __builtin_HEXAGON_V6_vpopcounth
    new BuiltinEntry(ID.hexagon_V6_vpopcounth_128B, 43417),  // __builtin_HEXAGON_V6_vpopcounth_128B
    new BuiltinEntry(ID.hexagon_V6_vrdelta, 43454),  // __builtin_HEXAGON_V6_vrdelta
    new BuiltinEntry(ID.hexagon_V6_vrdelta_128B, 43483),  // __builtin_HEXAGON_V6_vrdelta_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpybus, 43517),  // __builtin_HEXAGON_V6_vrmpybus
    new BuiltinEntry(ID.hexagon_V6_vrmpybus_128B, 43547),  // __builtin_HEXAGON_V6_vrmpybus_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpybus_acc, 43582),  // __builtin_HEXAGON_V6_vrmpybus_acc
    new BuiltinEntry(ID.hexagon_V6_vrmpybus_acc_128B, 43616),  // __builtin_HEXAGON_V6_vrmpybus_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpybusi, 43655),  // __builtin_HEXAGON_V6_vrmpybusi
    new BuiltinEntry(ID.hexagon_V6_vrmpybusi_128B, 43686),  // __builtin_HEXAGON_V6_vrmpybusi_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpybusi_acc, 43722),  // __builtin_HEXAGON_V6_vrmpybusi_acc
    new BuiltinEntry(ID.hexagon_V6_vrmpybusi_acc_128B, 43757),  // __builtin_HEXAGON_V6_vrmpybusi_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpybusv, 43797),  // __builtin_HEXAGON_V6_vrmpybusv
    new BuiltinEntry(ID.hexagon_V6_vrmpybusv_128B, 43828),  // __builtin_HEXAGON_V6_vrmpybusv_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpybusv_acc, 43864),  // __builtin_HEXAGON_V6_vrmpybusv_acc
    new BuiltinEntry(ID.hexagon_V6_vrmpybusv_acc_128B, 43899),  // __builtin_HEXAGON_V6_vrmpybusv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpybv, 43939),  // __builtin_HEXAGON_V6_vrmpybv
    new BuiltinEntry(ID.hexagon_V6_vrmpybv_128B, 43968),  // __builtin_HEXAGON_V6_vrmpybv_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpybv_acc, 44002),  // __builtin_HEXAGON_V6_vrmpybv_acc
    new BuiltinEntry(ID.hexagon_V6_vrmpybv_acc_128B, 44035),  // __builtin_HEXAGON_V6_vrmpybv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpyub, 44073),  // __builtin_HEXAGON_V6_vrmpyub
    new BuiltinEntry(ID.hexagon_V6_vrmpyub_128B, 44102),  // __builtin_HEXAGON_V6_vrmpyub_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpyub_acc, 44136),  // __builtin_HEXAGON_V6_vrmpyub_acc
    new BuiltinEntry(ID.hexagon_V6_vrmpyub_acc_128B, 44169),  // __builtin_HEXAGON_V6_vrmpyub_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpyubi, 44207),  // __builtin_HEXAGON_V6_vrmpyubi
    new BuiltinEntry(ID.hexagon_V6_vrmpyubi_128B, 44237),  // __builtin_HEXAGON_V6_vrmpyubi_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpyubi_acc, 44272),  // __builtin_HEXAGON_V6_vrmpyubi_acc
    new BuiltinEntry(ID.hexagon_V6_vrmpyubi_acc_128B, 44306),  // __builtin_HEXAGON_V6_vrmpyubi_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpyubv, 44345),  // __builtin_HEXAGON_V6_vrmpyubv
    new BuiltinEntry(ID.hexagon_V6_vrmpyubv_128B, 44375),  // __builtin_HEXAGON_V6_vrmpyubv_128B
    new BuiltinEntry(ID.hexagon_V6_vrmpyubv_acc, 44410),  // __builtin_HEXAGON_V6_vrmpyubv_acc
    new BuiltinEntry(ID.hexagon_V6_vrmpyubv_acc_128B, 44444),  // __builtin_HEXAGON_V6_vrmpyubv_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vror, 44483),  // __builtin_HEXAGON_V6_vror
    new BuiltinEntry(ID.hexagon_V6_vror_128B, 44509),  // __builtin_HEXAGON_V6_vror_128B
    new BuiltinEntry(ID.hexagon_V6_vroundhb, 44540),  // __builtin_HEXAGON_V6_vroundhb
    new BuiltinEntry(ID.hexagon_V6_vroundhb_128B, 44570),  // __builtin_HEXAGON_V6_vroundhb_128B
    new BuiltinEntry(ID.hexagon_V6_vroundhub, 44605),  // __builtin_HEXAGON_V6_vroundhub
    new BuiltinEntry(ID.hexagon_V6_vroundhub_128B, 44636),  // __builtin_HEXAGON_V6_vroundhub_128B
    new BuiltinEntry(ID.hexagon_V6_vroundwh, 44672),  // __builtin_HEXAGON_V6_vroundwh
    new BuiltinEntry(ID.hexagon_V6_vroundwh_128B, 44702),  // __builtin_HEXAGON_V6_vroundwh_128B
    new BuiltinEntry(ID.hexagon_V6_vroundwuh, 44737),  // __builtin_HEXAGON_V6_vroundwuh
    new BuiltinEntry(ID.hexagon_V6_vroundwuh_128B, 44768),  // __builtin_HEXAGON_V6_vroundwuh_128B
    new BuiltinEntry(ID.hexagon_V6_vrsadubi, 44804),  // __builtin_HEXAGON_V6_vrsadubi
    new BuiltinEntry(ID.hexagon_V6_vrsadubi_128B, 44834),  // __builtin_HEXAGON_V6_vrsadubi_128B
    new BuiltinEntry(ID.hexagon_V6_vrsadubi_acc, 44869),  // __builtin_HEXAGON_V6_vrsadubi_acc
    new BuiltinEntry(ID.hexagon_V6_vrsadubi_acc_128B, 44903),  // __builtin_HEXAGON_V6_vrsadubi_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vsathub, 44942),  // __builtin_HEXAGON_V6_vsathub
    new BuiltinEntry(ID.hexagon_V6_vsathub_128B, 44971),  // __builtin_HEXAGON_V6_vsathub_128B
    new BuiltinEntry(ID.hexagon_V6_vsatwh, 45005),  // __builtin_HEXAGON_V6_vsatwh
    new BuiltinEntry(ID.hexagon_V6_vsatwh_128B, 45033),  // __builtin_HEXAGON_V6_vsatwh_128B
    new BuiltinEntry(ID.hexagon_V6_vsb, 45066),  // __builtin_HEXAGON_V6_vsb
    new BuiltinEntry(ID.hexagon_V6_vsb_128B, 45091),  // __builtin_HEXAGON_V6_vsb_128B
    new BuiltinEntry(ID.hexagon_V6_vsh, 45121),  // __builtin_HEXAGON_V6_vsh
    new BuiltinEntry(ID.hexagon_V6_vsh_128B, 45146),  // __builtin_HEXAGON_V6_vsh_128B
    new BuiltinEntry(ID.hexagon_V6_vshufeh, 45176),  // __builtin_HEXAGON_V6_vshufeh
    new BuiltinEntry(ID.hexagon_V6_vshufeh_128B, 45205),  // __builtin_HEXAGON_V6_vshufeh_128B
    new BuiltinEntry(ID.hexagon_V6_vshuffb, 45239),  // __builtin_HEXAGON_V6_vshuffb
    new BuiltinEntry(ID.hexagon_V6_vshuffb_128B, 45268),  // __builtin_HEXAGON_V6_vshuffb_128B
    new BuiltinEntry(ID.hexagon_V6_vshuffeb, 45302),  // __builtin_HEXAGON_V6_vshuffeb
    new BuiltinEntry(ID.hexagon_V6_vshuffeb_128B, 45332),  // __builtin_HEXAGON_V6_vshuffeb_128B
    new BuiltinEntry(ID.hexagon_V6_vshuffh, 45367),  // __builtin_HEXAGON_V6_vshuffh
    new BuiltinEntry(ID.hexagon_V6_vshuffh_128B, 45396),  // __builtin_HEXAGON_V6_vshuffh_128B
    new BuiltinEntry(ID.hexagon_V6_vshuffob, 45430),  // __builtin_HEXAGON_V6_vshuffob
    new BuiltinEntry(ID.hexagon_V6_vshuffob_128B, 45460),  // __builtin_HEXAGON_V6_vshuffob_128B
    new BuiltinEntry(ID.hexagon_V6_vshuffvdd, 45495),  // __builtin_HEXAGON_V6_vshuffvdd
    new BuiltinEntry(ID.hexagon_V6_vshuffvdd_128B, 45526),  // __builtin_HEXAGON_V6_vshuffvdd_128B
    new BuiltinEntry(ID.hexagon_V6_vshufoeb, 45562),  // __builtin_HEXAGON_V6_vshufoeb
    new BuiltinEntry(ID.hexagon_V6_vshufoeb_128B, 45592),  // __builtin_HEXAGON_V6_vshufoeb_128B
    new BuiltinEntry(ID.hexagon_V6_vshufoeh, 45627),  // __builtin_HEXAGON_V6_vshufoeh
    new BuiltinEntry(ID.hexagon_V6_vshufoeh_128B, 45657),  // __builtin_HEXAGON_V6_vshufoeh_128B
    new BuiltinEntry(ID.hexagon_V6_vshufoh, 45692),  // __builtin_HEXAGON_V6_vshufoh
    new BuiltinEntry(ID.hexagon_V6_vshufoh_128B, 45721),  // __builtin_HEXAGON_V6_vshufoh_128B
    new BuiltinEntry(ID.hexagon_V6_vsubb, 45755),  // __builtin_HEXAGON_V6_vsubb
    new BuiltinEntry(ID.hexagon_V6_vsubb_128B, 45782),  // __builtin_HEXAGON_V6_vsubb_128B
    new BuiltinEntry(ID.hexagon_V6_vsubb_dv, 45814),  // __builtin_HEXAGON_V6_vsubb_dv
    new BuiltinEntry(ID.hexagon_V6_vsubb_dv_128B, 45844),  // __builtin_HEXAGON_V6_vsubb_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vsubbnq, 45879),  // __builtin_HEXAGON_V6_vsubbnq
    new BuiltinEntry(ID.hexagon_V6_vsubbnq_128B, 45908),  // __builtin_HEXAGON_V6_vsubbnq_128B
    new BuiltinEntry(ID.hexagon_V6_vsubbq, 45942),  // __builtin_HEXAGON_V6_vsubbq
    new BuiltinEntry(ID.hexagon_V6_vsubbq_128B, 45970),  // __builtin_HEXAGON_V6_vsubbq_128B
    new BuiltinEntry(ID.hexagon_V6_vsubh, 46003),  // __builtin_HEXAGON_V6_vsubh
    new BuiltinEntry(ID.hexagon_V6_vsubh_128B, 46030),  // __builtin_HEXAGON_V6_vsubh_128B
    new BuiltinEntry(ID.hexagon_V6_vsubh_dv, 46062),  // __builtin_HEXAGON_V6_vsubh_dv
    new BuiltinEntry(ID.hexagon_V6_vsubh_dv_128B, 46092),  // __builtin_HEXAGON_V6_vsubh_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vsubhnq, 46127),  // __builtin_HEXAGON_V6_vsubhnq
    new BuiltinEntry(ID.hexagon_V6_vsubhnq_128B, 46156),  // __builtin_HEXAGON_V6_vsubhnq_128B
    new BuiltinEntry(ID.hexagon_V6_vsubhq, 46190),  // __builtin_HEXAGON_V6_vsubhq
    new BuiltinEntry(ID.hexagon_V6_vsubhq_128B, 46218),  // __builtin_HEXAGON_V6_vsubhq_128B
    new BuiltinEntry(ID.hexagon_V6_vsubhsat, 46251),  // __builtin_HEXAGON_V6_vsubhsat
    new BuiltinEntry(ID.hexagon_V6_vsubhsat_128B, 46281),  // __builtin_HEXAGON_V6_vsubhsat_128B
    new BuiltinEntry(ID.hexagon_V6_vsubhsat_dv, 46316),  // __builtin_HEXAGON_V6_vsubhsat_dv
    new BuiltinEntry(ID.hexagon_V6_vsubhsat_dv_128B, 46349),  // __builtin_HEXAGON_V6_vsubhsat_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vsubhw, 46387),  // __builtin_HEXAGON_V6_vsubhw
    new BuiltinEntry(ID.hexagon_V6_vsubhw_128B, 46415),  // __builtin_HEXAGON_V6_vsubhw_128B
    new BuiltinEntry(ID.hexagon_V6_vsububh, 46448),  // __builtin_HEXAGON_V6_vsububh
    new BuiltinEntry(ID.hexagon_V6_vsububh_128B, 46477),  // __builtin_HEXAGON_V6_vsububh_128B
    new BuiltinEntry(ID.hexagon_V6_vsububsat, 46511),  // __builtin_HEXAGON_V6_vsububsat
    new BuiltinEntry(ID.hexagon_V6_vsububsat_128B, 46542),  // __builtin_HEXAGON_V6_vsububsat_128B
    new BuiltinEntry(ID.hexagon_V6_vsububsat_dv, 46578),  // __builtin_HEXAGON_V6_vsububsat_dv
    new BuiltinEntry(ID.hexagon_V6_vsububsat_dv_128B, 46612),  // __builtin_HEXAGON_V6_vsububsat_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vsubuhsat, 46651),  // __builtin_HEXAGON_V6_vsubuhsat
    new BuiltinEntry(ID.hexagon_V6_vsubuhsat_128B, 46682),  // __builtin_HEXAGON_V6_vsubuhsat_128B
    new BuiltinEntry(ID.hexagon_V6_vsubuhsat_dv, 46718),  // __builtin_HEXAGON_V6_vsubuhsat_dv
    new BuiltinEntry(ID.hexagon_V6_vsubuhsat_dv_128B, 46752),  // __builtin_HEXAGON_V6_vsubuhsat_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vsubuhw, 46791),  // __builtin_HEXAGON_V6_vsubuhw
    new BuiltinEntry(ID.hexagon_V6_vsubuhw_128B, 46820),  // __builtin_HEXAGON_V6_vsubuhw_128B
    new BuiltinEntry(ID.hexagon_V6_vsubw, 46854),  // __builtin_HEXAGON_V6_vsubw
    new BuiltinEntry(ID.hexagon_V6_vsubw_128B, 46881),  // __builtin_HEXAGON_V6_vsubw_128B
    new BuiltinEntry(ID.hexagon_V6_vsubw_dv, 46913),  // __builtin_HEXAGON_V6_vsubw_dv
    new BuiltinEntry(ID.hexagon_V6_vsubw_dv_128B, 46943),  // __builtin_HEXAGON_V6_vsubw_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vsubwnq, 46978),  // __builtin_HEXAGON_V6_vsubwnq
    new BuiltinEntry(ID.hexagon_V6_vsubwnq_128B, 47007),  // __builtin_HEXAGON_V6_vsubwnq_128B
    new BuiltinEntry(ID.hexagon_V6_vsubwq, 47041),  // __builtin_HEXAGON_V6_vsubwq
    new BuiltinEntry(ID.hexagon_V6_vsubwq_128B, 47069),  // __builtin_HEXAGON_V6_vsubwq_128B
    new BuiltinEntry(ID.hexagon_V6_vsubwsat, 47102),  // __builtin_HEXAGON_V6_vsubwsat
    new BuiltinEntry(ID.hexagon_V6_vsubwsat_128B, 47132),  // __builtin_HEXAGON_V6_vsubwsat_128B
    new BuiltinEntry(ID.hexagon_V6_vsubwsat_dv, 47167),  // __builtin_HEXAGON_V6_vsubwsat_dv
    new BuiltinEntry(ID.hexagon_V6_vsubwsat_dv_128B, 47200),  // __builtin_HEXAGON_V6_vsubwsat_dv_128B
    new BuiltinEntry(ID.hexagon_V6_vswap, 47238),  // __builtin_HEXAGON_V6_vswap
    new BuiltinEntry(ID.hexagon_V6_vswap_128B, 47265),  // __builtin_HEXAGON_V6_vswap_128B
    new BuiltinEntry(ID.hexagon_V6_vtmpyb, 47297),  // __builtin_HEXAGON_V6_vtmpyb
    new BuiltinEntry(ID.hexagon_V6_vtmpyb_128B, 47325),  // __builtin_HEXAGON_V6_vtmpyb_128B
    new BuiltinEntry(ID.hexagon_V6_vtmpyb_acc, 47358),  // __builtin_HEXAGON_V6_vtmpyb_acc
    new BuiltinEntry(ID.hexagon_V6_vtmpyb_acc_128B, 47390),  // __builtin_HEXAGON_V6_vtmpyb_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vtmpybus, 47427),  // __builtin_HEXAGON_V6_vtmpybus
    new BuiltinEntry(ID.hexagon_V6_vtmpybus_128B, 47457),  // __builtin_HEXAGON_V6_vtmpybus_128B
    new BuiltinEntry(ID.hexagon_V6_vtmpybus_acc, 47492),  // __builtin_HEXAGON_V6_vtmpybus_acc
    new BuiltinEntry(ID.hexagon_V6_vtmpybus_acc_128B, 47526),  // __builtin_HEXAGON_V6_vtmpybus_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vtmpyhb, 47565),  // __builtin_HEXAGON_V6_vtmpyhb
    new BuiltinEntry(ID.hexagon_V6_vtmpyhb_128B, 47594),  // __builtin_HEXAGON_V6_vtmpyhb_128B
    new BuiltinEntry(ID.hexagon_V6_vtmpyhb_acc, 47628),  // __builtin_HEXAGON_V6_vtmpyhb_acc
    new BuiltinEntry(ID.hexagon_V6_vtmpyhb_acc_128B, 47661),  // __builtin_HEXAGON_V6_vtmpyhb_acc_128B
    new BuiltinEntry(ID.hexagon_V6_vunpackb, 47699),  // __builtin_HEXAGON_V6_vunpackb
    new BuiltinEntry(ID.hexagon_V6_vunpackb_128B, 47729),  // __builtin_HEXAGON_V6_vunpackb_128B
    new BuiltinEntry(ID.hexagon_V6_vunpackh, 47764),  // __builtin_HEXAGON_V6_vunpackh
    new BuiltinEntry(ID.hexagon_V6_vunpackh_128B, 47794),  // __builtin_HEXAGON_V6_vunpackh_128B
    new BuiltinEntry(ID.hexagon_V6_vunpackob, 47829),  // __builtin_HEXAGON_V6_vunpackob
    new BuiltinEntry(ID.hexagon_V6_vunpackob_128B, 47860),  // __builtin_HEXAGON_V6_vunpackob_128B
    new BuiltinEntry(ID.hexagon_V6_vunpackoh, 47896),  // __builtin_HEXAGON_V6_vunpackoh
    new BuiltinEntry(ID.hexagon_V6_vunpackoh_128B, 47927),  // __builtin_HEXAGON_V6_vunpackoh_128B
    new BuiltinEntry(ID.hexagon_V6_vunpackub, 47963),  // __builtin_HEXAGON_V6_vunpackub
    new BuiltinEntry(ID.hexagon_V6_vunpackub_128B, 47994),  // __builtin_HEXAGON_V6_vunpackub_128B
    new BuiltinEntry(ID.hexagon_V6_vunpackuh, 48030),  // __builtin_HEXAGON_V6_vunpackuh
    new BuiltinEntry(ID.hexagon_V6_vunpackuh_128B, 48061),  // __builtin_HEXAGON_V6_vunpackuh_128B
    new BuiltinEntry(ID.hexagon_V6_vxor, 48097),  // __builtin_HEXAGON_V6_vxor
    new BuiltinEntry(ID.hexagon_V6_vxor_128B, 48123),  // __builtin_HEXAGON_V6_vxor_128B
    new BuiltinEntry(ID.hexagon_V6_vzb, 48154),  // __builtin_HEXAGON_V6_vzb
    new BuiltinEntry(ID.hexagon_V6_vzb_128B, 48179),  // __builtin_HEXAGON_V6_vzb_128B
    new BuiltinEntry(ID.hexagon_V6_vzh, 48209),  // __builtin_HEXAGON_V6_vzh
    new BuiltinEntry(ID.hexagon_V6_vzh_128B, 48234),  // __builtin_HEXAGON_V6_vzh_128B
    new BuiltinEntry(ID.hexagon_prefetch, 48714),  // __builtin_HEXAGON_prefetch
    new BuiltinEntry(ID.hexagon_SI_to_SXTHI_asrh, 28565),  // __builtin_SI_to_SXTHI_asrh
    new BuiltinEntry(ID.hexagon_mm256i_vaddw, 48690),  // __builtin__mm256i_vaddw
    new BuiltinEntry(ID.hexagon_brev_ldb, 48264),  // __builtin_brev_ldb
    new BuiltinEntry(ID.hexagon_brev_ldd, 48283),  // __builtin_brev_ldd
    new BuiltinEntry(ID.hexagon_brev_ldh, 48302),  // __builtin_brev_ldh
    new BuiltinEntry(ID.hexagon_brev_ldub, 48321),  // __builtin_brev_ldub
    new BuiltinEntry(ID.hexagon_brev_lduh, 48341),  // __builtin_brev_lduh
    new BuiltinEntry(ID.hexagon_brev_ldw, 48361),  // __builtin_brev_ldw
    new BuiltinEntry(ID.hexagon_brev_stb, 48380),  // __builtin_brev_stb
    new BuiltinEntry(ID.hexagon_brev_std, 48399),  // __builtin_brev_std
    new BuiltinEntry(ID.hexagon_brev_sth, 48418),  // __builtin_brev_sth
    new BuiltinEntry(ID.hexagon_brev_sthhi, 48437),  // __builtin_brev_sthhi
    new BuiltinEntry(ID.hexagon_brev_stw, 48458),  // __builtin_brev_stw
    new BuiltinEntry(ID.hexagon_circ_ldb, 48477),  // __builtin_circ_ldb
    new BuiltinEntry(ID.hexagon_circ_ldd, 48496),  // __builtin_circ_ldd
    new BuiltinEntry(ID.hexagon_circ_ldh, 48515),  // __builtin_circ_ldh
    new BuiltinEntry(ID.hexagon_circ_ldub, 48534),  // __builtin_circ_ldub
    new BuiltinEntry(ID.hexagon_circ_lduh, 48554),  // __builtin_circ_lduh
    new BuiltinEntry(ID.hexagon_circ_ldw, 48574),  // __builtin_circ_ldw
    new BuiltinEntry(ID.hexagon_circ_stb, 48593),  // __builtin_circ_stb
    new BuiltinEntry(ID.hexagon_circ_std, 48612),  // __builtin_circ_std
    new BuiltinEntry(ID.hexagon_circ_sth, 48631),  // __builtin_circ_sth
    new BuiltinEntry(ID.hexagon_circ_sthhi, 48650),  // __builtin_circ_sthhi
    new BuiltinEntry(ID.hexagon_circ_stw, 48671) // __builtin_circ_stw
  };
  static final/*static*/ /*const*/ BuiltinEntry mipsNames[/*667*/] = new /*const*/ BuiltinEntry [/*667*/] {
    new BuiltinEntry(ID.mips_absq_s_ph, 48741),  // __builtin_mips_absq_s_ph
    new BuiltinEntry(ID.mips_absq_s_qb, 48766),  // __builtin_mips_absq_s_qb
    new BuiltinEntry(ID.mips_absq_s_w, 48791),  // __builtin_mips_absq_s_w
    new BuiltinEntry(ID.mips_addq_ph, 48903),  // __builtin_mips_addq_ph
    new BuiltinEntry(ID.mips_addq_s_ph, 48926),  // __builtin_mips_addq_s_ph
    new BuiltinEntry(ID.mips_addq_s_w, 48951),  // __builtin_mips_addq_s_w
    new BuiltinEntry(ID.mips_addqh_ph, 48975),  // __builtin_mips_addqh_ph
    new BuiltinEntry(ID.mips_addqh_r_ph, 48999),  // __builtin_mips_addqh_r_ph
    new BuiltinEntry(ID.mips_addqh_r_w, 49025),  // __builtin_mips_addqh_r_w
    new BuiltinEntry(ID.mips_addqh_w, 49050),  // __builtin_mips_addqh_w
    new BuiltinEntry(ID.mips_addsc, 49349),  // __builtin_mips_addsc
    new BuiltinEntry(ID.mips_addu_ph, 49370),  // __builtin_mips_addu_ph
    new BuiltinEntry(ID.mips_addu_qb, 49393),  // __builtin_mips_addu_qb
    new BuiltinEntry(ID.mips_addu_s_ph, 49416),  // __builtin_mips_addu_s_ph
    new BuiltinEntry(ID.mips_addu_s_qb, 49441),  // __builtin_mips_addu_s_qb
    new BuiltinEntry(ID.mips_adduh_qb, 49466),  // __builtin_mips_adduh_qb
    new BuiltinEntry(ID.mips_adduh_r_qb, 49490),  // __builtin_mips_adduh_r_qb
    new BuiltinEntry(ID.mips_addwc, 49688),  // __builtin_mips_addwc
    new BuiltinEntry(ID.mips_append, 49750),  // __builtin_mips_append
    new BuiltinEntry(ID.mips_balign, 50316),  // __builtin_mips_balign
    new BuiltinEntry(ID.mips_bitrev, 50870),  // __builtin_mips_bitrev
    new BuiltinEntry(ID.mips_bposge32, 51248),  // __builtin_mips_bposge32
    new BuiltinEntry(ID.mips_cmp_eq_ph, 52487),  // __builtin_mips_cmp_eq_ph
    new BuiltinEntry(ID.mips_cmp_le_ph, 52512),  // __builtin_mips_cmp_le_ph
    new BuiltinEntry(ID.mips_cmp_lt_ph, 52537),  // __builtin_mips_cmp_lt_ph
    new BuiltinEntry(ID.mips_cmpgdu_eq_qb, 52562),  // __builtin_mips_cmpgdu_eq_qb
    new BuiltinEntry(ID.mips_cmpgdu_le_qb, 52590),  // __builtin_mips_cmpgdu_le_qb
    new BuiltinEntry(ID.mips_cmpgdu_lt_qb, 52618),  // __builtin_mips_cmpgdu_lt_qb
    new BuiltinEntry(ID.mips_cmpgu_eq_qb, 52646),  // __builtin_mips_cmpgu_eq_qb
    new BuiltinEntry(ID.mips_cmpgu_le_qb, 52673),  // __builtin_mips_cmpgu_le_qb
    new BuiltinEntry(ID.mips_cmpgu_lt_qb, 52700),  // __builtin_mips_cmpgu_lt_qb
    new BuiltinEntry(ID.mips_cmpu_eq_qb, 52727),  // __builtin_mips_cmpu_eq_qb
    new BuiltinEntry(ID.mips_cmpu_le_qb, 52753),  // __builtin_mips_cmpu_le_qb
    new BuiltinEntry(ID.mips_cmpu_lt_qb, 52779),  // __builtin_mips_cmpu_lt_qb
    new BuiltinEntry(ID.mips_dlsa, 53186),  // __builtin_mips_dlsa
    new BuiltinEntry(ID.mips_dpa_w_ph, 53344),  // __builtin_mips_dpa_w_ph
    new BuiltinEntry(ID.mips_dpaq_s_w_ph, 53512),  // __builtin_mips_dpaq_s_w_ph
    new BuiltinEntry(ID.mips_dpaq_sa_l_w, 53539),  // __builtin_mips_dpaq_sa_l_w
    new BuiltinEntry(ID.mips_dpaqx_s_w_ph, 53566),  // __builtin_mips_dpaqx_s_w_ph
    new BuiltinEntry(ID.mips_dpaqx_sa_w_ph, 53594),  // __builtin_mips_dpaqx_sa_w_ph
    new BuiltinEntry(ID.mips_dpau_h_qbl, 53623),  // __builtin_mips_dpau_h_qbl
    new BuiltinEntry(ID.mips_dpau_h_qbr, 53649),  // __builtin_mips_dpau_h_qbr
    new BuiltinEntry(ID.mips_dpax_w_ph, 53675),  // __builtin_mips_dpax_w_ph
    new BuiltinEntry(ID.mips_dps_w_ph, 53700),  // __builtin_mips_dps_w_ph
    new BuiltinEntry(ID.mips_dpsq_s_w_ph, 53724),  // __builtin_mips_dpsq_s_w_ph
    new BuiltinEntry(ID.mips_dpsq_sa_l_w, 53751),  // __builtin_mips_dpsq_sa_l_w
    new BuiltinEntry(ID.mips_dpsqx_s_w_ph, 53778),  // __builtin_mips_dpsqx_s_w_ph
    new BuiltinEntry(ID.mips_dpsqx_sa_w_ph, 53806),  // __builtin_mips_dpsqx_sa_w_ph
    new BuiltinEntry(ID.mips_dpsu_h_qbl, 53835),  // __builtin_mips_dpsu_h_qbl
    new BuiltinEntry(ID.mips_dpsu_h_qbr, 53861),  // __builtin_mips_dpsu_h_qbr
    new BuiltinEntry(ID.mips_dpsx_w_ph, 54031),  // __builtin_mips_dpsx_w_ph
    new BuiltinEntry(ID.mips_extp, 54056),  // __builtin_mips_extp
    new BuiltinEntry(ID.mips_extpdp, 54076),  // __builtin_mips_extpdp
    new BuiltinEntry(ID.mips_extr_r_w, 54098),  // __builtin_mips_extr_r_w
    new BuiltinEntry(ID.mips_extr_rs_w, 54122),  // __builtin_mips_extr_rs_w
    new BuiltinEntry(ID.mips_extr_s_h, 54147),  // __builtin_mips_extr_s_h
    new BuiltinEntry(ID.mips_extr_w, 54171),  // __builtin_mips_extr_w
    new BuiltinEntry(ID.mips_insv, 57223),  // __builtin_mips_insv
    new BuiltinEntry(ID.mips_lbux, 57331),  // __builtin_mips_lbux
    new BuiltinEntry(ID.mips_lhx, 57507),  // __builtin_mips_lhx
    new BuiltinEntry(ID.mips_lsa, 57526),  // __builtin_mips_lsa
    new BuiltinEntry(ID.mips_lwx, 57545),  // __builtin_mips_lwx
    new BuiltinEntry(ID.mips_madd, 57564),  // __builtin_mips_madd
    new BuiltinEntry(ID.mips_maddu, 57678),  // __builtin_mips_maddu
    new BuiltinEntry(ID.mips_maq_s_w_phl, 57787),  // __builtin_mips_maq_s_w_phl
    new BuiltinEntry(ID.mips_maq_s_w_phr, 57814),  // __builtin_mips_maq_s_w_phr
    new BuiltinEntry(ID.mips_maq_sa_w_phl, 57841),  // __builtin_mips_maq_sa_w_phl
    new BuiltinEntry(ID.mips_maq_sa_w_phr, 57869),  // __builtin_mips_maq_sa_w_phr
    new BuiltinEntry(ID.mips_modsub, 58969),  // __builtin_mips_modsub
    new BuiltinEntry(ID.mips_msub, 59012),  // __builtin_mips_msub
    new BuiltinEntry(ID.mips_msubu, 59126),  // __builtin_mips_msubu
    new BuiltinEntry(ID.mips_mthlip, 59235),  // __builtin_mips_mthlip
    new BuiltinEntry(ID.mips_mul_ph, 59257),  // __builtin_mips_mul_ph
    new BuiltinEntry(ID.mips_mul_s_ph, 59323),  // __builtin_mips_mul_s_ph
    new BuiltinEntry(ID.mips_muleq_s_w_phl, 59347),  // __builtin_mips_muleq_s_w_phl
    new BuiltinEntry(ID.mips_muleq_s_w_phr, 59376),  // __builtin_mips_muleq_s_w_phr
    new BuiltinEntry(ID.mips_muleu_s_ph_qbl, 59405),  // __builtin_mips_muleu_s_ph_qbl
    new BuiltinEntry(ID.mips_muleu_s_ph_qbr, 59435),  // __builtin_mips_muleu_s_ph_qbr
    new BuiltinEntry(ID.mips_mulq_rs_ph, 59465),  // __builtin_mips_mulq_rs_ph
    new BuiltinEntry(ID.mips_mulq_rs_w, 59491),  // __builtin_mips_mulq_rs_w
    new BuiltinEntry(ID.mips_mulq_s_ph, 59516),  // __builtin_mips_mulq_s_ph
    new BuiltinEntry(ID.mips_mulq_s_w, 59541),  // __builtin_mips_mulq_s_w
    new BuiltinEntry(ID.mips_mulsa_w_ph, 59611),  // __builtin_mips_mulsa_w_ph
    new BuiltinEntry(ID.mips_mulsaq_s_w_ph, 59637),  // __builtin_mips_mulsaq_s_w_ph
    new BuiltinEntry(ID.mips_mult, 59666),  // __builtin_mips_mult
    new BuiltinEntry(ID.mips_multu, 59686),  // __builtin_mips_multu
    new BuiltinEntry(ID.mips_packrl_ph, 60039),  // __builtin_mips_packrl_ph
    new BuiltinEntry(ID.mips_pick_ph, 60324),  // __builtin_mips_pick_ph
    new BuiltinEntry(ID.mips_pick_qb, 60347),  // __builtin_mips_pick_qb
    new BuiltinEntry(ID.mips_preceq_w_phl, 60370),  // __builtin_mips_preceq_w_phl
    new BuiltinEntry(ID.mips_preceq_w_phr, 60398),  // __builtin_mips_preceq_w_phr
    new BuiltinEntry(ID.mips_precequ_ph_qbl, 60426),  // __builtin_mips_precequ_ph_qbl
    new BuiltinEntry(ID.mips_precequ_ph_qbla, 60456),  // __builtin_mips_precequ_ph_qbla
    new BuiltinEntry(ID.mips_precequ_ph_qbr, 60487),  // __builtin_mips_precequ_ph_qbr
    new BuiltinEntry(ID.mips_precequ_ph_qbra, 60517),  // __builtin_mips_precequ_ph_qbra
    new BuiltinEntry(ID.mips_preceu_ph_qbl, 60548),  // __builtin_mips_preceu_ph_qbl
    new BuiltinEntry(ID.mips_preceu_ph_qbla, 60577),  // __builtin_mips_preceu_ph_qbla
    new BuiltinEntry(ID.mips_preceu_ph_qbr, 60607),  // __builtin_mips_preceu_ph_qbr
    new BuiltinEntry(ID.mips_preceu_ph_qbra, 60636),  // __builtin_mips_preceu_ph_qbra
    new BuiltinEntry(ID.mips_precr_qb_ph, 60666),  // __builtin_mips_precr_qb_ph
    new BuiltinEntry(ID.mips_precr_sra_ph_w, 60693),  // __builtin_mips_precr_sra_ph_w
    new BuiltinEntry(ID.mips_precr_sra_r_ph_w, 60723),  // __builtin_mips_precr_sra_r_ph_w
    new BuiltinEntry(ID.mips_precrq_ph_w, 60755),  // __builtin_mips_precrq_ph_w
    new BuiltinEntry(ID.mips_precrq_qb_ph, 60782),  // __builtin_mips_precrq_qb_ph
    new BuiltinEntry(ID.mips_precrq_rs_ph_w, 60810),  // __builtin_mips_precrq_rs_ph_w
    new BuiltinEntry(ID.mips_precrqu_s_qb_ph, 60840),  // __builtin_mips_precrqu_s_qb_ph
    new BuiltinEntry(ID.mips_prepend, 60871),  // __builtin_mips_prepend
    new BuiltinEntry(ID.mips_raddu_w_qb, 60894),  // __builtin_mips_raddu_w_qb
    new BuiltinEntry(ID.mips_rddsp, 60920),  // __builtin_mips_rddsp
    new BuiltinEntry(ID.mips_repl_ph, 60941),  // __builtin_mips_repl_ph
    new BuiltinEntry(ID.mips_repl_qb, 60964),  // __builtin_mips_repl_qb
    new BuiltinEntry(ID.mips_shilo, 61223),  // __builtin_mips_shilo
    new BuiltinEntry(ID.mips_shll_ph, 61244),  // __builtin_mips_shll_ph
    new BuiltinEntry(ID.mips_shll_qb, 61267),  // __builtin_mips_shll_qb
    new BuiltinEntry(ID.mips_shll_s_ph, 61290),  // __builtin_mips_shll_s_ph
    new BuiltinEntry(ID.mips_shll_s_w, 61315),  // __builtin_mips_shll_s_w
    new BuiltinEntry(ID.mips_shra_ph, 61339),  // __builtin_mips_shra_ph
    new BuiltinEntry(ID.mips_shra_qb, 61362),  // __builtin_mips_shra_qb
    new BuiltinEntry(ID.mips_shra_r_ph, 61385),  // __builtin_mips_shra_r_ph
    new BuiltinEntry(ID.mips_shra_r_qb, 61410),  // __builtin_mips_shra_r_qb
    new BuiltinEntry(ID.mips_shra_r_w, 61435),  // __builtin_mips_shra_r_w
    new BuiltinEntry(ID.mips_shrl_ph, 61459),  // __builtin_mips_shrl_ph
    new BuiltinEntry(ID.mips_shrl_qb, 61482),  // __builtin_mips_shrl_qb
    new BuiltinEntry(ID.mips_subq_ph, 62761),  // __builtin_mips_subq_ph
    new BuiltinEntry(ID.mips_subq_s_ph, 62784),  // __builtin_mips_subq_s_ph
    new BuiltinEntry(ID.mips_subq_s_w, 62809),  // __builtin_mips_subq_s_w
    new BuiltinEntry(ID.mips_subqh_ph, 62833),  // __builtin_mips_subqh_ph
    new BuiltinEntry(ID.mips_subqh_r_ph, 62857),  // __builtin_mips_subqh_r_ph
    new BuiltinEntry(ID.mips_subqh_r_w, 62883),  // __builtin_mips_subqh_r_w
    new BuiltinEntry(ID.mips_subqh_w, 62908),  // __builtin_mips_subqh_w
    new BuiltinEntry(ID.mips_subu_ph, 63315),  // __builtin_mips_subu_ph
    new BuiltinEntry(ID.mips_subu_qb, 63338),  // __builtin_mips_subu_qb
    new BuiltinEntry(ID.mips_subu_s_ph, 63361),  // __builtin_mips_subu_s_ph
    new BuiltinEntry(ID.mips_subu_s_qb, 63386),  // __builtin_mips_subu_s_qb
    new BuiltinEntry(ID.mips_subuh_qb, 63411),  // __builtin_mips_subuh_qb
    new BuiltinEntry(ID.mips_subuh_r_qb, 63435),  // __builtin_mips_subuh_r_qb
    new BuiltinEntry(ID.mips_wrdsp, 63717),  // __builtin_mips_wrdsp
    new BuiltinEntry(ID.mips_add_a_b, 48815),  // __builtin_msa_add_a_b
    new BuiltinEntry(ID.mips_add_a_d, 48837),  // __builtin_msa_add_a_d
    new BuiltinEntry(ID.mips_add_a_h, 48859),  // __builtin_msa_add_a_h
    new BuiltinEntry(ID.mips_add_a_w, 48881),  // __builtin_msa_add_a_w
    new BuiltinEntry(ID.mips_adds_a_b, 49073),  // __builtin_msa_adds_a_b
    new BuiltinEntry(ID.mips_adds_a_d, 49096),  // __builtin_msa_adds_a_d
    new BuiltinEntry(ID.mips_adds_a_h, 49119),  // __builtin_msa_adds_a_h
    new BuiltinEntry(ID.mips_adds_a_w, 49142),  // __builtin_msa_adds_a_w
    new BuiltinEntry(ID.mips_adds_s_b, 49165),  // __builtin_msa_adds_s_b
    new BuiltinEntry(ID.mips_adds_s_d, 49188),  // __builtin_msa_adds_s_d
    new BuiltinEntry(ID.mips_adds_s_h, 49211),  // __builtin_msa_adds_s_h
    new BuiltinEntry(ID.mips_adds_s_w, 49234),  // __builtin_msa_adds_s_w
    new BuiltinEntry(ID.mips_adds_u_b, 49257),  // __builtin_msa_adds_u_b
    new BuiltinEntry(ID.mips_adds_u_d, 49280),  // __builtin_msa_adds_u_d
    new BuiltinEntry(ID.mips_adds_u_h, 49303),  // __builtin_msa_adds_u_h
    new BuiltinEntry(ID.mips_adds_u_w, 49326),  // __builtin_msa_adds_u_w
    new BuiltinEntry(ID.mips_addv_b, 49516),  // __builtin_msa_addv_b
    new BuiltinEntry(ID.mips_addv_d, 49537),  // __builtin_msa_addv_d
    new BuiltinEntry(ID.mips_addv_h, 49558),  // __builtin_msa_addv_h
    new BuiltinEntry(ID.mips_addv_w, 49579),  // __builtin_msa_addv_w
    new BuiltinEntry(ID.mips_addvi_b, 49600),  // __builtin_msa_addvi_b
    new BuiltinEntry(ID.mips_addvi_d, 49622),  // __builtin_msa_addvi_d
    new BuiltinEntry(ID.mips_addvi_h, 49644),  // __builtin_msa_addvi_h
    new BuiltinEntry(ID.mips_addvi_w, 49666),  // __builtin_msa_addvi_w
    new BuiltinEntry(ID.mips_and_v, 49709),  // __builtin_msa_and_v
    new BuiltinEntry(ID.mips_andi_b, 49729),  // __builtin_msa_andi_b
    new BuiltinEntry(ID.mips_asub_s_b, 49772),  // __builtin_msa_asub_s_b
    new BuiltinEntry(ID.mips_asub_s_d, 49795),  // __builtin_msa_asub_s_d
    new BuiltinEntry(ID.mips_asub_s_h, 49818),  // __builtin_msa_asub_s_h
    new BuiltinEntry(ID.mips_asub_s_w, 49841),  // __builtin_msa_asub_s_w
    new BuiltinEntry(ID.mips_asub_u_b, 49864),  // __builtin_msa_asub_u_b
    new BuiltinEntry(ID.mips_asub_u_d, 49887),  // __builtin_msa_asub_u_d
    new BuiltinEntry(ID.mips_asub_u_h, 49910),  // __builtin_msa_asub_u_h
    new BuiltinEntry(ID.mips_asub_u_w, 49933),  // __builtin_msa_asub_u_w
    new BuiltinEntry(ID.mips_ave_s_b, 49956),  // __builtin_msa_ave_s_b
    new BuiltinEntry(ID.mips_ave_s_d, 49978),  // __builtin_msa_ave_s_d
    new BuiltinEntry(ID.mips_ave_s_h, 50000),  // __builtin_msa_ave_s_h
    new BuiltinEntry(ID.mips_ave_s_w, 50022),  // __builtin_msa_ave_s_w
    new BuiltinEntry(ID.mips_ave_u_b, 50044),  // __builtin_msa_ave_u_b
    new BuiltinEntry(ID.mips_ave_u_d, 50066),  // __builtin_msa_ave_u_d
    new BuiltinEntry(ID.mips_ave_u_h, 50088),  // __builtin_msa_ave_u_h
    new BuiltinEntry(ID.mips_ave_u_w, 50110),  // __builtin_msa_ave_u_w
    new BuiltinEntry(ID.mips_aver_s_b, 50132),  // __builtin_msa_aver_s_b
    new BuiltinEntry(ID.mips_aver_s_d, 50155),  // __builtin_msa_aver_s_d
    new BuiltinEntry(ID.mips_aver_s_h, 50178),  // __builtin_msa_aver_s_h
    new BuiltinEntry(ID.mips_aver_s_w, 50201),  // __builtin_msa_aver_s_w
    new BuiltinEntry(ID.mips_aver_u_b, 50224),  // __builtin_msa_aver_u_b
    new BuiltinEntry(ID.mips_aver_u_d, 50247),  // __builtin_msa_aver_u_d
    new BuiltinEntry(ID.mips_aver_u_h, 50270),  // __builtin_msa_aver_u_h
    new BuiltinEntry(ID.mips_aver_u_w, 50293),  // __builtin_msa_aver_u_w
    new BuiltinEntry(ID.mips_bclr_b, 50338),  // __builtin_msa_bclr_b
    new BuiltinEntry(ID.mips_bclr_d, 50359),  // __builtin_msa_bclr_d
    new BuiltinEntry(ID.mips_bclr_h, 50380),  // __builtin_msa_bclr_h
    new BuiltinEntry(ID.mips_bclr_w, 50401),  // __builtin_msa_bclr_w
    new BuiltinEntry(ID.mips_bclri_b, 50422),  // __builtin_msa_bclri_b
    new BuiltinEntry(ID.mips_bclri_d, 50444),  // __builtin_msa_bclri_d
    new BuiltinEntry(ID.mips_bclri_h, 50466),  // __builtin_msa_bclri_h
    new BuiltinEntry(ID.mips_bclri_w, 50488),  // __builtin_msa_bclri_w
    new BuiltinEntry(ID.mips_binsl_b, 50510),  // __builtin_msa_binsl_b
    new BuiltinEntry(ID.mips_binsl_d, 50532),  // __builtin_msa_binsl_d
    new BuiltinEntry(ID.mips_binsl_h, 50554),  // __builtin_msa_binsl_h
    new BuiltinEntry(ID.mips_binsl_w, 50576),  // __builtin_msa_binsl_w
    new BuiltinEntry(ID.mips_binsli_b, 50598),  // __builtin_msa_binsli_b
    new BuiltinEntry(ID.mips_binsli_d, 50621),  // __builtin_msa_binsli_d
    new BuiltinEntry(ID.mips_binsli_h, 50644),  // __builtin_msa_binsli_h
    new BuiltinEntry(ID.mips_binsli_w, 50667),  // __builtin_msa_binsli_w
    new BuiltinEntry(ID.mips_binsr_b, 50690),  // __builtin_msa_binsr_b
    new BuiltinEntry(ID.mips_binsr_d, 50712),  // __builtin_msa_binsr_d
    new BuiltinEntry(ID.mips_binsr_h, 50734),  // __builtin_msa_binsr_h
    new BuiltinEntry(ID.mips_binsr_w, 50756),  // __builtin_msa_binsr_w
    new BuiltinEntry(ID.mips_binsri_b, 50778),  // __builtin_msa_binsri_b
    new BuiltinEntry(ID.mips_binsri_d, 50801),  // __builtin_msa_binsri_d
    new BuiltinEntry(ID.mips_binsri_h, 50824),  // __builtin_msa_binsri_h
    new BuiltinEntry(ID.mips_binsri_w, 50847),  // __builtin_msa_binsri_w
    new BuiltinEntry(ID.mips_bmnz_v, 50892),  // __builtin_msa_bmnz_v
    new BuiltinEntry(ID.mips_bmnzi_b, 50913),  // __builtin_msa_bmnzi_b
    new BuiltinEntry(ID.mips_bmz_v, 50935),  // __builtin_msa_bmz_v
    new BuiltinEntry(ID.mips_bmzi_b, 50955),  // __builtin_msa_bmzi_b
    new BuiltinEntry(ID.mips_bneg_b, 50976),  // __builtin_msa_bneg_b
    new BuiltinEntry(ID.mips_bneg_d, 50997),  // __builtin_msa_bneg_d
    new BuiltinEntry(ID.mips_bneg_h, 51018),  // __builtin_msa_bneg_h
    new BuiltinEntry(ID.mips_bneg_w, 51039),  // __builtin_msa_bneg_w
    new BuiltinEntry(ID.mips_bnegi_b, 51060),  // __builtin_msa_bnegi_b
    new BuiltinEntry(ID.mips_bnegi_d, 51082),  // __builtin_msa_bnegi_d
    new BuiltinEntry(ID.mips_bnegi_h, 51104),  // __builtin_msa_bnegi_h
    new BuiltinEntry(ID.mips_bnegi_w, 51126),  // __builtin_msa_bnegi_w
    new BuiltinEntry(ID.mips_bnz_b, 51148),  // __builtin_msa_bnz_b
    new BuiltinEntry(ID.mips_bnz_d, 51168),  // __builtin_msa_bnz_d
    new BuiltinEntry(ID.mips_bnz_h, 51188),  // __builtin_msa_bnz_h
    new BuiltinEntry(ID.mips_bnz_v, 51208),  // __builtin_msa_bnz_v
    new BuiltinEntry(ID.mips_bnz_w, 51228),  // __builtin_msa_bnz_w
    new BuiltinEntry(ID.mips_bsel_v, 51272),  // __builtin_msa_bsel_v
    new BuiltinEntry(ID.mips_bseli_b, 51293),  // __builtin_msa_bseli_b
    new BuiltinEntry(ID.mips_bset_b, 51315),  // __builtin_msa_bset_b
    new BuiltinEntry(ID.mips_bset_d, 51336),  // __builtin_msa_bset_d
    new BuiltinEntry(ID.mips_bset_h, 51357),  // __builtin_msa_bset_h
    new BuiltinEntry(ID.mips_bset_w, 51378),  // __builtin_msa_bset_w
    new BuiltinEntry(ID.mips_bseti_b, 51399),  // __builtin_msa_bseti_b
    new BuiltinEntry(ID.mips_bseti_d, 51421),  // __builtin_msa_bseti_d
    new BuiltinEntry(ID.mips_bseti_h, 51443),  // __builtin_msa_bseti_h
    new BuiltinEntry(ID.mips_bseti_w, 51465),  // __builtin_msa_bseti_w
    new BuiltinEntry(ID.mips_bz_b, 51487),  // __builtin_msa_bz_b
    new BuiltinEntry(ID.mips_bz_d, 51506),  // __builtin_msa_bz_d
    new BuiltinEntry(ID.mips_bz_h, 51525),  // __builtin_msa_bz_h
    new BuiltinEntry(ID.mips_bz_v, 51544),  // __builtin_msa_bz_v
    new BuiltinEntry(ID.mips_bz_w, 51563),  // __builtin_msa_bz_w
    new BuiltinEntry(ID.mips_ceq_b, 51582),  // __builtin_msa_ceq_b
    new BuiltinEntry(ID.mips_ceq_d, 51602),  // __builtin_msa_ceq_d
    new BuiltinEntry(ID.mips_ceq_h, 51622),  // __builtin_msa_ceq_h
    new BuiltinEntry(ID.mips_ceq_w, 51642),  // __builtin_msa_ceq_w
    new BuiltinEntry(ID.mips_ceqi_b, 51662),  // __builtin_msa_ceqi_b
    new BuiltinEntry(ID.mips_ceqi_d, 51683),  // __builtin_msa_ceqi_d
    new BuiltinEntry(ID.mips_ceqi_h, 51704),  // __builtin_msa_ceqi_h
    new BuiltinEntry(ID.mips_ceqi_w, 51725),  // __builtin_msa_ceqi_w
    new BuiltinEntry(ID.mips_cfcmsa, 51746),  // __builtin_msa_cfcmsa
    new BuiltinEntry(ID.mips_cle_s_b, 51767),  // __builtin_msa_cle_s_b
    new BuiltinEntry(ID.mips_cle_s_d, 51789),  // __builtin_msa_cle_s_d
    new BuiltinEntry(ID.mips_cle_s_h, 51811),  // __builtin_msa_cle_s_h
    new BuiltinEntry(ID.mips_cle_s_w, 51833),  // __builtin_msa_cle_s_w
    new BuiltinEntry(ID.mips_cle_u_b, 51855),  // __builtin_msa_cle_u_b
    new BuiltinEntry(ID.mips_cle_u_d, 51877),  // __builtin_msa_cle_u_d
    new BuiltinEntry(ID.mips_cle_u_h, 51899),  // __builtin_msa_cle_u_h
    new BuiltinEntry(ID.mips_cle_u_w, 51921),  // __builtin_msa_cle_u_w
    new BuiltinEntry(ID.mips_clei_s_b, 51943),  // __builtin_msa_clei_s_b
    new BuiltinEntry(ID.mips_clei_s_d, 51966),  // __builtin_msa_clei_s_d
    new BuiltinEntry(ID.mips_clei_s_h, 51989),  // __builtin_msa_clei_s_h
    new BuiltinEntry(ID.mips_clei_s_w, 52012),  // __builtin_msa_clei_s_w
    new BuiltinEntry(ID.mips_clei_u_b, 52035),  // __builtin_msa_clei_u_b
    new BuiltinEntry(ID.mips_clei_u_d, 52058),  // __builtin_msa_clei_u_d
    new BuiltinEntry(ID.mips_clei_u_h, 52081),  // __builtin_msa_clei_u_h
    new BuiltinEntry(ID.mips_clei_u_w, 52104),  // __builtin_msa_clei_u_w
    new BuiltinEntry(ID.mips_clt_s_b, 52127),  // __builtin_msa_clt_s_b
    new BuiltinEntry(ID.mips_clt_s_d, 52149),  // __builtin_msa_clt_s_d
    new BuiltinEntry(ID.mips_clt_s_h, 52171),  // __builtin_msa_clt_s_h
    new BuiltinEntry(ID.mips_clt_s_w, 52193),  // __builtin_msa_clt_s_w
    new BuiltinEntry(ID.mips_clt_u_b, 52215),  // __builtin_msa_clt_u_b
    new BuiltinEntry(ID.mips_clt_u_d, 52237),  // __builtin_msa_clt_u_d
    new BuiltinEntry(ID.mips_clt_u_h, 52259),  // __builtin_msa_clt_u_h
    new BuiltinEntry(ID.mips_clt_u_w, 52281),  // __builtin_msa_clt_u_w
    new BuiltinEntry(ID.mips_clti_s_b, 52303),  // __builtin_msa_clti_s_b
    new BuiltinEntry(ID.mips_clti_s_d, 52326),  // __builtin_msa_clti_s_d
    new BuiltinEntry(ID.mips_clti_s_h, 52349),  // __builtin_msa_clti_s_h
    new BuiltinEntry(ID.mips_clti_s_w, 52372),  // __builtin_msa_clti_s_w
    new BuiltinEntry(ID.mips_clti_u_b, 52395),  // __builtin_msa_clti_u_b
    new BuiltinEntry(ID.mips_clti_u_d, 52418),  // __builtin_msa_clti_u_d
    new BuiltinEntry(ID.mips_clti_u_h, 52441),  // __builtin_msa_clti_u_h
    new BuiltinEntry(ID.mips_clti_u_w, 52464),  // __builtin_msa_clti_u_w
    new BuiltinEntry(ID.mips_copy_s_b, 52805),  // __builtin_msa_copy_s_b
    new BuiltinEntry(ID.mips_copy_s_d, 52828),  // __builtin_msa_copy_s_d
    new BuiltinEntry(ID.mips_copy_s_h, 52851),  // __builtin_msa_copy_s_h
    new BuiltinEntry(ID.mips_copy_s_w, 52874),  // __builtin_msa_copy_s_w
    new BuiltinEntry(ID.mips_copy_u_b, 52897),  // __builtin_msa_copy_u_b
    new BuiltinEntry(ID.mips_copy_u_d, 52920),  // __builtin_msa_copy_u_d
    new BuiltinEntry(ID.mips_copy_u_h, 52943),  // __builtin_msa_copy_u_h
    new BuiltinEntry(ID.mips_copy_u_w, 52966),  // __builtin_msa_copy_u_w
    new BuiltinEntry(ID.mips_ctcmsa, 52989),  // __builtin_msa_ctcmsa
    new BuiltinEntry(ID.mips_div_s_b, 53010),  // __builtin_msa_div_s_b
    new BuiltinEntry(ID.mips_div_s_d, 53032),  // __builtin_msa_div_s_d
    new BuiltinEntry(ID.mips_div_s_h, 53054),  // __builtin_msa_div_s_h
    new BuiltinEntry(ID.mips_div_s_w, 53076),  // __builtin_msa_div_s_w
    new BuiltinEntry(ID.mips_div_u_b, 53098),  // __builtin_msa_div_u_b
    new BuiltinEntry(ID.mips_div_u_d, 53120),  // __builtin_msa_div_u_d
    new BuiltinEntry(ID.mips_div_u_h, 53142),  // __builtin_msa_div_u_h
    new BuiltinEntry(ID.mips_div_u_w, 53164),  // __builtin_msa_div_u_w
    new BuiltinEntry(ID.mips_dotp_s_d, 53206),  // __builtin_msa_dotp_s_d
    new BuiltinEntry(ID.mips_dotp_s_h, 53229),  // __builtin_msa_dotp_s_h
    new BuiltinEntry(ID.mips_dotp_s_w, 53252),  // __builtin_msa_dotp_s_w
    new BuiltinEntry(ID.mips_dotp_u_d, 53275),  // __builtin_msa_dotp_u_d
    new BuiltinEntry(ID.mips_dotp_u_h, 53298),  // __builtin_msa_dotp_u_h
    new BuiltinEntry(ID.mips_dotp_u_w, 53321),  // __builtin_msa_dotp_u_w
    new BuiltinEntry(ID.mips_dpadd_s_d, 53368),  // __builtin_msa_dpadd_s_d
    new BuiltinEntry(ID.mips_dpadd_s_h, 53392),  // __builtin_msa_dpadd_s_h
    new BuiltinEntry(ID.mips_dpadd_s_w, 53416),  // __builtin_msa_dpadd_s_w
    new BuiltinEntry(ID.mips_dpadd_u_d, 53440),  // __builtin_msa_dpadd_u_d
    new BuiltinEntry(ID.mips_dpadd_u_h, 53464),  // __builtin_msa_dpadd_u_h
    new BuiltinEntry(ID.mips_dpadd_u_w, 53488),  // __builtin_msa_dpadd_u_w
    new BuiltinEntry(ID.mips_dpsub_s_d, 53887),  // __builtin_msa_dpsub_s_d
    new BuiltinEntry(ID.mips_dpsub_s_h, 53911),  // __builtin_msa_dpsub_s_h
    new BuiltinEntry(ID.mips_dpsub_s_w, 53935),  // __builtin_msa_dpsub_s_w
    new BuiltinEntry(ID.mips_dpsub_u_d, 53959),  // __builtin_msa_dpsub_u_d
    new BuiltinEntry(ID.mips_dpsub_u_h, 53983),  // __builtin_msa_dpsub_u_h
    new BuiltinEntry(ID.mips_dpsub_u_w, 54007),  // __builtin_msa_dpsub_u_w
    new BuiltinEntry(ID.mips_fadd_d, 54193),  // __builtin_msa_fadd_d
    new BuiltinEntry(ID.mips_fadd_w, 54214),  // __builtin_msa_fadd_w
    new BuiltinEntry(ID.mips_fcaf_d, 54235),  // __builtin_msa_fcaf_d
    new BuiltinEntry(ID.mips_fcaf_w, 54256),  // __builtin_msa_fcaf_w
    new BuiltinEntry(ID.mips_fceq_d, 54277),  // __builtin_msa_fceq_d
    new BuiltinEntry(ID.mips_fceq_w, 54298),  // __builtin_msa_fceq_w
    new BuiltinEntry(ID.mips_fclass_d, 54319),  // __builtin_msa_fclass_d
    new BuiltinEntry(ID.mips_fclass_w, 54342),  // __builtin_msa_fclass_w
    new BuiltinEntry(ID.mips_fcle_d, 54365),  // __builtin_msa_fcle_d
    new BuiltinEntry(ID.mips_fcle_w, 54386),  // __builtin_msa_fcle_w
    new BuiltinEntry(ID.mips_fclt_d, 54407),  // __builtin_msa_fclt_d
    new BuiltinEntry(ID.mips_fclt_w, 54428),  // __builtin_msa_fclt_w
    new BuiltinEntry(ID.mips_fcne_d, 54449),  // __builtin_msa_fcne_d
    new BuiltinEntry(ID.mips_fcne_w, 54470),  // __builtin_msa_fcne_w
    new BuiltinEntry(ID.mips_fcor_d, 54491),  // __builtin_msa_fcor_d
    new BuiltinEntry(ID.mips_fcor_w, 54512),  // __builtin_msa_fcor_w
    new BuiltinEntry(ID.mips_fcueq_d, 54533),  // __builtin_msa_fcueq_d
    new BuiltinEntry(ID.mips_fcueq_w, 54555),  // __builtin_msa_fcueq_w
    new BuiltinEntry(ID.mips_fcule_d, 54577),  // __builtin_msa_fcule_d
    new BuiltinEntry(ID.mips_fcule_w, 54599),  // __builtin_msa_fcule_w
    new BuiltinEntry(ID.mips_fcult_d, 54621),  // __builtin_msa_fcult_d
    new BuiltinEntry(ID.mips_fcult_w, 54643),  // __builtin_msa_fcult_w
    new BuiltinEntry(ID.mips_fcun_d, 54665),  // __builtin_msa_fcun_d
    new BuiltinEntry(ID.mips_fcun_w, 54686),  // __builtin_msa_fcun_w
    new BuiltinEntry(ID.mips_fcune_d, 54707),  // __builtin_msa_fcune_d
    new BuiltinEntry(ID.mips_fcune_w, 54729),  // __builtin_msa_fcune_w
    new BuiltinEntry(ID.mips_fdiv_d, 54751),  // __builtin_msa_fdiv_d
    new BuiltinEntry(ID.mips_fdiv_w, 54772),  // __builtin_msa_fdiv_w
    new BuiltinEntry(ID.mips_fexdo_h, 54793),  // __builtin_msa_fexdo_h
    new BuiltinEntry(ID.mips_fexdo_w, 54815),  // __builtin_msa_fexdo_w
    new BuiltinEntry(ID.mips_fexp2_d, 54837),  // __builtin_msa_fexp2_d
    new BuiltinEntry(ID.mips_fexp2_w, 54859),  // __builtin_msa_fexp2_w
    new BuiltinEntry(ID.mips_fexupl_d, 54881),  // __builtin_msa_fexupl_d
    new BuiltinEntry(ID.mips_fexupl_w, 54904),  // __builtin_msa_fexupl_w
    new BuiltinEntry(ID.mips_fexupr_d, 54927),  // __builtin_msa_fexupr_d
    new BuiltinEntry(ID.mips_fexupr_w, 54950),  // __builtin_msa_fexupr_w
    new BuiltinEntry(ID.mips_ffint_s_d, 54973),  // __builtin_msa_ffint_s_d
    new BuiltinEntry(ID.mips_ffint_s_w, 54997),  // __builtin_msa_ffint_s_w
    new BuiltinEntry(ID.mips_ffint_u_d, 55021),  // __builtin_msa_ffint_u_d
    new BuiltinEntry(ID.mips_ffint_u_w, 55045),  // __builtin_msa_ffint_u_w
    new BuiltinEntry(ID.mips_ffql_d, 55069),  // __builtin_msa_ffql_d
    new BuiltinEntry(ID.mips_ffql_w, 55090),  // __builtin_msa_ffql_w
    new BuiltinEntry(ID.mips_ffqr_d, 55111),  // __builtin_msa_ffqr_d
    new BuiltinEntry(ID.mips_ffqr_w, 55132),  // __builtin_msa_ffqr_w
    new BuiltinEntry(ID.mips_fill_b, 55153),  // __builtin_msa_fill_b
    new BuiltinEntry(ID.mips_fill_d, 55174),  // __builtin_msa_fill_d
    new BuiltinEntry(ID.mips_fill_h, 55195),  // __builtin_msa_fill_h
    new BuiltinEntry(ID.mips_fill_w, 55216),  // __builtin_msa_fill_w
    new BuiltinEntry(ID.mips_flog2_d, 55237),  // __builtin_msa_flog2_d
    new BuiltinEntry(ID.mips_flog2_w, 55259),  // __builtin_msa_flog2_w
    new BuiltinEntry(ID.mips_fmadd_d, 55281),  // __builtin_msa_fmadd_d
    new BuiltinEntry(ID.mips_fmadd_w, 55303),  // __builtin_msa_fmadd_w
    new BuiltinEntry(ID.mips_fmax_a_d, 55325),  // __builtin_msa_fmax_a_d
    new BuiltinEntry(ID.mips_fmax_a_w, 55348),  // __builtin_msa_fmax_a_w
    new BuiltinEntry(ID.mips_fmax_d, 55371),  // __builtin_msa_fmax_d
    new BuiltinEntry(ID.mips_fmax_w, 55392),  // __builtin_msa_fmax_w
    new BuiltinEntry(ID.mips_fmin_a_d, 55413),  // __builtin_msa_fmin_a_d
    new BuiltinEntry(ID.mips_fmin_a_w, 55436),  // __builtin_msa_fmin_a_w
    new BuiltinEntry(ID.mips_fmin_d, 55459),  // __builtin_msa_fmin_d
    new BuiltinEntry(ID.mips_fmin_w, 55480),  // __builtin_msa_fmin_w
    new BuiltinEntry(ID.mips_fmsub_d, 55501),  // __builtin_msa_fmsub_d
    new BuiltinEntry(ID.mips_fmsub_w, 55523),  // __builtin_msa_fmsub_w
    new BuiltinEntry(ID.mips_fmul_d, 55545),  // __builtin_msa_fmul_d
    new BuiltinEntry(ID.mips_fmul_w, 55566),  // __builtin_msa_fmul_w
    new BuiltinEntry(ID.mips_frcp_d, 55587),  // __builtin_msa_frcp_d
    new BuiltinEntry(ID.mips_frcp_w, 55608),  // __builtin_msa_frcp_w
    new BuiltinEntry(ID.mips_frint_d, 55629),  // __builtin_msa_frint_d
    new BuiltinEntry(ID.mips_frint_w, 55651),  // __builtin_msa_frint_w
    new BuiltinEntry(ID.mips_frsqrt_d, 55673),  // __builtin_msa_frsqrt_d
    new BuiltinEntry(ID.mips_frsqrt_w, 55696),  // __builtin_msa_frsqrt_w
    new BuiltinEntry(ID.mips_fsaf_d, 55719),  // __builtin_msa_fsaf_d
    new BuiltinEntry(ID.mips_fsaf_w, 55740),  // __builtin_msa_fsaf_w
    new BuiltinEntry(ID.mips_fseq_d, 55761),  // __builtin_msa_fseq_d
    new BuiltinEntry(ID.mips_fseq_w, 55782),  // __builtin_msa_fseq_w
    new BuiltinEntry(ID.mips_fsle_d, 55803),  // __builtin_msa_fsle_d
    new BuiltinEntry(ID.mips_fsle_w, 55824),  // __builtin_msa_fsle_w
    new BuiltinEntry(ID.mips_fslt_d, 55845),  // __builtin_msa_fslt_d
    new BuiltinEntry(ID.mips_fslt_w, 55866),  // __builtin_msa_fslt_w
    new BuiltinEntry(ID.mips_fsne_d, 55887),  // __builtin_msa_fsne_d
    new BuiltinEntry(ID.mips_fsne_w, 55908),  // __builtin_msa_fsne_w
    new BuiltinEntry(ID.mips_fsor_d, 55929),  // __builtin_msa_fsor_d
    new BuiltinEntry(ID.mips_fsor_w, 55950),  // __builtin_msa_fsor_w
    new BuiltinEntry(ID.mips_fsqrt_d, 55971),  // __builtin_msa_fsqrt_d
    new BuiltinEntry(ID.mips_fsqrt_w, 55993),  // __builtin_msa_fsqrt_w
    new BuiltinEntry(ID.mips_fsub_d, 56015),  // __builtin_msa_fsub_d
    new BuiltinEntry(ID.mips_fsub_w, 56036),  // __builtin_msa_fsub_w
    new BuiltinEntry(ID.mips_fsueq_d, 56057),  // __builtin_msa_fsueq_d
    new BuiltinEntry(ID.mips_fsueq_w, 56079),  // __builtin_msa_fsueq_w
    new BuiltinEntry(ID.mips_fsule_d, 56101),  // __builtin_msa_fsule_d
    new BuiltinEntry(ID.mips_fsule_w, 56123),  // __builtin_msa_fsule_w
    new BuiltinEntry(ID.mips_fsult_d, 56145),  // __builtin_msa_fsult_d
    new BuiltinEntry(ID.mips_fsult_w, 56167),  // __builtin_msa_fsult_w
    new BuiltinEntry(ID.mips_fsun_d, 56189),  // __builtin_msa_fsun_d
    new BuiltinEntry(ID.mips_fsun_w, 56210),  // __builtin_msa_fsun_w
    new BuiltinEntry(ID.mips_fsune_d, 56231),  // __builtin_msa_fsune_d
    new BuiltinEntry(ID.mips_fsune_w, 56253),  // __builtin_msa_fsune_w
    new BuiltinEntry(ID.mips_ftint_s_d, 56275),  // __builtin_msa_ftint_s_d
    new BuiltinEntry(ID.mips_ftint_s_w, 56299),  // __builtin_msa_ftint_s_w
    new BuiltinEntry(ID.mips_ftint_u_d, 56323),  // __builtin_msa_ftint_u_d
    new BuiltinEntry(ID.mips_ftint_u_w, 56347),  // __builtin_msa_ftint_u_w
    new BuiltinEntry(ID.mips_ftq_h, 56371),  // __builtin_msa_ftq_h
    new BuiltinEntry(ID.mips_ftq_w, 56391),  // __builtin_msa_ftq_w
    new BuiltinEntry(ID.mips_ftrunc_s_d, 56411),  // __builtin_msa_ftrunc_s_d
    new BuiltinEntry(ID.mips_ftrunc_s_w, 56436),  // __builtin_msa_ftrunc_s_w
    new BuiltinEntry(ID.mips_ftrunc_u_d, 56461),  // __builtin_msa_ftrunc_u_d
    new BuiltinEntry(ID.mips_ftrunc_u_w, 56486),  // __builtin_msa_ftrunc_u_w
    new BuiltinEntry(ID.mips_hadd_s_d, 56511),  // __builtin_msa_hadd_s_d
    new BuiltinEntry(ID.mips_hadd_s_h, 56534),  // __builtin_msa_hadd_s_h
    new BuiltinEntry(ID.mips_hadd_s_w, 56557),  // __builtin_msa_hadd_s_w
    new BuiltinEntry(ID.mips_hadd_u_d, 56580),  // __builtin_msa_hadd_u_d
    new BuiltinEntry(ID.mips_hadd_u_h, 56603),  // __builtin_msa_hadd_u_h
    new BuiltinEntry(ID.mips_hadd_u_w, 56626),  // __builtin_msa_hadd_u_w
    new BuiltinEntry(ID.mips_hsub_s_d, 56649),  // __builtin_msa_hsub_s_d
    new BuiltinEntry(ID.mips_hsub_s_h, 56672),  // __builtin_msa_hsub_s_h
    new BuiltinEntry(ID.mips_hsub_s_w, 56695),  // __builtin_msa_hsub_s_w
    new BuiltinEntry(ID.mips_hsub_u_d, 56718),  // __builtin_msa_hsub_u_d
    new BuiltinEntry(ID.mips_hsub_u_h, 56741),  // __builtin_msa_hsub_u_h
    new BuiltinEntry(ID.mips_hsub_u_w, 56764),  // __builtin_msa_hsub_u_w
    new BuiltinEntry(ID.mips_ilvev_b, 56787),  // __builtin_msa_ilvev_b
    new BuiltinEntry(ID.mips_ilvev_d, 56809),  // __builtin_msa_ilvev_d
    new BuiltinEntry(ID.mips_ilvev_h, 56831),  // __builtin_msa_ilvev_h
    new BuiltinEntry(ID.mips_ilvev_w, 56853),  // __builtin_msa_ilvev_w
    new BuiltinEntry(ID.mips_ilvl_b, 56875),  // __builtin_msa_ilvl_b
    new BuiltinEntry(ID.mips_ilvl_d, 56896),  // __builtin_msa_ilvl_d
    new BuiltinEntry(ID.mips_ilvl_h, 56917),  // __builtin_msa_ilvl_h
    new BuiltinEntry(ID.mips_ilvl_w, 56938),  // __builtin_msa_ilvl_w
    new BuiltinEntry(ID.mips_ilvod_b, 56959),  // __builtin_msa_ilvod_b
    new BuiltinEntry(ID.mips_ilvod_d, 56981),  // __builtin_msa_ilvod_d
    new BuiltinEntry(ID.mips_ilvod_h, 57003),  // __builtin_msa_ilvod_h
    new BuiltinEntry(ID.mips_ilvod_w, 57025),  // __builtin_msa_ilvod_w
    new BuiltinEntry(ID.mips_ilvr_b, 57047),  // __builtin_msa_ilvr_b
    new BuiltinEntry(ID.mips_ilvr_d, 57068),  // __builtin_msa_ilvr_d
    new BuiltinEntry(ID.mips_ilvr_h, 57089),  // __builtin_msa_ilvr_h
    new BuiltinEntry(ID.mips_ilvr_w, 57110),  // __builtin_msa_ilvr_w
    new BuiltinEntry(ID.mips_insert_b, 57131),  // __builtin_msa_insert_b
    new BuiltinEntry(ID.mips_insert_d, 57154),  // __builtin_msa_insert_d
    new BuiltinEntry(ID.mips_insert_h, 57177),  // __builtin_msa_insert_h
    new BuiltinEntry(ID.mips_insert_w, 57200),  // __builtin_msa_insert_w
    new BuiltinEntry(ID.mips_insve_b, 57243),  // __builtin_msa_insve_b
    new BuiltinEntry(ID.mips_insve_d, 57265),  // __builtin_msa_insve_d
    new BuiltinEntry(ID.mips_insve_h, 57287),  // __builtin_msa_insve_h
    new BuiltinEntry(ID.mips_insve_w, 57309),  // __builtin_msa_insve_w
    new BuiltinEntry(ID.mips_ld_b, 57351),  // __builtin_msa_ld_b
    new BuiltinEntry(ID.mips_ld_d, 57370),  // __builtin_msa_ld_d
    new BuiltinEntry(ID.mips_ld_h, 57389),  // __builtin_msa_ld_h
    new BuiltinEntry(ID.mips_ld_w, 57408),  // __builtin_msa_ld_w
    new BuiltinEntry(ID.mips_ldi_b, 57427),  // __builtin_msa_ldi_b
    new BuiltinEntry(ID.mips_ldi_d, 57447),  // __builtin_msa_ldi_d
    new BuiltinEntry(ID.mips_ldi_h, 57467),  // __builtin_msa_ldi_h
    new BuiltinEntry(ID.mips_ldi_w, 57487),  // __builtin_msa_ldi_w
    new BuiltinEntry(ID.mips_madd_q_h, 57584),  // __builtin_msa_madd_q_h
    new BuiltinEntry(ID.mips_madd_q_w, 57607),  // __builtin_msa_madd_q_w
    new BuiltinEntry(ID.mips_maddr_q_h, 57630),  // __builtin_msa_maddr_q_h
    new BuiltinEntry(ID.mips_maddr_q_w, 57654),  // __builtin_msa_maddr_q_w
    new BuiltinEntry(ID.mips_maddv_b, 57699),  // __builtin_msa_maddv_b
    new BuiltinEntry(ID.mips_maddv_d, 57721),  // __builtin_msa_maddv_d
    new BuiltinEntry(ID.mips_maddv_h, 57743),  // __builtin_msa_maddv_h
    new BuiltinEntry(ID.mips_maddv_w, 57765),  // __builtin_msa_maddv_w
    new BuiltinEntry(ID.mips_max_a_b, 57897),  // __builtin_msa_max_a_b
    new BuiltinEntry(ID.mips_max_a_d, 57919),  // __builtin_msa_max_a_d
    new BuiltinEntry(ID.mips_max_a_h, 57941),  // __builtin_msa_max_a_h
    new BuiltinEntry(ID.mips_max_a_w, 57963),  // __builtin_msa_max_a_w
    new BuiltinEntry(ID.mips_max_s_b, 57985),  // __builtin_msa_max_s_b
    new BuiltinEntry(ID.mips_max_s_d, 58007),  // __builtin_msa_max_s_d
    new BuiltinEntry(ID.mips_max_s_h, 58029),  // __builtin_msa_max_s_h
    new BuiltinEntry(ID.mips_max_s_w, 58051),  // __builtin_msa_max_s_w
    new BuiltinEntry(ID.mips_max_u_b, 58073),  // __builtin_msa_max_u_b
    new BuiltinEntry(ID.mips_max_u_d, 58095),  // __builtin_msa_max_u_d
    new BuiltinEntry(ID.mips_max_u_h, 58117),  // __builtin_msa_max_u_h
    new BuiltinEntry(ID.mips_max_u_w, 58139),  // __builtin_msa_max_u_w
    new BuiltinEntry(ID.mips_maxi_s_b, 58161),  // __builtin_msa_maxi_s_b
    new BuiltinEntry(ID.mips_maxi_s_d, 58184),  // __builtin_msa_maxi_s_d
    new BuiltinEntry(ID.mips_maxi_s_h, 58207),  // __builtin_msa_maxi_s_h
    new BuiltinEntry(ID.mips_maxi_s_w, 58230),  // __builtin_msa_maxi_s_w
    new BuiltinEntry(ID.mips_maxi_u_b, 58253),  // __builtin_msa_maxi_u_b
    new BuiltinEntry(ID.mips_maxi_u_d, 58276),  // __builtin_msa_maxi_u_d
    new BuiltinEntry(ID.mips_maxi_u_h, 58299),  // __builtin_msa_maxi_u_h
    new BuiltinEntry(ID.mips_maxi_u_w, 58322),  // __builtin_msa_maxi_u_w
    new BuiltinEntry(ID.mips_min_a_b, 58345),  // __builtin_msa_min_a_b
    new BuiltinEntry(ID.mips_min_a_d, 58367),  // __builtin_msa_min_a_d
    new BuiltinEntry(ID.mips_min_a_h, 58389),  // __builtin_msa_min_a_h
    new BuiltinEntry(ID.mips_min_a_w, 58411),  // __builtin_msa_min_a_w
    new BuiltinEntry(ID.mips_min_s_b, 58433),  // __builtin_msa_min_s_b
    new BuiltinEntry(ID.mips_min_s_d, 58455),  // __builtin_msa_min_s_d
    new BuiltinEntry(ID.mips_min_s_h, 58477),  // __builtin_msa_min_s_h
    new BuiltinEntry(ID.mips_min_s_w, 58499),  // __builtin_msa_min_s_w
    new BuiltinEntry(ID.mips_min_u_b, 58521),  // __builtin_msa_min_u_b
    new BuiltinEntry(ID.mips_min_u_d, 58543),  // __builtin_msa_min_u_d
    new BuiltinEntry(ID.mips_min_u_h, 58565),  // __builtin_msa_min_u_h
    new BuiltinEntry(ID.mips_min_u_w, 58587),  // __builtin_msa_min_u_w
    new BuiltinEntry(ID.mips_mini_s_b, 58609),  // __builtin_msa_mini_s_b
    new BuiltinEntry(ID.mips_mini_s_d, 58632),  // __builtin_msa_mini_s_d
    new BuiltinEntry(ID.mips_mini_s_h, 58655),  // __builtin_msa_mini_s_h
    new BuiltinEntry(ID.mips_mini_s_w, 58678),  // __builtin_msa_mini_s_w
    new BuiltinEntry(ID.mips_mini_u_b, 58701),  // __builtin_msa_mini_u_b
    new BuiltinEntry(ID.mips_mini_u_d, 58724),  // __builtin_msa_mini_u_d
    new BuiltinEntry(ID.mips_mini_u_h, 58747),  // __builtin_msa_mini_u_h
    new BuiltinEntry(ID.mips_mini_u_w, 58770),  // __builtin_msa_mini_u_w
    new BuiltinEntry(ID.mips_mod_s_b, 58793),  // __builtin_msa_mod_s_b
    new BuiltinEntry(ID.mips_mod_s_d, 58815),  // __builtin_msa_mod_s_d
    new BuiltinEntry(ID.mips_mod_s_h, 58837),  // __builtin_msa_mod_s_h
    new BuiltinEntry(ID.mips_mod_s_w, 58859),  // __builtin_msa_mod_s_w
    new BuiltinEntry(ID.mips_mod_u_b, 58881),  // __builtin_msa_mod_u_b
    new BuiltinEntry(ID.mips_mod_u_d, 58903),  // __builtin_msa_mod_u_d
    new BuiltinEntry(ID.mips_mod_u_h, 58925),  // __builtin_msa_mod_u_h
    new BuiltinEntry(ID.mips_mod_u_w, 58947),  // __builtin_msa_mod_u_w
    new BuiltinEntry(ID.mips_move_v, 58991),  // __builtin_msa_move_v
    new BuiltinEntry(ID.mips_msub_q_h, 59032),  // __builtin_msa_msub_q_h
    new BuiltinEntry(ID.mips_msub_q_w, 59055),  // __builtin_msa_msub_q_w
    new BuiltinEntry(ID.mips_msubr_q_h, 59078),  // __builtin_msa_msubr_q_h
    new BuiltinEntry(ID.mips_msubr_q_w, 59102),  // __builtin_msa_msubr_q_w
    new BuiltinEntry(ID.mips_msubv_b, 59147),  // __builtin_msa_msubv_b
    new BuiltinEntry(ID.mips_msubv_d, 59169),  // __builtin_msa_msubv_d
    new BuiltinEntry(ID.mips_msubv_h, 59191),  // __builtin_msa_msubv_h
    new BuiltinEntry(ID.mips_msubv_w, 59213),  // __builtin_msa_msubv_w
    new BuiltinEntry(ID.mips_mul_q_h, 59279),  // __builtin_msa_mul_q_h
    new BuiltinEntry(ID.mips_mul_q_w, 59301),  // __builtin_msa_mul_q_w
    new BuiltinEntry(ID.mips_mulr_q_h, 59565),  // __builtin_msa_mulr_q_h
    new BuiltinEntry(ID.mips_mulr_q_w, 59588),  // __builtin_msa_mulr_q_w
    new BuiltinEntry(ID.mips_mulv_b, 59707),  // __builtin_msa_mulv_b
    new BuiltinEntry(ID.mips_mulv_d, 59728),  // __builtin_msa_mulv_d
    new BuiltinEntry(ID.mips_mulv_h, 59749),  // __builtin_msa_mulv_h
    new BuiltinEntry(ID.mips_mulv_w, 59770),  // __builtin_msa_mulv_w
    new BuiltinEntry(ID.mips_nloc_b, 59791),  // __builtin_msa_nloc_b
    new BuiltinEntry(ID.mips_nloc_d, 59812),  // __builtin_msa_nloc_d
    new BuiltinEntry(ID.mips_nloc_h, 59833),  // __builtin_msa_nloc_h
    new BuiltinEntry(ID.mips_nloc_w, 59854),  // __builtin_msa_nloc_w
    new BuiltinEntry(ID.mips_nlzc_b, 59875),  // __builtin_msa_nlzc_b
    new BuiltinEntry(ID.mips_nlzc_d, 59896),  // __builtin_msa_nlzc_d
    new BuiltinEntry(ID.mips_nlzc_h, 59917),  // __builtin_msa_nlzc_h
    new BuiltinEntry(ID.mips_nlzc_w, 59938),  // __builtin_msa_nlzc_w
    new BuiltinEntry(ID.mips_nor_v, 59959),  // __builtin_msa_nor_v
    new BuiltinEntry(ID.mips_nori_b, 59979),  // __builtin_msa_nori_b
    new BuiltinEntry(ID.mips_or_v, 60000),  // __builtin_msa_or_v
    new BuiltinEntry(ID.mips_ori_b, 60019),  // __builtin_msa_ori_b
    new BuiltinEntry(ID.mips_pckev_b, 60064),  // __builtin_msa_pckev_b
    new BuiltinEntry(ID.mips_pckev_d, 60086),  // __builtin_msa_pckev_d
    new BuiltinEntry(ID.mips_pckev_h, 60108),  // __builtin_msa_pckev_h
    new BuiltinEntry(ID.mips_pckev_w, 60130),  // __builtin_msa_pckev_w
    new BuiltinEntry(ID.mips_pckod_b, 60152),  // __builtin_msa_pckod_b
    new BuiltinEntry(ID.mips_pckod_d, 60174),  // __builtin_msa_pckod_d
    new BuiltinEntry(ID.mips_pckod_h, 60196),  // __builtin_msa_pckod_h
    new BuiltinEntry(ID.mips_pckod_w, 60218),  // __builtin_msa_pckod_w
    new BuiltinEntry(ID.mips_pcnt_b, 60240),  // __builtin_msa_pcnt_b
    new BuiltinEntry(ID.mips_pcnt_d, 60261),  // __builtin_msa_pcnt_d
    new BuiltinEntry(ID.mips_pcnt_h, 60282),  // __builtin_msa_pcnt_h
    new BuiltinEntry(ID.mips_pcnt_w, 60303),  // __builtin_msa_pcnt_w
    new BuiltinEntry(ID.mips_sat_s_b, 60987),  // __builtin_msa_sat_s_b
    new BuiltinEntry(ID.mips_sat_s_d, 61009),  // __builtin_msa_sat_s_d
    new BuiltinEntry(ID.mips_sat_s_h, 61031),  // __builtin_msa_sat_s_h
    new BuiltinEntry(ID.mips_sat_s_w, 61053),  // __builtin_msa_sat_s_w
    new BuiltinEntry(ID.mips_sat_u_b, 61075),  // __builtin_msa_sat_u_b
    new BuiltinEntry(ID.mips_sat_u_d, 61097),  // __builtin_msa_sat_u_d
    new BuiltinEntry(ID.mips_sat_u_h, 61119),  // __builtin_msa_sat_u_h
    new BuiltinEntry(ID.mips_sat_u_w, 61141),  // __builtin_msa_sat_u_w
    new BuiltinEntry(ID.mips_shf_b, 61163),  // __builtin_msa_shf_b
    new BuiltinEntry(ID.mips_shf_h, 61183),  // __builtin_msa_shf_h
    new BuiltinEntry(ID.mips_shf_w, 61203),  // __builtin_msa_shf_w
    new BuiltinEntry(ID.mips_sld_b, 61505),  // __builtin_msa_sld_b
    new BuiltinEntry(ID.mips_sld_d, 61525),  // __builtin_msa_sld_d
    new BuiltinEntry(ID.mips_sld_h, 61545),  // __builtin_msa_sld_h
    new BuiltinEntry(ID.mips_sld_w, 61565),  // __builtin_msa_sld_w
    new BuiltinEntry(ID.mips_sldi_b, 61585),  // __builtin_msa_sldi_b
    new BuiltinEntry(ID.mips_sldi_d, 61606),  // __builtin_msa_sldi_d
    new BuiltinEntry(ID.mips_sldi_h, 61627),  // __builtin_msa_sldi_h
    new BuiltinEntry(ID.mips_sldi_w, 61648),  // __builtin_msa_sldi_w
    new BuiltinEntry(ID.mips_sll_b, 61669),  // __builtin_msa_sll_b
    new BuiltinEntry(ID.mips_sll_d, 61689),  // __builtin_msa_sll_d
    new BuiltinEntry(ID.mips_sll_h, 61709),  // __builtin_msa_sll_h
    new BuiltinEntry(ID.mips_sll_w, 61729),  // __builtin_msa_sll_w
    new BuiltinEntry(ID.mips_slli_b, 61749),  // __builtin_msa_slli_b
    new BuiltinEntry(ID.mips_slli_d, 61770),  // __builtin_msa_slli_d
    new BuiltinEntry(ID.mips_slli_h, 61791),  // __builtin_msa_slli_h
    new BuiltinEntry(ID.mips_slli_w, 61812),  // __builtin_msa_slli_w
    new BuiltinEntry(ID.mips_splat_b, 61833),  // __builtin_msa_splat_b
    new BuiltinEntry(ID.mips_splat_d, 61855),  // __builtin_msa_splat_d
    new BuiltinEntry(ID.mips_splat_h, 61877),  // __builtin_msa_splat_h
    new BuiltinEntry(ID.mips_splat_w, 61899),  // __builtin_msa_splat_w
    new BuiltinEntry(ID.mips_splati_b, 61921),  // __builtin_msa_splati_b
    new BuiltinEntry(ID.mips_splati_d, 61944),  // __builtin_msa_splati_d
    new BuiltinEntry(ID.mips_splati_h, 61967),  // __builtin_msa_splati_h
    new BuiltinEntry(ID.mips_splati_w, 61990),  // __builtin_msa_splati_w
    new BuiltinEntry(ID.mips_sra_b, 62013),  // __builtin_msa_sra_b
    new BuiltinEntry(ID.mips_sra_d, 62033),  // __builtin_msa_sra_d
    new BuiltinEntry(ID.mips_sra_h, 62053),  // __builtin_msa_sra_h
    new BuiltinEntry(ID.mips_sra_w, 62073),  // __builtin_msa_sra_w
    new BuiltinEntry(ID.mips_srai_b, 62093),  // __builtin_msa_srai_b
    new BuiltinEntry(ID.mips_srai_d, 62114),  // __builtin_msa_srai_d
    new BuiltinEntry(ID.mips_srai_h, 62135),  // __builtin_msa_srai_h
    new BuiltinEntry(ID.mips_srai_w, 62156),  // __builtin_msa_srai_w
    new BuiltinEntry(ID.mips_srar_b, 62177),  // __builtin_msa_srar_b
    new BuiltinEntry(ID.mips_srar_d, 62198),  // __builtin_msa_srar_d
    new BuiltinEntry(ID.mips_srar_h, 62219),  // __builtin_msa_srar_h
    new BuiltinEntry(ID.mips_srar_w, 62240),  // __builtin_msa_srar_w
    new BuiltinEntry(ID.mips_srari_b, 62261),  // __builtin_msa_srari_b
    new BuiltinEntry(ID.mips_srari_d, 62283),  // __builtin_msa_srari_d
    new BuiltinEntry(ID.mips_srari_h, 62305),  // __builtin_msa_srari_h
    new BuiltinEntry(ID.mips_srari_w, 62327),  // __builtin_msa_srari_w
    new BuiltinEntry(ID.mips_srl_b, 62349),  // __builtin_msa_srl_b
    new BuiltinEntry(ID.mips_srl_d, 62369),  // __builtin_msa_srl_d
    new BuiltinEntry(ID.mips_srl_h, 62389),  // __builtin_msa_srl_h
    new BuiltinEntry(ID.mips_srl_w, 62409),  // __builtin_msa_srl_w
    new BuiltinEntry(ID.mips_srli_b, 62429),  // __builtin_msa_srli_b
    new BuiltinEntry(ID.mips_srli_d, 62450),  // __builtin_msa_srli_d
    new BuiltinEntry(ID.mips_srli_h, 62471),  // __builtin_msa_srli_h
    new BuiltinEntry(ID.mips_srli_w, 62492),  // __builtin_msa_srli_w
    new BuiltinEntry(ID.mips_srlr_b, 62513),  // __builtin_msa_srlr_b
    new BuiltinEntry(ID.mips_srlr_d, 62534),  // __builtin_msa_srlr_d
    new BuiltinEntry(ID.mips_srlr_h, 62555),  // __builtin_msa_srlr_h
    new BuiltinEntry(ID.mips_srlr_w, 62576),  // __builtin_msa_srlr_w
    new BuiltinEntry(ID.mips_srlri_b, 62597),  // __builtin_msa_srlri_b
    new BuiltinEntry(ID.mips_srlri_d, 62619),  // __builtin_msa_srlri_d
    new BuiltinEntry(ID.mips_srlri_h, 62641),  // __builtin_msa_srlri_h
    new BuiltinEntry(ID.mips_srlri_w, 62663),  // __builtin_msa_srlri_w
    new BuiltinEntry(ID.mips_st_b, 62685),  // __builtin_msa_st_b
    new BuiltinEntry(ID.mips_st_d, 62704),  // __builtin_msa_st_d
    new BuiltinEntry(ID.mips_st_h, 62723),  // __builtin_msa_st_h
    new BuiltinEntry(ID.mips_st_w, 62742),  // __builtin_msa_st_w
    new BuiltinEntry(ID.mips_subs_s_b, 62931),  // __builtin_msa_subs_s_b
    new BuiltinEntry(ID.mips_subs_s_d, 62954),  // __builtin_msa_subs_s_d
    new BuiltinEntry(ID.mips_subs_s_h, 62977),  // __builtin_msa_subs_s_h
    new BuiltinEntry(ID.mips_subs_s_w, 63000),  // __builtin_msa_subs_s_w
    new BuiltinEntry(ID.mips_subs_u_b, 63023),  // __builtin_msa_subs_u_b
    new BuiltinEntry(ID.mips_subs_u_d, 63046),  // __builtin_msa_subs_u_d
    new BuiltinEntry(ID.mips_subs_u_h, 63069),  // __builtin_msa_subs_u_h
    new BuiltinEntry(ID.mips_subs_u_w, 63092),  // __builtin_msa_subs_u_w
    new BuiltinEntry(ID.mips_subsus_u_b, 63115),  // __builtin_msa_subsus_u_b
    new BuiltinEntry(ID.mips_subsus_u_d, 63140),  // __builtin_msa_subsus_u_d
    new BuiltinEntry(ID.mips_subsus_u_h, 63165),  // __builtin_msa_subsus_u_h
    new BuiltinEntry(ID.mips_subsus_u_w, 63190),  // __builtin_msa_subsus_u_w
    new BuiltinEntry(ID.mips_subsuu_s_b, 63215),  // __builtin_msa_subsuu_s_b
    new BuiltinEntry(ID.mips_subsuu_s_d, 63240),  // __builtin_msa_subsuu_s_d
    new BuiltinEntry(ID.mips_subsuu_s_h, 63265),  // __builtin_msa_subsuu_s_h
    new BuiltinEntry(ID.mips_subsuu_s_w, 63290),  // __builtin_msa_subsuu_s_w
    new BuiltinEntry(ID.mips_subv_b, 63461),  // __builtin_msa_subv_b
    new BuiltinEntry(ID.mips_subv_d, 63482),  // __builtin_msa_subv_d
    new BuiltinEntry(ID.mips_subv_h, 63503),  // __builtin_msa_subv_h
    new BuiltinEntry(ID.mips_subv_w, 63524),  // __builtin_msa_subv_w
    new BuiltinEntry(ID.mips_subvi_b, 63545),  // __builtin_msa_subvi_b
    new BuiltinEntry(ID.mips_subvi_d, 63567),  // __builtin_msa_subvi_d
    new BuiltinEntry(ID.mips_subvi_h, 63589),  // __builtin_msa_subvi_h
    new BuiltinEntry(ID.mips_subvi_w, 63611),  // __builtin_msa_subvi_w
    new BuiltinEntry(ID.mips_vshf_b, 63633),  // __builtin_msa_vshf_b
    new BuiltinEntry(ID.mips_vshf_d, 63654),  // __builtin_msa_vshf_d
    new BuiltinEntry(ID.mips_vshf_h, 63675),  // __builtin_msa_vshf_h
    new BuiltinEntry(ID.mips_vshf_w, 63696),  // __builtin_msa_vshf_w
    new BuiltinEntry(ID.mips_xor_v, 63738),  // __builtin_msa_xor_v
    new BuiltinEntry(ID.mips_xori_b, 63758) // __builtin_msa_xori_b
  };
  static final/*static*/ /*const*/ BuiltinEntry nvvmNames[/*555*/] = new /*const*/ BuiltinEntry [/*555*/] {
    new BuiltinEntry(ID.nvvm_abs_i, 63779),  // __nvvm_abs_i
    new BuiltinEntry(ID.nvvm_abs_ll, 63792),  // __nvvm_abs_ll
    new BuiltinEntry(ID.nvvm_add_rm_d, 63806),  // __nvvm_add_rm_d
    new BuiltinEntry(ID.nvvm_add_rm_f, 63822),  // __nvvm_add_rm_f
    new BuiltinEntry(ID.nvvm_add_rm_ftz_f, 63838),  // __nvvm_add_rm_ftz_f
    new BuiltinEntry(ID.nvvm_add_rn_d, 63858),  // __nvvm_add_rn_d
    new BuiltinEntry(ID.nvvm_add_rn_f, 63874),  // __nvvm_add_rn_f
    new BuiltinEntry(ID.nvvm_add_rn_ftz_f, 63890),  // __nvvm_add_rn_ftz_f
    new BuiltinEntry(ID.nvvm_add_rp_d, 63910),  // __nvvm_add_rp_d
    new BuiltinEntry(ID.nvvm_add_rp_f, 63926),  // __nvvm_add_rp_f
    new BuiltinEntry(ID.nvvm_add_rp_ftz_f, 63942),  // __nvvm_add_rp_ftz_f
    new BuiltinEntry(ID.nvvm_add_rz_d, 63962),  // __nvvm_add_rz_d
    new BuiltinEntry(ID.nvvm_add_rz_f, 63978),  // __nvvm_add_rz_f
    new BuiltinEntry(ID.nvvm_add_rz_ftz_f, 63994),  // __nvvm_add_rz_ftz_f
    new BuiltinEntry(ID.nvvm_barrier0_and, 64044),  // __nvvm_bar0_and
    new BuiltinEntry(ID.nvvm_barrier0_or, 64060),  // __nvvm_bar0_or
    new BuiltinEntry(ID.nvvm_barrier0_popc, 64075),  // __nvvm_bar0_popc
    new BuiltinEntry(ID.nvvm_bar_sync, 64014),  // __nvvm_bar_sync
    new BuiltinEntry(ID.nvvm_bitcast_d2ll, 64092),  // __nvvm_bitcast_d2ll
    new BuiltinEntry(ID.nvvm_bitcast_f2i, 64112),  // __nvvm_bitcast_f2i
    new BuiltinEntry(ID.nvvm_bitcast_i2f, 64131),  // __nvvm_bitcast_i2f
    new BuiltinEntry(ID.nvvm_bitcast_ll2d, 64150),  // __nvvm_bitcast_ll2d
    new BuiltinEntry(ID.nvvm_brev32, 64170),  // __nvvm_brev32
    new BuiltinEntry(ID.nvvm_brev64, 64184),  // __nvvm_brev64
    new BuiltinEntry(ID.nvvm_ceil_d, 64198),  // __nvvm_ceil_d
    new BuiltinEntry(ID.nvvm_ceil_f, 64212),  // __nvvm_ceil_f
    new BuiltinEntry(ID.nvvm_ceil_ftz_f, 64226),  // __nvvm_ceil_ftz_f
    new BuiltinEntry(ID.nvvm_clz_i, 64244),  // __nvvm_clz_i
    new BuiltinEntry(ID.nvvm_clz_ll, 64257),  // __nvvm_clz_ll
    new BuiltinEntry(ID.nvvm_cos_approx_f, 64271),  // __nvvm_cos_approx_f
    new BuiltinEntry(ID.nvvm_cos_approx_ftz_f, 64291),  // __nvvm_cos_approx_ftz_f
    new BuiltinEntry(ID.nvvm_d2f_rm, 64315),  // __nvvm_d2f_rm
    new BuiltinEntry(ID.nvvm_d2f_rm_ftz, 64329),  // __nvvm_d2f_rm_ftz
    new BuiltinEntry(ID.nvvm_d2f_rn, 64347),  // __nvvm_d2f_rn
    new BuiltinEntry(ID.nvvm_d2f_rn_ftz, 64361),  // __nvvm_d2f_rn_ftz
    new BuiltinEntry(ID.nvvm_d2f_rp, 64379),  // __nvvm_d2f_rp
    new BuiltinEntry(ID.nvvm_d2f_rp_ftz, 64393),  // __nvvm_d2f_rp_ftz
    new BuiltinEntry(ID.nvvm_d2f_rz, 64411),  // __nvvm_d2f_rz
    new BuiltinEntry(ID.nvvm_d2f_rz_ftz, 64425),  // __nvvm_d2f_rz_ftz
    new BuiltinEntry(ID.nvvm_d2i_hi, 64443),  // __nvvm_d2i_hi
    new BuiltinEntry(ID.nvvm_d2i_lo, 64457),  // __nvvm_d2i_lo
    new BuiltinEntry(ID.nvvm_d2i_rm, 64471),  // __nvvm_d2i_rm
    new BuiltinEntry(ID.nvvm_d2i_rn, 64485),  // __nvvm_d2i_rn
    new BuiltinEntry(ID.nvvm_d2i_rp, 64499),  // __nvvm_d2i_rp
    new BuiltinEntry(ID.nvvm_d2i_rz, 64513),  // __nvvm_d2i_rz
    new BuiltinEntry(ID.nvvm_d2ll_rm, 64527),  // __nvvm_d2ll_rm
    new BuiltinEntry(ID.nvvm_d2ll_rn, 64542),  // __nvvm_d2ll_rn
    new BuiltinEntry(ID.nvvm_d2ll_rp, 64557),  // __nvvm_d2ll_rp
    new BuiltinEntry(ID.nvvm_d2ll_rz, 64572),  // __nvvm_d2ll_rz
    new BuiltinEntry(ID.nvvm_d2ui_rm, 64587),  // __nvvm_d2ui_rm
    new BuiltinEntry(ID.nvvm_d2ui_rn, 64602),  // __nvvm_d2ui_rn
    new BuiltinEntry(ID.nvvm_d2ui_rp, 64617),  // __nvvm_d2ui_rp
    new BuiltinEntry(ID.nvvm_d2ui_rz, 64632),  // __nvvm_d2ui_rz
    new BuiltinEntry(ID.nvvm_d2ull_rm, 64647),  // __nvvm_d2ull_rm
    new BuiltinEntry(ID.nvvm_d2ull_rn, 64663),  // __nvvm_d2ull_rn
    new BuiltinEntry(ID.nvvm_d2ull_rp, 64679),  // __nvvm_d2ull_rp
    new BuiltinEntry(ID.nvvm_d2ull_rz, 64695),  // __nvvm_d2ull_rz
    new BuiltinEntry(ID.nvvm_div_approx_f, 64711),  // __nvvm_div_approx_f
    new BuiltinEntry(ID.nvvm_div_approx_ftz_f, 64731),  // __nvvm_div_approx_ftz_f
    new BuiltinEntry(ID.nvvm_div_rm_d, 64755),  // __nvvm_div_rm_d
    new BuiltinEntry(ID.nvvm_div_rm_f, 64771),  // __nvvm_div_rm_f
    new BuiltinEntry(ID.nvvm_div_rm_ftz_f, 64787),  // __nvvm_div_rm_ftz_f
    new BuiltinEntry(ID.nvvm_div_rn_d, 64807),  // __nvvm_div_rn_d
    new BuiltinEntry(ID.nvvm_div_rn_f, 64823),  // __nvvm_div_rn_f
    new BuiltinEntry(ID.nvvm_div_rn_ftz_f, 64839),  // __nvvm_div_rn_ftz_f
    new BuiltinEntry(ID.nvvm_div_rp_d, 64859),  // __nvvm_div_rp_d
    new BuiltinEntry(ID.nvvm_div_rp_f, 64875),  // __nvvm_div_rp_f
    new BuiltinEntry(ID.nvvm_div_rp_ftz_f, 64891),  // __nvvm_div_rp_ftz_f
    new BuiltinEntry(ID.nvvm_div_rz_d, 64911),  // __nvvm_div_rz_d
    new BuiltinEntry(ID.nvvm_div_rz_f, 64927),  // __nvvm_div_rz_f
    new BuiltinEntry(ID.nvvm_div_rz_ftz_f, 64943),  // __nvvm_div_rz_ftz_f
    new BuiltinEntry(ID.nvvm_ex2_approx_d, 64963),  // __nvvm_ex2_approx_d
    new BuiltinEntry(ID.nvvm_ex2_approx_f, 64983),  // __nvvm_ex2_approx_f
    new BuiltinEntry(ID.nvvm_ex2_approx_ftz_f, 65003),  // __nvvm_ex2_approx_ftz_f
    new BuiltinEntry(ID.nvvm_f2h_rn, 65027),  // __nvvm_f2h_rn
    new BuiltinEntry(ID.nvvm_f2h_rn_ftz, 65041),  // __nvvm_f2h_rn_ftz
    new BuiltinEntry(ID.nvvm_f2i_rm, 65059),  // __nvvm_f2i_rm
    new BuiltinEntry(ID.nvvm_f2i_rm_ftz, 65073),  // __nvvm_f2i_rm_ftz
    new BuiltinEntry(ID.nvvm_f2i_rn, 65091),  // __nvvm_f2i_rn
    new BuiltinEntry(ID.nvvm_f2i_rn_ftz, 65105),  // __nvvm_f2i_rn_ftz
    new BuiltinEntry(ID.nvvm_f2i_rp, 65123),  // __nvvm_f2i_rp
    new BuiltinEntry(ID.nvvm_f2i_rp_ftz, 65137),  // __nvvm_f2i_rp_ftz
    new BuiltinEntry(ID.nvvm_f2i_rz, 65155),  // __nvvm_f2i_rz
    new BuiltinEntry(ID.nvvm_f2i_rz_ftz, 65169),  // __nvvm_f2i_rz_ftz
    new BuiltinEntry(ID.nvvm_f2ll_rm, 65187),  // __nvvm_f2ll_rm
    new BuiltinEntry(ID.nvvm_f2ll_rm_ftz, 65202),  // __nvvm_f2ll_rm_ftz
    new BuiltinEntry(ID.nvvm_f2ll_rn, 65221),  // __nvvm_f2ll_rn
    new BuiltinEntry(ID.nvvm_f2ll_rn_ftz, 65236),  // __nvvm_f2ll_rn_ftz
    new BuiltinEntry(ID.nvvm_f2ll_rp, 65255),  // __nvvm_f2ll_rp
    new BuiltinEntry(ID.nvvm_f2ll_rp_ftz, 65270),  // __nvvm_f2ll_rp_ftz
    new BuiltinEntry(ID.nvvm_f2ll_rz, 65289),  // __nvvm_f2ll_rz
    new BuiltinEntry(ID.nvvm_f2ll_rz_ftz, 65304),  // __nvvm_f2ll_rz_ftz
    new BuiltinEntry(ID.nvvm_f2ui_rm, 65323),  // __nvvm_f2ui_rm
    new BuiltinEntry(ID.nvvm_f2ui_rm_ftz, 65338),  // __nvvm_f2ui_rm_ftz
    new BuiltinEntry(ID.nvvm_f2ui_rn, 65357),  // __nvvm_f2ui_rn
    new BuiltinEntry(ID.nvvm_f2ui_rn_ftz, 65372),  // __nvvm_f2ui_rn_ftz
    new BuiltinEntry(ID.nvvm_f2ui_rp, 65391),  // __nvvm_f2ui_rp
    new BuiltinEntry(ID.nvvm_f2ui_rp_ftz, 65406),  // __nvvm_f2ui_rp_ftz
    new BuiltinEntry(ID.nvvm_f2ui_rz, 65425),  // __nvvm_f2ui_rz
    new BuiltinEntry(ID.nvvm_f2ui_rz_ftz, 65440),  // __nvvm_f2ui_rz_ftz
    new BuiltinEntry(ID.nvvm_f2ull_rm, 65459),  // __nvvm_f2ull_rm
    new BuiltinEntry(ID.nvvm_f2ull_rm_ftz, 65475),  // __nvvm_f2ull_rm_ftz
    new BuiltinEntry(ID.nvvm_f2ull_rn, 65495),  // __nvvm_f2ull_rn
    new BuiltinEntry(ID.nvvm_f2ull_rn_ftz, 65511),  // __nvvm_f2ull_rn_ftz
    new BuiltinEntry(ID.nvvm_f2ull_rp, 65531),  // __nvvm_f2ull_rp
    new BuiltinEntry(ID.nvvm_f2ull_rp_ftz, 65547),  // __nvvm_f2ull_rp_ftz
    new BuiltinEntry(ID.nvvm_f2ull_rz, 65567),  // __nvvm_f2ull_rz
    new BuiltinEntry(ID.nvvm_f2ull_rz_ftz, 65583),  // __nvvm_f2ull_rz_ftz
    new BuiltinEntry(ID.nvvm_fabs_d, 65603),  // __nvvm_fabs_d
    new BuiltinEntry(ID.nvvm_fabs_f, 65617),  // __nvvm_fabs_f
    new BuiltinEntry(ID.nvvm_fabs_ftz_f, 65631),  // __nvvm_fabs_ftz_f
    new BuiltinEntry(ID.nvvm_floor_d, 65649),  // __nvvm_floor_d
    new BuiltinEntry(ID.nvvm_floor_f, 65664),  // __nvvm_floor_f
    new BuiltinEntry(ID.nvvm_floor_ftz_f, 65679),  // __nvvm_floor_ftz_f
    new BuiltinEntry(ID.nvvm_fma_rm_d, 65698),  // __nvvm_fma_rm_d
    new BuiltinEntry(ID.nvvm_fma_rm_f, 65714),  // __nvvm_fma_rm_f
    new BuiltinEntry(ID.nvvm_fma_rm_ftz_f, 65730),  // __nvvm_fma_rm_ftz_f
    new BuiltinEntry(ID.nvvm_fma_rn_d, 65750),  // __nvvm_fma_rn_d
    new BuiltinEntry(ID.nvvm_fma_rn_f, 65766),  // __nvvm_fma_rn_f
    new BuiltinEntry(ID.nvvm_fma_rn_ftz_f, 65782),  // __nvvm_fma_rn_ftz_f
    new BuiltinEntry(ID.nvvm_fma_rp_d, 65802),  // __nvvm_fma_rp_d
    new BuiltinEntry(ID.nvvm_fma_rp_f, 65818),  // __nvvm_fma_rp_f
    new BuiltinEntry(ID.nvvm_fma_rp_ftz_f, 65834),  // __nvvm_fma_rp_ftz_f
    new BuiltinEntry(ID.nvvm_fma_rz_d, 65854),  // __nvvm_fma_rz_d
    new BuiltinEntry(ID.nvvm_fma_rz_f, 65870),  // __nvvm_fma_rz_f
    new BuiltinEntry(ID.nvvm_fma_rz_ftz_f, 65886),  // __nvvm_fma_rz_ftz_f
    new BuiltinEntry(ID.nvvm_fmax_d, 65906),  // __nvvm_fmax_d
    new BuiltinEntry(ID.nvvm_fmax_f, 65920),  // __nvvm_fmax_f
    new BuiltinEntry(ID.nvvm_fmax_ftz_f, 65934),  // __nvvm_fmax_ftz_f
    new BuiltinEntry(ID.nvvm_fmin_d, 65952),  // __nvvm_fmin_d
    new BuiltinEntry(ID.nvvm_fmin_f, 65966),  // __nvvm_fmin_f
    new BuiltinEntry(ID.nvvm_fmin_ftz_f, 65980),  // __nvvm_fmin_ftz_f
    new BuiltinEntry(ID.nvvm_h2f, 65998),  // __nvvm_h2f
    new BuiltinEntry(ID.nvvm_i2d_rm, 66009),  // __nvvm_i2d_rm
    new BuiltinEntry(ID.nvvm_i2d_rn, 66023),  // __nvvm_i2d_rn
    new BuiltinEntry(ID.nvvm_i2d_rp, 66037),  // __nvvm_i2d_rp
    new BuiltinEntry(ID.nvvm_i2d_rz, 66051),  // __nvvm_i2d_rz
    new BuiltinEntry(ID.nvvm_i2f_rm, 66065),  // __nvvm_i2f_rm
    new BuiltinEntry(ID.nvvm_i2f_rn, 66079),  // __nvvm_i2f_rn
    new BuiltinEntry(ID.nvvm_i2f_rp, 66093),  // __nvvm_i2f_rp
    new BuiltinEntry(ID.nvvm_i2f_rz, 66107),  // __nvvm_i2f_rz
    new BuiltinEntry(ID.nvvm_isspacep_const, 66121),  // __nvvm_isspacep_const
    new BuiltinEntry(ID.nvvm_isspacep_global, 66143),  // __nvvm_isspacep_global
    new BuiltinEntry(ID.nvvm_isspacep_local, 66166),  // __nvvm_isspacep_local
    new BuiltinEntry(ID.nvvm_isspacep_shared, 66188),  // __nvvm_isspacep_shared
    new BuiltinEntry(ID.nvvm_istypep_sampler, 66211),  // __nvvm_istypep_sampler
    new BuiltinEntry(ID.nvvm_istypep_surface, 66234),  // __nvvm_istypep_surface
    new BuiltinEntry(ID.nvvm_istypep_texture, 66257),  // __nvvm_istypep_texture
    new BuiltinEntry(ID.nvvm_lg2_approx_d, 66280),  // __nvvm_lg2_approx_d
    new BuiltinEntry(ID.nvvm_lg2_approx_f, 66300),  // __nvvm_lg2_approx_f
    new BuiltinEntry(ID.nvvm_lg2_approx_ftz_f, 66320),  // __nvvm_lg2_approx_ftz_f
    new BuiltinEntry(ID.nvvm_ll2d_rm, 66344),  // __nvvm_ll2d_rm
    new BuiltinEntry(ID.nvvm_ll2d_rn, 66359),  // __nvvm_ll2d_rn
    new BuiltinEntry(ID.nvvm_ll2d_rp, 66374),  // __nvvm_ll2d_rp
    new BuiltinEntry(ID.nvvm_ll2d_rz, 66389),  // __nvvm_ll2d_rz
    new BuiltinEntry(ID.nvvm_ll2f_rm, 66404),  // __nvvm_ll2f_rm
    new BuiltinEntry(ID.nvvm_ll2f_rn, 66419),  // __nvvm_ll2f_rn
    new BuiltinEntry(ID.nvvm_ll2f_rp, 66434),  // __nvvm_ll2f_rp
    new BuiltinEntry(ID.nvvm_ll2f_rz, 66449),  // __nvvm_ll2f_rz
    new BuiltinEntry(ID.nvvm_lohi_i2d, 66464),  // __nvvm_lohi_i2d
    new BuiltinEntry(ID.nvvm_max_i, 66480),  // __nvvm_max_i
    new BuiltinEntry(ID.nvvm_max_ll, 66493),  // __nvvm_max_ll
    new BuiltinEntry(ID.nvvm_max_ui, 66507),  // __nvvm_max_ui
    new BuiltinEntry(ID.nvvm_max_ull, 66521),  // __nvvm_max_ull
    new BuiltinEntry(ID.nvvm_membar_cta, 66536),  // __nvvm_membar_cta
    new BuiltinEntry(ID.nvvm_membar_gl, 66554),  // __nvvm_membar_gl
    new BuiltinEntry(ID.nvvm_membar_sys, 66571),  // __nvvm_membar_sys
    new BuiltinEntry(ID.nvvm_min_i, 66589),  // __nvvm_min_i
    new BuiltinEntry(ID.nvvm_min_ll, 66602),  // __nvvm_min_ll
    new BuiltinEntry(ID.nvvm_min_ui, 66616),  // __nvvm_min_ui
    new BuiltinEntry(ID.nvvm_min_ull, 66630),  // __nvvm_min_ull
    new BuiltinEntry(ID.nvvm_mul24_i, 66853),  // __nvvm_mul24_i
    new BuiltinEntry(ID.nvvm_mul24_ui, 66868),  // __nvvm_mul24_ui
    new BuiltinEntry(ID.nvvm_mul_rm_d, 66645),  // __nvvm_mul_rm_d
    new BuiltinEntry(ID.nvvm_mul_rm_f, 66661),  // __nvvm_mul_rm_f
    new BuiltinEntry(ID.nvvm_mul_rm_ftz_f, 66677),  // __nvvm_mul_rm_ftz_f
    new BuiltinEntry(ID.nvvm_mul_rn_d, 66697),  // __nvvm_mul_rn_d
    new BuiltinEntry(ID.nvvm_mul_rn_f, 66713),  // __nvvm_mul_rn_f
    new BuiltinEntry(ID.nvvm_mul_rn_ftz_f, 66729),  // __nvvm_mul_rn_ftz_f
    new BuiltinEntry(ID.nvvm_mul_rp_d, 66749),  // __nvvm_mul_rp_d
    new BuiltinEntry(ID.nvvm_mul_rp_f, 66765),  // __nvvm_mul_rp_f
    new BuiltinEntry(ID.nvvm_mul_rp_ftz_f, 66781),  // __nvvm_mul_rp_ftz_f
    new BuiltinEntry(ID.nvvm_mul_rz_d, 66801),  // __nvvm_mul_rz_d
    new BuiltinEntry(ID.nvvm_mul_rz_f, 66817),  // __nvvm_mul_rz_f
    new BuiltinEntry(ID.nvvm_mul_rz_ftz_f, 66833),  // __nvvm_mul_rz_ftz_f
    new BuiltinEntry(ID.nvvm_mulhi_i, 66884),  // __nvvm_mulhi_i
    new BuiltinEntry(ID.nvvm_mulhi_ll, 66899),  // __nvvm_mulhi_ll
    new BuiltinEntry(ID.nvvm_mulhi_ui, 66915),  // __nvvm_mulhi_ui
    new BuiltinEntry(ID.nvvm_mulhi_ull, 66931),  // __nvvm_mulhi_ull
    new BuiltinEntry(ID.nvvm_popc_i, 66948),  // __nvvm_popc_i
    new BuiltinEntry(ID.nvvm_popc_ll, 66962),  // __nvvm_popc_ll
    new BuiltinEntry(ID.nvvm_prmt, 66977),  // __nvvm_prmt
    new BuiltinEntry(ID.nvvm_rcp_approx_ftz_d, 66989),  // __nvvm_rcp_approx_ftz_d
    new BuiltinEntry(ID.nvvm_rcp_rm_d, 67013),  // __nvvm_rcp_rm_d
    new BuiltinEntry(ID.nvvm_rcp_rm_f, 67029),  // __nvvm_rcp_rm_f
    new BuiltinEntry(ID.nvvm_rcp_rm_ftz_f, 67045),  // __nvvm_rcp_rm_ftz_f
    new BuiltinEntry(ID.nvvm_rcp_rn_d, 67065),  // __nvvm_rcp_rn_d
    new BuiltinEntry(ID.nvvm_rcp_rn_f, 67081),  // __nvvm_rcp_rn_f
    new BuiltinEntry(ID.nvvm_rcp_rn_ftz_f, 67097),  // __nvvm_rcp_rn_ftz_f
    new BuiltinEntry(ID.nvvm_rcp_rp_d, 67117),  // __nvvm_rcp_rp_d
    new BuiltinEntry(ID.nvvm_rcp_rp_f, 67133),  // __nvvm_rcp_rp_f
    new BuiltinEntry(ID.nvvm_rcp_rp_ftz_f, 67149),  // __nvvm_rcp_rp_ftz_f
    new BuiltinEntry(ID.nvvm_rcp_rz_d, 67169),  // __nvvm_rcp_rz_d
    new BuiltinEntry(ID.nvvm_rcp_rz_f, 67185),  // __nvvm_rcp_rz_f
    new BuiltinEntry(ID.nvvm_rcp_rz_ftz_f, 67201),  // __nvvm_rcp_rz_ftz_f
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_clock, 67221),  // __nvvm_read_ptx_sreg_clock
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_clock64, 67248),  // __nvvm_read_ptx_sreg_clock64
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_ctaid_w, 67277),  // __nvvm_read_ptx_sreg_ctaid_w
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_ctaid_x, 67306),  // __nvvm_read_ptx_sreg_ctaid_x
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_ctaid_y, 67335),  // __nvvm_read_ptx_sreg_ctaid_y
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_ctaid_z, 67364),  // __nvvm_read_ptx_sreg_ctaid_z
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg0, 67393),  // __nvvm_read_ptx_sreg_envreg0
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg1, 67422),  // __nvvm_read_ptx_sreg_envreg1
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg10, 67451),  // __nvvm_read_ptx_sreg_envreg10
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg11, 67481),  // __nvvm_read_ptx_sreg_envreg11
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg12, 67511),  // __nvvm_read_ptx_sreg_envreg12
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg13, 67541),  // __nvvm_read_ptx_sreg_envreg13
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg14, 67571),  // __nvvm_read_ptx_sreg_envreg14
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg15, 67601),  // __nvvm_read_ptx_sreg_envreg15
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg16, 67631),  // __nvvm_read_ptx_sreg_envreg16
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg17, 67661),  // __nvvm_read_ptx_sreg_envreg17
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg18, 67691),  // __nvvm_read_ptx_sreg_envreg18
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg19, 67721),  // __nvvm_read_ptx_sreg_envreg19
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg2, 67751),  // __nvvm_read_ptx_sreg_envreg2
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg20, 67780),  // __nvvm_read_ptx_sreg_envreg20
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg21, 67810),  // __nvvm_read_ptx_sreg_envreg21
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg22, 67840),  // __nvvm_read_ptx_sreg_envreg22
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg23, 67870),  // __nvvm_read_ptx_sreg_envreg23
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg24, 67900),  // __nvvm_read_ptx_sreg_envreg24
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg25, 67930),  // __nvvm_read_ptx_sreg_envreg25
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg26, 67960),  // __nvvm_read_ptx_sreg_envreg26
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg27, 67990),  // __nvvm_read_ptx_sreg_envreg27
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg28, 68020),  // __nvvm_read_ptx_sreg_envreg28
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg29, 68050),  // __nvvm_read_ptx_sreg_envreg29
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg3, 68080),  // __nvvm_read_ptx_sreg_envreg3
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg30, 68109),  // __nvvm_read_ptx_sreg_envreg30
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg31, 68139),  // __nvvm_read_ptx_sreg_envreg31
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg4, 68169),  // __nvvm_read_ptx_sreg_envreg4
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg5, 68198),  // __nvvm_read_ptx_sreg_envreg5
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg6, 68227),  // __nvvm_read_ptx_sreg_envreg6
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg7, 68256),  // __nvvm_read_ptx_sreg_envreg7
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg8, 68285),  // __nvvm_read_ptx_sreg_envreg8
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_envreg9, 68314),  // __nvvm_read_ptx_sreg_envreg9
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_gridid, 68343),  // __nvvm_read_ptx_sreg_gridid
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_laneid, 68371),  // __nvvm_read_ptx_sreg_laneid
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_lanemask_eq, 68399),  // __nvvm_read_ptx_sreg_lanemask_eq
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_lanemask_ge, 68432),  // __nvvm_read_ptx_sreg_lanemask_ge
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_lanemask_gt, 68465),  // __nvvm_read_ptx_sreg_lanemask_gt
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_lanemask_le, 68498),  // __nvvm_read_ptx_sreg_lanemask_le
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_lanemask_lt, 68531),  // __nvvm_read_ptx_sreg_lanemask_lt
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_nctaid_w, 68564),  // __nvvm_read_ptx_sreg_nctaid_w
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_nctaid_x, 68594),  // __nvvm_read_ptx_sreg_nctaid_x
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_nctaid_y, 68624),  // __nvvm_read_ptx_sreg_nctaid_y
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_nctaid_z, 68654),  // __nvvm_read_ptx_sreg_nctaid_z
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_nsmid, 68684),  // __nvvm_read_ptx_sreg_nsmid
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_ntid_w, 68711),  // __nvvm_read_ptx_sreg_ntid_w
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_ntid_x, 68739),  // __nvvm_read_ptx_sreg_ntid_x
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_ntid_y, 68767),  // __nvvm_read_ptx_sreg_ntid_y
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_ntid_z, 68795),  // __nvvm_read_ptx_sreg_ntid_z
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_nwarpid, 68823),  // __nvvm_read_ptx_sreg_nwarpid
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_pm0, 68852),  // __nvvm_read_ptx_sreg_pm0
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_pm1, 68877),  // __nvvm_read_ptx_sreg_pm1
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_pm2, 68902),  // __nvvm_read_ptx_sreg_pm2
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_pm3, 68927),  // __nvvm_read_ptx_sreg_pm3
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_smid, 68952),  // __nvvm_read_ptx_sreg_smid
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_tid_w, 68978),  // __nvvm_read_ptx_sreg_tid_w
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_tid_x, 69005),  // __nvvm_read_ptx_sreg_tid_x
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_tid_y, 69032),  // __nvvm_read_ptx_sreg_tid_y
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_tid_z, 69059),  // __nvvm_read_ptx_sreg_tid_z
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_warpid, 69086),  // __nvvm_read_ptx_sreg_warpid
    new BuiltinEntry(ID.nvvm_read_ptx_sreg_warpsize, 69114),  // __nvvm_read_ptx_sreg_warpsize
    new BuiltinEntry(ID.nvvm_rotate_b32, 69144),  // __nvvm_rotate_b32
    new BuiltinEntry(ID.nvvm_rotate_b64, 69162),  // __nvvm_rotate_b64
    new BuiltinEntry(ID.nvvm_rotate_right_b64, 69180),  // __nvvm_rotate_right_b64
    new BuiltinEntry(ID.nvvm_round_d, 69204),  // __nvvm_round_d
    new BuiltinEntry(ID.nvvm_round_f, 69219),  // __nvvm_round_f
    new BuiltinEntry(ID.nvvm_round_ftz_f, 69234),  // __nvvm_round_ftz_f
    new BuiltinEntry(ID.nvvm_rsqrt_approx_d, 69253),  // __nvvm_rsqrt_approx_d
    new BuiltinEntry(ID.nvvm_rsqrt_approx_f, 69275),  // __nvvm_rsqrt_approx_f
    new BuiltinEntry(ID.nvvm_rsqrt_approx_ftz_f, 69297),  // __nvvm_rsqrt_approx_ftz_f
    new BuiltinEntry(ID.nvvm_sad_i, 69323),  // __nvvm_sad_i
    new BuiltinEntry(ID.nvvm_sad_ui, 69336),  // __nvvm_sad_ui
    new BuiltinEntry(ID.nvvm_saturate_d, 69350),  // __nvvm_saturate_d
    new BuiltinEntry(ID.nvvm_saturate_f, 69368),  // __nvvm_saturate_f
    new BuiltinEntry(ID.nvvm_saturate_ftz_f, 69386),  // __nvvm_saturate_ftz_f
    new BuiltinEntry(ID.nvvm_shfl_bfly_f32, 69408),  // __nvvm_shfl_bfly_f32
    new BuiltinEntry(ID.nvvm_shfl_bfly_i32, 69429),  // __nvvm_shfl_bfly_i32
    new BuiltinEntry(ID.nvvm_shfl_down_f32, 69450),  // __nvvm_shfl_down_f32
    new BuiltinEntry(ID.nvvm_shfl_down_i32, 69471),  // __nvvm_shfl_down_i32
    new BuiltinEntry(ID.nvvm_shfl_idx_f32, 69492),  // __nvvm_shfl_idx_f32
    new BuiltinEntry(ID.nvvm_shfl_idx_i32, 69512),  // __nvvm_shfl_idx_i32
    new BuiltinEntry(ID.nvvm_shfl_up_f32, 69532),  // __nvvm_shfl_up_f32
    new BuiltinEntry(ID.nvvm_shfl_up_i32, 69551),  // __nvvm_shfl_up_i32
    new BuiltinEntry(ID.nvvm_sin_approx_f, 69570),  // __nvvm_sin_approx_f
    new BuiltinEntry(ID.nvvm_sin_approx_ftz_f, 69590),  // __nvvm_sin_approx_ftz_f
    new BuiltinEntry(ID.nvvm_sqrt_approx_f, 69614),  // __nvvm_sqrt_approx_f
    new BuiltinEntry(ID.nvvm_sqrt_approx_ftz_f, 69635),  // __nvvm_sqrt_approx_ftz_f
    new BuiltinEntry(ID.nvvm_sqrt_f, 69660),  // __nvvm_sqrt_f
    new BuiltinEntry(ID.nvvm_sqrt_rm_d, 69674),  // __nvvm_sqrt_rm_d
    new BuiltinEntry(ID.nvvm_sqrt_rm_f, 69691),  // __nvvm_sqrt_rm_f
    new BuiltinEntry(ID.nvvm_sqrt_rm_ftz_f, 69708),  // __nvvm_sqrt_rm_ftz_f
    new BuiltinEntry(ID.nvvm_sqrt_rn_d, 69729),  // __nvvm_sqrt_rn_d
    new BuiltinEntry(ID.nvvm_sqrt_rn_f, 69746),  // __nvvm_sqrt_rn_f
    new BuiltinEntry(ID.nvvm_sqrt_rn_ftz_f, 69763),  // __nvvm_sqrt_rn_ftz_f
    new BuiltinEntry(ID.nvvm_sqrt_rp_d, 69784),  // __nvvm_sqrt_rp_d
    new BuiltinEntry(ID.nvvm_sqrt_rp_f, 69801),  // __nvvm_sqrt_rp_f
    new BuiltinEntry(ID.nvvm_sqrt_rp_ftz_f, 69818),  // __nvvm_sqrt_rp_ftz_f
    new BuiltinEntry(ID.nvvm_sqrt_rz_d, 69839),  // __nvvm_sqrt_rz_d
    new BuiltinEntry(ID.nvvm_sqrt_rz_f, 69856),  // __nvvm_sqrt_rz_f
    new BuiltinEntry(ID.nvvm_sqrt_rz_ftz_f, 69873),  // __nvvm_sqrt_rz_ftz_f
    new BuiltinEntry(ID.nvvm_suq_array_size, 69894),  // __nvvm_suq_array_size
    new BuiltinEntry(ID.nvvm_suq_channel_data_type, 69916),  // __nvvm_suq_channel_data_type
    new BuiltinEntry(ID.nvvm_suq_channel_order, 69945),  // __nvvm_suq_channel_order
    new BuiltinEntry(ID.nvvm_suq_depth, 69970),  // __nvvm_suq_depth
    new BuiltinEntry(ID.nvvm_suq_height, 69987),  // __nvvm_suq_height
    new BuiltinEntry(ID.nvvm_suq_width, 70005),  // __nvvm_suq_width
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i16_clamp, 70022),  // __nvvm_sust_b_1d_array_i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i16_trap, 70055),  // __nvvm_sust_b_1d_array_i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i16_zero, 70087),  // __nvvm_sust_b_1d_array_i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i32_clamp, 70119),  // __nvvm_sust_b_1d_array_i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i32_trap, 70152),  // __nvvm_sust_b_1d_array_i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i32_zero, 70184),  // __nvvm_sust_b_1d_array_i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i64_clamp, 70216),  // __nvvm_sust_b_1d_array_i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i64_trap, 70249),  // __nvvm_sust_b_1d_array_i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i64_zero, 70281),  // __nvvm_sust_b_1d_array_i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i8_clamp, 70313),  // __nvvm_sust_b_1d_array_i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i8_trap, 70345),  // __nvvm_sust_b_1d_array_i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_i8_zero, 70376),  // __nvvm_sust_b_1d_array_i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i16_clamp, 70407),  // __nvvm_sust_b_1d_array_v2i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i16_trap, 70442),  // __nvvm_sust_b_1d_array_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i16_zero, 70476),  // __nvvm_sust_b_1d_array_v2i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i32_clamp, 70510),  // __nvvm_sust_b_1d_array_v2i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i32_trap, 70545),  // __nvvm_sust_b_1d_array_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i32_zero, 70579),  // __nvvm_sust_b_1d_array_v2i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i64_clamp, 70613),  // __nvvm_sust_b_1d_array_v2i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i64_trap, 70648),  // __nvvm_sust_b_1d_array_v2i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i64_zero, 70682),  // __nvvm_sust_b_1d_array_v2i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i8_clamp, 70716),  // __nvvm_sust_b_1d_array_v2i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i8_trap, 70750),  // __nvvm_sust_b_1d_array_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v2i8_zero, 70783),  // __nvvm_sust_b_1d_array_v2i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i16_clamp, 70816),  // __nvvm_sust_b_1d_array_v4i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i16_trap, 70851),  // __nvvm_sust_b_1d_array_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i16_zero, 70885),  // __nvvm_sust_b_1d_array_v4i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i32_clamp, 70919),  // __nvvm_sust_b_1d_array_v4i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i32_trap, 70954),  // __nvvm_sust_b_1d_array_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i32_zero, 70988),  // __nvvm_sust_b_1d_array_v4i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i8_clamp, 71022),  // __nvvm_sust_b_1d_array_v4i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i8_trap, 71056),  // __nvvm_sust_b_1d_array_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_array_v4i8_zero, 71089),  // __nvvm_sust_b_1d_array_v4i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_i16_clamp, 71122),  // __nvvm_sust_b_1d_i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_i16_trap, 71149),  // __nvvm_sust_b_1d_i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_i16_zero, 71175),  // __nvvm_sust_b_1d_i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_i32_clamp, 71201),  // __nvvm_sust_b_1d_i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_i32_trap, 71228),  // __nvvm_sust_b_1d_i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_i32_zero, 71254),  // __nvvm_sust_b_1d_i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_i64_clamp, 71280),  // __nvvm_sust_b_1d_i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_i64_trap, 71307),  // __nvvm_sust_b_1d_i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_i64_zero, 71333),  // __nvvm_sust_b_1d_i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_i8_clamp, 71359),  // __nvvm_sust_b_1d_i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_i8_trap, 71385),  // __nvvm_sust_b_1d_i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_i8_zero, 71410),  // __nvvm_sust_b_1d_i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i16_clamp, 71435),  // __nvvm_sust_b_1d_v2i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i16_trap, 71464),  // __nvvm_sust_b_1d_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i16_zero, 71492),  // __nvvm_sust_b_1d_v2i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i32_clamp, 71520),  // __nvvm_sust_b_1d_v2i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i32_trap, 71549),  // __nvvm_sust_b_1d_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i32_zero, 71577),  // __nvvm_sust_b_1d_v2i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i64_clamp, 71605),  // __nvvm_sust_b_1d_v2i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i64_trap, 71634),  // __nvvm_sust_b_1d_v2i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i64_zero, 71662),  // __nvvm_sust_b_1d_v2i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i8_clamp, 71690),  // __nvvm_sust_b_1d_v2i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i8_trap, 71718),  // __nvvm_sust_b_1d_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_v2i8_zero, 71745),  // __nvvm_sust_b_1d_v2i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i16_clamp, 71772),  // __nvvm_sust_b_1d_v4i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i16_trap, 71801),  // __nvvm_sust_b_1d_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i16_zero, 71829),  // __nvvm_sust_b_1d_v4i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i32_clamp, 71857),  // __nvvm_sust_b_1d_v4i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i32_trap, 71886),  // __nvvm_sust_b_1d_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i32_zero, 71914),  // __nvvm_sust_b_1d_v4i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i8_clamp, 71942),  // __nvvm_sust_b_1d_v4i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i8_trap, 71970),  // __nvvm_sust_b_1d_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_1d_v4i8_zero, 71997),  // __nvvm_sust_b_1d_v4i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i16_clamp, 72024),  // __nvvm_sust_b_2d_array_i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i16_trap, 72057),  // __nvvm_sust_b_2d_array_i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i16_zero, 72089),  // __nvvm_sust_b_2d_array_i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i32_clamp, 72121),  // __nvvm_sust_b_2d_array_i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i32_trap, 72154),  // __nvvm_sust_b_2d_array_i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i32_zero, 72186),  // __nvvm_sust_b_2d_array_i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i64_clamp, 72218),  // __nvvm_sust_b_2d_array_i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i64_trap, 72251),  // __nvvm_sust_b_2d_array_i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i64_zero, 72283),  // __nvvm_sust_b_2d_array_i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i8_clamp, 72315),  // __nvvm_sust_b_2d_array_i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i8_trap, 72347),  // __nvvm_sust_b_2d_array_i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_i8_zero, 72378),  // __nvvm_sust_b_2d_array_i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i16_clamp, 72409),  // __nvvm_sust_b_2d_array_v2i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i16_trap, 72444),  // __nvvm_sust_b_2d_array_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i16_zero, 72478),  // __nvvm_sust_b_2d_array_v2i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i32_clamp, 72512),  // __nvvm_sust_b_2d_array_v2i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i32_trap, 72547),  // __nvvm_sust_b_2d_array_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i32_zero, 72581),  // __nvvm_sust_b_2d_array_v2i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i64_clamp, 72615),  // __nvvm_sust_b_2d_array_v2i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i64_trap, 72650),  // __nvvm_sust_b_2d_array_v2i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i64_zero, 72684),  // __nvvm_sust_b_2d_array_v2i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i8_clamp, 72718),  // __nvvm_sust_b_2d_array_v2i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i8_trap, 72752),  // __nvvm_sust_b_2d_array_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v2i8_zero, 72785),  // __nvvm_sust_b_2d_array_v2i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i16_clamp, 72818),  // __nvvm_sust_b_2d_array_v4i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i16_trap, 72853),  // __nvvm_sust_b_2d_array_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i16_zero, 72887),  // __nvvm_sust_b_2d_array_v4i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i32_clamp, 72921),  // __nvvm_sust_b_2d_array_v4i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i32_trap, 72956),  // __nvvm_sust_b_2d_array_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i32_zero, 72990),  // __nvvm_sust_b_2d_array_v4i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i8_clamp, 73024),  // __nvvm_sust_b_2d_array_v4i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i8_trap, 73058),  // __nvvm_sust_b_2d_array_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_array_v4i8_zero, 73091),  // __nvvm_sust_b_2d_array_v4i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_i16_clamp, 73124),  // __nvvm_sust_b_2d_i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_i16_trap, 73151),  // __nvvm_sust_b_2d_i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_i16_zero, 73177),  // __nvvm_sust_b_2d_i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_i32_clamp, 73203),  // __nvvm_sust_b_2d_i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_i32_trap, 73230),  // __nvvm_sust_b_2d_i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_i32_zero, 73256),  // __nvvm_sust_b_2d_i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_i64_clamp, 73282),  // __nvvm_sust_b_2d_i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_i64_trap, 73309),  // __nvvm_sust_b_2d_i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_i64_zero, 73335),  // __nvvm_sust_b_2d_i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_i8_clamp, 73361),  // __nvvm_sust_b_2d_i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_i8_trap, 73387),  // __nvvm_sust_b_2d_i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_i8_zero, 73412),  // __nvvm_sust_b_2d_i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i16_clamp, 73437),  // __nvvm_sust_b_2d_v2i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i16_trap, 73466),  // __nvvm_sust_b_2d_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i16_zero, 73494),  // __nvvm_sust_b_2d_v2i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i32_clamp, 73522),  // __nvvm_sust_b_2d_v2i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i32_trap, 73551),  // __nvvm_sust_b_2d_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i32_zero, 73579),  // __nvvm_sust_b_2d_v2i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i64_clamp, 73607),  // __nvvm_sust_b_2d_v2i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i64_trap, 73636),  // __nvvm_sust_b_2d_v2i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i64_zero, 73664),  // __nvvm_sust_b_2d_v2i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i8_clamp, 73692),  // __nvvm_sust_b_2d_v2i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i8_trap, 73720),  // __nvvm_sust_b_2d_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_v2i8_zero, 73747),  // __nvvm_sust_b_2d_v2i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i16_clamp, 73774),  // __nvvm_sust_b_2d_v4i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i16_trap, 73803),  // __nvvm_sust_b_2d_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i16_zero, 73831),  // __nvvm_sust_b_2d_v4i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i32_clamp, 73859),  // __nvvm_sust_b_2d_v4i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i32_trap, 73888),  // __nvvm_sust_b_2d_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i32_zero, 73916),  // __nvvm_sust_b_2d_v4i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i8_clamp, 73944),  // __nvvm_sust_b_2d_v4i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i8_trap, 73972),  // __nvvm_sust_b_2d_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_2d_v4i8_zero, 73999),  // __nvvm_sust_b_2d_v4i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_i16_clamp, 74026),  // __nvvm_sust_b_3d_i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_i16_trap, 74053),  // __nvvm_sust_b_3d_i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_i16_zero, 74079),  // __nvvm_sust_b_3d_i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_i32_clamp, 74105),  // __nvvm_sust_b_3d_i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_i32_trap, 74132),  // __nvvm_sust_b_3d_i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_i32_zero, 74158),  // __nvvm_sust_b_3d_i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_i64_clamp, 74184),  // __nvvm_sust_b_3d_i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_i64_trap, 74211),  // __nvvm_sust_b_3d_i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_i64_zero, 74237),  // __nvvm_sust_b_3d_i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_i8_clamp, 74263),  // __nvvm_sust_b_3d_i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_i8_trap, 74289),  // __nvvm_sust_b_3d_i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_i8_zero, 74314),  // __nvvm_sust_b_3d_i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i16_clamp, 74339),  // __nvvm_sust_b_3d_v2i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i16_trap, 74368),  // __nvvm_sust_b_3d_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i16_zero, 74396),  // __nvvm_sust_b_3d_v2i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i32_clamp, 74424),  // __nvvm_sust_b_3d_v2i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i32_trap, 74453),  // __nvvm_sust_b_3d_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i32_zero, 74481),  // __nvvm_sust_b_3d_v2i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i64_clamp, 74509),  // __nvvm_sust_b_3d_v2i64_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i64_trap, 74538),  // __nvvm_sust_b_3d_v2i64_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i64_zero, 74566),  // __nvvm_sust_b_3d_v2i64_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i8_clamp, 74594),  // __nvvm_sust_b_3d_v2i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i8_trap, 74622),  // __nvvm_sust_b_3d_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_v2i8_zero, 74649),  // __nvvm_sust_b_3d_v2i8_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i16_clamp, 74676),  // __nvvm_sust_b_3d_v4i16_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i16_trap, 74705),  // __nvvm_sust_b_3d_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i16_zero, 74733),  // __nvvm_sust_b_3d_v4i16_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i32_clamp, 74761),  // __nvvm_sust_b_3d_v4i32_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i32_trap, 74790),  // __nvvm_sust_b_3d_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i32_zero, 74818),  // __nvvm_sust_b_3d_v4i32_zero
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i8_clamp, 74846),  // __nvvm_sust_b_3d_v4i8_clamp
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i8_trap, 74874),  // __nvvm_sust_b_3d_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_b_3d_v4i8_zero, 74901),  // __nvvm_sust_b_3d_v4i8_zero
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_i16_trap, 74928),  // __nvvm_sust_p_1d_array_i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_i32_trap, 74960),  // __nvvm_sust_p_1d_array_i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_i8_trap, 74992),  // __nvvm_sust_p_1d_array_i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_v2i16_trap, 75023),  // __nvvm_sust_p_1d_array_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_v2i32_trap, 75057),  // __nvvm_sust_p_1d_array_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_v2i8_trap, 75091),  // __nvvm_sust_p_1d_array_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_v4i16_trap, 75124),  // __nvvm_sust_p_1d_array_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_v4i32_trap, 75158),  // __nvvm_sust_p_1d_array_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_array_v4i8_trap, 75192),  // __nvvm_sust_p_1d_array_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_i16_trap, 75225),  // __nvvm_sust_p_1d_i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_i32_trap, 75251),  // __nvvm_sust_p_1d_i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_i8_trap, 75277),  // __nvvm_sust_p_1d_i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_v2i16_trap, 75302),  // __nvvm_sust_p_1d_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_v2i32_trap, 75330),  // __nvvm_sust_p_1d_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_v2i8_trap, 75358),  // __nvvm_sust_p_1d_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_v4i16_trap, 75385),  // __nvvm_sust_p_1d_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_v4i32_trap, 75413),  // __nvvm_sust_p_1d_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_1d_v4i8_trap, 75441),  // __nvvm_sust_p_1d_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_i16_trap, 75468),  // __nvvm_sust_p_2d_array_i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_i32_trap, 75500),  // __nvvm_sust_p_2d_array_i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_i8_trap, 75532),  // __nvvm_sust_p_2d_array_i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_v2i16_trap, 75563),  // __nvvm_sust_p_2d_array_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_v2i32_trap, 75597),  // __nvvm_sust_p_2d_array_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_v2i8_trap, 75631),  // __nvvm_sust_p_2d_array_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_v4i16_trap, 75664),  // __nvvm_sust_p_2d_array_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_v4i32_trap, 75698),  // __nvvm_sust_p_2d_array_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_array_v4i8_trap, 75732),  // __nvvm_sust_p_2d_array_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_i16_trap, 75765),  // __nvvm_sust_p_2d_i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_i32_trap, 75791),  // __nvvm_sust_p_2d_i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_i8_trap, 75817),  // __nvvm_sust_p_2d_i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_v2i16_trap, 75842),  // __nvvm_sust_p_2d_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_v2i32_trap, 75870),  // __nvvm_sust_p_2d_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_v2i8_trap, 75898),  // __nvvm_sust_p_2d_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_v4i16_trap, 75925),  // __nvvm_sust_p_2d_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_v4i32_trap, 75953),  // __nvvm_sust_p_2d_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_2d_v4i8_trap, 75981),  // __nvvm_sust_p_2d_v4i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_i16_trap, 76008),  // __nvvm_sust_p_3d_i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_i32_trap, 76034),  // __nvvm_sust_p_3d_i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_i8_trap, 76060),  // __nvvm_sust_p_3d_i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_v2i16_trap, 76085),  // __nvvm_sust_p_3d_v2i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_v2i32_trap, 76113),  // __nvvm_sust_p_3d_v2i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_v2i8_trap, 76141),  // __nvvm_sust_p_3d_v2i8_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_v4i16_trap, 76168),  // __nvvm_sust_p_3d_v4i16_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_v4i32_trap, 76196),  // __nvvm_sust_p_3d_v4i32_trap
    new BuiltinEntry(ID.nvvm_sust_p_3d_v4i8_trap, 76224),  // __nvvm_sust_p_3d_v4i8_trap
    new BuiltinEntry(ID.nvvm_swap_lo_hi_b64, 76251),  // __nvvm_swap_lo_hi_b64
    new BuiltinEntry(ID.nvvm_trunc_d, 76273),  // __nvvm_trunc_d
    new BuiltinEntry(ID.nvvm_trunc_f, 76288),  // __nvvm_trunc_f
    new BuiltinEntry(ID.nvvm_trunc_ftz_f, 76303),  // __nvvm_trunc_ftz_f
    new BuiltinEntry(ID.nvvm_txq_array_size, 76322),  // __nvvm_txq_array_size
    new BuiltinEntry(ID.nvvm_txq_channel_data_type, 76344),  // __nvvm_txq_channel_data_type
    new BuiltinEntry(ID.nvvm_txq_channel_order, 76373),  // __nvvm_txq_channel_order
    new BuiltinEntry(ID.nvvm_txq_depth, 76398),  // __nvvm_txq_depth
    new BuiltinEntry(ID.nvvm_txq_height, 76415),  // __nvvm_txq_height
    new BuiltinEntry(ID.nvvm_txq_num_mipmap_levels, 76433),  // __nvvm_txq_num_mipmap_levels
    new BuiltinEntry(ID.nvvm_txq_num_samples, 76462),  // __nvvm_txq_num_samples
    new BuiltinEntry(ID.nvvm_txq_width, 76485),  // __nvvm_txq_width
    new BuiltinEntry(ID.nvvm_ui2d_rm, 76502),  // __nvvm_ui2d_rm
    new BuiltinEntry(ID.nvvm_ui2d_rn, 76517),  // __nvvm_ui2d_rn
    new BuiltinEntry(ID.nvvm_ui2d_rp, 76532),  // __nvvm_ui2d_rp
    new BuiltinEntry(ID.nvvm_ui2d_rz, 76547),  // __nvvm_ui2d_rz
    new BuiltinEntry(ID.nvvm_ui2f_rm, 76562),  // __nvvm_ui2f_rm
    new BuiltinEntry(ID.nvvm_ui2f_rn, 76577),  // __nvvm_ui2f_rn
    new BuiltinEntry(ID.nvvm_ui2f_rp, 76592),  // __nvvm_ui2f_rp
    new BuiltinEntry(ID.nvvm_ui2f_rz, 76607),  // __nvvm_ui2f_rz
    new BuiltinEntry(ID.nvvm_ull2d_rm, 76622),  // __nvvm_ull2d_rm
    new BuiltinEntry(ID.nvvm_ull2d_rn, 76638),  // __nvvm_ull2d_rn
    new BuiltinEntry(ID.nvvm_ull2d_rp, 76654),  // __nvvm_ull2d_rp
    new BuiltinEntry(ID.nvvm_ull2d_rz, 76670),  // __nvvm_ull2d_rz
    new BuiltinEntry(ID.nvvm_ull2f_rm, 76686),  // __nvvm_ull2f_rm
    new BuiltinEntry(ID.nvvm_ull2f_rn, 76702),  // __nvvm_ull2f_rn
    new BuiltinEntry(ID.nvvm_ull2f_rp, 76718),  // __nvvm_ull2f_rp
    new BuiltinEntry(ID.nvvm_ull2f_rz, 76734),  // __nvvm_ull2f_rz
    new BuiltinEntry(ID.nvvm_barrier0, 64030) // __syncthreads
  };
  static final/*static*/ /*const*/ BuiltinEntry ppcNames[/*311*/] = new /*const*/ BuiltinEntry [/*311*/] {
    new BuiltinEntry(ID.ppc_altivec_crypto_vcipher, 76750),  // __builtin_altivec_crypto_vcipher
    new BuiltinEntry(ID.ppc_altivec_crypto_vcipherlast, 76783),  // __builtin_altivec_crypto_vcipherlast
    new BuiltinEntry(ID.ppc_altivec_crypto_vncipher, 76820),  // __builtin_altivec_crypto_vncipher
    new BuiltinEntry(ID.ppc_altivec_crypto_vncipherlast, 76854),  // __builtin_altivec_crypto_vncipherlast
    new BuiltinEntry(ID.ppc_altivec_crypto_vpermxor, 76892),  // __builtin_altivec_crypto_vpermxor
    new BuiltinEntry(ID.ppc_altivec_crypto_vpmsumb, 76926),  // __builtin_altivec_crypto_vpmsumb
    new BuiltinEntry(ID.ppc_altivec_crypto_vpmsumd, 76959),  // __builtin_altivec_crypto_vpmsumd
    new BuiltinEntry(ID.ppc_altivec_crypto_vpmsumh, 76992),  // __builtin_altivec_crypto_vpmsumh
    new BuiltinEntry(ID.ppc_altivec_crypto_vpmsumw, 77025),  // __builtin_altivec_crypto_vpmsumw
    new BuiltinEntry(ID.ppc_altivec_crypto_vsbox, 77058),  // __builtin_altivec_crypto_vsbox
    new BuiltinEntry(ID.ppc_altivec_crypto_vshasigmad, 77089),  // __builtin_altivec_crypto_vshasigmad
    new BuiltinEntry(ID.ppc_altivec_crypto_vshasigmaw, 77125),  // __builtin_altivec_crypto_vshasigmaw
    new BuiltinEntry(ID.ppc_altivec_dss, 77161),  // __builtin_altivec_dss
    new BuiltinEntry(ID.ppc_altivec_dssall, 77183),  // __builtin_altivec_dssall
    new BuiltinEntry(ID.ppc_altivec_dst, 77208),  // __builtin_altivec_dst
    new BuiltinEntry(ID.ppc_altivec_dstst, 77230),  // __builtin_altivec_dstst
    new BuiltinEntry(ID.ppc_altivec_dststt, 77254),  // __builtin_altivec_dststt
    new BuiltinEntry(ID.ppc_altivec_dstt, 77279),  // __builtin_altivec_dstt
    new BuiltinEntry(ID.ppc_altivec_mfvscr, 77302),  // __builtin_altivec_mfvscr
    new BuiltinEntry(ID.ppc_altivec_mtvscr, 77327),  // __builtin_altivec_mtvscr
    new BuiltinEntry(ID.ppc_altivec_vaddcuq, 77352),  // __builtin_altivec_vaddcuq
    new BuiltinEntry(ID.ppc_altivec_vaddcuw, 77378),  // __builtin_altivec_vaddcuw
    new BuiltinEntry(ID.ppc_altivec_vaddecuq, 77404),  // __builtin_altivec_vaddecuq
    new BuiltinEntry(ID.ppc_altivec_vaddeuqm, 77431),  // __builtin_altivec_vaddeuqm
    new BuiltinEntry(ID.ppc_altivec_vaddsbs, 77458),  // __builtin_altivec_vaddsbs
    new BuiltinEntry(ID.ppc_altivec_vaddshs, 77484),  // __builtin_altivec_vaddshs
    new BuiltinEntry(ID.ppc_altivec_vaddsws, 77510),  // __builtin_altivec_vaddsws
    new BuiltinEntry(ID.ppc_altivec_vaddubs, 77536),  // __builtin_altivec_vaddubs
    new BuiltinEntry(ID.ppc_altivec_vadduhs, 77562),  // __builtin_altivec_vadduhs
    new BuiltinEntry(ID.ppc_altivec_vadduws, 77588),  // __builtin_altivec_vadduws
    new BuiltinEntry(ID.ppc_altivec_vavgsb, 77614),  // __builtin_altivec_vavgsb
    new BuiltinEntry(ID.ppc_altivec_vavgsh, 77639),  // __builtin_altivec_vavgsh
    new BuiltinEntry(ID.ppc_altivec_vavgsw, 77664),  // __builtin_altivec_vavgsw
    new BuiltinEntry(ID.ppc_altivec_vavgub, 77689),  // __builtin_altivec_vavgub
    new BuiltinEntry(ID.ppc_altivec_vavguh, 77714),  // __builtin_altivec_vavguh
    new BuiltinEntry(ID.ppc_altivec_vavguw, 77739),  // __builtin_altivec_vavguw
    new BuiltinEntry(ID.ppc_altivec_vbpermq, 77764),  // __builtin_altivec_vbpermq
    new BuiltinEntry(ID.ppc_altivec_vcfsx, 77790),  // __builtin_altivec_vcfsx
    new BuiltinEntry(ID.ppc_altivec_vcfux, 77814),  // __builtin_altivec_vcfux
    new BuiltinEntry(ID.ppc_altivec_vcmpbfp, 77838),  // __builtin_altivec_vcmpbfp
    new BuiltinEntry(ID.ppc_altivec_vcmpbfp_p, 77864),  // __builtin_altivec_vcmpbfp_p
    new BuiltinEntry(ID.ppc_altivec_vcmpeqfp, 77892),  // __builtin_altivec_vcmpeqfp
    new BuiltinEntry(ID.ppc_altivec_vcmpeqfp_p, 77919),  // __builtin_altivec_vcmpeqfp_p
    new BuiltinEntry(ID.ppc_altivec_vcmpequb, 77948),  // __builtin_altivec_vcmpequb
    new BuiltinEntry(ID.ppc_altivec_vcmpequb_p, 77975),  // __builtin_altivec_vcmpequb_p
    new BuiltinEntry(ID.ppc_altivec_vcmpequd, 78004),  // __builtin_altivec_vcmpequd
    new BuiltinEntry(ID.ppc_altivec_vcmpequd_p, 78031),  // __builtin_altivec_vcmpequd_p
    new BuiltinEntry(ID.ppc_altivec_vcmpequh, 78060),  // __builtin_altivec_vcmpequh
    new BuiltinEntry(ID.ppc_altivec_vcmpequh_p, 78087),  // __builtin_altivec_vcmpequh_p
    new BuiltinEntry(ID.ppc_altivec_vcmpequw, 78116),  // __builtin_altivec_vcmpequw
    new BuiltinEntry(ID.ppc_altivec_vcmpequw_p, 78143),  // __builtin_altivec_vcmpequw_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgefp, 78172),  // __builtin_altivec_vcmpgefp
    new BuiltinEntry(ID.ppc_altivec_vcmpgefp_p, 78199),  // __builtin_altivec_vcmpgefp_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtfp, 78228),  // __builtin_altivec_vcmpgtfp
    new BuiltinEntry(ID.ppc_altivec_vcmpgtfp_p, 78255),  // __builtin_altivec_vcmpgtfp_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtsb, 78284),  // __builtin_altivec_vcmpgtsb
    new BuiltinEntry(ID.ppc_altivec_vcmpgtsb_p, 78311),  // __builtin_altivec_vcmpgtsb_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtsd, 78340),  // __builtin_altivec_vcmpgtsd
    new BuiltinEntry(ID.ppc_altivec_vcmpgtsd_p, 78367),  // __builtin_altivec_vcmpgtsd_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtsh, 78396),  // __builtin_altivec_vcmpgtsh
    new BuiltinEntry(ID.ppc_altivec_vcmpgtsh_p, 78423),  // __builtin_altivec_vcmpgtsh_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtsw, 78452),  // __builtin_altivec_vcmpgtsw
    new BuiltinEntry(ID.ppc_altivec_vcmpgtsw_p, 78479),  // __builtin_altivec_vcmpgtsw_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtub, 78508),  // __builtin_altivec_vcmpgtub
    new BuiltinEntry(ID.ppc_altivec_vcmpgtub_p, 78535),  // __builtin_altivec_vcmpgtub_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtud, 78564),  // __builtin_altivec_vcmpgtud
    new BuiltinEntry(ID.ppc_altivec_vcmpgtud_p, 78591),  // __builtin_altivec_vcmpgtud_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtuh, 78620),  // __builtin_altivec_vcmpgtuh
    new BuiltinEntry(ID.ppc_altivec_vcmpgtuh_p, 78647),  // __builtin_altivec_vcmpgtuh_p
    new BuiltinEntry(ID.ppc_altivec_vcmpgtuw, 78676),  // __builtin_altivec_vcmpgtuw
    new BuiltinEntry(ID.ppc_altivec_vcmpgtuw_p, 78703),  // __builtin_altivec_vcmpgtuw_p
    new BuiltinEntry(ID.ppc_altivec_vctsxs, 78732),  // __builtin_altivec_vctsxs
    new BuiltinEntry(ID.ppc_altivec_vctuxs, 78757),  // __builtin_altivec_vctuxs
    new BuiltinEntry(ID.ppc_altivec_vexptefp, 78782),  // __builtin_altivec_vexptefp
    new BuiltinEntry(ID.ppc_altivec_vgbbd, 78809),  // __builtin_altivec_vgbbd
    new BuiltinEntry(ID.ppc_altivec_vlogefp, 78833),  // __builtin_altivec_vlogefp
    new BuiltinEntry(ID.ppc_altivec_vmaddfp, 78859),  // __builtin_altivec_vmaddfp
    new BuiltinEntry(ID.ppc_altivec_vmaxfp, 78885),  // __builtin_altivec_vmaxfp
    new BuiltinEntry(ID.ppc_altivec_vmaxsb, 78910),  // __builtin_altivec_vmaxsb
    new BuiltinEntry(ID.ppc_altivec_vmaxsd, 78935),  // __builtin_altivec_vmaxsd
    new BuiltinEntry(ID.ppc_altivec_vmaxsh, 78960),  // __builtin_altivec_vmaxsh
    new BuiltinEntry(ID.ppc_altivec_vmaxsw, 78985),  // __builtin_altivec_vmaxsw
    new BuiltinEntry(ID.ppc_altivec_vmaxub, 79010),  // __builtin_altivec_vmaxub
    new BuiltinEntry(ID.ppc_altivec_vmaxud, 79035),  // __builtin_altivec_vmaxud
    new BuiltinEntry(ID.ppc_altivec_vmaxuh, 79060),  // __builtin_altivec_vmaxuh
    new BuiltinEntry(ID.ppc_altivec_vmaxuw, 79085),  // __builtin_altivec_vmaxuw
    new BuiltinEntry(ID.ppc_altivec_vmhaddshs, 79110),  // __builtin_altivec_vmhaddshs
    new BuiltinEntry(ID.ppc_altivec_vmhraddshs, 79138),  // __builtin_altivec_vmhraddshs
    new BuiltinEntry(ID.ppc_altivec_vminfp, 79167),  // __builtin_altivec_vminfp
    new BuiltinEntry(ID.ppc_altivec_vminsb, 79192),  // __builtin_altivec_vminsb
    new BuiltinEntry(ID.ppc_altivec_vminsd, 79217),  // __builtin_altivec_vminsd
    new BuiltinEntry(ID.ppc_altivec_vminsh, 79242),  // __builtin_altivec_vminsh
    new BuiltinEntry(ID.ppc_altivec_vminsw, 79267),  // __builtin_altivec_vminsw
    new BuiltinEntry(ID.ppc_altivec_vminub, 79292),  // __builtin_altivec_vminub
    new BuiltinEntry(ID.ppc_altivec_vminud, 79317),  // __builtin_altivec_vminud
    new BuiltinEntry(ID.ppc_altivec_vminuh, 79342),  // __builtin_altivec_vminuh
    new BuiltinEntry(ID.ppc_altivec_vminuw, 79367),  // __builtin_altivec_vminuw
    new BuiltinEntry(ID.ppc_altivec_vmladduhm, 79392),  // __builtin_altivec_vmladduhm
    new BuiltinEntry(ID.ppc_altivec_vmsummbm, 79420),  // __builtin_altivec_vmsummbm
    new BuiltinEntry(ID.ppc_altivec_vmsumshm, 79447),  // __builtin_altivec_vmsumshm
    new BuiltinEntry(ID.ppc_altivec_vmsumshs, 79474),  // __builtin_altivec_vmsumshs
    new BuiltinEntry(ID.ppc_altivec_vmsumubm, 79501),  // __builtin_altivec_vmsumubm
    new BuiltinEntry(ID.ppc_altivec_vmsumuhm, 79528),  // __builtin_altivec_vmsumuhm
    new BuiltinEntry(ID.ppc_altivec_vmsumuhs, 79555),  // __builtin_altivec_vmsumuhs
    new BuiltinEntry(ID.ppc_altivec_vmulesb, 79582),  // __builtin_altivec_vmulesb
    new BuiltinEntry(ID.ppc_altivec_vmulesh, 79608),  // __builtin_altivec_vmulesh
    new BuiltinEntry(ID.ppc_altivec_vmulesw, 79634),  // __builtin_altivec_vmulesw
    new BuiltinEntry(ID.ppc_altivec_vmuleub, 79660),  // __builtin_altivec_vmuleub
    new BuiltinEntry(ID.ppc_altivec_vmuleuh, 79686),  // __builtin_altivec_vmuleuh
    new BuiltinEntry(ID.ppc_altivec_vmuleuw, 79712),  // __builtin_altivec_vmuleuw
    new BuiltinEntry(ID.ppc_altivec_vmulosb, 79738),  // __builtin_altivec_vmulosb
    new BuiltinEntry(ID.ppc_altivec_vmulosh, 79764),  // __builtin_altivec_vmulosh
    new BuiltinEntry(ID.ppc_altivec_vmulosw, 79790),  // __builtin_altivec_vmulosw
    new BuiltinEntry(ID.ppc_altivec_vmuloub, 79816),  // __builtin_altivec_vmuloub
    new BuiltinEntry(ID.ppc_altivec_vmulouh, 79842),  // __builtin_altivec_vmulouh
    new BuiltinEntry(ID.ppc_altivec_vmulouw, 79868),  // __builtin_altivec_vmulouw
    new BuiltinEntry(ID.ppc_altivec_vnmsubfp, 79894),  // __builtin_altivec_vnmsubfp
    new BuiltinEntry(ID.ppc_altivec_vperm, 79921),  // __builtin_altivec_vperm_4si
    new BuiltinEntry(ID.ppc_altivec_vpkpx, 79949),  // __builtin_altivec_vpkpx
    new BuiltinEntry(ID.ppc_altivec_vpksdss, 79973),  // __builtin_altivec_vpksdss
    new BuiltinEntry(ID.ppc_altivec_vpksdus, 79999),  // __builtin_altivec_vpksdus
    new BuiltinEntry(ID.ppc_altivec_vpkshss, 80025),  // __builtin_altivec_vpkshss
    new BuiltinEntry(ID.ppc_altivec_vpkshus, 80051),  // __builtin_altivec_vpkshus
    new BuiltinEntry(ID.ppc_altivec_vpkswss, 80077),  // __builtin_altivec_vpkswss
    new BuiltinEntry(ID.ppc_altivec_vpkswus, 80103),  // __builtin_altivec_vpkswus
    new BuiltinEntry(ID.ppc_altivec_vpkudus, 80129),  // __builtin_altivec_vpkudus
    new BuiltinEntry(ID.ppc_altivec_vpkuhus, 80155),  // __builtin_altivec_vpkuhus
    new BuiltinEntry(ID.ppc_altivec_vpkuwus, 80181),  // __builtin_altivec_vpkuwus
    new BuiltinEntry(ID.ppc_altivec_vrefp, 80207),  // __builtin_altivec_vrefp
    new BuiltinEntry(ID.ppc_altivec_vrfim, 80231),  // __builtin_altivec_vrfim
    new BuiltinEntry(ID.ppc_altivec_vrfin, 80255),  // __builtin_altivec_vrfin
    new BuiltinEntry(ID.ppc_altivec_vrfip, 80279),  // __builtin_altivec_vrfip
    new BuiltinEntry(ID.ppc_altivec_vrfiz, 80303),  // __builtin_altivec_vrfiz
    new BuiltinEntry(ID.ppc_altivec_vrlb, 80327),  // __builtin_altivec_vrlb
    new BuiltinEntry(ID.ppc_altivec_vrld, 80350),  // __builtin_altivec_vrld
    new BuiltinEntry(ID.ppc_altivec_vrlh, 80373),  // __builtin_altivec_vrlh
    new BuiltinEntry(ID.ppc_altivec_vrlw, 80396),  // __builtin_altivec_vrlw
    new BuiltinEntry(ID.ppc_altivec_vrsqrtefp, 80419),  // __builtin_altivec_vrsqrtefp
    new BuiltinEntry(ID.ppc_altivec_vsel, 80447),  // __builtin_altivec_vsel_4si
    new BuiltinEntry(ID.ppc_altivec_vsl, 80474),  // __builtin_altivec_vsl
    new BuiltinEntry(ID.ppc_altivec_vslb, 80496),  // __builtin_altivec_vslb
    new BuiltinEntry(ID.ppc_altivec_vslh, 80519),  // __builtin_altivec_vslh
    new BuiltinEntry(ID.ppc_altivec_vslo, 80542),  // __builtin_altivec_vslo
    new BuiltinEntry(ID.ppc_altivec_vslw, 80565),  // __builtin_altivec_vslw
    new BuiltinEntry(ID.ppc_altivec_vsr, 80588),  // __builtin_altivec_vsr
    new BuiltinEntry(ID.ppc_altivec_vsrab, 80610),  // __builtin_altivec_vsrab
    new BuiltinEntry(ID.ppc_altivec_vsrah, 80634),  // __builtin_altivec_vsrah
    new BuiltinEntry(ID.ppc_altivec_vsraw, 80658),  // __builtin_altivec_vsraw
    new BuiltinEntry(ID.ppc_altivec_vsrb, 80682),  // __builtin_altivec_vsrb
    new BuiltinEntry(ID.ppc_altivec_vsrh, 80705),  // __builtin_altivec_vsrh
    new BuiltinEntry(ID.ppc_altivec_vsro, 80728),  // __builtin_altivec_vsro
    new BuiltinEntry(ID.ppc_altivec_vsrw, 80751),  // __builtin_altivec_vsrw
    new BuiltinEntry(ID.ppc_altivec_vsubcuq, 80774),  // __builtin_altivec_vsubcuq
    new BuiltinEntry(ID.ppc_altivec_vsubcuw, 80800),  // __builtin_altivec_vsubcuw
    new BuiltinEntry(ID.ppc_altivec_vsubecuq, 80826),  // __builtin_altivec_vsubecuq
    new BuiltinEntry(ID.ppc_altivec_vsubeuqm, 80853),  // __builtin_altivec_vsubeuqm
    new BuiltinEntry(ID.ppc_altivec_vsubsbs, 80880),  // __builtin_altivec_vsubsbs
    new BuiltinEntry(ID.ppc_altivec_vsubshs, 80906),  // __builtin_altivec_vsubshs
    new BuiltinEntry(ID.ppc_altivec_vsubsws, 80932),  // __builtin_altivec_vsubsws
    new BuiltinEntry(ID.ppc_altivec_vsububs, 80958),  // __builtin_altivec_vsububs
    new BuiltinEntry(ID.ppc_altivec_vsubuhs, 80984),  // __builtin_altivec_vsubuhs
    new BuiltinEntry(ID.ppc_altivec_vsubuws, 81010),  // __builtin_altivec_vsubuws
    new BuiltinEntry(ID.ppc_altivec_vsum2sws, 81036),  // __builtin_altivec_vsum2sws
    new BuiltinEntry(ID.ppc_altivec_vsum4sbs, 81063),  // __builtin_altivec_vsum4sbs
    new BuiltinEntry(ID.ppc_altivec_vsum4shs, 81090),  // __builtin_altivec_vsum4shs
    new BuiltinEntry(ID.ppc_altivec_vsum4ubs, 81117),  // __builtin_altivec_vsum4ubs
    new BuiltinEntry(ID.ppc_altivec_vsumsws, 81144),  // __builtin_altivec_vsumsws
    new BuiltinEntry(ID.ppc_altivec_vupkhpx, 81170),  // __builtin_altivec_vupkhpx
    new BuiltinEntry(ID.ppc_altivec_vupkhsb, 81196),  // __builtin_altivec_vupkhsb
    new BuiltinEntry(ID.ppc_altivec_vupkhsh, 81222),  // __builtin_altivec_vupkhsh
    new BuiltinEntry(ID.ppc_altivec_vupkhsw, 81248),  // __builtin_altivec_vupkhsw
    new BuiltinEntry(ID.ppc_altivec_vupklpx, 81274),  // __builtin_altivec_vupklpx
    new BuiltinEntry(ID.ppc_altivec_vupklsb, 81300),  // __builtin_altivec_vupklsb
    new BuiltinEntry(ID.ppc_altivec_vupklsh, 81326),  // __builtin_altivec_vupklsh
    new BuiltinEntry(ID.ppc_altivec_vupklsw, 81352),  // __builtin_altivec_vupklsw
    new BuiltinEntry(ID.ppc_bpermd, 81378),  // __builtin_bpermd
    new BuiltinEntry(ID.ppc_divde, 81395),  // __builtin_divde
    new BuiltinEntry(ID.ppc_divdeu, 81411),  // __builtin_divdeu
    new BuiltinEntry(ID.ppc_divwe, 81428),  // __builtin_divwe
    new BuiltinEntry(ID.ppc_divweu, 81444),  // __builtin_divweu
    new BuiltinEntry(ID.ppc_get_texasr, 81461),  // __builtin_get_texasr
    new BuiltinEntry(ID.ppc_get_texasru, 81482),  // __builtin_get_texasru
    new BuiltinEntry(ID.ppc_get_tfhar, 81504),  // __builtin_get_tfhar
    new BuiltinEntry(ID.ppc_get_tfiar, 81524),  // __builtin_get_tfiar
    new BuiltinEntry(ID.ppc_qpx_qvfabs, 81544),  // __builtin_qpx_qvfabs
    new BuiltinEntry(ID.ppc_qpx_qvfadd, 81565),  // __builtin_qpx_qvfadd
    new BuiltinEntry(ID.ppc_qpx_qvfadds, 81586),  // __builtin_qpx_qvfadds
    new BuiltinEntry(ID.ppc_qpx_qvfcfid, 81608),  // __builtin_qpx_qvfcfid
    new BuiltinEntry(ID.ppc_qpx_qvfcfids, 81630),  // __builtin_qpx_qvfcfids
    new BuiltinEntry(ID.ppc_qpx_qvfcfidu, 81653),  // __builtin_qpx_qvfcfidu
    new BuiltinEntry(ID.ppc_qpx_qvfcfidus, 81676),  // __builtin_qpx_qvfcfidus
    new BuiltinEntry(ID.ppc_qpx_qvfcmpeq, 81700),  // __builtin_qpx_qvfcmpeq
    new BuiltinEntry(ID.ppc_qpx_qvfcmpgt, 81723),  // __builtin_qpx_qvfcmpgt
    new BuiltinEntry(ID.ppc_qpx_qvfcmplt, 81746),  // __builtin_qpx_qvfcmplt
    new BuiltinEntry(ID.ppc_qpx_qvfcpsgn, 81769),  // __builtin_qpx_qvfcpsgn
    new BuiltinEntry(ID.ppc_qpx_qvfctid, 81792),  // __builtin_qpx_qvfctid
    new BuiltinEntry(ID.ppc_qpx_qvfctidu, 81814),  // __builtin_qpx_qvfctidu
    new BuiltinEntry(ID.ppc_qpx_qvfctiduz, 81837),  // __builtin_qpx_qvfctiduz
    new BuiltinEntry(ID.ppc_qpx_qvfctidz, 81861),  // __builtin_qpx_qvfctidz
    new BuiltinEntry(ID.ppc_qpx_qvfctiw, 81884),  // __builtin_qpx_qvfctiw
    new BuiltinEntry(ID.ppc_qpx_qvfctiwu, 81906),  // __builtin_qpx_qvfctiwu
    new BuiltinEntry(ID.ppc_qpx_qvfctiwuz, 81929),  // __builtin_qpx_qvfctiwuz
    new BuiltinEntry(ID.ppc_qpx_qvfctiwz, 81953),  // __builtin_qpx_qvfctiwz
    new BuiltinEntry(ID.ppc_qpx_qvflogical, 81976),  // __builtin_qpx_qvflogical
    new BuiltinEntry(ID.ppc_qpx_qvfmadd, 82001),  // __builtin_qpx_qvfmadd
    new BuiltinEntry(ID.ppc_qpx_qvfmadds, 82023),  // __builtin_qpx_qvfmadds
    new BuiltinEntry(ID.ppc_qpx_qvfmsub, 82046),  // __builtin_qpx_qvfmsub
    new BuiltinEntry(ID.ppc_qpx_qvfmsubs, 82068),  // __builtin_qpx_qvfmsubs
    new BuiltinEntry(ID.ppc_qpx_qvfmul, 82091),  // __builtin_qpx_qvfmul
    new BuiltinEntry(ID.ppc_qpx_qvfmuls, 82112),  // __builtin_qpx_qvfmuls
    new BuiltinEntry(ID.ppc_qpx_qvfnabs, 82134),  // __builtin_qpx_qvfnabs
    new BuiltinEntry(ID.ppc_qpx_qvfneg, 82156),  // __builtin_qpx_qvfneg
    new BuiltinEntry(ID.ppc_qpx_qvfnmadd, 82177),  // __builtin_qpx_qvfnmadd
    new BuiltinEntry(ID.ppc_qpx_qvfnmadds, 82200),  // __builtin_qpx_qvfnmadds
    new BuiltinEntry(ID.ppc_qpx_qvfnmsub, 82224),  // __builtin_qpx_qvfnmsub
    new BuiltinEntry(ID.ppc_qpx_qvfnmsubs, 82247),  // __builtin_qpx_qvfnmsubs
    new BuiltinEntry(ID.ppc_qpx_qvfperm, 82271),  // __builtin_qpx_qvfperm
    new BuiltinEntry(ID.ppc_qpx_qvfre, 82293),  // __builtin_qpx_qvfre
    new BuiltinEntry(ID.ppc_qpx_qvfres, 82313),  // __builtin_qpx_qvfres
    new BuiltinEntry(ID.ppc_qpx_qvfrim, 82334),  // __builtin_qpx_qvfrim
    new BuiltinEntry(ID.ppc_qpx_qvfrin, 82355),  // __builtin_qpx_qvfrin
    new BuiltinEntry(ID.ppc_qpx_qvfrip, 82376),  // __builtin_qpx_qvfrip
    new BuiltinEntry(ID.ppc_qpx_qvfriz, 82397),  // __builtin_qpx_qvfriz
    new BuiltinEntry(ID.ppc_qpx_qvfrsp, 82418),  // __builtin_qpx_qvfrsp
    new BuiltinEntry(ID.ppc_qpx_qvfrsqrte, 82439),  // __builtin_qpx_qvfrsqrte
    new BuiltinEntry(ID.ppc_qpx_qvfrsqrtes, 82463),  // __builtin_qpx_qvfrsqrtes
    new BuiltinEntry(ID.ppc_qpx_qvfsel, 82488),  // __builtin_qpx_qvfsel
    new BuiltinEntry(ID.ppc_qpx_qvfsub, 82509),  // __builtin_qpx_qvfsub
    new BuiltinEntry(ID.ppc_qpx_qvfsubs, 82530),  // __builtin_qpx_qvfsubs
    new BuiltinEntry(ID.ppc_qpx_qvftstnan, 82552),  // __builtin_qpx_qvftstnan
    new BuiltinEntry(ID.ppc_qpx_qvfxmadd, 82576),  // __builtin_qpx_qvfxmadd
    new BuiltinEntry(ID.ppc_qpx_qvfxmadds, 82599),  // __builtin_qpx_qvfxmadds
    new BuiltinEntry(ID.ppc_qpx_qvfxmul, 82623),  // __builtin_qpx_qvfxmul
    new BuiltinEntry(ID.ppc_qpx_qvfxmuls, 82645),  // __builtin_qpx_qvfxmuls
    new BuiltinEntry(ID.ppc_qpx_qvfxxcpnmadd, 82668),  // __builtin_qpx_qvfxxcpnmadd
    new BuiltinEntry(ID.ppc_qpx_qvfxxcpnmadds, 82695),  // __builtin_qpx_qvfxxcpnmadds
    new BuiltinEntry(ID.ppc_qpx_qvfxxmadd, 82723),  // __builtin_qpx_qvfxxmadd
    new BuiltinEntry(ID.ppc_qpx_qvfxxmadds, 82747),  // __builtin_qpx_qvfxxmadds
    new BuiltinEntry(ID.ppc_qpx_qvfxxnpmadd, 82772),  // __builtin_qpx_qvfxxnpmadd
    new BuiltinEntry(ID.ppc_qpx_qvfxxnpmadds, 82798),  // __builtin_qpx_qvfxxnpmadds
    new BuiltinEntry(ID.ppc_qpx_qvgpci, 82825),  // __builtin_qpx_qvgpci
    new BuiltinEntry(ID.ppc_qpx_qvlfcd, 82846),  // __builtin_qpx_qvlfcd
    new BuiltinEntry(ID.ppc_qpx_qvlfcda, 82867),  // __builtin_qpx_qvlfcda
    new BuiltinEntry(ID.ppc_qpx_qvlfcs, 82889),  // __builtin_qpx_qvlfcs
    new BuiltinEntry(ID.ppc_qpx_qvlfcsa, 82910),  // __builtin_qpx_qvlfcsa
    new BuiltinEntry(ID.ppc_qpx_qvlfd, 82932),  // __builtin_qpx_qvlfd
    new BuiltinEntry(ID.ppc_qpx_qvlfda, 82952),  // __builtin_qpx_qvlfda
    new BuiltinEntry(ID.ppc_qpx_qvlfiwa, 82973),  // __builtin_qpx_qvlfiwa
    new BuiltinEntry(ID.ppc_qpx_qvlfiwaa, 82995),  // __builtin_qpx_qvlfiwaa
    new BuiltinEntry(ID.ppc_qpx_qvlfiwz, 83018),  // __builtin_qpx_qvlfiwz
    new BuiltinEntry(ID.ppc_qpx_qvlfiwza, 83040),  // __builtin_qpx_qvlfiwza
    new BuiltinEntry(ID.ppc_qpx_qvlfs, 83063),  // __builtin_qpx_qvlfs
    new BuiltinEntry(ID.ppc_qpx_qvlfsa, 83083),  // __builtin_qpx_qvlfsa
    new BuiltinEntry(ID.ppc_qpx_qvlpcld, 83104),  // __builtin_qpx_qvlpcld
    new BuiltinEntry(ID.ppc_qpx_qvlpcls, 83126),  // __builtin_qpx_qvlpcls
    new BuiltinEntry(ID.ppc_qpx_qvlpcrd, 83148),  // __builtin_qpx_qvlpcrd
    new BuiltinEntry(ID.ppc_qpx_qvlpcrs, 83170),  // __builtin_qpx_qvlpcrs
    new BuiltinEntry(ID.ppc_qpx_qvstfcd, 83192),  // __builtin_qpx_qvstfcd
    new BuiltinEntry(ID.ppc_qpx_qvstfcda, 83214),  // __builtin_qpx_qvstfcda
    new BuiltinEntry(ID.ppc_qpx_qvstfcs, 83237),  // __builtin_qpx_qvstfcs
    new BuiltinEntry(ID.ppc_qpx_qvstfcsa, 83259),  // __builtin_qpx_qvstfcsa
    new BuiltinEntry(ID.ppc_qpx_qvstfd, 83282),  // __builtin_qpx_qvstfd
    new BuiltinEntry(ID.ppc_qpx_qvstfda, 83303),  // __builtin_qpx_qvstfda
    new BuiltinEntry(ID.ppc_qpx_qvstfiw, 83325),  // __builtin_qpx_qvstfiw
    new BuiltinEntry(ID.ppc_qpx_qvstfiwa, 83347),  // __builtin_qpx_qvstfiwa
    new BuiltinEntry(ID.ppc_qpx_qvstfs, 83370),  // __builtin_qpx_qvstfs
    new BuiltinEntry(ID.ppc_qpx_qvstfsa, 83391),  // __builtin_qpx_qvstfsa
    new BuiltinEntry(ID.ppc_set_texasr, 83413),  // __builtin_set_texasr
    new BuiltinEntry(ID.ppc_set_texasru, 83434),  // __builtin_set_texasru
    new BuiltinEntry(ID.ppc_set_tfhar, 83456),  // __builtin_set_tfhar
    new BuiltinEntry(ID.ppc_set_tfiar, 83476),  // __builtin_set_tfiar
    new BuiltinEntry(ID.ppc_tabort, 83496),  // __builtin_tabort
    new BuiltinEntry(ID.ppc_tabortdc, 83513),  // __builtin_tabortdc
    new BuiltinEntry(ID.ppc_tabortdci, 83532),  // __builtin_tabortdci
    new BuiltinEntry(ID.ppc_tabortwc, 83552),  // __builtin_tabortwc
    new BuiltinEntry(ID.ppc_tabortwci, 83571),  // __builtin_tabortwci
    new BuiltinEntry(ID.ppc_tbegin, 83591),  // __builtin_tbegin
    new BuiltinEntry(ID.ppc_tcheck, 83608),  // __builtin_tcheck
    new BuiltinEntry(ID.ppc_tend, 83625),  // __builtin_tend
    new BuiltinEntry(ID.ppc_tendall, 83640),  // __builtin_tendall
    new BuiltinEntry(ID.ppc_trechkpt, 83658),  // __builtin_trechkpt
    new BuiltinEntry(ID.ppc_treclaim, 83677),  // __builtin_treclaim
    new BuiltinEntry(ID.ppc_tresume, 83696),  // __builtin_tresume
    new BuiltinEntry(ID.ppc_tsr, 83714),  // __builtin_tsr
    new BuiltinEntry(ID.ppc_tsuspend, 83728),  // __builtin_tsuspend
    new BuiltinEntry(ID.ppc_ttest, 83747),  // __builtin_ttest
    new BuiltinEntry(ID.ppc_vsx_xsmaxdp, 83763),  // __builtin_vsx_xsmaxdp
    new BuiltinEntry(ID.ppc_vsx_xsmindp, 83785),  // __builtin_vsx_xsmindp
    new BuiltinEntry(ID.ppc_vsx_xvcmpeqdp, 83807),  // __builtin_vsx_xvcmpeqdp
    new BuiltinEntry(ID.ppc_vsx_xvcmpeqdp_p, 83831),  // __builtin_vsx_xvcmpeqdp_p
    new BuiltinEntry(ID.ppc_vsx_xvcmpeqsp, 83857),  // __builtin_vsx_xvcmpeqsp
    new BuiltinEntry(ID.ppc_vsx_xvcmpeqsp_p, 83881),  // __builtin_vsx_xvcmpeqsp_p
    new BuiltinEntry(ID.ppc_vsx_xvcmpgedp, 83907),  // __builtin_vsx_xvcmpgedp
    new BuiltinEntry(ID.ppc_vsx_xvcmpgedp_p, 83931),  // __builtin_vsx_xvcmpgedp_p
    new BuiltinEntry(ID.ppc_vsx_xvcmpgesp, 83957),  // __builtin_vsx_xvcmpgesp
    new BuiltinEntry(ID.ppc_vsx_xvcmpgesp_p, 83981),  // __builtin_vsx_xvcmpgesp_p
    new BuiltinEntry(ID.ppc_vsx_xvcmpgtdp, 84007),  // __builtin_vsx_xvcmpgtdp
    new BuiltinEntry(ID.ppc_vsx_xvcmpgtdp_p, 84031),  // __builtin_vsx_xvcmpgtdp_p
    new BuiltinEntry(ID.ppc_vsx_xvcmpgtsp, 84057),  // __builtin_vsx_xvcmpgtsp
    new BuiltinEntry(ID.ppc_vsx_xvcmpgtsp_p, 84081),  // __builtin_vsx_xvcmpgtsp_p
    new BuiltinEntry(ID.ppc_vsx_xvdivdp, 84107),  // __builtin_vsx_xvdivdp
    new BuiltinEntry(ID.ppc_vsx_xvdivsp, 84129),  // __builtin_vsx_xvdivsp
    new BuiltinEntry(ID.ppc_vsx_xvmaxdp, 84151),  // __builtin_vsx_xvmaxdp
    new BuiltinEntry(ID.ppc_vsx_xvmaxsp, 84173),  // __builtin_vsx_xvmaxsp
    new BuiltinEntry(ID.ppc_vsx_xvmindp, 84195),  // __builtin_vsx_xvmindp
    new BuiltinEntry(ID.ppc_vsx_xvminsp, 84217),  // __builtin_vsx_xvminsp
    new BuiltinEntry(ID.ppc_vsx_xvredp, 84239),  // __builtin_vsx_xvredp
    new BuiltinEntry(ID.ppc_vsx_xvresp, 84260),  // __builtin_vsx_xvresp
    new BuiltinEntry(ID.ppc_vsx_xvrsqrtedp, 84281),  // __builtin_vsx_xvrsqrtedp
    new BuiltinEntry(ID.ppc_vsx_xvrsqrtesp, 84306),  // __builtin_vsx_xvrsqrtesp
    new BuiltinEntry(ID.ppc_vsx_xxleqv, 84331) // __builtin_vsx_xxleqv
  };
  static final/*static*/ /*const*/ BuiltinEntry r600Names[/*12*/] = new /*const*/ BuiltinEntry [/*12*/] {
    new BuiltinEntry(ID.r600_group_barrier, 84352),  // __builtin_r600_group_barrier
    new BuiltinEntry(ID.r600_implicitarg_ptr, 84381),  // __builtin_r600_implicitarg_ptr
    new BuiltinEntry(ID.r600_rat_store_typed, 84412),  // __builtin_r600_rat_store_typed
    new BuiltinEntry(ID.r600_read_global_size_x, 84443),  // __builtin_r600_read_global_size_x
    new BuiltinEntry(ID.r600_read_global_size_y, 84477),  // __builtin_r600_read_global_size_y
    new BuiltinEntry(ID.r600_read_global_size_z, 84511),  // __builtin_r600_read_global_size_z
    new BuiltinEntry(ID.r600_read_ngroups_x, 84545),  // __builtin_r600_read_ngroups_x
    new BuiltinEntry(ID.r600_read_ngroups_y, 84575),  // __builtin_r600_read_ngroups_y
    new BuiltinEntry(ID.r600_read_ngroups_z, 84605),  // __builtin_r600_read_ngroups_z
    new BuiltinEntry(ID.r600_read_tgid_x, 84635),  // __builtin_r600_read_tgid_x
    new BuiltinEntry(ID.r600_read_tgid_y, 84662),  // __builtin_r600_read_tgid_y
    new BuiltinEntry(ID.r600_read_tgid_z, 84689) // __builtin_r600_read_tgid_z
  };
  static final/*static*/ /*const*/ BuiltinEntry s390Names[/*149*/] = new /*const*/ BuiltinEntry [/*149*/] {
    new BuiltinEntry(ID.s390_lcbb, 84743),  // __builtin_s390_lcbb
    new BuiltinEntry(ID.s390_vaccb, 84783),  // __builtin_s390_vaccb
    new BuiltinEntry(ID.s390_vacccq, 84804),  // __builtin_s390_vacccq
    new BuiltinEntry(ID.s390_vaccf, 84826),  // __builtin_s390_vaccf
    new BuiltinEntry(ID.s390_vaccg, 84847),  // __builtin_s390_vaccg
    new BuiltinEntry(ID.s390_vacch, 84868),  // __builtin_s390_vacch
    new BuiltinEntry(ID.s390_vaccq, 84889),  // __builtin_s390_vaccq
    new BuiltinEntry(ID.s390_vacq, 84910),  // __builtin_s390_vacq
    new BuiltinEntry(ID.s390_vaq, 84930),  // __builtin_s390_vaq
    new BuiltinEntry(ID.s390_vavgb, 84949),  // __builtin_s390_vavgb
    new BuiltinEntry(ID.s390_vavgf, 84970),  // __builtin_s390_vavgf
    new BuiltinEntry(ID.s390_vavgg, 84991),  // __builtin_s390_vavgg
    new BuiltinEntry(ID.s390_vavgh, 85012),  // __builtin_s390_vavgh
    new BuiltinEntry(ID.s390_vavglb, 85033),  // __builtin_s390_vavglb
    new BuiltinEntry(ID.s390_vavglf, 85055),  // __builtin_s390_vavglf
    new BuiltinEntry(ID.s390_vavglg, 85077),  // __builtin_s390_vavglg
    new BuiltinEntry(ID.s390_vavglh, 85099),  // __builtin_s390_vavglh
    new BuiltinEntry(ID.s390_vcksm, 85121),  // __builtin_s390_vcksm
    new BuiltinEntry(ID.s390_verimb, 85142),  // __builtin_s390_verimb
    new BuiltinEntry(ID.s390_verimf, 85164),  // __builtin_s390_verimf
    new BuiltinEntry(ID.s390_verimg, 85186),  // __builtin_s390_verimg
    new BuiltinEntry(ID.s390_verimh, 85208),  // __builtin_s390_verimh
    new BuiltinEntry(ID.s390_verllb, 85230),  // __builtin_s390_verllb
    new BuiltinEntry(ID.s390_verllf, 85252),  // __builtin_s390_verllf
    new BuiltinEntry(ID.s390_verllg, 85274),  // __builtin_s390_verllg
    new BuiltinEntry(ID.s390_verllh, 85296),  // __builtin_s390_verllh
    new BuiltinEntry(ID.s390_verllvb, 85318),  // __builtin_s390_verllvb
    new BuiltinEntry(ID.s390_verllvf, 85341),  // __builtin_s390_verllvf
    new BuiltinEntry(ID.s390_verllvg, 85364),  // __builtin_s390_verllvg
    new BuiltinEntry(ID.s390_verllvh, 85387),  // __builtin_s390_verllvh
    new BuiltinEntry(ID.s390_vfaeb, 85410),  // __builtin_s390_vfaeb
    new BuiltinEntry(ID.s390_vfaef, 85431),  // __builtin_s390_vfaef
    new BuiltinEntry(ID.s390_vfaeh, 85452),  // __builtin_s390_vfaeh
    new BuiltinEntry(ID.s390_vfaezb, 85473),  // __builtin_s390_vfaezb
    new BuiltinEntry(ID.s390_vfaezf, 85495),  // __builtin_s390_vfaezf
    new BuiltinEntry(ID.s390_vfaezh, 85517),  // __builtin_s390_vfaezh
    new BuiltinEntry(ID.s390_vfeeb, 85539),  // __builtin_s390_vfeeb
    new BuiltinEntry(ID.s390_vfeef, 85560),  // __builtin_s390_vfeef
    new BuiltinEntry(ID.s390_vfeeh, 85581),  // __builtin_s390_vfeeh
    new BuiltinEntry(ID.s390_vfeezb, 85602),  // __builtin_s390_vfeezb
    new BuiltinEntry(ID.s390_vfeezf, 85624),  // __builtin_s390_vfeezf
    new BuiltinEntry(ID.s390_vfeezh, 85646),  // __builtin_s390_vfeezh
    new BuiltinEntry(ID.s390_vfeneb, 85668),  // __builtin_s390_vfeneb
    new BuiltinEntry(ID.s390_vfenef, 85690),  // __builtin_s390_vfenef
    new BuiltinEntry(ID.s390_vfeneh, 85712),  // __builtin_s390_vfeneh
    new BuiltinEntry(ID.s390_vfenezb, 85734),  // __builtin_s390_vfenezb
    new BuiltinEntry(ID.s390_vfenezf, 85757),  // __builtin_s390_vfenezf
    new BuiltinEntry(ID.s390_vfenezh, 85780),  // __builtin_s390_vfenezh
    new BuiltinEntry(ID.s390_vgfmab, 85803),  // __builtin_s390_vgfmab
    new BuiltinEntry(ID.s390_vgfmaf, 85825),  // __builtin_s390_vgfmaf
    new BuiltinEntry(ID.s390_vgfmag, 85847),  // __builtin_s390_vgfmag
    new BuiltinEntry(ID.s390_vgfmah, 85869),  // __builtin_s390_vgfmah
    new BuiltinEntry(ID.s390_vgfmb, 85891),  // __builtin_s390_vgfmb
    new BuiltinEntry(ID.s390_vgfmf, 85912),  // __builtin_s390_vgfmf
    new BuiltinEntry(ID.s390_vgfmg, 85933),  // __builtin_s390_vgfmg
    new BuiltinEntry(ID.s390_vgfmh, 85954),  // __builtin_s390_vgfmh
    new BuiltinEntry(ID.s390_vistrb, 85975),  // __builtin_s390_vistrb
    new BuiltinEntry(ID.s390_vistrf, 85997),  // __builtin_s390_vistrf
    new BuiltinEntry(ID.s390_vistrh, 86019),  // __builtin_s390_vistrh
    new BuiltinEntry(ID.s390_vlbb, 86041),  // __builtin_s390_vlbb
    new BuiltinEntry(ID.s390_vll, 86061),  // __builtin_s390_vll
    new BuiltinEntry(ID.s390_vmaeb, 86080),  // __builtin_s390_vmaeb
    new BuiltinEntry(ID.s390_vmaef, 86101),  // __builtin_s390_vmaef
    new BuiltinEntry(ID.s390_vmaeh, 86122),  // __builtin_s390_vmaeh
    new BuiltinEntry(ID.s390_vmahb, 86143),  // __builtin_s390_vmahb
    new BuiltinEntry(ID.s390_vmahf, 86164),  // __builtin_s390_vmahf
    new BuiltinEntry(ID.s390_vmahh, 86185),  // __builtin_s390_vmahh
    new BuiltinEntry(ID.s390_vmaleb, 86206),  // __builtin_s390_vmaleb
    new BuiltinEntry(ID.s390_vmalef, 86228),  // __builtin_s390_vmalef
    new BuiltinEntry(ID.s390_vmaleh, 86250),  // __builtin_s390_vmaleh
    new BuiltinEntry(ID.s390_vmalhb, 86272),  // __builtin_s390_vmalhb
    new BuiltinEntry(ID.s390_vmalhf, 86294),  // __builtin_s390_vmalhf
    new BuiltinEntry(ID.s390_vmalhh, 86316),  // __builtin_s390_vmalhh
    new BuiltinEntry(ID.s390_vmalob, 86338),  // __builtin_s390_vmalob
    new BuiltinEntry(ID.s390_vmalof, 86360),  // __builtin_s390_vmalof
    new BuiltinEntry(ID.s390_vmaloh, 86382),  // __builtin_s390_vmaloh
    new BuiltinEntry(ID.s390_vmaob, 86404),  // __builtin_s390_vmaob
    new BuiltinEntry(ID.s390_vmaof, 86425),  // __builtin_s390_vmaof
    new BuiltinEntry(ID.s390_vmaoh, 86446),  // __builtin_s390_vmaoh
    new BuiltinEntry(ID.s390_vmeb, 86467),  // __builtin_s390_vmeb
    new BuiltinEntry(ID.s390_vmef, 86487),  // __builtin_s390_vmef
    new BuiltinEntry(ID.s390_vmeh, 86507),  // __builtin_s390_vmeh
    new BuiltinEntry(ID.s390_vmhb, 86527),  // __builtin_s390_vmhb
    new BuiltinEntry(ID.s390_vmhf, 86547),  // __builtin_s390_vmhf
    new BuiltinEntry(ID.s390_vmhh, 86567),  // __builtin_s390_vmhh
    new BuiltinEntry(ID.s390_vmleb, 86587),  // __builtin_s390_vmleb
    new BuiltinEntry(ID.s390_vmlef, 86608),  // __builtin_s390_vmlef
    new BuiltinEntry(ID.s390_vmleh, 86629),  // __builtin_s390_vmleh
    new BuiltinEntry(ID.s390_vmlhb, 86650),  // __builtin_s390_vmlhb
    new BuiltinEntry(ID.s390_vmlhf, 86671),  // __builtin_s390_vmlhf
    new BuiltinEntry(ID.s390_vmlhh, 86692),  // __builtin_s390_vmlhh
    new BuiltinEntry(ID.s390_vmlob, 86713),  // __builtin_s390_vmlob
    new BuiltinEntry(ID.s390_vmlof, 86734),  // __builtin_s390_vmlof
    new BuiltinEntry(ID.s390_vmloh, 86755),  // __builtin_s390_vmloh
    new BuiltinEntry(ID.s390_vmob, 86776),  // __builtin_s390_vmob
    new BuiltinEntry(ID.s390_vmof, 86796),  // __builtin_s390_vmof
    new BuiltinEntry(ID.s390_vmoh, 86816),  // __builtin_s390_vmoh
    new BuiltinEntry(ID.s390_vpdi, 86836),  // __builtin_s390_vpdi
    new BuiltinEntry(ID.s390_vperm, 86856),  // __builtin_s390_vperm
    new BuiltinEntry(ID.s390_vpklsf, 86877),  // __builtin_s390_vpklsf
    new BuiltinEntry(ID.s390_vpklsg, 86899),  // __builtin_s390_vpklsg
    new BuiltinEntry(ID.s390_vpklsh, 86921),  // __builtin_s390_vpklsh
    new BuiltinEntry(ID.s390_vpksf, 86943),  // __builtin_s390_vpksf
    new BuiltinEntry(ID.s390_vpksg, 86964),  // __builtin_s390_vpksg
    new BuiltinEntry(ID.s390_vpksh, 86985),  // __builtin_s390_vpksh
    new BuiltinEntry(ID.s390_vsbcbiq, 87006),  // __builtin_s390_vsbcbiq
    new BuiltinEntry(ID.s390_vsbiq, 87029),  // __builtin_s390_vsbiq
    new BuiltinEntry(ID.s390_vscbib, 87050),  // __builtin_s390_vscbib
    new BuiltinEntry(ID.s390_vscbif, 87072),  // __builtin_s390_vscbif
    new BuiltinEntry(ID.s390_vscbig, 87094),  // __builtin_s390_vscbig
    new BuiltinEntry(ID.s390_vscbih, 87116),  // __builtin_s390_vscbih
    new BuiltinEntry(ID.s390_vscbiq, 87138),  // __builtin_s390_vscbiq
    new BuiltinEntry(ID.s390_vsl, 87160),  // __builtin_s390_vsl
    new BuiltinEntry(ID.s390_vslb, 87179),  // __builtin_s390_vslb
    new BuiltinEntry(ID.s390_vsldb, 87199),  // __builtin_s390_vsldb
    new BuiltinEntry(ID.s390_vsq, 87220),  // __builtin_s390_vsq
    new BuiltinEntry(ID.s390_vsra, 87239),  // __builtin_s390_vsra
    new BuiltinEntry(ID.s390_vsrab, 87259),  // __builtin_s390_vsrab
    new BuiltinEntry(ID.s390_vsrl, 87280),  // __builtin_s390_vsrl
    new BuiltinEntry(ID.s390_vsrlb, 87300),  // __builtin_s390_vsrlb
    new BuiltinEntry(ID.s390_vstl, 87321),  // __builtin_s390_vstl
    new BuiltinEntry(ID.s390_vstrcb, 87341),  // __builtin_s390_vstrcb
    new BuiltinEntry(ID.s390_vstrcf, 87363),  // __builtin_s390_vstrcf
    new BuiltinEntry(ID.s390_vstrch, 87385),  // __builtin_s390_vstrch
    new BuiltinEntry(ID.s390_vstrczb, 87407),  // __builtin_s390_vstrczb
    new BuiltinEntry(ID.s390_vstrczf, 87430),  // __builtin_s390_vstrczf
    new BuiltinEntry(ID.s390_vstrczh, 87453),  // __builtin_s390_vstrczh
    new BuiltinEntry(ID.s390_vsumb, 87476),  // __builtin_s390_vsumb
    new BuiltinEntry(ID.s390_vsumgf, 87497),  // __builtin_s390_vsumgf
    new BuiltinEntry(ID.s390_vsumgh, 87519),  // __builtin_s390_vsumgh
    new BuiltinEntry(ID.s390_vsumh, 87541),  // __builtin_s390_vsumh
    new BuiltinEntry(ID.s390_vsumqf, 87562),  // __builtin_s390_vsumqf
    new BuiltinEntry(ID.s390_vsumqg, 87584),  // __builtin_s390_vsumqg
    new BuiltinEntry(ID.s390_vtm, 87606),  // __builtin_s390_vtm
    new BuiltinEntry(ID.s390_vuphb, 87625),  // __builtin_s390_vuphb
    new BuiltinEntry(ID.s390_vuphf, 87646),  // __builtin_s390_vuphf
    new BuiltinEntry(ID.s390_vuphh, 87667),  // __builtin_s390_vuphh
    new BuiltinEntry(ID.s390_vuplb, 87688),  // __builtin_s390_vuplb
    new BuiltinEntry(ID.s390_vuplf, 87709),  // __builtin_s390_vuplf
    new BuiltinEntry(ID.s390_vuplhb, 87730),  // __builtin_s390_vuplhb
    new BuiltinEntry(ID.s390_vuplhf, 87752),  // __builtin_s390_vuplhf
    new BuiltinEntry(ID.s390_vuplhh, 87774),  // __builtin_s390_vuplhh
    new BuiltinEntry(ID.s390_vuplhw, 87796),  // __builtin_s390_vuplhw
    new BuiltinEntry(ID.s390_vupllb, 87818),  // __builtin_s390_vupllb
    new BuiltinEntry(ID.s390_vupllf, 87840),  // __builtin_s390_vupllf
    new BuiltinEntry(ID.s390_vupllh, 87862),  // __builtin_s390_vupllh
    new BuiltinEntry(ID.s390_tend, 83625),  // __builtin_tend
    new BuiltinEntry(ID.s390_ppa_txassist, 84763),  // __builtin_tx_assist
    new BuiltinEntry(ID.s390_etnd, 84716) // __builtin_tx_nesting_depth
  };
  private static final BuiltinEntry[] readBuiltinEntries(String resource, int length) throws URISyntaxException, IOException {
    InputStream is = IntrinsicsIntrinsicGlobals.class.getResourceAsStream(resource);
    BuiltinEntry res[] = new BuiltinEntry[length];
    for(int i = 0; i < length; i++) {
      int id = is.read()+ (is.read())<<8 + (is.read())<<16 + (is.read())<<24;
      int shift =  is.read()+ (is.read())<<8 + (is.read())<<16 + (is.read())<<24;
      res[i] = new BuiltinEntry(id, shift);
    }
    is.close();
    return res;
  }
  static final/*static*/ /*const*/ BuiltinEntry x86Names[/*1740*/];
  static {
    BuiltinEntry res[] = new BuiltinEntry[0];
    try {
      res = readBuiltinEntries("/org/llvm/ir/resources/x86Names", 1740);
    } catch (Exception ex) {
      Logger.getLogger(IntrinsicsIntrinsicGlobals.class.getName()).log(Level.SEVERE, null, ex);
    }
    x86Names = res;
  }
  static final/*static*/ /*const*/ BuiltinEntry xcoreNames[/*4*/] = new /*const*/ BuiltinEntry [/*4*/] {
    new BuiltinEntry(ID.xcore_bitrev, 138696),  // __builtin_bitrev
    new BuiltinEntry(ID.xcore_getid, 138713),  // __builtin_getid
    new BuiltinEntry(ID.xcore_getps, 138729),  // __builtin_getps
    new BuiltinEntry(ID.xcore_setps, 138745) // __builtin_setps
  };
  }


/// Map a MS builtin name to an intrinsic ID.
//<editor-fold defaultstate="collapsed" desc="llvm::Intrinsic::getIntrinsicForMSBuiltin">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/build/include/llvm/IR/Intrinsics.gen", line = 34841,
 FQN="llvm::Intrinsic::getIntrinsicForMSBuiltin", NM="_ZN4llvm9Intrinsic24getIntrinsicForMSBuiltinEPKcS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Function.cpp -nm=_ZN4llvm9Intrinsic24getIntrinsicForMSBuiltinEPKcS2_")
//</editor-fold>
public static /*Intrinsic.ID*/int getIntrinsicForMSBuiltin(/*const*/char$ptr/*char P*/ TargetPrefixStr, /*const*/char$ptr/*char P*/ BuiltinNameStr) {
  final/*static*/ /*const*//*char*/byte BuiltinNames[/*61*/] = getIntrinsicForMSBuiltin$$.BuiltinNames;
  
  StringRef BuiltinName/*J*/= new StringRef(BuiltinNameStr);
  StringRef TargetPrefix/*J*/= new StringRef(TargetPrefixStr);
  if ($eq_StringRef(/*NO_COPY*/TargetPrefix, /*STRINGREF_STR*/"arm")) {
    Native.ComparatorLower<BuiltinEntry, char$ptr> comparator = new Native.ComparatorLower<BuiltinEntry, char$ptr>(){
      @Override
      public boolean $less(BuiltinEntry one, char$ptr other) {
        return one.$less(other);
      }
    };
    final/*static*/ /*const*/ type$ptr<BuiltinEntry> armNames = create_type$ptr(getIntrinsicForMSBuiltin$$.armNames);
    /*const*/ type$ptr<BuiltinEntry /*P*/> I = std.lower_bound(armNames, armNames.$add(5), BuiltinNameStr, comparator);
    if ($noteq_ptr(I, armNames.$add(5))
       && strcmp(I.$star().getName(), BuiltinNameStr) == 0) {
      return I.$star().IntrinID;
    }
  }
  return ID.not_intrinsic;
}
private static final class getIntrinsicForMSBuiltin$$ {
  static final/*static*/ /*const*//*char*/byte BuiltinNames[/*61*/] = new$char(61, 
    $$UNDERSCORE, $$UNDERSCORE, $$d, $$m, $$b, $$TERM, $$UNDERSCORE, $$UNDERSCORE, $$d, $$s, $$b, $$TERM, $$UNDERSCORE, $$UNDERSCORE, $$i, 
    $$s, $$b, $$TERM, $$UNDERSCORE, $$M, $$o, $$v, $$e, $$F, $$r, $$o, $$m, $$C, $$o, $$p, 
    $$r, $$o, $$c, $$e, $$s, $$s, $$o, $$r, $$TERM, $$UNDERSCORE, $$M, $$o, $$v, $$e, $$F, 
    $$r, $$o, $$m, $$C, $$o, $$p, $$r, $$o, $$c, $$e, $$s, $$s, $$o, $$r, $$2, 
    $$TERM
  );
  static final/*static*/ /*const*/ BuiltinEntry armNames[/*5*/] = new /*const*/ BuiltinEntry [/*5*/] {
    new BuiltinEntry(ID.arm_mrc, 18),  // _MoveFromCoprocessor
    new BuiltinEntry(ID.arm_mrc2, 39),  // _MoveFromCoprocessor2
    new BuiltinEntry(ID.arm_dmb, 0),  // __dmb
    new BuiltinEntry(ID.arm_dsb, 6),  // __dsb
    new BuiltinEntry(ID.arm_isb, 12) // __isb
  };
}

} // END OF class IntrinsicsIntrinsicGlobals
