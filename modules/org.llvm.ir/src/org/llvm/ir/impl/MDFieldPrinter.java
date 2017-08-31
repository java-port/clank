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

package org.llvm.ir.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.$uchar2uint;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.support.dwarf.DwarfGlobals;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1422,
 FQN="(anonymous namespace)::MDFieldPrinter", NM="_ZN12_GLOBAL__N_114MDFieldPrinterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinterE")
//</editor-fold>
public class/*struct*/ MDFieldPrinter {
  public final raw_ostream /*&*/ Out;
  public FieldSeparator FS;
  public TypePrinting /*P*/ TypePrinter;
  public SlotTracker /*P*/ Machine;
  public /*const*/ Module /*P*/ Context;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::MDFieldPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1429,
   FQN="(anonymous namespace)::MDFieldPrinter::MDFieldPrinter", NM="_ZN12_GLOBAL__N_114MDFieldPrinterC1ERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinterC1ERN4llvm11raw_ostreamE")
  //</editor-fold>
  public /*explicit*/ MDFieldPrinter(final raw_ostream /*&*/ Out) {
    // : Out(Out), FS(), TypePrinter(null), Machine(null), Context(null) 
    //START JInit
    this./*&*/Out=/*&*/Out;
    this.FS = new FieldSeparator();
    this.TypePrinter = null;
    this.Machine = null;
    this.Context = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::MDFieldPrinter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1431,
   FQN="(anonymous namespace)::MDFieldPrinter::MDFieldPrinter", NM="_ZN12_GLOBAL__N_114MDFieldPrinterC1ERN4llvm11raw_ostreamEPNS_12TypePrintingEPNS1_11SlotTrackerEPKNS1_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinterC1ERN4llvm11raw_ostreamEPNS_12TypePrintingEPNS1_11SlotTrackerEPKNS1_6ModuleE")
  //</editor-fold>
  public MDFieldPrinter(final raw_ostream /*&*/ Out, TypePrinting /*P*/ TypePrinter, 
      SlotTracker /*P*/ Machine, /*const*/ Module /*P*/ Context) {
    // : Out(Out), FS(), TypePrinter(TypePrinter), Machine(Machine), Context(Context) 
    //START JInit
    this./*&*/Out=/*&*/Out;
    this.FS = new FieldSeparator();
    this.TypePrinter = TypePrinter;
    this.Machine = Machine;
    this.Context = Context;
    //END JInit
  }

  // end namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printTag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1452,
   FQN="(anonymous namespace)::MDFieldPrinter::printTag", NM="_ZN12_GLOBAL__N_114MDFieldPrinter8printTagEPKN4llvm6DINodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter8printTagEPKN4llvm6DINodeE")
  //</editor-fold>
  public void printTag(/*const*/ DINode /*P*/ N) {
    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*KEEP_STR*/"tag: ");
    {
      /*const*/char$ptr/*char P*/ Tag = $tryClone(DwarfGlobals.TagString(N.getTag()));
      if (Native.$bool(Tag)) {
        Out.$out(Tag);
      } else {
        Out.$out_uint(N.getTag());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printMacinfoType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1460,
   FQN="(anonymous namespace)::MDFieldPrinter::printMacinfoType", NM="_ZN12_GLOBAL__N_114MDFieldPrinter16printMacinfoTypeEPKN4llvm11DIMacroNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter16printMacinfoTypeEPKN4llvm11DIMacroNodeE")
  //</editor-fold>
  public void printMacinfoType(/*const*/ DIMacroNode /*P*/ N) {
    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*KEEP_STR*/"type: ");
    {
      /*const*/char$ptr/*char P*/ Type = $tryClone(DwarfGlobals.MacinfoString(N.getMacinfoType()));
      if (Native.$bool(Type)) {
        Out.$out(Type);
      } else {
        Out.$out_uint(N.getMacinfoType());
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1468,
   FQN="(anonymous namespace)::MDFieldPrinter::printString", NM="_ZN12_GLOBAL__N_114MDFieldPrinter11printStringEN4llvm9StringRefES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter11printStringEN4llvm9StringRefES2_b")
  //</editor-fold>
  public void printString(StringRef Name, StringRef Value) {
    printString(Name, Value, 
             true);
  }
  public void printString(StringRef Name, StringRef Value, 
             boolean ShouldSkipEmpty/*= true*/) {
    if (ShouldSkipEmpty && Value.empty()) {
      return;
    }
    
    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": \"");
    AsmWriterStatics.PrintEscapedString(new StringRef(Value), Out);
    Out.$out(/*KEEP_STR*/$DBL_QUOTE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1489,
   FQN="(anonymous namespace)::MDFieldPrinter::printMetadata", NM="_ZN12_GLOBAL__N_114MDFieldPrinter13printMetadataEN4llvm9StringRefEPKNS1_8MetadataEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter13printMetadataEN4llvm9StringRefEPKNS1_8MetadataEb")
  //</editor-fold>
  public void printMetadata(StringRef Name, /*const*/ Metadata /*P*/ MD) {
    printMetadata(Name, MD, 
               true);
  }
  public void printMetadata(StringRef Name, /*const*/ Metadata /*P*/ MD, 
               boolean ShouldSkipNull/*= true*/) {
    if (ShouldSkipNull && !(MD != null)) {
      return;
    }
    
    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ");
    AsmWriterStatics.writeMetadataAsOperand(Out, MD, TypePrinter, Machine, Context);
  }

  //template <class IntTy = unsigned int> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printInt">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1499,
   FQN="(anonymous namespace)::MDFieldPrinter::printInt", NM="_ZN12_GLOBAL__N_114MDFieldPrinter8printIntIjEEvN4llvm9StringRefET_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter8printIntIjEEvN4llvm9StringRefET_b")
  //</editor-fold>
  public void printInt$UInt(StringRef Name, /*uint*/int Int) {
    printInt$UInt(Name, Int, true);
  }
  public void printInt$UInt(StringRef Name, /*uint*/int Int, boolean ShouldSkipZero/*= true*/) {
    if (ShouldSkipZero && !(Int != 0)) {
      return;
    }

    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ").$out_uint(Int);
  }
  //template <class IntTy = long long> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printInt">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1499,
   FQN="(anonymous namespace)::MDFieldPrinter::printInt", NM="_ZN12_GLOBAL__N_114MDFieldPrinter8printIntIxEEvN4llvm9StringRefET_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter8printIntIxEEvN4llvm9StringRefET_b")
  //</editor-fold>
  public void printInt$LLong(StringRef Name, /*llong*/long Int) {
    printInt$LLong(Name, Int, true);
  }
  public void printInt$LLong(StringRef Name, /*llong*/long Int, boolean ShouldSkipZero/*= true*/) {
    if (ShouldSkipZero && !(Int != 0)) {
      return;
    }

    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ").$out_llong(Int);
  }
  //template <class IntTy = unsigned long long> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printInt">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1499,
   FQN="(anonymous namespace)::MDFieldPrinter::printInt", NM="_ZN12_GLOBAL__N_114MDFieldPrinter8printIntIyEEvN4llvm9StringRefET_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter8printIntIyEEvN4llvm9StringRefET_b")
  //</editor-fold>
  public void printInt$ULLong(StringRef Name, /*ullong*/long Int) {
    printInt$ULLong(Name, Int, true);
  }
  public void printInt$ULLong(StringRef Name, /*ullong*/long Int, boolean ShouldSkipZero/*= true*/) {
    if (ShouldSkipZero && !(Int != 0)) {
      return;
    }

    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ").$out_ullong(Int);
  }
  //template <class IntTy = int> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printInt">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1499,
   FQN="(anonymous namespace)::MDFieldPrinter::printInt", NM="_ZN12_GLOBAL__N_114MDFieldPrinter8printIntIiEEvN4llvm9StringRefET_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter8printIntIiEEvN4llvm9StringRefET_b")
  //</editor-fold>
  public void printInt$Int(StringRef Name, int Int) {
    printInt$Int(Name, Int, true);
  }
  public void printInt$Int(StringRef Name, int Int, boolean ShouldSkipZero/*= true*/) {
    if (ShouldSkipZero && !(Int != 0)) {
      return;
    }

    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ").$out_int(Int);
  }
