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
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;
import static org.llvm.support.AdtsupportLlvmGlobals.toIRString;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2056,
 FQN="(anonymous namespace)::AssemblyWriter", NM="_ZN12_GLOBAL__N_114AssemblyWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriterE")
//</editor-fold>
public class AssemblyWriter implements Destructors.ClassWithDestructor {
  private final formatted_raw_ostream /*&*/ Out;
  private /*const*/ Module /*P*/ TheModule;
  private std.unique_ptr<SlotTracker> SlotTrackerStorage;
  private final SlotTracker /*&*/ Machine;
  private TypePrinting TypePrinter;
  private AssemblyAnnotationWriter /*P*/ AnnotationWriter;
  private SetVector</*const*/ Comdat /*P*/ > Comdats;
  private boolean IsForDebug;
  private boolean ShouldPreserveUseListOrder;
  private std.vector<UseListOrder> UseListOrders;
  private SmallVector<StringRef> MDNames;
/*public:*/
  /// Construct an AssemblyWriter with an external SlotTracker
  // namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::AssemblyWriter">
  @Converted(kind = Converted.Kind.MANUAL/*use supplier*/,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2121,
   FQN="(anonymous namespace)::AssemblyWriter::AssemblyWriter", NM="_ZN12_GLOBAL__N_114AssemblyWriterC1ERN4llvm21formatted_raw_ostreamERNS1_11SlotTrackerEPKNS1_6ModuleEPNS1_24AssemblyAnnotationWriterEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriterC1ERN4llvm21formatted_raw_ostreamERNS1_11SlotTrackerEPKNS1_6ModuleEPNS1_24AssemblyAnnotationWriterEbb")
  //</editor-fold>
  public AssemblyWriter(final formatted_raw_ostream /*&*/ o, final SlotTracker /*&*/ Mac, 
      /*const*/ Module /*P*/ M, AssemblyAnnotationWriter /*P*/ AAW, 
      boolean IsForDebug) {
    this(o, Mac, 
      M, AAW, 
      IsForDebug, false);
  }
  public AssemblyWriter(final formatted_raw_ostream /*&*/ o, final SlotTracker /*&*/ Mac, 
      /*const*/ Module /*P*/ M, AssemblyAnnotationWriter /*P*/ AAW, 
      boolean IsForDebug, boolean ShouldPreserveUseListOrder/*= false*/) {
    // : Out(o), TheModule(M), SlotTrackerStorage(), Machine(Mac), TypePrinter(), AnnotationWriter(AAW), Comdats(), IsForDebug(IsForDebug), ShouldPreserveUseListOrder(ShouldPreserveUseListOrder), UseListOrders(), MDNames() 
    //START JInit
    this./*&*/Out=/*&*/o;
    this.TheModule = M;
    this.SlotTrackerStorage = new std.unique_ptr<SlotTracker>();
    this./*&*/Machine=/*&*/Mac;
    this.TypePrinter = new TypePrinting();
    this.AnnotationWriter = AAW;
    this.Comdats = new SetVector</*const*/ Comdat /*P*/ >((/*const*/ Comdat /*P*/ )null);
    this.IsForDebug = IsForDebug;
    this.ShouldPreserveUseListOrder = ShouldPreserveUseListOrder;
    this.UseListOrders = new std.vector<UseListOrder>(()->new UseListOrder());
    this.MDNames = new SmallVector<StringRef>(8, new StringRef());
    //END JInit
    if (!(TheModule != null)) {
      return;
    }
    TypePrinter.incorporateTypes($Deref(TheModule));
    for (final /*const*/ GlobalObject /*&*/ GO : TheModule.global_objects$Const())  {
      {
        /*const*/ Comdat /*P*/ C = GO.getComdat$Const();
        if ((C != null)) {
          Comdats.insert(C);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printMDNodeBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3235,
   FQN="(anonymous namespace)::AssemblyWriter::printMDNodeBody", NM="_ZN12_GLOBAL__N_114AssemblyWriter15printMDNodeBodyEPKN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter15printMDNodeBodyEPKN4llvm6MDNodeE")
  //</editor-fold>
  public void printMDNodeBody(/*const*/ MDNode /*P*/ Node) {
    AsmWriterStatics.WriteMDNodeBodyInternal(Out, Node, $AddrOf(TypePrinter), $AddrOf(Machine), TheModule);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printNamedMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2345,
   FQN="(anonymous namespace)::AssemblyWriter::printNamedMDNode", NM="_ZN12_GLOBAL__N_114AssemblyWriter16printNamedMDNodeEPKN4llvm11NamedMDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter16printNamedMDNodeEPKN4llvm11NamedMDNodeE")
  //</editor-fold>
  public void printNamedMDNode(/*const*/ NamedMDNode /*P*/ NMD) {
    Out.$out_char($$EXCLAMATION);
    AsmWriterStatics.printMetadataIdentifier(NMD.getName(), Out);
    Out.$out(/*KEEP_STR*/" = !{");
    for (/*uint*/int i = 0, e = NMD.getNumOperands(); i != e; ++i) {
      if ((i != 0)) {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      int Slot = Machine.getMetadataSlot(NMD.getOperand(i));
      if (Slot == -1) {
        Out.$out(/*KEEP_STR*/"<badref>");
      } else {
        Out.$out_char($$EXCLAMATION).$out_int(Slot);
      }
    }
    Out.$out(/*KEEP_STR*/"}\n");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2229,
   FQN="(anonymous namespace)::AssemblyWriter::printModule", NM="_ZN12_GLOBAL__N_114AssemblyWriter11printModuleEPKN4llvm6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter11printModuleEPKN4llvm6ModuleE")
  //</editor-fold>
  public void printModule(/*const*/ Module /*P*/ M) {
    Machine.initialize();
    if (ShouldPreserveUseListOrder) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(UseListOrders.$assignMove($c$.track(AsmWriterStatics.predictUseListOrder(M))));
      } finally {
        $c$.$destroy();
      }
    }
    if (!M.getModuleIdentifier().empty()
      // Don't print the ID if it will start a new line (which would
      // require a comment char before it).
       && M.getModuleIdentifier().find_T_size_type$_CharT($$LF) == std.string.npos) {
      Out.$out(/*KEEP_STR*/"; ModuleID = '").$out(M.getModuleIdentifier()).$out(/*KEEP_STR*/"'\n");
    }
    if (!M.getSourceFileName().empty()) {
      Out.$out(/*KEEP_STR*/"source_filename = \"");
      AsmWriterStatics.PrintEscapedString(new StringRef(M.getSourceFileName()), Out);
      Out.$out(/*KEEP_STR*/$QUOTE_LF);
    }
    
    final /*const*/std.string/*&*/ DL = M.getDataLayoutStr();
    if (!DL.empty()) {
      Out.$out(/*KEEP_STR*/"target datalayout = \"").$out(DL).$out(/*KEEP_STR*/$QUOTE_LF);
    }
    if (!M.getTargetTriple().empty()) {
      Out.$out(/*KEEP_STR*/"target triple = \"").$out(M.getTargetTriple()).$out(/*KEEP_STR*/$QUOTE_LF);
    }
    if (!M.getModuleInlineAsm().empty()) {
      Out.$out_char($$LF);
      
      // Split the string into lines, to make it easier to read the .ll file.
      StringRef Asm = new StringRef(M.getModuleInlineAsm());
      do {
        StringRef Front/*J*/= new StringRef();
        std.tie(Front, Asm).$assign(Asm.split($$LF));
        
        // We found a newline, print the portion of the asm string from the
        // last newline up to this newline.
        Out.$out(/*KEEP_STR*/"module asm \"");
        AsmWriterStatics.PrintEscapedString(new StringRef(Front), Out);
        Out.$out(/*KEEP_STR*/$QUOTE_LF);
      } while (!Asm.empty());
    }
    
    printTypeIdentities();
    
    // Output all comdats.
    if (!Comdats.empty()) {
      Out.$out_char($$LF);
    }
    for (/*const*/ Comdat /*P*/ C : Comdats) {
      printComdat(C);
      if (C != Comdats.back()) {
        Out.$out_char($$LF);
      }
    }
    
    // Output all globals.
    if (!M.global_empty()) {
      Out.$out_char($$LF);
    }
    for (final /*const*/ GlobalVariable /*&*/ GV : M.globals$Const()) {
      printGlobal($AddrOf(GV));
      Out.$out_char($$LF);
    }
    
    // Output all aliases.
    if (!M.alias_empty()) {
      Out.$out(/*KEEP_STR*/$LF);
    }
    for (final /*const*/ GlobalAlias /*&*/ GA : M.aliases$Const())  {
      printIndirectSymbol($AddrOf(GA));
    }
    
    // Output all ifuncs.
    if (!M.ifunc_empty()) {
      Out.$out(/*KEEP_STR*/$LF);
    }
    for (final /*const*/ GlobalIFunc /*&*/ GI : M.ifuncs$Const())  {
      printIndirectSymbol($AddrOf(GI));
    }
    
    // Output global use-lists.
    printUseLists((/*const*/ Function /*P*/ )null);
    
    // Output all of the functions.
    for (final /*const*/ Function /*&*/ F : $Deref(M))  {
      printFunction($AddrOf(F));
    }
    assert (UseListOrders.empty()) : "All use-lists should have been consumed";
    
    // Output all attribute groups.
    if (!Machine.as_empty()) {
      Out.$out_char($$LF);
      writeAllAttributeGroups();
    }
    
    // Output named metadata.
    if (!M.named_metadata_empty()) {
      Out.$out_char($$LF);
    }
    
    for (final /*const*/ NamedMDNode /*&*/ Node : M.named_metadata$Const())  {
      printNamedMDNode($AddrOf(Node));
    }
    
    // Output metadata.
    if (!Machine.mdn_empty()) {
      Out.$out_char($$LF);
      writeAllMDNodes();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::writeOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2135,
   FQN="(anonymous namespace)::AssemblyWriter::writeOperand", NM="_ZN12_GLOBAL__N_114AssemblyWriter12writeOperandEPKN4llvm5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter12writeOperandEPKN4llvm5ValueEb")
  //</editor-fold>
  public void writeOperand(/*const*/ Value /*P*/ Operand, boolean PrintType) {
    if (!(Operand != null)) {
      Out.$out(/*KEEP_STR*/"<null operand!>");
      return;
    }
    if (PrintType) {
      TypePrinter.print(Operand.getType(), Out);
      Out.$out_char($$SPACE);
    }
    AsmWriterStatics.WriteAsOperandInternal(Out, Operand, $AddrOf(TypePrinter), $AddrOf(Machine), TheModule);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::writeParamOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2175,
   FQN="(anonymous namespace)::AssemblyWriter::writeParamOperand", NM="_ZN12_GLOBAL__N_114AssemblyWriter17writeParamOperandEPKN4llvm5ValueENS1_12AttributeSetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter17writeParamOperandEPKN4llvm5ValueENS1_12AttributeSetEj")
  //</editor-fold>
  public void writeParamOperand(/*const*/ Value /*P*/ Operand, 
                   AttributeSet Attrs, /*uint*/int Idx) {
    if (!(Operand != null)) {
      Out.$out(/*KEEP_STR*/"<null operand!>");
      return;
    }
    
    // Print the type
    TypePrinter.print(Operand.getType(), Out);
    // Print parameter attributes list
    if (Attrs.hasAttributes(Idx)) {
      Out.$out_char($$SPACE).$out(Attrs.getAsString(Idx));
    }
    Out.$out_char($$SPACE);
    // Print the operand
    AsmWriterStatics.WriteAsOperandInternal(Out, Operand, $AddrOf(TypePrinter), $AddrOf(Machine), TheModule);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::writeOperandBundles">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2192,
   FQN="(anonymous namespace)::AssemblyWriter::writeOperandBundles", NM="_ZN12_GLOBAL__N_114AssemblyWriter19writeOperandBundlesEN4llvm17ImmutableCallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter19writeOperandBundlesEN4llvm17ImmutableCallSiteE")
  //</editor-fold>
  public void writeOperandBundles(ImmutableCallSite CS) {
    if (!CS.hasOperandBundles()) {
      return;
    }
    
    Out.$out(/*KEEP_STR*/" [ ");
    
    boolean FirstBundle = true;
    for (/*uint*/int i = 0, e = CS.getNumOperandBundles(); i != e; ++i) {
      OperandBundleUse BU = CS.getOperandBundleAt(i);
      if (!FirstBundle) {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      FirstBundle = false;
      
      Out.$out_char($$DBL_QUOTE);
      AsmWriterStatics.PrintEscapedString(BU.getTagName(), Out);
      Out.$out_char($$DBL_QUOTE);
      
      Out.$out_char($$LPAREN);
      
      boolean FirstInput = true;
      for (final /*const*/ Use /*&*/ Input : BU.Inputs) {
        if (!FirstInput) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        FirstInput = false;
        
        TypePrinter.print(Input.$arrow$Const().getType(), Out);
        Out.$out(/*KEEP_STR*/$SPACE);
        AsmWriterStatics.WriteAsOperandInternal(Out, Input.$Value$P(), $AddrOf(TypePrinter), $AddrOf(Machine), TheModule);
      }
      
      Out.$out_char($$RPAREN);
    }
    
    Out.$out(/*KEEP_STR*/" ]");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::writeAtomic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2147,
   FQN="(anonymous namespace)::AssemblyWriter::writeAtomic", NM="_ZN12_GLOBAL__N_114AssemblyWriter11writeAtomicEN4llvm14AtomicOrderingENS1_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter11writeAtomicEN4llvm14AtomicOrderingENS1_20SynchronizationScopeE")
  //</editor-fold>
  public void writeAtomic(AtomicOrdering Ordering, 
             SynchronizationScope SynchScope) {
    if (Ordering == AtomicOrdering.NotAtomic) {
      return;
    }
    switch (SynchScope) {
     case SingleThread:
      Out.$out(/*KEEP_STR*/" singlethread");
      break;
     case CrossThread:
      break;
    }
    
    Out.$out(/*KEEP_STR*/$SPACE).$out(toIRString(Ordering));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::writeAtomicCmpXchg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2160,
   FQN="(anonymous namespace)::AssemblyWriter::writeAtomicCmpXchg", NM="_ZN12_GLOBAL__N_114AssemblyWriter18writeAtomicCmpXchgEN4llvm14AtomicOrderingES2_NS1_20SynchronizationScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter18writeAtomicCmpXchgEN4llvm14AtomicOrderingES2_NS1_20SynchronizationScopeE")
  //</editor-fold>
  public void writeAtomicCmpXchg(AtomicOrdering SuccessOrdering, 
                    AtomicOrdering FailureOrdering, 
                    SynchronizationScope SynchScope) {
    assert (SuccessOrdering != AtomicOrdering.NotAtomic && FailureOrdering != AtomicOrdering.NotAtomic);
    switch (SynchScope) {
     case SingleThread:
      Out.$out(/*KEEP_STR*/" singlethread");
      break;
     case CrossThread:
      break;
    }
    
    Out.$out(/*KEEP_STR*/$SPACE).$out(toIRString(SuccessOrdering));
    Out.$out(/*KEEP_STR*/$SPACE).$out(toIRString(FailureOrdering));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::writeAllMDNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3223,
   FQN="(anonymous namespace)::AssemblyWriter::writeAllMDNodes", NM="_ZN12_GLOBAL__N_114AssemblyWriter15writeAllMDNodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter15writeAllMDNodesEv")
  //</editor-fold>
  public void writeAllMDNodes() {
    SmallVector</*const*/ MDNode /*P*/ > Nodes/*J*/= new SmallVector</*const*/ MDNode /*P*/ >(16, (/*const*/ MDNode /*P*/ )null);
    Nodes.resize(Machine.mdn_size());
    for (DenseMapIteratorTypeUInt</*const*/ MDNode /*P*/ /*P*/> I = Machine.mdn_begin(), E = Machine.mdn_end();
         I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
      Nodes.$set(I.$arrow().second, cast_MDNode(I.$arrow().first));
    }
    
    for (/*uint*/int i = 0, e = Nodes.size(); i != e; ++i) {
      writeMDNode(i, Nodes.$at(i));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::writeMDNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3217,
   FQN="(anonymous namespace)::AssemblyWriter::writeMDNode", NM="_ZN12_GLOBAL__N_114AssemblyWriter11writeMDNodeEjPKN4llvm6MDNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter11writeMDNodeEjPKN4llvm6MDNodeE")
  //</editor-fold>
  public void writeMDNode(/*uint*/int Slot, /*const*/ MDNode /*P*/ Node) {
    Out.$out_char($$EXCLAMATION).$out_uint(Slot).$out(/*KEEP_STR*/" = ");
    printMDNodeBody(Node);
    Out.$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::writeAllAttributeGroups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3239,
   FQN="(anonymous namespace)::AssemblyWriter::writeAllAttributeGroups", NM="_ZN12_GLOBAL__N_114AssemblyWriter23writeAllAttributeGroupsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter23writeAllAttributeGroupsEv")
  //</editor-fold>
  public void writeAllAttributeGroups() {
    std.vector<std.pairTypeUInt<AttributeSet>> asVec = null;
    try {
      asVec/*J*/= new std.vector<std.pairTypeUInt<AttributeSet>>(new std.pairTypeUInt<AttributeSet>());
      asVec.resize(Machine.as_size());
      
      for (DenseMapIteratorTypeUInt<AttributeSet> I = Machine.as_begin(), E = Machine.as_end();
           I.$noteq(/*NO_ITER_COPY*/E); I.$preInc())  {
        asVec.$at(I.$arrow().second).$assign(I.$star());
      }
      
      for (final /*const*/std.pairTypeUInt<AttributeSet> /*&*/ I : asVec)  {
        Out.$out(/*KEEP_STR*/"attributes #").$out_uint(I.second).$out(/*KEEP_STR*/" = { ").$out(
            I.first.getAsString(AttributeSet.AttrIndex.FunctionIndex.getValue(), true)
        ).$out(/*KEEP_STR*/" }\n");
      }
    } finally {
      if (asVec != null) { asVec.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printTypeIdentities">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2545,
   FQN="(anonymous namespace)::AssemblyWriter::printTypeIdentities", NM="_ZN12_GLOBAL__N_114AssemblyWriter19printTypeIdentitiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter19printTypeIdentitiesEv")
  //</editor-fold>
  public void printTypeIdentities() {
    std.vector<StructType /*P*/ > NumberedTypes = null;
    try {
      if (TypePrinter.NumberedTypes.empty()
         && TypePrinter.NamedTypes.empty()) {
        return;
      }
      
      Out.$out_char($$LF);
      
      // We know all the numbers that each type is used and we know that it is a
      // dense assignment.  Convert the map to an index table.
      NumberedTypes/*J*/= new std.vector<StructType /*P*/ >(TypePrinter.NumberedTypes.size(), (StructType /*P*/ )null);
      for (DenseMapIteratorTypeUInt<StructType /*P*/ /*P*/> I = TypePrinter.NumberedTypes.begin(), E = TypePrinter.NumberedTypes.end();
           I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
        assert ($less_uint(I.$arrow().second, NumberedTypes.size())) : "Didn't get a dense numbering?";
        NumberedTypes.$set(I.$arrow().second, I.$arrow().first);
      }
      
      // Emit all numbered types.
      for (/*uint*/int i = 0, e = NumberedTypes.size(); i != e; ++i) {
        Out.$out_char($$PERCENT).$out_uint(i).$out(/*KEEP_STR*/" = type ");
        
        // Make sure we print out at least one level of the type structure, so
        // that we do not get %2 = type %2
        TypePrinter.printStructBody(NumberedTypes.$at(i), Out);
        Out.$out_char($$LF);
      }
      
      for (/*uint*/int i = 0, e = TypePrinter.NamedTypes.size(); i != e; ++i) {
        AsmWriterStatics.PrintLLVMName(Out, TypePrinter.NamedTypes.$at(i).getName(), PrefixType.LocalPrefix);
        Out.$out(/*KEEP_STR*/" = type ");
        
        // Make sure we print out at least one level of the type structure, so
        // that we do not get %FILE = type %FILE
        TypePrinter.printStructBody(TypePrinter.NamedTypes.$at(i), Out);
        Out.$out_char($$LF);
      }
    } finally {
      if (NumberedTypes != null) { NumberedTypes.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2457,
   FQN="(anonymous namespace)::AssemblyWriter::printGlobal", NM="_ZN12_GLOBAL__N_114AssemblyWriter11printGlobalEPKN4llvm14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter11printGlobalEPKN4llvm14GlobalVariableE")
  //</editor-fold>
  public void printGlobal(/*const*/ GlobalVariable /*P*/ GV) {
    if (GV.isMaterializable()) {
      Out.$out(/*KEEP_STR*/"; Materializable\n");
    }
    
    AsmWriterStatics.WriteAsOperandInternal(Out, GV, $AddrOf(TypePrinter), $AddrOf(Machine), GV.getParent$Const());
    Out.$out(/*KEEP_STR*/" = ");
    if (!GV.hasInitializer() && GV.hasExternalLinkage()) {
      Out.$out(/*KEEP_STR*/"external ");
    }
    
    Out.$out(AsmWriterStatics.getLinkagePrintName(GV.getLinkage()));
    AsmWriterStatics.PrintVisibility(GV.getVisibility(), Out);
    AsmWriterStatics.PrintDLLStorageClass(GV.getDLLStorageClass(), Out);
    AsmWriterStatics.PrintThreadLocalModel(GV.getThreadLocalMode(), Out);
    StringRef UA = AsmWriterStatics.getUnnamedAddrEncoding(GV.getUnnamedAddr());
    if (!UA.empty()) {
      Out.$out(/*NO_COPY*/UA).$out_char($$SPACE);
    }
    {
      
      /*uint*/int AddressSpace = GV.getType().getAddressSpace();
      if ((AddressSpace != 0)) {
        Out.$out(/*KEEP_STR*/"addrspace(").$out_uint(AddressSpace).$out(/*KEEP_STR*/") ");
      }
    }
    if (GV.isExternallyInitialized()) {
      Out.$out(/*KEEP_STR*/"externally_initialized ");
    }
    Out.$out((GV.isConstant() ? $("constant ") : $("global ")));
    TypePrinter.print(GV.getValueType(), Out);
    if (GV.hasInitializer()) {
      Out.$out_char($$SPACE);
      writeOperand(GV.getInitializer$Const(), false);
    }
    if (GV.hasSection()) {
      Out.$out(/*KEEP_STR*/", section \"");
      AsmWriterStatics.PrintEscapedString(GV.getSection(), Out);
      Out.$out_char($$DBL_QUOTE);
    }
    AsmWriterStatics.maybePrintComdat(Out, $Deref(GV));
    if ((GV.getAlignment() != 0)) {
      Out.$out(/*KEEP_STR*/", align ").$out_uint(GV.getAlignment());
    }
    
    SmallVector<std.pairUIntPtr<MDNode /*P*/ >> MDs/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
    GV.getAllMetadata(MDs);
    printMetadataAttachments(MDs, new StringRef(/*KEEP_STR*/$COMMA_SPACE));
    
    printInfoComment($Deref(GV));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printIndirectSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2502,
   FQN="(anonymous namespace)::AssemblyWriter::printIndirectSymbol", NM="_ZN12_GLOBAL__N_114AssemblyWriter19printIndirectSymbolEPKN4llvm20GlobalIndirectSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter19printIndirectSymbolEPKN4llvm20GlobalIndirectSymbolE")
  //</editor-fold>
  public void printIndirectSymbol(/*const*/ GlobalIndirectSymbol /*P*/ GIS) {
    if (GIS.isMaterializable()) {
      Out.$out(/*KEEP_STR*/"; Materializable\n");
    }
    
    AsmWriterStatics.WriteAsOperandInternal(Out, GIS, $AddrOf(TypePrinter), $AddrOf(Machine), GIS.getParent$Const());
    Out.$out(/*KEEP_STR*/" = ");
    
    Out.$out(AsmWriterStatics.getLinkagePrintName(GIS.getLinkage()));
    AsmWriterStatics.PrintVisibility(GIS.getVisibility(), Out);
    AsmWriterStatics.PrintDLLStorageClass(GIS.getDLLStorageClass(), Out);
    AsmWriterStatics.PrintThreadLocalModel(GIS.getThreadLocalMode(), Out);
    StringRef UA = AsmWriterStatics.getUnnamedAddrEncoding(GIS.getUnnamedAddr());
    if (!UA.empty()) {
      Out.$out(/*NO_COPY*/UA).$out_char($$SPACE);
    }
    if (isa_GlobalAlias(GIS)) {
      Out.$out(/*KEEP_STR*/"alias ");
    } else if (isa_GlobalIFunc(GIS)) {
      Out.$out(/*KEEP_STR*/"ifunc ");
    } else {
      throw new llvm_unreachable("Not an alias or ifunc!");
    }
    
    TypePrinter.print(GIS.getValueType(), Out);
    
    Out.$out(/*KEEP_STR*/$COMMA_SPACE);
    
    /*const*/ Constant /*P*/ IS = GIS.getIndirectSymbol$Const();
    if (!(IS != null)) {
      TypePrinter.print(GIS.getType(), Out);
      Out.$out(/*KEEP_STR*/" <<NULL ALIASEE>>");
    } else {
      writeOperand(IS, !isa_ConstantExpr(IS));
    }
    
    printInfoComment($Deref(GIS));
    Out.$out_char($$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printComdat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2541,
   FQN="(anonymous namespace)::AssemblyWriter::printComdat", NM="_ZN12_GLOBAL__N_114AssemblyWriter11printComdatEPKN4llvm6ComdatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter11printComdatEPKN4llvm6ComdatE")
  //</editor-fold>
  public void printComdat(/*const*/ Comdat /*P*/ C) {
    C.print(Out);
  }

  
  /// printFunction - Print all aspects of a function.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2585,
   FQN="(anonymous namespace)::AssemblyWriter::printFunction", NM="_ZN12_GLOBAL__N_114AssemblyWriter13printFunctionEPKN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter13printFunctionEPKN4llvm8FunctionE")
  //</editor-fold>
  public void printFunction(/*const*/ Function /*P*/ F) {
    // Print out the return type and name.
    Out.$out_char($$LF);
    if ((AnnotationWriter != null)) {
      AnnotationWriter.emitFunctionAnnot(F, Out);
    }
    if (F.isMaterializable()) {
      Out.$out(/*KEEP_STR*/"; Materializable\n");
    }
    
    final /*const*/ AttributeSet /*&*/ Attrs = F.getAttributes();
    if (Attrs.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
      AttributeSet AS = Attrs.getFnAttributes();
      std.string AttrStr/*J*/= new std.string();
      
      /*uint*/int Idx = 0;
      for (/*uint*/int E = AS.getNumSlots(); Idx != E; ++Idx)  {
        if (AS.getSlotIndex(Idx) == AttributeSet.AttrIndex.FunctionIndex.getValue()) {
          break;
        }
      }
      
      for (type$ptr<Attribute> I = $tryClone(AS.begin(Idx)), /*P*/ E = $tryClone(AS.end(Idx));
           $noteq_ptr(I, E); I.$preInc()) {
        Attribute Attr = new Attribute(I.$star());
        if (!Attr.isStringAttribute()) {
          if (!AttrStr.empty()) {
            AttrStr.$addassign_T($$SPACE);
          }
          AttrStr.$addassign(Attr.getAsString());
        }
      }
      if (!AttrStr.empty()) {
        Out.$out(/*KEEP_STR*/"; Function Attrs: ").$out(AttrStr).$out_char($$LF);
      }
    }
    
    Machine.incorporateFunction(F);
    if (F.isDeclaration()) {
      Out.$out(/*KEEP_STR*/"declare");
      SmallVector<std.pairUIntPtr<MDNode /*P*/ >> MDs/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
      F.getAllMetadata(MDs);
      printMetadataAttachments(MDs, new StringRef(/*KEEP_STR*/$SPACE));
      Out.$out_char($$SPACE);
    } else {
      Out.$out(/*KEEP_STR*/"define ");
    }
    
    Out.$out(AsmWriterStatics.getLinkagePrintName(F.getLinkage()));
    AsmWriterStatics.PrintVisibility(F.getVisibility(), Out);
    AsmWriterStatics.PrintDLLStorageClass(F.getDLLStorageClass(), Out);
    
    // Print the calling convention.
    if (F.getCallingConv() != CallingConv.C) {
      AsmWriterStatics.PrintCallingConv(F.getCallingConv(), Out);
      Out.$out(/*KEEP_STR*/$SPACE);
    }
    
    FunctionType /*P*/ FT = F.getFunctionType();
    if (Attrs.hasAttributes(AttributeSet.AttrIndex.ReturnIndex.getValue())) {
      Out.$out(Attrs.getAsString(AttributeSet.AttrIndex.ReturnIndex.getValue())).$out_char($$SPACE);
    }
    TypePrinter.print(F.getReturnType(), Out);
    Out.$out_char($$SPACE);
    AsmWriterStatics.WriteAsOperandInternal(Out, F, $AddrOf(TypePrinter), $AddrOf(Machine), F.getParent$Const());
    Out.$out_char($$LPAREN);
    
    // Loop over the arguments, printing them...
    if (F.isDeclaration() && !IsForDebug) {
      // We're only interested in the type here - don't print argument names.
      for (/*uint*/int I = 0, E = FT.getNumParams(); I != E; ++I) {
        // Insert commas as we go... the first arg doesn't get a comma
        if ((I != 0)) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        // Output type...
        TypePrinter.print(FT.getParamType(I), Out);
        if (Attrs.hasAttributes(I + 1)) {
          Out.$out_char($$SPACE).$out(Attrs.getAsString(I + 1));
        }
      }
    } else {
      // The arguments are meaningful here, print them in detail.
      /*uint*/int Idx = 1;
      for (final /*const*/ Argument /*&*/ Arg : F.args$Const()) {
        // Insert commas as we go... the first arg doesn't get a comma
        if (Idx != 1) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        printArgument($AddrOf(Arg), new AttributeSet(Attrs), Idx++);
      }
    }
    
    // Finish printing arguments...
    if (FT.isVarArg()) {
      if ((FT.getNumParams() != 0)) {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      Out.$out(/*KEEP_STR*/$ELLIPSIS); // Output varargs portion of signature!
    }
    Out.$out_char($$RPAREN);
    StringRef UA = AsmWriterStatics.getUnnamedAddrEncoding(F.getUnnamedAddr());
    if (!UA.empty()) {
      Out.$out_char($$SPACE).$out(/*NO_COPY*/UA);
    }
    if (Attrs.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
      Out.$out(/*KEEP_STR*/" #").$out_int(Machine.getAttributeGroupSlot(Attrs.getFnAttributes()));
    }
    if (F.hasSection()) {
      Out.$out(/*KEEP_STR*/" section \"");
      AsmWriterStatics.PrintEscapedString(F.getSection(), Out);
      Out.$out_char($$DBL_QUOTE);
    }
    AsmWriterStatics.maybePrintComdat(Out, $Deref(F));
    if ((F.getAlignment() != 0)) {
      Out.$out(/*KEEP_STR*/" align ").$out_uint(F.getAlignment());
    }
    if (F.hasGC()) {
      Out.$out(/*KEEP_STR*/" gc \"").$out(F.getGC()).$out_char($$DBL_QUOTE);
    }
    if (F.hasPrefixData()) {
      Out.$out(/*KEEP_STR*/" prefix ");
      writeOperand(F.getPrefixData(), true);
    }
    if (F.hasPrologueData()) {
      Out.$out(/*KEEP_STR*/" prologue ");
      writeOperand(F.getPrologueData(), true);
    }
    if (F.hasPersonalityFn()) {
      Out.$out(/*KEEP_STR*/" personality ");
      writeOperand(F.getPersonalityFn(), /*PrintType=*/ true);
    }
    if (F.isDeclaration()) {
      Out.$out_char($$LF);
    } else {
      SmallVector<std.pairUIntPtr<MDNode /*P*/ >> MDs/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
      F.getAllMetadata(MDs);
      printMetadataAttachments(MDs, new StringRef(/*KEEP_STR*/$SPACE));
      
      Out.$out(/*KEEP_STR*/" {");
      // Output all of the function's basic blocks.
      for (final /*const*/ BasicBlock /*&*/ BB : $Deref(F))  {
        printBasicBlock($AddrOf(BB));
      }
      
      // Output the function's use-lists.
      printUseLists(F);
      
      Out.$out(/*KEEP_STR*/"}\n");
    }
    
    Machine.purgeFunction();
  }

  
  /// printArgument - This member is called for every argument that is passed into
  /// the function.  Simply print it out
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2728,
   FQN="(anonymous namespace)::AssemblyWriter::printArgument", NM="_ZN12_GLOBAL__N_114AssemblyWriter13printArgumentEPKN4llvm8ArgumentENS1_12AttributeSetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter13printArgumentEPKN4llvm8ArgumentENS1_12AttributeSetEj")
  //</editor-fold>
  public void printArgument(/*const*/ Argument /*P*/ Arg, 
               AttributeSet Attrs, /*uint*/int Idx) {
    // Output type...
    TypePrinter.print(Arg.getType(), Out);
    
    // Output parameter attributes list
    if (Attrs.hasAttributes(Idx)) {
      Out.$out_char($$SPACE).$out(Attrs.getAsString(Idx));
    }
    
    // Output name, if available...
    if (Arg.hasName()) {
      Out.$out_char($$SPACE);
      AsmWriterStatics.PrintLLVMName(Out, Arg);
    }
  }

  
  /// printBasicBlock - This member is called for each basic block in a method.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2746,
   FQN="(anonymous namespace)::AssemblyWriter::printBasicBlock", NM="_ZN12_GLOBAL__N_114AssemblyWriter15printBasicBlockEPKN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter15printBasicBlockEPKN4llvm10BasicBlockE")
  //</editor-fold>
  public void printBasicBlock(/*const*/ BasicBlock /*P*/ BB) {
    if (BB.hasName()) { // Print out the label if it exists...
      Out.$out(/*KEEP_STR*/$LF);
      AsmWriterStatics.PrintLLVMName(Out, BB.getName(), PrefixType.LabelPrefix);
      Out.$out_char($$COLON);
    } else if (!BB.use_empty()) { // Don't print block # of no uses...
      Out.$out(/*KEEP_STR*/"\n; <label>:");
      int Slot = Machine.getLocalSlot(BB);
      if (Slot != -1) {
        Out.$out_int(Slot).$out(/*KEEP_STR*/$COLON);
      } else {
        Out.$out(/*KEEP_STR*/"<badref>");
      }
    }
    if (!(BB.getParent$Const() != null)) {
      Out.PadToColumn(50);
      Out.$out(/*KEEP_STR*/"; Error: Block without parent!");
    } else if (BB != $AddrOf(BB.getParent$Const().getEntryBlock$Const())) { // Not the entry block?
      // Output predecessors for the block.
      Out.PadToColumn(50);
      Out.$out(/*KEEP_STR*/$SEMI);
      PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > PI = IrLlvmGlobals.pred_begin_BasicBlock$C$P(BB);
      PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > PE = IrLlvmGlobals.pred_end_BasicBlock$C$P(BB);
      if (PI.$eq(PE)) {
        Out.$out(/*KEEP_STR*/" No predecessors!");
      } else {
        Out.$out(/*KEEP_STR*/" preds = ");
        writeOperand(PI.$star(), false);
        for (PI.$preInc(); PI.$noteq(PE); PI.$preInc()) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          writeOperand(PI.$star(), false);
        }
      }
    }
    
    Out.$out(/*KEEP_STR*/$LF);
    if ((AnnotationWriter != null)) {
      AnnotationWriter.emitBasicBlockStartAnnot(BB, Out);
    }
    
    // Output all of the instructions in the basic block...
    for (final /*const*/ Instruction /*&*/ I : $Deref(BB)) {
      printInstructionLine(I);
    }
    if ((AnnotationWriter != null)) {
      AnnotationWriter.emitBasicBlockEndAnnot(BB, Out);
    }
  }

  
  /// printInstructionLine - Print an instruction and a newline character.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printInstructionLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2794,
   FQN="(anonymous namespace)::AssemblyWriter::printInstructionLine", NM="_ZN12_GLOBAL__N_114AssemblyWriter20printInstructionLineERKN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter20printInstructionLineERKN4llvm11InstructionE")
  //</editor-fold>
  public void printInstructionLine(final /*const*/ Instruction /*&*/ I) {
    printInstruction(I);
    Out.$out_char($$LF);
  }

  
  // This member is called for each Instruction in a function..
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2821,
   FQN="(anonymous namespace)::AssemblyWriter::printInstruction", NM="_ZN12_GLOBAL__N_114AssemblyWriter16printInstructionERKN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter16printInstructionERKN4llvm11InstructionE")
  //</editor-fold>
  public void printInstruction(final /*const*/ Instruction /*&*/ I) {
    if ((AnnotationWriter != null)) {
      AnnotationWriter.emitInstructionAnnot($AddrOf(I), Out);
    }
    
    // Print out indentation for an instruction.
    Out.$out(/*KEEP_STR*/"  ");
    
    // Print out name if it exists...
    if (I.hasName()) {
      AsmWriterStatics.PrintLLVMName(Out, $AddrOf(I));
      Out.$out(/*KEEP_STR*/" = ");
    } else if (!I.getType().isVoidTy()) {
      // Print out the def slot taken.
      int SlotNum = Machine.getLocalSlot($AddrOf(I));
      if (SlotNum == -1) {
        Out.$out(/*KEEP_STR*/"<badref> = ");
      } else {
        Out.$out_char($$PERCENT).$out_int(SlotNum).$out(/*KEEP_STR*/" = ");
      }
    }
    {
      
      /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst($AddrOf(I));
      if ((CI != null)) {
        if (CI.isMustTailCall()) {
          Out.$out(/*KEEP_STR*/"musttail ");
        } else if (CI.isTailCall()) {
          Out.$out(/*KEEP_STR*/"tail ");
        } else if (CI.isNoTailCall()) {
          Out.$out(/*KEEP_STR*/"notail ");
        }
      }
    }
    
    // Print out the opcode...
    Out.$out(I.getOpcodeName());
    
    // If this is an atomic load or store, print out the atomic marker.
    if ((isa_LoadInst(I) && cast_LoadInst(I).isAtomic())
       || (isa_StoreInst(I) && cast_StoreInst(I).isAtomic())) {
      Out.$out(/*KEEP_STR*/" atomic");
    }
    if (isa_AtomicCmpXchgInst(I) && cast_AtomicCmpXchgInst(I).isWeak()) {
      Out.$out(/*KEEP_STR*/" weak");
    }
    
    // If this is a volatile operation, print out the volatile marker.
    if ((isa_LoadInst(I) && cast_LoadInst(I).isVolatile())
       || (isa_StoreInst(I) && cast_StoreInst(I).isVolatile())
       || (isa_AtomicCmpXchgInst(I) && cast_AtomicCmpXchgInst(I).isVolatile())
       || (isa_AtomicRMWInst(I) && cast_AtomicRMWInst(I).isVolatile())) {
      Out.$out(/*KEEP_STR*/" volatile");
    }
    
    // Print out optimization information.
    AsmWriterStatics.WriteOptimizationInfo(Out, $AddrOf(I));
    {
      
      // Print out the compare instruction predicates
      /*const*/ CmpInst /*P*/ CI = dyn_cast_CmpInst($AddrOf(I));
      if ((CI != null)) {
        Out.$out_char($$SPACE).$out(AsmWriterStatics.getPredicateText(CI.getPredicate().getValue()));
      }
    }
    {
      
      // Print out the atomicrmw operation
      /*const*/ AtomicRMWInst /*P*/ RMWI = dyn_cast_AtomicRMWInst($AddrOf(I));
      if ((RMWI != null)) {
        AsmWriterStatics.writeAtomicRMWOperation(Out, RMWI.getOperation());
      }
    }
    
    // Print out the type of the operands...
    /*const*/ Value /*P*/ Operand = (I.getNumOperands() != 0) ? I.getOperand(0) : null;
    
    // Special case conditional branches to swizzle the condition out to the front
    if (isa_BranchInst(I) && cast_BranchInst(I).isConditional()) {
      final /*const*/ BranchInst /*&*/ BI/*J*/= cast_BranchInst(I);
      Out.$out_char($$SPACE);
      writeOperand(BI.getCondition(), true);
      Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      writeOperand(BI.getSuccessor(0), true);
      Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      writeOperand(BI.getSuccessor(1), true);
    } else if (isa_SwitchInst(I)) {
      final /*const*/ SwitchInst /*&*/ SI/*J*/= cast_SwitchInst(I);
      // Special case switch instruction to get formatting nice and correct.
      Out.$out_char($$SPACE);
      writeOperand(SI.getCondition(), true);
      Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      writeOperand(SI.getDefaultDest(), true);
      Out.$out(/*KEEP_STR*/" [");
      for (SwitchInst.CaseIteratorT</*const*/ SwitchInst, /*const*/ ConstantInt, /*const*/ BasicBlock> i = SI.case_begin$Const(), e = SI.case_end$Const();
           i.$noteq(e); i.$preInc()) {
        Out.$out(/*KEEP_STR*/"\n    ");
        writeOperand(i.getCaseValue(), true);
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        writeOperand(i.getCaseSuccessor(), true);
      }
      Out.$out(/*KEEP_STR*/"\n  ]");
    } else if (isa_IndirectBrInst(I)) {
      // Special case indirectbr instruction to get formatting nice and correct.
      Out.$out_char($$SPACE);
      writeOperand(Operand, true);
      Out.$out(/*KEEP_STR*/", [");
      
      for (/*uint*/int i = 1, e = I.getNumOperands(); i != e; ++i) {
        if (i != 1) {
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        }
        writeOperand(I.getOperand(i), true);
      }
      Out.$out_char($$RSQUARE);
    } else {
      /*const*/ PHINode /*P*/ PN = dyn_cast_PHINode($AddrOf(I));
      if ((PN != null)) {
        Out.$out_char($$SPACE);
        TypePrinter.print(I.getType(), Out);
        Out.$out_char($$SPACE);
        
        for (/*uint*/int op = 0, Eop = PN.getNumIncomingValues(); $less_uint(op, Eop); ++op) {
          if ((op != 0)) {
            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          Out.$out(/*KEEP_STR*/"[ ");
          writeOperand(PN.getIncomingValue(op), false);
          Out.$out(/*KEEP_STR*/$COMMA_SPACE);
          writeOperand(PN.getIncomingBlock(op), false);
          Out.$out(/*KEEP_STR*/" ]");
        }
      } else {
        /*const*/ ExtractValueInst /*P*/ EVI = dyn_cast_ExtractValueInst($AddrOf(I));
        if ((EVI != null)) {
          Out.$out_char($$SPACE);
          writeOperand(I.getOperand(0), true);
          for (/*const*/uint$ptr/*uint P*/ i = $tryClone(EVI.idx_begin()), /*P*/ e = $tryClone(EVI.idx_end()); $noteq_ptr(i, e); i.$preInc())  {
            Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(i.$star());
          }
        } else {
          /*const*/ InsertValueInst /*P*/ IVI = dyn_cast_InsertValueInst($AddrOf(I));
          if ((IVI != null)) {
            Out.$out_char($$SPACE);
            writeOperand(I.getOperand(0), true);
            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
            writeOperand(I.getOperand(1), true);
            for (/*const*/uint$ptr/*uint P*/ i = $tryClone(IVI.idx_begin()), /*P*/ e = $tryClone(IVI.idx_end()); $noteq_ptr(i, e); i.$preInc())  {
              Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(i.$star());
            }
          } else {
            /*const*/ LandingPadInst /*P*/ LPI = dyn_cast_LandingPadInst($AddrOf(I));
            if ((LPI != null)) {
              Out.$out_char($$SPACE);
              TypePrinter.print(I.getType(), Out);
              if (LPI.isCleanup() || LPI.getNumClauses() != 0) {
                Out.$out_char($$LF);
              }
              if (LPI.isCleanup()) {
                Out.$out(/*KEEP_STR*/"          cleanup");
              }
              
              for (/*uint*/int i = 0, e = LPI.getNumClauses(); i != e; ++i) {
                if (i != 0 || LPI.isCleanup()) {
                  Out.$out(/*KEEP_STR*/$LF);
                }
                if (LPI.isCatch(i)) {
                  Out.$out(/*KEEP_STR*/"          catch ");
                } else {
                  Out.$out(/*KEEP_STR*/"          filter ");
                }
                
                writeOperand(LPI.getClause(i), true);
              }
            } else {
              /*const*/ CatchSwitchInst /*P*/ CatchSwitch = dyn_cast_CatchSwitchInst($AddrOf(I));
              if ((CatchSwitch != null)) {
                Out.$out(/*KEEP_STR*/" within ");
                writeOperand(CatchSwitch.getParentPad(), /*PrintType=*/ false);
                Out.$out(/*KEEP_STR*/" [");
                /*uint*/int Op = 0;
                for (/*const*/ BasicBlock /*P*/ PadBB : CatchSwitch.handlers$Const()) {
                  if ($greater_uint(Op, 0)) {
                    Out.$out(/*KEEP_STR*/$COMMA_SPACE);
                  }
                  writeOperand(PadBB, /*PrintType=*/ true);
                  ++Op;
                }
                Out.$out(/*KEEP_STR*/"] unwind ");
                {
                  /*const*/ BasicBlock /*P*/ UnwindDest = CatchSwitch.getUnwindDest();
                  if ((UnwindDest != null)) {
                    writeOperand(UnwindDest, /*PrintType=*/ true);
                  } else {
                    Out.$out(/*KEEP_STR*/"to caller");
                  }
                }
              } else {
                /*const*/ FuncletPadInst /*P*/ FPI = dyn_cast_FuncletPadInst($AddrOf(I));
                if ((FPI != null)) {
                  Out.$out(/*KEEP_STR*/" within ");
                  writeOperand(FPI.getParentPad(), /*PrintType=*/ false);
                  Out.$out(/*KEEP_STR*/" [");
                  for (/*uint*/int Op = 0, NumOps = FPI.getNumArgOperands(); $less_uint(Op, NumOps);
                       ++Op) {
                    if ($greater_uint(Op, 0)) {
                      Out.$out(/*KEEP_STR*/$COMMA_SPACE);
                    }
                    writeOperand(FPI.getArgOperand(Op), /*PrintType=*/ true);
                  }
                  Out.$out_char($$RSQUARE);
                } else if (isa_ReturnInst(I) && !(Operand != null)) {
                  Out.$out(/*KEEP_STR*/" void");
                } else {
                  /*const*/ CatchReturnInst /*P*/ CRI = dyn_cast_CatchReturnInst($AddrOf(I));
                  if ((CRI != null)) {
                    Out.$out(/*KEEP_STR*/" from ");
                    writeOperand(CRI.getOperand(0), /*PrintType=*/ false);
                    
                    Out.$out(/*KEEP_STR*/" to ");
                    writeOperand(CRI.getOperand(1), /*PrintType=*/ true);
                  } else {
                    /*const*/ CleanupReturnInst /*P*/ CRI$1 = dyn_cast_CleanupReturnInst($AddrOf(I));
                    if ((CRI$1 != null)) {
                      Out.$out(/*KEEP_STR*/" from ");
                      writeOperand(CRI$1.getOperand(0), /*PrintType=*/ false);
                      
                      Out.$out(/*KEEP_STR*/" unwind ");
                      if (CRI$1.hasUnwindDest()) {
                        writeOperand(CRI$1.getOperand(1), /*PrintType=*/ true);
                      } else {
                        Out.$out(/*KEEP_STR*/"to caller");
                      }
                    } else {
                      /*const*/ CallInst /*P*/ CI = dyn_cast_CallInst($AddrOf(I));
                      if ((CI != null)) {
                        // Print the calling convention being used.
                        if (CI.getCallingConv() != CallingConv.C) {
                          Out.$out(/*KEEP_STR*/$SPACE);
                          AsmWriterStatics.PrintCallingConv(CI.getCallingConv(), Out);
                        }
                        
                        Operand = CI.getCalledValue$Const();
                        FunctionType /*P*/ FTy = cast_FunctionType(CI.getFunctionType());
                        Type /*P*/ RetTy = FTy.getReturnType();
                        final /*const*/ AttributeSet /*&*/ PAL = CI.getAttributes();
                        if (PAL.hasAttributes(AttributeSet.AttrIndex.ReturnIndex.getValue())) {
                          Out.$out_char($$SPACE).$out(PAL.getAsString(AttributeSet.AttrIndex.ReturnIndex.getValue()));
                        }
                        
                        // If possible, print out the short form of the call instruction.  We can
                        // only do this if the first argument is a pointer to a nonvararg function,
                        // and if the return type is not a pointer to a function.
                        //
                        Out.$out_char($$SPACE);
                        TypePrinter.print(FTy.isVarArg() ? FTy : RetTy, Out);
                        Out.$out_char($$SPACE);
                        writeOperand(Operand, false);
                        Out.$out_char($$LPAREN);
                        for (/*uint*/int op = 0, Eop = CI.getNumArgOperands(); $less_uint(op, Eop); ++op) {
                          if ($greater_uint(op, 0)) {
                            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
                          }
                          writeParamOperand(CI.getArgOperand(op), new AttributeSet(PAL), op + 1);
                        }
                        
                        // Emit an ellipsis if this is a musttail call in a vararg function.  This
                        // is only to aid readability, musttail calls forward varargs by default.
                        if (CI.isMustTailCall() && (CI.getParent$Const() != null)
                           && (CI.getParent$Const().getParent$Const() != null)
                           && CI.getParent$Const().getParent$Const().isVarArg()) {
                          Out.$out(/*KEEP_STR*/", ...");
                        }
                        
                        Out.$out_char($$RPAREN);
                        if (PAL.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
                          Out.$out(/*KEEP_STR*/" #").$out_int(Machine.getAttributeGroupSlot(PAL.getFnAttributes()));
                        }
                        
                        writeOperandBundles(new ImmutableCallSite(CI));
                      } else {
                        /*const*/ InvokeInst /*P*/ II = dyn_cast_InvokeInst($AddrOf(I));
                        if ((II != null)) {
                          Operand = II.getCalledValue$Const();
                          FunctionType /*P*/ FTy = cast_FunctionType(II.getFunctionType());
                          Type /*P*/ RetTy = FTy.getReturnType();
                          final /*const*/ AttributeSet /*&*/ PAL = II.getAttributes();
                          
                          // Print the calling convention being used.
                          if (II.getCallingConv() != CallingConv.C) {
                            Out.$out(/*KEEP_STR*/$SPACE);
                            AsmWriterStatics.PrintCallingConv(II.getCallingConv(), Out);
                          }
                          if (PAL.hasAttributes(AttributeSet.AttrIndex.ReturnIndex.getValue())) {
                            Out.$out_char($$SPACE).$out(PAL.getAsString(AttributeSet.AttrIndex.ReturnIndex.getValue()));
                          }
                          
                          // If possible, print out the short form of the invoke instruction. We can
                          // only do this if the first argument is a pointer to a nonvararg function,
                          // and if the return type is not a pointer to a function.
                          //
                          Out.$out_char($$SPACE);
                          TypePrinter.print(FTy.isVarArg() ? FTy : RetTy, Out);
                          Out.$out_char($$SPACE);
                          writeOperand(Operand, false);
                          Out.$out_char($$LPAREN);
                          for (/*uint*/int op = 0, Eop = II.getNumArgOperands(); $less_uint(op, Eop); ++op) {
                            if ((op != 0)) {
                              Out.$out(/*KEEP_STR*/$COMMA_SPACE);
                            }
                            writeParamOperand(II.getArgOperand(op), new AttributeSet(PAL), op + 1);
                          }
                          
                          Out.$out_char($$RPAREN);
                          if (PAL.hasAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue())) {
                            Out.$out(/*KEEP_STR*/" #").$out_int(Machine.getAttributeGroupSlot(PAL.getFnAttributes()));
                          }
                          
                          writeOperandBundles(new ImmutableCallSite(II));
                          
                          Out.$out(/*KEEP_STR*/"\n          to ");
                          writeOperand(II.getNormalDest(), true);
                          Out.$out(/*KEEP_STR*/" unwind ");
                          writeOperand(II.getUnwindDest(), true);
                        } else {
                          /*const*/ AllocaInst /*P*/ AI = dyn_cast_AllocaInst($AddrOf(I));
                          if ((AI != null)) {
                            Out.$out_char($$SPACE);
                            if (AI.isUsedWithInAlloca()) {
                              Out.$out(/*KEEP_STR*/"inalloca ");
                            }
                            if (AI.isSwiftError()) {
                              Out.$out(/*KEEP_STR*/"swifterror ");
                            }
                            TypePrinter.print(AI.getAllocatedType(), Out);
                            
                            // Explicitly write the array size if the code is broken, if it's an array
                            // allocation, or if the type is not canonical for scalar allocations.  The
                            // latter case prevents the type from mutating when round-tripping through
                            // assembly.
                            if (!(AI.getArraySize$Const() != null) || AI.isArrayAllocation()
                               || !AI.getArraySize$Const().getType().isIntegerTy(32)) {
                              Out.$out(/*KEEP_STR*/$COMMA_SPACE);
                              writeOperand(AI.getArraySize$Const(), true);
                            }
                            if ((AI.getAlignment() != 0)) {
                              Out.$out(/*KEEP_STR*/", align ").$out_uint(AI.getAlignment());
                            }
                          } else if (isa_CastInst(I)) {
                            if ((Operand != null)) {
                              Out.$out_char($$SPACE);
                              writeOperand(Operand, true); // Work with broken code
                            }
                            Out.$out(/*KEEP_STR*/" to ");
                            TypePrinter.print(I.getType(), Out);
                          } else if (isa_VAArgInst(I)) {
                            if ((Operand != null)) {
                              Out.$out_char($$SPACE);
                              writeOperand(Operand, true); // Work with broken code
                            }
                            Out.$out(/*KEEP_STR*/$COMMA_SPACE);
                            TypePrinter.print(I.getType(), Out);
                          } else if ((Operand != null)) { // Print the normal way.
                            {
                              /*const*/ GetElementPtrInst /*P*/ GEP = dyn_cast_GetElementPtrInst($AddrOf(I));
                              if ((GEP != null)) {
                                Out.$out_char($$SPACE);
                                TypePrinter.print(GEP.getSourceElementType(), Out);
                                Out.$out_char($$COMMA);
                              } else {
                                /*const*/ LoadInst /*P*/ LI = dyn_cast_LoadInst($AddrOf(I));
                                if ((LI != null)) {
                                  Out.$out_char($$SPACE);
                                  TypePrinter.print(LI.getType(), Out);
                                  Out.$out_char($$COMMA);
                                }
                              }
                            }
                            
                            // PrintAllTypes - Instructions who have operands of all the same type
                            // omit the type from all but the first operand.  If the instruction has
                            // different type operands (for example br), then they are all printed.
                            boolean PrintAllTypes = false;
                            Type /*P*/ TheType = Operand.getType();
                            
                            // Select, Store and ShuffleVector always print all types.
                            if (isa_SelectInst(I) || isa_StoreInst(I) || isa_ShuffleVectorInst(I)
                               || isa_ReturnInst(I)) {
                              PrintAllTypes = true;
                            } else {
                              for (/*uint*/int i = 1, E = I.getNumOperands(); i != E; ++i) {
                                Operand = I.getOperand(i);
                                // note that Operand shouldn't be null, but the test helps make dump()
                                // more tolerant of malformed IR
                                if ((Operand != null) && Operand.getType() != TheType) {
                                  PrintAllTypes = true; // We have differing types!  Print them all!
                                  break;
                                }
                              }
                            }
                            if (!PrintAllTypes) {
                              Out.$out_char($$SPACE);
                              TypePrinter.print(TheType, Out);
                            }
                            
                            Out.$out_char($$SPACE);
                            for (/*uint*/int i = 0, E = I.getNumOperands(); i != E; ++i) {
                              if ((i != 0)) {
                                Out.$out(/*KEEP_STR*/$COMMA_SPACE);
                              }
                              writeOperand(I.getOperand(i), PrintAllTypes);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    {
      
      // Print atomic ordering/alignment for memory operations
      /*const*/ LoadInst /*P*/ LI = dyn_cast_LoadInst($AddrOf(I));
      if ((LI != null)) {
        if (LI.isAtomic()) {
          writeAtomic(LI.getOrdering(), LI.getSynchScope());
        }
        if ((LI.getAlignment() != 0)) {
          Out.$out(/*KEEP_STR*/", align ").$out_uint(LI.getAlignment());
        }
      } else {
        /*const*/ StoreInst /*P*/ SI = dyn_cast_StoreInst($AddrOf(I));
        if ((SI != null)) {
          if (SI.isAtomic()) {
            writeAtomic(SI.getOrdering(), SI.getSynchScope());
          }
          if ((SI.getAlignment() != 0)) {
            Out.$out(/*KEEP_STR*/", align ").$out_uint(SI.getAlignment());
          }
        } else {
          /*const*/ AtomicCmpXchgInst /*P*/ CXI = dyn_cast_AtomicCmpXchgInst($AddrOf(I));
          if ((CXI != null)) {
            writeAtomicCmpXchg(CXI.getSuccessOrdering(), CXI.getFailureOrdering(), 
                CXI.getSynchScope());
          } else {
            /*const*/ AtomicRMWInst /*P*/ RMWI = dyn_cast_AtomicRMWInst($AddrOf(I));
            if ((RMWI != null)) {
              writeAtomic(RMWI.getOrdering(), RMWI.getSynchScope());
            } else {
              /*const*/ FenceInst /*P*/ FI = dyn_cast_FenceInst($AddrOf(I));
              if ((FI != null)) {
                writeAtomic(FI.getOrdering(), FI.getSynchScope());
              }
            }
          }
        }
      }
    }
    
    // Print Metadata info.
    SmallVector<std.pairUIntPtr<MDNode /*P*/ >> InstMD/*J*/= new SmallVector<std.pairUIntPtr<MDNode /*P*/ >>(4, new std.pairUIntPtr<MDNode /*P*/ >());
    I.getAllMetadata(InstMD);
    printMetadataAttachments(InstMD, new StringRef(/*KEEP_STR*/$COMMA_SPACE));
    
    // Print a nice comment.
    printInfoComment(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printUseListOrder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3252,
   FQN="(anonymous namespace)::AssemblyWriter::printUseListOrder", NM="_ZN12_GLOBAL__N_114AssemblyWriter17printUseListOrderERKN4llvm12UseListOrderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter17printUseListOrderERKN4llvm12UseListOrderE")
  //</editor-fold>
  public void printUseListOrder(final /*const*/ UseListOrder /*&*/ Order) {
    boolean IsInFunction = (Machine.getFunction() != null);
    if (IsInFunction) {
      Out.$out(/*KEEP_STR*/"  ");
    }
    
    Out.$out(/*KEEP_STR*/"uselistorder");
    {
      /*const*/ BasicBlock /*P*/ BB = IsInFunction ? null : dyn_cast_BasicBlock(Order.V);
      if ((BB != null)) {
        Out.$out(/*KEEP_STR*/"_bb ");
        writeOperand(BB.getParent$Const(), false);
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
        writeOperand(BB, false);
      } else {
        Out.$out(/*KEEP_STR*/$SPACE);
        writeOperand(Order.V, true);
      }
    }
    Out.$out(/*KEEP_STR*/", { ");
    assert ($greatereq_uint(Order.Shuffle.size(), 2)) : "Shuffle too small";
    Out.$out_uint(Order.Shuffle.$at$Const(0));
    for (/*uint*/int I = 1, E = Order.Shuffle.size(); I != E; ++I)  {
      Out.$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(Order.Shuffle.$at$Const(I));
    }
    Out.$out(/*KEEP_STR*/" }\n");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printUseLists">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3277,
   FQN="(anonymous namespace)::AssemblyWriter::printUseLists", NM="_ZN12_GLOBAL__N_114AssemblyWriter13printUseListsEPKN4llvm8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter13printUseListsEPKN4llvm8FunctionE")
  //</editor-fold>
  public void printUseLists(/*const*/ Function /*P*/ F) {
    VoidBoolPredicate hasMore = /*[&, this, &F]*/ () -> {
          return !UseListOrders.empty() && UseListOrders.back().F == F;
        };
    if (!hasMore.$call()) {
      // Nothing to do.
      return;
    }
    
    Out.$out(/*KEEP_STR*/"\n; uselistorder directives\n");
    while (hasMore.$call()) {
      printUseListOrder(UseListOrders.back());
      UseListOrders.pop_back();
    }
  }

/*private:*/
  /// \brief Print out metadata attachments.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printMetadataAttachments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 3195,
   FQN="(anonymous namespace)::AssemblyWriter::printMetadataAttachments", NM="_ZN12_GLOBAL__N_114AssemblyWriter24printMetadataAttachmentsERKN4llvm15SmallVectorImplISt4pairIjPNS1_6MDNodeEEEENS1_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter24printMetadataAttachmentsERKN4llvm15SmallVectorImplISt4pairIjPNS1_6MDNodeEEEENS1_9StringRefE")
  //</editor-fold>
  private void printMetadataAttachments(final /*const*/ SmallVectorImpl<std.pairUIntPtr<MDNode /*P*/ > > /*&*/ MDs, 
                          StringRef Separator) {
    if (MDs.empty()) {
      return;
    }
    if (MDNames.empty()) {
      MDs.$at$Const(0).second.getContext().getMDKindNames(MDNames);
    }
    
    for (final /*const*/std.pairUIntPtr<MDNode /*P*/ > /*&*/ I : MDs) {
      /*uint*/int Kind = I.first;
      Out.$out(/*NO_COPY*/Separator);
      if ($less_uint(Kind, MDNames.size())) {
        Out.$out(/*KEEP_STR*/$EXCLAIM);
        AsmWriterStatics.printMetadataIdentifier(new StringRef(MDNames.$at(Kind)), Out);
      } else {
        Out.$out(/*KEEP_STR*/"!<unknown kind #").$out_uint(Kind).$out(/*KEEP_STR*/$GT);
      }
      Out.$out_char($$SPACE);
      AsmWriterStatics.WriteAsOperandInternal(Out, I.second, $AddrOf(TypePrinter), $AddrOf(Machine), TheModule);
    }
  }

  
  // printInfoComment - Print a little comment after the instruction indicating
  // which slot it occupies.
  
  /// printInfoComment - Print a little comment after the instruction indicating
  /// which slot it occupies.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printInfoComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2812,
   FQN="(anonymous namespace)::AssemblyWriter::printInfoComment", NM="_ZN12_GLOBAL__N_114AssemblyWriter16printInfoCommentERKN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter16printInfoCommentERKN4llvm5ValueE")
  //</editor-fold>
  private void printInfoComment(final /*const*/ Value /*&*/ V) {
    {
      /*const*/ GCRelocateInst /*P*/ Relocate = dyn_cast_GCRelocateInst($AddrOf(V));
      if ((Relocate != null)) {
        printGCRelocateComment($Deref(Relocate));
      }
    }
    if ((AnnotationWriter != null)) {
      AnnotationWriter.printInfoComment(V, Out);
    }
  }

  
  // printGCRelocateComment - print comment after call to the gc.relocate
  // intrinsic indicating base and derived pointer names.
  
  /// printGCRelocateComment - print comment after call to the gc.relocate
  /// intrinsic indicating base and derived pointer names.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::printGCRelocateComment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2801,
   FQN="(anonymous namespace)::AssemblyWriter::printGCRelocateComment", NM="_ZN12_GLOBAL__N_114AssemblyWriter22printGCRelocateCommentERKN4llvm14GCRelocateInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriter22printGCRelocateCommentERKN4llvm14GCRelocateInstE")
  //</editor-fold>
  private void printGCRelocateComment(final /*const*/ GCRelocateInst /*&*/ Relocate) {
    Out.$out(/*KEEP_STR*/" ; (");
    writeOperand(Relocate.getBasePtr(), false);
    Out.$out(/*KEEP_STR*/$COMMA_SPACE);
    writeOperand(Relocate.getDerivedPtr(), false);
    Out.$out(/*KEEP_STR*/$RPAREN);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AssemblyWriter::~AssemblyWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp", line = 2056,
   FQN="(anonymous namespace)::AssemblyWriter::~AssemblyWriter", NM="_ZN12_GLOBAL__N_114AssemblyWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/AsmWriter.cpp -nm=_ZN12_GLOBAL__N_114AssemblyWriterD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    MDNames.$destroy();
    UseListOrders.$destroy();
    Comdats.$destroy();
    TypePrinter.$destroy();
    SlotTrackerStorage.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Out=" + Out // NOI18N
              + ", TheModule=" + TheModule // NOI18N
              + ", SlotTrackerStorage=" + SlotTrackerStorage // NOI18N
              + ", Machine=" + Machine // NOI18N
              + ", TypePrinter=" + TypePrinter // NOI18N
              + ", AnnotationWriter=" + AnnotationWriter // NOI18N
              + ", Comdats=" + Comdats // NOI18N
              + ", IsForDebug=" + IsForDebug // NOI18N
              + ", ShouldPreserveUseListOrder=" + ShouldPreserveUseListOrder // NOI18N
              + ", UseListOrders=" + UseListOrders // NOI18N
              + ", MDNames=" + MDNames; // NOI18N
  }
}
