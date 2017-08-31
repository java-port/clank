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

package org.llvm.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import org.llvm.cl.*;
import static org.llvm.support.impl.CommandLineStatics.*;
import org.clank.java.stdimpl.aliases.*;
import org.llvm.support.impl.*;
import org.llvm.support.sys.*;
import org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.adt.aliases.DenseMap;
import org.llvm.adt.aliases.DenseMapInfo$LikePtr;
import org.llvm.adt.aliases.DenseMapIterator;

// namespace detail

/// \brief Singleton class used to register debug options.
///
/// The OptionRegistry is responsible for managing lifetimes of the options and
/// provides interfaces for option registration and reading values from options.
/// This object is a singleton, only one instance should ever exist so that all
/// options are registered in the same place.
//<editor-fold defaultstate="collapsed" desc="llvm::OptionRegistry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Options.h", line = 65,
 FQN="llvm::OptionRegistry", NM="_ZN4llvm14OptionRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Options.cpp -nm=_ZN4llvm14OptionRegistryE")
//</editor-fold>
public class OptionRegistry implements Destructors.ClassWithDestructor {
/*private:*/
  private DenseMap</*const*/Object/*void P*/, Option /*P*/ > Options;
  
  /// \brief Adds a cl::Option to the registry.
  ///
  /// \param Key unique key for option
  /// \param O option to map to \p Key
  ///
  /// Allocated cl::Options are owned by the OptionRegistry and are deallocated
  /// on destruction or removal
  //<editor-fold defaultstate="collapsed" desc="llvm::OptionRegistry::addOption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Options.cpp", line = 25,
   FQN="llvm::OptionRegistry::addOption", NM="_ZN4llvm14OptionRegistry9addOptionEPvPNS_2cl6OptionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Options.cpp -nm=_ZN4llvm14OptionRegistry9addOptionEPvPNS_2cl6OptionE")
  //</editor-fold>
  private void addOption(Object/*void P*/ Key, Option /*P*/ O) {
    assert (Options.find(Key).$eq(/*NO_ITER_COPY*/Options.end())) : "Argument with this key already registerd";
    Options.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(Key, O));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OptionRegistry::~OptionRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Options.cpp", line = 20,
   FQN="llvm::OptionRegistry::~OptionRegistry", NM="_ZN4llvm14OptionRegistryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Options.cpp -nm=_ZN4llvm14OptionRegistryD0Ev")
  //</editor-fold>
  public void $destroy() {
    for (DenseMapIterator<Object/*void P*/ , Option /*P*/ > IT = Options.begin(); IT.$noteq(/*NO_ITER_COPY*/Options.end()); IT.$preInc())  {
      if (IT.$arrow().second != null) { IT.$arrow().second.$destroy();};
    }
    //START JDestroy
    Options.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::OptionRegistry::OptionRegistry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Options.h", line = 80,
   FQN="llvm::OptionRegistry::OptionRegistry", NM="_ZN4llvm14OptionRegistryC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Options.cpp -nm=_ZN4llvm14OptionRegistryC1Ev")
  //</editor-fold>
  public OptionRegistry() {
    // : Options() 
    //START JInit
    this.Options = new DenseMap</*const*/Object/*void P*/, Option /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Option /*P*/ )null);
    //END JInit
  }

  
  /// \brief Returns a reference to the singleton instance.
  //<editor-fold defaultstate="collapsed" desc="llvm::OptionRegistry::instance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Options.cpp", line = 33,
   FQN="llvm::OptionRegistry::instance", NM="_ZN4llvm14OptionRegistry8instanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Options.cpp -nm=_ZN4llvm14OptionRegistry8instanceEv")
  //</editor-fold>
  public static OptionRegistry /*&*/ instance() {
    return OptionsStatics.OR.$star();
  }

  
  /// \brief Registers an option with the OptionRegistry singleton.
  ///
  /// \tparam ValT type of the option's data
  /// \tparam Base class used to key the option
  /// \tparam Mem member of \p Base used for keying the option
  ///
  /// Options are keyed off the template parameters to generate unique static
  /// characters. The template parameters are (1) the type of the data the
  /// option stores (\p ValT), the class that will read the option (\p Base),
  /// and the member that the class will store the data into (\p Mem).
  /*template <typename ValT, typename Base, ValT (Base::*) Mem> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OptionRegistry::registerOption">
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Options.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/Options.h", old_line = 95,
   FQN="llvm::OptionRegistry::registerOption", NM="Tpl__ZN4llvm14OptionRegistry14registerOptionEPKcS2_RKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Options.cpp -nm=Tpl__ZN4llvm14OptionRegistry14registerOptionEPKcS2_RKT_")
  //</editor-fold>
  public static </*typename*/ ValT, /*typename*/ Base> void registerOption(byte ID, /*const*/char$ptr/*char P*/ ArgStr, /*const*/char$ptr/*char P*/ Desc,
                final /*const*/ ValT /*&*/ InitValue) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Returns the value of the option.
  ///
  /// \tparam ValT type of the option's data
  /// \tparam Base class used to key the option
  /// \tparam Mem member of \p Base used for keying the option
  ///
  /// Reads option values based on the key generated by the template parameters.
  /// Keying for get() is the same as keying for registerOption.
  /*template <typename ValT, typename Base, ValT (Base::*) Mem> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::OptionRegistry::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Options.h", line = 111,
   FQN="llvm::OptionRegistry::get", NM="Tpl__ZNK4llvm14OptionRegistry3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Options.cpp -nm=Tpl__ZNK4llvm14OptionRegistry3getEv")
  //</editor-fold>
  public </*typename*/ ValT, /*typename*/ Base> ValT get(byte ID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Options=" + Options; // NOI18N
  }
}
