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
package org.llvm.support.impl;

import org.llvm.cl.aliases.optBool;
import org.llvm.support.sys.sys;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import static org.clank.support.Unsigned.$greatereq_uint;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.cl.*;
import org.llvm.cl.ClGlobals.TokenizerCallback;
import static org.llvm.cl.ClGlobals.*;
import org.llvm.support.sys.ManagedStaticInfoImpl;


//<editor-fold defaultstate="collapsed" desc="static type CommandLineStatics">
@Converted(kind = Converted.Kind.MANUAL,
 NM="org.llvm.support.impl.CommandLineStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_Z27LLVMParseCommandLineOptions;_ZL10isGroupingPKN4llvm2cl6OptionE;_ZL11MaxOptWidth;_ZL11getValueStrRKN4llvm2cl6OptionENS_9StringRefE;_ZL11parseDoubleRN4llvm2cl6OptionENS_9StringRefERd;_ZL12GlobalParser;_ZL12PrintOptions;_ZL12isWhitespacec;_ZL12printHelpStrN4llvm9StringRefEjj;_ZL13ProvideOptionPN4llvm2cl6OptionENS_9StringRefES3_iPKPKcRi;_ZL13RequiresValuePKN4llvm2cl6OptionE;_ZL13getOptionPredN4llvm9StringRefERjPFbPKNS_2cl6OptionEERKNS_9StringMapIPS3_NS_15MallocAllocatorEEE;_ZL14OptNameComparePKSt4pairIPKcPN4llvm2cl6OptionEES8_;_ZL14SubNameComparePKSt4pairIPKcPN4llvm2cl10SubCommandEES8_;_ZL14parseBackslashN4llvm9StringRefEjRNS_11SmallStringILj128EEE;_ZL15GenericCategory;_ZL15PrintAllOptions;_ZL15sortSubCommandsRKN4llvm15SmallPtrSetImplIPNS_2cl10SubCommandEEERNS_15SmallVectorImplISt4pairIPKcS3_EEE;_ZL18ExpandResponseFilePKcRN4llvm11StringSaverEPFvNS1_9StringRefES3_RNS1_15SmallVectorImplIS0_EEbES7_b;_ZL19LookupNearestOptionN4llvm9StringRefERKNS_9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZL20ExtraVersionPrinters;_ZL20WrappedHiddenPrinter;_ZL20WrappedNormalPrinter;_ZL20hasUTF8ByteOrderMarkN4llvm8ArrayRefIcEE;_ZL20isPrefixedOrGroupingPKN4llvm2cl6OptionE;_ZL22OverrideVersionPrinter;_ZL22VersionPrinterInstance;_ZL23ProvidePositionalOptionPN4llvm2cl6OptionENS_9StringRefEi;_ZL24CategorizedHiddenPrinter;_ZL24CategorizedNormalPrinter;_ZL26UncategorizedHiddenPrinter;_ZL26UncategorizedNormalPrinter;_ZL27EatsUnboundedNumberOfValuesPKN4llvm2cl6OptionE;_ZL29CommaSeparateAndAddOccurrencePN4llvm2cl6OptionEjNS_9StringRefES3_b;_ZL29HandlePrefixedOrGroupedOptionRN4llvm9StringRefES1_RbRKNS_9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEE;_ZL3HOp;_ZL4HHOp;_ZL4HLOp;_ZL5HLHOp;_ZL6VersOp;_ZL7isQuotec;_ZL8sortOptsRN4llvm9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEERNS_15SmallVectorImplISt4pairIPKcS3_EEEb; -static-type=CommandLineStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class CommandLineStatics {


//===----------------------------------------------------------------------===//

// namespace
//<editor-fold defaultstate="collapsed" desc="GlobalParser">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 336,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 213,
 FQN="GlobalParser", NM="_ZL12GlobalParser",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL12GlobalParser")
//</editor-fold>
public static final ManagedStatic<CommandLineParser> GlobalParser/*J*/= new ManagedStatic<CommandLineParser>(new ManagedStaticInfoImpl<CommandLineParser>(){
  @Override
  protected CommandLineParser create() {
    return new CommandLineParser();
  }
});
public static final boolean USE_NEW_CL_PARSER = false;

private static final String PREMAIN = "<premain>";

// Globals for name and overview of program.  Program name is not a string to
// avoid static ctor/dtor issues.
//<editor-fold defaultstate="collapsed" desc="ProgramName">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 88,
 FQN = "ProgramName", NM = "_ZL11ProgramName",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=ProgramName")
//</editor-fold>
public static final/*char*/char$ptr ProgramName/*[80]*/;
static {
  byte array[] = new$char(80);
  //copy$Object(PREMAIN.toCharArray(), 0, array, 0, PREMAIN.length());
  for (int i = 0; i < PREMAIN.length(); i++) {
    array[i] = (byte) PREMAIN.charAt(i);
  }
  array[PREMAIN.length()] = '\0';
  ProgramName = create_char$ptr(array);
}

//<editor-fold defaultstate="collapsed" desc="ProgramOverview">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 89,
 FQN = "ProgramOverview", NM = "_ZL15ProgramOverview",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=ProgramOverview")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ProgramOverview = null;

// This collects additional help to be printed.
//<editor-fold defaultstate="collapsed" desc="MoreHelp">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 92,
 FQN = "MoreHelp", NM = "_ZL8MoreHelp",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=MoreHelp")
//</editor-fold>
public static final ManagedStatic<vectorCharPtr> MoreHelp/*J*/= new ManagedStatic<vectorCharPtr>(sys.StaticStdVectorCharPtr);
//<editor-fold defaultstate="collapsed" desc="OptionListChanged">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 98,
 FQN = "OptionListChanged", NM = "_ZL17OptionListChanged",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=OptionListChanged")
//</editor-fold>
public static boolean OptionListChanged = false;

@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 98,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=MarkOptionsChanged",
 notes = Converted.Notes.FAILED)
public static void MarkOptionsChanged() {
  OptionListChanged = true;
}
/// RegisteredOptionList - This is the list of the command line options that
/// have statically constructed themselves.
//<editor-fold defaultstate="collapsed" desc="RegisteredOptionList">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 105,
 FQN = "RegisteredOptionList", NM = "_ZL20RegisteredOptionList",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=RegisteredOptionList")