//  /*template <class IntTy> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printInt">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1499,
//   FQN="(anonymous namespace)::MDFieldPrinter::printInt", NM="Tpl__ZN12_GLOBAL__N_114MDFieldPrinter8printIntEN4llvm9StringRefET_b",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=Tpl__ZN12_GLOBAL__N_114MDFieldPrinter8printIntEN4llvm9StringRefET_b")
//  //</editor-fold>
//  public </*class*/ IntTy> void printInt(StringRef Name, IntTy Int) {
//    printInt(Name, Int, true);
//  }
//  public </*class*/ IntTy> void printInt(StringRef Name, IntTy Int, boolean ShouldSkipZero/*= true*/) {
//    if (ShouldSkipZero && Native.$not(Int)) {
//      return;
//    }
//
//    Native.$out(AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": "), Int);
//  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printBool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1506,
   FQN="(anonymous namespace)::MDFieldPrinter::printBool", NM="_ZN12_GLOBAL__N_114MDFieldPrinter9printBoolEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter9printBoolEN4llvm9StringRefEb")
  //</editor-fold>
  public void printBool(StringRef Name, boolean Value) {
    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ").$out((Value ? $true : $false));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printDIFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1510,
   FQN="(anonymous namespace)::MDFieldPrinter::printDIFlags", NM="_ZN12_GLOBAL__N_114MDFieldPrinter12printDIFlagsEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter12printDIFlagsEN4llvm9StringRefEj")
  //</editor-fold>
  public void printDIFlags(StringRef Name, /*uint*/int Flags) {
    if (!(Flags != 0)) {
      return;
    }
    
    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ");
    
    SmallVectorUInt SplitFlags/*J*/= new SmallVectorUInt(8, 0);
    /*uint*/int Extra = DINode.splitFlags(Flags, SplitFlags);
    
    FieldSeparator FlagsFS/*J*/= new FieldSeparator($(" | "));
    for (/*uint*/int F : SplitFlags) {
      /*const*/char$ptr/*char P*/ StringF = $tryClone(DINode.getFlagString(F));
      assert (Native.$bool(StringF)) : "Expected valid flag";
      AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FlagsFS).$out(StringF);
    }
    if ((Extra != 0) || SplitFlags.empty()) {
      AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FlagsFS).$out_uint(Extra);
    }
  }

  //template <class IntTy = unsigned int, class Stringifier extends StringifierFunction = const char *(*)(unsigned int)> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printDwarfEnum">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1536,
   FQN="(anonymous namespace)::MDFieldPrinter::printDwarfEnum", NM="_ZN12_GLOBAL__N_114MDFieldPrinter14printDwarfEnumIjPFPKcjEEEvN4llvm9StringRefET_T0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter14printDwarfEnumIjPFPKcjEEEvN4llvm9StringRefET_T0_b")
  //</editor-fold>
  public void printDwarfEnum$UInt(StringRef Name, /*uint*/int Value, StringifierUInt __toString){
    printDwarfEnum$UInt(Name, Value, __toString, true);
  }
  public void printDwarfEnum$UInt(StringRef Name, /*uint*/int Value,  StringifierUInt __toString, boolean ShouldSkipZero/*= true*/) {
    if (!(Value != 0)) {
      return;
    }

    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ");
    {
      /*const*/char$ptr/*char P*/ S = $tryClone(__toString.$call(Value));
      if (Native.$bool(S)) {
        Out.$out(S);
      } else {
        Out.$out_uint(Value);
      }
    }
  }
  //template <class IntTy = unsigned char, class Stringifier extends StringifierFunction = const char *(*)(unsigned int)> 
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printDwarfEnum">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1536,
   FQN="(anonymous namespace)::MDFieldPrinter::printDwarfEnum", NM="_ZN12_GLOBAL__N_114MDFieldPrinter14printDwarfEnumIhPFPKcjEEEvN4llvm9StringRefET_T0_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter14printDwarfEnumIhPFPKcjEEEvN4llvm9StringRefET_T0_b")
  //</editor-fold>
  public void printDwarfEnum$UChar(StringRef Name, /*uchar*/byte Value, StringifierUChar __toString){
    printDwarfEnum$UChar(Name, Value, __toString, true);
  }
  public void printDwarfEnum$UChar(StringRef Name, /*uchar*/byte Value, StringifierUChar __toString, boolean ShouldSkipZero/*= true*/) {
    if (!(Value != 0)) {
      return;
    }

    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ");
    {
      /*const*/char$ptr/*char P*/ S = $tryClone(__toString.$call($uchar2uint(Value)));
      if (Native.$bool(S)) {
        Out.$out(S);
      } else {
        Out.$out_uchar(Value);
      }
    }
  }
