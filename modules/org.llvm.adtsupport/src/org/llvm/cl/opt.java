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

import org.clank.support.*;
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;

/*template <class DataType, bool ExternalStorage = false, class ParserClass = parser<DataType>> TEMPLATE*/

//===----------------------------------------------------------------------===//
// opt - A scalar command line option.
//
//<editor-fold defaultstate="collapsed" desc="llvm::cl::opt">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1147,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt",
 notes = Converted.Notes.FAILED)
//</editor-fold>
public class opt</*class*/ DataType /*, class ParserClass = parser<DataType>*/>
  extends /*public*/ Option
  implements opt_storage<DataType>, Destructors.ClassWithDestructor {
  
  private final basic_parser<DataType> Parser;
  private final opt_storage<DataType> opt_storage_delegate;

  private final DataType DefaultValue;

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::handleOccurrence">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1154,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::handleOccurrence")
  //</editor-fold>
  @Override protected/*private*/ /*virtual*/ boolean handleOccurrence(/*uint*/int pos, StringRef ArgName,
                  StringRef Arg) {
    type$ref<DataType> Val =  create_type$ref($tryClone(DefaultValue));
    if (Parser.parse(/*Deref*/this, ArgName, Arg, Val)) {
      return true; // Parse error!
    }
    this.setValue(Val.$deref());
    this.setPosition(pos);
    return false;
  }

  @Override public/*private*/ /*virtual*/  boolean setLocation(type$ref L) /*const*/ {
    return setLocation(this, (type$ref<DataType>)L);
  }
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1066)
  @Override public/*private*/ /*virtual*/  boolean setLocation(Option O, type$ref<DataType> L) /*const*/ {
    assert  opt_storage_delegate instanceof opt_storage_impl_external : "must be initialized with opt.StorageKind.External";
    return opt_storage_delegate.setLocation(O, L);
  }
  
  @Override
  public void setValue(DataType V) {
    opt_storage_delegate.setValue(V);
  }

  @Override
  public void setValue(DataType V, boolean initial) {
    opt_storage_delegate.setValue(V, initial);
  }

  @Override
  public DataType getValue() {
    return opt_storage_delegate.getValue();
  }

  @Override
  public DataType $T() {
    return opt_storage_delegate.$T();
  }
  
  @Override
  public OptionValue<DataType> getDefault() {
    return opt_storage_delegate.getDefault();
  }
  //</editor-fold>
  

  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::getValueExpectedFlagDefault">
  //</editor-fold>
  /*private*/
  /*virtual*/
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1165,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::getValueExpectedFlagDefault")
  @Override
  protected /*private*/ /*virtual*/ ValueExpected getValueExpectedFlagDefault() /*const*/ {
    return Parser.getValueExpectedFlagDefault();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::getExtraOptionNames">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1168,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::getExtraOptionNames")
  //</editor-fold>
  @Override public/*private*/ /*virtual*/ void getExtraOptionNames(SmallVectorImpl<StringRef> /*&*/ OptionNames) {
    Parser.getExtraOptionNames(OptionNames);
  }


  // Forward printing stuff to the parser...
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::getOptionWidth">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1173,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::getOptionWidth")
  //</editor-fold>
  @Override public/*private*/ /*virtual*/ /*size_t*/int getOptionWidth() /*const*/ {
    return Parser.getOptionWidth(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::printOptionInfo">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1174,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::printOptionInfo",
   notes = Converted.Notes.FIXME)
  //</editor-fold>
  @Override public/*private*/ /*virtual*/ void printOptionInfo(/*size_t*/int GlobalWidth) /*const*/ {
    Parser.printOptionInfo(/*Deref*/this, GlobalWidth);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::printOptionValue">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1178,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::printOptionValue",
   notes = Converted.Notes.FIXME)
  //</editor-fold>
  @Override public/*private*/ /*virtual*/ void printOptionValue(/*size_t*/int GlobalWidth, boolean Force) /*const*/ {
    if (Force || this.getDefault().compare(this.getValue())) {
      //cl.printOptionDiff<ParserClass>(/*Deref*/this, Parser, this.getValue(), this.getDefault(), GlobalWidth);
      ClGlobals.printOptionDiff(this, Parser, getValue(), getDefault(), GlobalWidth);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::done">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1185,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::done")
  //</editor-fold>
  private void done() {
    addArgument();
    Parser.initialize(/*Deref*/this);
  }

/*public:*/
  // setInitialValue - Used by the cl::init modifier...
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::setInitialValue">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1191,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::setInitialValue")
  //</editor-fold>
  @Override public void setInitialValue(/*const*/ Object /*&*/ V) {
    this.setValue((DataType)V, true);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::getParser">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1193,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::getParser")
  //</editor-fold>
  public basic_parser<DataType> /*&*/ getParser() {
    return Parser;
  }


  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt::operator=">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1196,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt::operator=")
  //</editor-fold>
  public /*<class T>*/ DataType /*&*/ $assign(/*const T &*/ DataType Val) {
    this.setValue(Val);
    return this.getValue();
  }

  // options...
  /*template <class M0t, class M1t, class M2t> TEMPLATE  -- and other such constructors as well*/
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1217)
  public /*<class M0t, class M1t, class M2t>*/ opt(DataType DefaultValue, StorageKind ExternalStorage, basic_parser<DataType> Parser, Object... flags) {
    /* : Option(Optional, NotHidden)*/
    //START JInit
    super(NumOccurrencesFlag.Optional, OptionHidden.NotHidden);
    //END JInit
    this.Parser = Parser;
    this.DefaultValue = DefaultValue;
    if (ExternalStorage == StorageKind.External) {
      opt_storage_delegate = new opt_storage_impl_external<>();
    } else {
      opt_storage_delegate = new opt_storage_impl_internal<>(DefaultValue);
    }
    super.apply(this, flags);
    done();
  }

  @Override public void reset() {
    OptionValue<DataType> aDefault = opt_storage_delegate.getDefault();
    DataType def = this.DefaultValue;
    if (aDefault.hasValue()) {
      def = aDefault.getValue();
    }
    setValue(def);
    super.reset();
  }

  public enum StorageKind {
    External,
    Internal
  }
  
  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{ DefaultValue=" + DefaultValue + super.toString() + "\nParser=" + Parser + ", opt_storage_delegate=" + opt_storage_delegate + '}';
  }
}
