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
package org.llvm.cl;

import org.clank.java.std;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Unsigned.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.llvm.cl.ClGlobals.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.impl.CommandLineStatics;
import static org.llvm.support.impl.CommandLineStatics.GlobalParser;
import static org.llvm.support.impl.CommandLineStatics.MarkOptionsChanged;
import static org.llvm.support.impl.CommandLineStatics.ProgramName;
import static org.llvm.support.impl.CommandLineStatics.RegisteredOptionList;

//<editor-fold defaultstate="collapsed" desc="llvm::cl::Option">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 219,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 177,
 FQN="llvm::cl::Option", NM="_ZN4llvm2cl6OptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6OptionE")
//</editor-fold>
public abstract class Option implements Destructors.ClassWithDestructor {
  /*friend  class alias*/
  
  // handleOccurrences - Overriden by subclasses to handle the value passed into
  // an argument.  Should return true if there was an error processing the
  // argument and the program should exit.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::handleOccurrence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 184,
   FQN="llvm::cl::Option::handleOccurrence", NM="_ZN4llvm2cl6Option16handleOccurrenceEjNS_9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option16handleOccurrenceEjNS_9StringRefES2_")
  //</editor-fold>
  protected/*private*/ abstract /*virtual*/ boolean handleOccurrence(/*uint*/int pos, StringRef ArgName, 
                  StringRef Arg)/* = 0*/;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getValueExpectedFlagDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 229,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 187,
   FQN="llvm::cl::Option::getValueExpectedFlagDefault", NM="_ZNK4llvm2cl6Option27getValueExpectedFlagDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option27getValueExpectedFlagDefaultEv")
  //</editor-fold>
  protected/*private*/ /*virtual*/ ValueExpected getValueExpectedFlagDefault() /*const*/ {
    return ValueExpected.ValueOptional;
  }

  
  // Out of line virtual function to provide home for the class.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 72,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 71,
   FQN="llvm::cl::Option::anchor", NM="_ZN4llvm2cl6Option6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

  
  private int NumOccurrences; // The number of times specified
  // Occurrences, HiddenFlag, and Formatting are all enum types but to avoid
  // problems with signed enums in bitfields.
  private NumOccurrencesFlag Occurrences /*: 3*/; // enum NumOccurrencesFlag
  // not using the enum type for 'Value' because zero is an implementation
  // detail representing the non-value
  private ValueExpected Value /*: 2*/;
  private OptionHidden HiddenFlag /*: 2*/; // enum OptionHidden
  private FormattingFlags Formatting /*: 2*/; // enum FormattingFlags
  private /*JBYTE unsigned int*/ byte Misc /*: 3*/;
  private /*uint*/int Position; // Position of last occurrence of the option
  private /*uint*/int AdditionalVals; // Greater than 0 for multi-valued option.