//  /*template <class IntTy, class Stringifier> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printDwarfEnum">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1536,
//   FQN="(anonymous namespace)::MDFieldPrinter::printDwarfEnum", NM="Tpl__ZN12_GLOBAL__N_114MDFieldPrinter14printDwarfEnumEN4llvm9StringRefET_T0_b",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=Tpl__ZN12_GLOBAL__N_114MDFieldPrinter14printDwarfEnumEN4llvm9StringRefET_T0_b")
//  //</editor-fold>
//  public </*class*/ IntTy, /*class*/ Stringifier extends StringifierFunction> void printDwarfEnum(StringRef Name, IntTy Value, 
//                Stringifier __toString) {
//    printDwarfEnum(Name, Value, 
//                __toString, true);
//  }
//  public </*class*/ IntTy, /*class*/ Stringifier extends StringifierFunction> void printDwarfEnum(StringRef Name, IntTy Value, 
//                Stringifier __toString, boolean ShouldSkipZero/*= true*/) {
//    if (Native.$not(Value)) {
//      return;
//    }
//
//    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ");
//    {
//      /*const*/char$ptr/*char P*/ S = __toString.$call(Value);
//      if (Native.$bool(S)) {
//        Out.$out(S);
//      } else {
//        Native.$out(Out, Value);
//      }
//    }
//  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MDFieldPrinter::printEmissionKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 1529,
   FQN="(anonymous namespace)::MDFieldPrinter::printEmissionKind", NM="_ZN12_GLOBAL__N_114MDFieldPrinter17printEmissionKindEN4llvm9StringRefENS1_13DICompileUnit17DebugEmissionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114MDFieldPrinter17printEmissionKindEN4llvm9StringRefENS1_13DICompileUnit17DebugEmissionKindE")
  //</editor-fold>
  public void printEmissionKind(StringRef Name, 
                   DICompileUnit.DebugEmissionKind EK) {
    AsmWriterStatics.$out_raw_ostream_FieldSeparator(Out, FS).$out(/*NO_COPY*/Name).$out(/*KEEP_STR*/": ").$out(DICompileUnit.EmissionKindString(EK));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @FunctionalInterface
  public interface StringifierUInt {
    char$ptr/*char P*/ $call(/*uint*/int P);
  }

  @FunctionalInterface
  public interface StringifierUChar {
    char$ptr/*char P*/ $call(/*uchar*/int P);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + ", FS=" + FS // NOI18N
              + ", TypePrinter=" + TypePrinter // NOI18N
              + ", Machine=" + Machine // NOI18N
              + ", Context=" + Context; // NOI18N
  }
}