//</editor-fold>
public static Option /*P*/ RegisteredOptionList = null;

private static final ManagedStaticInfo</*OptionCatSet*/SmallPtrSet<OptionCategory/*P*/> > StaticOptionCatSet = new ManagedStaticInfoImpl<SmallPtrSet<OptionCategory>>() {

  @Override
  protected SmallPtrSet<OptionCategory> create() {
    return new SmallPtrSet<>(DenseMapInfo$LikePtr.$Info(), 16);
  }
};
//<editor-fold defaultstate="collapsed" desc="RegisteredOptionCategories">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 130,
 FQN = "RegisteredOptionCategories", NM = "_ZL26RegisteredOptionCategories",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=RegisteredOptionCategories")
//</editor-fold>
public static final ManagedStatic</*OptionCatSet*/SmallPtrSet<OptionCategory/*P*/> > RegisteredOptionCategories/*J*/= new ManagedStatic</*OptionCatSet*/SmallPtrSet<OptionCategory/*P*/> >(StaticOptionCatSet);


/// CommaSeparateAndAddOccurrence - A wrapper around Handler->addOccurrence()
/// that does special handling of cl::CommaSeparated options.
//<editor-fold defaultstate="collapsed" desc="CommaSeparateAndAddOccurrence">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 493,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 325,
 FQN="CommaSeparateAndAddOccurrence", NM="_ZL29CommaSeparateAndAddOccurrencePN4llvm2cl6OptionEjNS_9StringRefES3_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL29CommaSeparateAndAddOccurrencePN4llvm2cl6OptionEjNS_9StringRefES3_b")
//</editor-fold>
public static boolean CommaSeparateAndAddOccurrence(Option /*P*/ Handler, /*uint*/int pos, 
                             StringRef ArgName, StringRef Value) {
  return CommaSeparateAndAddOccurrence(Handler, pos, 
                             ArgName, Value, 
                             false);
}
public static boolean CommaSeparateAndAddOccurrence(Option /*P*/ Handler, /*uint*/int pos, 
                             StringRef ArgName, StringRef Value, 
                             boolean MultiArg/*= false*/) {
  // Check to see if this option accepts a comma separated list of values.  If
  // it does, we have to split up the value into multiple values.
  if (((Handler.getMiscFlags() & MiscFlags.CommaSeparated) != 0)) {
    StringRef Val/*J*/= new StringRef(Value);
    /*size_t*/int Pos = Val.find($$COMMA);
    while (Pos != StringRef.npos) {
      // Process the portion before the comma.
      if (Handler.addOccurrence(pos, ArgName, Val.substr(0, Pos), MultiArg)) {
        return true;
      }
      // Erase the portion before the comma, AND the comma.
      Val.$assign$substr(Pos + 1);
      Value.substr(Pos + 1); // Increment the original value pointer as well.
      // Check for another comma.
      Pos = Val.find($$COMMA);
    }
    
    Value.$assign(Val);
  }
  
  return Handler.addOccurrence(pos, new StringRef(ArgName), new StringRef(Value), MultiArg);
}


/// ProvideOption - For Value, this differentiates between an empty value ("")
/// and a null value (StringRef()).  The later is accepted for arguments that
/// don't allow a value (-foo) the former is rejected (-foo=).
//<editor-fold defaultstate="collapsed" desc="ProvideOption">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 522,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 354,
 FQN="ProvideOption", NM="_ZL13ProvideOptionPN4llvm2cl6OptionENS_9StringRefES3_iPKPKcRi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL13ProvideOptionPN4llvm2cl6OptionENS_9StringRefES3_iPKPKcRi")
//</editor-fold>
public static /*inline*/ boolean ProvideOption(Option /*P*/ Handler, StringRef ArgName, 
             StringRef Value, int argc, 
             /*const*/type$ptr<char$ptr>/*char P const P*/ argv, final int$ref/*int &*/ i) {
  // Is this a multi-argument option?
  /*uint*/int NumAdditionalVals = Handler.getNumAdditionalVals();
  
  // Enforce value requirements
  switch (Handler.getValueExpectedFlag()) {
   case ValueRequired:
    if (Value.data() == null) { // No value specified?
      if (i.$deref() + 1 >= argc) {
        return Handler.error(new Twine("requires a value!"));
      }
      // Steal the next argument, like for '-o filename'
      Value.$assign(new StringRef(argv.$at(i.$set(i.$deref()+1))));
    }
    break;
   case ValueDisallowed:
    if (NumAdditionalVals > 0) {
      return Handler.error(new Twine("multi-valued option specified with ValueDisallowed modifier!"));
    }
    if ((Value.data() != null)) {
      return Handler.error($add_Twine($add_Twine(new Twine("does not allow a value! '"), 
                  new Twine(Value)), new Twine("' specified.")));
    }
    break;
   case ValueOptional:
    break;
  }
  
  // If this isn't a multi-arg option, just run the handler.
  if (NumAdditionalVals == 0) {
    return CommaSeparateAndAddOccurrence(Handler, i.$deref(), ArgName, Value);
  }
  
  // If it is, run the handle several times.
  boolean MultiArg = false;
  if ((Value.data() != null)) {
    if (CommaSeparateAndAddOccurrence(Handler, i.$deref(), ArgName, Value, MultiArg)) {
      return true;
    }
    --NumAdditionalVals;
    MultiArg = true;
  }
  while (NumAdditionalVals > 0) {
    if (i.$deref() + 1 >= argc) {
      return Handler.error(new Twine("not enough values!"));
    }
    Value.$assign(new StringRef(argv.$at(i.$set(i.$deref()+1))));
    if (CommaSeparateAndAddOccurrence(Handler, i.$deref(), ArgName, Value, MultiArg)) {
      return true;
    }
    MultiArg = true;
    --NumAdditionalVals;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="ProvidePositionalOption">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 580,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 412,
 FQN="ProvidePositionalOption", NM="_ZL23ProvidePositionalOptionPN4llvm2cl6OptionENS_9StringRefEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL23ProvidePositionalOptionPN4llvm2cl6OptionENS_9StringRefEi")
//</editor-fold>
public static boolean ProvidePositionalOption(Option /*P*/ Handler, StringRef Arg, int i) {
  int$ref Dummy = create_int$ref((int)i);
  return ProvideOption(Handler, new StringRef(Handler.ArgStr), Arg, 0, null, Dummy);
}


// Option predicates...
//<editor-fold defaultstate="collapsed" desc="isGrouping">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 586,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 418,
 FQN="isGrouping", NM="_ZL10isGroupingPKN4llvm2cl6OptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL10isGroupingPKN4llvm2cl6OptionE")