/*public:*/
  public StringRef ArgStr; // The argument string itself (ex: "help", "o")
  public StringRef HelpStr; // The descriptive text message for -help
  public StringRef ValueStr; // String describing what the value of this option is
  public OptionCategory /*P*/ Category; // The Category this option belongs to
  public SmallPtrSet<SubCommand /*P*/ > Subs; // The subcommands this option belongs to.
  public boolean FullyInitialized; // Has addArguemnt been called?
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getNumOccurrencesFlag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 257,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 214,
   FQN="llvm::cl::Option::getNumOccurrencesFlag", NM="_ZNK4llvm2cl6Option21getNumOccurrencesFlagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option21getNumOccurrencesFlagEv")
  //</editor-fold>
  public /*inline*/  NumOccurrencesFlag getNumOccurrencesFlag() /*const*/ {
    return Occurrences;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getValueExpectedFlag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 260,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 217,
   FQN="llvm::cl::Option::getValueExpectedFlag", NM="_ZNK4llvm2cl6Option20getValueExpectedFlagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option20getValueExpectedFlagEv")
  //</editor-fold>
  public /*inline*/  ValueExpected getValueExpectedFlag() /*const*/ {
    return (Value != null) ? Value : getValueExpectedFlagDefault();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getOptionHiddenFlag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 263,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 220,
   FQN="llvm::cl::Option::getOptionHiddenFlag", NM="_ZNK4llvm2cl6Option19getOptionHiddenFlagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option19getOptionHiddenFlagEv")
  //</editor-fold>
  public /*inline*/  OptionHidden getOptionHiddenFlag() /*const*/ {
    return HiddenFlag;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getFormattingFlag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 266,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 223,
   FQN="llvm::cl::Option::getFormattingFlag", NM="_ZNK4llvm2cl6Option17getFormattingFlagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option17getFormattingFlagEv")
  //</editor-fold>
  public /*inline*/  FormattingFlags getFormattingFlag() /*const*/ {
    return Formatting;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getMiscFlags">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 269,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 226,
   FQN="llvm::cl::Option::getMiscFlags", NM="_ZNK4llvm2cl6Option12getMiscFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option12getMiscFlagsEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int getMiscFlags() /*const*/ {
    return Misc;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 270,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 227,
   FQN="llvm::cl::Option::getPosition", NM="_ZNK4llvm2cl6Option11getPositionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option11getPositionEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int getPosition() /*const*/ {
    return Position;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getNumAdditionalVals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 271,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 228,
   FQN="llvm::cl::Option::getNumAdditionalVals", NM="_ZNK4llvm2cl6Option20getNumAdditionalValsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option20getNumAdditionalValsEv")
  //</editor-fold>
  public /*inline*/ /*uint*/int getNumAdditionalVals() /*const*/ {
    return AdditionalVals;
  }

  
  // hasArgStr - Return true if the argstr != ""
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::hasArgStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 274,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 231,
   FQN="llvm::cl::Option::hasArgStr", NM="_ZNK4llvm2cl6Option9hasArgStrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option9hasArgStrEv")
  //</editor-fold>
  public boolean hasArgStr() /*const*/ {
    return !ArgStr.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::isPositional">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 275,
   FQN="llvm::cl::Option::isPositional", NM="_ZNK4llvm2cl6Option12isPositionalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option12isPositionalEv")
  //</editor-fold>
  public boolean isPositional() /*const*/ {
    return getFormattingFlag() == FormattingFlags.Positional;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::isSink">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 276,
   FQN="llvm::cl::Option::isSink", NM="_ZNK4llvm2cl6Option6isSinkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option6isSinkEv")
  //</editor-fold>
  public boolean isSink() /*const*/ {
    return ((getMiscFlags() & MiscFlags.Sink) != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::isConsumeAfter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 277,
   FQN="llvm::cl::Option::isConsumeAfter", NM="_ZNK4llvm2cl6Option14isConsumeAfterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option14isConsumeAfterEv")
  //</editor-fold>
  public boolean isConsumeAfter() /*const*/ {
    return getNumOccurrencesFlag() == NumOccurrencesFlag.ConsumeAfter;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::isInAllSubCommands">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 280,
   FQN="llvm::cl::Option::isInAllSubCommands", NM="_ZNK4llvm2cl6Option18isInAllSubCommandsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option18isInAllSubCommandsEv")
  //</editor-fold>
  public boolean isInAllSubCommands() /*const*/ {
    return std.any_of(Subs.begin(), Subs.end(), /*[]*/ (/*const*/ SubCommand /*P*/ SC) -> {
              return SC == $AddrOf(AllSubCommands.$star());
            });
  }

  
  //-------------------------------------------------------------------------===
  // Accessor functions set by OptionModifiers
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setArgStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 353,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 230,
   FQN="llvm::cl::Option::setArgStr", NM="_ZN4llvm2cl6Option9setArgStrENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option9setArgStrENS_9StringRefE")
  //</editor-fold>
  public void setArgStr(StringRef S) {
    if (FullyInitialized) {
      GlobalParser.$arrow().updateArgStr(this, new StringRef(S));
    }    
    ArgStr.$assign(S);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 290,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 237,
   FQN="llvm::cl::Option::setDescription", NM="_ZN4llvm2cl6Option14setDescriptionENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option14setDescriptionENS_9StringRefE")
  //</editor-fold>
  public void setDescription(StringRef S) {
    HelpStr.$assign(S);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setValueStr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 291,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 238,
   FQN="llvm::cl::Option::setValueStr", NM="_ZN4llvm2cl6Option11setValueStrENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option11setValueStrENS_9StringRefE")
  //</editor-fold>
  public void setValueStr(StringRef S) {
    ValueStr.$assign(S);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setNumOccurrencesFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 292,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 239,
   FQN="llvm::cl::Option::setNumOccurrencesFlag", NM="_ZN4llvm2cl6Option21setNumOccurrencesFlagENS0_18NumOccurrencesFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option21setNumOccurrencesFlagENS0_18NumOccurrencesFlagE")
  //</editor-fold>
  public void setNumOccurrencesFlag(NumOccurrencesFlag Val) {
    Occurrences = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setValueExpectedFlag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 293,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 240,
   FQN="llvm::cl::Option::setValueExpectedFlag", NM="_ZN4llvm2cl6Option20setValueExpectedFlagENS0_13ValueExpectedE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option20setValueExpectedFlagENS0_13ValueExpectedE")
  //</editor-fold>
  public void setValueExpectedFlag(ValueExpected Val) {
    Value = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setHiddenFlag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 294,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 241,
   FQN="llvm::cl::Option::setHiddenFlag", NM="_ZN4llvm2cl6Option13setHiddenFlagENS0_12OptionHiddenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option13setHiddenFlagENS0_12OptionHiddenE")
  //</editor-fold>
  public void setHiddenFlag(OptionHidden Val) {
    HiddenFlag = Val;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setFormattingFlag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 295,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 242,
   FQN="llvm::cl::Option::setFormattingFlag", NM="_ZN4llvm2cl6Option17setFormattingFlagENS0_15FormattingFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option17setFormattingFlagENS0_15FormattingFlagsE")
  //</editor-fold>
  public void setFormattingFlag(FormattingFlags V) {
    Formatting = V;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setMiscFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 296,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 243,
   FQN="llvm::cl::Option::setMiscFlag", NM="_ZN4llvm2cl6Option11setMiscFlagENS0_9MiscFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option11setMiscFlagENS0_9MiscFlagsE")
  //</editor-fold>
  public void setMiscFlag(/* MiscFlags*//*uint*/int M) {
    Misc |= $int2uint_3bits(M);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setPosition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 297,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 244,
   FQN="llvm::cl::Option::setPosition", NM="_ZN4llvm2cl6Option11setPositionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option11setPositionEj")
  //</editor-fold>
  public void setPosition(/*uint*/int pos) {
    Position = pos;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 298,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 245,
   FQN="llvm::cl::Option::setCategory", NM="_ZN4llvm2cl6Option11setCategoryERNS0_14OptionCategoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option11setCategoryERNS0_14OptionCategoryE")
  //</editor-fold>
  public void setCategory(final OptionCategory /*&*/ C) {
    Category = $AddrOf(C);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::addSubCommand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 299,
   FQN="llvm::cl::Option::addSubCommand", NM="_ZN4llvm2cl6Option13addSubCommandERNS0_10SubCommandE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option13addSubCommandERNS0_10SubCommandE")
  //</editor-fold>
  public void addSubCommand(final SubCommand /*&*/ S) {
    Subs.insert($AddrOf(S));
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::Option">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 302,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 248,
   FQN="llvm::cl::Option::Option", NM="_ZN4llvm2cl6OptionC1ENS0_18NumOccurrencesFlagENS0_12OptionHiddenE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6OptionC1ENS0_18NumOccurrencesFlagENS0_12OptionHiddenE")
  //</editor-fold>
  protected /*explicit*/ Option(NumOccurrencesFlag OccurrencesFlag, 
       OptionHidden Hidden) {
    // : NumOccurrences(0), Occurrences(OccurrencesFlag), Value(0), HiddenFlag(Hidden), Formatting(NormalFormatting), Misc(0), Position(0), AdditionalVals(0), ArgStr(""), HelpStr(""), ValueStr(""), Category(&GeneralCategory), Subs(), FullyInitialized(false) 
    //START JInit
    this.NumOccurrences = 0;
    this.Occurrences = OccurrencesFlag;
    this.Value = null;
    this.HiddenFlag = Hidden;
    this.Formatting = FormattingFlags.NormalFormatting;
    this.Misc = 0;
    this.Position = 0;
    this.AdditionalVals = 0;
    this.ArgStr = new StringRef(/*KEEP_STR*/$EMPTY);
    this.HelpStr = new StringRef(/*KEEP_STR*/$EMPTY);
    this.ValueStr = new StringRef(/*KEEP_STR*/$EMPTY);
    this.Category = $AddrOf(GeneralCategory);
    this.Subs = new SmallPtrSet<SubCommand /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.FullyInitialized = false;
    //END JInit
    // JAVA: from old days...
    this.NextRegistered = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::setNumAdditionalVals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 309,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 255,
   FQN="llvm::cl::Option::setNumAdditionalVals", NM="_ZN4llvm2cl6Option20setNumAdditionalValsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option20setNumAdditionalValsEj")
  //</editor-fold>
  protected /*inline*/ void setNumAdditionalVals(/*uint*/int n) {
    AdditionalVals = n;
  }

