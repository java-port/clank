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

package org.llvm.mc;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// \brief Instances of this class represent a single low-level machine
/// instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::MCInst">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 150,
 FQN="llvm::MCInst", NM="_ZN4llvm6MCInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInstE")
//</editor-fold>
public class MCInst implements Destructors.ClassWithDestructor {
  private /*uint*/int Opcode;
  private SMLoc Loc;
  private SmallVector<MCOperand> Operands;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::MCInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 156,
   FQN="llvm::MCInst::MCInst", NM="_ZN4llvm6MCInstC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInstC1Ev")
  //</editor-fold>
  public MCInst() {
    // : Opcode(0), Loc(), Operands() 
    //START JInit
    this.Opcode = 0;
    this.Loc = new SMLoc();
    this.Operands = new SmallVector<MCOperand>(8, new MCOperand());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::setOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 158,
   FQN="llvm::MCInst::setOpcode", NM="_ZN4llvm6MCInst9setOpcodeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst9setOpcodeEj")
  //</editor-fold>
  public void setOpcode(/*uint*/int Op) {
    Opcode = Op;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::getOpcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 159,
   FQN="llvm::MCInst::getOpcode", NM="_ZNK4llvm6MCInst9getOpcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK4llvm6MCInst9getOpcodeEv")
  //</editor-fold>
  public /*uint*/int getOpcode() /*const*/ {
    return Opcode;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::setLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 161,
   FQN="llvm::MCInst::setLoc", NM="_ZN4llvm6MCInst6setLocENS_5SMLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst6setLocENS_5SMLocE")
  //</editor-fold>
  public void setLoc(SMLoc loc) {
    Loc.$assign(loc);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::getLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 162,
   FQN="llvm::MCInst::getLoc", NM="_ZNK4llvm6MCInst6getLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK4llvm6MCInst6getLocEv")
  //</editor-fold>
  public SMLoc getLoc() /*const*/ {
    return new SMLoc(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 164,
   FQN="llvm::MCInst::getOperand", NM="_ZNK4llvm6MCInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK4llvm6MCInst10getOperandEj")
  //</editor-fold>
  public /*const*/ MCOperand /*&*/ getOperand$Const(/*uint*/int i) /*const*/ {
    return Operands.$at$Const(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 165,
   FQN="llvm::MCInst::getOperand", NM="_ZN4llvm6MCInst10getOperandEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst10getOperandEj")
  //</editor-fold>
  public MCOperand /*&*/ getOperand(/*uint*/int i) {
    return Operands.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::getNumOperands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 166,
   FQN="llvm::MCInst::getNumOperands", NM="_ZNK4llvm6MCInst14getNumOperandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK4llvm6MCInst14getNumOperandsEv")
  //</editor-fold>
  public /*uint*/int getNumOperands() /*const*/ {
    return Operands.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::addOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 168,
   FQN="llvm::MCInst::addOperand", NM="_ZN4llvm6MCInst10addOperandERKNS_9MCOperandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst10addOperandERKNS_9MCOperandE")
  //</editor-fold>
  public void addOperand(final /*const*/ MCOperand /*&*/ Op) {
    Operands.push_back(Op);
  }

  
  // JAVA: typedef SmallVectorImpl<MCOperand>::iterator iterator
//  public final class iterator extends type$ptr<MCOperand>{ };
  // JAVA: typedef SmallVectorImpl<MCOperand>::const_iterator const_iterator
//  public final class const_iterator extends type$ptr<MCOperand>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 172,
   FQN="llvm::MCInst::clear", NM="_ZN4llvm6MCInst5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst5clearEv")
  //</editor-fold>
  public void clear() {
    Operands.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 173,
   FQN="llvm::MCInst::erase", NM="_ZN4llvm6MCInst5eraseEPNS_9MCOperandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst5eraseEPNS_9MCOperandE")
  //</editor-fold>
  public void erase(type$ptr<MCOperand> I) {
    Operands.erase(I);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 174,
   FQN="llvm::MCInst::size", NM="_ZNK4llvm6MCInst4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK4llvm6MCInst4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Operands.size();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 175,
   FQN="llvm::MCInst::begin", NM="_ZN4llvm6MCInst5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst5beginEv")
  //</editor-fold>
  public type$ptr<MCOperand> begin() {
    return Operands.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 176,
   FQN="llvm::MCInst::begin", NM="_ZNK4llvm6MCInst5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK4llvm6MCInst5beginEv")
  //</editor-fold>
  public type$ptr<MCOperand> begin$Const() /*const*/ {
    return Operands.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 177,
   FQN="llvm::MCInst::end", NM="_ZN4llvm6MCInst3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst3endEv")
  //</editor-fold>
  public type$ptr<MCOperand> end() {
    return Operands.end();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 178,
   FQN="llvm::MCInst::end", NM="_ZNK4llvm6MCInst3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZNK4llvm6MCInst3endEv")
  //</editor-fold>
  public type$ptr<MCOperand> end$Const() /*const*/ {
    return Operands.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 179,
   FQN="llvm::MCInst::insert", NM="_ZN4llvm6MCInst6insertEPNS_9MCOperandERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInst6insertEPNS_9MCOperandERKS1_")
  //</editor-fold>
  public type$ptr<MCOperand> insert(type$ptr<MCOperand> I, final /*const*/ MCOperand /*&*/ Op) {
    return Operands.insert_iterator$T$value_T$C$R(I, Op);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInst.cpp", line = 44,
   FQN="llvm::MCInst::print", NM="_ZNK4llvm6MCInst5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm6MCInst5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    OS.$out(/*KEEP_STR*/"<MCInst ").$out_uint(getOpcode());
    for (/*uint*/int i = 0, e = getNumOperands(); i != e; ++i) {
      OS.$out(/*KEEP_STR*/$SPACE);
      getOperand$Const(i).print(OS);
    }
    OS.$out(/*KEEP_STR*/$GT);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInst.cpp", line = 69,
   FQN="llvm::MCInst::dump", NM="_ZNK4llvm6MCInst4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm6MCInst4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
    dbgs().$out(/*KEEP_STR*/$LF);
  }


  
  /// \brief Dump the MCInst as prettily as possible using the additional MC
  /// structures, if given. Operators are separated by the \p Separator
  /// string.
  
  /// \brief Dump the MCInst as prettily as possible using the additional MC
  /// structures, if given. Operators are separated by the \p Separator
  /// string.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::dump_pretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInst.cpp", line = 53,
   FQN="llvm::MCInst::dump_pretty", NM="_ZNK4llvm6MCInst11dump_prettyERNS_11raw_ostreamEPKNS_13MCInstPrinterENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm6MCInst11dump_prettyERNS_11raw_ostreamEPKNS_13MCInstPrinterENS_9StringRefE")
  //</editor-fold>
  public void dump_pretty(final raw_ostream /*&*/ OS) /*const*/ {
    dump_pretty(OS, (/*const*/ MCInstPrinter /*P*/ )null, 
             new StringRef(/*KEEP_STR*/$SPACE));
  }
  public void dump_pretty(final raw_ostream /*&*/ OS, /*const*/ MCInstPrinter /*P*/ Printer/*= null*/) /*const*/ {
    dump_pretty(OS, Printer, 
             new StringRef(/*KEEP_STR*/$SPACE));
  }
  public void dump_pretty(final raw_ostream /*&*/ OS, /*const*/ MCInstPrinter /*P*/ Printer/*= null*/, 
             StringRef Separator/*= " "*/) /*const*/ {
    OS.$out(/*KEEP_STR*/"<MCInst #").$out_uint(getOpcode());
    
    // Show the instruction opcode name if we have access to a printer.
    if ((Printer != null)) {
      OS.$out_char($$SPACE).$out(Printer.getOpcodeName(getOpcode()));
    }
    
    for (/*uint*/int i = 0, e = getNumOperands(); i != e; ++i) {
      OS.$out(/*NO_COPY*/Separator);
      getOperand$Const(i).print(OS);
    }
    OS.$out(/*KEEP_STR*/$GT);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::MCInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 150,
   FQN="llvm::MCInst::MCInst", NM="_ZN4llvm6MCInstC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInstC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCInst(final /*const*/ MCInst /*&*/ $Prm0) {
    // : Opcode(.Opcode), Loc(.Loc), Operands(.Operands) 
    //START JInit
    this.Opcode = $Prm0.Opcode;
    this.Loc = new SMLoc($Prm0.Loc);
    this.Operands = new SmallVector<MCOperand>($Prm0.Operands);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::~MCInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 150,
   FQN="llvm::MCInst::~MCInst", NM="_ZN4llvm6MCInstD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInstD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Operands.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCInst::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 150,
   FQN="llvm::MCInst::operator=", NM="_ZN4llvm6MCInstaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_ZN4llvm6MCInstaSERKS0_")
  //</editor-fold>
  public /*inline*/ MCInst /*&*/ $assign(final /*const*/ MCInst /*&*/ $Prm0) {
    this.Opcode = $Prm0.Opcode;
    this.Loc.$assign($Prm0.Loc);
    this.Operands.$assign($Prm0.Operands);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Opcode=" + Opcode // NOI18N
              + ", Loc=" + Loc // NOI18N
              + ", Operands=" + Operands; // NOI18N
  }
}