//</editor-fold>
public static /*inline*/ boolean isGrouping(/*const*/ Option /*P*/ O) {
  return O.getFormattingFlag() == FormattingFlags.Grouping;
}

private static final BoolPredicate<Option/*P*/> isGroupingCallback = new BoolPredicate<Option>() {

  @Override
  public boolean $call(Option param) {
    return isGrouping(param);
  }
};

//<editor-fold defaultstate="collapsed" desc="isPrefixedOrGrouping">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 589,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 421,
 FQN="isPrefixedOrGrouping", NM="_ZL20isPrefixedOrGroupingPKN4llvm2cl6OptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL20isPrefixedOrGroupingPKN4llvm2cl6OptionE")
//</editor-fold>
public static /*inline*/ boolean isPrefixedOrGrouping(/*const*/ Option /*P*/ O) {
  return isGrouping(O) || O.getFormattingFlag() == FormattingFlags.Prefix;
}

private static final BoolPredicate<Option/*P*/> isPrefixedOrGroupingCallback = new BoolPredicate<Option>() {

  @Override
  public boolean $call(Option param) {
    return isPrefixedOrGrouping(param);
  }
};

// getOptionPred - Check to see if there are any options that satisfy the
// specified predicate with names that are the prefixes in Name.  This is
// checked by progressively stripping characters off of the name, checking to
// see if there options that satisfy the predicate.  If we find one, return it,
// otherwise return null.
//
//<editor-fold defaultstate="collapsed" desc="getOptionPred">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 599,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 431,
 FQN="getOptionPred", NM="_ZL13getOptionPredN4llvm9StringRefERjPFbPKNS_2cl6OptionEERKNS_9StringMapIPS3_NS_15MallocAllocatorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL13getOptionPredN4llvm9StringRefERjPFbPKNS_2cl6OptionEERKNS_9StringMapIPS3_NS_15MallocAllocatorEEE")
//</editor-fold>
public static Option /*P*/ getOptionPred(StringRef Name, int$ref/*size_t*//*&*/ Length,
             BoolPredicate<Option/*P*/> Pred, 
             /*const*/StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ OptionsMap) {
  
  StringMapIterator<Option /*P*/ > OMI = $tryClone(OptionsMap.find(Name));
  
  // Loop while we haven't found an option and Name still has at least two
  // characters in it (so that the next iteration will not be the empty
  // string.
  while (OMI.$eq(OptionsMap.end()) && Name.size() > 1) {
    Name.$assign$substr(0, Name.size() - 1); // Chop off the last character.
    OMI.$assign(OptionsMap.find(Name));
  }
  if (OMI.$noteq(OptionsMap.end()) && Pred.$call(OMI.$arrow().second)) {
    Length.$set(Name.size());
    return OMI.$arrow().second; // Found one!
  }
  return null; // No option found!
}


/// HandlePrefixedOrGroupedOption - The specified argument string (which started
/// with at least one '-') does not fully match an available option.  Check to
/// see if this is a prefix or grouped option.  If so, split arg into output an
/// Arg/Value pair and return the Option to parse it with.
//<editor-fold defaultstate="collapsed" desc="HandlePrefixedOrGroupedOption">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 624,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 456,
 FQN="HandlePrefixedOrGroupedOption", NM="_ZL29HandlePrefixedOrGroupedOptionRN4llvm9StringRefES1_RbRKNS_9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL29HandlePrefixedOrGroupedOptionRN4llvm9StringRefES1_RbRKNS_9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEE")
//</editor-fold>
public static Option /*P*/ HandlePrefixedOrGroupedOption(final StringRef /*&*/ Arg, final StringRef /*&*/ Value, 
                             final bool$ref/*bool &*/ ErrorParsing, 
                             final /*const*/StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ OptionsMap) {
  if (Arg.size() == 1) {
    return null;
  }
  
  // Do the lookup!
  int$ref/*size_t*/ $Length = create_int$ref(0);
  Option /*P*/ PGOpt = getOptionPred(Arg, $Length, isPrefixedOrGroupingCallback, OptionsMap);
  /*size_t*/int Length = $Length.$deref();
  if (PGOpt == null) {
    return null;
  }
  
  // If the option is a prefixed option, then the value is simply the
  // rest of the name...  so fall through to later processing, by
  // setting up the argument name flags and value fields.
  if (PGOpt.getFormattingFlag() == FormattingFlags.Prefix) {
    Value.$assign(Arg.substr(Length));
    Arg.$assign$substr(0, Length);
    assert ((OptionsMap.count(Arg) != 0) && OptionsMap.find(Arg).$arrow().second == PGOpt);
    return PGOpt;
  }
  
  // This must be a grouped option... handle them now.  Grouping options can't
  // have values.
  assert (isGrouping(PGOpt)) : "Broken getOptionPred!";
  
  do {
    // Move current arg name out of Arg into OneArgName.
    StringRef OneArgName = Arg.substr(0, Length);
    Arg.$assign$substr(Length);
    
    // Because ValueRequired is an invalid flag for grouped arguments,
    // we don't need to pass argc/argv in.
    assert (PGOpt.getValueExpectedFlag() != ValueExpected.ValueRequired) : "Option can not be cl::Grouping AND cl::ValueRequired!";
    int$ref Dummy = create_int$ref(0);
    boolean _ErrorParsing = ErrorParsing.$deref();
    _ErrorParsing |= ProvideOption(PGOpt, OneArgName, 
        new StringRef(), 0, null, Dummy);
    ErrorParsing.$set(ErrorParsing.$deref() | _ErrorParsing);
    
    // Get the next grouping option.
    $Length.$set(Length);
    PGOpt = getOptionPred(Arg, $Length, isGroupingCallback, OptionsMap);
    Length = $Length.$deref();
  } while ((PGOpt != null) && Length != Arg.size());
  
  // Return the last option with Arg cut down to just the last one.
  return PGOpt;
}