/*public:*/
  // addArgument - Register this argument with the commandline system.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::addArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 346,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 223,
   FQN="llvm::cl::Option::addArgument", NM="_ZN4llvm2cl6Option11addArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option11addArgumentEv")
  //</editor-fold>
  public void addArgument() {
    if (CommandLineStatics.USE_NEW_CL_PARSER) {
    // if we uncomment this lines, then GlobalParser initialized and old code 
    // will cause issues in tests
    GlobalParser.$arrow().addOption(this);
    FullyInitialized = true;      
    }
    // JAVA: from old days...
    assert (NextRegistered == null) : "argument multiply registered!";

    NextRegistered = RegisteredOptionList;
    RegisteredOptionList = this;
    MarkOptionsChanged();
  }
  
  
  /// Unregisters this option from the CommandLine system.
  ///
  /// This option must have been the last option registered.
  /// For testing purposes only.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::removeArgument">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*pre 3.9*/,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 351,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 228,
   FQN="llvm::cl::Option::removeArgument", NM="_ZN4llvm2cl6Option14removeArgumentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option14removeArgumentEv")
  //</editor-fold>
  public void removeArgument() {
    GlobalParser.$arrow().removeOption(this);
    // JAVA: RegisteredOptionList for now from old days
    Option Prev = null;
    for(Option O = RegisteredOptionList; O != null; O = O.NextRegistered) {
      if (O == this) {
        if (Prev != null) {
          Prev.NextRegistered = this.NextRegistered;
        } else {
          assert RegisteredOptionList == this;
          RegisteredOptionList = this.NextRegistered;
        }
        return;
      }
      Prev = O;
    }
  }
  
  
  // Return the width of the option tag for printing...
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getOptionWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 323,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 269,
   FQN="llvm::cl::Option::getOptionWidth", NM="_ZNK4llvm2cl6Option14getOptionWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option14getOptionWidthEv")
  //</editor-fold>
  public abstract /*virtual*/ /*size_t*/int getOptionWidth() /*const*//* = 0*/;

  
  // printOptionInfo - Print out information about this option.  The
  // to-be-maintained width is specified.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::printOptionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 328,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 274,
   FQN="llvm::cl::Option::printOptionInfo", NM="_ZNK4llvm2cl6Option15printOptionInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option15printOptionInfoEj")
  //</editor-fold>
  public abstract /*virtual*/ void printOptionInfo(/*size_t*/int GlobalWidth) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::printOptionValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 330,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 276,
   FQN="llvm::cl::Option::printOptionValue", NM="_ZNK4llvm2cl6Option16printOptionValueEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option16printOptionValueEjb")
  //</editor-fold>
  public abstract /*virtual*/ void printOptionValue(/*size_t*/int GlobalWidth, boolean Force) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getExtraOptionNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 332,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 278,
   FQN="llvm::cl::Option::getExtraOptionNames", NM="_ZN4llvm2cl6Option19getExtraOptionNamesERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option19getExtraOptionNamesERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  public /*virtual*/ void getExtraOptionNames(final SmallVectorImpl<StringRef> /*&*/ $Prm0) {
  }

  
  // addOccurrence - Wrapper around handleOccurrence that enforces Flags.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::addOccurrence">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1344,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1117,
   FQN="llvm::cl::Option::addOccurrence", NM="_ZN4llvm2cl6Option13addOccurrenceEjNS_9StringRefES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option13addOccurrenceEjNS_9StringRefES2_b")
  //</editor-fold>
  public boolean addOccurrence(/*uint*/int pos, StringRef ArgName, StringRef Value) {
    return addOccurrence(pos, ArgName, Value, 
               false);
  }
  public boolean addOccurrence(/*uint*/int pos, StringRef ArgName, StringRef Value, 
               boolean MultiArg/*= false*/) {
    if (!MultiArg) {
      NumOccurrences++; // Increment the number of times we have been seen
    }
    switch (getNumOccurrencesFlag()) {
     case Optional:
      if (NumOccurrences > 1) {
        return error(new Twine(/*KEEP_STR*/"may only occur zero or one times!"), new StringRef(ArgName));
      }
      break;
     case Required:
      if (NumOccurrences > 1) {
        return error(new Twine(/*KEEP_STR*/"must occur exactly one time!"), new StringRef(ArgName));
      }
     case OneOrMore:
     case ZeroOrMore:
     case ConsumeAfter:
      // Fall through
      break;
    }
    
    return handleOccurrence(pos, new StringRef(ArgName), new StringRef(Value));
  }

  
  // Prints option name followed by message.  Always returns true.
  
  //===----------------------------------------------------------------------===//
  // Option Base class implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::error">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1332,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1105,
   FQN="llvm::cl::Option::error", NM="_ZN4llvm2cl6Option5errorERKNS_5TwineENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option5errorERKNS_5TwineENS_9StringRefE")
  //</editor-fold>
  public boolean error(final /*const*/ Twine /*&*/ Message) {
    return error(Message, new StringRef());
  }
  public boolean error(final /*const*/ Twine /*&*/ Message, StringRef ArgName/*= StringRef()*/) {
    if (ArgName.data() == null) {
      ArgName.$assign(ArgStr);
    }
    if (ArgName.empty()) {
      errs().$out(/*NO_COPY*/HelpStr); // Be nice for positional arguments
    } else {
      errs().$out(/*GlobalParser.$arrow().*/ProgramName).$out(/*KEEP_STR*/": for the -").$out(/*NO_COPY*/ArgName);
    }
    
    $out_raw_ostream_Twine$C(errs().$out(/*KEEP_STR*/" option: "), Message).$out(/*KEEP_STR*/$LF);
    return true;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getNumOccurrences">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 343,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 289,
   FQN="llvm::cl::Option::getNumOccurrences", NM="_ZNK4llvm2cl6Option17getNumOccurrencesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl6Option17getNumOccurrencesEv")
  //</editor-fold>
  public /*inline*/ int getNumOccurrences() /*const*/ {
    return NumOccurrences;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 344,
   FQN="llvm::cl::Option::reset", NM="_ZN4llvm2cl6Option5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6Option5resetEv")
  //</editor-fold>
  public /*inline*/ void reset() {
    NumOccurrences = 0;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::~Option">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 345,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 290,
   FQN="llvm::cl::Option::~Option", NM="_ZN4llvm2cl6OptionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl6OptionD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    Subs.$destroy();
    //END JDestroy
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public Option(Option $Prm0) {
    this.NumOccurrences = $Prm0.NumOccurrences;
    this.Occurrences = $Prm0.Occurrences;
    this.Value = $Prm0.Value;
    this.HiddenFlag = $Prm0.HiddenFlag;
    this.Formatting = $Prm0.Formatting;
    this.Misc = $Prm0.Misc;
    this.Position = $Prm0.Position;
    this.AdditionalVals = $Prm0.AdditionalVals;
    this.NextRegistered = $Prm0.NextRegistered;
    this.ArgStr = new StringRef($Prm0.ArgStr);
    this.HelpStr = new StringRef($Prm0.HelpStr);
    this.ValueStr = new StringRef($Prm0.ValueStr);
    this.Category = $Prm0.Category;
    this.Subs = new SmallPtrSet<>($Prm0.Subs);
    this.FullyInitialized = $Prm0.FullyInitialized;
  }

  // JAVA: semantic from old versions
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::Option::getNextRegisteredOption">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*DELETED in 3.9*/, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 252,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::Option::getNextRegisteredOption")
  //</editor-fold>
  public Option /*P*/ getNextRegisteredOption() /*const*/ {
    return NextRegistered;
  }
  public Option /*P*/ NextRegistered; // Singly linked list of registered options.
  
  ///////////////////////////
  // Instead of applicator<...>::apply
  
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1034)
  protected final void apply(FormattingFlags FF) {
    this.setFormattingFlag(FF);
  }

  // Instead of applicator<MiscFlags>::apply
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1037)
  protected final void applyMiscFlags(int /*MiscFlags*/ MF) {
    this.setMiscFlag(MF);
  }

  // Instead of applicator<const char *>::apply
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1011,
   notes = Converted.Notes.FAILED)
  protected final void apply(String /*const char **/ Str) {
    this.setArgStr(new StringRef(Str));
  }

  // Instead of applicator<const char *>::apply
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1011,
   notes = Converted.Notes.FAILED)
  protected final void apply(char$ptr /*const char **/ Str) {
    this.setArgStr(new StringRef(Str));
  }

  // Instead of applicator<NumOccurrencesFlag>::apply
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1023)
  protected final void apply(NumOccurrencesFlag NO) {
    this.setNumOccurrencesFlag(NO);
  }

  // Instead of applicator<ValueExpected>::apply
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1028)
  protected final void apply(ValueExpected VE) {
    this.setValueExpectedFlag(VE);
  }  

  // Instead of applicator<OptionHidden>::apply
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1028)
  protected final void apply(OptionHidden Val) {
    this.setHiddenFlag(Val);
  }  

  public/*private*/ /*virtual*/  boolean setLocation(type$ref L) /*const*/ {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
  }

  public/*private*/ /*virtual*/  void setInitialValue(Object Val) /*const*/ {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
  }
  
  protected basic_parser getParser() {
    throw new UnsupportedOperationException("Why not implemented in " + this.getClass());
  }
  
  void apply(Option $this, Object... Ms) {
    assert $this == this;
    for (Object f : Ms) {      
      if (f instanceof FormattingFlags) {
        apply((FormattingFlags) f);
      } else if (f instanceof /*MiscFlags*/ Integer) { // the only int so far
        applyMiscFlags((/*MiscFlags*/ Integer) f);
      } else if (f instanceof String) {
        apply((String) f);
      } else if (f instanceof char$ptr) {
        apply((char$ptr) f);
      } else if (f instanceof NumOccurrencesFlag) {
        apply((NumOccurrencesFlag) f);
      } else if (f instanceof ValueExpected) {
        apply((ValueExpected) f);
      } else if (f instanceof OptionHidden) {
        apply((OptionHidden) f);
      } else if (f instanceof desc) {
        ((desc) f).apply(this);
      } else if (f instanceof value_desc) {
        ((value_desc) f).apply(this);
      } else if (f instanceof initializer) {
        ((initializer) f).apply(this);
      } else if (f instanceof LocationClass) {
        ((LocationClass) f).apply(this);
      } else if (f instanceof cat) {
        ((cat) f).apply(this);
      } else if (f instanceof aliasopt) {
        ((aliasopt) f).apply(this);
      } else if (f instanceof sub) {
        ((sub) f).apply(this);
      } else if (f instanceof ValuesClass) {
        ((ValuesClass) f).apply(this);
      } else {
        String text = "Unexpected class: opt.opt(" + f.getClass() + ":" + f +")";
        throw NativeTrace.registerReason(new IllegalArgumentException(text));
      }
    }
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "NumOccurrences=" + NumOccurrences // NOI18N
              + ", ArgStr=[" + ArgStr.toJavaString() // NOI18N
              + "], ValueStr=[" + ValueStr.toJavaString() // NOI18N
              + "], HelpStr=[" + HelpStr.toJavaString() // NOI18N
              + "], Occurrences=" + Occurrences // NOI18N
              + ", Value=" + Value // NOI18N
              + ", HiddenFlag=" + HiddenFlag // NOI18N
              + ", Formatting=" + Formatting // NOI18N
              + ", Misc=" + $uchar2uint(Misc) // NOI18N
              + ", Position=" + Position // NOI18N
              + ", AdditionalVals=" + AdditionalVals // NOI18N
              + ", Category=" + Category // NOI18N
              + ", Subs=" + Subs // NOI18N
              + ", FullyInitialized=" + FullyInitialized; // NOI18N
  }  
}
