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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.impl.CommandLineStatics.*;
import org.llvm.support.impl.*;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.SmallVectorImpl;
import org.llvm.support.llvm;


//===----------------------------------------------------------------------===//
// parser class - Parameterizable parser for different data types.  By default,
// known data types (string, int, bool) have specialized parsers, that do what
// you would expect.  The default parser, used for data types that are not
// built-in, uses a mapping table to map specific options to values, which is
// used, among other things, to handle enum types.

//--------------------------------------------------
// generic_parser_base - This class holds all the non-generic code that we do
// not need replicated for every instance of the generic parser.  This also
// allows us to put stuff into CommandLine.cpp
//
//<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 618,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 555,
 FQN="llvm::cl::generic_parser_base", NM="_ZN4llvm2cl19generic_parser_baseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_baseE")
//</editor-fold>
public abstract class generic_parser_base implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::GenericOptionInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 620,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 557,
   FQN="llvm::cl::generic_parser_base::GenericOptionInfo", NM="_ZN4llvm2cl19generic_parser_base17GenericOptionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_base17GenericOptionInfoE")
  //</editor-fold>
  protected static class GenericOptionInfo {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::GenericOptionInfo::GenericOptionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 622,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 559,
     FQN="llvm::cl::generic_parser_base::GenericOptionInfo::GenericOptionInfo", NM="_ZN4llvm2cl19generic_parser_base17GenericOptionInfoC1EPKcS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_base17GenericOptionInfoC1EPKcS4_")
    //</editor-fold>
    public GenericOptionInfo(/*const*/char$ptr/*char P*/ name, /*const*/char$ptr/*char P*/ helpStr) {
      // : Name(name), HelpStr(helpStr) 
      //START JInit
      this.Name = $tryClone(name);
      this.HelpStr = $tryClone(helpStr);
      //END JInit
    }

    public /*const*/char$ptr/*char P*/ Name;
    public /*const*/char$ptr/*char P*/ HelpStr;

    //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::GenericOptionInfo::GenericOptionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 620,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 557,
     FQN="llvm::cl::generic_parser_base::GenericOptionInfo::GenericOptionInfo", NM="_ZN4llvm2cl19generic_parser_base17GenericOptionInfoC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm2cl19generic_parser_base17GenericOptionInfoC1ERKS2_")
    //</editor-fold>
    public /*inline*/ GenericOptionInfo(final /*const*/ GenericOptionInfo /*&*/ $Prm0) {
      // : Name(.Name), HelpStr(.HelpStr) 
      //START JInit
      this.Name = $tryClone($Prm0.Name);
      this.HelpStr = $tryClone($Prm0.HelpStr);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::GenericOptionInfo::GenericOptionInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 620,
     old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 557,
     FQN="llvm::cl::generic_parser_base::GenericOptionInfo::GenericOptionInfo", NM="_ZN4llvm2cl19generic_parser_base17GenericOptionInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm2cl19generic_parser_base17GenericOptionInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ GenericOptionInfo(JD$Move _dparam, final GenericOptionInfo /*&&*/$Prm0) {
      // : Name(static_cast<GenericOptionInfo &&>().Name), HelpStr(static_cast<GenericOptionInfo &&>().HelpStr) 
      //START JInit
      this.Name = $tryClone($Prm0.Name);
      this.HelpStr = $tryClone($Prm0.HelpStr);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "Name=" + Name // NOI18N
                + ", HelpStr=" + HelpStr; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::generic_parser_base">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 629,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 566,
   FQN="llvm::cl::generic_parser_base::generic_parser_base", NM="_ZN4llvm2cl19generic_parser_baseC1ERNS0_6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_baseC1ERNS0_6OptionE")
  //</editor-fold>
  public generic_parser_base(final Option /*&*/ O) {
    // : Owner(O) 
    //START JInit
    this./*&*/Owner=/*&*/O;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::~generic_parser_base">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 631,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 568,
   FQN="llvm::cl::generic_parser_base::~generic_parser_base", NM="_ZN4llvm2cl19generic_parser_baseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_baseD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
  }
 // Base class should have virtual-dtor
  
  // getNumOptions - Virtual function implemented by generic subclass to
  // indicate how many entries are in Values.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::getNumOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 636,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 573,
   FQN="llvm::cl::generic_parser_base::getNumOptions", NM="_ZNK4llvm2cl19generic_parser_base13getNumOptionsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl19generic_parser_base13getNumOptionsEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getNumOptions() /*const*//* = 0*/;

  
  // getOption - Return option name N.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::getOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 639,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 576,
   FQN="llvm::cl::generic_parser_base::getOption", NM="_ZNK4llvm2cl19generic_parser_base9getOptionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl19generic_parser_base9getOptionEj")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/char$ptr/*char P*/ getOption(/*uint*/int N) /*const*//* = 0*/;

  
  // getDescription - Return description N
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::getDescription">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 642,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 579,
   FQN="llvm::cl::generic_parser_base::getDescription", NM="_ZNK4llvm2cl19generic_parser_base14getDescriptionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl19generic_parser_base14getDescriptionEj")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/char$ptr/*char P*/ getDescription(/*uint*/int N) /*const*//* = 0*/;

  
  // Return the width of the option tag for printing...
  
  // Return the width of the option tag for printing...
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::getOptionWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1543,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1316,
   FQN="llvm::cl::generic_parser_base::getOptionWidth", NM="_ZNK4llvm2cl19generic_parser_base14getOptionWidthERKNS0_6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl19generic_parser_base14getOptionWidthERKNS0_6OptionE")
  //</editor-fold>
  public /*size_t*/int getOptionWidth(final /*const*/ Option /*&*/ O) /*const*/ {
    if (O.hasArgStr()) {
      /*size_t*/int Size = O.ArgStr.size() + 6;
      for (/*uint*/int i = 0, e = getNumOptions(); i != e; ++i)  {
        Size = std.max(Size, std.strlen(getOption(i)) + 8);
      }
      return Size;
    } else {
      /*size_t*/int BaseSize = 0;
      for (/*uint*/int i = 0, e = getNumOptions(); i != e; ++i)  {
        BaseSize = std.max(BaseSize, std.strlen(getOption(i)) + 8);
      }
      return BaseSize;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::getOptionValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 647,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 584,
   FQN="llvm::cl::generic_parser_base::getOptionValue", NM="_ZNK4llvm2cl19generic_parser_base14getOptionValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl19generic_parser_base14getOptionValueEj")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/ GenericOptionValue /*&*/ getOptionValue(/*uint*/int N) /*const*//* = 0*/;

  
  // printOptionInfo - Print out information about this option.  The
  // to-be-maintained width is specified.
  //
  
  // printOptionInfo - Print out information about this option.  The
  // to-be-maintained width is specified.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::printOptionInfo">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1560,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1333,
   FQN="llvm::cl::generic_parser_base::printOptionInfo", NM="_ZNK4llvm2cl19generic_parser_base15printOptionInfoERKNS0_6OptionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl19generic_parser_base15printOptionInfoERKNS0_6OptionEj")
  //</editor-fold>
  public void printOptionInfo(final /*const*/ Option /*&*/ O, 
                 /*size_t*/int GlobalWidth) /*const*/ {
    if (O.hasArgStr()) {
      llvm.outs().$out(/*KEEP_STR*/"  -").$out(/*NO_COPY*/O.ArgStr);
      CommandLineStatics.printHelpStr(new StringRef(O.HelpStr), GlobalWidth, O.ArgStr.size() + 6);
      
      for (/*uint*/int i = 0, e = getNumOptions(); i != e; ++i) {
        /*size_t*/int NumSpaces = GlobalWidth - strlen(getOption(i)) - 8;
        llvm.outs().$out(/*KEEP_STR*/"    =").$out(getOption(i));
        llvm.outs().indent(NumSpaces).$out(/*KEEP_STR*/" -   ").$out(getDescription(i)).$out_char($$LF);
      }
    } else {
      if (!O.HelpStr.empty()) {
        llvm.outs().$out(/*KEEP_STR*/"  ").$out(/*NO_COPY*/O.HelpStr).$out_char($$LF);
      }
      for (/*uint*/int i = 0, e = getNumOptions(); i != e; ++i) {
        /*const*/char$ptr/*char P*/ Option = $tryClone(getOption(i));
        llvm.outs().$out(/*KEEP_STR*/"    -").$out(Option);
        CommandLineStatics.printHelpStr(new StringRef(getDescription(i)), GlobalWidth, std.strlen(Option) + 8);
      }
    }
  }

  
  // arbitrary spacing for printOptionDiff
  
  // printGenericOptionDiff - Print the value of this option and it's default.
  //
  // "Generic" options have each value mapped to a name.
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::printGenericOptionDiff">
  @Converted(kind = Converted.Kind.MANUAL,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1587,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1360,
   FQN="llvm::cl::generic_parser_base::printGenericOptionDiff", NM="_ZNK4llvm2cl19generic_parser_base22printGenericOptionDiffERKNS0_6OptionERKNS0_18GenericOptionValueES7_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl19generic_parser_base22printGenericOptionDiffERKNS0_6OptionERKNS0_18GenericOptionValueES7_j")
  //</editor-fold>
  public void printGenericOptionDiff(final /*const*/ Option /*&*/ O, final /*const*/ GenericOptionValue /*&*/ Value, 
                        final /*const*/ GenericOptionValue /*&*/ Default, /*size_t*/int GlobalWidth) /*const*/ {
    llvm.outs().$out(/*KEEP_STR*/"  -").$out(/*NO_COPY*/O.ArgStr);
    llvm.outs().indent(GlobalWidth - O.ArgStr.size());
    
    /*uint*/int NumOpts = getNumOptions();
    for (/*uint*/int i = 0; i != NumOpts; ++i) {
      if (Value.compare(getOptionValue(i))) {
        continue;
      }
      
      llvm.outs().$out(/*KEEP_STR*/"= ").$out(getOption(i));
      /*size_t*/int L = std.strlen(getOption(i));
      /*size_t*/int NumSpaces = $greater_uint(MaxOptWidth, L) ? MaxOptWidth - L : 0;
      llvm.outs().indent(NumSpaces).$out(/*KEEP_STR*/" (default: ");
      for (/*uint*/int j = 0; j != NumOpts; ++j) {
        if (Default.compare(getOptionValue(j))) {
          continue;
        }
        llvm.outs().$out(getOption(j));
        break;
      }
      llvm.outs().$out(/*KEEP_STR*/")\n");
      return;
    }
    llvm.outs().$out(/*KEEP_STR*/"= *unknown option value*\n");
  }

  
  // printOptionDiff - print the value of an option and it's default.
  //
  // Template definition ensures that the option and default have the same
  // DataType (via the same AnyOptionValue).
  /*template <class AnyOptionValue> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::printOptionDiff">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 663,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 599,
   FQN="llvm::cl::generic_parser_base::printOptionDiff", NM="Tpl__ZNK4llvm2cl19generic_parser_base15printOptionDiffERKNS0_6OptionERKT_S7_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZNK4llvm2cl19generic_parser_base15printOptionDiffERKNS0_6OptionERKT_S7_j")
  //</editor-fold>
  public </*class*/ AnyOptionValue extends GenericOptionValue> void printOptionDiff(final /*const*/ Option /*&*/ O, final /*const*/ AnyOptionValue /*&*/ V, 
                 final /*const*/ AnyOptionValue /*&*/ Default, 
                 /*size_t*/int GlobalWidth) /*const*/ {
    printGenericOptionDiff(O, V, Default, GlobalWidth);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::initialize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 669,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 606,
   FQN="llvm::cl::generic_parser_base::initialize", NM="_ZN4llvm2cl19generic_parser_base10initializeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_base10initializeEv")
  //</editor-fold>
  public void initialize(final Option /*&*/ $Prm0) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::getExtraOptionNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 671,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 608,
   FQN="llvm::cl::generic_parser_base::getExtraOptionNames", NM="_ZN4llvm2cl19generic_parser_base19getExtraOptionNamesERNS_15SmallVectorImplINS_9StringRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_base19getExtraOptionNamesERNS_15SmallVectorImplINS_9StringRefEEE")
  //</editor-fold>
  public void getExtraOptionNames(final SmallVectorImpl<StringRef> /*&*/ OptionNames) {
    // If there has been no argstr specified, that means that we need to add an
    // argument for every possible option.  This ensures that our options are
    // vectored to us.
    if (!Owner.hasArgStr()) {
      for (/*uint*/int i = 0, e = getNumOptions(); i != e; ++i)  {
        OptionNames.push_back(new StringRef(getOption(i)));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::getValueExpectedFlagDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 680,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 617,
   FQN="llvm::cl::generic_parser_base::getValueExpectedFlagDefault", NM="_ZNK4llvm2cl19generic_parser_base27getValueExpectedFlagDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl19generic_parser_base27getValueExpectedFlagDefaultEv")
  //</editor-fold>
  public ValueExpected getValueExpectedFlagDefault() /*const*/ {
    // If there is an ArgStr specified, then we are of the form:
    //
    //    -opt=O2   or   -opt O2  or  -optO2
    //
    // In which case, the value is required.  Otherwise if an arg str has not
    // been specified, we are of the form:
    //
    //    -O2 or O2 or -la (where -l and -a are separate options)
    //
    // If this is the case, we cannot allow a value.
    //
    if (Owner.hasArgStr()) {
      return ValueExpected.ValueRequired;
    } else {
      return ValueExpected.ValueDisallowed;
    }
  }

  
  // findOption - Return the option number corresponding to the specified
  // argument string.  If the option is not found, getNumOptions() is returned.
  //
  
  // generic_parser_base implementation
  //
  
  // findOption - Return the option number corresponding to the specified
  // argument string.  If the option is not found, getNumOptions() is returned.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::generic_parser_base::findOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", line = 1532,
   old_source = "${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp", old_line = 1305,
   FQN="llvm::cl::generic_parser_base::findOption", NM="_ZN4llvm2cl19generic_parser_base10findOptionEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZN4llvm2cl19generic_parser_base10findOptionEPKc")
  //</editor-fold>
  public /*uint*/int findOption(/*const*/char$ptr/*char P*/ Name) {
    /*uint*/int e = getNumOptions();
    
    for (/*uint*/int i = 0; i != e; ++i) {
      if (strcmp(getOption(i), Name) == 0) {
        return i;
      }
    }
    return e;
  }

/*protected:*/
  protected final Option /*&*/ Owner;
  
  @Override public String toString() {
    return "" + "Owner=" + Owner; // NOI18N
  }
}