//<editor-fold defaultstate="collapsed" desc="RequiresValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 672,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 504,
 FQN="RequiresValue", NM="_ZL13RequiresValuePKN4llvm2cl6OptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL13RequiresValuePKN4llvm2cl6OptionE")
//</editor-fold>
public static boolean RequiresValue(/*const*/ Option /*P*/ O) {
  return O.getNumOccurrencesFlag() == NumOccurrencesFlag.Required
     || O.getNumOccurrencesFlag() == NumOccurrencesFlag.OneOrMore;
}

//<editor-fold defaultstate="collapsed" desc="EatsUnboundedNumberOfValues">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 677,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 509,
 FQN="EatsUnboundedNumberOfValues", NM="_ZL27EatsUnboundedNumberOfValuesPKN4llvm2cl6OptionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL27EatsUnboundedNumberOfValuesPKN4llvm2cl6OptionE")
//</editor-fold>
public static boolean EatsUnboundedNumberOfValues(/*const*/ Option /*P*/ O) {
  return O.getNumOccurrencesFlag() == NumOccurrencesFlag.ZeroOrMore
     || O.getNumOccurrencesFlag() == NumOccurrencesFlag.OneOrMore;
}

//<editor-fold defaultstate="collapsed" desc="isWhitespace">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 682,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 514,
 FQN="isWhitespace", NM="_ZL12isWhitespacec",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL12isWhitespacec")
//</editor-fold>
public static boolean isWhitespace(/*char*/byte C) {
  return (strchr(" \t\n\015\014\013", C) != null);
}

//<editor-fold defaultstate="collapsed" desc="isQuote">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 684,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 516,
 FQN="isQuote", NM="_ZL7isQuotec",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL7isQuotec")
//</editor-fold>
public static boolean isQuote(/*char*/byte C) {
  return C == $$DBL_QUOTE || C == $$SGL_QUOTE;
}

//<editor-fold defaultstate="collapsed" desc="isGNUSpecial">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 518,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 480,
 FQN = "isGNUSpecial", NM = "_ZL12isGNUSpecialc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL12isGNUSpecialc")
//</editor-fold>
public static boolean isGNUSpecial(/*char*/byte C) {
  return (strchr("\\\"' ", C) != null);
}


/// Backslashes are interpreted in a rather complicated way in the Windows-style
/// command line, because backslashes are used both to separate path and to
/// escape double quote. This method consumes runs of backslashes as well as the
/// following double quote if it's escaped.
///
///  * If an even number of backslashes is followed by a double quote, one
///    backslash is output for every pair of backslashes, and the last double
///    quote remains unconsumed. The double quote will later be interpreted as
///    the start or end of a quoted string in the main loop outside of this
///    function.
///
///  * If an odd number of backslashes is followed by a double quote, one
///    backslash is output for every pair of backslashes, and a double quote is
///    output for the last pair of backslash-double quote. The double quote is
///    consumed in this case.
///
///  * Otherwise, backslashes are interpreted literally.
//<editor-fold defaultstate="collapsed" desc="parseBackslash">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 762,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 597,
 FQN="parseBackslash", NM="_ZL14parseBackslashN4llvm9StringRefEjRNS_11SmallStringILj128EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL14parseBackslashN4llvm9StringRefEjRNS_11SmallStringILj128EEE")
//</editor-fold>
public static /*size_t*/int parseBackslash(StringRef Src, /*size_t*/int I, final SmallString/*128*/ /*&*/ Token) {
  /*size_t*/int E = Src.size();
  int BackslashCount = 0;
  // Skip the backslashes.
  do {
    ++I;
    ++BackslashCount;
  } while (I != E && Src.$at(I) == $$BACK_SLASH);
  
  boolean FollowedByDoubleQuote = (I != E && Src.$at(I) == $$DBL_QUOTE);
  if (FollowedByDoubleQuote) {
    Token.append(BackslashCount / 2, $$BACK_SLASH);
    if (BackslashCount % 2 == 0) {
      return I - 1;
    }
    Token.push_back($$DBL_QUOTE);
    return I;
  }
  Token.append(BackslashCount, $$BACK_SLASH);
  return I - 1;
}


// It is called byte order marker but the UTF-8 BOM is actually not affected
// by the host system's endianness.
//<editor-fold defaultstate="collapsed" desc="hasUTF8ByteOrderMark">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 863,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 698,
 FQN="hasUTF8ByteOrderMark", NM="_ZL20hasUTF8ByteOrderMarkN4llvm8ArrayRefIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL20hasUTF8ByteOrderMarkN4llvm8ArrayRefIcEE")
//</editor-fold>
public static boolean hasUTF8ByteOrderMark(ArrayRefChar S) {
  return ($greatereq_uint(S.size(), 3) && S.$at(0) == $$0xEF && S.$at(1) == $$0xBB && S.$at(2) == $$0xBF);
}

//<editor-fold defaultstate="collapsed" desc="ExpandResponseFile">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 867,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 702,
 FQN="ExpandResponseFile", NM="_ZL18ExpandResponseFilePKcRN4llvm11StringSaverEPFvNS1_9StringRefES3_RNS1_15SmallVectorImplIS0_EEbES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL18ExpandResponseFilePKcRN4llvm11StringSaverEPFvNS1_9StringRefES3_RNS1_15SmallVectorImplIS0_EEbES7_b")
//</editor-fold>
public static boolean ExpandResponseFile(/*const*/char$ptr/*char P*/ FName, final StringSaver /*&*/ Saver, 
                  TokenizerCallback Tokenizer, 
                  final SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ NewArgv) {
  return ExpandResponseFile(FName, Saver, 
                  Tokenizer, 
                  NewArgv, 
                  false);
}
public static boolean ExpandResponseFile(/*const*/char$ptr/*char P*/ FName, StringSaver /*&*/ Saver, 
                  TokenizerCallback Tokenizer, 
                  SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ NewArgv, 
                  boolean MarkEOLs/*= false*/) {
  std.string UTF8Buf = null;
  try {
    ErrorOr<std.unique_ptr<MemoryBuffer> > MemBufOrErr = MemoryBuffer.getFile(new Twine(FName));
    if (!MemBufOrErr.$bool()) {
      return false;
    }
    MemoryBuffer /*&*/ MemBuf = MemBufOrErr.get().$star();
    StringRef Str/*J*/= new StringRef(MemBuf.getBufferStart(), MemBuf.getBufferSize());
    
    // If we have a UTF-16 byte order mark, convert to UTF-8 for parsing.
    ArrayRefChar BufRef/*J*/= new ArrayRefChar(MemBuf.getBufferStart(), MemBuf.getBufferEnd());
    UTF8Buf/*J*/= new std.string();
    if (hasUTF16ByteOrderMark(new ArrayRefChar(BufRef))) {
      if (!convertUTF16ToUTF8String(new ArrayRefChar(BufRef), UTF8Buf)) {
        return false;
      }
      Str.$assign(new StringRef(UTF8Buf));
    }
    
    // Tokenize the contents into NewArgv.
    Tokenizer.$call(new StringRef(Str), Saver, NewArgv, MarkEOLs);
    
    return true;
  } finally {
    if (UTF8Buf != null) { UTF8Buf.$destroy(); }
  }
}

/// GetOptionInfo - Scan the list of registered options, turning them into data
/// structures that are easier to handle.
//<editor-fold defaultstate="collapsed" desc="GetOptionInfo">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 152,
 FQN = "GetOptionInfo", NM = "_ZL13GetOptionInfoRN4llvm15SmallVectorImplIPNS_2cl6OptionEEES5_RNS_9StringMapIS3_NS_15MallocAllocatorEEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL13GetOptionInfoRN4llvm15SmallVectorImplIPNS_2cl6OptionEEES5_RNS_9StringMapIS3_NS_15MallocAllocatorEEE")
//</editor-fold>
public static void GetOptionInfo(SmallVectorImpl<Option /*P*/ > /*&*/ PositionalOpts, 
             SmallVectorImpl<Option /*P*/ > /*&*/ SinkOpts, 
             StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ OptionsMap) {
  SmallVector</*const*/StringRef/*char P*//*,16*/> OptionNames = null;
  try {
    boolean HadErrors = false;
    OptionNames/*J*/= new SmallVector</*const*/StringRef/*char P*//*,16*/>(16, new StringRef());
    Option /*P*/ CAOpt = null; // The ConsumeAfter option if it exists.
    for (Option /*P*/ O = RegisteredOptionList; (O != null); O = O.getNextRegisteredOption()) {
      // If this option wants to handle multiple option names, get the full set.
      // This handles enum options like "-O1 -O2" etc.
      O.getExtraOptionNames(OptionNames);
      if (O.hasArgStr()) {
        OptionNames.push_back(O.ArgStr);
      }
      
      // Handle named options.
      for (/*size_t*/int i = 0, e = OptionNames.size(); i != e; ++i) {
        // Add argument to the argument map!
        if (!OptionsMap.insert(std.make_pair(new StringRef(OptionNames.$at(i)), O)).second) {
          errs().$out(ProgramName).$out($(": CommandLine Error: Option '")).$out(OptionNames.$at(i)).$out($("' registered more than once!\n"));
          HadErrors = true;
        }
      }
      
      OptionNames.clear();
      
      // Remember information about positional options.
      if (O.getFormattingFlag() == FormattingFlags.Positional) {
        PositionalOpts.push_back(O);
      } else if (((O.getMiscFlags() & MiscFlags.Sink) != 0)) {
        // Remember sink options
        SinkOpts.push_back(O);
      } else if (O.getNumOccurrencesFlag() == NumOccurrencesFlag.ConsumeAfter) {
        if ((CAOpt != null)) {
          O.error(new Twine($("Cannot specify more than one option with cl::ConsumeAfter!")));
          HadErrors = true;
        }
        CAOpt = O;
      }
    }
    if ((CAOpt != null)) {
      PositionalOpts.push_back(CAOpt);
    }
    
    // Make sure that they are in order of registration not backwards.
    std.reverse(PositionalOpts.begin(), PositionalOpts.end());
    
    // Fail hard if there were errors. These are strictly unrecoverable and
    // indicate serious issues such as conflicting option names or an incorrectly
    // linked LLVM distribution.
    if (HadErrors) {
      report_fatal_error($("inconsistency in registered CommandLine options"));
    }
  } finally {
    if (OptionNames != null) { OptionNames.$destroy(); }
  }
}


/// LookupOption - Lookup the option specified by the specified option on the
/// command line.  If there is a value specified (after an equal sign) return
/// that as well.  This assumes that leading dashes have already been stripped.
//<editor-fold defaultstate="collapsed" desc="LookupOption">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 207,
 FQN = "LookupOption", NM = "_ZL12LookupOptionRN4llvm9StringRefES1_RKNS_9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=LookupOption")
//</editor-fold>
public static Option /*P*/ LookupOption(StringRef /*&*/ Arg, StringRef /*&*/ Value, 
            /*const*/StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ OptionsMap) {
  // Reject all dashes.
  if (Arg.empty()) {
    return null;
  }
  
  /*size_t*/int EqualPos = Arg.find($('='));
  
  // If we have an equals sign, remember the value.
  if (EqualPos == StringRef.npos) {
    // Look up the option.
    StringMapIterator<Option /*P*/ > I = $tryClone(OptionsMap.find(Arg));
    return I.$noteq(OptionsMap.end()) ? I.$arrow().second : null;
  }
  
  // If the argument before the = is a valid option name, we match.  If not,
  // return Arg unmolested.
  StringMapIterator<Option /*P*/ > I = $tryClone(OptionsMap.find(Arg.substr(0, EqualPos)));
  if (I.$eq(OptionsMap.end())) {
    return null;
  }
  
  Value.$assign(Arg.substr(EqualPos + 1));
  Arg.$assign$substr(0, (int)EqualPos);
  return I.$arrow().second;
}


/// LookupNearestOption - Lookup the closest match to the option specified by
/// the specified option on the command line.  If there is a value specified
/// (after an equal sign) return that as well.  This assumes that leading dashes
/// have already been stripped.
//<editor-fold defaultstate="collapsed" desc="LookupNearestOption">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 280,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 238,
 FQN = "LookupNearestOption", NM = "_ZL19LookupNearestOptionN4llvm9StringRefERKNS_9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEERSs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL19LookupNearestOptionN4llvm9StringRefERKNS_9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEERSs")
//</editor-fold>
public static Option /*P*/ LookupNearestOption(StringRef Arg, 
                   /*const*/StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ OptionsMap, 
                   std.string/*&*/ NearestString) {
  // Reject all dashes.
  if (Arg.empty()) {
    return null;
  }
  
  // Split on any equal sign.
  std.pair<StringRef, StringRef> SplitArg = Arg.split('=');
  StringRef /*&*/ LHS = SplitArg.first; // LHS == Arg when no '=' is present.
  StringRef /*&*/ RHS = SplitArg.second;
  
  // Find the closest match.
  Option /*P*/ Best = null;
  /*uint*/int BestDistance = 0;
  for (StringMapIterator<Option /*P*/ > it = $tryClone(OptionsMap.begin()), 
      ie = $tryClone(OptionsMap.end()); it.$noteq(ie); it.$preInc()) {
    SmallVector</*const*/StringRef/*char P*//*,16*/> OptionNames = null;
    try {
      Option /*P*/ O = it.$arrow().second;
      OptionNames/*J*/= new SmallVector</*const*/StringRef/*char P*//*,16*/>(16, new StringRef());
      O.getExtraOptionNames(OptionNames);
      if (O.hasArgStr()) {
        OptionNames.push_back(O.ArgStr);
      }
      
      boolean PermitValue = O.getValueExpectedFlag() != ValueExpected.ValueDisallowed;
      StringRef Flag = PermitValue ? LHS : Arg;
      for (/*size_t*/int i = 0, e = OptionNames.size(); i != e; ++i) {
        StringRef Name = new StringRef(OptionNames.$at(i));
        /*uint*/int Distance = new StringRef(Name).edit_distance(Flag, true, BestDistance);
        if (!(Best != null) || Distance < BestDistance) {
          Best = O;
          BestDistance = Distance;
          if (RHS.empty() || !PermitValue) {
            NearestString.$assignMove(Name.$string());
          } else {
            NearestString.$assignMove(($add_Twine$C($add_Twine$C(new Twine(Name), new Twine(/*KEEP_STR*/$EQ)), new Twine(RHS))).str());
          }
        }
      }
    } finally {
      if (OptionNames != null) { OptionNames.$destroy(); }
    }
  }
  
  return Best;
}
// getValueStr - Get the value description string, using "DefaultMsg" if nothing
// has been specified yet.
//
//<editor-fold defaultstate="collapsed" desc="getValueStr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1370,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1143,
 FQN="getValueStr", NM="_ZL11getValueStrRKN4llvm2cl6OptionENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL11getValueStrRKN4llvm2cl6OptionENS_9StringRefE")
//</editor-fold>
public static StringRef getValueStr(final /*const*/ Option /*&*/ O, StringRef DefaultMsg) {
  if (O.ValueStr.empty()) {
    return DefaultMsg;
  }
  return new StringRef(O.ValueStr);
}

//<editor-fold defaultstate="collapsed" desc="printHelpStr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1383,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1156,
 FQN="printHelpStr", NM="_ZL12printHelpStrN4llvm9StringRefEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL12printHelpStrN4llvm9StringRefEjj")
//</editor-fold>
public static void printHelpStr(StringRef HelpStr, /*size_t*/int Indent, 
            /*size_t*/int FirstLineIndentedBy) {
  std.pairTypeType<StringRef, StringRef> Split = HelpStr.split($$LF);
  outs().indent(Indent - FirstLineIndentedBy).$out(/*KEEP_STR*/" - ").$out(/*NO_COPY*/Split.first).$out(/*KEEP_STR*/$LF);
  while (!Split.second.empty()) {
    Split.$assignMove(Split.second.split($$LF));
    outs().indent(Indent).$out(/*NO_COPY*/Split.first).$out(/*KEEP_STR*/$LF);
  }
}


// parser<double>/parser<float> implementation
//
//<editor-fold defaultstate="collapsed" desc="parseDouble">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1502,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1275,
 FQN="parseDouble", NM="_ZL11parseDoubleRN4llvm2cl6OptionENS_9StringRefERd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL11parseDoubleRN4llvm2cl6OptionENS_9StringRefERd")
//</editor-fold>
public static boolean parseDouble(Option /*&*/ O, StringRef Arg, type$ref<Double>/*&*/ Value) {
  NativeTrace.traceNotImplemented("CommandLineStatics.parseDouble");
  SmallString TmpStr/*J*/= new SmallString(Arg.begin(), Arg.end(), 32);
  /*const*/char$ptr/*char P*/ ArgStart = $tryClone(TmpStr.c_str());
  char$ptr/*char P*/ End = create_char$ptr(new$char(0));
  Value.$set(strtod(ArgStart, End.$addr()));
  if (End.$star() != 0) {
    return O.error($add_Twine($add_T_StringRef("'", Arg), new Twine("' value invalid for floating point argument!")));
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="MaxOptWidth">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1582,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1355,
 FQN="MaxOptWidth", NM="_ZL11MaxOptWidth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL11MaxOptWidth")
//</editor-fold>
public static final/*const*//*size_t*/int MaxOptWidth = 8;

//===----------------------------------------------------------------------===//
// -help and -help-hidden option implementation
//
//<editor-fold defaultstate="collapsed" desc="OptNameCompare">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1670,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1443,
 FQN="OptNameCompare", NM="_ZL14OptNameComparePKSt4pairIPKcPN4llvm2cl6OptionEES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL14OptNameComparePKSt4pairIPKcPN4llvm2cl6OptionEES8_")
//</editor-fold>
public static int OptNameCompare(/*const*/std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ > /*P*/ LHS, 
              /*const*/std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ > /*P*/ RHS) {
  return strcmp(LHS.first, RHS.first);
}

//<editor-fold defaultstate="collapsed" desc="SubNameCompare">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1675,
 FQN="SubNameCompare", NM="_ZL14SubNameComparePKSt4pairIPKcPN4llvm2cl10SubCommandEES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL14SubNameComparePKSt4pairIPKcPN4llvm2cl10SubCommandEES8_")
//</editor-fold>
public static int SubNameCompare(/*const*/std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ > /*P*/ LHS, 
              /*const*/std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ > /*P*/ RHS) {
  return strcmp(LHS.first, RHS.first);
}


// Copy Options into a vector so we can sort them as we like.
//<editor-fold defaultstate="collapsed" desc="sortOpts">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1681,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1449,
 FQN="sortOpts", NM="_ZL8sortOptsRN4llvm9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEERNS_15SmallVectorImplISt4pairIPKcS3_EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL8sortOptsRN4llvm9StringMapIPNS_2cl6OptionENS_15MallocAllocatorEEERNS_15SmallVectorImplISt4pairIPKcS3_EEEb")
//</editor-fold>
public static void sortOpts(StringMap<Option /*P*//*, MallocAllocator*/>/*&*/ OptMap, 
        SmallVectorImpl<std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ > > /*&*/ Opts, 
        boolean ShowHidden) {
  SmallPtrSet<Option /*P*/> OptionSet = null;
  try {
    OptionSet/*J*/= new SmallPtrSet<Option /*P*/>(DenseMapInfo$LikePtr.$Info(), 128); // Duplicate option detection.
    
    for (StringMapIterator<Option /*P*/ > I = $tryClone(OptMap.begin()), E = $tryClone(OptMap.end());
         I.$noteq(E); I.$preInc()) {
      // Ignore really-hidden options.
      if (I.$arrow().second.getOptionHiddenFlag() == OptionHidden.ReallyHidden) {
        continue;
      }
      
      // Unless showhidden is set, ignore hidden flags.
      if (I.$arrow().second.getOptionHiddenFlag() == OptionHidden.Hidden && !ShowHidden) {
        continue;
      }
      
      // If we've already seen this option, don't add it to the list again.
      if (!OptionSet.insert(I.$arrow().second).second) {
        continue;
      }
      
      Opts.push_back(new std.pairTypePtr</*const*/char$ptr/*char P*/ , Option /*P*/ >(I.$arrow().getKey().data(), I.$arrow().second));
    }
    
    // Sort the options list alphabetically.
    qsort(Opts.data(), Opts.size(), /*sizeof (Opts.$at(0))*/-1, CommandLineStatics::OptNameCompare);
  } finally {
    if (OptionSet != null) { OptionSet.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="sortSubCommands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1708,
 FQN="sortSubCommands", NM="_ZL15sortSubCommandsRKN4llvm15SmallPtrSetImplIPNS_2cl10SubCommandEEERNS_15SmallVectorImplISt4pairIPKcS3_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL15sortSubCommandsRKN4llvm15SmallPtrSetImplIPNS_2cl10SubCommandEEERNS_15SmallVectorImplISt4pairIPKcS3_EEE")
//</editor-fold>
public static void sortSubCommands(final /*const*/ SmallPtrSetImpl<SubCommand /*P*/ > /*&*/ SubMap, 
               final SmallVectorImpl<std.pairTypePtr</*const*/char$ptr/*char P*/ , SubCommand /*P*/ > > /*&*/ Subs) {
  for (final SubCommand /*P*/ /*const*/ /*&*/ S : SubMap) {
    if ($eq_ptr(S.getName(), null)) {
      continue;
    }
    Subs.push_back(std.make_pair_T_Ptr(S.getName(), S));
  }
  array_pod_sort(Subs.begin(), Subs.end(), /*FuncRef*/CommandLineStatics::SubNameCompare);
}

// End anonymous namespace

// Declare the four HelpPrinter instances that are used to print out help, or
// help-hidden as an uncategorized list or in categories.
//<editor-fold defaultstate="collapsed" desc="UncategorizedNormalPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1930,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1643,
 FQN="UncategorizedNormalPrinter", NM="_ZL26UncategorizedNormalPrinter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL26UncategorizedNormalPrinter")
//</editor-fold>
public final static HelpPrinter UncategorizedNormalPrinter/*J*/= new HelpPrinter(false);
//<editor-fold defaultstate="collapsed" desc="UncategorizedHiddenPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1931,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1644,
 FQN="UncategorizedHiddenPrinter", NM="_ZL26UncategorizedHiddenPrinter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL26UncategorizedHiddenPrinter")
//</editor-fold>
public final static HelpPrinter UncategorizedHiddenPrinter/*J*/= new HelpPrinter(true);
//<editor-fold defaultstate="collapsed" desc="CategorizedNormalPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1932,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1645,
 FQN="CategorizedNormalPrinter", NM="_ZL24CategorizedNormalPrinter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL24CategorizedNormalPrinter")
//</editor-fold>
public final static CategorizedHelpPrinter CategorizedNormalPrinter/*J*/= new CategorizedHelpPrinter(false);
//<editor-fold defaultstate="collapsed" desc="CategorizedHiddenPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1933,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1646,
 FQN="CategorizedHiddenPrinter", NM="_ZL24CategorizedHiddenPrinter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL24CategorizedHiddenPrinter")
//</editor-fold>
public final static CategorizedHelpPrinter CategorizedHiddenPrinter/*J*/= new CategorizedHelpPrinter(true);

// Declare HelpPrinter wrappers that will decide whether or not to invoke
// a categorizing help printer
//<editor-fold defaultstate="collapsed" desc="WrappedNormalPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1937,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1650,
 FQN="WrappedNormalPrinter", NM="_ZL20WrappedNormalPrinter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL20WrappedNormalPrinter")
//</editor-fold>
public final static HelpPrinterWrapper WrappedNormalPrinter/*J*/= new HelpPrinterWrapper(UncategorizedNormalPrinter, 
        CategorizedNormalPrinter);
//<editor-fold defaultstate="collapsed" desc="WrappedHiddenPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1939,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1652,
 FQN="WrappedHiddenPrinter", NM="_ZL20WrappedHiddenPrinter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL20WrappedHiddenPrinter")
//</editor-fold>
public final static HelpPrinterWrapper WrappedHiddenPrinter/*J*/= new HelpPrinterWrapper(UncategorizedHiddenPrinter, 
        CategorizedHiddenPrinter);

// Define a category for generic options that all tools should have.
//<editor-fold defaultstate="collapsed" desc="GenericCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1943,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1656,
 FQN="GenericCategory", NM="_ZL15GenericCategory",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL15GenericCategory")
//</editor-fold>
public final static OptionCategory GenericCategory/*J*/= new OptionCategory($("Generic Options"));

// Define uncategorized help printers.
// -help-list is hidden by default because if Option categories are being used
// then -help behaves the same as -help-list.
//<editor-fold defaultstate="collapsed" desc="HLOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1948,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1661,
 FQN="HLOp", NM="_ZL4HLOp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL4HLOp")
//</editor-fold>
public static optBool HLOp/*J*/= new optBool/*<HelpPrinter>*/(opt.StorageKind.External/*ExternalStorage*/, new parserBoolean(), $("help-list"), 
    new desc($("Display list of available options (-help-list-hidden for more)")), 
    ClGlobals.location(UncategorizedNormalPrinter), OptionHidden.Hidden, ValueExpected.ValueDisallowed, 
    new cat(GenericCategory), new sub(AllSubCommands.$star()));

//<editor-fold defaultstate="collapsed" desc="HLHOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1954,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1667,
 FQN="HLHOp", NM="_ZL5HLHOp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL5HLHOp")
//</editor-fold>
public static optBool HLHOp/*J*/= new optBool/*<HelpPrinter>*/(opt.StorageKind.External/*ExternalStorage*/, new parserBoolean(), $("help-list-hidden"), 
    new desc($("Display list of all available options")), 
    ClGlobals.location(UncategorizedHiddenPrinter), OptionHidden.Hidden, 
    ValueExpected.ValueDisallowed, new cat(GenericCategory), 
    new sub(AllSubCommands.$star()));

//// Define uncategorized/categorized help printers. These printers change their
//// behaviour at runtime depending on whether one or more Option categories have
//// been declared.
////<editor-fold defaultstate="collapsed" desc="HOp">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1617,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=HOp")
////</editor-fold>
//public static opt<HelpPrinterWrapper, true, parser<boolean> > HOp/*J*/= new opt<HelpPrinterWrapper, true, parser<boolean> >("help", new desc("Display available options (-help-hidden for more)"), cl.location(WrappedNormalPrinter), cl.ValueExpected.ValueDisallowed);
////<editor-fold defaultstate="collapsed" desc="HHOp">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1621,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=HHOp")
////</editor-fold>
//public static opt<HelpPrinterWrapper, true, parser<boolean> > HHOp/*J*/= new opt<HelpPrinterWrapper, true, parser<boolean> >("help-hidden", new desc("Display all available options"), cl.location(WrappedHiddenPrinter), cl.OptionHidden.Hidden, cl.ValueExpected.ValueDisallowed);

//<editor-fold defaultstate="collapsed" desc="PrintOptions">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1685,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1680,
 FQN = "PrintOptions", NM = "_ZL12PrintOptions",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL12PrintOptions")
//</editor-fold>
public final static opt<Boolean> PrintOptions/*J*/= new optBool("print-options",
    new desc("Print non-default options after command line parsing"),
    OptionHidden.Hidden, init(false));

//<editor-fold defaultstate="collapsed" desc="PrintAllOptions">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1690,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1685,
 FQN = "PrintAllOptions", NM = "_ZL15PrintAllOptions",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL15PrintAllOptions")
//</editor-fold>
public final static opt<Boolean> PrintAllOptions/*J*/ = new optBool("print-all-options", new desc("Print all option values after command line parsing"), OptionHidden.Hidden, init(false));
//<editor-fold defaultstate="collapsed" desc="OverrideVersionPrinter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2020,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1731,
 FQN="OverrideVersionPrinter", NM="_ZL22OverrideVersionPrinter",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL22OverrideVersionPrinter")
//</editor-fold>
public static Void2Void OverrideVersionPrinter = null;
//<editor-fold defaultstate="collapsed" desc="ExtraVersionPrinters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2022,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1733,
 FQN="ExtraVersionPrinters", NM="_ZL20ExtraVersionPrinters",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL20ExtraVersionPrinters")
//</editor-fold>
public static std.vector<Void2Void> /*P*/ ExtraVersionPrinters = null;
// End anonymous namespace

// Define the --version option that prints out the LLVM version for the tool
//<editor-fold defaultstate="collapsed" desc="VersionPrinterInstance">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 2080,
 old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1790,
 FQN="VersionPrinterInstance", NM="_ZL22VersionPrinterInstance",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZL22VersionPrinterInstance")
//</editor-fold>
public static final VersionPrinter VersionPrinterInstance/*J*/= new VersionPrinter();
////<editor-fold defaultstate="collapsed" desc="VersOp">
//@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1737,
// cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=VersOp")
////</editor-fold>
//public static opt<VersionPrinter, true, parser<boolean> > VersOp/*J*/= new opt<VersionPrinter, true, parser<boolean> >("version", new desc("Display the version of this program"), cl.location(VersionPrinterInstance), cl.ValueExpected.ValueDisallowed);

public static void resetAllOptionsPre39() {
  // reset all registered options (pre 3.9)
  for (Option /*P*/ O = RegisteredOptionList; (O != null); O = O.getNextRegisteredOption()) {
    O.reset();
  }
}

public static void java$shutdown() {
  ClGlobals.ResetAllOptionOccurrences();
  ClGlobals.ResetCommandLineParser();  
  OverrideVersionPrinter = null;
  if (ExtraVersionPrinters != null) {
    ExtraVersionPrinters.clear();
    ExtraVersionPrinters = null;
  }
//  PrintAllOptions.reset();
  assert PrintAllOptions.$T() == false : "generated with initial false: " + PrintAllOptions.$T();
//  PrintOptions.reset();
  assert PrintOptions.$T() == false : "generated with initial false: " + PrintOptions.$T();
//  HLOp.reset();
  assert UncategorizedNormalPrinter.ShowHidden == false : "generated with initial false";
  assert HLOp.$T() == UncategorizedNormalPrinter.ShowHidden : "generated with initial " + UncategorizedNormalPrinter.$deref();
//  HLHOp.reset();
  assert UncategorizedHiddenPrinter.ShowHidden == true : "generated with initial true";
  assert HLHOp.$T() == UncategorizedHiddenPrinter.ShowHidden : "generated with initial " + UncategorizedHiddenPrinter.$deref();
  OptionListChanged = false;
  ProgramOverview = null;
}

} // END OF class CommandLineStatics
